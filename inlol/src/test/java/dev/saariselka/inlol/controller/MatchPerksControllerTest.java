package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.MatchPerksDto;
import dev.saariselka.inlol.entity.MatchPerksEntity;
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
public class MatchPerksControllerTest {
    @Autowired
    MatchPerksController matchPerksController;

    @Test
    @DisplayName("Get Dto By MatchId, Puuid")
    void getMatchPerksListByMatchIdAndPuuid() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        matchPerksController.insertPerks("KR_9999999999", "ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw",
                8200, 8230, 8226, 8233, 8236, 8300, 8304, 8345,
                5003, 5008, 5008, rrt);

        // when
        List<MatchPerksDto> matchPerksDtoList = matchPerksController.getMatchPerksListByMatchIdAndPuuid("KR_9999999999", "ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw");
        MatchPerksDto matchPerksDtoForTest = matchPerksDtoList.get(0);

        // then
        assertThat(matchPerksDtoForTest.getMatchId()).isEqualTo("KR_9999999999");
        assertThat(matchPerksDtoForTest.getPuuid()).isEqualTo("ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw");
        assertThat(matchPerksDtoForTest.getPrimaryStyle()).isEqualTo(8200);
        assertThat(matchPerksDtoForTest.getPrimaryPerk1()).isEqualTo(8230);
        assertThat(matchPerksDtoForTest.getPrimaryPerk2()).isEqualTo(8226);
        assertThat(matchPerksDtoForTest.getPrimaryPerk3()).isEqualTo(8233);
        assertThat(matchPerksDtoForTest.getPrimaryPerk4()).isEqualTo(8236);
        assertThat(matchPerksDtoForTest.getSubStyle()).isEqualTo(8300);
        assertThat(matchPerksDtoForTest.getSubPerk1()).isEqualTo(8304);
        assertThat(matchPerksDtoForTest.getSubPerk2()).isEqualTo(8345);
        assertThat(matchPerksDtoForTest.getStatPerkDefense()).isEqualTo(5003);
        assertThat(matchPerksDtoForTest.getStatPerkFlex()).isEqualTo(5008);
        assertThat(matchPerksDtoForTest.getStatPerkOffense()).isEqualTo(5008);
    }
}