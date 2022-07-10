package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import dev.saariselka.inlol.repository.MatchBanRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MatchBanServiceTest {

    @Autowired
    private MatchBanService matchBanService;
    @Autowired
    private MatchBanRepository matchBanRepository;

    @Test
    @DisplayName("Insert Entity")
    public void insert() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;

        // when
        matchBanService.insert(matchId,pickTurn,teamId,championId,rrt);

        // then
        MatchBanEntity matchBanEntitySaved = matchBanRepository.findByMatchBanId(new MatchBanId(matchId,pickTurn,teamId)).get(0);

        assertThat(new MatchBanId(matchId, pickTurn, teamId)).isEqualTo(matchBanEntitySaved.getMatchBanId());
        assertThat(matchBanEntitySaved.getMatchBanId()).isNotNull();
        assertThat(matchBanRepository.count()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Find Entity By MatchBanId")
    public void findByMatchBanId() {
        // given
        String matchId = "KR_5804413147";
        int pickTurnFirst = 1;
        int pickTurnSecond = 2;
        int teamIdFirst = 100;
        int teamIdSecond = 100;
        int championIdFirst = 99;
        int championIdSecond = 100;

        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        MatchBanEntity matchBanEntityFirst = new MatchBanEntity(new MatchBanId(matchId, pickTurnFirst, teamIdFirst), championIdFirst, rrt);
        MatchBanEntity matchBanEntitySecond = new MatchBanEntity(new MatchBanId(matchId, pickTurnSecond, teamIdSecond), championIdSecond, rrt);

        MatchBanEntity matchBanEntitySavedFirst = matchBanRepository.save(matchBanEntityFirst);
        MatchBanEntity matchBanEntitySavedSecond = matchBanRepository.save(matchBanEntitySecond);

        // when
        MatchBanEntity matchBanEntityFindFirst = matchBanService.findByMatchBanId(matchBanEntitySavedFirst.getMatchBanId()).get(0);
        MatchBanEntity matchBanEntityFindSecond = matchBanService.findByMatchBanId(matchBanEntitySavedSecond.getMatchBanId()).get(0);

        // then
        assertThat(matchBanRepository.count()).isGreaterThan(0);
        assertThat(matchBanEntityFindFirst.getMatchBanId().getPickTurn()).isEqualTo(1);
        assertThat(matchBanEntityFindFirst.getChampionId()).isEqualTo(99);
        assertThat(matchBanEntityFindSecond.getMatchBanId().getPickTurn()).isEqualTo(2);
        assertThat(matchBanEntityFindSecond.getChampionId()).isEqualTo(100);
    }

    @Test
    @DisplayName("Find Entity By MatchBanId.MatchId")
    public void findByMatchId() {
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

        MatchBanEntity matchBanEntityFirst = new MatchBanEntity(new MatchBanId(matchIdFirst, pickTurnFirst, teamIdFirst), championIdFirst, rrt);
        MatchBanEntity matchBanEntitySecond = new MatchBanEntity(new MatchBanId(matchIdSecond, pickTurnSecond, teamIdSecond), championIdSecond, rrt);

        MatchBanEntity matchBanEntitySavedFirst = matchBanRepository.save(matchBanEntityFirst);
        MatchBanEntity matchBanEntitySavedSecond = matchBanRepository.save(matchBanEntitySecond);

        // when
        MatchBanEntity matchBanEntityFindFirst = matchBanService.findByMatchId(matchBanEntitySavedFirst.getMatchBanId().getMatchId()).get(0);
        MatchBanEntity matchBanEntityFindSecond = matchBanService.findByMatchId(matchBanEntitySavedSecond.getMatchBanId().getMatchId()).get(0);

        // then
        assertThat(matchBanRepository.count()).isGreaterThan(0);
        assertThat(matchBanEntityFindFirst.getMatchBanId().getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanEntityFindFirst.getChampionId()).isEqualTo(99);
        assertThat(matchBanEntityFindSecond.getMatchBanId().getMatchId()).isEqualTo("KR_5804413148");
        assertThat(matchBanEntityFindSecond.getChampionId()).isEqualTo(100);
    }

    @Test
    @DisplayName("Find Entity By MatchBanId.MatchId, MatchBanId.TeamId")
    public void findByMatchIdAndTeamId() {
        // given
        String matchId = "KR_5804413147";
        int pickTurnFirst = 1;
        int pickTurnSecond = 2;
        int teamIdFirst = 100;
        int teamIdSecond = 200;
        int championIdFirst = 99;
        int championIdSecond = 100;

        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        MatchBanEntity matchBanEntityFirst = new MatchBanEntity(new MatchBanId(matchId, pickTurnFirst, teamIdFirst), championIdFirst, rrt);
        MatchBanEntity matchBanEntitySecond = new MatchBanEntity(new MatchBanId(matchId, pickTurnSecond, teamIdSecond), championIdSecond, rrt);

        MatchBanEntity matchBanEntitySavedFirst = matchBanRepository.save(matchBanEntityFirst);
        MatchBanEntity matchBanEntitySavedSecond = matchBanRepository.save(matchBanEntitySecond);

        // when
        MatchBanEntity matchBanEntityFindFirst = matchBanService.findByMatchIdAndTeamId(matchBanEntitySavedFirst.getMatchBanId().getMatchId(),matchBanEntitySavedFirst.getMatchBanId().getTeamId()).get(0);
        MatchBanEntity matchBanEntityFindSecond = matchBanService.findByMatchIdAndTeamId(matchBanEntitySavedSecond.getMatchBanId().getMatchId(),matchBanEntitySavedSecond.getMatchBanId().getTeamId()).get(0);

        // then
        assertThat(matchBanRepository.count()).isGreaterThan(0);
        assertThat(matchBanEntityFindFirst.getMatchBanId().getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanEntityFindFirst.getMatchBanId().getTeamId()).isEqualTo(100);
        assertThat(matchBanEntityFindSecond.getMatchBanId().getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanEntityFindSecond.getMatchBanId().getTeamId()).isEqualTo(200);
    }
}

