package dev.saariselka.lcsgg.entity;

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

    private String description;
    private int style;

    // 연관관계 매핑
    @OneToMany
    @JoinColumn(name = "perk_style_selection_id")
    private List<PerkStyleSelection> selections = new ArrayList<>();

    // 연관관계 설정
    public void setSelections(List<PerkStyleSelection> selections) { this.selections = selections; }
}
