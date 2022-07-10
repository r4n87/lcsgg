package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueEntryId;
import dev.saariselka.inlol.repository.LeagueEntryRepository;
import dev.saariselka.inlol.service.LeagueEntryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class LeagueEntryControllerTest {

    @Autowired
    private LeagueEntryController leagueEntryController;
    @Autowired
    private LeagueEntryService leagueEntryService;

    @Test
    @DisplayName("Insert Entity")
    public void insertLeagueEntryInfo() {
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

        // when
        leagueEntryController.insertLeagueEntryInfo(summonerId,queueType,leagueId,summonerName,tier,ranks,leaguePoints,wins,losses,hotStreak,veteran,freshBlood,inactive,rrt);

        // then
        LeagueEntryEntity leagueEntryEntitySaved = leagueEntryService.findByLeagueEntryId(new LeagueEntryId(summonerId,queueType)).get(0);

        assertThat(new LeagueEntryId(summonerId,queueType)).isEqualTo(leagueEntryEntitySaved.getLeagueEntryId());
        assertThat(leagueEntryEntitySaved.getLeagueEntryId()).isNotNull();
    }

    @Test
    @DisplayName("Find Entity By LeagueEntryId")
    public void getLeagueEntriesByLeagueEntryId() {
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

        leagueEntryService.insert(summonerIdFaker,queueTypeFaker,leagueIdFaker,summonerNameFaker,tierFaker,ranksFaker,leaguePointsFaker,winsFaker,lossesFaker,hotStreakFaker,veteranFaker,freshBloodFaker,inactiveFaker,rrt);
        leagueEntryService.insert(summonerIdKeria,queueTypeKeria,leagueIdKeria,summonerNameKeria,tierKeria,ranksKeria,leaguePointsKeria,winsKeria,lossesKeria,hotStreakKeria,veteranKeria,freshBloodKeria,inactiveKeria,rrt);

        // when
        LeagueEntryEntity leagueEntryEntityFindFaker = leagueEntryController.getLeagueEntriesByLeagueEntryId(summonerIdFaker, queueTypeFaker).get(0);
        LeagueEntryEntity leagueEntryEntityFindKeria = leagueEntryController.getLeagueEntriesByLeagueEntryId(summonerIdKeria, queueTypeKeria).get(0);

        // then
        assertThat(leagueEntryEntityFindFaker.getSummonerName()).isEqualTo("Hide on bush");
        assertThat(leagueEntryEntityFindFaker.getLeaguePoints()).isEqualTo(1008);
        assertThat(leagueEntryEntityFindKeria.getSummonerName()).isEqualTo("역천괴");
        assertThat(leagueEntryEntityFindKeria.getLeaguePoints()).isEqualTo(1002);
    }

    @Test
    @DisplayName("Find Entity By LeagueEntryId.SummonerId")
    public void getLeagueEntriesBySummonerId() {
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

        leagueEntryService.insert(summonerIdFaker,queueTypeFaker,leagueIdFaker,summonerNameFaker,tierFaker,ranksFaker,leaguePointsFaker,winsFaker,lossesFaker,hotStreakFaker,veteranFaker,freshBloodFaker,inactiveFaker,rrt);
        leagueEntryService.insert(summonerIdKeria,queueTypeKeria,leagueIdKeria,summonerNameKeria,tierKeria,ranksKeria,leaguePointsKeria,winsKeria,lossesKeria,hotStreakKeria,veteranKeria,freshBloodKeria,inactiveKeria,rrt);

        // when
        LeagueEntryEntity leagueEntryEntityFindFaker = leagueEntryController.getLeagueEntriesBySummonerId(summonerIdFaker).get(0);
        LeagueEntryEntity leagueEntryEntityFindKeria = leagueEntryController.getLeagueEntriesBySummonerId(summonerIdKeria).get(0);

        // then
        assertThat(leagueEntryEntityFindFaker.getSummonerName()).isEqualTo("Hide on bush");
        assertThat(leagueEntryEntityFindFaker.getLeaguePoints()).isEqualTo(1008);
        assertThat(leagueEntryEntityFindKeria.getSummonerName()).isEqualTo("역천괴");
        assertThat(leagueEntryEntityFindKeria.getLeaguePoints()).isEqualTo(1002);
    }
}
