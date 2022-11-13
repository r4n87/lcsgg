package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Objectives extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "objectives_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "baron_id")
    private Objective baron;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "champion_id")
    private Objective champion;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dragon_id")
    private Objective dragon;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "inhibitor_id")
    private Objective inhibitor;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "riftHerald_id")
    private Objective riftHerald;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tower_id")
    private Objective tower;

    // 연관관계 설정
    public void setBaron(Objective baron) { this.baron = baron; }
    public void setChampion(Objective champion) { this.champion = champion; }
    public void setDragon(Objective dragon) { this.dragon = dragon; }
    public void setInhibitor(Objective inhibitor) { this.inhibitor = inhibitor; }
    public void setRiftHerald(Objective riftHerald) { this.riftHerald = riftHerald; }
    public void setTower(Objective tower) { this.tower = tower; }

    @Builder
    public Objectives(Objective baron, Objective champion, Objective dragon,
                      Objective inhibitor, Objective riftHerald, Objective tower) {
        this.baron = baron;
        this.champion = champion;
        this.dragon = dragon;
        this.inhibitor = inhibitor;
        this.riftHerald = riftHerald;
        this.tower = tower;
    }
}
