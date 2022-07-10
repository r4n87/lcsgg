package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchPerksEntity;
import dev.saariselka.inlol.entity.MatchPerksId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MatchPerksServiceTest {
    @Autowired
    MatchPerksService matchPerksService;

    @Test
    @DisplayName("Find Entity By MatchPerksId")
    void findByMatchPerksId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        matchPerksService.insert("KR_9999999999", "ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw",
                8200, 8230, 8226, 8233, 8236, 8300, 8304, 8345,
                       5003, 5008, 5008, rrt);

        // when
        List<MatchPerksEntity> entity = matchPerksService.findByMatchPerksId(new MatchPerksId("KR_9999999999", "ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw"));
        MatchPerksEntity test = entity.get(0);

        // then
        assertThat(test.getMatchPerksId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(test.getMatchPerksId().getPuuid()).isEqualTo("ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw");
        assertThat(test.getPrimaryStyle()).isEqualTo(8200);
        assertThat(test.getPrimaryPerk1()).isEqualTo(8230);
        assertThat(test.getPrimaryPerk2()).isEqualTo(8226);
        assertThat(test.getPrimaryPerk3()).isEqualTo(8233);
        assertThat(test.getPrimaryPerk4()).isEqualTo(8236);
        assertThat(test.getSubStyle()).isEqualTo(8300);
        assertThat(test.getSubPerk1()).isEqualTo(8304);
        assertThat(test.getSubPerk2()).isEqualTo(8345);
        assertThat(test.getStatPerkDefense()).isEqualTo(5003);
        assertThat(test.getStatPerkFlex()).isEqualTo(5008);
        assertThat(test.getStatPerkOffense()).isEqualTo(5008);
        assertThat(test.getRrt()).isEqualTo(rrt);
    }

}