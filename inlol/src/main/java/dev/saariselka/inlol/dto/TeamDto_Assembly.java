package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.TeamController;
import dev.saariselka.inlol.entity.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamDto_Assembly {

    @Autowired
    TeamController teamController;

    public TeamDto getTeamDto_ByMatchIdAndTeamId(String matchId, int teamId, List<BanDto> banDtoList, ObjectivesDto objectivesDto) {
        List<TeamEntity> teamList = teamController.getTeams_ByMatchIdAndTeamId(matchId,teamId);
        TeamDto teamDto = new TeamDto();

        for (TeamEntity teamEntity : teamList) {
            teamDto.setTeamId(teamEntity.getTeamId().getTeamId());
            teamDto.setWin(teamEntity.isWin());
            teamDto.setBans(banDtoList);
            teamDto.setObjectives(objectivesDto);
        }

        return teamDto;
    }
}
