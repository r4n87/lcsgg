package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchObjectivesDto {
    private MatchObjectiveDto baron;
    private MatchObjectiveDto champion;
    private MatchObjectiveDto dragon;
    private MatchObjectiveDto inhibitor;
    private MatchObjectiveDto riftHeraId;
    private MatchObjectiveDto tower;

}
