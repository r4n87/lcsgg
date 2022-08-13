package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.entity.TeamId;
import dev.saariselka.inlol.repository.TeamRepository;
import dev.saariselka.inlol.vo.TeamVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    @Autowired
    private final TeamRepository TeamRepository;

    @Autowired
    VOMapper mapper;

    public List<TeamVO> findByMatchIdAndTeamId(String matchId, int teamId) {
        return mapper.toTeamVOList(TeamRepository.findByTeamId(new TeamId(matchId, teamId)));
    }

    public List<TeamVO> findByMatchId(String matchId) {
        return mapper.toTeamVOList(TeamRepository.findByTeamId_MatchId(matchId));
    }

    public void insert(String matchId, int teamId, boolean win, Timestamp rrt) {
        TeamRepository.save( new TeamEntity(new TeamId(matchId,teamId),win, rrt));
    }
}
