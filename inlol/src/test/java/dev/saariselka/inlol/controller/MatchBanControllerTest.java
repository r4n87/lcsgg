package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.MatchBanDto;
import dev.saariselka.inlol.entity.MatchBanId;
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
    @Autowired
    DtoMapper dtoMapper;

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
        MatchBanDto matchBanDtoSaved = dtoMapper.toMatchBanDtoList(matchBanService.findByMatchBanId(new MatchBanId(matchId,pickTurn,teamId))).get(0);

        assertThat(matchBanDtoSaved.getMatchId()).isEqualTo(matchId);
        assertThat(matchBanDtoSaved.getPickTurn()).isEqualTo(pickTurn);
        assertThat(matchBanDtoSaved.getTeamId()).isEqualTo(teamId);
        assertThat(matchBanDtoSaved.getChampionId()).isEqualTo(championId);
    }

    @Test
    @DisplayName("Find Dto By MatchBanId")
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
        MatchBanDto matchBanDtoFindFirst = matchBanController.getBansByMatchBanId(matchId,pickTurnFirst,teamIdFirst).get(0);
        MatchBanDto matchBanDtoFindSecond = matchBanController.getBansByMatchBanId(matchId,pickTurnSecond,teamIdSecond).get(0);

        // then
        assertThat(matchBanDtoFindFirst.getPickTurn()).isEqualTo(1);
        assertThat(matchBanDtoFindFirst.getChampionId()).isEqualTo(99);
        assertThat(matchBanDtoFindSecond.getPickTurn()).isEqualTo(2);
        assertThat(matchBanDtoFindSecond.getChampionId()).isEqualTo(100);
    }

    @Test
    @DisplayName("Find Dto By MatchBanId.MatchId")
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
        MatchBanDto matchBanDtoFindFirst = matchBanController.getBansByMatchId(matchIdFirst).get(0);
        MatchBanDto matchBanDtoFindSecond = matchBanController.getBansByMatchId(matchIdSecond).get(0);

        // then
        assertThat(matchBanDtoFindFirst.getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanDtoFindFirst.getChampionId()).isEqualTo(99);
        assertThat(matchBanDtoFindSecond.getMatchId()).isEqualTo("KR_5804413148");
        assertThat(matchBanDtoFindSecond.getChampionId()).isEqualTo(100);
    }

    @Test
    @DisplayName("Find Dto By MatchBanId.MatchId, MatchBanId.TeamId")
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
        MatchBanDto matchBanDtoFindFirst = matchBanController.getBansByMatchBanIdAndTeamId(matchId,teamIdFirst).get(0);
        MatchBanDto matchBanDtoFindSecond = matchBanController.getBansByMatchBanIdAndTeamId(matchId,teamIdSecond).get(0);

        // then
        assertThat(matchBanDtoFindFirst.getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanDtoFindFirst.getTeamId()).isEqualTo(100);
        assertThat(matchBanDtoFindSecond.getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanDtoFindSecond.getTeamId()).isEqualTo(200);
    }
}

