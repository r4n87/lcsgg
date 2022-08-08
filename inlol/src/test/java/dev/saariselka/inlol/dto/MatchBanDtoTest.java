package dev.saariselka.inlol.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchBanDtoTest {

    @Test
    @DisplayName("MatchBanDto Lombok Get Function")
    public void testLombokGetFunction() {

        //given
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;

        //when
        MatchBanDto matchBanDto = new MatchBanDto(matchId, pickTurn, teamId, championId);

        //then
        assertThat(matchBanDto.getMatchId()).isEqualTo(matchId);
        assertThat(matchBanDto.getPickTurn()).isEqualTo(pickTurn);
        assertThat(matchBanDto.getTeamId()).isEqualTo(teamId);
        assertThat(matchBanDto.getChampionId()).isEqualTo(championId);
    }

    @Test
    @DisplayName("MatchBanDto Lombok Set Function")
    public void testLombokSetFunction() {
        //given
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;
        MatchBanDto matchBanDto = new MatchBanDto(matchId, pickTurn, teamId, championId);

        //when
        int testChampionId = 100;
        matchBanDto.setChampionId(testChampionId);

        //then
        assertThat(matchBanDto.getChampionId()).isEqualTo(testChampionId);
    }
}
