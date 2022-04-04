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

}
