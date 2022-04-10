package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.BanDto;
import dev.saariselka.inlol.dto.MatchDto;
import dev.saariselka.inlol.dto.TeamDto;
import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.service.MatchBanService;
import dev.saariselka.inlol.service.MatchMasterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/match_ban")
public class MatchBanController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MatchBanService matchBanService;

    @GetMapping(value ="/{matchId}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<MatchBanEntity> getBans_ByMatchId(@PathVariable("matchId") String matchId) {
        List<MatchBanEntity> bans = matchBanService.findByMatchId(matchId);
        return bans;
    }

    @GetMapping(value ="/{matchId, pickTurn, teamId}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<MatchBanEntity> getBans_ByMatchBanId(@PathVariable("matchId") String matchId, @PathVariable("pickTurn") int pickTurn, @PathVariable("teamId") int teamId) {
        List<MatchBanEntity> bans = matchBanService.findByMatchBanId(new MatchBanId(matchId, pickTurn, teamId));
        return bans;
    }
}
