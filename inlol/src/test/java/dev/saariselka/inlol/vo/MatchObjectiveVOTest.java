package dev.saariselka.inlol.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchObjectiveVOTest {

    @Test
    @DisplayName("Constructor")
    void constructor() {
        // given

        // when
        MatchObjectiveVO vo = new MatchObjectiveVO(false, 5);

        // then
        assertThat(vo.isFirst()).isFalse();
        assertThat(vo.getKills()).isEqualTo(5);
    }

    @Test
    @DisplayName("Setter")
    void setter() {
        // given
        MatchObjectiveVO vo = new MatchObjectiveVO();

        // when
        vo.setFirst(true);
        vo.setKills(10);

        // then
        assertThat(vo.isFirst()).isTrue();
        assertThat(vo.getKills()).isEqualTo(10);
    }

}