package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import dev.saariselka.inlol.repository.MatchBanRepository;
import dev.saariselka.inlol.service.MatchBanService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MatchBanControllerTest {

    @Autowired
    private MatchBanController matchBanController;
    @Autowired
    private MatchBanService matchBanService;


    @Test
    @DisplayName("Insert Entity")
    public void insertBanInfo() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;

        // when
        matchBanController.insertBanInfo(matchId,pickTurn,teamId,championId,rrt);

        // then
        MatchBanEntity matchBanEntitySaved = matchBanService.findByMatchBanId(new MatchBanId(matchId,pickTurn,teamId)).get(0);

        assertThat(new MatchBanId(matchId, pickTurn, teamId)).isEqualTo(matchBanEntitySaved.getMatchBanId());
        assertThat(matchBanEntitySaved.getMatchBanId()).isNotNull();
    }

    @Test
    @DisplayName("Find Entity By MatchBanId")
    public void getBansByMatchBanId() {
        // given
        String matchId = "KR_5804413147";
        int pickTurnFirst = 1;
        int pickTurnSecond = 2;
        int teamIdFirst = 100;
        int teamIdSecond = 100;
        int championIdFirst = 99;
        int championIdSecond = 100;

        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        matchBanService.insert(matchId,pickTurnFirst,teamIdFirst,championIdFirst,rrt);
        matchBanService.insert(matchId,pickTurnSecond,teamIdSecond,championIdSecond,rrt);

        // when
        MatchBanEntity matchBanEntityFindFirst = matchBanController.getBansByMatchBanId(matchId,pickTurnFirst,teamIdFirst).get(0);
        MatchBanEntity matchBanEntityFindSecond = matchBanController.getBansByMatchBanId(matchId,pickTurnSecond,teamIdSecond).get(0);

        // then
        assertThat(matchBanEntityFindFirst.getMatchBanId().getPickTurn()).isEqualTo(1);
        assertThat(matchBanEntityFindFirst.getChampionId()).isEqualTo(99);
        assertThat(matchBanEntityFindSecond.getMatchBanId().getPickTurn()).isEqualTo(2);
        assertThat(matchBanEntityFindSecond.getChampionId()).isEqualTo(100);
    }

    @Test
    @DisplayName("Find Entity By MatchBanId.MatchId")
    public void getBansByMatchId() {
        // given
        String matchIdFirst = "KR_5804413147";
        String matchIdSecond = "KR_5804413148";
        int pickTurnFirst = 1;
        int pickTurnSecond = 2;
        int teamIdFirst = 100;
        int teamIdSecond = 100;
        int championIdFirst = 99;
        int championIdSecond = 100;

        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        matchBanService.insert(matchIdFirst,pickTurnFirst,teamIdFirst,championIdFirst,rrt);
        matchBanService.insert(matchIdSecond,pickTurnSecond,teamIdSecond,championIdSecond,rrt);

        // when
        MatchBanEntity matchBanEntityFindFirst = matchBanController.getBansByMatchId(matchIdFirst).get(0);
        MatchBanEntity matchBanEntityFindSecond = matchBanController.getBansByMatchId(matchIdSecond).get(0);

        // then
        assertThat(matchBanEntityFindFirst.getMatchBanId().getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanEntityFindFirst.getChampionId()).isEqualTo(99);
        assertThat(matchBanEntityFindSecond.getMatchBanId().getMatchId()).isEqualTo("KR_5804413148");
        assertThat(matchBanEntityFindSecond.getChampionId()).isEqualTo(100);
    }

    @Test
    @DisplayName("Find Entity By MatchBanId.MatchId, MatchBanId.TeamId")
    public void getBansByMatchBanIdAndTeamId() {
        // given
        String matchId = "KR_5804413147";
        int pickTurnFirst = 1;
        int pickTurnSecond = 2;
        int teamIdFirst = 100;
        int teamIdSecond = 200;
        int championIdFirst = 99;
        int championIdSecond = 100;

        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        matchBanService.insert(matchId,pickTurnFirst,teamIdFirst,championIdFirst,rrt);
        matchBanService.insert(matchId,pickTurnSecond,teamIdSecond,championIdSecond,rrt);

        // when
        MatchBanEntity matchBanEntityFindFirst = matchBanController.getBansByMatchBanIdAndTeamId(matchId,teamIdFirst).get(0);
        MatchBanEntity matchBanEntityFindSecond = matchBanController.getBansByMatchBanIdAndTeamId(matchId,teamIdSecond).get(0);

        // then
        assertThat(matchBanEntityFindFirst.getMatchBanId().getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanEntityFindFirst.getMatchBanId().getTeamId()).isEqualTo(100);
        assertThat(matchBanEntityFindSecond.getMatchBanId().getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanEntityFindSecond.getMatchBanId().getTeamId()).isEqualTo(200);
    }
}

