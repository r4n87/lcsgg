package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.InfoDto;
import dev.saariselka.inlol.dto.MatchDto;
import dev.saariselka.inlol.dto.MetadataDto;
import dev.saariselka.inlol.dto.TeamDto;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchMasterId;
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
@RequestMapping(path = "/match_master")
public class MatchMasterController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MatchMasterService matchMasterService;

    @GetMapping(value ="/{matchId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<MatchMasterEntity> getMatchMaster_ByMatchId(@PathVariable("matchId") String matchId) {
        List<MatchMasterEntity> match = matchMasterService.findByMatchId(matchId);
        return match;
    }

    @GetMapping(value ="/{dataVersion,matchId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<MatchMasterEntity> getMatchMaster_ByDataVersionAndMatchId(@PathVariable("dataVersion") String dataVersion, @PathVariable("matchId") String matchId) {
        List<MatchMasterEntity> match = matchMasterService.findByMatchMasterId(new MatchMasterId(dataVersion, matchId));
        return match;
    }

    @GetMapping(value = "/insert/{dataVersion, matchId, gameCreation, gameDuration, gameEndTimeStamp, gameId, gameMode, gameName, " +
            "gameStartTimeStamp, gameType, gameVersion, mapId, platformId, queueId, tournamentCode, teamId1, teamId2}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public void insertMatchMaster(@PathVariable("dataVersion") String dataVersion, @PathVariable("matchId") String matchId, @PathVariable("gameCreation") long gameCreation,
                                  @PathVariable("gameDuration") long gameDuration, @PathVariable("gameEndTimeStamp") long gameEndTimeStamp, @PathVariable("gameId") long gameId,
                                  @PathVariable("gameMode") String gameMode, @PathVariable("gameName") String gameName, @PathVariable("gameStartTimeStamp") long gameStartTimeStamp,
                                  @PathVariable("gameType") String gameType, @PathVariable("gameVersion") String gameVersion, @PathVariable("mapId") int mapId,
                                  @PathVariable("platformId") String platformId, @PathVariable("queueId") int queueId, @PathVariable("tournamentCode") String tournamentCode,
                                  @PathVariable("teamId1") int teamId1, @PathVariable("teamId2") int teamId2) {
        matchMasterService.insert( dataVersion, matchId,gameCreation,gameDuration,gameEndTimeStamp,gameId,gameMode,
                gameName,gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,tournamentCode,teamId1,teamId2);
    }

}
