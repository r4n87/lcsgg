package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.entity.MatchParticipantId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchParticipantRepository extends JpaRepository<MatchParticipantEntity, MatchParticipantId> {
    List<MatchParticipantEntity> findByMatchParticipantId(MatchParticipantId matchParticipantId);

    List<MatchParticipantEntity> findByMatchParticipantId_DataVersionAndMatchParticipantId_MatchId(@Param("dataVersion") String dataVersion, @Param("matchId") String matchId);

    List<MatchParticipantEntity> findByMatchParticipantId_Puuid(@Param("puuid") String puuid);
}
