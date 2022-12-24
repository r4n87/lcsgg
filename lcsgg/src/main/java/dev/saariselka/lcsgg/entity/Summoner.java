package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Summoner extends BaseInfo{
    @Id
    private String puuid;

    private String accountId;
    private int profileIconId;
    private Long revisionDate;
    private String name;
    private String id;
    private Long summonerLevel;

    private String lastRefreshTimeForUI;

    private long lastRefreshTimeForAPI;

    @Builder
    public Summoner(String puuid, String accountId, int profileIconId, Long revisionDate, String name, String id, Long summonerLevel, String lastRefreshTimeForUI, long lastRefreshTimeForAPI) {
        this.puuid = puuid;
        this.accountId = accountId;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.name = name;
        this.id = id;
        this.summonerLevel = summonerLevel;
        this.lastRefreshTimeForUI = lastRefreshTimeForUI;
        this.lastRefreshTimeForAPI = lastRefreshTimeForAPI;
    }
}
