package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;

public class ObjectivesDto_Assembly {

    public ObjectivesDto getObjectivesDtoByEntity(MatchObjectivesEntity objectivesEntity) {
        ObjectivesDto objectivesDto = new ObjectivesDto();
        ObjectiveDto baron = new ObjectiveDto();
        ObjectiveDto champion = new ObjectiveDto();
        ObjectiveDto dragon = new ObjectiveDto();
        ObjectiveDto inhibitor = new ObjectiveDto();
        ObjectiveDto riftHerald = new ObjectiveDto();
        ObjectiveDto tower = new ObjectiveDto();

        baron.setFirst(objectivesEntity.isBaron_first());
        baron.setKills(objectivesEntity.getBaron_kills());
        champion.setFirst(objectivesEntity.isChampion_first());
        champion.setKills(objectivesEntity.getChampion_kills());
        dragon.setFirst(objectivesEntity.isDragon_first());
        dragon.setKills(objectivesEntity.getDragon_kills());
        inhibitor.setFirst(objectivesEntity.isInhibitor_first());
        inhibitor.setKills(objectivesEntity.getInhibitor_kills());
        riftHerald.setFirst(objectivesEntity.isRiftherald_first());
        riftHerald.setKills(objectivesEntity.getRiftherald_kills());
        tower.setFirst(objectivesEntity.isTower_first());
        tower.setKills(objectivesEntity.getTower_kills());

        objectivesDto.setBaron(baron);
        objectivesDto.setChampion(champion);
        objectivesDto.setDragon(dragon);
        objectivesDto.setInhibitor(inhibitor);
        objectivesDto.setRiftHeraId(riftHerald);
        objectivesDto.setTower(tower);

        return objectivesDto;
    }
}
