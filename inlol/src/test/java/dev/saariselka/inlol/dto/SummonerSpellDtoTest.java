package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.SummonerSpellEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SummonerSpellDtoTest {


    @Test
    @DisplayName("SummonerSpellDto Lombok Get Function")
    public void testLombokGetFunction() {

        //given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";

        //when
        SummonerSpellDto summonerSpellDto = new SummonerSpellDto(name,description,spellKey,image);

        //then
        assertThat(summonerSpellDto.getName()).isEqualTo(name);
        assertThat(summonerSpellDto.getDescription()).isEqualTo(description);
        assertThat(summonerSpellDto.getSpellKey()).isEqualTo(spellKey);
        assertThat(summonerSpellDto.getImage()).isEqualTo(image);
    }

    @Test
    @DisplayName("SummonerSpellDto Lombok Set Function")
    public void testLombokSetFunction() {
        //given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";
        SummonerSpellDto summonerSpellDto = new SummonerSpellDto(name,description,spellKey,image);

        //when
        String testSetFunctionImage = "tetSetFunctionSummonerSpellImage";
        summonerSpellDto.setImage(testSetFunctionImage);

        //then
        assertThat(summonerSpellDto.getImage()).isEqualTo(testSetFunctionImage);
    }
}
