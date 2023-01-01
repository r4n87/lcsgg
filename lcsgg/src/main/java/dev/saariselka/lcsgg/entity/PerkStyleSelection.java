package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PerkStyleSelection extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perk_style_selection_id")
    private Long id;

    private int perk;
    private int var1;
    private int var2;
    private int var3;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "perk_style_id")
    private PerkStyle perkStyle;

    // 연관관계 설정
    public void setPerkStyle(PerkStyle perkStyle) { this.perkStyle = perkStyle; }

    @Builder
    public PerkStyleSelection(int perk, int var1, int var2, int var3, PerkStyle perkStyle) {
        this.perk = perk;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;

        if(this.perkStyle != null) {
            this.perkStyle.getSelections().remove(this);
        }

        setPerkStyle(perkStyle);
        perkStyle.getSelections().add(this);
    }
}
