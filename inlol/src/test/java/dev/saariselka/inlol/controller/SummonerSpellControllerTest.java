package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.SummonerSpellDto;
import dev.saariselka.inlol.service.SummonerSpellService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SummonerSpellControllerTest {

    @Autowired
    private SummonerSpellController summonerSpellController;
    @Autowired
    private SummonerSpellService summonerSpellService;
    @Autowired
    private DtoMapper dtoMapper;


    @Test
    @DisplayName("Insert Entity")
    public void insertSummonerSpell() {
        // given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";

        // when
        summonerSpellController.insertSummonerSpell(name, description, spellKey, image);

        // then
        SummonerSpellDto summonerSpellDtoSaved = dtoMapper.toSummonerSpellDtoList(summonerSpellService.findByspellKey(spellKey)).get(0);

        assertThat(spellKey).isEqualTo(summonerSpellDtoSaved.getSpellKey());
        assertThat(summonerSpellDtoSaved.getSpellKey()).isNotNull();
    }

    @Test
    @DisplayName("Insert Entities")
    public void insertAllSummonerSpell() {
        // given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";

        List<SummonerSpellDto> summonerSpellDtos = new ArrayList<>();
        SummonerSpellDto summonerSpellDto = new SummonerSpellDto(name,description,spellKey,image);
        summonerSpellDtos.add(summonerSpellDto);

        // when
        summonerSpellController.insertAllSummonerSpell(summonerSpellDtos);

        // then
        SummonerSpellDto summonerSpellDtoSaved = dtoMapper.toSummonerSpellDtoList(summonerSpellService.findByspellKey(spellKey)).get(0);

        assertThat(spellKey).isEqualTo(summonerSpellDtoSaved.getSpellKey());
        assertThat(summonerSpellDtoSaved.getSpellKey()).isNotNull();
    }

    @Test
    @DisplayName("Find Entity By Key")
    public void getSummonerSpellByKey() {
        // given
        String summonerSpellNameBarrier = "?????????";
        String summonerSpellNameBooster = "??????";
        String summonerSpellDescBarrier = "2??? ?????? ??????????????? ?????? ????????? 115~455(????????? ????????? ?????? ??????)?????? ???????????????.";
        String summonerSpellDescBooster = "???????????? ?????? ?????? ?????? ????????? (?????? ??? ???????????? ????????? ?????? ??????) ????????? ????????? ?????? ????????? ????????? ???????????? ?????? ???????????? ?????? ?????? ???????????? ??????????????? 3?????? 65% ??????????????????.";
        int summonerSpellKeyBarrier = 21;
        int summonerSpellKeyBooster = 1;
        String summonerSpellImageBarrier = "SummonerBarrier.png";
        String summonerSpellImageBooster = "SummonerBoost.png";

        summonerSpellService.insert(summonerSpellNameBarrier, summonerSpellDescBarrier, summonerSpellKeyBarrier, summonerSpellImageBarrier);
        summonerSpellService.insert(summonerSpellNameBooster, summonerSpellDescBooster, summonerSpellKeyBooster, summonerSpellImageBooster);

        // when
        SummonerSpellDto summonerSpellDtoBarrierFind = summonerSpellController.getSummonerSpellByKey(summonerSpellKeyBarrier).get(0);
        SummonerSpellDto summonerSpellDtoBoosterFind = summonerSpellController.getSummonerSpellByKey(summonerSpellKeyBooster).get(0);

        // then
        assertThat(summonerSpellDtoBarrierFind.getSpellKey()).isEqualTo(21);
        assertThat(summonerSpellDtoBarrierFind.getImage()).isEqualTo("SummonerBarrier.png");
        assertThat(summonerSpellDtoBoosterFind.getSpellKey()).isEqualTo(1);
        assertThat(summonerSpellDtoBoosterFind.getImage()).isEqualTo("SummonerBoost.png");
    }
}
