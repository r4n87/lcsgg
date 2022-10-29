package dev.saariselka.lcsgg.utils;

import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class API {

    private HttpComponentsClientHttpRequestFactory factory;
    private RestTemplate restTemplate;
    private HttpEntity<?> entity;
    private HttpHeaders header;
    private Charset utf8;
    private MediaType mediaType;

    public API() {
        factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); // 타임아웃 5초
        factory.setReadTimeout(5000); // 타임아웃 5초
        restTemplate = new RestTemplate(factory);

        header = new HttpHeaders();
        utf8 = Charset.forName("UTF-8");
        mediaType = new MediaType("application", "json", utf8);
        header.setContentType(mediaType);
        entity = new HttpEntity<>(header);
    }

    public HashMap<String, Object> executeAPI(UriComponents uri, Class responseType) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, responseType);
        result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
        result.put("header", resultMap.getHeaders()); //헤더 정보 확인
        result.put("body", resultMap.getBody()); //실제 데이터 정보 확인
        return result;
    }
}
