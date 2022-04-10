package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.ObjectiveDto;
import dev.saariselka.inlol.dto.ObjectivesDto;
import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import dev.saariselka.inlol.entity.MatchObjectivesId;
import dev.saariselka.inlol.service.MatchObjectivesService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/match_objectives")
public class MatchObjectivesController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MatchObjectivesService matchObjectivesService;

    @GetMapping(value ="/{matchId,teamId}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<MatchObjectivesEntity> getMatchObjectives_ByMatchIdAndTeamId(@PathVariable("matchId") String matchId, @PathVariable("teamId") int teamId) {
        List<MatchObjectivesEntity> objectives = matchObjectivesService.findByMatchObjectivesId(new MatchObjectivesId(matchId, teamId));
        return objectives;
    }
}
