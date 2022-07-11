package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.SummonerSpellEntity;
import dev.saariselka.inlol.service.SummonerSpellService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SummonerSpellControllerTest {

    @Autowired
    private SummonerSpellController summonerSpellController;
    @Autowired
    private SummonerSpellService summonerSpellService;


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
        SummonerSpellEntity summonerSpellEntitySaved = summonerSpellService.findByspellKey(spellKey).get(0);

        assertThat(spellKey).isEqualTo(summonerSpellEntitySaved.getSpellKey());
        assertThat(summonerSpellEntitySaved.getSpellKey()).isNotNull();
    }

    @Test
    @DisplayName("Find Entity By Key")
    public void getSummonerSpellByKey() {
        // given
        String summonerSpellNameBarrier = "방어막";
        String summonerSpellNameBooster = "점멸";
        String summonerSpellDescBarrier = "2초 동안 방어막으로 감싸 피해를 115~455(챔피언 레벨에 따라 변동)만큼 흡수합니다.";
        String summonerSpellDescBooster = "챔피언에 걸린 모든 이동 불가와 (제압 및 공중으로 띄우는 효과 제외) 소환사 주문에 의한 해로운 효과를 제거하고 새로 적용되는 이동 불가 효과들의 지속시간을 3초간 65% 감소시킵니다.";
        int summonerSpellKeyBarrier = 21;
        int summonerSpellKeyBooster = 1;
        String summonerSpellImageBarrier = "SummonerBarrier.png";
        String summonerSpellImageBooster = "SummonerBoost.png";

        summonerSpellService.insert(summonerSpellNameBarrier, summonerSpellDescBarrier, summonerSpellKeyBarrier, summonerSpellImageBarrier);
        summonerSpellService.insert(summonerSpellNameBooster, summonerSpellDescBooster, summonerSpellKeyBooster, summonerSpellImageBooster);

        // when
        SummonerSpellEntity summonerSpellEntityBarrierFind = summonerSpellController.getSummonerSpellByKey(summonerSpellKeyBarrier).get(0);
        SummonerSpellEntity summonerSpellEntityBoosterFind = summonerSpellController.getSummonerSpellByKey(summonerSpellKeyBooster).get(0);

        // then
        assertThat(summonerSpellEntityBarrierFind.getSpellKey()).isEqualTo(21);
        assertThat(summonerSpellEntityBarrierFind.getImage()).isEqualTo("SummonerBarrier.png");
        assertThat(summonerSpellEntityBoosterFind.getSpellKey()).isEqualTo(1);
        assertThat(summonerSpellEntityBoosterFind.getImage()).isEqualTo("SummonerBoost.png");
    }
}
