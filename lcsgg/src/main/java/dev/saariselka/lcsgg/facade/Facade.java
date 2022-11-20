package dev.saariselka.lcsgg.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

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

        return new ModelAndView(); // TODO : 임시
    }

    @GetMapping("refresh")
    public ModelAndView refreshSummoner(@RequestParam("name") String name) throws IOException {
        return new ModelAndView(); // TODO : 임시
    }

    public String setSummonerByAPI(String name, String puuid) throws JsonProcessingException {
        long startTime = 0L;

        // TODO : getLastRefreshTimeBySummonerName() 없어서 주석처리
//        if(puuid != null)
//            startTime = dbFacade.getLastRefreshTimeBySummonerName(puuid);

        //Step 1. Get Summoner Info By Name via API
        dbFacade.setSummonerInfo(apiFacade.getSummonerBySummonerName(name));

//        dbFacade.setSummonerInfo((LinkedHashMap<String, String>) apiFacade.getSummonerBySummonerName(name).get("body"));
//        SummonerDto summonerDto = dbFacade.getSummonerDtoBySummonerName(name);

        //Step 2. Get League info by encryptedSummonerId via API
//        HashSet<Object> leagueInfo = (HashSet<Object>) apiFacade.getLeagueBySummonerId(summonerDto.getId()).get("body");
//        if(!leagueInfo.isEmpty()) {
//            dbFacade.setLeagueInfo(leagueInfo);
//        }

        //Step 3. Get Match Info List by Name via API
//        ArrayList<String> matchList = apiFacade.getMatchIdListBySummonerPuuidAndMatchStartTime(summonerDto.getPuuid(), startTime);
//        HashSet<String> dbMatchList = dbFacade.getMatchIdListBySummonerPuuid(summonerDto.getPuuid());
//
//        matchList.removeIf(dbMatchList::contains);
//
//        for (int i = 0; i < matchList.size(); i++) {
//            dbFacade.setMatch(((HashMap<String, Object>) apiFacade.getMatchByMatchId(matchList, i).get("body")));
//        }
//
        //TODO : 임시 리턴
        return "puuid"; //summonerDto.getPuuid();
    }
}
