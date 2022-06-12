package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LeagueEntryDto {
    private String leagueId;
    private String summonerId;
    private String summonerName;
    private String queueType;
    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean veteran;
    private boolean freshBlood;
    private boolean inactive;
    private LeagueMiniSeriesDto miniSeries;

    public LeagueEntryDto (LeagueEntryEntity leagueEntryEntity, LeagueMiniSeriesDto leagueMiniSeriesDto) {
        this.leagueId = leagueEntryEntity.getLeagueId();
        this.summonerId = leagueEntryEntity.getLeagueEntryId().getSummonerId();
        this.summonerName = leagueEntryEntity.getSummonerName();
        this.queueType = leagueEntryEntity.getLeagueEntryId().getQueueType();
        this.tier = leagueEntryEntity.getTier();
        this.rank = leagueEntryEntity.getRanks();
        this.leaguePoints = leagueEntryEntity.getLeaguePoints();
        this.wins = leagueEntryEntity.getWins();
        this.losses = leagueEntryEntity.getLosses();
        this.hotStreak = leagueEntryEntity.isHotStreak();
        this.veteran = leagueEntryEntity.isVeteran();
        this.freshBlood = leagueEntryEntity.isFreshBlood();
        this.inactive = leagueEntryEntity.isInactive();
        this.miniSeries = leagueMiniSeriesDto;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
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

    public boolean isHotStreak() {
        return hotStreak;
    }

    public void setHotStreak(boolean hotStreak) {
        this.hotStreak = hotStreak;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public void setVeteran(boolean veteran) {
        this.veteran = veteran;
    }

    public boolean isFreshBlood() {
        return freshBlood;
    }

    public void setFreshBlood(boolean freshBlood) {
        this.freshBlood = freshBlood;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public LeagueMiniSeriesDto getMiniSeries() {
        return miniSeries;
    }

    public void setMiniSeries(LeagueMiniSeriesDto miniSeries) {
        this.miniSeries = miniSeries;
    }
}
