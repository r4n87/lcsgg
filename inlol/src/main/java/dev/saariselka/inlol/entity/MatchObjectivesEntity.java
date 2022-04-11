package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="RIOT_MATCH_OBJECTIVES")
public class MatchObjectivesEntity {
    @EmbeddedId
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private MatchObjectivesId matchObjectivesId;

    //@Column(nullable = false,unique = true)
    private boolean baron_first;
    private int baron_kills;
    private boolean champion_first;
    private int champion_kills;
    private boolean dragon_first;
    private int dragon_kills;
    private boolean inhibitor_first;
    private int inhibitor_kills;
    private boolean riftherald_first;
    private int riftherald_kills;
    private boolean tower_first;
    private int tower_kills;
    private Timestamp rrt;

}
