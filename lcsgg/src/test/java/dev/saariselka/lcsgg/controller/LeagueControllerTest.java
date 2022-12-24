package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.dto.LeagueEntryDto;
import dev.saariselka.lcsgg.dto.MiniSeriesDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class LeagueControllerTest {

    @Autowired
    LeagueController leagueController;

    @Test
    public void testLeagueEntry() {
        // given
        String summonerId = "testSummonerId";
        String queueType = "RANKED_SOLO_5x5";
        String leagueId = "05fb99f4-e149-3133-a78e-821597582f9d";
        String summonerName = "Test on bush";
        String tier = "CHALLENGER";
        String ranks = "I";
        int leaguePoints = 1008;
        int wins = 358;
        int losses = 309;
        boolean hotStreak = false;
        boolean veteran = true;
        boolean freshBlood = false;
        boolean inactive = false;
        int mini_wins = 2;
        int mini_losses = 1;
        int mini_target = 3;
        String mini_progress = "Test";

        LeagueEntryDto dto = LeagueEntryDto.builder()
                .summonerId(summonerId)
                .queueType(queueType)
                .leagueId(leagueId)
                .summonerName(summonerName)
                .tier(tier)
                .ranks(ranks)
                .leaguePoints(leaguePoints)
                .wins(wins)
                .losses(losses)
                .hotStreak(hotStreak)
                .veteran(veteran)
                .freshBlood(freshBlood)
                .inactive(inactive)
                .miniSeries(MiniSeriesDto.builder()
                        .wins(mini_wins)
                        .losses(mini_losses)
                        .target(mini_target)
                        .progress(mini_progress)
                        .build())
                .build();

        // when
        leagueController.insertLeagueEntry(dto);
        LeagueEntryDto findDto = leagueController.getLeagueEntryDtosBySummonerId(summonerId).get(0);

        // then
        assertThat(findDto.getSummonerId()).isEqualTo(summonerId);
        assertThat(findDto.getQueueType()).isEqualTo(queueType);
        assertThat(findDto.getLeagueId()).isEqualTo(leagueId);
        assertThat(findDto.getSummonerName()).isEqualTo(summonerName);
        assertThat(findDto.getTier()).isEqualTo(tier);
        assertThat(findDto.getRanks()).isEqualTo(ranks);
        assertThat(findDto.getLeaguePoints()).isEqualTo(leaguePoints);
        assertThat(findDto.getWins()).isEqualTo(wins);
        assertThat(findDto.getLosses()).isEqualTo(losses);
        assertThat(findDto.isHotStreak()).isEqualTo(hotStreak);
        assertThat(findDto.isVeteran()).isEqualTo(veteran);
        assertThat(findDto.isInactive()).isEqualTo(inactive);
        assertThat(findDto.getMiniSeries().getWins()).isEqualTo(mini_wins);
        assertThat(findDto.getMiniSeries().getLosses()).isEqualTo(mini_losses);
        assertThat(findDto.getMiniSeries().getTarget()).isEqualTo(mini_target);
        assertThat(findDto.getMiniSeries().getProgress()).isEqualTo(mini_progress);
    }
}