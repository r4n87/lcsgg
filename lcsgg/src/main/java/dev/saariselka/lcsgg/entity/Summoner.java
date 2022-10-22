package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
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

    @Builder
    public Summoner(String puuid, String accountId, int profileIconId, long revisionDate, String name, String id, long summonerLevel){
        this.puuid = puuid;
        this.accountId = accountId;
        this.id = id;
        this.name = name;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.summonerLevel = summonerLevel;
    }
}
