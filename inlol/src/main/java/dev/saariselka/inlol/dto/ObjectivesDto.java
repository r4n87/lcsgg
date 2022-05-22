package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ObjectivesDto {
    private ObjectiveDto baron;
    private ObjectiveDto champion;
    private ObjectiveDto dragon;
    private ObjectiveDto inhibitor;
    private ObjectiveDto riftHeraId;
    private ObjectiveDto tower;

    public ObjectivesDto(ObjectiveDto baron, ObjectiveDto champion, ObjectiveDto dragon, ObjectiveDto inhibitor, ObjectiveDto riftHeraId, ObjectiveDto tower) {
        this.baron = baron;
        this.champion = champion;
        this.dragon = dragon;
        this.inhibitor = inhibitor;
        this.riftHeraId = riftHeraId;
        this.tower = tower;
    }

    public ObjectivesDto(MatchObjectivesEntity objectivesEntity) {
        this.baron = new ObjectiveDto(objectivesEntity.isBaron_first(), objectivesEntity.getBaron_kills());
        this.champion = new ObjectiveDto(objectivesEntity.isChampion_first(), objectivesEntity.getChampion_kills());
        this.dragon = new ObjectiveDto(objectivesEntity.isDragon_first(), objectivesEntity.getDragon_kills());
        this.inhibitor = new ObjectiveDto(objectivesEntity.isInhibitor_first(), objectivesEntity.getInhibitor_kills());
        this.riftHeraId = new ObjectiveDto(objectivesEntity.isRiftherald_first(), objectivesEntity.getRiftherald_kills());
        this.tower = new ObjectiveDto(objectivesEntity.isTower_first(), objectivesEntity.getTower_kills());
    }

    public ObjectiveDto getBaron() {
        return baron;
    }

    public void setBaron(ObjectiveDto baron) {
        this.baron = baron;
    }

    public ObjectiveDto getChampion() {
        return champion;
    }

    public void setChampion(ObjectiveDto champion) {
        this.champion = champion;
    }

    public ObjectiveDto getDragon() {
        return dragon;
    }

    public void setDragon(ObjectiveDto dragon) {
        this.dragon = dragon;
    }

    public ObjectiveDto getInhibitor() {
        return inhibitor;
    }

    public void setInhibitor(ObjectiveDto inhibitor) {
        this.inhibitor = inhibitor;
    }

    public ObjectiveDto getRiftHeraId() {
        return riftHeraId;
    }

    public void setRiftHeraId(ObjectiveDto riftHeraId) {
        this.riftHeraId = riftHeraId;
    }

    public ObjectiveDto getTower() {
        return tower;
    }

    public void setTower(ObjectiveDto tower) {
        this.tower = tower;
    }
}
