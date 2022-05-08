package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="RIOT_LEAGUE_MINISERIES")
public class LeagueMiniSeriesEntity {
    @EmbeddedId
    private LeagueMiniSeriesId leagueMiniSeriesId;

    private int losses;
    private String progress;
    private int target;
    private int wins;
    private Timestamp rrt;
}
