package dev.saariselka.lcsgg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PerkStyleDto {
    private String description;
    private int style;

    private List<PerkStyleSelectionDto> selections;
}
