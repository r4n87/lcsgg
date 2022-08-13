package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import dev.saariselka.inlol.repository.MatchBanRepository;
import dev.saariselka.inlol.vo.MatchBanVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchBanService {
    @Autowired
    private final MatchBanRepository matchBanRepository;
    @Autowired
    VOMapper voMapper;

    public List<MatchBanVO> findByMatchId(String matchId) {
        return voMapper.toMatchBanVOList(matchBanRepository.findByMatchBanId_MatchId(matchId));
    }

    public List<MatchBanVO> findByMatchIdAndTeamId(String matchId, int teamId) {
        return voMapper.toMatchBanVOList(matchBanRepository.findByMatchBanId_MatchIdAndMatchBanId_TeamId(matchId, teamId));
    }

    public List<MatchBanVO> findByMatchBanId(MatchBanId matchBanId) {
        return voMapper.toMatchBanVOList(matchBanRepository.findByMatchBanId(matchBanId));
    }

    public void insert(String matchId, int pickTurn, int teamId, int championId, Timestamp rrt) {
        matchBanRepository.save( new MatchBanEntity(new MatchBanId(matchId, pickTurn, teamId), championId, rrt));
    }
}
