package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueEntryId;
import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

public class LeagueEntryDtoTest {

    @Test
    @DisplayName("LeagueEntryDto Lombok Get Function")
    public void testLombokGetFunction() {
        // Given
        String summonerId = "TestUser";
        String queueType = "RANKED_SOLO_5x5";
        int leagueMiniSeries_losses = 1;
        String progress = "Test";
        int target = 3;
        int leagueMiniSeries_wins = 1;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        String leagueId = "TestLeagueId";
        String summonerName = "TestName";
        String tier = "TestTier";
        String ranks = "TestRank";
        int leaguePoints = 50;
        int leagueEntry_wins = 10;
        int leagueEntry_losses = 5;
        boolean hotStreak = false;
        boolean veteran = false;
        boolean freshBlood = false;
        boolean inactive = false;

        LeagueMiniSeriesEntity leagueMiniSeriesEntity = new LeagueMiniSeriesEntity(new LeagueMiniSeriesId(summonerId,queueType),leagueMiniSeries_losses,progress,target,leagueMiniSeries_wins,rrt);
        LeagueEntryEntity leagueEntryEntity = new LeagueEntryEntity(new LeagueEntryId(summonerId,queueType),leagueId,summonerName,tier,ranks,leaguePoints,leagueEntry_wins,leagueEntry_losses,hotStreak,veteran,freshBlood,inactive,rrt);
        LeagueMiniSeriesDto leagueMiniSeriesDto = new LeagueMiniSeriesDto(leagueMiniSeriesEntity);

        // When
        LeagueEntryDto leagueEntryDto = new LeagueEntryDto(leagueEntryEntity,leagueMiniSeriesDto);

        // Then
        assertThat(leagueEntryDto.getSummonerId()).isEqualTo(summonerId);
        assertThat(leagueEntryDto.getQueueType()).isEqualTo(queueType);
        assertThat(leagueEntryDto.getLeagueId()).isEqualTo(leagueId);
        assertThat(leagueEntryDto.getSummonerName()).isEqualTo(summonerName);
        assertThat(leagueEntryDto.getTier()).isEqualTo(tier);
        assertThat(leagueEntryDto.getRank()).isEqualTo(ranks);
        assertThat(leagueEntryDto.getLeaguePoints()).isEqualTo(leaguePoints);
        assertThat(leagueEntryDto.getWins()).isEqualTo(leagueEntry_wins);
        assertThat(leagueEntryDto.getLosses()).isEqualTo(leagueEntry_losses);
        assertThat(leagueEntryDto.getMiniSeries()).isEqualTo(leagueMiniSeriesDto);
    }

    @Test
    @DisplayName("LeagueEntryDto Lombok Set Function")
    public void testLombokSetFunction() {
        // Given
        String summonerId = "TestUser";
        String tobe_summonerId = "Tobe_TestUser";
        String queueType = "RANKED_SOLO_5x5";
        String tobe_queueType = "RANKED_FLEX_SR";
        int leagueMiniSeries_losses = 1;
        int tobe_leagueMiniSeries_losses = 2;
        String progress = "Test";
        String tobe_progress = "Tobe_Test";
        int target = 3;
        int tobe_target = 4;
        int leagueMiniSeries_wins = 1;
        int tobe_leagueMiniSeries_wins = 2;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        String leagueId = "TestLeagueId";
        String tobe_leagueId = "tobe_TestLeagueId";
        String summonerName = "TestName";
        String tobe_summonerName = "tobe_TestName";
        String tier = "TestTier";
        String tobe_tier = "tobe_TestTier";
        String ranks = "TestRank";
        String tobe_ranks = "tobe_TestRank";
        int leaguePoints = 50;
        int tobe_leaguePoints = 51;
        int leagueEntry_wins = 10;
        int tobe_leagueEntry_wins = 11;
        int leagueEntry_losses = 5;
        int tobe_leagueEntry_losses = 6;
        boolean hotStreak = false;
        boolean veteran = false;
        boolean freshBlood = false;
        boolean inactive = false;

        LeagueMiniSeriesEntity leagueMiniSeriesEntity = new LeagueMiniSeriesEntity(new LeagueMiniSeriesId(summonerId,queueType),leagueMiniSeries_losses,progress,target,leagueMiniSeries_wins,rrt);
        LeagueMiniSeriesEntity tobe_leagueMiniSeriesEntity = new LeagueMiniSeriesEntity(new LeagueMiniSeriesId(tobe_summonerId,tobe_queueType),tobe_leagueMiniSeries_losses,progress,target,tobe_leagueMiniSeries_wins,rrt);
        LeagueMiniSeriesDto leagueMiniSeriesDto = new LeagueMiniSeriesDto(leagueMiniSeriesEntity);
        LeagueMiniSeriesDto tobe_leagueMiniSeriesDto = new LeagueMiniSeriesDto(tobe_leagueMiniSeriesEntity);
        LeagueEntryEntity leagueEntryEntity = new LeagueEntryEntity(new LeagueEntryId(summonerId,queueType),leagueId,summonerName,tier,ranks,leaguePoints,leagueEntry_wins,leagueEntry_losses,hotStreak,veteran,freshBlood,inactive,rrt);
        LeagueEntryDto leagueEntryDto = new LeagueEntryDto(leagueEntryEntity,leagueMiniSeriesDto);

        // When
        leagueEntryDto.setSummonerId(tobe_summonerId);
        leagueEntryDto.setQueueType(tobe_queueType);
        leagueEntryDto.setLeagueId(tobe_leagueId);
        leagueEntryDto.setSummonerName(tobe_summonerName);
        leagueEntryDto.setTier(tobe_tier);
        leagueEntryDto.setRank(tobe_ranks);
        leagueEntryDto.setLeaguePoints(tobe_leaguePoints);
        leagueEntryDto.setWins(tobe_leagueEntry_wins);
        leagueEntryDto.setLosses(tobe_leagueEntry_losses);
        leagueEntryDto.setMiniSeries(tobe_leagueMiniSeriesDto);

        // Then
        assertThat(leagueEntryDto.getSummonerId()).isEqualTo(tobe_summonerId);
        assertThat(leagueEntryDto.getQueueType()).isEqualTo(tobe_queueType);
        assertThat(leagueEntryDto.getLeagueId()).isEqualTo(tobe_leagueId);
        assertThat(leagueEntryDto.getSummonerName()).isEqualTo(tobe_summonerName);
        assertThat(leagueEntryDto.getTier()).isEqualTo(tobe_tier);
        assertThat(leagueEntryDto.getRank()).isEqualTo(tobe_ranks);
        assertThat(leagueEntryDto.getLeaguePoints()).isEqualTo(tobe_leaguePoints);
        assertThat(leagueEntryDto.getWins()).isEqualTo(tobe_leagueEntry_wins);
        assertThat(leagueEntryDto.getLosses()).isEqualTo(tobe_leagueEntry_losses);
        assertThat(leagueEntryDto.getMiniSeries()).isEqualTo(tobe_leagueMiniSeriesDto);
    }
}
