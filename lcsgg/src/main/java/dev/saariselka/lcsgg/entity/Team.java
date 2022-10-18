package dev.saariselka.lcsgg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Team extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private boolean win;
    private int matchTeamId;

    // 연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "info_id")
    private Info info;

    @OneToMany(mappedBy = "team")
    private List<Ban> banList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "objectives_id")
    private Objectives objectives;

    // 연관관계 설정
    public void setInfo(Info info) { this.info = info; }

    public void setObjectives(Objectives objectives) { this.objectives = objectives; }

    public void setBanList(List<Ban> banList) { this.banList = banList; }
}
