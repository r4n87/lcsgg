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
    private String matchId;
    private Integer pickTurn;
    private Integer teamId;
    private Integer championId;


}
