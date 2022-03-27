package dev.saariselka.inlol;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.saariselka.inlol.controller.APIController;
import dev.saariselka.inlol.service.APIService;
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

import java.nio.charset.Charset;
import java.util.*;

@RestController
public class RestAPI {
    @GetMapping("callAPI")
    public String callAPI() {
        HashMap<String, Object> result1 = new HashMap<String, Object>();    // ppuid
        HashMap<String, Object> result2 = new HashMap<String, Object>();    // match id
        HashMap<String, Object> result3 = new HashMap<String, Object>();    // match info

        String jsonInString = "";

        try {
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory .setConnectTimeout(5000); // 타임아웃 5초
            factory.setReadTimeout(5000); // 타임아웃 5초
            RestTemplate restTemplate = new RestTemplate(factory);
            RestTemplate restTemplate2 = new RestTemplate(factory);

            HttpHeaders header = new HttpHeaders();
            Charset utf8 = Charset.forName("UTF-8");
            MediaType mediaType = new MediaType("application", "json", utf8);
            header.setContentType(mediaType);
            HttpEntity<?> entity = new HttpEntity<>(header);

            // 임시로 Petaluma,
            // api key는 만료되면 갱신해야 함
            String userID = "Petaluma";
            String apiKey = "RGAPI-c26c3b08-edb4-40c8-b5ab-4cf49668f8d2";

            // 1. ppuid get
            String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url+ userID + "?"+"api_key="+apiKey).build();

            // API 호출
            ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
            result1.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result1.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result1.put("body", resultMap.getBody()); //실제 데이터 정보 확인

            // parsing
            LinkedHashMap<String, String> res = (LinkedHashMap)result1.get("body");
            String strPuuid = res.get("puuid");

            // 2. match id get
            url = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/";
            uri = UriComponentsBuilder.fromHttpUrl(url + strPuuid +  "/ids?start=0&count=20&api_key=" + apiKey).build();

            // API 호출
            ResponseEntity<List> resultMap2 = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, List.class);
            result2.put("statusCode", resultMap2.getStatusCodeValue()); //http status code를 확인
            result2.put("header", resultMap2.getHeaders()); //헤더 정보 확인
            result2.put("body", resultMap2.getBody()); //실제 데이터 정보 확인

            // parsing
            ArrayList<String> matchList = (ArrayList)result2.get("body");


            // 3. get match
            // 임의로 1개만 먼저 test
            url = "https://asia.api.riotgames.com/lol/match/v5/matches/";
            String matchId = matchList.get(0);
            uri = UriComponentsBuilder.fromHttpUrl(url + matchId + "?" + "api_key=" + apiKey).build();

            // API 호출
            ResponseEntity<HashMap> resultMap3 = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, HashMap.class);
            result3.put("statusCode", resultMap3.getStatusCodeValue()); //http status code를 확인
            result3.put("header", resultMap3.getHeaders()); //헤더 정보 확인
            result3.put("body", resultMap3.getBody()); //실제 데이터 정보 확인

            // parsing
            HashMap<String, Object> matchInfoList = (HashMap)result3.get("body");

            // response 파싱
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(matchInfoList);


        }catch (HttpClientErrorException | HttpServerErrorException e) {
            result1.put("statusCode", e.getRawStatusCode());
            result1.put("body"  , e.getStatusText());
            System.out.println("error~");
            System.out.println(e.toString());

        } catch (Exception e) {
            result1.put("statusCode", "999");
            result1.put("body"  , "excpetion~");
            System.out.println(e.toString());
        }

        return jsonInString;
    }
}
