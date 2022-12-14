package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.MatchMasterDto;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchMasterId;
import dev.saariselka.inlol.service.MatchMasterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/match_master")
public class MatchMasterController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MatchMasterService matchMasterService;
    @Autowired
    DtoMapper dtoMapper;

    public List<MatchMasterDto> getMatchMasterByMatchId(String matchId) {
        List<MatchMasterDto> match = dtoMapper.toMatchMasterDtoList(matchMasterService.findByMatchId(matchId));
        return match;
    }

    public List<MatchMasterDto> getMatchMasterByMatchMasterId(String dataVersion, String matchId) {
        List<MatchMasterDto> match = dtoMapper.toMatchMasterDtoList(matchMasterService.findByMatchMasterId(new MatchMasterId(dataVersion, matchId)));
        return match;
    }

    public void insertMatchMaster(String dataVersion, String matchId, long gameCreation,
                                  long gameDuration, long gameEndTimeStamp, long gameId,
                                  String gameMode, String gameName, long gameStartTimeStamp,
                                  String gameType, String gameVersion, int mapId,
                                  String platformId, int queueId, String queueType, String tournamentCode,
                                  int teamId1, int teamId2, Timestamp rrt) {
        matchMasterService.insert( dataVersion, matchId,gameCreation,gameDuration,gameEndTimeStamp,gameId,gameMode,
                gameName,gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,queueType,tournamentCode,teamId1,teamId2, rrt);
    }

}
