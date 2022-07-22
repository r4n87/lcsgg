package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.utils.JsonParserForLOL;
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
    private ParticipantDto summoner;
    private String queueId;
    private List<TeamDto> teams;
    private String tournamentCode;

    public InfoDto (MatchMasterEntity matchMasterEntity, List<TeamDto> teamDtoList, ParticipantDto summonerInfo) {

        //시간 차이 계산
        String gameDuration = String.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())))
                + "분 "
                + String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) - (ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) * 60))
                + "초";

        String gameAgoTime = null;

        if (ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.now()) >= 24)
        {
            gameAgoTime = String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "일 전";
        }
        else
        {
            gameAgoTime = String.valueOf(ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "시간 전";
        }

        //1. Match Master 정보 생성

        this.gameCreation = matchMasterEntity.getGameCreation();
        this.gameDuration = gameDuration;
        this.gameEndTimestamp = LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId());
        this.gameId = matchMasterEntity.getGameId();
        //this.queueType = JsonParserForLOL.getKRGameModeByQueueId(matchMasterEntity.getQueueId());
        this.queueType = matchMasterEntity.getQueueType();
        this.gameName = matchMasterEntity.getGameName();
        this.gameStartTimeStamp = LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()),TimeZone.getDefault().toZoneId());
        this.gameType = matchMasterEntity.getGameType();
        this.gameVersion = matchMasterEntity.getGameVersion();
        this.mapId = String.valueOf(matchMasterEntity.getMapId());
        this.platformId = matchMasterEntity.getPlatformId();
        this.queueId = String.valueOf(matchMasterEntity.getQueueId());
        this.tournamentCode = matchMasterEntity.getTournamentCode();
        this.gameAgoTime = gameAgoTime;
        this.teams = teamDtoList;
        this.summoner = summonerInfo;
    }
}
