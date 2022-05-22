package dev.saariselka.inlol;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.saariselka.inlol.dto.LeagueEntryDto;
import dev.saariselka.inlol.dto.MatchDto;
import dev.saariselka.inlol.dto.SummonerDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
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
        long startTime = getRefreshTimeFromDB(name);

        //Step 1. Get Summoner Info By Name via API
        SummonerDto summonerDto = getSummonerInfoFromAPI(modelAndView, name);

        //Step 2. Get League info by encryptedSummonerId via API
        getLeagueInfoFromAPI(modelAndView, summonerDto.getId());

        //Step 3. Get Match Info List by Name via API
        getMatchInfoFromAPI_Refresh(modelAndView, summonerDto, startTime);

        return modelAndView;
    }

    private long getRefreshTimeFromDB(String name) {
        return facade_get.getSummonerInfoFromDB(name).getLastRefreshTime();
    }

    private SummonerDto getSummonerInfo(ModelAndView modelAndView, String name, SummonerDto summonerInfoFromDB) {
        if(null != summonerInfoFromDB) {
            setSummonerInfoAtModelAndView(modelAndView, summonerInfoFromDB, name);
            return summonerInfoFromDB;
        }

        return getSummonerInfoFromAPI(modelAndView, name);
    }

    private SummonerDto getSummonerInfoFromAPI(ModelAndView modelAndView, String name) {
        facade_set.setSummonerInfoAtDB((LinkedHashMap<String, String>) facade_get.getSummonerInfo(name).get("body"));

        SummonerDto summonerDto = facade_get.getSummonerInfoFromDB(name);

        setSummonerInfoAtModelAndView(modelAndView, summonerDto, name);

        return summonerDto;
    }

    private void getLeagueInfo(ModelAndView modelAndView, String encryptedSummonerId, List<LeagueEntryDto> leagueInfoFromDB) {
        if(null != leagueInfoFromDB && !leagueInfoFromDB.isEmpty()) {
            setLeagueInfoAtModelAndView(modelAndView, leagueInfoFromDB);
            return;
        }

        getLeagueInfoFromAPI(modelAndView, encryptedSummonerId);
    }

    private void getLeagueInfoFromAPI(ModelAndView modelAndView, String encryptedSummonerId) {
        HashSet<Object> leagueInfo = (HashSet<Object>) facade_get.getLeagueInfo(encryptedSummonerId).get("body");

        if(!leagueInfo.isEmpty()) {
            facade_set.setLeagueInfoAtDB(leagueInfo);
        }

        setLeagueInfoAtModelAndView(modelAndView, facade_get.getLeagueInfoFromDB(encryptedSummonerId));
    }

    private void getMatchInfoList(ModelAndView modelAndView, SummonerDto summonerDto, ArrayList<MatchDto> matchInfoList) throws JsonProcessingException {
        if(null != matchInfoList) {
            setMatchInfoListAtModelAndView(modelAndView, matchInfoList);
            return;
        }

        getMatchInfoFromAPI_Init(modelAndView, summonerDto);
    }

    private void getMatchInfoFromAPI_Init(ModelAndView modelAndView, SummonerDto summonerDto) throws JsonProcessingException {
        ArrayList<String> matchList = facade_get.getMatchList(summonerDto.getName(), 0L);

        for (int i = 0; i < matchList.size(); i++) {
            HashMap<String, Object> result =  ((HashMap<String, Object>) facade_get.getMatchInfo(matchList, i).get("body"));
            facade_set.setMatchInfoAtDB(result);
        }

        ArrayList<MatchDto> matchInfoList = facade_get.getMatchInfoFromDB(summonerDto.getPuuid());

        setMatchInfoListAtModelAndView(modelAndView, matchInfoList);
    }

    private void getMatchInfoFromAPI_Refresh(ModelAndView modelAndView, SummonerDto summonerDto, long startTime) throws JsonProcessingException {
        ArrayList<String> matchList = facade_get.getMatchList(summonerDto.getName(), startTime);
        HashSet<String> dbMatchList = facade_get.getMatchListFromDB(summonerDto.getPuuid());

        matchList.removeIf(dbMatchList::contains);

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

    private void setLeagueInfoAtModelAndView(ModelAndView modelAndView, List<LeagueEntryDto> leagueEntryDtoList) {
        for (LeagueEntryDto leagueEntryDto : leagueEntryDtoList) {
            String tierInfo = leagueEntryDto.getTier();
            String tierImg = "";

            if (null != tierInfo && !"".equals(tierInfo)) {
                tierImg = "/images/ranked-emblems/" + tierInfo + ".png";
            }

            String rankInfo = leagueEntryDto.getQueueType();

            if ("RANKED_SOLO_5x5".equals(rankInfo)) {
                modelAndView.addObject("soloRankInfo", leagueEntryDto);
                modelAndView.addObject("soloRankImg", tierImg);

                if(leagueEntryDto.getMiniSeries() != null)
                {
                    modelAndView.addObject("soloRankIsIncrement","true");

                    modelAndView.addObject("soloRankIncrementProgress",leagueEntryDto.getMiniSeries().getProgress());
                }
                else
                {
                    modelAndView.addObject("soloRankIsIncrement","false");
                }
            } else {
                modelAndView.addObject("flexRankInfo", leagueEntryDto);
                modelAndView.addObject("flexRankImg", tierImg);

                if(leagueEntryDto.getMiniSeries() != null)
                {
                    modelAndView.addObject("flexRankIsIncrement","true");

                    modelAndView.addObject("flexRankIncrementProgress",leagueEntryDto.getMiniSeries().getProgress());
                }
                else
                {
                    modelAndView.addObject("flexRankIsIncrement","false");
                }
            }


        }
    }
}
