package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Info extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id")
    private Long id;

    private long gameCreation;
    private long gameDuration;
    private long gameEndTimestamp;
    private long gameId;
    private String gameMode;
    private String gameName;
    private long gameStartTimestamp;
    private String gameType;
    private String gameVersion;
    private int mapId;
    private String platformId;
    private int queueId;
    private String tournamentCode;
    
    // 연관관계 매핑
    @OneToMany(mappedBy = "info_participants", cascade = CascadeType.PERSIST)
    private List<Participant> participants = new ArrayList<>();

    @OneToMany(mappedBy = "info_team")
    private List<Team> teams = new ArrayList<>();

    // 연관관계 설정
    public void setParticipants(List<Participant> participants) { this.participants = participants; }
    public void setTeams(List<Team> teams) { this.teams = teams; }

    @Builder
    public Info(long gameCreation
            , long gameDuration
            , long gameEndTimestamp
            , long gameId
            , String gameMode
            , String gameName
            , long gameStartTimestamp
            , String gameType
            , String gameVersion
            , int mapId
            , String platformId
            , int queueId
            , String tournamentCode) {
        this.gameCreation = gameCreation;
        this.gameDuration = gameDuration;
        this.gameEndTimestamp = gameEndTimestamp;
        this.gameId = gameId;
        this.gameMode = gameMode;
        this.gameName = gameName;
        this.gameStartTimestamp = gameStartTimestamp;
        this.gameType = gameType;
        this.gameVersion = gameVersion;
        this.mapId = mapId;
        this.platformId = platformId;
        this.queueId = queueId;
        this.tournamentCode = tournamentCode;
    }
}
