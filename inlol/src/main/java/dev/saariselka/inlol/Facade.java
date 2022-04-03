package dev.saariselka.inlol;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.saariselka.inlol.controller.APIController;
import dev.saariselka.inlol.controller.APIKeyController;
import dev.saariselka.inlol.controller.MatchMasterController;
import dev.saariselka.inlol.controller.SummonerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

public class Facade {

    private String apiKey;
    private String name;

    @Autowired
    SummonerController summonerController;
    @Autowired
    APIController apiController;
    @Autowired
    APIKeyController apiKeyController;
    @Autowired
    MatchMasterController matchMasterController;

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
    public void init()
    {
        API api = new API();

        apiKey = apiKeyController.getAPIKey_ByCategory("Personal");

        // 테스트를 위해 하드 코딩
        name = "Petaluma";

        //Step 1. get summoner by name
        HashMap<String, Object> result = new HashMap<String, Object>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("SUMMONER","GET_PUUID_BY_NAME")
                    + name
                    + "?"+"api_key="
                    + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, Map.class);

            // parsing
            LinkedHashMap<String, String> res = (LinkedHashMap)result.get("body");

            // DB Insert
            summonerController.insertSummoner(res.get("accountId"),Integer.parseInt(String.valueOf(res.get("profileIconId"))),
                    Long.parseLong(String.valueOf(res.get("revisionDate"))),res.get("name"),res.get("id"),
                    Long.parseLong(String.valueOf(res.get("summonerLevel"))),res.get("puuid"));
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("error~");
            System.out.println(e.toString());

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion~");
            System.out.println(e.toString());
        }

        //Step 2. Get MatchList By puuid
        ArrayList<String> matchList = new ArrayList<String>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("MATCH","GET_MATCHES_BY_PUUID")
                    + summonerController.getSummner_Puuid_ByName(name)
                    +  "/ids?start=0&count=20&api_key="
                    + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, List.class);

            // parsing
            matchList = (ArrayList)result.get("body");
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("error~");
            System.out.println(e.toString());

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion~");
            System.out.println(e.toString());
        }

        //Step 3. Get MatchInfo By MatchList
        HashMap<String, Object> matchInfo = new HashMap<String, Object>();

        for(int i = 0; i < matchList.size(); i++)
        {
            System.out.println("Match Id" + matchList.get(i));

            try {
                UriComponents uri;
                uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("MATCH","GET_MATCH_BY_MATCHID")
                        + matchList.get(i)
                        + "?"
                        + "api_key=" + apiKey).build();

                // API 호출
                result = api.executeAPI(uri, HashMap.class);

                // parsing
                matchInfo = (HashMap) result.get("body");

                ObjectMapper mapper = new ObjectMapper();
                String jsonInString = mapper.writeValueAsString(matchInfo);

                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = (JsonObject)jsonParser.parse(jsonInString);
                JsonObject jsonObjectForMetadata = (JsonObject) jsonObject.get("metadata");
                JsonObject jsonObjectForInfo = (JsonObject) jsonObject.get("info");

                //DB Insert
                matchMasterController.insertMatchMaster(jsonObjectForMetadata.get("dataVersion").toString(),jsonObjectForMetadata.get("matchId").toString(),
                        Long.parseLong(jsonObjectForInfo.get("gameCreation").toString()),Long.parseLong(jsonObjectForInfo.get("gameDuration").toString()),
                        Long.parseLong(jsonObjectForInfo.get("gameEndTimestamp").toString()),Long.parseLong(jsonObjectForInfo.get("gameId").toString()),
                        jsonObjectForInfo.get("gameMode").toString(),jsonObjectForInfo.get("gameName").toString(),
                        Long.parseLong(jsonObjectForInfo.get("gameStartTimestamp").toString()),jsonObjectForInfo.get("gameType").toString(),
                        jsonObjectForInfo.get("gameVersion").toString(),Integer.parseInt(jsonObjectForInfo.get("mapId").toString()),
                        jsonObjectForInfo.get("platformId").toString(),Integer.parseInt(jsonObjectForInfo.get("queueId").toString()),
                        jsonObjectForInfo.get("tournamentCode").toString(), 100, 200);

            } catch (HttpClientErrorException | HttpServerErrorException e) {
                result.put("statusCode", e.getRawStatusCode());
                result.put("body"  , e.getStatusText());
                System.out.println("error~");
                System.out.println(e.toString());

            } catch (Exception e) {
                result.put("statusCode", "999");
                result.put("body"  , "excpetion~");
                System.out.println(e.toString());
            }
        }


    }

    // API를 활용해서 DB 업데이트
    public void update()
    {
        //1. puuid 발췌
        //String puuid = summonerController.getSummner_Puuid_ByName(name);

    }

}
