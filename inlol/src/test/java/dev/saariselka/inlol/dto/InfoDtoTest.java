package dev.saariselka.inlol.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

public class InfoDtoTest {

    MatchMasterDto matchMasterDto;
    List<MatchTeamDto> matchTeamDtoList;
    MatchParticipantDto summonerInfo;

    @BeforeEach
    public void init() {
        matchMasterDto = createTestMatchMasterDto();
        matchTeamDtoList = createTestTeamDtoList();
        summonerInfo = createTestSummonerInfo();
    }

    @Test
    @DisplayName("InfoDto Lombok Get Function")
    public void testLombokGetFunction() {
        // Given

        //시간 차이 계산
        String convert_gameDuration = String.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())))
                + "분 "
                + String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) - (ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) * 60))
                + "초";

        String convert_gameAgoTime = null;

        if (ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.now()) >= 24)
        {
            convert_gameAgoTime = String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "일 전";
        }
        else
        {
            convert_gameAgoTime = String.valueOf(ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "시간 전";
        }

        // When
        InfoDto infoDto = new InfoDto(matchMasterDto, matchTeamDtoList,summonerInfo);

        // Then
        assertThat(infoDto.getGameCreation()).isEqualTo(matchMasterDto.getGameCreation());
        assertThat(infoDto.getGameDuration()).isEqualTo(convert_gameDuration);
        assertThat(infoDto.getGameEndTimestamp()).isEqualTo(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()));
        assertThat(infoDto.getGameId()).isEqualTo(matchMasterDto.getGameId());
        assertThat(infoDto.getQueueType()).isEqualTo(matchMasterDto.getQueueType());
        assertThat(infoDto.getGameName()).isEqualTo(matchMasterDto.getGameName());
        assertThat(infoDto.getGameStartTimeStamp()).isEqualTo(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameStartTimeStamp()),TimeZone.getDefault().toZoneId()));
        assertThat(infoDto.getGameType()).isEqualTo(matchMasterDto.getGameType());
        assertThat(infoDto.getGameVersion()).isEqualTo(matchMasterDto.getGameVersion());
        assertThat(infoDto.getMapId()).isEqualTo(String.valueOf(matchMasterDto.getMapId()));
        assertThat(infoDto.getPlatformId()).isEqualTo(matchMasterDto.getPlatformId());
        assertThat(infoDto.getGameAgoTime()).isEqualTo(convert_gameAgoTime);
        assertThat(infoDto.getSummoner()).isEqualTo(summonerInfo);
        assertThat(infoDto.getQueueId()).isEqualTo(String.valueOf(matchMasterDto.getQueueId()));
        assertThat(infoDto.getQueueType()).isEqualTo(String.valueOf(matchMasterDto.getQueueType()));
        assertThat(infoDto.getTeams()).isEqualTo(matchTeamDtoList);
        assertThat(infoDto.getTournamentCode()).isEqualTo(matchMasterDto.getTournamentCode());
    }


    @Test
    @DisplayName("InfoDto Lombok Set Function")
    public void testLombokSetFunction() {

        // Given
        long tobe_gameCreation = 101;
        long tobe_gameEndTimeStamp = 1646754647545L;
        long tobe_gameId = 101;
        String tobe_gameName = "tobe_testGameName";
        long tobe_gameStartTimeStamp = 1646753953170L;
        String tobe_gameType = "tobe_testGameType";
        String tobe_gameVersion = "tobe_testGameVersion";
        int tobe_mapId = 101;
        String tobe_platformId = "tobe_testPlatformId";
        int tobe_queueId = 450;
        String tobe_tournamentCode = "testTournamentCode";
        String tobe_queueType = "testQueueType";

        List<MatchTeamDto> tobe_Match_teamDtoList = new ArrayList<>();
        MatchParticipantDto tobe_summonerInfo = new MatchParticipantDto();

        //시간 차이 계산
        String tobe_convert_gameDuration = String.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameStartTimeStamp), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp), TimeZone.getDefault().toZoneId())))
                + "분 "
                + String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameStartTimeStamp), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp), TimeZone.getDefault().toZoneId())) - (ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameStartTimeStamp), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp), TimeZone.getDefault().toZoneId())) * 60))
                + "초";

        String tobe_convert_gameAgoTime = null;

        if (ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp), TimeZone.getDefault().toZoneId()), LocalDateTime.now()) >= 24)
        {
            tobe_convert_gameAgoTime = String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "일 전";
        }
        else
        {
            tobe_convert_gameAgoTime = String.valueOf(ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "시간 전";
        }

        InfoDto infoDto = new InfoDto(matchMasterDto, matchTeamDtoList,summonerInfo);

        // When
        infoDto.setGameCreation(tobe_gameCreation);
        infoDto.setGameDuration(tobe_convert_gameDuration);
        infoDto.setGameEndTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp),TimeZone.getDefault().toZoneId()));
        infoDto.setGameId(tobe_gameId);
        infoDto.setQueueType(tobe_queueType);
        infoDto.setGameName(tobe_gameName);
        infoDto.setGameStartTimeStamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameStartTimeStamp),TimeZone.getDefault().toZoneId()));
        infoDto.setGameType(tobe_gameType);
        infoDto.setGameVersion(tobe_gameVersion);
        infoDto.setMapId(String.valueOf(tobe_mapId));
        infoDto.setPlatformId(tobe_platformId);
        infoDto.setGameAgoTime(tobe_convert_gameAgoTime);
        infoDto.setSummoner(tobe_summonerInfo);
        infoDto.setQueueId(String.valueOf(tobe_queueId));
        infoDto.setQueueType(tobe_queueType);
        infoDto.setTeams(tobe_Match_teamDtoList);
        infoDto.setTournamentCode(tobe_tournamentCode);

        // Then
        assertThat(infoDto.getGameCreation()).isEqualTo(tobe_gameCreation);
        assertThat(infoDto.getGameDuration()).isEqualTo(tobe_convert_gameDuration);
        assertThat(infoDto.getGameEndTimestamp()).isEqualTo(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameEndTimeStamp),TimeZone.getDefault().toZoneId()));
        assertThat(infoDto.getGameId()).isEqualTo(tobe_gameId);
        assertThat(infoDto.getQueueType()).isEqualTo(tobe_queueType);
        assertThat(infoDto.getGameName()).isEqualTo(tobe_gameName);
        assertThat(infoDto.getGameStartTimeStamp()).isEqualTo(LocalDateTime.ofInstant(Instant.ofEpochMilli(tobe_gameStartTimeStamp),TimeZone.getDefault().toZoneId()));
        assertThat(infoDto.getGameType()).isEqualTo(tobe_gameType);
        assertThat(infoDto.getGameVersion()).isEqualTo(tobe_gameVersion);
        assertThat(infoDto.getMapId()).isEqualTo(String.valueOf(tobe_mapId));
        assertThat(infoDto.getPlatformId()).isEqualTo(tobe_platformId);
        assertThat(infoDto.getGameAgoTime()).isEqualTo(tobe_convert_gameAgoTime);
        assertThat(infoDto.getSummoner()).isEqualTo(tobe_summonerInfo);
        assertThat(infoDto.getQueueId()).isEqualTo(String.valueOf(tobe_queueId));
        assertThat(infoDto.getQueueType()).isEqualTo(tobe_queueType);
        assertThat(infoDto.getTeams()).isEqualTo(tobe_Match_teamDtoList);
        assertThat(infoDto.getTournamentCode()).isEqualTo(tobe_tournamentCode);
    }


    private MatchParticipantDto createTestSummonerInfo() {
        MatchParticipantDto summoner = new MatchParticipantDto();
        return summoner;

    }

    private List<MatchTeamDto> createTestTeamDtoList() {
        List<MatchTeamDto> teamlist = new ArrayList<>();
        return teamlist;
    }

    private MatchMasterDto createTestMatchMasterDto() {

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
        String queueType = "testQueueType";

        return new MatchMasterDto(dataVersion,matchId,gameCreation,gameDuration,gameEndTimeStamp,gameId,gameMode,gameName,gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,queueType, teamId1,teamId2,tournamentCode);
    }
}
