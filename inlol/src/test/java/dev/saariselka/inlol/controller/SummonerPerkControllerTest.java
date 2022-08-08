package dev.saariselka.inlol.controller;
import dev.saariselka.inlol.entity.SummonerPerkEntity;
import dev.saariselka.inlol.service.SummonerPerkService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SummonerPerkControllerTest {
    @Autowired
    private SummonerPerkController summonerPerkController;
    @Autowired
    private SummonerPerkService summonerPerkService;

    @Test
    @DisplayName("Insert Entities")
    public void insertAll() {
        
    }

    @Test
    @DisplayName("Find Entity By PerkId")
    public void getSummonerPerkByPerkId() {
        //given
        int perkId = 5;
        String nameEng = "English Name";
        String nameKor = "Korean Name";
        String icon = "Icon Path";
        String description = "Description";
        summonerPerkService.insert(perkId, nameEng, nameKor, icon, description);

        //when
        SummonerPerkEntity summonerPerkEntity = summonerPerkController.getSummonerPerkByPerkId(perkId).get(0);

        //then
        assertThat(summonerPerkEntity.getPerkId()).isEqualTo(perkId);
        assertThat(summonerPerkEntity.getNameEng()).isEqualTo(nameEng);
        assertThat(summonerPerkEntity.getNameKor()).isEqualTo(nameKor);
        assertThat(summonerPerkEntity.getIcon()).isEqualTo(icon);
        assertThat(summonerPerkEntity.getDescription()).isEqualTo(description);
    }

}
