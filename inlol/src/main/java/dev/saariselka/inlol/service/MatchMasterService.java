package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.repository.MatchMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<MatchMasterEntity> findByDataVersionAndMatchId(String dataVersion,String matchId) {
        List<MatchMasterEntity> matchs = matchMasterRepository.findByDataVersionAndMatchId(dataVersion,matchId);
        return matchs;
    }

    public void insert(String dataVersion, String matchId, long gameCreation, long gameDuration, long gameEndTimeStamp, long gameid,
                       String gameMode, String gameName, long gameStartTimeStamp, String gameType, String gameVersion, int mapId,
                       String platformId, int queueId, String tournamentCode, int teamId1, int teamId2) {
        matchMasterRepository.save( new MatchMasterEntity(dataVersion,matchId,gameCreation,gameDuration,gameEndTimeStamp,gameid,gameMode,
                gameName,gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,tournamentCode,teamId1,teamId2));
    }

}
