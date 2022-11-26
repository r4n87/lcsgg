package dev.saariselka.lcsgg.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.saariselka.lcsgg.controller.APIController;
import dev.saariselka.lcsgg.controller.APIKeyController;
import dev.saariselka.lcsgg.controller.DtoMapper;
import dev.saariselka.lcsgg.dto.LeagueEntryDto;
import dev.saariselka.lcsgg.dto.SummonerDto;
import dev.saariselka.lcsgg.utils.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
// TODO : exception 리팩토링 필요
public class APIFacade {
    private static API api;
    private static String apiKey;

    @Autowired
    private DtoMapper dtoMapper;
    @Autowired
    private APIController apiController;
    @Autowired
    private APIKeyController apiKeyController;

    public APIFacade() {
        api = new API();
    }

    //public HashMap<String, Object> getSummonerBySummonerName(String name) {
    public SummonerDto getSummonerBySummonerName(String name) throws JsonProcessingException {
        apiKey = apiKeyController.getAPIKeyByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIUrlByCategoryAndOperation("SUMMONER","GET_PUUID_BY_NAME")
                    + name
                    + "?"+"api_key="
                    + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, Map.class);


        } catch (HttpClientErrorException | HttpServerErrorException e) {
            //throw new ApiException("[Error][Get] getSummonerBySummonerName() : " + e.getRawStatusCode() + "HttpError" , APIType.SUMMONER);

            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("summoner info get error");
            System.out.println(e);

        } catch (Exception e) {
            //throw new ApiException("[Error][Get] getSummonerBySummonerName() : Unknown", APIType.SUMMONER);
            result.put("statusCode", "999");
            result.put("body"  , "summoner info get exception");
            System.out.println(e);
        }

        // TODO : 더 좋은 변환방법이 있을듯 (공통코드로)
        Gson gson = new Gson();
        String json = gson.toJson(result.get("body"));
        JsonParser parser = new JsonParser();
        JsonObject summoner = (JsonObject) parser.parse(json);
        return dtoMapper.toSummonerDto(summoner);
    }

    //public HashMap<String, Object> getLeagueBySummonerId(String encryptedSummonerId) {
    public LeagueEntryDto getLeagueBySummonerId(String encryptedSummonerId) throws JsonProcessingException {
        apiKey = apiKeyController.getAPIKeyByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIUrlByCategoryAndOperation("LEAGUE","GET_LEAGUE_BY_ENCRYPTEDID")
                    + encryptedSummonerId
                    + "?"+"api_key="
                    + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, Set.class);

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body", e.getStatusText());
            System.out.println("league info get error");
            System.out.println(e);

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body", "league info get exception");
            System.out.println(e);
        }

        // TODO : 더 좋은 변환방법이 있을듯 (공통코드로) 일단 임시로 값만 보기
        Gson gson = new Gson();
        String json = gson.toJson(result.get("body"));
        JsonParser parser = new JsonParser();
        JsonObject league = (JsonObject) parser.parse(json);
        LeagueEntryDto leagueEntryDto = dtoMapper.toLeagueEntryDto(league);
        return leagueEntryDto;
    }

    public ArrayList<String> getMatchIdListBySummonerPuuidAndMatchStartTime(String puuid, long startTime) {
        apiKey = apiKeyController.getAPIKeyByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();
        ArrayList<String> matchList = new ArrayList<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIUrlByCategoryAndOperation("MATCH", "GET_MATCHES_BY_PUUID")
                    + puuid
                    + "/ids?start=0&count=20&api_key="
                    + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, List.class);

            // parsing
            matchList = (ArrayList) result.get("body");
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body", e.getStatusText());
            System.out.println("get match list error");
            System.out.println(e);

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body", "get match list exception");
            System.out.println(e);
        }
        return matchList;
    }

    public HashMap<String, Object> getMatchByMatchId(ArrayList<String> matchList, int i) {

        apiKey = apiKeyController.getAPIKeyByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri;
            uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIUrlByCategoryAndOperation("MATCH","GET_MATCH_BY_MATCHID")
                    + matchList.get(i)
                    + "?"
                    + "api_key=" + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, HashMap.class);


        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("error~");
            System.out.println(e);

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion~");
            System.out.println(e);
        }
        return result;
    }
}
