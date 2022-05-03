package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.entity.TeamId;
import dev.saariselka.inlol.repository.TeamRepository;
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

    public List<TeamEntity> findAll() {
        List<TeamEntity> teams = new ArrayList<>();
        TeamRepository.findAll().forEach(e -> teams.add(e));

        return teams;
    }

    public List<TeamEntity> findByMatchIdAndTeamId(TeamId teamId) {
        return TeamRepository.findByTeamId(teamId);
    }

    public List<TeamEntity> findByMatchId(String matchId) {
        return TeamRepository.findByTeamId_MatchId(matchId);
    }

    public void insert(String matchId, int teamId, boolean win, Timestamp rrt) {
        TeamRepository.save( new TeamEntity(new TeamId(matchId,teamId),win, rrt));
    }
}
