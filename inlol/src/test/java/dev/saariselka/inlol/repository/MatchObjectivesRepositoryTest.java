package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import dev.saariselka.inlol.entity.MatchObjectivesId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MatchObjectivesRepositoryTest {
    @Autowired MatchObjectivesRepository matchObjectivesRepository;

    @Test
    @DisplayName("Save")
    void saveMatchObjectivesRepository() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        MatchObjectivesEntity entity = createMatchObjectivesEntity(rrt);

        // when
        MatchObjectivesEntity saveEntity = matchObjectivesRepository.save(entity);

        // then
        assertThat(saveEntity.getMatchObjectivesId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(saveEntity.getMatchObjectivesId().getTeamId()).isEqualTo(100);
        assertThat(saveEntity.isBaron_first()).isTrue();
        assertThat(saveEntity.getBaron_kills()).isEqualTo(2);
        assertThat(saveEntity.isChampion_first()).isFalse();
        assertThat(saveEntity.getChampion_kills()).isEqualTo(40);
        assertThat(saveEntity.isDragon_first()).isFalse();
        assertThat(saveEntity.getDragon_kills()).isEqualTo(1);
        assertThat(saveEntity.isInhibitor_first()).isTrue();
        assertThat(saveEntity.getInhibitor_kills()).isEqualTo(1);
        assertThat(saveEntity.isRiftherald_first()).isFalse();
        assertThat(saveEntity.getRiftherald_kills()).isEqualTo(0);
        assertThat(saveEntity.isTower_first()).isFalse();
        assertThat(saveEntity.getTower_kills()).isEqualTo(11);
        assertThat(saveEntity.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Find by MatchObjectivesId")
    void findMatchObjectivesRepository_ByMatchObjectivesId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        matchObjectivesRepository.save(createMatchObjectivesEntity(rrt));

        // when
        MatchObjectivesEntity findEntity = matchObjectivesRepository.findByMatchObjectivesId(new MatchObjectivesId("KR_9999999999", 100)).get(0);

        // then
        assertThat(findEntity.getMatchObjectivesId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(findEntity.getMatchObjectivesId().getTeamId()).isEqualTo(100);
        assertThat(findEntity.isBaron_first()).isTrue();
        assertThat(findEntity.getBaron_kills()).isEqualTo(2);
        assertThat(findEntity.isChampion_first()).isFalse();
        assertThat(findEntity.getChampion_kills()).isEqualTo(40);
        assertThat(findEntity.isDragon_first()).isFalse();
        assertThat(findEntity.getDragon_kills()).isEqualTo(1);
        assertThat(findEntity.isInhibitor_first()).isTrue();
        assertThat(findEntity.getInhibitor_kills()).isEqualTo(1);
        assertThat(findEntity.isRiftherald_first()).isFalse();
        assertThat(findEntity.getRiftherald_kills()).isEqualTo(0);
        assertThat(findEntity.isTower_first()).isFalse();
        assertThat(findEntity.getTower_kills()).isEqualTo(11);
        assertThat(findEntity.getRrt()).isEqualTo(rrt);
    }

    MatchObjectivesEntity createMatchObjectivesEntity(Timestamp rrt) {
        return new MatchObjectivesEntity(new MatchObjectivesId("KR_9999999999", 100),
                true, 2, false, 40, false, 1,
                true, 1, false, 0, false, 11, rrt);
    }
}