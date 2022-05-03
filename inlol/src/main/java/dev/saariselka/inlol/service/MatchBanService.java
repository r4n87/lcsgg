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
        return matchBanRepository.findByMatchBanId_MatchId(matchId);
    }

    public List<MatchBanEntity> findByMatchIdAndTeamId(String matchId, int teamId) {
        return matchBanRepository.findByMatchBanId_MatchIdAndMatchBanId_TeamId(matchId, teamId);
    }

    public List<MatchBanEntity> findByMatchBanId(MatchBanId matchBanId) {
        return matchBanRepository.findByMatchBanId(matchBanId);
    }

    public void insert(String matchId, int pickTurn, int teamId, int championId, Timestamp rrt) {
        matchBanRepository.save( new MatchBanEntity(new MatchBanId(matchId, pickTurn, teamId), championId, rrt));
    }
}
