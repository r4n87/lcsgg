package dev.saariselka.inlol.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SummonerPerkVOTest {
    @Test
    @DisplayName("SummonerPerkVO Lombok Get Function")
    public void testLombokGetFunction() {
        //given
        int perkId = 12345;
        String nameEng = "EnglishName";
        String nameKor = "한글이름";
        String icon = "iconpath";
        String description = "description1";

        //when
        SummonerPerkVO summonerPerkVO = new SummonerPerkVO(perkId, nameEng, nameKor, icon, description);

        //then
        assertThat(summonerPerkVO.getPerkId()).isEqualTo(perkId);
        assertThat(summonerPerkVO.getNameEng()).isEqualTo(nameEng);
        assertThat(summonerPerkVO.getNameKor()).isEqualTo(nameKor);
        assertThat(summonerPerkVO.getIcon()).isEqualTo(icon);
        assertThat(summonerPerkVO.getDescription()).isEqualTo(description);
    }

    @Test
    @DisplayName("SummonerPerkVO Lombok Set Function")
    public void testLombokSetFunction() {
        //given
        int perkId = 12345;
        String nameEng = "EnglishName";
        String nameKor = "한글이름";
        String icon = "iconpath";
        String description = "description1";
        SummonerPerkVO summonerPerkVO = new SummonerPerkVO(perkId, nameEng, nameKor, icon, description);

        //when
        int perkId2 = 67890;
        String nameEng2 = "NewEnglishName";
        String nameKor2 = "새로운한글이름";
        String icon2 = "newiconpath";
        String description2 = "description2";

        summonerPerkVO.setPerkId(perkId2);
        summonerPerkVO.setNameEng(nameEng2);
        summonerPerkVO.setNameKor(nameKor2);
        summonerPerkVO.setIcon(icon2);
        summonerPerkVO.setDescription(description2);

        //then
        assertThat(summonerPerkVO.getPerkId()).isEqualTo(perkId2);
        assertThat(summonerPerkVO.getNameEng()).isEqualTo(nameEng2);
        assertThat(summonerPerkVO.getNameKor()).isEqualTo(nameKor2);
        assertThat(summonerPerkVO.getIcon()).isEqualTo(icon2);
        assertThat(summonerPerkVO.getDescription()).isEqualTo(description2);
    }
}
