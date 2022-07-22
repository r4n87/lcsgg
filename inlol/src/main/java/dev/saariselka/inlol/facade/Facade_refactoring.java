package dev.saariselka.inlol.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.saariselka.inlol.dto.LeagueEntryDto;
import dev.saariselka.inlol.dto.MatchDto;
import dev.saariselka.inlol.dto.SummonerDto;
import dev.saariselka.inlol.utils.JsonParserForLOL;
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
// TODO : 작업 완료 후 클래스명 Facade로 변경 예정
public class Facade_refactoring {
    @Autowired
    private APIFacade apiFacade;
    @Autowired
    private DBFacade dbFacade;

    // refactoring 후 new 버전
    @GetMapping("search")
    public ModelAndView searchSummoner(@RequestParam("name") String name) throws IOException {
        //Step 1. Check DB
        String puuid = dbFacade.getSummonerPuuidBySummonerName(name);

        // TODO : 리팩토링 필요. null이 아니라 enum type을 만드는게 나을수도?
        if(puuid == null)   // DB에 사용자 정보가 없을 때 API 호출하여 새로 받아서 DB에 넣어준다
            puuid = setSummonerByAPI(name, null);

        return getSummonerFromDB(name, puuid);
    }

    @GetMapping("refresh")
    public ModelAndView refreshSummoner(@RequestParam("name") String name) throws IOException {

        String puuid = dbFacade.getSummonerPuuidBySummonerName(name);
        setSummonerByAPI(name, puuid);

        return getSummonerFromDB(name, puuid);

    }

    public ModelAndView getSummonerFromDB(String name, String puuid) throws IOException {
        ModelAndView modelAndView = new ModelAndView("content/summoner");

        //Step 2. Get Summoner Dto and Set Summoner Info At ModelAndView
        SummonerDto summonerDto = dbFacade.getSummonerDtoBySummonerPuuid(puuid);
        setSummonerAtModelAndView(modelAndView, summonerDto, name);

        //Step 3. Get League Dto and Set League Info At ModelAndView
        setLeagueAtModelAndView(modelAndView, dbFacade.getLeagueEntryDtoListBySummonerId(summonerDto.getId()));

        //Step 4. Get Match Info List
        setMatchListAtModelAndView(modelAndView, dbFacade.getMatchDtoListBySummonerPuuid(puuid));

        //Step 5. Get Ddragon Version And Set Ddragon Version At ModelAndView
        setDdragonVersionAtModelAndView(modelAndView, dbFacade.getCurrentDdragonVersion());

        return modelAndView;
    }

    // TODO : 성공, 실패의 결과값을 리턴해야될거 같음 or exception으로 대체?
    public String setSummonerByAPI(String name, String puuid) throws JsonProcessingException {
        long startTime = 0L;

        if(puuid != null)
            startTime = dbFacade.getLastRefreshTimeBySummonerName(puuid);

        //Step 1. Get Summoner Info By Name via API
        dbFacade.setSummonerInfo((LinkedHashMap<String, String>) apiFacade.getSummonerBySummonerName(name).get("body"));
        SummonerDto summonerDto = dbFacade.getSummonerDtoBySummonerName(name);

        //Step 2. Get League info by encryptedSummonerId via API
        HashSet<Object> leagueInfo = (HashSet<Object>) apiFacade.getLeagueBySummonerId(summonerDto.getId()).get("body");
        if(!leagueInfo.isEmpty()) {
            dbFacade.setLeagueInfo(leagueInfo);
        }

        //Step 3. Get Match Info List by Name via API
        ArrayList<String> matchList = apiFacade.getMatchIdListBySummonerPuuidAndMatchStartTime(summonerDto.getPuuid(), startTime);
        HashSet<String> dbMatchList = dbFacade.getMatchIdListBySummonerPuuid(summonerDto.getPuuid());

        matchList.removeIf(dbMatchList::contains);

        for (int i = 0; i < matchList.size(); i++) {
            dbFacade.setMatch(((HashMap<String, Object>) apiFacade.getMatchByMatchId(matchList, i).get("body")));
        }

        return summonerDto.getPuuid();
    }

    private void setDdragonVersionAtModelAndView(ModelAndView modelAndView, String ddragonVersion) {
        modelAndView.addObject("DdragonVersion", ddragonVersion);
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

    private void setMatchListAtModelAndView(ModelAndView modelAndView, ArrayList<MatchDto> matchInfoList) {
        modelAndView.addObject("matchInfoList", matchInfoList);
    }

    @GetMapping("initJsonResource")
    private void initJsonResource() {
        JsonParserForLOL jsonParserForLOL = new JsonParserForLOL();

        dbFacade.setSummonerSpell(jsonParserForLOL.getSummonerSpellEntities());
        dbFacade.setChampions(jsonParserForLOL.getChampionEntities());
    }
}
