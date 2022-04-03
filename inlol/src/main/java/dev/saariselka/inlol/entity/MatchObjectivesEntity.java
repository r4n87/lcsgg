package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="RIOT_MATCH_OBJECTIVES")
public class MatchObjectivesEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String matchId;
    private Integer teamId;

    //@Column(nullable = false,unique = true)
    private Boolean baron_first;
    private Integer baron_kills;
    private Boolean champion_first;
    private Integer champion_kills;
    private Boolean dragon_first;
    private Integer dragon_kills;
    private Boolean inhibitor_first;
    private Integer inhibitor_kills;
    private Boolean riftherald_first;
    private Integer riftherald_kills;
    private Boolean tower_first;
    private Integer tower_kills;

    public MatchObjectivesEntity(Boolean baron_first, Integer baron_kills,
                                 Boolean champion_first, Integer champion_kills,
                                 Boolean dragon_first, Integer dragon_kills,
                                 Boolean inhibitor_first, Integer inhibitor_kills,
                                 Boolean riftherald_first, Integer riftherald_kills,
                                 Boolean tower_first, Integer tower_kills) {
        this.baron_first = baron_first;
        this.baron_kills = baron_kills;
        this.champion_first = champion_first;
        this.champion_kills = champion_kills;
        this.dragon_first = dragon_first;
        this.dragon_kills = dragon_kills;
        this.inhibitor_first = inhibitor_first;
        this.inhibitor_kills = inhibitor_kills;
        this.riftherald_first = riftherald_first;
        this.riftherald_kills = riftherald_kills;
        this.tower_first = tower_first;
        this.tower_kills = tower_kills;
    }
}
