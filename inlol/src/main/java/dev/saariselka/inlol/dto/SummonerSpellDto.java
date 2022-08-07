package dev.saariselka.inlol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SummonerSpellDto {

    private String name;
    private String description;
    private int spellKey;
    private String image;
}
