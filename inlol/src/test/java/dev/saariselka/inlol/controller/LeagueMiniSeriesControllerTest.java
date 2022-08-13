package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.LeagueMiniSeriesDto;
import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesId;
import dev.saariselka.inlol.repository.LeagueMiniSeriesRepository;
import dev.saariselka.inlol.service.LeagueMiniSeriesService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class LeagueMiniSeriesControllerTest {

    @Autowired
    private LeagueMiniSeriesController leagueMiniSeriesController;
    @Autowired
    private LeagueMiniSeriesService leagueMiniSeriesService;
    @Autowired
    private DtoMapper dtoMapper;


    @Test
    @DisplayName("Insert Entity")
    public void insertLeagueMiniSeriesInfo() {
        // given
        String summonerId = "testSummonerId";
        String queueType = "RANKED_SOLO_5x5";
        int target = 3;
        int wins = 2;
        int losses = 1;
        String progress = "Test";
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        // when
        leagueMiniSeriesController.insertLeagueMiniSeriesInfo(summonerId,queueType,losses,progress,target,wins,rrt);

        // then
        LeagueMiniSeriesDto leagueMiniSeriesDtoSaved = dtoMapper.toLeagueMiniseriesDto(leagueMiniSeriesService.findByLeagueMiniSeriesId(new LeagueMiniSeriesId(summonerId,queueType)));

        assertThat(leagueMiniSeriesDtoSaved.getSummonerId()).isEqualTo(summonerId);
        assertThat(leagueMiniSeriesDtoSaved.getQueueType()).isEqualTo(queueType);
    }

    @Test
    @DisplayName("Find Dto By LeagueMiniSeriesId")
    public void getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId() {
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

        leagueMiniSeriesService.insert(summonerIdFaker,queueTypeFaker,lossesFaker,progressFaker,targetFaker,winsFaker,rrt);
        leagueMiniSeriesService.insert(summonerIdKeria,queueTypeKeria,lossesKeria,progressKeria,targetKeria,winsKeria,rrt);

        // when
        LeagueMiniSeriesDto leagueMiniSeriesDtoFindFaker = leagueMiniSeriesController.getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId(summonerIdFaker, queueTypeFaker);
        LeagueMiniSeriesDto leagueMiniSeriesDtoFindKeria = leagueMiniSeriesController.getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId(summonerIdKeria, queueTypeKeria);

        // then
        assertThat(leagueMiniSeriesDtoFindFaker.getSummonerId()).isEqualTo("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA");
        assertThat(leagueMiniSeriesDtoFindFaker.getWins()).isEqualTo(2);
        assertThat(leagueMiniSeriesDtoFindKeria.getSummonerId()).isEqualTo("WZ5VlMpcG1fdbCMf2EKYRgcl6JPMljsZjaJrWeLqAAjoWVc");
        assertThat(leagueMiniSeriesDtoFindKeria.getWins()).isEqualTo(1);
    }
}
