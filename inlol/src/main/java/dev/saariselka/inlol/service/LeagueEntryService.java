package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueEntryId;
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

    public List<LeagueEntryEntity> findByLeagueEntryId(LeagueEntryId leagueEntryId) {
        return leagueEntryRepository.findByLeagueEntryId(leagueEntryId);
    }

    public List<LeagueEntryEntity> findByLeagueEntryId_SummonerId(String summonerId) {
        return leagueEntryRepository.findByLeagueEntryId_SummonerId(summonerId);
    }

    public void insert(String summonerId, String queueType, String leagueId, String summonerName, String tier, String ranks, int leaguePoints, int wins, int losses, boolean hotStreak, boolean veteran, boolean freshBlood, boolean inactive, Timestamp rrt) {
        leagueEntryRepository.save( new LeagueEntryEntity( new LeagueEntryId(summonerId, queueType), leagueId, summonerName, tier, ranks, leaguePoints, wins, losses, hotStreak, veteran, freshBlood, inactive, rrt));
    }
}
