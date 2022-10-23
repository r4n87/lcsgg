package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.Summoner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SummonerRepositoryTest {

    @Autowired
    SummonerRepository summonerRepository;

    @Test
    void test() {
        // given
        Summoner summoner = createSummoner();

        // when
        summonerRepository.save(summoner);

        // then
        assertThat(summonerRepository.findByName("Test on bush")).isPresent();
        assertThat(summonerRepository.findByPuuid("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g")).isPresent();
    }

    Summoner createSummoner() {
        return Summoner.builder()
                .puuid("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g")
                .accountId("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy")
                .profileIconId(6)
                .revisionDate(1655406735000L)
                .name("Test on bush")
                .id("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA")
                .summonerLevel(576L)
                .build();

    }
}