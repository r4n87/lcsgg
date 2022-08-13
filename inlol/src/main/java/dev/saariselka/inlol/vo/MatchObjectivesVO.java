package dev.saariselka.inlol.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchObjectivesVO {
    private MatchObjectiveVO baron;
    private MatchObjectiveVO champion;
    private MatchObjectiveVO dragon;
    private MatchObjectiveVO inhibitor;
    private MatchObjectiveVO riftHeraId;
    private MatchObjectiveVO tower;
}

