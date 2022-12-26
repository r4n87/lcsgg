package dev.saariselka.lcsgg.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class SummonerDto {

    private String puuid;
    private String accountId;
    private String id;
    private String name;
    private String profileIconId;
    private String revisionDate;
    private String summonerLevel;
    private String lastRefreshTimeForUI;
    private long lastRefreshTimeForAPI;

    @Builder
    public SummonerDto(String puuid, String accountId, String id, String name, String profileIconId, String revisionDate, String summonerLevel, String lastRefreshTimeForUI, long lastRefreshTimeForAPI) {
        this.puuid = puuid;
        this.accountId = accountId;
        this.id = id;
        this.name = name;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.summonerLevel = summonerLevel;
        this.lastRefreshTimeForUI = lastRefreshTimeForUI;
        this.lastRefreshTimeForAPI = lastRefreshTimeForAPI;
    }
}
