package dev.saariselka.inlol.facade;

import dev.saariselka.inlol.controller.SummonerController;
import dev.saariselka.inlol.controller.SummonerSpellController;
import dev.saariselka.inlol.dto.SummonerDto;
import dev.saariselka.inlol.entity.SummonerEntity;
import dev.saariselka.inlol.entity.SummonerSpellEntity;
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
public class DBFacadeTest {

    @Autowired
    DBFacade dbFacade;
    @Autowired
    SummonerSpellController summonerSpellController;
    @Autowired
    SummonerController summonerController;

    @Test
    @DisplayName("Find SummonerDto By SummonerName When SummonerName is Null")
    public void getSummonerDtoBySummonerNameWhenSummonerNameIsNull() {
        //given
        String name = null;
        SummonerEntity summonerEntity = null;
        SummonerDto summonerDto = null;

        //when
        String puuid = summonerController.getSummoner_Puuid_ByName(name);
        if(puuid != null)
        {
            summonerEntity = summonerController.getSummoner(puuid).get(0);
            summonerDto = new SummonerDto(summonerEntity);
        }

        //then
        assertThat(summonerDto).isNull();
    }

    @Test
    @DisplayName("Find SummonerDto By SummonerName When SummonerName is Not Null")
    public void getSummonerDtoBySummonerNameWhenSummonerNameIsNotNull() {
        //given
        String name = "Petaluma";

        //when
        String puuid = summonerController.getSummoner_Puuid_ByName(name);
        SummonerEntity summonerEntity = summonerController.getSummoner(puuid).get(0);
        SummonerDto summonerDto = new SummonerDto(summonerEntity);

        //then
        assertThat(summonerDto).isNotNull();
    }

    @Test
    @DisplayName("Find SummonerDto By SummonerName When Invalid SummonerName")
    public void getSummonerDtoBySummonerNameWhenInvalidSummonerName() {
        //given
        String name = "A";
        SummonerEntity summonerEntity = null;
        SummonerDto summonerDto = null;

        //when
        String puuid = summonerController.getSummoner_Puuid_ByName(name);
        if(puuid != null)
        {
            summonerEntity = summonerController.getSummoner(puuid).get(0);
            summonerDto = new SummonerDto(summonerEntity);
        }

        //then
        assertThat(summonerDto).isNull();
    }

    @Test
    @DisplayName("Find Summoner Puuid By SummonerName When SummonerName Is Null")
    public void getSummonerPuuidBySummonerNameWhenSummonerNameIsNull() {

        //given
        String name = null;

        //when
        String puuid = summonerController.getSummoner_Puuid_ByName(name);

        //then
        assertThat(puuid).isNull();
    }

    @Test
    @DisplayName("Find Summoner Puuid By SummonerName When SummonerName Is Not Null")
    public void getSummonerPuuidBySummonerNameWhenSummonerNameIsNotNull() {

        //given
        String name = "Petaluma";

        //when
        String puuid = summonerController.getSummoner_Puuid_ByName(name);

        //then
        assertThat(puuid).isNotNull();
    }

    @Test
    @DisplayName("Find Summoner Puuid By SummonerName When SummonerName Is Not Null")
    public void getSummonerPuuidBySummonerNameWhenInvalidSummonerName() {

        //given
        String name = "A";

        //when
        String puuid = summonerController.getSummoner_Puuid_ByName(name);

        //then
        assertThat(puuid).isNull();
    }

    @Test
    @DisplayName("Save SummonerSpell")
    public void setSummonerSpell()
    {
        // given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";

        List<SummonerSpellEntity> summonerSpellEntities = new ArrayList<>();

        SummonerSpellEntity summonerSpellEntity = new SummonerSpellEntity(name, description, spellKey, image);

        summonerSpellEntities.add(summonerSpellEntity);

        // when
        dbFacade.setSummonerSpell(summonerSpellEntities);

        // then
        SummonerSpellEntity summonerSpellEntitySaved = summonerSpellController.getSummonerSpellByKey(spellKey).get(0);

        assertThat(spellKey).isEqualTo(summonerSpellEntitySaved.getSpellKey());
        assertThat(summonerSpellEntitySaved.getSpellKey()).isNotNull();
    }

    @Test
    @DisplayName("Find SummonerSpellImage By SummonerSpellKey")
    public void getSummonerSpellByKey()
    {
        //given
        String summonerSpellNameBarrier = "방어막";
        String summonerSpellNameBooster = "점멸";
        String summonerSpellDescBarrier = "2초 동안 방어막으로 감싸 피해를 115~455(챔피언 레벨에 따라 변동)만큼 흡수합니다.";
        String summonerSpellDescBooster = "챔피언에 걸린 모든 이동 불가와 (제압 및 공중으로 띄우는 효과 제외) 소환사 주문에 의한 해로운 효과를 제거하고 새로 적용되는 이동 불가 효과들의 지속시간을 3초간 65% 감소시킵니다.";
        int summonerSpellKeyBarrier = 21;
        int summonerSpellKeyBooster = 1;
        String summonerSpellImageBarrier = "SummonerBarrier.png";
        String summonerSpellImageBooster = "SummonerBoost.png";

        summonerSpellController.insertSummonerSpell(summonerSpellNameBarrier, summonerSpellDescBarrier, summonerSpellKeyBarrier, summonerSpellImageBarrier);
        summonerSpellController.insertSummonerSpell(summonerSpellNameBooster, summonerSpellDescBooster, summonerSpellKeyBooster, summonerSpellImageBooster);

        //when
        String summonerSpellImageBarrierFind = dbFacade.getSummonerSpellImageByKey(summonerSpellKeyBarrier);
        String summonerSpellImageBoosterFind = dbFacade.getSummonerSpellImageByKey(summonerSpellKeyBooster);

        //then
        assertThat(summonerSpellImageBarrierFind).isEqualTo("SummonerBarrier.png");
        assertThat(summonerSpellImageBoosterFind).isEqualTo("SummonerBoost.png");
    }
}
