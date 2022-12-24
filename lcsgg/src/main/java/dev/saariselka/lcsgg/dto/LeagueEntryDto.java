package dev.saariselka.lcsgg.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class LeagueEntryDto {
    private Long id;
    private String leagueId;
    private String summonerId;
    private String summonerName;
    private String queueType;
    private String tier;
    private String ranks;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean veteran;
    private boolean freshBlood;
    private boolean inactive;
    private MiniSeriesDto miniSeries;

    @Builder
    public LeagueEntryDto(Long id, String leagueId, String summonerId, String summonerName, String queueType, String tier, String ranks, int leaguePoints, int wins, int losses, boolean hotStreak, boolean veteran, boolean freshBlood, boolean inactive, MiniSeriesDto miniSeries) {
        this.id = id;
        this.leagueId = leagueId;
        this.summonerId = summonerId;
        this.summonerName = summonerName;
        this.queueType = queueType;
        this.tier = tier;
        this.ranks = ranks;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        this.hotStreak = hotStreak;
        this.veteran = veteran;
        this.freshBlood = freshBlood;
        this.inactive = inactive;
        this.miniSeries = miniSeries;
    }
}
