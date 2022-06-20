package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchPerksEntity;
import dev.saariselka.inlol.utils.JsonParserForLOL;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PerksDto {
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

    public PerksDto(MatchPerksEntity matchPerksEntity) {
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

        this.primaryIconPath = JsonParserForLOL.getRuneIconImageByPerkStyle("primary", this.primaryStyle, matchPerksEntity.getPrimaryPerk1());
        this.subIconPath = JsonParserForLOL.getRuneIconImageByPerkStyle("sub", matchPerksEntity.getSubStyle(), 0);
    }
}
