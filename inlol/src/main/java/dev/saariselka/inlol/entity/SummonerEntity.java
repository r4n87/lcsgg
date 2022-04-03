package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="RIOT_SUMMONER")
public class SummonerEntity {
    @Id
    private String puuid;

    private String accountid;
    private String id;
    private String name;
    private int profileiconid;
    private long revisiondate;
    private long summonerlevel;

    public SummonerEntity(String accountid, int profileiconid, long revisiondate, String name, String id, long summonerlevel, String puuid) {
        this.accountid = accountid;
        this.id = id;
        this.name = name;
        this.profileiconid = profileiconid;
        this.revisiondate = revisiondate;
        this.summonerlevel = summonerlevel;
        this.puuid = puuid;
    }
}
