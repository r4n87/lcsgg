package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.entity.TeamId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchTeamRepository extends JpaRepository<TeamEntity, TeamId> {
    List<TeamEntity> findByTeamId(TeamId teamId);
    List<TeamEntity> findByTeamId_MatchId(@Param("matchId") String matchId);
}
