package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class PerkStyle extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perk_style_id")
    private Long id;

    @Column(name = "style_description")
    private String description;
    private int style;

    // 연관관계 매핑
    @OneToMany(mappedBy = "perkStyle")
    private List<PerkStyleSelection> selections = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "perks_id")
    private Perks perks;

    // 연관관계 설정
    public void setSelections(List<PerkStyleSelection> selections) { this.selections = selections; }
    public void setPerks(Perks perks) { this.perks = perks; }

    @Builder
    public PerkStyle(String description, int style, Perks perks) {
        this.description = description;
        this.style = style;

        if(this.perks != null) {
            this.perks.getStyles().remove(this);
        }

        setPerks(perks);
        perks.getStyles().add(this);
    }
}
