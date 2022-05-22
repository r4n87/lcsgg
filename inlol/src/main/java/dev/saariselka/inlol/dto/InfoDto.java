package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.util.JsonParserForLOL;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TimeZone;

@AllArgsConstructor
@NoArgsConstructor
public class InfoDto {
    private long gameCreation;
    private String gameDuration;
    private LocalDateTime gameEndTimestamp;
    private long gameId;
    private String gameMode;
    private String gameName;
    private LocalDateTime gameStartTimeStamp;
    private String gameType;
    private String gameVersion;
    private String mapId;
    private List<ParticipantDto> blueParticipants;
    private List<ParticipantDto> redParticipants;
    private String platformId;
    private String gameAgoTime;
    private ParticipantDto summoner;
    private String queueId;
    private List<TeamDto> teams;
    private String tournamentCode;

    public InfoDto (MatchMasterEntity matchMasterEntity, List<TeamDto> teamDtoList, List<ParticipantDto> blueParticipantDtoList,
                    List<ParticipantDto> redParticipantDtoList, ParticipantDto summonerInfo) {

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
        this.gameMode = JsonParserForLOL.getKRGameModeByQueueId(matchMasterEntity.getQueueId());
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
        this.blueParticipants = blueParticipantDtoList;
        this.redParticipants = redParticipantDtoList;
        this.summoner = summonerInfo;
    }

    public long getGameCreation() {
        return gameCreation;
    }

    public void setGameCreation(long gameCreation) {
        this.gameCreation = gameCreation;
    }

    public String getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(String gameDuration) {
        this.gameDuration = gameDuration;
    }

    public LocalDateTime getGameEndTimestamp() {
        return gameEndTimestamp;
    }

    public void setGameEndTimestamp(LocalDateTime gameEndTimestamp) {
        this.gameEndTimestamp = gameEndTimestamp;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public LocalDateTime getGameStartTimeStamp() {
        return gameStartTimeStamp;
    }

    public void setGameStartTimeStamp(LocalDateTime gameStartTimeStamp) { this.gameStartTimeStamp = gameStartTimeStamp; }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getQueueId() {
        return queueId;
    }

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public List<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDto> teams) {
        this.teams = teams;
    }

    public String getTournamentCode() {
        return tournamentCode;
    }

    public void setTournamentCode(String tournamentCode) {
        this.tournamentCode = tournamentCode;
    }

    public String getGameAgoTime() { return gameAgoTime; }

    public void setGameAgoTime(String gameAgoTime) { this.gameAgoTime = gameAgoTime; }

    public ParticipantDto getSummoner() { return summoner; }

    public void setSummoner(ParticipantDto summoner) { this.summoner = summoner; }

    public List<ParticipantDto> getBlueParticipants() {
        return blueParticipants;
    }

    public void setBlueParticipants(List<ParticipantDto> participants) {
        this.blueParticipants = participants;
    }

    public List<ParticipantDto> getRedParticipants() { return redParticipants; }

    public void setRedParticipants(List<ParticipantDto> participants) { this.redParticipants = participants; }
}
