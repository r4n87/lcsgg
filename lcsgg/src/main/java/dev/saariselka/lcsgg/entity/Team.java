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
public class Team extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchteam_id")
    private Long id;

    private boolean win;
    private int teamId;

    // 연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_id")
    private Info info_team;

    @OneToMany(mappedBy = "team_bans", cascade = CascadeType.PERSIST)
    private List<Ban> bans = new ArrayList<Ban>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "objectives_id")
    private Objectives objectives;

    // 연관관계 설정
    public void setInfo(Info info) { this.info_team = info; }

    public void setObjectives(Objectives objectives) { this.objectives = objectives; }

    public void setBans(List<Ban> bans) { this.bans = bans; }

    @Builder
    public Team(boolean win, int teamId, Objectives objectives, Info info, List<Ban> bans) {
        this.win = win;
        this.teamId = teamId;

        setInfo(info);
        setObjectives(objectives);
        setBans(bans);
    }
}
