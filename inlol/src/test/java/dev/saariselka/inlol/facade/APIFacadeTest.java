package dev.saariselka.inlol.facade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void getLeagueBySummonerId() {
        // given
        String encryptedSummonerId = "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA";

        // when
        HashMap<String, Object> test = apiFacade.getLeagueBySummonerId(encryptedSummonerId);

        // then
        assertThat(test.get("statusCode")).isEqualTo(200);
    }
}