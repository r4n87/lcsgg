package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.ChampionEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ChampionServiceTest {
    @Autowired
    ChampionService championService;

    @BeforeEach
    void init() {
        List<ChampionEntity> entities = new ArrayList<>();
        entities.add(new ChampionEntity(9999, "Aatrox1", "아트록스", "Aatrox.png"));
        entities.add(new ChampionEntity(9998, "Ahri1", "아리", "Ahri.png"));
        championService.insertAll(entities);
    }

    @Test
    @DisplayName("Find imagePath By nameEng")
    void findImagePathByNameEng() {
        // given

        // when
        String nameKo = championService.findImagePathByNameEng("Aatrox1");

        // then
        Assertions.assertThat(nameKo).isEqualTo("Aatrox.png");
    }

    @Test
    @DisplayName("Find nameKo By nameEng")
    void findNameKoByNameEng() {
        // given

        // when
        String nameKo = championService.findNameKoByNameEng("Ahri1");

        // then
        Assertions.assertThat(nameKo).isEqualTo("아리");
    }
}