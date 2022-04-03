package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="RIOT_MATCH_BAN")
public class MatchBanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String matchId;
    //private Integer pickTurn;
    //private Integer teamId;

    @Column(nullable = false,unique = true)
    private Integer pickTurn;
    private Integer teamId;
    private Integer championId;

    //@Column(nullable = true)

    public MatchBanEntity(Integer pickTurn, Integer teamId, Integer championId) {
        //this.matchId = matchId;
        this.pickTurn = pickTurn;
        this.teamId = teamId;
        this.championId = championId;

    }
}
