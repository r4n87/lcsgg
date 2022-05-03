package dev.saariselka.inlol;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
@NoArgsConstructor
@AllArgsConstructor
public class Facade {

    @Autowired
    private Facade_Get facade_get;
    @Autowired
    private Facade_Set facade_set;

    private String name;

    // 테스트를 위해 주석 처리
//    public Facade(String name)
//    {
//        this.name = name;
//    }


    // 소환사 검색 수행
    @GetMapping("searchInit")
    public ModelAndView search(@RequestParam("name") String name) throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView("content/summoner");

        //Step 1. Get Summoner Info and Set Summoner Info At ModelAndView
        LinkedHashMap<String, String> res = getSummonerInfo(modelAndView, name, facade_get.getSummonerInfoFromDB(name));

        //Step 2. Get League Info and Set League Info At ModelAndView
        getLeagueInfo(modelAndView, res.get("id"), facade_get.getLeagueInfoFromDB(res.get("id")));

        //Step 3. Get Match Info List
        getMatchInfoList(modelAndView, res.get("puuid"), facade_get.getMatchInfoFromDB(res.get("puuid")));

        return modelAndView;
    }

    // 소환사 검색 결과 새로고침
    @GetMapping("searchRefresh")
    public ModelAndView refresh(@RequestParam("name") String name) throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView("content/summoner");

        //Step 1. Get Summoner Info By Name via API
        LinkedHashMap<String, String> res = getSummonerInfoFromAPI(modelAndView, name);

        //Step 2. Get League info by encryptedSummonerId via API
        getLeagueInfoFromAPI(modelAndView, res.get("id"));

        //Step 3. Get Match Info List by Name via API
        getMatchInfoFromAPI_Refresh(modelAndView, name, res);

        return modelAndView;
    }

    private LinkedHashMap<String, String> getSummonerInfo(ModelAndView modelAndView, String name, LinkedHashMap<String, String> summonerInfoFromDB) {
        if(null != summonerInfoFromDB) {
            setSummonerInfoAtModelAndView(modelAndView, summonerInfoFromDB, name);
            return summonerInfoFromDB;
        }

        return getSummonerInfoFromAPI(modelAndView, name);
    }

    private LinkedHashMap<String, String> getSummonerInfoFromAPI(ModelAndView modelAndView, String name) {
        LinkedHashMap<String, String> summonerInfo = (LinkedHashMap) facade_get.getSummonerInfo(name).get("body");
        facade_set.setSummonerInfoAtDB(summonerInfo);
        setSummonerInfoAtModelAndView(modelAndView, summonerInfo, name);

        return summonerInfo;
    }

    private void getLeagueInfo(ModelAndView modelAndView, String encryptedSummonerId, HashSet<Object> leagueInfoFromDB) {
        if(null != leagueInfoFromDB) {
            setLeagueInfoAtModelAndView(modelAndView, leagueInfoFromDB);
            return;
        }

        getLeagueInfoFromAPI(modelAndView, encryptedSummonerId);
    }

    private void getLeagueInfoFromAPI(ModelAndView modelAndView, String encryptedSummonerId) {
        HashSet<Object> leagueInfo = (HashSet<Object>) facade_get.getLeagueInfo(encryptedSummonerId).get("body");
        facade_set.setLeagueInfoAtDB(leagueInfo);
        setLeagueInfoAtModelAndView(modelAndView, leagueInfo);
    }

    private void getMatchInfoList(ModelAndView modelAndView, String name, ArrayList<HashMap<String, Object>> matchInfoList) throws JsonProcessingException {
        if(null != matchInfoList) {
            setMatchInfoListAtModelAndView(modelAndView, matchInfoList);
            return;
        }

        getMatchInfoFromAPI_Init(modelAndView, name);
    }

    private void getMatchInfoFromAPI_Init(ModelAndView modelAndView, String name) throws JsonProcessingException {
        ArrayList<HashMap<String, Object>> matchInfoList = new ArrayList<>();
        ArrayList<String> matchList = facade_get.getMatchList(name);

        for (int i = 0; i < matchList.size(); i++) {
            HashMap<String, Object> result =  ((HashMap<String, Object>) facade_get.getMatchInfo(matchList, i).get("body"));
            matchInfoList.add((HashMap<String, Object>) result.get("info"));
            facade_set.setMatchInfoAtDB(result);
        }

        setMatchInfoListAtModelAndView(modelAndView, matchInfoList);
    }

    private void getMatchInfoFromAPI_Refresh(ModelAndView modelAndView, String name, LinkedHashMap<String, String> res) throws JsonProcessingException {
        ArrayList<String> matchList = facade_get.getMatchList(name);

        for (int i = 0; i < matchList.size(); i++) {
            facade_set.setMatchInfoAtDB(((HashMap<String, Object>) facade_get.getMatchInfo(matchList, i).get("body")));
        }

        setMatchInfoListAtModelAndView(modelAndView, facade_get.getMatchInfoFromDB(res.get("puuid")));
    }

    private void setMatchInfoListAtModelAndView(ModelAndView modelAndView, ArrayList<HashMap<String, Object>> matchInfoList) {
        modelAndView.addObject("matchInfoList", matchInfoList);
    }

    private void setSummonerInfoAtModelAndView(ModelAndView modelAndView, LinkedHashMap<String, String> res, String name) {
        modelAndView.addObject("summoner", res);
        modelAndView.addObject("summonerName", name);
    }

    private void setLeagueInfoAtModelAndView(ModelAndView modelAndView, HashSet<Object> res) {
        Iterator<Object> iterator = res.iterator();
        while(iterator.hasNext()) {
            HashMap<String, String> map = (HashMap) iterator.next();
            String tierInfo = map.get("tier");
            String tierImg = "";

            if(null != tierInfo && !"".equals(tierInfo)) {
                tierImg = "/images/ranked-emblems/" + tierInfo + ".png";
            }

            String rankInfo = map.get("queueType");

            if("RANKED_SOLO_5x5".equals(rankInfo)) {
                modelAndView.addObject("soloRankInfo", map);
                modelAndView.addObject("soloRankImg", tierImg);
            } else {
                modelAndView.addObject("flexRankInfo", map);
                modelAndView.addObject("flexRankImg", tierImg);
            }
        }
    }
}
