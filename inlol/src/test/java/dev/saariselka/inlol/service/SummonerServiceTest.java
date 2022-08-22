package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.SummonerEntity;
import dev.saariselka.inlol.vo.SummonerVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SummonerServiceTest {
    @Autowired
    SummonerService summonerService;

    @Test
    @DisplayName("Find Entity By Puuid")
    void findByPuuid() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        summonerService.insert("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy", 6, 1655406735000L, "Test on bush",
                "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA", 576L,
                "test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g", rrt);

        // when
        List<SummonerVO> summonerVOList = summonerService.findByPuuid("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g");
        SummonerVO test = summonerVOList.get(0);

        // then
        assertThat(test.getAccountId()).isEqualTo("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy");
        assertThat(test.getProfileIconId()).isEqualTo("6");
        assertThat(test.getRevisionDate()).isEqualTo("1655406735000");
        assertThat(test.getName()).isEqualTo("Test on bush");
        assertThat(test.getId()).isEqualTo("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA");
        assertThat(test.getSummonerLevel()).isEqualTo("576");
        assertThat(test.getPuuid()).isEqualTo("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g");
        assertThat(test.getLastRefreshTimeForUI()).isEqualTo(getLastRefreshTimeForUI(rrt));
        assertThat(test.getLastRefreshTimeForAPI()).isEqualTo(rrt.toInstant().getEpochSecond());
    }

    @Test
    @DisplayName("Find Entity By Name")
    void findByName() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        summonerService.insert("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy", 6, 1655406735000L, "Test on bush",
                "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA", 576L,
                "test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g", rrt);

        // when
        List<SummonerVO> summonerVOList = summonerService.findByName("Test on bush");
        SummonerVO test = summonerVOList.get(0);

        // then
        assertThat(test.getAccountId()).isEqualTo("dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy");
        assertThat(test.getProfileIconId()).isEqualTo("6");
        assertThat(test.getRevisionDate()).isEqualTo("1655406735000");
        assertThat(test.getName()).isEqualTo("Test on bush");
        assertThat(test.getId()).isEqualTo("qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA");
        assertThat(test.getSummonerLevel()).isEqualTo("576");
        assertThat(test.getPuuid()).isEqualTo("test_4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g");
        assertThat(test.getLastRefreshTimeForUI()).isEqualTo(getLastRefreshTimeForUI(rrt));
        assertThat(test.getLastRefreshTimeForAPI()).isEqualTo(rrt.toInstant().getEpochSecond());
    }

    private String getLastRefreshTimeForUI(Timestamp rrt)
    {
        String refreshAgoTime = null;

        if (ChronoUnit.HOURS.between(rrt.toLocalDateTime(), LocalDateTime.now()) >= 24)
        {
            refreshAgoTime = String.valueOf(ChronoUnit.DAYS.between(rrt.toLocalDateTime(), LocalDateTime.now()))
                    + "일 전";
        }
        else if (ChronoUnit.MINUTES.between(rrt.toLocalDateTime(), LocalDateTime.now()) >= 60)
        {
            refreshAgoTime = String.valueOf(ChronoUnit.HOURS.between(rrt.toLocalDateTime(), LocalDateTime.now()))
                    + "시간 전";
        }
        else
        {
            refreshAgoTime = String.valueOf(ChronoUnit.MINUTES.between(rrt.toLocalDateTime(), LocalDateTime.now()))
                    + "분 전";
        }

        return refreshAgoTime;
    }

}