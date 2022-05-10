package dev.saariselka.inlol.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
