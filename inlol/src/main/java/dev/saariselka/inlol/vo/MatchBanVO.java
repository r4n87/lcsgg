package dev.saariselka.inlol.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchBanVO {

    private String matchId;
    private int pickTurn;
    private int teamId;
    private int championId;
}
