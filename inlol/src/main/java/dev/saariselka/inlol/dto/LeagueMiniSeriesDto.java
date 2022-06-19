package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LeagueMiniSeriesDto {
    private String summonerId;
    private String queueType;
    private int wins;
    private int losses;
    private int target;
    private char[] progress;

    public LeagueMiniSeriesDto() {}

    public LeagueMiniSeriesDto(LeagueMiniSeriesEntity leagueMiniSeriesEntity) {
        this.summonerId = leagueMiniSeriesEntity.getLeagueMiniSeriesId().getSummonerId();
        this.queueType = leagueMiniSeriesEntity.getLeagueMiniSeriesId().getQueueType();
        this.wins = leagueMiniSeriesEntity.getWins();
        this.losses = leagueMiniSeriesEntity.getLosses();
        this.target = leagueMiniSeriesEntity.getTarget();
        this.progress = leagueMiniSeriesEntity.getProgress().toCharArray();
    }
}
