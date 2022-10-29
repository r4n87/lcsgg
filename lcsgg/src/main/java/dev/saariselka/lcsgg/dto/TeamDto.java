package dev.saariselka.lcsgg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TeamDto {

    private int matchTeamId;
    private boolean win;

    private List<BanDto> bans;
    private ObjectivesDto objectives;

}
