package dev.saariselka.inlol.controller;

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
import java.sql.Timestamp;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchObjectivesController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MatchObjectivesService matchObjectivesService;

    public List<MatchObjectivesEntity> getMatchObjectives_ByMatchIdAndTeamId(String matchId, int teamId) {
        List<MatchObjectivesEntity> objectives = matchObjectivesService.findByMatchObjectivesId(new MatchObjectivesId(matchId, teamId));
        return objectives;
    }

    public void insertObjectivesInfo(String matchId, int teamId, boolean baronFirst, int baronKills, boolean championFirst,  int championKills,
                                     boolean dragonFirst,  int dragonKills, boolean inhibitorFirst,  int inhibitorKills,
                                     boolean riftheraldFirst,  int riftheraldKills, boolean towerFirst,  int towerKills, Timestamp rrt) {
        matchObjectivesService.insert(matchId, teamId, baronFirst, baronKills, championFirst, championKills, dragonFirst, dragonKills, inhibitorFirst, inhibitorKills, riftheraldFirst, riftheraldKills, towerFirst, towerKills, rrt);
    }
}
