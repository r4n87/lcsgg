package dev.saariselka.inlol;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.saariselka.inlol.dto.MatchDto;
import dev.saariselka.inlol.dto.SummonerDto;
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
        SummonerDto summonerDto = getSummonerInfo(modelAndView, name, facade_get.getSummonerInfoFromDB(name));

        //Step 2. Get League Info and Set League Info At ModelAndView
        getLeagueInfo(modelAndView, summonerDto.getId(), facade_get.getLeagueInfoFromDB(summonerDto.getId()));

        //Step 3. Get Match Info List
        getMatchInfoList(modelAndView, summonerDto, facade_get.getMatchInfoFromDB(summonerDto.getPuuid()));

        return modelAndView;
    }

    // 소환사 검색 결과 새로고침
    @GetMapping("searchRefresh")
    public ModelAndView refresh(@RequestParam("name") String name) throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView("content/summoner");

        //Step 1. Get Summoner Info By Name via API
        SummonerDto summonerDto = getSummonerInfoFromAPI(modelAndView, name);

        //Step 2. Get League info by encryptedSummonerId via API
        getLeagueInfoFromAPI(modelAndView, summonerDto.getId());

        //Step 3. Get Match Info List by Name via API
        getMatchInfoFromAPI_Refresh(modelAndView, summonerDto);

        return modelAndView;
    }

    private SummonerDto getSummonerInfo(ModelAndView modelAndView, String name, SummonerDto summonerInfoFromDB) {
        if(null != summonerInfoFromDB) {
            setSummonerInfoAtModelAndView(modelAndView, summonerInfoFromDB, name);
            return summonerInfoFromDB;
        }

        return getSummonerInfoFromAPI(modelAndView, name);
    }

    private SummonerDto getSummonerInfoFromAPI(ModelAndView modelAndView, String name) {
        SummonerDto summonerDto = new SummonerDto();

        facade_set.setSummonerInfoAtDB((LinkedHashMap) facade_get.getSummonerInfo(name).get("body"));

        summonerDto = facade_get.getSummonerInfoFromDB(name);

        setSummonerInfoAtModelAndView(modelAndView, summonerDto, name);

        return summonerDto;
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

    private void getMatchInfoList(ModelAndView modelAndView, SummonerDto summonerDto, ArrayList<MatchDto> matchInfoList) throws JsonProcessingException {
        if(null != matchInfoList) {
            setMatchInfoListAtModelAndView(modelAndView, matchInfoList);
            return;
        }

        getMatchInfoFromAPI_Init(modelAndView, summonerDto);
    }

    private void getMatchInfoFromAPI_Init(ModelAndView modelAndView, SummonerDto summonerDto) throws JsonProcessingException {
        ArrayList<MatchDto> matchInfoList = new ArrayList<>();
        ArrayList<String> matchList = facade_get.getMatchList(summonerDto.getName());

        for (int i = 0; i < matchList.size(); i++) {
            HashMap<String, Object> result =  ((HashMap<String, Object>) facade_get.getMatchInfo(matchList, i).get("body"));
            facade_set.setMatchInfoAtDB(result);
        }

        matchInfoList = facade_get.getMatchInfoFromDB(summonerDto.getPuuid());

        setMatchInfoListAtModelAndView(modelAndView, matchInfoList);
    }

    private void getMatchInfoFromAPI_Refresh(ModelAndView modelAndView, SummonerDto summonerDto) throws JsonProcessingException {
        ArrayList<String> matchList = facade_get.getMatchList(summonerDto.getName());

        for (int i = 0; i < matchList.size(); i++) {
            facade_set.setMatchInfoAtDB(((HashMap<String, Object>) facade_get.getMatchInfo(matchList, i).get("body")));
        }

        setMatchInfoListAtModelAndView(modelAndView, facade_get.getMatchInfoFromDB(summonerDto.getPuuid()));
    }

    private void setMatchInfoListAtModelAndView(ModelAndView modelAndView, ArrayList<MatchDto> matchInfoList) {
        modelAndView.addObject("matchInfoList", matchInfoList);
    }

    private void setSummonerInfoAtModelAndView(ModelAndView modelAndView, SummonerDto summonerDto, String name) {
        modelAndView.addObject("summoner", summonerDto);
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
