package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueEntryId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LeagueEntryRepositoryTest {

    @Autowired
    private LeagueEntryRepository leagueEntryRepository;

    @Test
    @DisplayName("LeagueEntry Entity  Save Test")
    public void saveLeagueEntryEntity() {
        // given
        String summonerId = "testSummonerId";
        String queueType = "RANKED_SOLO_5x5";
        String leagueId = "05fb99f4-e149-3133-a78e-821597582f9d";
        String summonerName = "Hide on bush";
        String tier = "CHALLENGER";
        String ranks = "I";
        int leaguePoints = 1008;
        int wins = 358;
        int losses = 309;
        boolean hotStreak = false;
        boolean veteran = true;
        boolean freshBlood = false;
        boolean inactive = false;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        LeagueEntryEntity leagueEntryEntity = new LeagueEntryEntity(new LeagueEntryId(summonerId, queueType), leagueId, summonerName, tier, ranks, leaguePoints, wins, losses, hotStreak, veteran, freshBlood, inactive, rrt);

        // when
        LeagueEntryEntity leagueEntryEntitySaved = leagueEntryRepository.save(leagueEntryEntity);

        // then
        assertThat(leagueEntryEntity.getLeagueEntryId()).isEqualTo(leagueEntryEntitySaved.getLeagueEntryId());
        assertThat(leagueEntryEntitySaved.getLeagueEntryId()).isNotNull();
        assertThat(leagueEntryRepository.count()).isGreaterThan(1);
    }

    @Test
    @DisplayName("LeagueEntry Entity FindByLeagueEntryId Test")
    public void findByLeagueEntryId() {
        // given
        String summonerIdFaker = "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA";
        String summonerIdKeria = "WZ5VlMpcG1fdbCMf2EKYRgcl6JPMljsZjaJrWeLqAAjoWVc";
        String queueTypeFaker = "RANKED_SOLO_5x5";
        String queueTypeKeria = "RANKED_SOLO_5x5";
        String leagueIdFaker = "05fb99f4-e149-3133-a78e-821597582f9d";
        String leagueIdKeria = "05fb99f4-e149-3133-a78e-821597582f9d";
        String summonerNameFaker = "Hide on bush";
        String summonerNameKeria = "역천괴";
        String tierFaker = "CHALLENGER";
        String tierKeria = "CHALLENGER";
        String ranksFaker = "I";
        String ranksKeria = "I";
        int leaguePointsFaker = 1008;
        int leaguePointsKeria = 1002;
        int winsFaker = 358;
        int winsKeria = 352;
        int lossesFaker = 309;
        int lossesKeria = 298;
        boolean hotStreakFaker = false;
        boolean hotStreakKeria = true;
        boolean veteranFaker = true;
        boolean veteranKeria = true;
        boolean freshBloodFaker = false;
        boolean freshBloodKeria = false;
        boolean inactiveFaker = false;
        boolean inactiveKeria = false;

        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        LeagueEntryEntity leagueEntryEntityFaker = new LeagueEntryEntity(new LeagueEntryId(summonerIdFaker, queueTypeFaker), leagueIdFaker, summonerNameFaker, tierFaker, ranksFaker, leaguePointsFaker, winsFaker, lossesFaker, hotStreakFaker, veteranFaker, freshBloodFaker, inactiveFaker, rrt);
        LeagueEntryEntity leagueEntryEntityKeria = new LeagueEntryEntity(new LeagueEntryId(summonerIdKeria, queueTypeKeria), leagueIdKeria, summonerNameKeria, tierKeria, ranksKeria, leaguePointsKeria, winsKeria, lossesKeria, hotStreakKeria, veteranKeria, freshBloodKeria, inactiveKeria, rrt);

        LeagueEntryEntity leagueEntryEntitySavedFaker = leagueEntryRepository.save(leagueEntryEntityFaker);
        LeagueEntryEntity leagueEntryEntitySavedKeria = leagueEntryRepository.save(leagueEntryEntityKeria);

        // when

        LeagueEntryEntity leagueEntryEntityFindFaker = leagueEntryRepository.findByLeagueEntryId(leagueEntryEntitySavedFaker.getLeagueEntryId()).get(0);
        LeagueEntryEntity leagueEntryEntityFindKeria = leagueEntryRepository.findByLeagueEntryId(leagueEntryEntitySavedKeria.getLeagueEntryId()).get(0);

        // then
        assertThat(leagueEntryRepository.count()).isGreaterThan(2);
        assertThat(leagueEntryEntityFindFaker.getSummonerName()).isEqualTo("Hide on bush");
        assertThat(leagueEntryEntityFindFaker.getLeaguePoints()).isEqualTo(1008);
        assertThat(leagueEntryEntityFindKeria.getSummonerName()).isEqualTo("역천괴");
        assertThat(leagueEntryEntityFindKeria.getLeaguePoints()).isEqualTo(1002);
    }

    @Test
    @DisplayName("LeagueEntry Entity FindBySummonerId Test")
    public void findBySummonerId() {
        // given
        String summonerIdFaker = "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA";
        String summonerIdKeria = "WZ5VlMpcG1fdbCMf2EKYRgcl6JPMljsZjaJrWeLqAAjoWVc";
        String queueTypeFaker = "RANKED_SOLO_5x5";
        String queueTypeKeria = "RANKED_SOLO_5x5";
        String leagueIdFaker = "05fb99f4-e149-3133-a78e-821597582f9d";
        String leagueIdKeria = "05fb99f4-e149-3133-a78e-821597582f9d";
        String summonerNameFaker = "Hide on bush";
        String summonerNameKeria = "역천괴";
        String tierFaker = "CHALLENGER";
        String tierKeria = "CHALLENGER";
        String ranksFaker = "I";
        String ranksKeria = "I";
        int leaguePointsFaker = 1008;
        int leaguePointsKeria = 1002;
        int winsFaker = 358;
        int winsKeria = 352;
        int lossesFaker = 309;
        int lossesKeria = 298;
        boolean hotStreakFaker = false;
        boolean hotStreakKeria = true;
        boolean veteranFaker = true;
        boolean veteranKeria = true;
        boolean freshBloodFaker = false;
        boolean freshBloodKeria = false;
        boolean inactiveFaker = false;
        boolean inactiveKeria = false;

        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        LeagueEntryEntity leagueEntryEntityFaker = new LeagueEntryEntity(new LeagueEntryId(summonerIdFaker, queueTypeFaker), leagueIdFaker, summonerNameFaker, tierFaker, ranksFaker, leaguePointsFaker, winsFaker, lossesFaker, hotStreakFaker, veteranFaker, freshBloodFaker, inactiveFaker, rrt);
        LeagueEntryEntity leagueEntryEntityKeria = new LeagueEntryEntity(new LeagueEntryId(summonerIdKeria, queueTypeKeria), leagueIdKeria, summonerNameKeria, tierKeria, ranksKeria, leaguePointsKeria, winsKeria, lossesKeria, hotStreakKeria, veteranKeria, freshBloodKeria, inactiveKeria, rrt);

        LeagueEntryEntity leagueEntryEntitySavedFaker = leagueEntryRepository.save(leagueEntryEntityFaker);
        LeagueEntryEntity leagueEntryEntitySavedKeria = leagueEntryRepository.save(leagueEntryEntityKeria);

        // when

        LeagueEntryEntity leagueEntryEntityFindFaker = leagueEntryRepository.findByLeagueEntryId_SummonerId(leagueEntryEntitySavedFaker.getLeagueEntryId().getSummonerId()).get(0);
        LeagueEntryEntity leagueEntryEntityFindKeria = leagueEntryRepository.findByLeagueEntryId_SummonerId(leagueEntryEntitySavedKeria.getLeagueEntryId().getSummonerId()).get(0);

        // then
        assertThat(leagueEntryRepository.count()).isGreaterThan(2);
        assertThat(leagueEntryEntityFindFaker.getSummonerName()).isEqualTo("Hide on bush");
        assertThat(leagueEntryEntityFindFaker.getLeaguePoints()).isEqualTo(1008);
        assertThat(leagueEntryEntityFindKeria.getSummonerName()).isEqualTo("역천괴");
        assertThat(leagueEntryEntityFindKeria.getLeaguePoints()).isEqualTo(1002);
    }
}
