package dev.saariselka.inlol.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SummonerSpellVOTest {

    @Test
    @DisplayName("SummonerSpellVO Lombok Get Function")
    public void testLombokGetFunction() {

        //given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";

        //when
        SummonerSpellVO summonerSpellVO = new SummonerSpellVO(name,description,spellKey,image);

        //then
        assertThat(summonerSpellVO.getName()).isEqualTo(name);
        assertThat(summonerSpellVO.getDescription()).isEqualTo(description);
        assertThat(summonerSpellVO.getSpellKey()).isEqualTo(spellKey);
        assertThat(summonerSpellVO.getImage()).isEqualTo(image);
    }

    @Test
    @DisplayName("SummonerSpellVO Lombok Set Function")
    public void testLombokSetFunction() {
        //given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";
        SummonerSpellVO summonerSpellVO = new SummonerSpellVO(name,description,spellKey,image);

        //when
        String testSetFunctionImage = "tetSetFunctionSummonerSpellImage";
        summonerSpellVO.setImage(testSetFunctionImage);

        //then
        assertThat(summonerSpellVO.getImage()).isEqualTo(testSetFunctionImage);
    }
}
