package dev.saariselka.inlol.repository;


import dev.saariselka.inlol.entity.SummonerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummonerRepository extends JpaRepository<SummonerEntity, Long> {
    public List<SummonerEntity> findById(String puuid);

    @Query(value = "SELECT ACCOUNTID PROFILEICONID REVISIONDATE NAME ID SUMMONERLEVEL FROM RIOT_SUMMONER WHERE PUUID = :puuid", nativeQuery = true)
    List<SummonerEntity> searchSummoner(@Param("puuid") String puuid);
}
