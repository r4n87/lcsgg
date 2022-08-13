package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesId;
import dev.saariselka.inlol.repository.LeagueMiniSeriesRepository;
import dev.saariselka.inlol.vo.LeagueMiniSeriesVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class LeagueMiniSeriesServiceTest {

    @Autowired
    private LeagueMiniSeriesService leagueMiniSeriesService;
    @Autowired
    private LeagueMiniSeriesRepository leagueMiniSeriesRepository;
    @Autowired
    private VOMapper voMapper;

    @Test
    @DisplayName("Insert Entity")
    public void insert() {
        // given
        String summonerId = "testSummonerId";
        String queueType = "RANKED_SOLO_5x5";
        int target = 3;
        int wins = 2;
        int losses = 1;
        String progress = "Test";
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        // when
        leagueMiniSeriesService.insert(summonerId,queueType,losses,progress,target,wins,rrt);

        // then
        LeagueMiniSeriesVO leagueMiniSeriesVOSaved = voMapper.toLeagueMiniseriesVO(leagueMiniSeriesRepository.findByLeagueMiniSeriesId(new LeagueMiniSeriesId(summonerId, queueType)));

        assertThat(leagueMiniSeriesVOSaved.getSummonerId()).isEqualTo(summonerId);
        assertThat(leagueMiniSeriesVOSaved.getQueueType()).isEqualTo(queueType);
        assertThat(leagueMiniSeriesRepository.count()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Find Entity By LeagueMiniSeriesId")
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
        LeagueMiniSeriesVO leagueMiniSeriesVOFindFaker = leagueMiniSeriesService.findByLeagueMiniSeriesId(leagueMiniSeriesEntitySavedFaker.getLeagueMiniSeriesId());
        LeagueMiniSeriesVO leagueMiniSeriesVOFindKeria = leagueMiniSeriesService.findByLeagueMiniSeriesId(leagueMiniSeriesEntitySavedKeria.getLeagueMiniSeriesId());

        // then
        assertThat(leagueMiniSeriesRepository.count()).isGreaterThan(0);
        assertThat(leagueMiniSeriesVOFindFaker.getSummonerId()).isEqualTo("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA");
        assertThat(leagueMiniSeriesVOFindFaker.getWins()).isEqualTo(2);
        assertThat(leagueMiniSeriesVOFindKeria.getSummonerId()).isEqualTo("WZ5VlMpcG1fdbCMf2EKYRgcl6JPMljsZjaJrWeLqAAjoWVc");
        assertThat(leagueMiniSeriesVOFindKeria.getWins()).isEqualTo(1);
    }
}
