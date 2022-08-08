package dev.saariselka.inlol.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class APIFacadeTest {

    @Autowired
    APIFacade apiFacade;

    @Test
    @DisplayName("[API] Get Summoner By Summoner Name")
    void getSummonerBySummonerName() {
        // given
        String name = "Hide on bush";

        // when
        HashMap<String, Object> test = apiFacade.getSummonerBySummonerName(name);

        // then
        assertThat(test.get("statusCode")).isEqualTo(200);
        assertThat(((LinkedHashMap<String, String>) test.get("body")).get("name")).isEqualTo(name);
    }

    @Test
    @DisplayName("[API] Get League By Summoner Id")
    void  getLeagueBySummonerId() {
        // given
        String encryptedSummonerId = "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA";

        // when
        HashMap<String, Object> test = apiFacade.getLeagueBySummonerId(encryptedSummonerId);

        // then
        assertThat(test.get("statusCode")).isEqualTo(200);
    }

    @Test
    @DisplayName("[API] Get Match Id List By Summoner Puuid, Match Start Time")
    void getMatchIdListBySummonerPuuidAndMatchStartTime() {
        // given
        String puuid = "UaX2DtUVIdsIuc-chtJJ-hUSgtL32HQPZZhfsqLt6bPzudr80EIbYwAgPQfV8b8eC4sKCkRjx4wrZg";
        long startTime = 0L;

        // when
        ArrayList<String> matchIdList = apiFacade.getMatchIdListBySummonerPuuidAndMatchStartTime(puuid, startTime);

        // then
        assertThat(matchIdList.size()).isGreaterThan(0);
    }

    @Test
    @DisplayName("[API] Get Match By Match Id")
    void getMatchByMatchId() throws JsonProcessingException {
        // given
        String matchId = "KR_6014432489";
        ArrayList<String> matchList = new ArrayList<>();
        matchList.add(matchId);

        // when
        HashMap<String, Object> testHashMap = apiFacade.getMatchByMatchId(matchList, 0);

        // then
        assertThat(testHashMap.get("statusCode")).isEqualTo(200);

        HashMap<String, Object> matchInfo = (HashMap<String, Object>) testHashMap.get("body");
        ObjectMapper mapper = new ObjectMapper();
        JsonObject testObject =
                (JsonObject) JsonParser.parseString(mapper.writeValueAsString(matchInfo))
                                .getAsJsonObject()
                                .get("metadata");

        assertThat(testObject.get("matchId").getAsString()).isEqualTo(matchId);
    }
}