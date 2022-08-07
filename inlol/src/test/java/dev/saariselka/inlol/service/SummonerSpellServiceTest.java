package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.SummonerSpellEntity;
import dev.saariselka.inlol.repository.SummonerSpellRepository;
import dev.saariselka.inlol.vo.SummonerSpellVO;
import dev.saariselka.inlol.vo.VOMapper;
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
public class SummonerSpellServiceTest {

    @Autowired
    private SummonerSpellService summonerSpellService;
    @Autowired
    private SummonerSpellRepository summonerSpellRepository;
    @Autowired
    private VOMapper voMapper;

    @Test
    @DisplayName("Insert Entity")
    public void insert() {
        // given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";

        // when
        summonerSpellService.insert(name, description, spellKey, image);

        // then
        SummonerSpellVO summonerSpellVOSaved = voMapper.toSummonerSpellVOList(summonerSpellRepository.findByspellKey(spellKey)).get(0);

        assertThat(spellKey).isEqualTo(summonerSpellVOSaved.getSpellKey());
        assertThat(summonerSpellVOSaved.getSpellKey()).isNotNull();
        assertThat(summonerSpellRepository.count()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Insert Entities")
    public void insertAll() {
        // given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";

        List<SummonerSpellVO> summonerSpellVOList = new ArrayList<>();
        SummonerSpellVO summonerSpellVO = new SummonerSpellVO(name,description,spellKey,image);
        summonerSpellVOList.add(summonerSpellVO);

        // when
        summonerSpellService.insertAll(summonerSpellVOList);

        // then
        SummonerSpellVO summonerSpellVOSaved = voMapper.toSummonerSpellVOList(summonerSpellRepository.findByspellKey(spellKey)).get(0);

        assertThat(spellKey).isEqualTo(summonerSpellVOSaved.getSpellKey());
        assertThat(summonerSpellVOSaved.getSpellKey()).isNotNull();
        assertThat(summonerSpellRepository.count()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Find Entity By Key")
    public void findByKey() {
        // given
        String summonerSpellNameBarrier = "방어막";
        String summonerSpellNameBooster = "점멸";
        String summonerSpellDescBarrier = "2초 동안 방어막으로 감싸 피해를 115~455(챔피언 레벨에 따라 변동)만큼 흡수합니다.";
        String summonerSpellDescBooster = "챔피언에 걸린 모든 이동 불가와 (제압 및 공중으로 띄우는 효과 제외) 소환사 주문에 의한 해로운 효과를 제거하고 새로 적용되는 이동 불가 효과들의 지속시간을 3초간 65% 감소시킵니다.";
        int summonerSpellKeyBarrier = 21;
        int summonerSpellKeyBooster = 1;
        String summonerSpellImageBarrier = "SummonerBarrier.png";
        String summonerSpellImageBooster = "SummonerBoost.png";

        SummonerSpellEntity summonerSpellEntityBarrier = new SummonerSpellEntity(summonerSpellNameBarrier, summonerSpellDescBarrier, summonerSpellKeyBarrier, summonerSpellImageBarrier);
        SummonerSpellEntity summonerSpellEntityBooster = new SummonerSpellEntity(summonerSpellNameBooster, summonerSpellDescBooster, summonerSpellKeyBooster, summonerSpellImageBooster);

        SummonerSpellEntity summonerSpellEntityBarrierSave = summonerSpellRepository.save(summonerSpellEntityBarrier);
        SummonerSpellEntity summonerSpellEntityBoosterSave = summonerSpellRepository.save(summonerSpellEntityBooster);

        // when
        SummonerSpellVO summonerSpellVOBarrierFind = summonerSpellService.findByspellKey(summonerSpellEntityBarrierSave.getSpellKey()).get(0);
        SummonerSpellVO summonerSpellVOBoosterFind = summonerSpellService.findByspellKey(summonerSpellEntityBoosterSave.getSpellKey()).get(0);

        // then
        assertThat(summonerSpellRepository.count()).isGreaterThan(0);
        assertThat(summonerSpellVOBarrierFind.getSpellKey()).isEqualTo(21);
        assertThat(summonerSpellVOBarrierFind.getImage()).isEqualTo("SummonerBarrier.png");
        assertThat(summonerSpellVOBoosterFind.getSpellKey()).isEqualTo(1);
        assertThat(summonerSpellVOBoosterFind.getImage()).isEqualTo("SummonerBoost.png");
    }
}
