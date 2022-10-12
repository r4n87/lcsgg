package dev.saariselka.lcsgg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

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

}
