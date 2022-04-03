package dev.saariselka.inlol.dto;

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
