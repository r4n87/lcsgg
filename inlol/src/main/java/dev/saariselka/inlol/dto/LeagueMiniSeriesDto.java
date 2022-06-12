package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
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

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTarget() { return target; }

    public void setTarget(int target) {
        this.target = target;
    }

    public char[] getProgress() {
        return progress;
    }

    public void setProgress(char[] progress) {
        this.progress = progress;
    }
}
