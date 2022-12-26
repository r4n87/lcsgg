package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.dto.SummonerDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class SummonerControllerTest {
    @Autowired
    SummonerController summonerController;

    String puuid = "test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g";
    String accountId = "dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy";
    String id = "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA";
    String name = "Test on bush";
    String profileIconId = "6";
    String revisionDate = "1655406735000";
    String summonerLevel = "576";
    String lastRefreshTimeForUI = getLastRefreshTimeForUI(new Timestamp(System.currentTimeMillis()));
    long lastRefreshTimeForAPI = 123456789L;

    @Test
    @DisplayName("Get Puuid By Name")
    void getPuuidByName() {
        // given
        SummonerDto dto = SummonerDto.builder()
                .puuid(puuid)
                .accountId(accountId)
                .id(id)
                .name(name)
                .profileIconId(profileIconId)
                .revisionDate(revisionDate)
                .summonerLevel(summonerLevel)
                .lastRefreshTimeForUI(lastRefreshTimeForUI)
                .lastRefreshTimeForAPI(lastRefreshTimeForAPI)
                .build();

        summonerController.insertSummoner(dto);

        // when
        String findPuuid = summonerController.getPuuidByName("Test on bush");

        // then
        assertThat(findPuuid).isEqualTo(puuid);
    }

    @Test
    @DisplayName("Get SummonerDto By Name")
    void getSummonerDtoByName() {
        // given
        SummonerDto dto = SummonerDto.builder()
                .puuid(puuid)
                .accountId(accountId)
                .id(id)
                .name(name)
                .profileIconId(profileIconId)
                .revisionDate(revisionDate)
                .summonerLevel(summonerLevel)
                .lastRefreshTimeForUI(lastRefreshTimeForUI)
                .lastRefreshTimeForAPI(lastRefreshTimeForAPI)
                .build();

        summonerController.insertSummoner(dto);

        // when
        SummonerDto findDto = summonerController.getSummonerDtoByName(name);

        // then
        assertThat(findDto.getAccountId()).isEqualTo(accountId);
        assertThat(findDto.getProfileIconId()).isEqualTo(profileIconId);
        assertThat(findDto.getRevisionDate()).isEqualTo(revisionDate);
        assertThat(findDto.getName()).isEqualTo(name);
        assertThat(findDto.getId()).isEqualTo(id);
        assertThat(findDto.getSummonerLevel()).isEqualTo(summonerLevel);
        assertThat(findDto.getPuuid()).isEqualTo(puuid);
        assertThat(findDto.getLastRefreshTimeForUI()).isEqualTo(lastRefreshTimeForUI);
        assertThat(findDto.getLastRefreshTimeForAPI()).isEqualTo(lastRefreshTimeForAPI);
    }

    @Test
    @DisplayName("Get SummonerDto By Puuid")
    void getSummonerDtoByPuuid() {
        // given
        SummonerDto dto = SummonerDto.builder()
                .puuid(puuid)
                .accountId(accountId)
                .id(id)
                .name(name)
                .profileIconId(profileIconId)
                .revisionDate(revisionDate)
                .summonerLevel(summonerLevel)
                .lastRefreshTimeForUI(lastRefreshTimeForUI)
                .lastRefreshTimeForAPI(lastRefreshTimeForAPI)
                .build();

        summonerController.insertSummoner(dto);

        // when
        SummonerDto findDto = summonerController.getSummonerDtoByPuuid(puuid);

        // then
        assertThat(findDto.getAccountId()).isEqualTo(accountId);
        assertThat(findDto.getProfileIconId()).isEqualTo(profileIconId);
        assertThat(findDto.getRevisionDate()).isEqualTo(revisionDate);
        assertThat(findDto.getName()).isEqualTo(name);
        assertThat(findDto.getId()).isEqualTo(id);
        assertThat(findDto.getSummonerLevel()).isEqualTo(summonerLevel);
        assertThat(findDto.getPuuid()).isEqualTo(puuid);
        assertThat(findDto.getLastRefreshTimeForUI()).isEqualTo(lastRefreshTimeForUI);
        assertThat(findDto.getLastRefreshTimeForAPI()).isEqualTo(lastRefreshTimeForAPI);
    }

    private String getLastRefreshTimeForUI(Timestamp rrt)
    {
        String refreshAgoTime = null;

        if (ChronoUnit.HOURS.between(rrt.toLocalDateTime(), LocalDateTime.now()) >= 24)
        {
            refreshAgoTime = String.valueOf(ChronoUnit.DAYS.between(rrt.toLocalDateTime(), LocalDateTime.now()))
                    + "일 전";
        }
        else if (ChronoUnit.MINUTES.between(rrt.toLocalDateTime(), LocalDateTime.now()) >= 60)
        {
            refreshAgoTime = String.valueOf(ChronoUnit.HOURS.between(rrt.toLocalDateTime(), LocalDateTime.now()))
                    + "시간 전";
        }
        else
        {
            refreshAgoTime = String.valueOf(ChronoUnit.MINUTES.between(rrt.toLocalDateTime(), LocalDateTime.now()))
                    + "분 전";
        }

        return refreshAgoTime;
    }
}