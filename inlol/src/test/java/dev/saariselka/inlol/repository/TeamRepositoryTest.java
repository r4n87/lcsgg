package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.entity.TeamId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Time;
import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeamRepositoryTest {
    @Autowired TeamRepository teamRepository;

    @Test
    @DisplayName("Save Entity")
    void saveTeamRepository() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        TeamEntity entity = createTestTeamEntity(rrt);

        // when
        TeamEntity saveEntity = teamRepository.save(entity);

        // then
        assertThat(saveEntity.getTeamId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(saveEntity.getTeamId().getTeamId()).isEqualTo(100);
        assertThat(saveEntity.isWin()).isTrue();
        assertThat(saveEntity.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Find Entity By TeamId")
    void findTeamRepositoryByTeamId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        teamRepository.save(createTestTeamEntity(rrt));

        // when
        TeamEntity findEntity = teamRepository.findByTeamId(new TeamId("KR_9999999999", 100 )).get(0);

        // then
        assertThat(findEntity.getTeamId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(findEntity.getTeamId().getTeamId()).isEqualTo(100);
        assertThat(findEntity.isWin()).isTrue();
        assertThat(findEntity.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Find Entity By TeamId.MatchId")
    void findTeamRepositoryByMatchId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        teamRepository.save(createTestTeamEntity(rrt));

        // when
        TeamEntity findEntity = teamRepository.findByTeamId_MatchId("KR_9999999999").get(0);

        // then
        assertThat(findEntity.getTeamId().getMatchId()).isEqualTo("KR_9999999999");
        assertThat(findEntity.getTeamId().getTeamId()).isEqualTo(100);
        assertThat(findEntity.isWin()).isTrue();
        assertThat(findEntity.getRrt()).isEqualTo(rrt);
    }

    TeamEntity createTestTeamEntity(Timestamp rrt) {
        return new TeamEntity(new TeamId("KR_9999999999", 100 ), true, rrt);
    }
}