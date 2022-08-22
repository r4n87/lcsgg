package dev.saariselka.inlol.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchTeamVO {
    private List<MatchBanVO> bans;
    private MatchObjectivesVO objectives;
    private String teamId;
    private String win;
    private int teamKills;
    private List<MatchParticipantVO> participants;
}
