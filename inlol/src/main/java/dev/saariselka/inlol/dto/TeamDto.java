package dev.saariselka.inlol.dto;

import java.util.List;

public class TeamDto {
    private List<BanDto> bans;
    private ObjectivesDto objectives;
    private String teamId;
    private String win;

    public TeamDto() {
    }

    public TeamDto(List<BanDto> bans, ObjectivesDto objectives, String teamId, String win) {
        this.bans = bans;
        this.objectives = objectives;
        this.teamId = teamId;
        this.win = win;
    }

    public List<BanDto> getBans() {
        return bans;
    }

    public void setBans(List<BanDto> bans) {
        this.bans = bans;
    }

    public ObjectivesDto getObjectives() {
        return objectives;
    }

    public void setObjectives(ObjectivesDto objectives) {
        this.objectives = objectives;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String isWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }
}
