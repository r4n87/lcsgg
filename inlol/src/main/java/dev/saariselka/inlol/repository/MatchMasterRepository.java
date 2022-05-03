package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchMasterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchMasterRepository extends JpaRepository<MatchMasterEntity, MatchMasterId> {
    List<MatchMasterEntity> findByMatchMasterId(MatchMasterId matchMasterId);
    List<MatchMasterEntity> findByMatchMasterId_MatchId(@Param("matchId") String matchId);
}


