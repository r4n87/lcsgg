package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueEntryId;
import dev.saariselka.inlol.repository.LeagueEntryRepository;
import dev.saariselka.inlol.vo.LeagueEntryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeagueEntryService {

    @Autowired
    private final LeagueEntryRepository leagueEntryRepository;
    @Autowired
    private VOMapper voMapper;

    public List<LeagueEntryVO> findByLeagueEntryId(LeagueEntryId leagueEntryId) {
        return voMapper.toLeagueEntryVOList(leagueEntryRepository.findByLeagueEntryId(leagueEntryId));
    }

    public List<LeagueEntryVO> findByLeagueEntryId_SummonerId(String summonerId) {
        return voMapper.toLeagueEntryVOList(leagueEntryRepository.findByLeagueEntryId_SummonerId(summonerId));
    }

    public void insert(String summonerId, String queueType, String leagueId, String summonerName, String tier, String ranks, int leaguePoints, int wins, int losses, boolean hotStreak, boolean veteran, boolean freshBlood, boolean inactive, Timestamp rrt) {
        leagueEntryRepository.save( new LeagueEntryEntity( new LeagueEntryId(summonerId, queueType), leagueId, summonerName, tier, ranks, leaguePoints, wins, losses, hotStreak, veteran, freshBlood, inactive, rrt));
    }
}
