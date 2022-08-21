package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.vo.MatchMasterVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchMasterDtoTest {

    @Test
    @DisplayName("MatchMasterDto Lombok Get Function")
    public void testLombokGetFunction() {

        //given
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

        //when
        MatchMasterDto matchMasterDto = new MatchMasterDto(dataVersion,matchId,gameCreation,gameDuration,gameEndTimeStamp,gameId,gameMode,gameName,
                gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,queueType,teamId1,teamId2,tournamentCode);

        //then
        assertThat(matchMasterDto.getDataVersion()).isEqualTo(dataVersion);
        assertThat(matchMasterDto.getMatchId()).isEqualTo(matchId);
    }

    @Test
    @DisplayName("MatchMasterVO Lombok Set Function")
    public void testLombokSetFunction() {
        //given
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

        MatchMasterDto matchMasterDto = new MatchMasterDto(dataVersion,matchId,gameCreation,gameDuration,gameEndTimeStamp,gameId,gameMode,gameName,
                gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,queueType,teamId1,teamId2,tournamentCode);

        //when
        String testGameName = "TestGameName";
        matchMasterDto.setGameName(testGameName);

        //then
        assertThat(matchMasterDto.getGameName()).isEqualTo(testGameName);
    }
}
