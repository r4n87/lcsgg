package dev.saariselka.lcsgg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PerksDto {
    private PerkStatsDto statPerks;
    private List<PerkStyleDto> styles;
}
