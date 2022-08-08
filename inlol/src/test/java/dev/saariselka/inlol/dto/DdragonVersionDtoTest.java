package dev.saariselka.inlol.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DdragonVersionDtoTest {
    @Test
    @DisplayName("DdragonVersionDto Lombok Get Function")
    public void testLombokGetFunction() {
        //given
        long id = 123456L;
        String current = "Y";
        String version = "555555";

        //when
        DdragonVersionDto ddragonVersionDto = new DdragonVersionDto(id, version, current);

        //then
        assertThat(ddragonVersionDto.getId()).isEqualTo(id);
        assertThat(ddragonVersionDto.getCurrent()).isEqualTo(current);
        assertThat(ddragonVersionDto.getVersion()).isEqualTo(version);
    }

    @Test
    @DisplayName("DdragonVersionDto Lombok Set Function")
    public void testLombokSetFunction() {
        //given
        long id = 123456L;
        String current = "Y";
        String version = "555555";
        DdragonVersionDto ddragonVersionDto = new DdragonVersionDto(id, version, current);

        //when
        long newId = 654321L;
        String newCurrent = "N";
        String newVersion = "666666";
        ddragonVersionDto.setId(newId);
        ddragonVersionDto.setCurrent(newCurrent);
        ddragonVersionDto.setVersion(newVersion);

        //then
        assertThat(ddragonVersionDto.getId()).isEqualTo(newId);
        assertThat(ddragonVersionDto.getCurrent()).isEqualTo(newCurrent);
        assertThat(ddragonVersionDto.getVersion()).isEqualTo(newVersion);
    }
}
