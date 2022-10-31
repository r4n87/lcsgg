package dev.saariselka.lcsgg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PerkStyleSelectionDto {
    private int perk;
    private int var1;
    private int var2;
    private int var3;

    private PerkStyleDto perkStyle;
}
