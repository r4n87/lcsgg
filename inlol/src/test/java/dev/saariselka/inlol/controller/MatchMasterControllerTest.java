package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.MatchMasterDto;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchMasterId;
import dev.saariselka.inlol.service.MatchMasterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MatchMasterControllerTest {

    @Autowired
    private MatchMasterController matchMasterController;
    @Autowired
    private MatchMasterService matchMasterService;
    @Autowired
    private DtoMapper dtoMapper;


    @Test
    @DisplayName("Insert Entity")
    public void insertMatchMaster() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        String dataVersion = "2";
        String matchId = "KR_5804413147";
        long gameCreation = 1646753771000L;
        long gameDuration = 694L;
        long gameEndTimeStamp = 1646754647544L;
        long gameId = 5803564866L;
        String gameMode = "ARAM";
        String gameName = "hondoner 님의 게임";
        long gameStartTimeStamp = 1646753953169L;
        String gameType = "CUSTOM_GAME";
        String gameVersion = "12.5.425.9171";
        int mapId = 12;
        String platformId = "KR";
        int queueId = 0;
        String queueType = "일반";
        int teamId1 = 100;
        int teamId2 = 200;
        String tournamentCode = null;

        // when
        matchMasterController.insertMatchMaster(dataVersion,matchId,gameCreation,gameDuration,gameEndTimeStamp,gameId,gameMode,gameName,gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,queueType, tournamentCode,teamId1,teamId2,rrt);

        // then
        MatchMasterDto matchMasterDtoSaved = dtoMapper.toMatchMasterDtoList(matchMasterService.findByMatchMasterId(new MatchMasterId(dataVersion, matchId))).get(0);

        assertThat(matchMasterDtoSaved.getDataVersion()).isEqualTo(dataVersion);
        assertThat(matchMasterDtoSaved.getMatchId()).isEqualTo(matchId);
    }

    @Test
    @DisplayName("Find Entity By MatchMasterId")
    public void getMatchMasterByMatchMasterId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        String dataVersionFirst = "2";
        String dataVersionSecond = "2";
        String matchIdFirst = "KR_5804413147";
        String matchIdSecond = "KR_5803565065";
        long gameCreationFirst = 1646753771000L;
        long gameCreationSecond = 1646754660000L;
        long gameDurationFirst = 694L;
        long gameDurationSecond = 1921L;
        long gameEndTimeStampFirst = 1646754647544L;
        long gameEndTimeStampSecond = 1646756796297L;
        long gameIdFirst = 5803564866L;
        long gameIdSecond = 5803565065L;
        String gameModeFirst = "ARAM";
        String gameModeSecond = "CLASSIC";
        String gameNameFirst = "hondoner 님의 게임";
        String gameNameSecond = "hondoner 님의 게임";
        long gameStartTimeStampFirst = 1646753953169L;
        long gameStartTimeStampSecond = 1646754874366L;
        String gameTypeFirst = "CUSTOM_GAME";
        String gameTypeSecond = "CUSTOM_GAME";
        String gameVersionFirst = "12.5.425.9171";
        String gameVersionSecond = "12.5.425.9171";
        int mapIdFirst = 12;
        int mapIdSecond = 12;
        String platformIdFirst = "KR";
        String platformIdSecond = "KR";
        int queueIdFirst = 0;
        int queueIdSecond = 0;
        String queueTypeFirst = "일반";
        String queueTypeSecond = "일반";
        int teamId1First = 100;
        int teamId1Second = 100;
        int teamId2First = 200;
        int teamId2Second = 200;
        String tournamentCodeFirst = null;
        String tournamentCodeSecond = null;

        matchMasterService.insert(dataVersionFirst,matchIdFirst,gameCreationFirst,gameDurationFirst,gameEndTimeStampFirst,gameIdFirst,gameModeFirst,gameNameFirst,gameStartTimeStampFirst,gameTypeFirst,gameVersionFirst,mapIdFirst,platformIdFirst,queueIdFirst,queueTypeFirst, tournamentCodeFirst,teamId1First,teamId2First,rrt);
        matchMasterService.insert(dataVersionSecond,matchIdSecond,gameCreationSecond,gameDurationSecond,gameEndTimeStampSecond,gameIdSecond,gameModeSecond,gameNameSecond,gameStartTimeStampSecond,gameTypeSecond,gameVersionSecond,mapIdSecond,platformIdSecond,queueIdSecond,queueTypeSecond, tournamentCodeSecond,teamId1Second,teamId2Second,rrt);

        // when
        MatchMasterDto matchMasterDtoFindFirst = matchMasterController.getMatchMasterByMatchMasterId(dataVersionFirst,matchIdFirst).get(0);
        MatchMasterDto matchMasterDtoFindSecond = matchMasterController.getMatchMasterByMatchMasterId(dataVersionSecond,matchIdSecond).get(0);

        // then
        assertThat(matchMasterDtoFindFirst.getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchMasterDtoFindFirst.getGameId()).isEqualTo(5803564866L);
        assertThat(matchMasterDtoFindSecond.getMatchId()).isEqualTo("KR_5803565065");
        assertThat(matchMasterDtoFindSecond.getGameId()).isEqualTo(5803565065L);
    }

    @Test
    @DisplayName("Find Entity By MatchMasterId.MatchId")
    public void getMatchMasterByMatchId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        String dataVersionFirst = "2";
        String dataVersionSecond = "2";
        String matchIdFirst = "KR_5804413147";
        String matchIdSecond = "KR_5803565065";
        long gameCreationFirst = 1646753771000L;
        long gameCreationSecond = 1646754660000L;
        long gameDurationFirst = 694L;
        long gameDurationSecond = 1921L;
        long gameEndTimeStampFirst = 1646754647544L;
        long gameEndTimeStampSecond = 1646756796297L;
        long gameIdFirst = 5803564866L;
        long gameIdSecond = 5803565065L;
        String gameModeFirst = "ARAM";
        String gameModeSecond = "CLASSIC";
        String gameNameFirst = "hondoner 님의 게임";
        String gameNameSecond = "hondoner 님의 게임";
        long gameStartTimeStampFirst = 1646753953169L;
        long gameStartTimeStampSecond = 1646754874366L;
        String gameTypeFirst = "CUSTOM_GAME";
        String gameTypeSecond = "CUSTOM_GAME";
        String gameVersionFirst = "12.5.425.9171";
        String gameVersionSecond = "12.5.425.9171";
        int mapIdFirst = 12;
        int mapIdSecond = 12;
        String platformIdFirst = "KR";
        String platformIdSecond = "KR";
        int queueIdFirst = 0;
        int queueIdSecond = 0;
        String queueTypeFirst = "일반";
        String queueTypeSecond = "일반";
        int teamId1First = 100;
        int teamId1Second = 100;
        int teamId2First = 200;
        int teamId2Second = 200;
        String tournamentCodeFirst = null;
        String tournamentCodeSecond = null;

        matchMasterService.insert(dataVersionFirst,matchIdFirst,gameCreationFirst,gameDurationFirst,gameEndTimeStampFirst,gameIdFirst,gameModeFirst,gameNameFirst,gameStartTimeStampFirst,gameTypeFirst,gameVersionFirst,mapIdFirst,platformIdFirst,queueIdFirst,queueTypeFirst,tournamentCodeFirst,teamId1First,teamId2First,rrt);
        matchMasterService.insert(dataVersionSecond,matchIdSecond,gameCreationSecond,gameDurationSecond,gameEndTimeStampSecond,gameIdSecond,gameModeSecond,gameNameSecond,gameStartTimeStampSecond,gameTypeSecond,gameVersionSecond,mapIdSecond,platformIdSecond,queueIdSecond,queueTypeSecond,tournamentCodeSecond,teamId1Second,teamId2Second,rrt);

        // when
        MatchMasterDto matchMasterDtoFindFirst = matchMasterController.getMatchMasterByMatchId(matchIdFirst).get(0);
        MatchMasterDto matchMasterDtoFindSecond = matchMasterController.getMatchMasterByMatchId(matchIdSecond).get(0);

        // then
        assertThat(matchMasterDtoFindFirst.getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchMasterDtoFindFirst.getGameId()).isEqualTo(5803564866L);
        assertThat(matchMasterDtoFindSecond.getMatchId()).isEqualTo("KR_5803565065");
        assertThat(matchMasterDtoFindSecond.getGameId()).isEqualTo(5803565065L);
    }
}

