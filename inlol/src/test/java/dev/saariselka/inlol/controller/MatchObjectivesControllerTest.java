package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.MatchObjectivesDto;
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
        List<MatchObjectivesDto> dto = matchObjectivesController.getMatchObjectivesByMatchIdAndTeamId("KR_9999999999", 100);
        MatchObjectivesDto test = dto.get(0);

        // then
        assertThat(test.getBaron().isFirst()).isTrue();
        assertThat(test.getBaron().getKills()).isEqualTo(2);
        assertThat(test.getChampion().isFirst()).isFalse();
        assertThat(test.getChampion().getKills()).isEqualTo(40);
        assertThat(test.getDragon().isFirst()).isFalse();
        assertThat(test.getDragon().getKills()).isEqualTo(1);
        assertThat(test.getInhibitor().isFirst()).isTrue();
        assertThat(test.getInhibitor().getKills()).isEqualTo(1);
        assertThat(test.getRiftHeraId().isFirst()).isFalse();
        assertThat(test.getRiftHeraId().getKills()).isEqualTo(0);
        assertThat(test.getTower().isFirst()).isFalse();
        assertThat(test.getTower().getKills()).isEqualTo(11);
    }
}