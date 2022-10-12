package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.LeagueEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueEntryRepository extends JpaRepository<LeagueEntry, Long> {
    List<LeagueEntry> findBySummonerId(String summonerId);
}
