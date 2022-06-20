package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.TeamEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeamDto {
    private List<BanDto> bans;
    private ObjectivesDto objectives;
    private String teamId;
    private String win;
    private int teamKills;
    private List<ParticipantDto> participants;

    public TeamDto (TeamEntity teamEntity, List<BanDto> banDtoList, ObjectivesDto objectivesDto) {
        this.teamId = String.valueOf(teamEntity.getTeamId().getTeamId());
        this.win = String.valueOf(teamEntity.isWin());
        this.bans = banDtoList;
        this.objectives = objectivesDto;
    }
}
