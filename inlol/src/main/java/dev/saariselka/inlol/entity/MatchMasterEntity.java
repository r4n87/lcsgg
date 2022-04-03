package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.*;
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="RIOT_MATCH_MASTER")

public class MatchMasterEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dataVersion;
    private String matchId;

    //@Column(nullable = false,unique = true)
    private Long gameCreation;
    private Long gameEndTimeStamp; // todo : table에 오타있음
    private Long gameDuration;
    private Long gameId;
    private String gameMode;
    private String gameName;
    private Long gameStartTimeStamp;
    private String gameType;
    private String gameVersion;
    private Integer mapId;
    private String platformId;
    private Integer queueId;
    private Integer teamId1;
    private Integer teamId2;
    private String tournamentCode; // todo : table에 오타있음

    //@Column(nullable = true)

    public MatchMasterEntity(Long gameCreation, Long gameEndTimeStamp, Long gameDuration, Long gameId,
                          String gameMode, String gameName, Long gameStartTimeStamp, String gameType, String gameVersion,
                          Integer mapId, String platformId, Integer queueId, Integer teamId1, Integer teamId2, String tournamentCode ) {
        this.gameCreation = gameCreation;
        this.gameEndTimeStamp = gameEndTimeStamp;
        this.gameDuration = gameDuration;
        this.gameId = gameId;
        this.gameMode = gameMode;
        this.gameName = gameName;
        this.gameStartTimeStamp = gameStartTimeStamp;
        this.gameType = gameType;
        this.gameVersion = gameVersion;
        this.mapId = mapId;
        this.platformId = platformId;
        this.queueId = queueId;
        this.teamId1 = teamId1;
        this.teamId2 = teamId2;
        this.tournamentCode = tournamentCode;
    }
}
