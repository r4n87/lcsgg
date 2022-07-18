package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.ChampionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ChampionRepositoryTest {
    @Autowired
    ChampionRepository championRepository;


    @Test
    @DisplayName("Find Entity By nameEng")
    void findByNameEng() {
        // given
        ChampionEntity entity = new ChampionEntity(9999, "Aatrox1", "아트록스", "Aatrox.png");
        championRepository.save(entity);

        // when
        ChampionEntity findEntity = championRepository.findByNameEng("Aatrox1").get(0);

        // then
        assertThat(findEntity.getId()).isEqualTo(9999);
        assertThat(findEntity.getNameEng()).isEqualTo("Aatrox1");
        assertThat(findEntity.getNameKo()).isEqualTo("아트록스");
        assertThat(findEntity.getImagePath()).isEqualTo("Aatrox.png");

    }

}