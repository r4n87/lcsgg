package dev.saariselka.lcsgg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
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
}
