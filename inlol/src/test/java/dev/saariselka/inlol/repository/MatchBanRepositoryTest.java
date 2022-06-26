package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MatchBanRepositoryTest {

    @Autowired
    private MatchBanRepository matchBanRepository;

    @Test
    @DisplayName("MatchBan Entity  Save Test")
    public void saveMatchBanEntity() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;
        
        MatchBanEntity matchBanEntity = new MatchBanEntity(new MatchBanId(matchId, pickTurn, teamId), championId, rrt);

        // when
        MatchBanEntity matchBanEntity_save = matchBanRepository.save(matchBanEntity);

        // then
        assertThat(matchBanEntity.getMatchBanId()).isEqualTo(matchBanEntity_save.getMatchBanId());
        assertThat(matchBanEntity_save.getMatchBanId()).isNotNull();
        assertThat(matchBanRepository.count()).isGreaterThan(0);
    }

    @Test
    @DisplayName("MatchBan Entity FindByMatchBanId Test")
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

        MatchBanEntity matchBanEntityFindFirst = matchBanRepository.findByMatchBanId(matchBanEntitySavedFirst.getMatchBanId()).get(0);
        MatchBanEntity matchBanEntityFindSecond = matchBanRepository.findByMatchBanId(matchBanEntitySavedSecond.getMatchBanId()).get(0);

        // then
        assertThat(matchBanRepository.count()).isGreaterThan(0);
        assertThat(matchBanEntityFindFirst.getMatchBanId().getPickTurn()).isEqualTo(1);
        assertThat(matchBanEntityFindFirst.getChampionId()).isEqualTo(99);
        assertThat(matchBanEntityFindSecond.getMatchBanId().getPickTurn()).isEqualTo(2);
        assertThat(matchBanEntityFindSecond.getChampionId()).isEqualTo(100);
    }

    @Test
    @DisplayName("MatchBan Entity FindByMatchBanId_MatchId Test")
    public void findByMatchBanId_MatchId() {
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
        MatchBanEntity matchBanEntityFindFirst = matchBanRepository.findByMatchBanId_MatchId(matchBanEntitySavedFirst.getMatchBanId().getMatchId()).get(0);
        MatchBanEntity matchBanEntityFindSecond = matchBanRepository.findByMatchBanId_MatchId(matchBanEntitySavedSecond.getMatchBanId().getMatchId()).get(0);

        // then
        assertThat(matchBanRepository.count()).isGreaterThan(0);
        assertThat(matchBanEntityFindFirst.getMatchBanId().getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanEntityFindFirst.getChampionId()).isEqualTo(99);
        assertThat(matchBanEntityFindSecond.getMatchBanId().getMatchId()).isEqualTo("KR_5804413148");
        assertThat(matchBanEntityFindSecond.getChampionId()).isEqualTo(100);
    }

    @Test
    @DisplayName("MatchBan Entity FindByMatchBanId_MatchIdAndMatchBanId_TeamId Test")
    public void findByMatchBanId_MatchIdAndMatchBanId_TeamId() {
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
        MatchBanEntity matchBanEntityFindFirst = matchBanRepository.findByMatchBanId_MatchIdAndMatchBanId_TeamId(matchBanEntitySavedFirst.getMatchBanId().getMatchId(),matchBanEntitySavedFirst.getMatchBanId().getTeamId()).get(0);
        MatchBanEntity matchBanEntityFindSecond = matchBanRepository.findByMatchBanId_MatchIdAndMatchBanId_TeamId(matchBanEntitySavedSecond.getMatchBanId().getMatchId(),matchBanEntitySavedSecond.getMatchBanId().getTeamId()).get(0);

        // then
        assertThat(matchBanRepository.count()).isGreaterThan(0);
        assertThat(matchBanEntityFindFirst.getMatchBanId().getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanEntityFindFirst.getMatchBanId().getTeamId()).isEqualTo(100);
        assertThat(matchBanEntityFindSecond.getMatchBanId().getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchBanEntityFindSecond.getMatchBanId().getTeamId()).isEqualTo(200);
    }
}

