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
    private List<MatchBanDto> bans;
    private ObjectivesDto objectives;
    private String teamId;
    private String win;
    private int teamKills;
    private List<ParticipantDto> participants;

    public TeamDto (TeamEntity teamEntity, List<MatchBanDto> matchBanDtoList, ObjectivesDto objectivesDto) {
        this.teamId = String.valueOf(teamEntity.getTeamId().getTeamId());
        this.win = String.valueOf(teamEntity.isWin());
        this.bans = matchBanDtoList;
        this.objectives = objectivesDto;
    }
}
