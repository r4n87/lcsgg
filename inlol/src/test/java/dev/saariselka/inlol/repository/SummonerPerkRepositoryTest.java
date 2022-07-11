package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.SummonerPerkEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SummonerPerkRepositoryTest {
    @Autowired
    private SummonerPerkRepository summonerPerkRepository;

    @Test
    @DisplayName("Save Entity")
    public void saveSummonerPerkEntity() {
        //given
        int perkId = 98765;
        String nameEng = "NameEng";
        String nameKor = "한글이름";
        String icon = "iconPath";
        String description = "소개글";

        //when
        SummonerPerkEntity summonerPerkEntity = new SummonerPerkEntity(perkId, nameEng, nameKor, icon, description);
        SummonerPerkEntity summonerPerkEntityForTest = summonerPerkRepository.save(summonerPerkEntity);

        //then
        assertThat(summonerPerkEntityForTest.getPerkId()).isEqualTo(summonerPerkEntity.getPerkId());
        assertThat(summonerPerkEntityForTest.getNameEng()).isEqualTo(summonerPerkEntity.getNameEng());
        assertThat(summonerPerkEntityForTest.getNameKor()).isEqualTo(summonerPerkEntity.getNameKor());
        assertThat(summonerPerkEntityForTest.getIcon()).isEqualTo(summonerPerkEntity.getIcon());
        assertThat(summonerPerkEntityForTest.getDescription()).isEqualTo(summonerPerkEntity.getDescription());
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
        SummonerPerkEntity summonerPerkEntity = new SummonerPerkEntity(perkId, nameEng, nameKor, icon, description);
        SummonerPerkEntity summonerPerkEntityForTest = summonerPerkRepository.save(summonerPerkEntity);

        //when
        SummonerPerkEntity summonerPerkEntityFindByPerkId = summonerPerkRepository.findByPerkId(summonerPerkEntityForTest.getPerkId()).get(0);


        //then
        assertThat(summonerPerkEntityFindByPerkId.getPerkId()).isEqualTo(summonerPerkEntityForTest.getPerkId());
        assertThat(summonerPerkEntityFindByPerkId.getNameEng()).isEqualTo(summonerPerkEntityForTest.getNameEng());
        assertThat(summonerPerkEntityFindByPerkId.getNameKor()).isEqualTo(summonerPerkEntityForTest.getNameKor());
        assertThat(summonerPerkEntityFindByPerkId.getIcon()).isEqualTo(summonerPerkEntityForTest.getIcon());
        assertThat(summonerPerkEntityFindByPerkId.getDescription()).isEqualTo(summonerPerkEntityForTest.getDescription());
    }


}
