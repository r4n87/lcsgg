package dev.saariselka.inlol.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChampionVO {
    private int id;
    private String nameEng;
    private String nameKo;
    private String imagePath;
}
