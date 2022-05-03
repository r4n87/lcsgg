package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueEntryId;
import dev.saariselka.inlol.service.LeagueEntryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/league_entry")
public class LeagueEntryController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LeagueEntryService leagueEntryService;

    public List<LeagueEntryEntity> getLeagueEntries_ByLeagueEntryId(String summonerId, String queueType) {
        return leagueEntryService.findByLeagueEntryId(new LeagueEntryId(summonerId, queueType));
    }

    public List<LeagueEntryEntity> getLeagueEntries_BySummonerId(String summonerId) {
        return leagueEntryService.findByLeagueEntryId_SummonerId(summonerId);
    }

    public void insertLeagueEntryInfo(String summonerId, String queueType, String leagueId, String summonerName, String tier, String rank, int leaguePoints, int wins, int losses, boolean hotStreak, boolean veteran, boolean freshBlood, boolean inactive, Timestamp rrt) {
        leagueEntryService.insert(summonerId, queueType, leagueId, summonerName, tier, rank, leaguePoints, wins, losses, hotStreak, veteran, freshBlood, inactive, rrt);
    }
}
