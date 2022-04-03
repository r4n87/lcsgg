package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="RIOT_MATCH_TEAM")
public class TeamEntity {
    @Id
    private String matchid;
    private int teamid;

    private boolean win;

    public TeamEntity(String matchid, int teamid) {
        this.matchid = matchid;
        this.teamid = teamid;
    }
}
