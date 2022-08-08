package dev.saariselka.inlol.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DdragonVersionVOTest {
    @Test
    @DisplayName("DdragonVersionVO Lombok Get Function")
    public void testLombokGetFunction() {
        //given
        long id = 123456L;
        String current = "Y";
        String version = "555555";

        //when
        DdragonVersionVO ddragonVersionVO = new DdragonVersionVO(id, version, current);

        //then
        assertThat(ddragonVersionVO.getId()).isEqualTo(id);
        assertThat(ddragonVersionVO.getCurrent()).isEqualTo(current);
        assertThat(ddragonVersionVO.getVersion()).isEqualTo(version);
    }

    @Test
    @DisplayName("DdragonVersionVO Lombok Set Function")
    public void testLombokSetFunction() {
        //given
        long id = 123456L;
        String current = "Y";
        String version = "555555";
        DdragonVersionVO ddragonVersionVO = new DdragonVersionVO(id, version, current);

        //when
        long newId = 654321L;
        String newCurrent = "N";
        String newVersion = "666666";
        ddragonVersionVO.setId(newId);
        ddragonVersionVO.setCurrent(newCurrent);
        ddragonVersionVO.setVersion(newVersion);

        //then
        assertThat(ddragonVersionVO.getId()).isEqualTo(newId);
        assertThat(ddragonVersionVO.getCurrent()).isEqualTo(newCurrent);
        assertThat(ddragonVersionVO.getVersion()).isEqualTo(newVersion);
    }
}
