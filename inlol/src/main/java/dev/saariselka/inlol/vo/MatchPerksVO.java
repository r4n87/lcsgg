package dev.saariselka.inlol.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchPerksVO {
    private String matchId;
    private String puuid;
    private int primaryStyle;
    private int primaryPerk1;
    private int primaryPerk2;
    private int primaryPerk3;
    private int primaryPerk4;
    private int subStyle;
    private int subPerk1;
    private int subPerk2;
    private int statPerkDefense;
    private int statPerkFlex;
    private int statPerkOffense;
    private Timestamp rrt;
}
