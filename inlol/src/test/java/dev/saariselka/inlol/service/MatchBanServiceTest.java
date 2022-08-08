package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import dev.saariselka.inlol.repository.MatchBanRepository;
import dev.saariselka.inlol.vo.MatchBanVO;
import dev.saariselka.inlol.vo.VOMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MatchBanServiceTest {

    @Autowired
    private MatchBanService matchBanService;
    @Autowired
    private MatchBanRepository matchBanRepository;
    @Autowired
    VOMapper voMapper;

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
        MatchBanVO matchBanVOSaved = voMapper.toMatchBanVOList(matchBanRepository.findByMatchBanId(new MatchBanId(matchId,pickTurn,teamId))).get(0);

        assertThat(matchBanVOSaved.getMatchId()).isEqualTo(matchId);
        assertThat(matchBanVOSaved.getPickTurn()).isEqualTo(pickTurn);
        assertThat(matchBanVOSaved.getTeamId()).isEqualTo(teamId);
        assertThat(matchBanVOSaved.getChampionId()).isEqualTo(championId);
        assertThat(matchBanRepository.count()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Find VO By MatchBanId")
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
        MatchBanVO matchBanVOFindFirst = matchBanService.findByMatchBanId(matchBanEntitySavedFirst.getMatchBanId()).get(0);
        MatchBanVO matchBanVOFindSecond = matchBanService.findByMatchBanId(matchBanEntitySavedSecond.getMatchBanId()).get(0);

        // then
        assertThat(matchBanRepository.count()).isGreaterThan(0);
        assertThat(matchBanVOFindFirst.getPickTurn()).isEqualTo(1);
        assertThat(matchBanVOFindFirst.getChampionId()).isEqualTo(99);
        assertThat(matchBanVOFindSecond.getPickTurn()).isEqualTo(2);
        assertThat(matchBanVOFindSecond.getChampionId()).isEqualTo(100);
    }

    @Test
    @DisplayName("Find VO By MatchId")
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
        MatchBanVO matchBanVOFindFirst = matchBanService.findByMatchId(matchBanEntitySavedFirst.getMatchBanId().getMatchId()).get(0);
        MatchBanVO matchBanVOFindSecond = matchBanService.findByMatchId(matchBanEntitySavedSecond.getMatchBanId().getMatchId()).get(0);

        // then
        assertThat(matchBanRepository.count()).isGreaterThan(0);
        assertThat(matchBanVOFindFirst.getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanVOFindFirst.getChampionId()).isEqualTo(99);
        assertThat(matchBanVOFindSecond.getMatchId()).isEqualTo("KR_5804413148");
        assertThat(matchBanVOFindSecond.getChampionId()).isEqualTo(100);
    }

    @Test
    @DisplayName("Find VO By MatchId, TeamId")
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
        MatchBanVO matchBanVOFindFirst = matchBanService.findByMatchIdAndTeamId(matchBanEntitySavedFirst.getMatchBanId().getMatchId(),matchBanEntitySavedFirst.getMatchBanId().getTeamId()).get(0);
        MatchBanVO matchBanVOFindSecond = matchBanService.findByMatchIdAndTeamId(matchBanEntitySavedSecond.getMatchBanId().getMatchId(),matchBanEntitySavedSecond.getMatchBanId().getTeamId()).get(0);

        // then
        assertThat(matchBanRepository.count()).isGreaterThan(0);
        assertThat(matchBanVOFindFirst.getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanVOFindFirst.getTeamId()).isEqualTo(100);
        assertThat(matchBanVOFindSecond.getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanVOFindSecond.getTeamId()).isEqualTo(200);
    }
}

