package dev.saariselka.inlol.vo;

import dev.saariselka.inlol.dto.LeagueEntryDto;
import dev.saariselka.inlol.dto.LeagueMiniSeriesDto;
import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueEntryId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

public class LeagueEntryVOTest {

    @Test
    @DisplayName("LeagueEntryVO Lombok Get Function")
    public void testLombokGetFunction() {

        // Given
        String summonerId = "TestUser";
        String queueType = "RANKED_SOLO_5x5";
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

        // When
        LeagueEntryVO leagueEntryVO = new LeagueEntryVO(summonerId,queueType,leagueId,summonerName,tier,ranks,leaguePoints,leagueEntry_wins,leagueEntry_losses,hotStreak,veteran,freshBlood,inactive);

        // Then
        assertThat(leagueEntryVO.getSummonerId()).isEqualTo(summonerId);
        assertThat(leagueEntryVO.getQueueType()).isEqualTo(queueType);
        assertThat(leagueEntryVO.getLeagueId()).isEqualTo(leagueId);
        assertThat(leagueEntryVO.getSummonerName()).isEqualTo(summonerName);
        assertThat(leagueEntryVO.getTier()).isEqualTo(tier);
        assertThat(leagueEntryVO.getRanks()).isEqualTo(ranks);
        assertThat(leagueEntryVO.getLeaguePoints()).isEqualTo(leaguePoints);
        assertThat(leagueEntryVO.getWins()).isEqualTo(leagueEntry_wins);
        assertThat(leagueEntryVO.getLosses()).isEqualTo(leagueEntry_losses);
    }

    @Test
    @DisplayName("LeagueEntryVO Lombok Set Function")
    public void testLombokSetFunction() {
        // Given
        String summonerId = "TestUser";
        String tobe_summonerId = "Tobe_TestUser";
        String queueType = "RANKED_SOLO_5x5";
        String tobe_queueType = "RANKED_FLEX_SR";

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

        LeagueEntryVO leagueEntryVO = new LeagueEntryVO(summonerId,queueType,leagueId,summonerName,tier,ranks,leaguePoints,leagueEntry_wins,leagueEntry_losses,hotStreak,veteran,freshBlood,inactive);

        // When
        leagueEntryVO.setSummonerId(tobe_summonerId);
        leagueEntryVO.setQueueType(tobe_queueType);
        leagueEntryVO.setLeagueId(tobe_leagueId);
        leagueEntryVO.setSummonerName(tobe_summonerName);
        leagueEntryVO.setTier(tobe_tier);
        leagueEntryVO.setRanks(tobe_ranks);
        leagueEntryVO.setLeaguePoints(tobe_leaguePoints);
        leagueEntryVO.setWins(tobe_leagueEntry_wins);
        leagueEntryVO.setLosses(tobe_leagueEntry_losses);

        // Then
        assertThat(leagueEntryVO.getSummonerId()).isEqualTo(tobe_summonerId);
        assertThat(leagueEntryVO.getQueueType()).isEqualTo(tobe_queueType);
        assertThat(leagueEntryVO.getLeagueId()).isEqualTo(tobe_leagueId);
        assertThat(leagueEntryVO.getSummonerName()).isEqualTo(tobe_summonerName);
        assertThat(leagueEntryVO.getTier()).isEqualTo(tobe_tier);
        assertThat(leagueEntryVO.getRanks()).isEqualTo(tobe_ranks);
        assertThat(leagueEntryVO.getLeaguePoints()).isEqualTo(tobe_leaguePoints);
        assertThat(leagueEntryVO.getWins()).isEqualTo(tobe_leagueEntry_wins);
        assertThat(leagueEntryVO.getLosses()).isEqualTo(tobe_leagueEntry_losses);
    }
}
