package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchBanRepository extends JpaRepository<MatchBanEntity, MatchBanId> {
    //List<MatchBanEntity> findByMatchId(String matchId);
    List<MatchBanEntity> findByMatchBanId(MatchBanId matchBanId);

    @Query(value = "SELECT * FROM riot_match_ban WHERE match_id = :matchId", nativeQuery = true)
    List<MatchBanEntity> searchBansByMatchId(@Param("matchId") String matchId);
}
