package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.SummonerPerkController;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class MatchPerksDto {
    @Autowired
    private SummonerPerkController summonerPerkController;

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

    private String primaryIconPath;
    private String subIconPath;

    public MatchPerksDto(MatchPerksDto matchPerksDto, String primaryIconPath, String subIconPath) {
        this.matchId = matchPerksDto.matchId;
        this.puuid = matchPerksDto.puuid;
        this.primaryStyle = matchPerksDto.getPrimaryStyle();
        this.primaryPerk1 = matchPerksDto.getPrimaryPerk1();
        this.primaryPerk2 = matchPerksDto.getPrimaryPerk2();
        this.primaryPerk3 = matchPerksDto.getPrimaryPerk3();
        this.primaryPerk4 = matchPerksDto.getPrimaryPerk4();
        this.subStyle = matchPerksDto.getSubStyle();
        this.subPerk1 = matchPerksDto.getSubPerk1();
        this.subPerk2 = matchPerksDto.getSubPerk2();
        this.statPerkDefense = matchPerksDto.getStatPerkDefense();
        this.statPerkFlex = matchPerksDto.getStatPerkFlex();
        this.statPerkOffense = matchPerksDto.getStatPerkOffense();

        this.primaryIconPath = primaryIconPath;
        this.subIconPath = subIconPath;
    }

    public MatchPerksDto(
            String matchId
            , String puuid
            , int primaryStyle
            , int primaryPerk1
            , int primaryPerk2
            , int primaryPerk3
            , int primaryPerk4
            , int subStyle
            , int subPerk1
            , int subPerk2
            , int statPerkDefense
            , int statPerkFlex
            , int statPerkOffense) {
        this.matchId = matchId;
        this.puuid = puuid;
        this.primaryStyle = primaryStyle;
        this.primaryPerk1 = primaryPerk1;
        this.primaryPerk2 = primaryPerk2;
        this.primaryPerk3 = primaryPerk3;
        this.primaryPerk4 = primaryPerk4;
        this.subStyle = subStyle;
        this.subPerk1 = subPerk1;
        this.subPerk2 = subPerk2;
        this.statPerkDefense = statPerkDefense;
        this.statPerkFlex = statPerkFlex;
        this.statPerkOffense = statPerkOffense;
    }
}
