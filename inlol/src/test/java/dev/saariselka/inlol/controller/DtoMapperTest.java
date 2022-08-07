package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.DtoMapper;
import dev.saariselka.inlol.dto.SummonerDto;
import dev.saariselka.inlol.dto.SummonerSpellDto;
import dev.saariselka.inlol.vo.SummonerSpellVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DtoMapperTest {

    @Autowired
    DtoMapper dtoMapper;

    @Test
    @DisplayName("Convert SummonerSpellDtoList To SummonerSpellVOList")
    public void toSummonerSpellVOList() {

        //given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";
        SummonerSpellDto summonerSpellDto = new SummonerSpellDto(name,description,spellKey,image);
        List<SummonerSpellDto> summonerSpellDtoList = new ArrayList<>();
        summonerSpellDtoList.add(summonerSpellDto);

        //when
        List<SummonerSpellVO> summonerSpellVOList = new ArrayList<>();
        summonerSpellVOList = dtoMapper.toSummonerSpellVOList(summonerSpellDtoList);

        //then
        assertThat(summonerSpellVOList.get(0).getName()).isEqualTo(name);
        assertThat(summonerSpellVOList.get(0).getDescription()).isEqualTo(description);
        assertThat(summonerSpellVOList.get(0).getSpellKey()).isEqualTo(spellKey);
        assertThat(summonerSpellVOList.get(0).getImage()).isEqualTo(image);
    }

    @Test
    @DisplayName("Convert SummonerSpellVOList To SummonerSpellDtoList")
    public void toSummonerSpellDtoList() {

        //given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";
        SummonerSpellVO summonerSpellVO = new SummonerSpellVO(name,description,spellKey,image);
        List<SummonerSpellVO> summonerSpellVOList = new ArrayList<>();
        summonerSpellVOList.add(summonerSpellVO);

        //when
        List<SummonerSpellDto> summonerSpellDtoList = new ArrayList<>();
        summonerSpellDtoList = dtoMapper.toSummonerSpellDtoList(summonerSpellVOList);

        //then
        assertThat(summonerSpellDtoList.get(0).getName()).isEqualTo(name);
        assertThat(summonerSpellDtoList.get(0).getDescription()).isEqualTo(description);
        assertThat(summonerSpellDtoList.get(0).getSpellKey()).isEqualTo(spellKey);
        assertThat(summonerSpellDtoList.get(0).getImage()).isEqualTo(image);
    }
}
