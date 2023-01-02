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
public class Perks extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perks_id")
    private Long id;

    // 연관관계 매핑
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "perk_stats_id")
    private PerkStats statPerks;

    @OneToMany(mappedBy = "perks", cascade = CascadeType.PERSIST)
    private List<PerkStyle> styles = new ArrayList<>();

    // 연관관계 설정
    public void setStatPerks(PerkStats statPerks) { this.statPerks = statPerks; }
    public void setStyles(List<PerkStyle> styles) { this.styles = styles; }

    @Builder
    public Perks(PerkStats statPerks) {
        setStatPerks(statPerks);
    }
}
