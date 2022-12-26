package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.dto.ChampionDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class ChampionControllerTest {
    @Autowired
    ChampionController championController;

    @BeforeEach
    void init() {
        List<ChampionDto> dtoList = new ArrayList<>();
        dtoList.add(new ChampionDto(9999, "Aatrox1", "아트록스", "Aatrox.png"));
        dtoList.add(new ChampionDto(9998, "Ahri1", "아리", "Ahri.png"));
        championController.insertAll(dtoList);
    }

    @Test
    @DisplayName("Find imagePath By nameEng")
    void findImagePathByNameEng() {
        // given

        // when
        String nameKo = championController.getImagePathByNameEng("Aatrox1");

        // then
        Assertions.assertThat(nameKo).isEqualTo("Aatrox.png");
    }

    @Test
    @DisplayName("Find nameKo By nameEng")
    void findNameKoByNameEng() {
        // given

        // when
        String nameKo = championController.getNameKoByNameEng("Ahri1");

        // then
        Assertions.assertThat(nameKo).isEqualTo("아리");
    }
}