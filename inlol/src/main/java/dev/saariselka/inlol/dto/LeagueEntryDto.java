package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
