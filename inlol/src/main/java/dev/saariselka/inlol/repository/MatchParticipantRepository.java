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

    @Query(value = "SELECT * FROM riot_match_participant WHERE data_version = :dataVersion and match_id = :matchId", nativeQuery = true)
    List<MatchParticipantEntity> searchMatchesByDataVersionAndMatchId(@Param("dataVersion") String dataVersion, @Param("matchId") String matchId);

    @Query(value = "SELECT * FROM riot_match_participant WHERE puuid = :puuid", nativeQuery = true)
    List<MatchParticipantEntity> searchMatchesByPuuid(@Param("puuid") String puuid);
}
