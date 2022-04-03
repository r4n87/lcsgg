package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.MatchDto;
import dev.saariselka.inlol.dto.ObjectiveDto;
import dev.saariselka.inlol.dto.ObjectivesDto;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import dev.saariselka.inlol.service.MatchMasterService;
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

    @GetMapping(value ="/{matchid,teamid}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public ObjectivesDto getMatchMaster_ByMatchidAndTeamid(@PathVariable("matchid") String matchid, @PathVariable("teamid") Integer teamid) {
        List<MatchObjectivesEntity> objectives = matchObjectivesService.findByMatchidAndTeamid(matchid, teamid);

        ObjectiveDto baron = new ObjectiveDto();
        baron.setFirst(objectives.get(0).getBaron_first());
        baron.setKills(objectives.get(0).getBaron_kills());

        ObjectiveDto champion = new ObjectiveDto();
        champion.setFirst(objectives.get(0).getChampion_first());
        champion.setKills(objectives.get(0).getChampion_kills());

        ObjectiveDto dragon = new ObjectiveDto();
        dragon.setFirst(objectives.get(0).getDragon_first());
        dragon.setKills(objectives.get(0).getDragon_kills());

        ObjectiveDto inhibitor = new ObjectiveDto();
        inhibitor.setFirst(objectives.get(0).getInhibitor_first());
        inhibitor.setKills(objectives.get(0).getInhibitor_kills());

        ObjectiveDto riftHerald = new ObjectiveDto();
        riftHerald.setFirst(objectives.get(0).getRiftherald_first());
        riftHerald.setKills(objectives.get(0).getRiftherald_kills());

        ObjectiveDto tower = new ObjectiveDto();
        tower.setFirst(objectives.get(0).getTower_first());
        tower.setKills(objectives.get(0).getTower_kills());

        ObjectivesDto objectivesDto = new ObjectivesDto(baron, champion, dragon, inhibitor, riftHerald, tower);
        return objectivesDto;
    }
}
