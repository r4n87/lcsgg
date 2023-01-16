package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    Optional<Match> findByMetadata_MatchId(String matchId);

    @Query("select m from Match m left join m.info i left join i.participants p where p.puuid = :puuid")
    List<Match> findMatchListByPuuid(@Param("puuid") String puuid);
}


