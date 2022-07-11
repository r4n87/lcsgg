package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.entity.TeamId;
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
public class TeamServiceTest {

    @Autowired
    TeamService teamService;

    @Test
    @DisplayName("Find Entity By TeamId")
    void findEntityByTeamId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        teamService.insert("KR_9999999999", 100, true, rrt);

        // when
        List<TeamEntity> entity = teamService.findByMatchIdAndTeamId(new TeamId("KR_9999999999", 100));
        TeamEntity test = entity.get(0);

        // then
        assertThat(test.getTeamId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(test.getTeamId().getTeamId()).isEqualTo(100);
        assertThat(test.isWin()).isTrue();
        assertThat(test.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Find Entity By TeamId.MatchId")
    void findEntityByMatchId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        teamService.insert("KR_9999999999", 100, true, rrt);

        // when
        List<TeamEntity> entity = teamService.findByMatchId("KR_9999999999");
        TeamEntity test = entity.get(0);

        // then
        assertThat(test.getTeamId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(test.getTeamId().getTeamId()).isEqualTo(100);
        assertThat(test.isWin()).isTrue();
        assertThat(test.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Find All")
    void findAll() {
        // given
        List<TeamEntity> before = teamService.findAll();
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        teamService.insert("KR_9999999999", 100, true, rrt);

        // when
        List<TeamEntity> entity = teamService.findAll();

        // then
        assertThat(entity.size()).isEqualTo(before.size()+1);
    }
}