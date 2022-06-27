package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchPerksEntity;
import dev.saariselka.inlol.entity.MatchPerksId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MatchPerksRepositoryTest {
    @Autowired MatchPerksRepository matchPerksRepository;

    @Test
    @DisplayName("Save")
    void saveMatchPerksRepository() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        MatchPerksEntity entity = createTestMatchPerksEntity(rrt);

        // when
        MatchPerksEntity saveEntity = matchPerksRepository.save(entity);

        // then
        assertThat(saveEntity.getMatchPerksId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(saveEntity.getMatchPerksId().getPuuid()).isEqualTo("ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw");
        assertThat(saveEntity.getPrimaryStyle()).isEqualTo(8200);
        assertThat(saveEntity.getPrimaryPerk1()).isEqualTo(8230);
        assertThat(saveEntity.getPrimaryPerk2()).isEqualTo(8226);
        assertThat(saveEntity.getPrimaryPerk3()).isEqualTo(8233);
        assertThat(saveEntity.getPrimaryPerk4()).isEqualTo(8236);
        assertThat(saveEntity.getSubStyle()).isEqualTo(8300);
        assertThat(saveEntity.getSubPerk1()).isEqualTo(8304);
        assertThat(saveEntity.getSubPerk2()).isEqualTo(8345);
        assertThat(saveEntity.getStatPerkDefense()).isEqualTo(5003);
        assertThat(saveEntity.getStatPerkFlex()).isEqualTo(5008);
        assertThat(saveEntity.getStatPerkOffense()).isEqualTo(5008);
        assertThat(saveEntity.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Find by MatchPerksId")
    void findMatchPerksRepository_ByMatchPerksId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        matchPerksRepository.save(createTestMatchPerksEntity(rrt));

        // when
        MatchPerksEntity findEntity = matchPerksRepository.findByMatchPerksId(new MatchPerksId("KR_9999999999", "ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw")).get(0);

        // then
        assertThat(findEntity.getMatchPerksId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(findEntity.getMatchPerksId().getPuuid()).isEqualTo("ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw");
        assertThat(findEntity.getPrimaryStyle()).isEqualTo(8200);
        assertThat(findEntity.getPrimaryPerk1()).isEqualTo(8230);
        assertThat(findEntity.getPrimaryPerk2()).isEqualTo(8226);
        assertThat(findEntity.getPrimaryPerk3()).isEqualTo(8233);
        assertThat(findEntity.getPrimaryPerk4()).isEqualTo(8236);
        assertThat(findEntity.getSubStyle()).isEqualTo(8300);
        assertThat(findEntity.getSubPerk1()).isEqualTo(8304);
        assertThat(findEntity.getSubPerk2()).isEqualTo(8345);
        assertThat(findEntity.getStatPerkDefense()).isEqualTo(5003);
        assertThat(findEntity.getStatPerkFlex()).isEqualTo(5008);
        assertThat(findEntity.getStatPerkOffense()).isEqualTo(5008);
        assertThat(findEntity.getRrt()).isEqualTo(rrt);
    }

    MatchPerksEntity createTestMatchPerksEntity(Timestamp rrt) {
        return new MatchPerksEntity(new MatchPerksId("KR_9999999999", "ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw"),
                8200, 8230, 8226, 8233, 8236,
                8300, 8304, 8345, 5003, 5008, 5008, rrt);
    }
}