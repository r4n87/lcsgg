package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.LeagueEntry;
import dev.saariselka.lcsgg.entity.MiniSeries;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LeagueEntryRepositoryTest {
    @Autowired
    LeagueEntryRepository leagueEntryRepository;

    @Test
    void test() {
        // given
        LeagueEntry leagueEntry = createLeagueEntry();

        // when
        leagueEntryRepository.save(leagueEntry);

        // then
        assertThat(leagueEntryRepository.findBySummonerId("testSummonerId")).isPresent();

        LeagueEntry find = leagueEntryRepository.findBySummonerId("testSummonerId").get();

        assertThat(find.getLeagueId()).isEqualTo(leagueEntry.getLeagueId());
        assertThat(find.getSummonerId()).isEqualTo(leagueEntry.getSummonerId());
        assertThat(find.getSummonerName()).isEqualTo(leagueEntry.getSummonerName());
        assertThat(find.getQueueType()).isEqualTo(leagueEntry.getQueueType());
        assertThat(find.getTier()).isEqualTo(leagueEntry.getTier());
        assertThat(find.getRanks()).isEqualTo(leagueEntry.getRanks());
        assertThat(find.getLeaguePoints()).isEqualTo(leagueEntry.getLeaguePoints());
        assertThat(find.getWins()).isEqualTo(leagueEntry.getWins());
        assertThat(find.getLosses()).isEqualTo(leagueEntry.getLosses());
        assertThat(find.isHotStreak()).isEqualTo(leagueEntry.isHotStreak());
        assertThat(find.isVeteran()).isEqualTo(leagueEntry.isVeteran());
        assertThat(find.isFreshBlood()).isEqualTo(leagueEntry.isFreshBlood());
        assertThat(find.isInactive()).isEqualTo(leagueEntry.isInactive());
        assertThat(find.getMiniSeries().getWins()).isEqualTo(leagueEntry.getMiniSeries().getWins());
        assertThat(find.getMiniSeries().getLosses()).isEqualTo(leagueEntry.getMiniSeries().getLosses());
        assertThat(find.getMiniSeries().getTarget()).isEqualTo(leagueEntry.getMiniSeries().getTarget());
        assertThat(find.getMiniSeries().getProgress()).isEqualTo(leagueEntry.getMiniSeries().getProgress());

    }

    LeagueEntry createLeagueEntry(){
        return LeagueEntry.builder()
                .leagueId("05fb99f4-e149-3133-a78e-821597582f9d")
                .summonerId("testSummonerId")
                .summonerName("Hide on bush")
                .queueType("RANKED_SOLO_5x5")
                .tier("CHALLENGER")
                .ranks("I")
                .leaguePoints(1008)
                .wins(358)
                .losses(309)
                .hotStreak(false)
                .veteran(true)
                .freshBlood(false)
                .inactive(false)
                .miniSeries(MiniSeries.builder()
                        .wins(2)
                        .losses(1)
                        .target(5)
                        .progress("Test")
                        .build())
                .build();
    }


}