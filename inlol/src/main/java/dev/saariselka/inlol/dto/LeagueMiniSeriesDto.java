package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeagueMiniSeriesDto {
    private String summonerId;
    private String queueType;
    private int wins;
    private int losses;
    private int target;
    private char[] progress;
}
