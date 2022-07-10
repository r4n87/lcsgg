package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.SummonerEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SummonerControllerTest {
    @Autowired
    SummonerController summonerController;

    @Test
    @DisplayName("Get Puuid By Name")
    void getPuuidByName() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        summonerController.insertSummoner("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy", 6, 1655406735000L,
                "Test on bush", "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA", 576L,
                "test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g", rrt);

        // when
        String puuid = summonerController.getSummoner_Puuid_ByName("Test on bush");

        // then
        assertThat(puuid).isEqualTo("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g");
    }

    @Test
    @DisplayName("Get Entity By Puuid")
    void getEntityByPuuid() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        summonerController.insertSummoner("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy", 6, 1655406735000L,
                "Test on bush", "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA", 576L,
                "test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g", rrt);

        // when
        List<SummonerEntity> entity = summonerController.getSummoner("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g");
        SummonerEntity test = entity.get(0);

        // then
        assertThat(test.getAccountid()).isEqualTo("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy");
        assertThat(test.getProfileiconid()).isEqualTo(6);
        assertThat(test.getRevisiondate()).isEqualTo(1655406735000L);
        assertThat(test.getName()).isEqualTo("Test on bush");
        assertThat(test.getId()).isEqualTo("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA");
        assertThat(test.getSummonerlevel()).isEqualTo(576L);
        assertThat(test.getPuuid()).isEqualTo("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g");
        assertThat(test.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Get All")
    void getAllSummoner() {
        // given
        List<SummonerEntity> before = summonerController.getAllSummoners().getBody();
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        summonerController.insertSummoner("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy", 6, 1655406735000L,
                "Test on bush", "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA", 576L,
                "test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g", rrt);

        // when
        List<SummonerEntity> entity = summonerController.getAllSummoners().getBody();

        // then
        assertThat(entity.size()).isEqualTo(before.size()+1);
    }
}