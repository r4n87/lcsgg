package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="RIOT_LEAGUE_ENTRY")
public class LeagueEntryEntity {
    @EmbeddedId
    private LeagueEntryId leagueEntryId;

    private String leagueId;
    private String summonerName;

    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean veteran;
    private boolean freshBlood;
    private boolean inactive;
    private Timestamp rrt;
}
