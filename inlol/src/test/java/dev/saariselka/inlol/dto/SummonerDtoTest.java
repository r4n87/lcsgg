package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.SummonerEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SummonerDtoTest {

    Timestamp rrt;
    SummonerEntity entity;

    @BeforeEach
    void init() {
        rrt = new Timestamp(System.currentTimeMillis());
        entity = createSummonerEntity(rrt);
    }

    @Test
    @DisplayName("SummonerDto 생성자 테스트")
    void SummonerDto_생성자_테스트() {
        //given
        //Timestamp rrt = new Timestamp(System.currentTimeMillis());
        //SummonerEntity entity = createSummonerEntity(rrt);

        //when
        SummonerDto dto = new SummonerDto(entity);  
        
        //then 
        assertThat(dto.getPuuid()).isEqualTo("yNr_v4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g");
        assertThat(dto.getAccountId()).isEqualTo("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy");
        assertThat(dto.getId()).isEqualTo("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA");
        assertThat(dto.getName()).isEqualTo("Hide on bush");
        assertThat(dto.getProfileIconId()).isEqualTo("6");
        assertThat(dto.getRevisionDate()).isEqualTo("1655406735000");
        assertThat(dto.getSummonerLevel()).isEqualTo("576");
        assertThat(dto.getRefreshAgoTime()).isEqualTo("0분 전");
        assertThat(dto.getLastRefreshTime()).isEqualTo(rrt.toInstant().getEpochSecond());
    }

    @Test
    @DisplayName("SummonerDto Setter 테스트")
    void SummonerDto_Setter_테스트() {
        //given
        // rrt = new Timestamp(System.currentTimeMillis());
        //SummonerEntity faker = createSummonerEntity(rrt);

        //when
        SummonerDto keria = new SummonerDto(entity);
        keria.setPuuid("peLkDG9h61dj9LYGw3yFcCHyetHM-Qt6eKY3x2U070_6fIErG2EwTqDzczjduVomIKJDj7-6L2ueLg");
        keria.setAccountId("AnVn-ctV9lk-m-DZQhVFoHqIGZpqqluBkRudI3tsoRqOQGY");
        keria.setId("WZ5VlMpcG1fdbCMf2EKYRgcl6JPMljsZjaJrWeLqAAjoWVc");
        keria.setName("역천괴");
        keria.setProfileIconId("20");
        keria.setRevisionDate("1655575724000");
        keria.setSummonerLevel("686");
        keria.setRefreshAgoTime("1분 전");
        keria.setLastRefreshTime(1655714385L);

        //then
        assertThat(keria.getPuuid()).isEqualTo("peLkDG9h61dj9LYGw3yFcCHyetHM-Qt6eKY3x2U070_6fIErG2EwTqDzczjduVomIKJDj7-6L2ueLg");
        assertThat(keria.getAccountId()).isEqualTo("AnVn-ctV9lk-m-DZQhVFoHqIGZpqqluBkRudI3tsoRqOQGY");
        assertThat(keria.getId()).isEqualTo("WZ5VlMpcG1fdbCMf2EKYRgcl6JPMljsZjaJrWeLqAAjoWVc");
        assertThat(keria.getName()).isEqualTo("역천괴");
        assertThat(keria.getProfileIconId()).isEqualTo("20");
        assertThat(keria.getRevisionDate()).isEqualTo("1655575724000");
        assertThat(keria.getSummonerLevel()).isEqualTo("686");
        assertThat(keria.getRefreshAgoTime()).isEqualTo("1분 전");
        assertThat(keria.getLastRefreshTime()).isEqualTo(1655714385L);
    }


    SummonerEntity createSummonerEntity(Timestamp rrt) {
        return new SummonerEntity(
                "dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy", 6, 1655406735000L,
                "Hide on bush", "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA", 576L,
                "yNr_v4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g", rrt);
    }
}