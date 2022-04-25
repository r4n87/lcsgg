package dev.saariselka.inlol;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonObject;
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
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("content/summoner");
        HashMap<String, Object> result;

        //Step 1. Get Summoner Info By Name from DB
        LinkedHashMap<String, String> res = facade_get.getSummonerInfoFromDB(name);

        //Step 1.1 Get Summoner Info By Name via API
        if(null == res) {
            result = facade_get.getSummonerInfo(name);
            res = (LinkedHashMap) result.get("body");
            facade_set.setSummonerInfoAtDB(res);
        }

        String encryptedSummonerId = res.get("id");
        String puuid = res.get("puuid");

        //Step 1.2. Set summoner At ModelAndView
        modelAndView.addObject("summoner", res);
        modelAndView.addObject("summonerName", name);

        //Step 2. Get League info by encryptedSummonerId
        result = facade_get.getLeagueInfo(encryptedSummonerId);
        HashSet<Object> res2 = (HashSet<Object>) result.get("body");

        //Step 2.1. Set League Info At DB
        facade_set.setLeagueInfoAtDB(result);

        //Step 2.2. Set League Info At ModelAndView
        setLeagueInfoAtModelAndView(modelAndView, res2);

        //Step 3. Get Match Info List from DB
        ArrayList<HashMap<String,Object>> matchInfoList = facade_get.getMatchInfoFromDB(puuid);

        //Step 3.1 Get Match Info List via API
        if(null == matchInfoList) {
            matchInfoList = new ArrayList<>();
            ArrayList<String> matchList = facade_get.getMatchList(name);
            for (int i = 0; i < matchList.size(); i++) {
                result = facade_get.getMatchInfo(matchList, i);
                matchInfoList.add((HashMap<String, Object>) ((HashMap<String, Object>) result.get("body")).get("info"));
                facade_set.setMatchInfoAtDB(result);
            }
        }

        modelAndView.addObject("match1", matchInfoList.get(0).get("info"));

        return modelAndView;
    }

    private void setLeagueInfoAtModelAndView(ModelAndView modelAndView, HashSet<Object> res2) {
        Iterator<Object> iterator = res2.iterator();
        while(iterator.hasNext()) {
            HashMap<String, String> map = (HashMap) iterator.next();
            String tierInfo = map.get("tier");
            String tierImg = "/images/ranked-emblems/";
            switch(tierInfo) {
                case "IRON":
                    tierImg += "Emblem_Iron.png";
                    break;
                case "BRONZE":
                    tierImg += "Emblem_Bronze.png";
                    break;
                case "SILVER":
                    tierImg += "Emblem_Silver.png";
                    break;
                case "GOLD":
                    tierImg += "Emblem_Gold.png";
                    break;
                case "PLATINUM":
                    tierImg += "Emblem_Platinum.png";
                    break;
                case "DIAMOND":
                    tierImg += "Emblem_Diamond.png";
                    break;
                case "MASTER":
                    tierImg += "Emblem_Master.png";
                    break;
                case "GRANDMASTER":
                    tierImg += "Emblem_Grandmaster.png";
                    break;
                case "CHALLENGER":
                    tierImg += "Emblem_Challenger.png";
                    break;
                default:
                    tierImg = "";
            }

            String rankInfo = map.get("queueType").toString();

            if("RANKED_SOLO_5x5".equals(rankInfo)) {
                modelAndView.addObject("soloRankInfo", map);
                modelAndView.addObject("soloRankImg", tierImg);
            } else {
                modelAndView.addObject("flexRankInfo", map);
                modelAndView.addObject("flexRankImg", tierImg);
            }
        }
    }

    // 소환사 검색 결과 새로고침
    @GetMapping("searchRefresh")
    public void refresh() {

    }
}
