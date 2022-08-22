package dev.saariselka.inlol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TimeZone;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InfoDto {
    private long gameCreation;
    private String gameDuration;
    private LocalDateTime gameEndTimestamp;
    private long gameId;
    private String queueType;
    private String gameName;
    private LocalDateTime gameStartTimeStamp;
    private String gameType;
    private String gameVersion;
    private String mapId;
    private String platformId;
    private String gameAgoTime;
    private MatchParticipantDto summoner;
    private String queueId;
    private List<MatchTeamDto> teams;
    private String tournamentCode;

    public InfoDto (MatchMasterDto matchMasterDto, List<MatchTeamDto> matchTeamDtoList, MatchParticipantDto summonerInfo) {

        //시간 차이 계산
        String gameDuration = String.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())))
                + "분 "
                + String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) - (ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) * 60))
                + "초";

        String gameAgoTime = null;

        if (ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.now()) >= 24)
        {
            gameAgoTime = String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "일 전";
        }
        else
        {
            gameAgoTime = String.valueOf(ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "시간 전";
        }

        //1. Match Master 정보 생성

        this.gameCreation = matchMasterDto.getGameCreation();
        this.gameDuration = gameDuration;
        this.gameEndTimestamp = LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId());
        this.gameId = matchMasterDto.getGameId();
        //this.queueType = JsonParserForLOL.getKRGameModeByQueueId(matchMasterEntity.getQueueId());
        this.queueType = matchMasterDto.getQueueType();
        this.gameName = matchMasterDto.getGameName();
        this.gameStartTimeStamp = LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterDto.getGameStartTimeStamp()),TimeZone.getDefault().toZoneId());
        this.gameType = matchMasterDto.getGameType();
        this.gameVersion = matchMasterDto.getGameVersion();
        this.mapId = String.valueOf(matchMasterDto.getMapId());
        this.platformId = matchMasterDto.getPlatformId();
        this.queueId = String.valueOf(matchMasterDto.getQueueId());
        this.tournamentCode = matchMasterDto.getTournamentCode();
        this.gameAgoTime = gameAgoTime;
        this.teams = matchTeamDtoList;
        this.summoner = summonerInfo;
    }
}
