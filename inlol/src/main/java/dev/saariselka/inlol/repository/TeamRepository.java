package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.entity.MatchParticipantId;
import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.entity.TeamId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, TeamId> {
    List<TeamEntity> findByTeamId(TeamId teamId);

    @Query(value = "SELECT * FROM riot_match_team WHERE match_id = :matchId", nativeQuery = true)
    List<TeamEntity> searchTeamsByMatchId(@Param("matchId") String matchId);
}
