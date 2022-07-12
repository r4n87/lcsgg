package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.SummonerPerkController;
import dev.saariselka.inlol.entity.MatchPerksEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
public class PerksDto {
    @Autowired
    private SummonerPerkController summonerPerkController;

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
    private int statPerkOffence;

    private String primaryIconPath;
    private String subIconPath;

    public PerksDto(MatchPerksEntity matchPerksEntity, String primaryIconPath, String subIconPath) {
        this.primaryStyle = matchPerksEntity.getPrimaryStyle();
        this.primaryPerk1 = matchPerksEntity.getPrimaryPerk1();
        this.primaryPerk2 = matchPerksEntity.getPrimaryPerk2();
        this.primaryPerk3 = matchPerksEntity.getPrimaryPerk3();
        this.primaryPerk4 = matchPerksEntity.getPrimaryPerk4();
        this.subStyle = matchPerksEntity.getSubStyle();
        this.subPerk1 = matchPerksEntity.getSubPerk1();
        this.subPerk2 = matchPerksEntity.getSubPerk2();
        this.statPerkDefense = matchPerksEntity.getStatPerkDefense();
        this.statPerkFlex = matchPerksEntity.getStatPerkFlex();
        this.statPerkOffence = matchPerksEntity.getStatPerkOffense();

        this.primaryIconPath = primaryIconPath;
        this.subIconPath = subIconPath;
    }
}
