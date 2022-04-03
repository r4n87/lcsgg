package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.InfoDto;
import dev.saariselka.inlol.dto.MatchDto;
import dev.saariselka.inlol.dto.MetadataDto;
import dev.saariselka.inlol.dto.TeamDto;
import dev.saariselka.inlol.entity.MatchMasterEntity;
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

    /*
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<MatchMasterEntity>> getAllapis() {
        List<MatchMasterEntity> match = matchMasterService.findAll();
        return new ResponseEntity<List<MatchMasterEntity>>(match, HttpStatus.OK);
    }
    */

//    @GetMapping(value ="/{dataversion,matchid}",produces = { MediaType.APPLICATION_JSON_VALUE })
//    public MatchDto getMatchMaster_ByDataversionAndMatchid(@PathVariable("dataversion") String dataversion, @PathVariable("matchid") String matchid) {
//        List<MatchMasterEntity> match = matchMasterService.findByDataversionAndMatchid(dataversion,matchid);
//        // todo : adapter가 따로 있어야 하나? 코드 지저분?
//        MetadataDto metadataDto = new MetadataDto(match.get(0).getDataVersion(), match.get(0).getMatchId());
//        InfoDto infoDto = new InfoDto();
//        infoDto.setGameCreation(match.get(0).getGameCreation());
//        infoDto.setGameEndTimestamp(match.get(0).getGameEndTimeStamp());
//        infoDto.setGameDuration(match.get(0).getGameDuration());
//        infoDto.setGameId(match.get(0).getGameId());
//        infoDto.setGameMode(match.get(0).getGameMode());
//        infoDto.setGameName(match.get(0).getGameName());
//        infoDto.setGameStartTimeStamp(match.get(0).getGameStartTimeStamp());
//        infoDto.setGameType(match.get(0).getGameType());
//        infoDto.setGameVersion(match.get(0).getGameVersion());
//        infoDto.setMapId(match.get(0).getMapId());
//        infoDto.setPlatformId(match.get(0).getPlatformId());
//        infoDto.setQueueId(match.get(0).getQueueId());
//
//        TeamDto teamDto1 = new TeamDto();
//        teamDto1.setTeamId(match.get(0).getTeamId1());
//
//        TeamDto teamDto2 = new TeamDto();
//        teamDto2.setTeamId(match.get(0).getTeamId2());
//
//        List<TeamDto> teams = new ArrayList<>();
//        teams.add(teamDto1);
//        teams.add(teamDto2);
//        infoDto.setTeams(teams);
//        infoDto.setTournamentCode(match.get(0).getTournamentCode());
//
//        MatchDto matchDto = new MatchDto(metadataDto, infoDto);
//        return matchDto;
//    }

    @GetMapping(value = "/insert/{dataVersion, matchId, gameCreation, gameDuration, gameEndTimeStamp, gameid, gameMode, gameName, " +
            "gameStartTimeStamp, gameType, gameVersion, mapId, platformId, queueId, tournamentCode, teamId1, teamId2}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public void insertMatchMaster(@PathVariable("dataVersion") String dataVersion, @PathVariable("matchId") String matchId, @PathVariable("gameCreation") long gameCreation,
                                  @PathVariable("gameDuration") long gameDuration, @PathVariable("gameEndTimeStamp") long gameEndTimeStamp, @PathVariable("gameid") long gameid,
                                  @PathVariable("gameMode") String gameMode, @PathVariable("gameName") String gameName, @PathVariable("gameStartTimeStamp") long gameStartTimeStamp,
                                  @PathVariable("gameType") String gameType, @PathVariable("gameVersion") String gameVersion, @PathVariable("mapId") int mapId,
                                  @PathVariable("platformId") String platformId, @PathVariable("queueId") int queueId, @PathVariable("tournamentCode") String tournamentCode,
                                  @PathVariable("teamId1") int teamId1, @PathVariable("teamId2") int teamId2) {
        matchMasterService.insert( dataVersion,matchId,gameCreation,gameDuration,gameEndTimeStamp,gameid,gameMode,
                gameName,gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,tournamentCode,teamId1,teamId2);
    }

}
