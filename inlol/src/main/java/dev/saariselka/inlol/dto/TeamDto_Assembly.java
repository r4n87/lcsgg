package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.TeamEntity;

import java.util.List;

public class TeamDto_Assembly {

    public TeamDto getTeamDtoByEntityAndDto(TeamEntity teamEntity, List<BanDto> banDtoList, ObjectivesDto objectivesDto) {
        TeamDto teamDto = new TeamDto();

        teamDto.setTeamId(String.valueOf(teamEntity.getTeamId().getTeamId()));
        teamDto.setWin(String.valueOf(teamEntity.isWin()));

        teamDto.setBans(banDtoList);

        teamDto.setObjectives(objectivesDto);

        return  teamDto;
    }
}
