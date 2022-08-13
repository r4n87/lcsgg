package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.TeamDto;
import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.entity.TeamId;
import dev.saariselka.inlol.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TeamService TeamService;

    @Autowired
    DtoMapper mapper;

    public List<TeamDto> getTeamsByMatchId(String matchId) {
        return mapper.toTeamDtoList(TeamService.findByMatchId(matchId));
    }

    public List<TeamDto> getTeamsByMatchIdAndTeamId(String matchId, int teamId) {
        return mapper.toTeamDtoList(TeamService.findByMatchIdAndTeamId(matchId, teamId));
    }

    public void insertTeamInfo(String matchId, int teamId, boolean win, Timestamp rrt) {
        TeamService.insert(matchId,teamId,win, rrt);
    }
}
