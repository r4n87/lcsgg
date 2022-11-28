package dev.saariselka.lcsgg.service;

import dev.saariselka.lcsgg.entity.LeagueEntry;
import dev.saariselka.lcsgg.repository.LeagueEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {
    @Autowired
    private LeagueEntryRepository leagueEntryRepository;

    public List<LeagueEntry> getLeagueEntriesBySummonerId(String summonerId) {
        return leagueEntryRepository.findBySummonerId(summonerId).get();
    }

    public void insert(LeagueEntry leagueEntry) {
        leagueEntryRepository.save(leagueEntry);
    }
}
