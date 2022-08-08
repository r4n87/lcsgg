package dev.saariselka.inlol.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchBanVOTest {

    @Test
    @DisplayName("MatchBanVO Lombok Get Function")
    public void testLombokGetFunction() {

        //given
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;

        //when
        MatchBanVO matchBanVO = new MatchBanVO(matchId, pickTurn, teamId, championId);

        //then
        assertThat(matchBanVO.getMatchId()).isEqualTo(matchId);
        assertThat(matchBanVO.getPickTurn()).isEqualTo(pickTurn);
        assertThat(matchBanVO.getTeamId()).isEqualTo(teamId);
        assertThat(matchBanVO.getChampionId()).isEqualTo(championId);
    }

    @Test
    @DisplayName("MatchBanVO Lombok Set Function")
    public void testLombokSetFunction() {
        //given
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;
        MatchBanVO matchBanVO = new MatchBanVO(matchId, pickTurn, teamId, championId);

        //when
        int testChampionId = 100;
        matchBanVO.setChampionId(testChampionId);

        //then
        assertThat(matchBanVO.getChampionId()).isEqualTo(testChampionId);
    }
}
