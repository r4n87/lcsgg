package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.entity.TeamId;
import dev.saariselka.inlol.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/Team")
public class TeamController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TeamService TeamService;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<TeamEntity>> getAllteams() {
        List<TeamEntity> teams = TeamService.findAll();
        return new ResponseEntity<List<TeamEntity>>(teams, HttpStatus.OK);
    }

    @GetMapping(value ="/{matchId,teamId}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<TeamEntity>> getTeams_ByMatchidAndTeamid(@PathVariable("matchId") String matchId,@PathVariable("teamId") int teamId) {
        List<TeamEntity> teams = TeamService.findByMatchIdAndTeamId(new TeamId(matchId,teamId));
        return new ResponseEntity<List<TeamEntity>>(teams, HttpStatus.OK);
    }

    @GetMapping(value = "/insert/{matchId, teamId, win}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public void insertTeamInfo(@PathVariable("matchId") String matchId, @PathVariable("teamId") int teamId, @PathVariable("win") boolean win) {
        TeamService.insert(matchId,teamId,win);
    }

}
