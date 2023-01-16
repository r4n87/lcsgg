package dev.saariselka.lcsgg.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.saariselka.lcsgg.controller.APIController;
import dev.saariselka.lcsgg.controller.APIKeyController;
import dev.saariselka.lcsgg.controller.DtoMapper;
import dev.saariselka.lcsgg.dto.LeagueEntryDto;
import dev.saariselka.lcsgg.dto.MatchDto;
import dev.saariselka.lcsgg.dto.SummonerDto;
import dev.saariselka.lcsgg.utils.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Timestamp;
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

        SummonerDto summonerDto = dtoMapper.toSummonerDto(result);
        summonerDto.setLastRefreshTimeForAPI(new Timestamp(System.currentTimeMillis()));
        return summonerDto;
    }

    public List<LeagueEntryDto> getLeagueBySummonerId(String encryptedSummonerId) throws JsonProcessingException {
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

        return dtoMapper.toLeagueEntryDto(result);
    }

    public ArrayList<String> getMatchIdListBySummonerPuuid(String puuid) {
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

    public MatchDto getMatchByMatchId(ArrayList<String> matchList, int i) throws JsonProcessingException {

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

        return dtoMapper.toMatchDto(result);
    }
}
