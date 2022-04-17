package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueEntryId;
import dev.saariselka.inlol.entity.SummonerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueEntryRepository extends JpaRepository<LeagueEntryEntity, LeagueEntryId> {
    List<LeagueEntryEntity> findByLeagueEntryId(LeagueEntryId leagueEntryId);
}
