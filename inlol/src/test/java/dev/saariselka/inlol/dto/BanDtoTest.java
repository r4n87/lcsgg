package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

public class BanDtoTest {

    @Test
    public void testLombokGetFunction() {
        // Given
        String matchId = "KR_5804413147";
        int championId = 99;
        int pickTurn = 1;
        int teamId = 100;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        MatchBanEntity matchBanEntity = new MatchBanEntity(new MatchBanId(matchId, pickTurn, teamId), championId, rrt);

        // When
        BanDto banDto = new BanDto(matchBanEntity);

        // Then
        assertThat(banDto.getChampionId()).isEqualTo(String.valueOf(championId));
        assertThat(banDto.getPickTurn()).isEqualTo(String.valueOf(pickTurn));
    }

    @Test
    public void testLombokSetFunction() {
        // Given
        String matchId = "KR_5804413147";
        int championId = 99;
        String tobe_championId = "100";
        int pickTurn = 1;
        String tobe_pickTurn = "2";
        int teamId = 100;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        MatchBanEntity matchBanEntity = new MatchBanEntity(new MatchBanId(matchId, pickTurn, teamId), championId, rrt);
        BanDto banDto = new BanDto(matchBanEntity);

        // When
        banDto.setChampionId(tobe_championId);
        banDto.setPickTurn(tobe_pickTurn);

        // Then
        assertThat(banDto.getChampionId()).isEqualTo(tobe_championId);
        assertThat(banDto.getPickTurn()).isEqualTo(tobe_pickTurn);
    }
}
