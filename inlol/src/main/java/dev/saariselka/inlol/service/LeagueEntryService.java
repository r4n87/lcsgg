package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.repository.LeagueEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeagueEntryService {
    @Autowired
    private final LeagueEntryRepository leagueEntryRepository;

    public List<LeagueEntryEntity> findAll() {
        List<LeagueEntryEntity> league = new ArrayList<>();
        leagueEntryRepository.findAll().forEach(e -> league.add(e));
        return league;
    }

    public List<LeagueEntryEntity> findBySummonerId(String summonerId) {
        List<LeagueEntryEntity> league = leagueEntryRepository.findBySummonerId(summonerId);
        return league;
    }

    public void insert(String leagueId, String summonerId, String summonerName, String queueType, String tier, String rank, int leaguePoints, int wins, int losses, boolean hotStreak, boolean veteran, boolean freshBlood, boolean inactive, Timestamp rrt) {
        leagueEntryRepository.save( new LeagueEntryEntity( leagueId, summonerId, summonerName, queueType, tier, rank, leaguePoints, wins, losses, hotStreak, veteran, freshBlood, inactive, rrt ));
    }
}
