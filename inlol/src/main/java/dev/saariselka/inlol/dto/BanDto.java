package dev.saariselka.inlol.dto;

public class BanDto {
    private String championId;
    private String pickTurn;

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
