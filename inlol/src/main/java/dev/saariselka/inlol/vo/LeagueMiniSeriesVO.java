package dev.saariselka.inlol.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeagueMiniSeriesVO {

    private String summonerId;
    private String queueType;
    private int losses;
    private String progress;
    private int target;
    private int wins;
}
