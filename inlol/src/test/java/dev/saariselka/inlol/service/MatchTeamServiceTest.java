package dev.saariselka.inlol.service;

import dev.saariselka.inlol.vo.MatchTeamVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MatchTeamServiceTest {

    @Autowired
    MatchTeamService matchTeamService;

    @Test
    @DisplayName("Find Entity By TeamId")
    void findEntityByTeamId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        matchTeamService.insert("KR_9999999999", 100, true, rrt);

        // when
        List<MatchTeamVO> voList = matchTeamService.findByMatchIdAndTeamId("KR_9999999999", 100);
        MatchTeamVO test = voList.get(0);

        // then
        //assertThat(test.getTeamId()).isEqualTo("KR_9999999999");
        assertThat(test.getTeamId()).isEqualTo("100");
        assertThat(test.getWin()).isEqualTo("true");
        //(test.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Find Entity By TeamId.MatchId")
    void findEntityByMatchId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        matchTeamService.insert("KR_9999999999", 100, true, rrt);

        // when
        List<MatchTeamVO> voList = matchTeamService.findByMatchId("KR_9999999999");
        MatchTeamVO test = voList.get(0);

        // then
        //assertThat(test.getTeamId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(test.getTeamId()).isEqualTo("100");
        assertThat(test.getWin()).isEqualTo("true");
        //assertThat(test.getRrt()).isEqualTo(rrt);
    }

}