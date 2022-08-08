package dev.saariselka.inlol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MatchBanDto {
    private String matchId;
    private int pickTurn;
    private int teamId;
    private int championId;
}
