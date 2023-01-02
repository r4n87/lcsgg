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
public class PerkStats extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perk_stats_id")
    private Long id;

    private int defense;
    private int flex;
    private int offense;

    @Builder
    public PerkStats(int defense, int flex, int offense) {
        this.defense = defense;
        this.flex = flex;
        this.offense = offense;
    }
}
