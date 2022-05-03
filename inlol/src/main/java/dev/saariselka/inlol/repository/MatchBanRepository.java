package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchBanRepository extends JpaRepository<MatchBanEntity, MatchBanId> {
    List<MatchBanEntity> findByMatchBanId(MatchBanId matchBanId);

    List<MatchBanEntity> findByMatchBanId_MatchId(@Param("matchId") String matchId);

    List<MatchBanEntity> findByMatchBanId_MatchIdAndMatchBanId_TeamId(@Param("matchId") String matchId, @Param("teamId") int teamId);
}
