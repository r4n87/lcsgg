package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueEntryId;
import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LeagueMiniSeriesRepositoryTest {

    @Autowired
    private LeagueMiniSeriesRepository leagueMiniSeriesRepository;

    @Test
    @DisplayName("LeagueMiniSeries Entity  Save Test")
    public void saveLeagueMiniSeriesEntity() {
        // given
        String summonerId = "testSummonerId";
        String queueType = "RANKED_SOLO_5x5";
        int target = 3;
        int wins = 2;
        int losses = 1;
        String progress = "Test";
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        LeagueMiniSeriesEntity leagueMiniSeriesEntity = new LeagueMiniSeriesEntity(new LeagueMiniSeriesId(summonerId, queueType), losses, progress, target, wins, rrt);

        // when
        LeagueMiniSeriesEntity leagueMiniSeriesEntity_save = leagueMiniSeriesRepository.save(leagueMiniSeriesEntity);

        // then
        assertThat(leagueMiniSeriesEntity.getLeagueMiniSeriesId()).isEqualTo(leagueMiniSeriesEntity_save.getLeagueMiniSeriesId());
        assertThat(leagueMiniSeriesEntity_save.getLeagueMiniSeriesId()).isNotNull();
        assertThat(leagueMiniSeriesRepository.count()).isGreaterThan(0);
    }

    @Test
    @DisplayName("LeagueMiniSeries Entity FindByLeagueMiniSeriesId Test")
    public void findByLeagueMiniSeriesId() {
        // given
        String summonerIdFaker = "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA";
        String summonerIdKeria = "WZ5VlMpcG1fdbCMf2EKYRgcl6JPMljsZjaJrWeLqAAjoWVc";
        String queueTypeFaker = "RANKED_SOLO_5x5";
        String queueTypeKeria = "RANKED_SOLO_5x5";
        int targetFaker = 3;
        int targetKeria = 3;
        int winsFaker = 2;
        int winsKeria = 1;
        int lossesFaker = 1;
        int lossesKeria = 0;
        String progressFaker = "TestFaker";
        String progressKeria = "TestKeria";

        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        LeagueMiniSeriesEntity leagueMiniSeriesEntityFaker = new LeagueMiniSeriesEntity(new LeagueMiniSeriesId(summonerIdFaker, queueTypeFaker), lossesFaker, progressFaker, targetFaker, winsFaker, rrt);
        LeagueMiniSeriesEntity leagueMiniSeriesEntityKeria = new LeagueMiniSeriesEntity(new LeagueMiniSeriesId(summonerIdKeria, queueTypeKeria), lossesKeria, progressKeria, targetKeria, winsKeria, rrt);

        LeagueMiniSeriesEntity leagueMiniSeriesEntitySavedFaker = leagueMiniSeriesRepository.save(leagueMiniSeriesEntityFaker);
        LeagueMiniSeriesEntity leagueMiniSeriesEntitySavedKeria = leagueMiniSeriesRepository.save(leagueMiniSeriesEntityKeria);

        // when

        LeagueMiniSeriesEntity leagueMiniSeriesEntityFindFaker = leagueMiniSeriesRepository.findByLeagueMiniSeriesId(leagueMiniSeriesEntitySavedFaker.getLeagueMiniSeriesId());
        LeagueMiniSeriesEntity leagueMiniSeriesEntityFindKeria = leagueMiniSeriesRepository.findByLeagueMiniSeriesId(leagueMiniSeriesEntitySavedKeria.getLeagueMiniSeriesId());

        // then
        assertThat(leagueMiniSeriesRepository.count()).isGreaterThan(0);
        assertThat(leagueMiniSeriesEntityFindFaker.getLeagueMiniSeriesId().getSummonerId()).isEqualTo("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA");
        assertThat(leagueMiniSeriesEntityFindFaker.getWins()).isEqualTo(2);
        assertThat(leagueMiniSeriesEntityFindKeria.getLeagueMiniSeriesId().getSummonerId()).isEqualTo("WZ5VlMpcG1fdbCMf2EKYRgcl6JPMljsZjaJrWeLqAAjoWVc");
        assertThat(leagueMiniSeriesEntityFindKeria.getWins()).isEqualTo(1);
    }
}
