package dev.saariselka.lcsgg.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.saariselka.lcsgg.dto.LeagueEntryDto;
import dev.saariselka.lcsgg.dto.MatchDto;
import dev.saariselka.lcsgg.dto.SummonerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@RestController
public class Facade {

    @Autowired
    private APIFacade apiFacade;

    @Autowired
    private DBFacade dbFacade;

    @GetMapping("search")
    public ModelAndView searchSummoner(@RequestParam("name") String name) throws IOException {
        //Step 1. Check DB
        String puuid = dbFacade.getSummonerPuuidBySummonerName(name);

        //Step 2. Call API
        // db에 없으면 api 호출
        if(puuid == null)
            puuid = setSummonerByAPI(name, null);

        return getSummonerFromDB(name, puuid);
    }

    @GetMapping("refresh")
    public ModelAndView refreshSummoner(@RequestParam("name") String name) throws IOException {
        String puuid = dbFacade.getSummonerPuuidBySummonerName(name);
        setSummonerByAPI(name, puuid);

        return getSummonerFromDB(name, puuid);
    }

    public String setSummonerByAPI(String name, String puuid) throws JsonProcessingException {
        // 기존 플젝에서도 startTime 변수 안쓰였음
//        long startTime = 0L;
//
//        if(puuid != null)
//            startTime = dbFacade.getLastRefreshTimeBySummonerName(puuid);

        //Step 1. Get Summoner Info By Name via API
        SummonerDto summonerDto = apiFacade.getSummonerBySummonerName(name);
        dbFacade.setSummonerInfo(summonerDto);

        //Step 2. Get League info by encryptedSummonerId via API
        List<LeagueEntryDto> leagueEntryDtos = apiFacade.getLeagueBySummonerId(summonerDto.getId());
        if(leagueEntryDtos != null)
            dbFacade.setLeagueInfo(leagueEntryDtos);

        //Step 3. Get Match Info List by Name via API
        ArrayList<String> matchList = apiFacade.getMatchIdListBySummonerPuuidAndMatchStartTime(summonerDto.getPuuid());
//        HashSet<String> dbMatchList = dbFacade.getMatchIdListBySummonerPuuid(summonerDto.getPuuid()); // TODO : match를 puuid별로 가져올 방법 필요
//
//        matchList.removeIf(dbMatchList::contains);
//
        for (int i = 0; i < matchList.size(); i++) {
            dbFacade.setMatch(apiFacade.getMatchByMatchId(matchList, i));
        }

        return summonerDto.getPuuid();
    }

    public ModelAndView getSummonerFromDB(String name, String puuid) throws IOException {
        ModelAndView modelAndView = new ModelAndView("content/summoner");

        //Step 2. Get Summoner Dto and Set Summoner Info At ModelAndView
        SummonerDto summonerDto = dbFacade.getSummonerDtoBySummonerPuuid(puuid);
        setSummonerAtModelAndView(modelAndView, summonerDto, name);

        //Step 3. Get League Dto and Set League Info At ModelAndView
        setLeagueAtModelAndView(modelAndView, dbFacade.getLeagueEntryDtoListBySummonerId(summonerDto.getId()));

        //TODO : Step 4. Get Match Info List
        //setMatchListAtModelAndView(modelAndView, dbFacade.getMatchDtoListBySummonerPuuid(puuid));

        //TODO : Step 5. Get Ddragon Version And Set Ddragon Version At ModelAndView
        //setDdragonVersionAtModelAndView(modelAndView, dbFacade.getCurrentDdragonVersion());

        return modelAndView;
    }

    private void setSummonerAtModelAndView(ModelAndView modelAndView, SummonerDto summonerDto, String name) {
        modelAndView.addObject("summoner", summonerDto);
        modelAndView.addObject("summonerName", name);
    }

    private void setLeagueAtModelAndView(ModelAndView modelAndView, List<LeagueEntryDto> leagueEntryDtoList) {
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

                if(leagueEntryDto.getMiniSeries() != null) // TODO : 잘 되는지 테스트 필요
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

    private void setMatchListAtModelAndView(ModelAndView modelAndView, ArrayList<MatchDto> matchInfoList) {
        modelAndView.addObject("matchInfoList", matchInfoList);
    }

    private void setDdragonVersionAtModelAndView(ModelAndView modelAndView, String ddragonVersion) {
        modelAndView.addObject("DdragonVersion", ddragonVersion);
    }

}
