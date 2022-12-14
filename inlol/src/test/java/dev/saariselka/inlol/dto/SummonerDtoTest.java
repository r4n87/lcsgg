package dev.saariselka.inlol.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

public class SummonerDtoTest {

    Timestamp rrt;

    @BeforeEach
    void init() {
        rrt = new Timestamp(System.currentTimeMillis());
    }

    @Test
    @DisplayName("Constructor")
    void constructor() {
        //given
        //Timestamp rrt = new Timestamp(System.currentTimeMillis());
        //SummonerEntity entity = createSummonerEntity(rrt);

        //when
        SummonerDto dto = new SummonerDto("yNr_v4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g",
                "dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy",
                "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA",
                "Hide on bush",
                "6",
                "1655406735000",
                "576",
                "0분 전",
                rrt.toInstant().getEpochSecond());
        
        //then 
        assertThat(dto.getPuuid()).isEqualTo("yNr_v4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g");
        assertThat(dto.getAccountId()).isEqualTo("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy");
        assertThat(dto.getId()).isEqualTo("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA");
        assertThat(dto.getName()).isEqualTo("Hide on bush");
        assertThat(dto.getProfileIconId()).isEqualTo("6");
        assertThat(dto.getRevisionDate()).isEqualTo("1655406735000");
        assertThat(dto.getSummonerLevel()).isEqualTo("576");
        assertThat(dto.getLastRefreshTimeForUI()).isEqualTo("0분 전");
        assertThat(dto.getLastRefreshTimeForAPI()).isEqualTo(rrt.toInstant().getEpochSecond());
    }

    @Test
    @DisplayName("Setter")
    void setter() {
        //given
        // rrt = new Timestamp(System.currentTimeMillis());
        //SummonerEntity faker = createSummonerEntity(rrt);

        //when
        SummonerDto keria = new SummonerDto("yNr_v4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g",
                "dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy",
                "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA",
                "Hide on bush",
                "6",
                "1655406735000",
                "576",
                "0분 전",
                rrt.toInstant().getEpochSecond());

        keria.setPuuid("peLkDG9h61dj9LYGw3yFcCHyetHM-Qt6eKY3x2U070_6fIErG2EwTqDzczjduVomIKJDj7-6L2ueLg");
        keria.setAccountId("AnVn-ctV9lk-m-DZQhVFoHqIGZpqqluBkRudI3tsoRqOQGY");
        keria.setId("WZ5VlMpcG1fdbCMf2EKYRgcl6JPMljsZjaJrWeLqAAjoWVc");
        keria.setName("역천괴");
        keria.setProfileIconId("20");
        keria.setRevisionDate("1655575724000");
        keria.setSummonerLevel("686");
        keria.setLastRefreshTimeForUI("1분 전");
        keria.setLastRefreshTimeForAPI(1655714385L);

        //then
        assertThat(keria.getPuuid()).isEqualTo("peLkDG9h61dj9LYGw3yFcCHyetHM-Qt6eKY3x2U070_6fIErG2EwTqDzczjduVomIKJDj7-6L2ueLg");
        assertThat(keria.getAccountId()).isEqualTo("AnVn-ctV9lk-m-DZQhVFoHqIGZpqqluBkRudI3tsoRqOQGY");
        assertThat(keria.getId()).isEqualTo("WZ5VlMpcG1fdbCMf2EKYRgcl6JPMljsZjaJrWeLqAAjoWVc");
        assertThat(keria.getName()).isEqualTo("역천괴");
        assertThat(keria.getProfileIconId()).isEqualTo("20");
        assertThat(keria.getRevisionDate()).isEqualTo("1655575724000");
        assertThat(keria.getSummonerLevel()).isEqualTo("686");
        assertThat(keria.getLastRefreshTimeForUI()).isEqualTo("1분 전");
        assertThat(keria.getLastRefreshTimeForAPI()).isEqualTo(1655714385L);
    }

}