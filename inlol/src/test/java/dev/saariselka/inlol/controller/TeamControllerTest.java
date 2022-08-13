package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.TeamDto;
import dev.saariselka.inlol.entity.TeamEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class TeamControllerTest {

    @Autowired
    TeamController teamController;

    @Test
    @DisplayName("Get Entity By MatchId, TeamId")
    void getEntityByMatchIdAndTeamId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        teamController.insertTeamInfo("KR_9999999999", 100, true, rrt);

        // when
        List<TeamDto> dtoList = teamController.getTeamsByMatchIdAndTeamId("KR_9999999999",100);
        TeamDto test = dtoList.get(0);

        // then
        //assertThat(test.getTeamId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(test.getTeamId()).isEqualTo("100");
        assertThat(test.getWin()).isEqualTo("true");

    }

    @Test
    @DisplayName("Get Entity By MatchId")
    void getEntityByMatchId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        teamController.insertTeamInfo("KR_9999999999", 100, true, rrt);

        // when
        List<TeamDto> dtoList = teamController.getTeamsByMatchId("KR_9999999999");
        TeamDto test = dtoList.get(0);

        // then
        //assertThat(test.getTeamId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(test.getTeamId()).isEqualTo("100");
        assertThat(test.getWin()).isEqualTo("true");
    }

}