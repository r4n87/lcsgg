package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchMasterId;
import dev.saariselka.inlol.repository.MatchMasterRepository;
import dev.saariselka.inlol.vo.MatchMasterVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchMasterService {
    @Autowired
    private final MatchMasterRepository matchMasterRepository;
    @Autowired
    private VOMapper voMapper;

    public List<MatchMasterVO> findByMatchId(String matchId) {
        return voMapper.toMatchMasterVOList(matchMasterRepository.findByMatchMasterId_MatchId(matchId));
    }

    public List<MatchMasterVO> findByMatchMasterId(MatchMasterId matchMasterId) {
        return voMapper.toMatchMasterVOList(matchMasterRepository.findByMatchMasterId(matchMasterId));
    }

    public void insert(String dataVersion, String matchId, long gameCreation, long gameDuration, long gameEndTimeStamp, long gameId,
                       String gameMode, String gameName, long gameStartTimeStamp, String gameType, String gameVersion, int mapId,
                       String platformId, int queueId, String queueType, String tournamentCode, int teamId1, int teamId2, Timestamp rrt) {
        matchMasterRepository.save( new MatchMasterEntity(new MatchMasterId(dataVersion, matchId),gameCreation,gameDuration,
                gameEndTimeStamp,gameId, gameMode,
                gameName,gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId, queueType, teamId1,teamId2, tournamentCode, rrt));
    }

}
