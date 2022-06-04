package dev.saariselka.inlol.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.saariselka.inlol.dto.LeagueEntryDto;
import dev.saariselka.inlol.dto.MatchDto;
import dev.saariselka.inlol.dto.SummonerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@RestController
@RequiredArgsConstructor
// 작업 완료 후 클래스명 Facade로 변경 예정
public class Facade_refactoring {
    @Autowired
    private APIFacade apiFacade;
    @Autowired
    private DBFacade dbFacade;

    @GetMapping("searchInit")
    public ModelAndView search(@RequestParam("name") String name) throws IOException {
        ModelAndView modelAndView = new ModelAndView("content/summoner");

        //Step 1. Get Summoner Info and Set Summoner Info At ModelAndView
        SummonerDto summonerDto = getSummonerInfo(modelAndView, name, dbFacade.getSummonerDtoBySummonerName(name));

        //Step 2. Get League Info and Set League Info At ModelAndView
        getLeagueInfo(modelAndView, summonerDto.getId(), dbFacade.getLeagueEntryDtoListBySummonerId(summonerDto.getId()));

        //Step 3. Get Match Info List
        getMatchInfoList(modelAndView, summonerDto, dbFacade.getMatchDtoListBySummonerPuuid(summonerDto.getPuuid()));

        return modelAndView;
    }

    // 소환사 검색 결과 새로고침
    @GetMapping("searchRefresh")
    public ModelAndView refresh(@RequestParam("name") String name) throws IOException {
        ModelAndView modelAndView = new ModelAndView("content/summoner");
        long startTime = dbFacade.getSummonerDtoBySummonerName(name).getLastRefreshTime();

        //Step 1. Get Summoner Info By Name via API
        SummonerDto summonerDto = getSummonerInfoFromAPI(modelAndView, name);

        //Step 2. Get League info by encryptedSummonerId via API
        getLeagueInfoFromAPI(modelAndView, summonerDto.getId());

        //Step 3. Get Match Info List by Name via API
        getMatchInfoFromAPI_Refresh(modelAndView, summonerDto, startTime);

        return modelAndView;
    }

    // TODO : refactoring 대상 - modelandview와 분리
    private SummonerDto getSummonerInfo(ModelAndView modelAndView, String name, SummonerDto summonerInfoFromDB) {
        if(null != summonerInfoFromDB) {
            setSummonerInfoAtModelAndView(modelAndView, summonerInfoFromDB, name);
            return summonerInfoFromDB;
        }

        return getSummonerInfoFromAPI(modelAndView, name);
    }

    // TODO : refactoring 대상 - modelandview와 분리
    private SummonerDto getSummonerInfoFromAPI(ModelAndView modelAndView, String name) {
        dbFacade.setSummonerInfo((LinkedHashMap<String, String>) apiFacade.getSummonerInfoBySummonerName(name).get("body"));

        SummonerDto summonerDto = dbFacade.getSummonerDtoBySummonerName(name);

        setSummonerInfoAtModelAndView(modelAndView, summonerDto, name);

        return summonerDto;
    }

    // TODO : refactoring 대상 - modelandview와 분리
    private void getLeagueInfo(ModelAndView modelAndView, String encryptedSummonerId, List<LeagueEntryDto> leagueInfoFromDB) {
        if(null != leagueInfoFromDB && !leagueInfoFromDB.isEmpty()) {
            setLeagueInfoAtModelAndView(modelAndView, leagueInfoFromDB);
            return;
        }

        getLeagueInfoFromAPI(modelAndView, encryptedSummonerId);
    }

    // TODO : refactoring 대상 - modelandview와 분리
    private void getLeagueInfoFromAPI(ModelAndView modelAndView, String encryptedSummonerId) {
        HashSet<Object> leagueInfo = (HashSet<Object>) apiFacade.getLeagueInfoBySummonerId(encryptedSummonerId).get("body");

        if(!leagueInfo.isEmpty()) {
            dbFacade.setLeagueInfo(leagueInfo);
        }

        setLeagueInfoAtModelAndView(modelAndView, dbFacade.getLeagueEntryDtoListBySummonerId(encryptedSummonerId));
    }

    // TODO : refactoring 대상 - modelandview와 분리
    private void getMatchInfoList(ModelAndView modelAndView, SummonerDto summonerDto, ArrayList<MatchDto> matchInfoList) throws IOException {
        if(null != matchInfoList) {
            setMatchInfoListAtModelAndView(modelAndView, matchInfoList);
            return;
        }

        getMatchInfoFromAPI_Init(modelAndView, summonerDto);
    }

    // TODO : refactoring 대상 - modelandview와 분리
    private void getMatchInfoFromAPI_Init(ModelAndView modelAndView, SummonerDto summonerDto) throws IOException {
        ArrayList<String> matchList = apiFacade.getMatchIdListBySummonerPuuidAndMatchStartTime(summonerDto.getPuuid(), 0L);

        for (int i = 0; i < matchList.size(); i++) {
            HashMap<String, Object> result =  ((HashMap<String, Object>) apiFacade.getMatchInfoByMatchId(matchList, i).get("body"));
            dbFacade.setMatchInfo(result);
        }

        ArrayList<MatchDto> matchInfoList = dbFacade.getMatchDtoListBySummonerPuuid(summonerDto.getPuuid());

        setMatchInfoListAtModelAndView(modelAndView, matchInfoList);
    }

    // TODO : refactoring 대상 - modelandview와 분리
    private void getMatchInfoFromAPI_Refresh(ModelAndView modelAndView, SummonerDto summonerDto, long startTime) throws IOException {
        ArrayList<String> matchList = apiFacade.getMatchIdListBySummonerPuuidAndMatchStartTime(summonerDto.getPuuid(), startTime);
        HashSet<String> dbMatchList = dbFacade.getMatchIdListBySummonerPuuid(summonerDto.getPuuid());

        matchList.removeIf(dbMatchList::contains);

        for (int i = 0; i < matchList.size(); i++) {
            dbFacade.setMatchInfo(((HashMap<String, Object>) apiFacade.getMatchInfoByMatchId(matchList, i).get("body")));
        }

        setMatchInfoListAtModelAndView(modelAndView, dbFacade.getMatchDtoListBySummonerPuuid(summonerDto.getPuuid()));
    }

    // refactoring 후 new 버전
    @GetMapping("search")
    public ModelAndView searchSummoner(@RequestParam("name") String name) throws IOException {
        ModelAndView modelAndView = new ModelAndView("content/summoner");

        //Step 1. Check DB
        String puuid = dbFacade.getSummonerPuuidBySummonerName(name);
        if(puuid == null)
            return initSummoner(name);

        //Step 2. Get Summoner Dto and Set Summoner Info At ModelAndView
        SummonerDto summonerDto = dbFacade.getSummonerDtoBySummonerPuuid(puuid);
        setSummonerInfoAtModelAndView(modelAndView, summonerDto, name);

        //Step 3. Get League Dto and Set League Info At ModelAndView
        setLeagueInfoAtModelAndView(modelAndView, dbFacade.getLeagueEntryListDtoBySummonerId(summonerDto.getId()));

        //Step 4. Get Match Info List
        setMatchInfoListAtModelAndView(modelAndView, dbFacade.getMatchDtoListBySummonerPuuid(puuid));

        return modelAndView;
    }

    @GetMapping("init")
    public ModelAndView initSummoner(@RequestParam("name") String name) throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView("content/summoner");

        //Step 1. initial Summoner
        dbFacade.setSummonerInfo((LinkedHashMap<String, String>) apiFacade.getSummonerInfoBySummonerName(name).get("body"));

        //Step 2. Get Summoner Dto and Set Summoner Info At ModelAndView
        String puuid = dbFacade.getSummonerPuuidBySummonerName(name);
        SummonerDto summonerDto = dbFacade.getSummonerDtoBySummonerPuuid(puuid);
        setSummonerInfoAtModelAndView(modelAndView, summonerDto, name);

        //Step 3. Get League Dto and Set League Info At ModelAndView
        dbFacade.setLeagueInfo( (HashSet<Object>) apiFacade.getLeagueInfoBySummonerId(summonerDto.getId()).get("body") );
        setLeagueInfoAtModelAndView(modelAndView, dbFacade.getLeagueEntryDtoListBySummonerId(summonerDto.getId()));

        //Step 4. Get Match Id List
        // ..

        return modelAndView;
    }

    @GetMapping("refresh")
    public ModelAndView refreshSummoner(@RequestParam("name") String name) throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView("content/summoner");



        return modelAndView;
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

                if(leagueEntryDto.getMiniSeries().getSummonerId() != null)
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

    private void setMatchInfoListAtModelAndView(ModelAndView modelAndView, ArrayList<MatchDto> matchInfoList) {
        modelAndView.addObject("matchInfoList", matchInfoList);
    }
}
