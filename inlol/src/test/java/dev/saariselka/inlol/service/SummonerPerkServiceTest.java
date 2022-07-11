package dev.saariselka.inlol.service;


import dev.saariselka.inlol.entity.SummonerPerkEntity;
import dev.saariselka.inlol.repository.SummonerPerkRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SummonerPerkServiceTest {
    @Autowired
    private SummonerPerkService summonerPerkService;

    @Test
    @DisplayName("Insert Entity")
    public void insert() {
        //given
        int perkId = 98765;
        String nameEng = "NameEng";
        String nameKor = "한글이름";
        String icon = "iconPath";
        String description = "소개글";

        //when
        summonerPerkService.insert(perkId, nameEng, nameKor, icon, description);

        //then
        SummonerPerkEntity summonerPerkEntityForTest = summonerPerkService.findByPerkId(perkId).get(0);
        assertThat(summonerPerkEntityForTest.getPerkId()).isEqualTo(perkId);
        assertThat(summonerPerkEntityForTest.getNameEng()).isEqualTo(nameEng);
        assertThat(summonerPerkEntityForTest.getNameKor()).isEqualTo(nameKor);
        assertThat(summonerPerkEntityForTest.getIcon()).isEqualTo(icon);
        assertThat(summonerPerkEntityForTest.getDescription()).isEqualTo(description);
    }

    @Test
    @DisplayName("Find Entity By PerkId")
    public void findByPerkId() {
        //given
        int perkId = 98765;
        String nameEng = "NameEng";
        String nameKor = "한글이름";
        String icon = "iconPath";
        String description = "소개글";
        summonerPerkService.insert(perkId, nameEng, nameKor, icon, description);

        //when
        SummonerPerkEntity summonerPerkEntityForTest = summonerPerkService.findByPerkId(perkId).get(0);

        //then
        assertThat(summonerPerkEntityForTest.getPerkId()).isEqualTo(perkId);
        assertThat(summonerPerkEntityForTest.getNameEng()).isEqualTo(nameEng);
        assertThat(summonerPerkEntityForTest.getNameKor()).isEqualTo(nameKor);
        assertThat(summonerPerkEntityForTest.getIcon()).isEqualTo(icon);
        assertThat(summonerPerkEntityForTest.getDescription()).isEqualTo(description);
    }


}
