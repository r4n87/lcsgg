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
@Table(name="RIOT_MATCH_BAN")
public class MatchBanEntity {
    @EmbeddedId
    private MatchBanId matchBanId;

    private int championId;
    private Timestamp rrt;

}
