package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
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
public class MatchObjectivesControllerTest {
    @Autowired
    MatchObjectivesController matchObjectivesController;

    @Test
    @DisplayName("Get Entity By MatchId, TeamId")
    void getMatchObjectivesByMatchIdAndTeamId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        matchObjectivesController.insertObjectivesInfo("KR_9999999999", 100,
                true, 2, false, 40, false, 1,
                true, 1, false, 0, false, 11, rrt);

        // when
        List<MatchObjectivesEntity> entity = matchObjectivesController.getMatchObjectivesByMatchIdAndTeamId("KR_9999999999", 100);
        MatchObjectivesEntity test = entity.get(0);

        // then
        assertThat(test.getMatchObjectivesId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(test.getMatchObjectivesId().getTeamId()).isEqualTo(100);
        assertThat(test.isBaron_first()).isTrue();
        assertThat(test.getBaron_kills()).isEqualTo(2);
        assertThat(test.isChampion_first()).isFalse();
        assertThat(test.getChampion_kills()).isEqualTo(40);
        assertThat(test.isDragon_first()).isFalse();
        assertThat(test.getDragon_kills()).isEqualTo(1);
        assertThat(test.isInhibitor_first()).isTrue();
        assertThat(test.getInhibitor_kills()).isEqualTo(1);
        assertThat(test.isRiftherald_first()).isFalse();
        assertThat(test.getRiftherald_kills()).isEqualTo(0);
        assertThat(test.isTower_first()).isFalse();
        assertThat(test.getTower_kills()).isEqualTo(11);
        assertThat(test.getRrt()).isEqualTo(rrt);
    }
}