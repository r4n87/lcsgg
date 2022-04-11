package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import dev.saariselka.inlol.repository.MatchBanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchBanService {
    @Autowired
    private final MatchBanRepository matchBanRepository;

    public List<MatchBanEntity> findAll() {
        List<MatchBanEntity> bans = new ArrayList<>();
        matchBanRepository.findAll().forEach(e -> bans.add(e));
        return bans;
    }

    public List<MatchBanEntity> findByMatchId(String matchId) {
        List<MatchBanEntity> teams = matchBanRepository.searchBansByMatchId(matchId);
        return teams;
    }

    public List<MatchBanEntity> findByMatchBanId(MatchBanId matchBanId) {
        List<MatchBanEntity> bans = matchBanRepository.findByMatchBanId(matchBanId);
        return bans;
    }

    public void insert(String matchId, int pickTurn, int teamId, int championId, Timestamp rrt) {
        matchBanRepository.save( new MatchBanEntity(new MatchBanId(matchId, pickTurn, teamId), championId, rrt));
    }
}
