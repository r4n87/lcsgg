package dev.saariselka.inlol.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

public class MatchObjectivesVOTest {
    @Test
    @DisplayName("Constructor")
    void constructor() {
        // given
        MatchObjectiveVO baron = new MatchObjectiveVO(true, 1);
        MatchObjectiveVO champion = new MatchObjectiveVO(false, 2);
        MatchObjectiveVO dragon = new MatchObjectiveVO(true, 3);
        MatchObjectiveVO inhibitor = new MatchObjectiveVO(false, 4);
        MatchObjectiveVO riftHeraId = new MatchObjectiveVO(true, 5);
        MatchObjectiveVO tower = new MatchObjectiveVO(false, 6);

        // when
        MatchObjectivesVO vo = new MatchObjectivesVO(baron, champion, dragon, inhibitor, riftHeraId, tower);

        // then
        assertThat(vo.getBaron().isFirst()).isTrue();
        assertThat(vo.getBaron().getKills()).isEqualTo(1);
        assertThat(vo.getChampion().isFirst()).isFalse();
        assertThat(vo.getChampion().getKills()).isEqualTo(2);
        assertThat(vo.getDragon().isFirst()).isTrue();
        assertThat(vo.getDragon().getKills()).isEqualTo(3);
        assertThat(vo.getInhibitor().isFirst()).isFalse();
        assertThat(vo.getInhibitor().getKills()).isEqualTo(4);
        assertThat(vo.getRiftHeraId().isFirst()).isTrue();
        assertThat(vo.getRiftHeraId().getKills()).isEqualTo(5);
        assertThat(vo.getTower().isFirst()).isFalse();
        assertThat(vo.getTower().getKills()).isEqualTo(6);
    }

    @Test
    @DisplayName("Setter")
    void setter() {
        // given
        MatchObjectivesVO vo = new MatchObjectivesVO();
        MatchObjectiveVO baron = new MatchObjectiveVO(true, 1);
        MatchObjectiveVO champion = new MatchObjectiveVO(false, 2);
        MatchObjectiveVO dragon = new MatchObjectiveVO(true, 3);
        MatchObjectiveVO inhibitor = new MatchObjectiveVO(false, 4);
        MatchObjectiveVO riftHeraId = new MatchObjectiveVO(true, 5);
        MatchObjectiveVO tower = new MatchObjectiveVO(false, 6);

        // when
        vo.setBaron(baron);
        vo.setChampion(champion);
        vo.setDragon(dragon);
        vo.setInhibitor(inhibitor);
        vo.setRiftHeraId(riftHeraId);
        vo.setTower(tower);

        // then
        assertThat(vo.getBaron().isFirst()).isTrue();
        assertThat(vo.getBaron().getKills()).isEqualTo(1);
        assertThat(vo.getChampion().isFirst()).isFalse();
        assertThat(vo.getChampion().getKills()).isEqualTo(2);
        assertThat(vo.getDragon().isFirst()).isTrue();
        assertThat(vo.getDragon().getKills()).isEqualTo(3);
        assertThat(vo.getInhibitor().isFirst()).isFalse();
        assertThat(vo.getInhibitor().getKills()).isEqualTo(4);
        assertThat(vo.getRiftHeraId().isFirst()).isTrue();
        assertThat(vo.getRiftHeraId().getKills()).isEqualTo(5);
        assertThat(vo.getTower().isFirst()).isFalse();
        assertThat(vo.getTower().getKills()).isEqualTo(6);
    }

}