package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchBanEntity;

public class BanDto {
    private String championId;
    private String pickTurn;

    public BanDto(MatchBanEntity matchBanEntity) {
        this.championId = String.valueOf(matchBanEntity.getChampionId());
        this.pickTurn = String.valueOf(matchBanEntity.getMatchBanId().getPickTurn());
    }

    public String getChampionId() {
        return championId;
    }

    public void setChampionId(String championId) {
        this.championId = championId;
    }

    public String getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn(String pickTurn) {
        this.pickTurn = pickTurn;
    }
}
