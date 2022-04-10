package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchMasterId;
import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.repository.MatchMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchMasterService {
    @Autowired
    private final MatchMasterRepository matchMasterRepository;

    public List<MatchMasterEntity> findAll() {
        List<MatchMasterEntity> matchs = new ArrayList<>();
        matchMasterRepository.findAll().forEach(e -> matchs.add(e));

        return matchs;
    }

    public List<MatchMasterEntity> findByMatchId(String matchId) {
        List<MatchMasterEntity> matchs = matchMasterRepository.searchMatchByMatchId(matchId);
        return matchs;
    }

    public List<MatchMasterEntity> findByMatchMasterId(MatchMasterId matchMasterId) {
        List<MatchMasterEntity> matchs = matchMasterRepository.findByMatchMasterId(matchMasterId);
        return matchs;
    }

    public void insert(String dataVersion, String matchId, long gameCreation, long gameDuration, long gameEndTimeStamp, long gameId,
                       String gameMode, String gameName, long gameStartTimeStamp, String gameType, String gameVersion, int mapId,
                       String platformId, int queueId, String tournamentCode, int teamId1, int teamId2) {
        matchMasterRepository.save( new MatchMasterEntity(new MatchMasterId(dataVersion, matchId),gameCreation,gameDuration,
                gameEndTimeStamp,gameId,gameMode,
                gameName,gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,teamId1,teamId2, tournamentCode));
    }

}
