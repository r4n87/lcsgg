package dev.saariselka.inlol.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChampionDtoTest {

    @Test
    @DisplayName("Constructor")
    void constructor() {
        // given

        // when
        ChampionDto dto = new ChampionDto(999, "Test", "테스트", "/testimage.png");

        // then
        assertThat(dto.getId()).isEqualTo(999);
        assertThat(dto.getNameEng()).isEqualTo("Test");
        assertThat(dto.getNameKo()).isEqualTo("테스트");
        assertThat(dto.getImagePath()).isEqualTo("/testimage.png");

    }

    @Test
    @DisplayName("Setter")
    void setter() {
        // given
        ChampionDto dto = new ChampionDto(999, "Test", "테스트", "/testimage.png");

        // when
        dto.setId(998);
        dto.setNameEng("Test2");
        dto.setNameKo("테스트2");
        dto.setImagePath("/testImage.png");

        // then
        assertThat(dto.getId()).isEqualTo(998);
        assertThat(dto.getNameEng()).isEqualTo("Test2");
        assertThat(dto.getNameKo()).isEqualTo("테스트2");
        assertThat(dto.getImagePath()).isEqualTo("/testImage.png");

    }
}