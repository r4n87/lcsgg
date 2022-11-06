package dev.saariselka.lcsgg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectivesDto {

    private ObjectiveDto baron;

    private ObjectiveDto champion;

    private ObjectiveDto dragon;

    private ObjectiveDto inhibitor;

    private ObjectiveDto riftHerald;

    private ObjectiveDto tower;

}
