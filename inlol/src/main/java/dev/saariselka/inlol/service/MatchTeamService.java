package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.entity.TeamId;
import dev.saariselka.inlol.repository.MatchTeamRepository;
import dev.saariselka.inlol.vo.MatchTeamVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchTeamService {

    @Autowired
    private final MatchTeamRepository MatchTeamRepository;

    @Autowired
    VOMapper mapper;

    public List<MatchTeamVO> findByMatchIdAndTeamId(String matchId, int teamId) {
        return mapper.toMatchTeamVOList(MatchTeamRepository.findByTeamId(new TeamId(matchId, teamId)));
    }

    public List<MatchTeamVO> findByMatchId(String matchId) {
        return mapper.toMatchTeamVOList(MatchTeamRepository.findByTeamId_MatchId(matchId));
    }

    public void insert(String matchId, int teamId, boolean win, Timestamp rrt) {
        MatchTeamRepository.save( new TeamEntity(new TeamId(matchId,teamId),win, rrt));
    }
}
