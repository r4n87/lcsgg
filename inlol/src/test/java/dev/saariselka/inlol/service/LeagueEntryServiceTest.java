package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueEntryId;
import dev.saariselka.inlol.repository.LeagueEntryRepository;
import dev.saariselka.inlol.vo.LeagueEntryVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class LeagueEntryServiceTest {

    @Autowired
    private LeagueEntryService leagueEntryService;
    @Autowired
    private LeagueEntryRepository leagueEntryRepository;
    @Autowired
    private VOMapper voMapper;

    @Test
    @DisplayName("Insert Entity")
    public void insert() {
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
        leagueEntryService.insert(summonerId,queueType,leagueId,summonerName,tier,ranks,leaguePoints,wins,losses,hotStreak,veteran,freshBlood,inactive,rrt);

        // then
        LeagueEntryVO leagueEntryVOSaved = voMapper.toLeagueEntryVOList(leagueEntryRepository.findByLeagueEntryId(new LeagueEntryId(summonerId,queueType))).get(0);

        assertThat(leagueEntryVOSaved.getSummonerId()).isEqualTo(summonerId);
        assertThat(leagueEntryVOSaved.getQueueType()).isEqualTo(queueType);
        assertThat(leagueEntryRepository.count()).isGreaterThan(1);
    }

    @Test
    @DisplayName("Find VO By LeagueEntryId")
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
        LeagueEntryVO leagueEntryVOFindFaker = leagueEntryService.findByLeagueEntryId(leagueEntryEntitySavedFaker.getLeagueEntryId()).get(0);
        LeagueEntryVO leagueEntryVOFindKeria = leagueEntryService.findByLeagueEntryId(leagueEntryEntitySavedKeria.getLeagueEntryId()).get(0);

        // then
        assertThat(leagueEntryRepository.count()).isGreaterThan(2);
        assertThat(leagueEntryVOFindFaker.getSummonerName()).isEqualTo("Hide on bush");
        assertThat(leagueEntryVOFindFaker.getLeaguePoints()).isEqualTo(1008);
        assertThat(leagueEntryVOFindKeria.getSummonerName()).isEqualTo("역천괴");
        assertThat(leagueEntryVOFindKeria.getLeaguePoints()).isEqualTo(1002);
    }

    @Test
    @DisplayName("Find VO By LeagueEntryId.SummonerId")
    public void findByLeagueEntryId_SummonerId() {
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
        LeagueEntryVO leagueEntryVOFindFaker = leagueEntryService.findByLeagueEntryId_SummonerId(leagueEntryEntitySavedFaker.getLeagueEntryId().getSummonerId()).get(0);
        LeagueEntryVO leagueEntryVOFindKeria = leagueEntryService.findByLeagueEntryId_SummonerId(leagueEntryEntitySavedKeria.getLeagueEntryId().getSummonerId()).get(0);

        // then
        assertThat(leagueEntryVOFindFaker.getSummonerName()).isEqualTo("Hide on bush");
        assertThat(leagueEntryVOFindFaker.getLeaguePoints()).isEqualTo(1008);
        assertThat(leagueEntryVOFindKeria.getSummonerName()).isEqualTo("역천괴");
        assertThat(leagueEntryVOFindKeria.getLeaguePoints()).isEqualTo(1002);
    }
}
