package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ObjectivesDto {
    private ObjectiveDto baron;
    private ObjectiveDto champion;
    private ObjectiveDto dragon;
    private ObjectiveDto inhibitor;
    private ObjectiveDto riftHeraId;
    private ObjectiveDto tower;

    public ObjectivesDto(MatchObjectivesEntity objectivesEntity) {
        this.baron = new ObjectiveDto(objectivesEntity.isBaron_first(), objectivesEntity.getBaron_kills());
        this.champion = new ObjectiveDto(objectivesEntity.isChampion_first(), objectivesEntity.getChampion_kills());
        this.dragon = new ObjectiveDto(objectivesEntity.isDragon_first(), objectivesEntity.getDragon_kills());
        this.inhibitor = new ObjectiveDto(objectivesEntity.isInhibitor_first(), objectivesEntity.getInhibitor_kills());
        this.riftHeraId = new ObjectiveDto(objectivesEntity.isRiftherald_first(), objectivesEntity.getRiftherald_kills());
        this.tower = new ObjectiveDto(objectivesEntity.isTower_first(), objectivesEntity.getTower_kills());
    }
}
