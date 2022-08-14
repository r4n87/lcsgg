package dev.saariselka.inlol.service;


import dev.saariselka.inlol.dto.SummonerPerkDto;
import dev.saariselka.inlol.entity.SummonerPerkEntity;
import dev.saariselka.inlol.repository.SummonerPerkRepository;
import dev.saariselka.inlol.vo.SummonerPerkVO;
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
    @DisplayName("Insert VO")
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
        SummonerPerkVO summonerPerkVOForTest = summonerPerkService.findByPerkId(perkId).get(0);
        assertThat(summonerPerkVOForTest.getPerkId()).isEqualTo(perkId);
        assertThat(summonerPerkVOForTest.getNameEng()).isEqualTo(nameEng);
        assertThat(summonerPerkVOForTest.getNameKor()).isEqualTo(nameKor);
        assertThat(summonerPerkVOForTest.getIcon()).isEqualTo(icon);
        assertThat(summonerPerkVOForTest.getDescription()).isEqualTo(description);
    }

    @Test
    @DisplayName("Find VO By PerkId")
    public void findByPerkId() {
        //given
        int perkId = 98765;
        String nameEng = "NameEng";
        String nameKor = "한글이름";
        String icon = "iconPath";
        String description = "소개글";
        summonerPerkService.insert(perkId, nameEng, nameKor, icon, description);

        //when
        SummonerPerkVO summonerPerkVOForTest = summonerPerkService.findByPerkId(perkId).get(0);

        //then
        assertThat(summonerPerkVOForTest.getPerkId()).isEqualTo(perkId);
        assertThat(summonerPerkVOForTest.getNameEng()).isEqualTo(nameEng);
        assertThat(summonerPerkVOForTest.getNameKor()).isEqualTo(nameKor);
        assertThat(summonerPerkVOForTest.getIcon()).isEqualTo(icon);
        assertThat(summonerPerkVOForTest.getDescription()).isEqualTo(description);
    }
}
