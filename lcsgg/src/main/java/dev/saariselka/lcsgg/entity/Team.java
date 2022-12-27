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
    @ManyToOne
    @JoinColumn(name = "info_id")
    private Info info;

    @OneToMany(mappedBy = "team")
    private List<Ban> bans = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "objectives_id")
    private Objectives objectives;

    // 연관관계 설정
    public void setInfo(Info info) { this.info = info; }

    public void setObjectives(Objectives objectives) { this.objectives = objectives; }

    public void setBanList(List<Ban> banList) { this.bans = banList; }

    @Builder
    public Team(boolean win, int teamId, Objectives objectives, Info info) {
        this.win = win;
        this.teamId = teamId;
        this.objectives = objectives;

        setInfo(info);
    }
}
