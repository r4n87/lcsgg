package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.SummonerEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SummonerRepositoryTest {
    @Autowired SummonerRepository summonerRepository;

    @Test
    @DisplayName("Save")
    void saveSummonerRepository() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        SummonerEntity entity = createSummonerEntity(rrt);

        // when
        SummonerEntity saveEntity = summonerRepository.save(entity);

        // then
        assertThat(saveEntity.getAccountid()).isEqualTo("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy");
        assertThat(saveEntity.getProfileiconid()).isEqualTo(6);
        assertThat(saveEntity.getRevisiondate()).isEqualTo(1655406735000L);
        assertThat(saveEntity.getName()).isEqualTo("Test on bush");
        assertThat(saveEntity.getId()).isEqualTo("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA");
        assertThat(saveEntity.getSummonerlevel()).isEqualTo(576L);
        assertThat(saveEntity.getPuuid()).isEqualTo("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g");
        assertThat(saveEntity.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Find by puuid")
    void findSummonerRepository_ByPuuid() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        summonerRepository.save(createSummonerEntity(rrt));

        // when
        SummonerEntity findEntity = summonerRepository.findByPuuid("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g").get(0);

        // then
        assertThat(findEntity.getAccountid()).isEqualTo("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy");
        assertThat(findEntity.getProfileiconid()).isEqualTo(6);
        assertThat(findEntity.getRevisiondate()).isEqualTo(1655406735000L);
        assertThat(findEntity.getName()).isEqualTo("Test on bush");
        assertThat(findEntity.getId()).isEqualTo("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA");
        assertThat(findEntity.getSummonerlevel()).isEqualTo(576L);
        assertThat(findEntity.getPuuid()).isEqualTo("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g");
        assertThat(findEntity.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Find by name")
    void findSummonerRepository_ByName() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        summonerRepository.save(createSummonerEntity(rrt));

        // when
        SummonerEntity findEntity = summonerRepository.findByName("Test on bush").get(0);

        // then
        assertThat(findEntity.getAccountid()).isEqualTo("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy");
        assertThat(findEntity.getProfileiconid()).isEqualTo(6);
        assertThat(findEntity.getRevisiondate()).isEqualTo(1655406735000L);
        assertThat(findEntity.getName()).isEqualTo("Test on bush");
        assertThat(findEntity.getId()).isEqualTo("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA");
        assertThat(findEntity.getSummonerlevel()).isEqualTo(576L);
        assertThat(findEntity.getPuuid()).isEqualTo("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g");
        assertThat(findEntity.getRrt()).isEqualTo(rrt);
    }

    SummonerEntity createSummonerEntity(Timestamp rrt) {
        return new SummonerEntity(
                "dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy", 6, 1655406735000L,
                "Test on bush", "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA", 576L,
                "test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g", rrt);
    }
}