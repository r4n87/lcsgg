package dev.saariselka.inlol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SummonerPerkDto {
    private int perkId;
    private String nameEng;
    private String nameKor;
    private String icon;
    private String description;
}
