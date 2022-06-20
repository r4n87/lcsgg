package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.*;
import dev.saariselka.inlol.utils.JsonParserForLOL;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

public class InfoDtoTest {

    @Test
    public void testLombokGetFunction() {
        // Given
        String dataVersion = "testDataVersion";
        String matchId = "testMatchId";
        long gameCreation = 100;
        long gameDuration = 100;
        long gameEndTimeStamp = 1646754647544L;
        long gameId = 100;
        String gameMode = "testGameMode";
        String gameName = "testGameName";
        long gameStartTimeStamp = 1646753953169L;
        String gameType = "testGameType";
        String gameVersion = "testGameVersion";
        int mapId = 100;
        String platformId = "testPlatformId";
        int queueId = 420;
        int teamId1 = 100;
        int teamId2 = 200;
        String tournamentCode = "testTournamentCode";
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        MatchMasterEntity matchMasterEntity = new MatchMasterEntity(new MatchMasterId(dataVersion,matchId),gameCreation,gameDuration,gameEndTimeStamp,gameId,gameMode,gameName,gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,teamId1,teamId2,tournamentCode,rrt);

        List<TeamDto> teamDtoList = new ArrayList<>();
        List<ParticipantDto> blueParticipantDtoList = new ArrayList<>();
        List<ParticipantDto> redParticipantDtoList = new ArrayList<>();

        ParticipantDto summonerInfo = new ParticipantDto();

        //시간 차이 계산
        String convert_gameDuration = String.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())))
                + "분 "
                + String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) - (ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) * 60))
                + "초";

        String convert_gameAgoTime = null;

        if (ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.now()) >= 24)
        {
            convert_gameAgoTime = String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "일 전";
        }
        else
        {
            convert_gameAgoTime = String.valueOf(ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "시간 전";
        }

        // When
        InfoDto infoDto = new InfoDto(matchMasterEntity,teamDtoList,blueParticipantDtoList,redParticipantDtoList,summonerInfo);

        // Then
        assertThat(infoDto.getGameCreation()).isEqualTo(gameCreation);
        assertThat(infoDto.getGameDuration()).isEqualTo(convert_gameDuration);
        assertThat(infoDto.getGameEndTimestamp()).isEqualTo(LocalDateTime.ofInstant(Instant.ofEpochMilli(gameEndTimeStamp),TimeZone.getDefault().toZoneId()));
        assertThat(infoDto.getGameId()).isEqualTo(gameId);
        assertThat(infoDto.getGameMode()).isEqualTo(JsonParserForLOL.getKRGameModeByQueueId(queueId));
        assertThat(infoDto.getGameName()).isEqualTo(gameName);
        assertThat(infoDto.getGameStartTimeStamp()).isEqualTo(LocalDateTime.ofInstant(Instant.ofEpochMilli(gameStartTimeStamp),TimeZone.getDefault().toZoneId()));
        assertThat(infoDto.getGameType()).isEqualTo(gameType);
        assertThat(infoDto.getGameVersion()).isEqualTo(gameVersion);
        assertThat(infoDto.getMapId()).isEqualTo(String.valueOf(mapId));
        assertThat(infoDto.getBlueParticipants()).isEqualTo(blueParticipantDtoList);
        assertThat(infoDto.getRedParticipants()).isEqualTo(redParticipantDtoList);
        assertThat(infoDto.getPlatformId()).isEqualTo(platformId);
        assertThat(infoDto.getGameAgoTime()).isEqualTo(convert_gameAgoTime);
        assertThat(infoDto.getSummoner()).isEqualTo(summonerInfo);
        assertThat(infoDto.getQueueId()).isEqualTo(String.valueOf(queueId));
        assertThat(infoDto.getTeams()).isEqualTo(teamDtoList);
        assertThat(infoDto.getTournamentCode()).isEqualTo(tournamentCode);
    }


    @Test
    public void testLombokSetFunction() {

        // Given
        String dataVersion = "testDataVersion";
        String matchId = "testMatchId";
        long gameCreation = 100;
        long tobe_gameCreation = 101;
        long gameDuration = 100;
        long gameEndTimeStamp = 1646754647544L;
        long tobe_gameEndTimeStamp = 1646754647545L;
        long gameId = 100;
        long tobe_gameId = 101;
        String gameMode = "testGameMode";
        String gameName = "testGameName";
        String tobe_gameName = "tobe_testGameName";
        long gameStartTimeStamp = 1646753953169L;
        long tobe_gameStartTimeStamp = 1646753953170L;
        String gameType = "testGameType";
        String tobe_gameType = "tobe_testGameType";
        String gameVersion = "testGameVersion";
        String tobe_gameVersion = "tobe_testGameVersion";
        int mapId = 100;
        int tobe_mapId = 101;
        String platformId = "testPlatformId";
        String tobe_platformId = "tobe_testPlatformId";
        int queueId = 420;
        int tobe_queueId = 450;
        int teamId1 = 100;
        int teamId2 = 200;
        String tournamentCode = "testTournamentCode";
        String tobe_tournamentCode = "testTournamentCode";
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        MatchMasterEntity matchMasterEntity = new MatchMasterEntity(new MatchMasterId(dataVersion,matchId),gameCreation,gameDuration,gameEndTimeStamp,gameId,gameMode,gameName,gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,teamId1,teamId2,tournamentCode,rrt);

        List<TeamDto> teamDtoList = new ArrayList<>();
        List<TeamDto> tobe_teamDtoList = new ArrayList<>();
        List<ParticipantDto> blueParticipantDtoList = new ArrayList<>();
        List<ParticipantDto> tobe_blueParticipantDtoList = new ArrayList<>();
        List<ParticipantDto> redParticipantDtoList = new ArrayList<>();
        List<ParticipantDto> tobe_redParticipantDtoList = new ArrayList<>();
        ParticipantDto summonerInfo = new ParticipantDto();
        ParticipantDto tobe_summonerInfo = new ParticipantDto();

        //시간 차이 계산
        String convert_gameDuration = String.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())))
                + "분 "
                + String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) - (ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) * 60))
                + "초";

        String convert_gameAgoTime = null;

        if (ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.now()) >= 24)
        {
            convert_gameAgoTime = String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "일 전";
        }
        else
        {
            convert_gameAgoTime = String.valueOf(ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "시간 전";
        }

        //시간 차이 계산
        String tobe_convert_gameDuration = String.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameStartTimeStamp), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp), TimeZone.getDefault().toZoneId())))
                + "분 "
                + String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameStartTimeStamp), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp), TimeZone.getDefault().toZoneId())) - (ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameStartTimeStamp), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp), TimeZone.getDefault().toZoneId())) * 60))
                + "초";

        String tobe_convert_gameAgoTime = null;

        if (ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp), TimeZone.getDefault().toZoneId()), LocalDateTime.now()) >= 24)
        {
            convert_gameAgoTime = String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "일 전";
        }
        else
        {
            convert_gameAgoTime = String.valueOf(ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "시간 전";
        }

        InfoDto infoDto = new InfoDto(matchMasterEntity,teamDtoList,blueParticipantDtoList,redParticipantDtoList,summonerInfo);

        // When
        infoDto.setGameCreation(tobe_gameCreation);
        infoDto.setGameDuration(tobe_convert_gameDuration);
        infoDto.setGameEndTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp),TimeZone.getDefault().toZoneId()));
        infoDto.setGameId(tobe_gameId);
        infoDto.setGameMode(JsonParserForLOL.getKRGameModeByQueueId(tobe_queueId));
        infoDto.setGameName(tobe_gameName);
        infoDto.setGameStartTimeStamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameStartTimeStamp),TimeZone.getDefault().toZoneId()));
        infoDto.setGameType(tobe_gameType);
        infoDto.setGameVersion(tobe_gameVersion);
        infoDto.setMapId(String.valueOf(tobe_mapId));
        infoDto.setBlueParticipants(tobe_blueParticipantDtoList);
        infoDto.setRedParticipants(tobe_redParticipantDtoList);
        infoDto.setPlatformId(tobe_platformId);
        infoDto.setGameAgoTime(tobe_convert_gameAgoTime);
        infoDto.setSummoner(tobe_summonerInfo);
        infoDto.setQueueId(String.valueOf(tobe_queueId));
        infoDto.setTeams(tobe_teamDtoList);
        infoDto.setTournamentCode(tobe_tournamentCode);

        // Then
        assertThat(infoDto.getGameCreation()).isEqualTo(tobe_gameCreation);
        assertThat(infoDto.getGameDuration()).isEqualTo(tobe_convert_gameDuration);
        assertThat(infoDto.getGameEndTimestamp()).isEqualTo(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp),TimeZone.getDefault().toZoneId()));
        assertThat(infoDto.getGameId()).isEqualTo(tobe_gameId);
        assertThat(infoDto.getGameMode()).isEqualTo(JsonParserForLOL.getKRGameModeByQueueId(tobe_queueId));
        assertThat(infoDto.getGameName()).isEqualTo(tobe_gameName);
        assertThat(infoDto.getGameStartTimeStamp()).isEqualTo(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameStartTimeStamp),TimeZone.getDefault().toZoneId()));
        assertThat(infoDto.getGameType()).isEqualTo(tobe_gameType);
        assertThat(infoDto.getGameVersion()).isEqualTo(tobe_gameVersion);
        assertThat(infoDto.getMapId()).isEqualTo(String.valueOf(tobe_mapId));
        assertThat(infoDto.getBlueParticipants()).isEqualTo(tobe_blueParticipantDtoList);
        assertThat(infoDto.getRedParticipants()).isEqualTo(tobe_redParticipantDtoList);
        assertThat(infoDto.getPlatformId()).isEqualTo(tobe_platformId);
        assertThat(infoDto.getGameAgoTime()).isEqualTo(tobe_convert_gameAgoTime);
        assertThat(infoDto.getSummoner()).isEqualTo(tobe_summonerInfo);
        assertThat(infoDto.getQueueId()).isEqualTo(String.valueOf(tobe_queueId));
        assertThat(infoDto.getTeams()).isEqualTo(tobe_teamDtoList);
        assertThat(infoDto.getTournamentCode()).isEqualTo(tobe_tournamentCode);
    }
}
