package dev.saariselka.inlol;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.saariselka.inlol.controller.APIController;
import dev.saariselka.inlol.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

@RestController
public class RestAPI {

    @Autowired
    APIController apiController;

    @GetMapping("callAPI")
    public String callAPI() {

        String jsonInString = "";

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); // 타임아웃 5초
        factory.setReadTimeout(5000); // 타임아웃 5초
        RestTemplate restTemplate = new RestTemplate(factory);

        HttpHeaders header = new HttpHeaders();
        Charset utf8 = Charset.forName("UTF-8");
        MediaType mediaType = new MediaType("application", "json", utf8);
        header.setContentType(mediaType);
        HttpEntity<?> entity = new HttpEntity<>(header);

        // 임시로 Petaluma,
        // api key는 만료되면 갱신해야 함
        String userID = "Petaluma";
        String apiKey = "RGAPI-40229b42-021a-446c-80fe-f3a8776416ac";

        // 1. puuid get
        String strPuuid = getPuuidByName(restTemplate, entity, userID, apiKey);

        // 2. match id get
        ArrayList<String> matchList = getMatchListByPuuid(restTemplate, entity, apiKey, strPuuid);

        // 3. get match
        // 임의로 1개만 먼저 test
        String matchId = matchList.get(0);
        HashMap<String, Object> matchInfo = getMatchInfoByMatchid(restTemplate, entity, apiKey, matchId);

        // response 파싱
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(matchInfo);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonInString;
    }

    private HashMap<String, Object> getMatchInfoByMatchid(RestTemplate restTemplate, HttpEntity<?> entity, String apiKey, String matchId) {

        HashMap<String, Object> result = new HashMap<String, Object>();
        HashMap<String, Object> matchInfo = new HashMap<String, Object>();

        try {
            UriComponents uri;
            uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("MATCH","GET_MATCH_BY_MATCHID")
                    + matchId
                    + "?"
                    + "api_key=" + apiKey).build();

            // API 호출
            result = executeAPI(restTemplate, entity, uri, HashMap.class);

            // parsing
            matchInfo = (HashMap) result.get("body");
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

        return matchInfo;
    }

    private ArrayList<String> getMatchListByPuuid(RestTemplate restTemplate, HttpEntity<?> entity, String apiKey, String strPuuid) {

        HashMap<String, Object> result = new HashMap<String, Object>();
        ArrayList<String> matchList = new ArrayList<String>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("MATCH","GET_MATCHES_BY_PUUID")
                    + strPuuid
                    +  "/ids?start=0&count=20&api_key="
                    + apiKey).build();

            // API 호출
            result = executeAPI(restTemplate, entity, uri, List.class);

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

        return matchList;
    }

    private String getPuuidByName(RestTemplate restTemplate, HttpEntity<?> entity, String userID, String apiKey) {

        HashMap<String, Object> result = new HashMap<String, Object>();
        String strPuuid = "";

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("SUMMONER","GET_PUUID_BY_NAME")
                    + userID
                    + "?"+"api_key="
                    + apiKey).build();

            // API 호출
            result = executeAPI(restTemplate, entity, uri, Map.class);

            // parsing
            LinkedHashMap<String, String> res = (LinkedHashMap)result.get("body");
            strPuuid = res.get("puuid");
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

        return strPuuid;
    }

    private HashMap<String, Object> executeAPI(RestTemplate restTemplate, HttpEntity<?> entity, UriComponents uri, Class responseType) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, responseType);
        result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
        result.put("header", resultMap.getHeaders()); //헤더 정보 확인
        result.put("body", resultMap.getBody()); //실제 데이터 정보 확인
        return result;
    }
}
