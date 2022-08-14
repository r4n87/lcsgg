package dev.saariselka.inlol.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SummonerPerkDtoTest {
    @Test
    @DisplayName("Lombok Get Function")
    public void testLombokGetFunction() {
        //given
        int perkId = 12345;
        String nameEng = "nameEng";
        String nameKor = "한글이름";
        String icon = "iconpath";
        String description = "description";

        //when
        SummonerPerkDto summonerPerkDto = new SummonerPerkDto(perkId, nameEng, nameKor, icon, description);

        //then
        assertThat(summonerPerkDto.getPerkId()).isEqualTo(perkId);
        assertThat(summonerPerkDto.getNameEng()).isEqualTo(nameEng);
        assertThat(summonerPerkDto.getNameKor()).isEqualTo(nameKor);
        assertThat(summonerPerkDto.getIcon()).isEqualTo(icon);
        assertThat(summonerPerkDto.getDescription()).isEqualTo(description);
    }

    @Test
    @DisplayName("Lombok Set Function")
    public void testLombokSetFunction() {
        //given
        int perkId = 12345;
        String nameEng = "nameEng";
        String nameKor = "한글이름";
        String icon = "iconpath";
        String description = "description";
        SummonerPerkDto summonerPerkDto = new SummonerPerkDto(perkId, nameEng, nameKor, icon, description);

        //when
        int perkId2 = 67890;
        String nameEng2 = "nameEng2";
        String nameKor2 = "한글이름2";
        String icon2 = "iconpath2";
        String description2 = "description2";
        summonerPerkDto.setPerkId(perkId2);
        summonerPerkDto.setNameEng(nameEng2);
        summonerPerkDto.setNameKor(nameKor2);
        summonerPerkDto.setIcon(icon2);
        summonerPerkDto.setDescription(description2);

        //then
        assertThat(summonerPerkDto.getPerkId()).isEqualTo(perkId2);
        assertThat(summonerPerkDto.getNameEng()).isEqualTo(nameEng2);
        assertThat(summonerPerkDto.getNameKor()).isEqualTo(nameKor2);
        assertThat(summonerPerkDto.getIcon()).isEqualTo(icon2);
        assertThat(summonerPerkDto.getDescription()).isEqualTo(description2);
    }
}
