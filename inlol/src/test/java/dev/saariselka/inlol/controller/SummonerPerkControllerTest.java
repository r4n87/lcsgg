package dev.saariselka.inlol.controller;
import dev.saariselka.inlol.dto.SummonerPerkDto;
import dev.saariselka.inlol.entity.SummonerPerkEntity;
import dev.saariselka.inlol.service.SummonerPerkService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SummonerPerkControllerTest {
    @Autowired
    private SummonerPerkController summonerPerkController;
    @Autowired
    private SummonerPerkService summonerPerkService;
    @Autowired
    private DtoMapper dtoMapper;

    @Test
    @DisplayName("Insert Dtos")
    public void insertAll() {
        //given
        SummonerPerkDto summonerPerkDto1 =
                new SummonerPerkDto(
                        12345
                        , "nameEng1"
                        , "한글이름1"
                        , "iconpath1"
                        , "description1");

        SummonerPerkDto summonerPerkDto2 =
                new SummonerPerkDto(
                        67890
                        , "nameEng2"
                        , "한글이름2"
                        , "iconpath2"
                        , "description2");

        List<SummonerPerkDto> summonerPerkDtoList = new ArrayList<>();
        summonerPerkDtoList.add(summonerPerkDto1);
        summonerPerkDtoList.add(summonerPerkDto2);

        //when
        summonerPerkController.insertAll(summonerPerkDtoList);

        //then
        SummonerPerkDto summonerPerkDtoForTest1 = dtoMapper.toSummonerPerkDtoList(summonerPerkService.findByPerkId(summonerPerkDto1.getPerkId())).get(0);
        assertThat(summonerPerkDtoForTest1.getPerkId()).isEqualTo(summonerPerkDto1.getPerkId());
        assertThat(summonerPerkDtoForTest1.getNameEng()).isEqualTo(summonerPerkDto1.getNameEng());
        assertThat(summonerPerkDtoForTest1.getNameKor()).isEqualTo(summonerPerkDto1.getNameKor());
        assertThat(summonerPerkDtoForTest1.getIcon()).isEqualTo(summonerPerkDto1.getIcon());
        assertThat(summonerPerkDtoForTest1.getDescription()).isEqualTo(summonerPerkDto1.getDescription());

        SummonerPerkDto summonerPerkDtoForTest2 = dtoMapper.toSummonerPerkDtoList(summonerPerkService.findByPerkId(summonerPerkDto2.getPerkId())).get(0);
        assertThat(summonerPerkDtoForTest2.getPerkId()).isEqualTo(summonerPerkDto2.getPerkId());
        assertThat(summonerPerkDtoForTest2.getNameEng()).isEqualTo(summonerPerkDto2.getNameEng());
        assertThat(summonerPerkDtoForTest2.getNameKor()).isEqualTo(summonerPerkDto2.getNameKor());
        assertThat(summonerPerkDtoForTest2.getIcon()).isEqualTo(summonerPerkDto2.getIcon());
        assertThat(summonerPerkDtoForTest2.getDescription()).isEqualTo(summonerPerkDto2.getDescription());
    }

    @Test
    @DisplayName("Find Dto By PerkId")
    public void getSummonerPerkByPerkId() {
        //given
        int perkId = 5;
        String nameEng = "English Name";
        String nameKor = "Korean Name";
        String icon = "Icon Path";
        String description = "Description";
        summonerPerkService.insert(perkId, nameEng, nameKor, icon, description);

        //when
        SummonerPerkDto summonerPerkDto = summonerPerkController.getSummonerPerkByPerkId(perkId).get(0);

        //then
        assertThat(summonerPerkDto.getPerkId()).isEqualTo(perkId);
        assertThat(summonerPerkDto.getNameEng()).isEqualTo(nameEng);
        assertThat(summonerPerkDto.getNameKor()).isEqualTo(nameKor);
        assertThat(summonerPerkDto.getIcon()).isEqualTo(icon);
        assertThat(summonerPerkDto.getDescription()).isEqualTo(description);
    }

}
