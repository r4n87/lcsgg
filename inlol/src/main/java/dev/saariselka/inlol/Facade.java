package dev.saariselka.inlol;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.saariselka.inlol.controller.APIController;
import dev.saariselka.inlol.controller.APIKeyController;
import dev.saariselka.inlol.controller.MatchMasterController;
import dev.saariselka.inlol.controller.SummonerController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class Facade {

    private String name;

    // 테스트를 위해 주석 처리
//    public Facade(String name)
//    {
//        this.name = name;
//    }

    // DB 정보 불러오기
    public void search()
    {

    }

    // API를 활용해서 Init
    public void init() throws JsonProcessingException
    {
        // 테스트를 위해 하드 코딩
        name = "Petaluma";

        Facade_Get facade_get = new Facade_Get();
        Facade_Set facade_set = new Facade_Set();

        HashMap<String, Object> result;

        //Step 1. Get SummonerInfo By Name
        result = facade_get.getSummonerInfo(name);

        //Step 2. Set SummonerInfo At DB
        facade_set.setSummonerInfoAtDB(result);

        //Step 3. Get MatchList By puuid
        ArrayList<String> matchList = facade_get.getMatchList(name);

        for(int i = 0; i < matchList.size(); i++)
        {
            //Step 4. Get MatchInfo By MatchList
            result = facade_get.getMatchInfo(matchList, i);

            //Step 5. Set MatchInfo At DB
            facade_set.setMatchInfoAtDB(result);
        }
    }

    // API를 활용해서 DB 업데이트
    public void update()
    {
        //1. puuid 발췌
        //String puuid = summonerController.getSummner_Puuid_ByName(name);

    }

}
