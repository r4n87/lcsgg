package dev.saariselka.lcsgg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChampionDto {
    private int id;
    private String nameEng;
    private String nameKo;
    private String imagePath;
}
