package dev.saariselka.lcsgg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
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
    private long gameStartTimeStamp;
    private String gameType;
    private String gameVersion;
    private int mapId;
    private String platformId;
    private int queueId;
    private String tournamentCode;
    
    // 연관관계 매핑
    @OneToMany(mappedBy = "info")
    private List<Participant> participants = new ArrayList<>();

    @OneToMany(mappedBy = "info")
    private List<Team> teams = new ArrayList<>();

    // 연관관계 설정
    public void setParticipants(List<Participant> participants) { this.participants = participants; }
    public void setTeams(List<Team> teams) { this.teams = teams; }

}
