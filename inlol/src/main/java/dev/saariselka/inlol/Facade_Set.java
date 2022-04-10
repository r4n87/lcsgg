package dev.saariselka.inlol;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.saariselka.inlol.controller.MatchMasterController;
import dev.saariselka.inlol.controller.SummonerController;
import dev.saariselka.inlol.controller.TeamController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class Facade_Set {

    @Autowired
    SummonerController summonerController;
    @Autowired
    MatchMasterController matchMasterController;
    @Autowired
    TeamController teamController;

    public void setMatchInfoAtDB(HashMap<String, Object> result) throws JsonProcessingException {

        HashMap<String, Object> matchInfo;

        matchInfo = (HashMap) result.get("body");

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(matchInfo);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(jsonInString);
        JsonObject jsonObjectForMetadata = (JsonObject) jsonObject.get("metadata");
        JsonObject jsonObjectForInfo = (JsonObject) jsonObject.get("info");
        JsonArray jsonArrayForTeams = (JsonArray)jsonObjectForInfo.get("teams");

        //DB Insert
        matchMasterController.insertMatchMaster(jsonObjectForMetadata.get("dataVersion").toString(),jsonObjectForMetadata.get("matchId").toString(),
                Long.parseLong(jsonObjectForInfo.get("gameCreation").toString()),Long.parseLong(jsonObjectForInfo.get("gameDuration").toString()),
                Long.parseLong(jsonObjectForInfo.get("gameEndTimestamp").toString()),Long.parseLong(jsonObjectForInfo.get("gameId").toString()),
                jsonObjectForInfo.get("gameMode").toString(),jsonObjectForInfo.get("gameName").toString(),
                Long.parseLong(jsonObjectForInfo.get("gameStartTimestamp").toString()),jsonObjectForInfo.get("gameType").toString(),
                jsonObjectForInfo.get("gameVersion").toString(),Integer.parseInt(jsonObjectForInfo.get("mapId").toString()),
                jsonObjectForInfo.get("platformId").toString(),Integer.parseInt(jsonObjectForInfo.get("queueId").toString()),
                jsonObjectForInfo.get("tournamentCode").toString(), 100, 200);

        for (Object obj : jsonArrayForTeams) {
            JsonObject teamObj = (JsonObject)obj;
            teamController.insertTeamInfo(jsonObjectForMetadata.get("matchId").toString()
                    ,Integer.parseInt(teamObj.get("teamId").toString())
                    ,Boolean.parseBoolean(teamObj.get("win").toString()));
        }
    }

    public void setSummonerInfoAtDB(HashMap<String, Object> result) {
        // parsing
        LinkedHashMap<String, String> res = (LinkedHashMap) result.get("body");

        // DB Insert
        summonerController.insertSummoner(res.get("accountId"),Integer.parseInt(String.valueOf(res.get("profileIconId"))),
                Long.parseLong(String.valueOf(res.get("revisionDate"))),res.get("name"),res.get("id"),
                Long.parseLong(String.valueOf(res.get("summonerLevel"))),res.get("puuid"));
    }
}
