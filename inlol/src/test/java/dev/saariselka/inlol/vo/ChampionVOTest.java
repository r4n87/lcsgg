package dev.saariselka.inlol.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChampionVOTest {
    @Test
    @DisplayName("Constructor")
    void constructor() {
        // given

        // when
        ChampionVO vo = new ChampionVO(999, "Test", "테스트", "/testimage.png");

        // then
        assertThat(vo.getId()).isEqualTo(999);
        assertThat(vo.getNameEng()).isEqualTo("Test");
        assertThat(vo.getNameKo()).isEqualTo("테스트");
        assertThat(vo.getImagePath()).isEqualTo("/testimage.png");
    }

    @Test
    @DisplayName("Setter")
    void setter() {
        // given
        ChampionVO vo = new ChampionVO(999, "Test", "테스트", "/testimage.png");

        // when
        vo.setId(998);
        vo.setNameEng("Test2");
        vo.setNameKo("테스트2");
        vo.setImagePath("/testImage.png");

        // then
        assertThat(vo.getId()).isEqualTo(998);
        assertThat(vo.getNameEng()).isEqualTo("Test2");
        assertThat(vo.getNameKo()).isEqualTo("테스트2");
        assertThat(vo.getImagePath()).isEqualTo("/testImage.png");

    }

}