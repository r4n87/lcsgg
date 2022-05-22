package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.TeamEntity;

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

    public TeamDto (TeamEntity teamEntity, List<BanDto> banDtoList, ObjectivesDto objectivesDto) {
        this.teamId = String.valueOf(teamEntity.getTeamId().getTeamId());
        this.win = String.valueOf(teamEntity.isWin());
        this.bans = banDtoList;
        this.objectives = objectivesDto;
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
