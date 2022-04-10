package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.entity.MatchParticipantId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchBanRepository extends JpaRepository<MatchBanEntity, MatchBanId> {
    //List<MatchBanEntity> findByMatchId(String matchId);
    List<MatchBanEntity> findByMatchBanId(MatchBanId matchBanId);
}
