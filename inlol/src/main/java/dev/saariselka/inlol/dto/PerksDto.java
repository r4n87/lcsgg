package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchPerksEntity;

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

    public PerksDto() {

    }

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
    }

    public int getPrimaryStyle() {
        return primaryStyle;
    }

    public void setPrimaryStyle(int primaryStyle) {
        this.primaryStyle = primaryStyle;
    }

    public int getPrimaryPerk1() {
        return primaryPerk1;
    }

    public void setPrimaryPerk1(int primaryPerk1) {
        this.primaryPerk1 = primaryPerk1;
    }

    public int getPrimaryPerk2() {
        return primaryPerk2;
    }

    public void setPrimaryPerk2(int primaryPerk2) {
        this.primaryPerk2 = primaryPerk2;
    }

    public int getPrimaryPerk3() {
        return primaryPerk3;
    }

    public void setPrimaryPerk3(int primaryPerk3) {
        this.primaryPerk3 = primaryPerk3;
    }

    public int getSubStyle() {
        return subStyle;
    }

    public void setSubStyle(int subStyle) {
        this.subStyle = subStyle;
    }

    public int getSubPerk1() {
        return subPerk1;
    }

    public void setSubPerk1(int subPerk1) {
        this.subPerk1 = subPerk1;
    }

    public int getSubPerk2() {
        return subPerk2;
    }

    public void setSubPerk2(int subPerk2) {
        this.subPerk2 = subPerk2;
    }

    public int getStatPerkDefense() {
        return statPerkDefense;
    }

    public void setStatPerkDefense(int statPerkDefense) {
        this.statPerkDefense = statPerkDefense;
    }

    public int getStatPerkFlex() {
        return statPerkFlex;
    }

    public void setStatPerkFlex(int statPerkFlex) {
        this.statPerkFlex = statPerkFlex;
    }

    public int getStatPerkOffence() {
        return statPerkOffence;
    }

    public void setStatPerkOffence(int statPerkOffence) {
        this.statPerkOffence = statPerkOffence;
    }

    public int getPrimaryPerk4() {
        return primaryPerk4;
    }

    public void setPrimaryPerk4(int primaryPerk4) {
        this.primaryPerk4 = primaryPerk4;
    }
}
