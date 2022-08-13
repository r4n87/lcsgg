package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import dev.saariselka.inlol.entity.MatchObjectivesId;
import dev.saariselka.inlol.vo.MatchObjectivesVO;
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
public class MatchObjectivesServiceTest {
    @Autowired
    MatchObjectivesService matchObjectivesService;

    @Test
    @DisplayName("Find Entity By MatchObjectivesId")
    void findByMatchObjectivesId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        matchObjectivesService.insert("KR_9999999999", 100,
                true, 2, false, 40, false, 1,
                true, 1, false, 0, false, 11, rrt);

        // when
        List<MatchObjectivesVO> vo = matchObjectivesService.findByMatchIdAndTeamId("KR_9999999999", 100);
        MatchObjectivesVO test = vo.get(0);

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