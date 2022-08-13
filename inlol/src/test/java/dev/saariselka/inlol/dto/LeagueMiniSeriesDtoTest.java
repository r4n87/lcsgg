package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

public class LeagueMiniSeriesDtoTest {

    @Test
    @DisplayName("LeagueMiniSeriesDto Lombok Get Function")
    public void testLombokGetFunction() {
        // Given
        String summonerId = "TestUser";
        String queueType = "RANKED_SOLO_5x5";
        int losses = 1;
        String progress = "Test";
        int target = 3;
        int wins = 1;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        // When
        LeagueMiniSeriesDto leagueMiniSeriesDto = new LeagueMiniSeriesDto(summonerId,queueType,wins,losses,target,progress.toCharArray());

        // Then
        assertThat(leagueMiniSeriesDto.getSummonerId()).isEqualTo(summonerId);
        assertThat(leagueMiniSeriesDto.getQueueType()).isEqualTo(queueType);
        assertThat(leagueMiniSeriesDto.getLosses()).isEqualTo(losses);
        assertThat(leagueMiniSeriesDto.getProgress()).isEqualTo(progress.toCharArray());
        assertThat(leagueMiniSeriesDto.getTarget()).isEqualTo(target);
        assertThat(leagueMiniSeriesDto.getWins()).isEqualTo(wins);
    }

    @Test
    @DisplayName("LeagueMiniSeriesDto Lombok Set Function")
    public void testLombokSetFunction() {
        // Given
        String summonerId = "TestUser";
        String tobe_summonerId = "Tobe_TestUser";
        String queueType = "RANKED_SOLO_5x5";
        String tobe_queueType = "RANKED_FLEX_SR";
        int losses = 1;
        int tobe_losses = 2;
        String progress = "Test";
        String tobe_progress = "Tobe_Test";
        int target = 3;
        int tobe_target = 4;
        int wins = 1;
        int tobe_wins = 2;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        LeagueMiniSeriesDto leagueMiniSeriesDto = new LeagueMiniSeriesDto(summonerId,queueType,wins,losses,target,progress.toCharArray());

        // When
        leagueMiniSeriesDto.setSummonerId(tobe_summonerId);
        leagueMiniSeriesDto.setQueueType(tobe_queueType);
        leagueMiniSeriesDto.setLosses(tobe_losses);
        leagueMiniSeriesDto.setProgress(tobe_progress.toCharArray());
        leagueMiniSeriesDto.setTarget(tobe_target);
        leagueMiniSeriesDto.setWins(tobe_wins);

        // Then
        assertThat(leagueMiniSeriesDto.getSummonerId()).isEqualTo(tobe_summonerId);
        assertThat(leagueMiniSeriesDto.getQueueType()).isEqualTo(tobe_queueType);
        assertThat(leagueMiniSeriesDto.getLosses()).isEqualTo(tobe_losses);
        assertThat(leagueMiniSeriesDto.getProgress()).isEqualTo(tobe_progress.toCharArray());
        assertThat(leagueMiniSeriesDto.getTarget()).isEqualTo(tobe_target);
        assertThat(leagueMiniSeriesDto.getWins()).isEqualTo(tobe_wins);
    }
}
