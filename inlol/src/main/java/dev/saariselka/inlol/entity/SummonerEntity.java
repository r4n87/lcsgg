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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long puuid;

    @Column(nullable = false,unique = true)
    private Long accountId;
    private Long id;
    private String name;
    private int profileIconId;
    private Long revisionDate;
    private Long summonerLevel;

    //@Column(nullable = true)

    public SummonerEntity(Long accountId, Long id, String name, int profileIconId, Long revisionDate, Long summonerLevel) {
        this.accountId = accountId;
        this.id = id;
        this.name = name;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.summonerLevel = summonerLevel;
    }
}
