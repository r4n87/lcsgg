package dev.saariselka.inlol.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeagueMiniseriesVOTest {

    @Test
    @DisplayName("LeagueMiniSeriesVO Lombok Get Function")
    public void testLombokGetFunction() {

        //given
        String summonerId = "testSummonerId";
        String queueType = "RANKED_SOLO_5x5";
        int target = 3;
        int wins = 2;
        int losses = 1;
        String progress = "Test";

        //when
        LeagueMiniSeriesVO leagueMiniSeriesVO = new LeagueMiniSeriesVO(summonerId,queueType,losses,progress,target,wins);

        //then
        assertThat(leagueMiniSeriesVO.getSummonerId()).isEqualTo(summonerId);
        assertThat(leagueMiniSeriesVO.getQueueType()).isEqualTo(queueType);
        assertThat(leagueMiniSeriesVO.getLosses()).isEqualTo(losses);
        assertThat(leagueMiniSeriesVO.getProgress()).isEqualTo(progress);
        assertThat(leagueMiniSeriesVO.getTarget()).isEqualTo(target);
        assertThat(leagueMiniSeriesVO.getWins()).isEqualTo(wins);
    }

    @Test
    @DisplayName("LeagueMiniSeriesVO Lombok Set Function")
    public void testLombokSetFunction() {
        //given
        String summonerId = "testSummonerId";
        String queueType = "RANKED_SOLO_5x5";
        int target = 3;
        int wins = 2;
        int losses = 1;
        String progress = "Test";
        LeagueMiniSeriesVO leagueMiniSeriesVO = new LeagueMiniSeriesVO(summonerId,queueType,losses,progress,target,wins);

        //when
        String testProgress = "TestProgress";
        leagueMiniSeriesVO.setProgress(testProgress);

        //then
        assertThat(leagueMiniSeriesVO.getProgress()).isEqualTo(testProgress);
    }
}
