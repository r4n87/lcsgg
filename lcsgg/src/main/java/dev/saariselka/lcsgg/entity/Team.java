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
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "info_id")
    private Info info;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.PERSIST)
    private List<Ban> bans = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "objectives_id")
    private Objectives objectives;

    // 연관관계 설정
    public void setInfo(Info info) { this.info = info; }

    public void setObjectives(Objectives objectives) { this.objectives = objectives; }

    @Builder
    public Team(boolean win, int teamId, Objectives objectives, Info info) {
        this.win = win;
        this.teamId = teamId;

        setObjectives(objectives);

        if(this.info != null) {
            this.info.getTeams().remove(this);
        }

        setInfo(info);
        info.getTeams().add(this);

    }
}
