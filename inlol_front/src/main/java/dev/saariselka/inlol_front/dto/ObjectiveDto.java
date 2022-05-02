package dev.saariselka.inlol_front.dto;

public class ObjectiveDto {
    private boolean first;
    private int kills;

    public ObjectiveDto() {
    }

    public ObjectiveDto(boolean first, int kills) {
        this.first = first;
        this.kills = kills;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }
}
