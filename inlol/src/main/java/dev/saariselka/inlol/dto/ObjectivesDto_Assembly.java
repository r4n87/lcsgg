package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.MatchObjectivesController;
import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import dev.saariselka.inlol.entity.MatchObjectivesId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ObjectivesDto_Assembly {
    @Autowired
    MatchObjectivesController matchObjectivesController;

    public ObjectivesDto getMatchMaster_ByMatchIdAndTeamId(String matchId, int teamId) {
        List<MatchObjectivesEntity> objectives = matchObjectivesController.getMatchObjectives_ByMatchIdAndTeamId(matchId, teamId);
        ObjectivesDto objectivesDto = new ObjectivesDto();
        for (MatchObjectivesEntity objectivesEntity : objectives)
        {
            ObjectiveDto baron = new ObjectiveDto();
            baron.setFirst(objectivesEntity.isBaron_first());
            baron.setKills(objectivesEntity.getBaron_kills());

            ObjectiveDto champion = new ObjectiveDto();
            champion.setFirst(objectivesEntity.isChampion_first());
            champion.setKills(objectivesEntity.getChampion_kills());

            ObjectiveDto dragon = new ObjectiveDto();
            dragon.setFirst(objectivesEntity.isDragon_first());
            dragon.setKills(objectivesEntity.getDragon_kills());

            ObjectiveDto inhibitor = new ObjectiveDto();
            inhibitor.setFirst(objectivesEntity.isInhibitor_first());
            inhibitor.setKills(objectivesEntity.getInhibitor_kills());

            ObjectiveDto riftHerald = new ObjectiveDto();
            riftHerald.setFirst(objectivesEntity.isRiftherald_first());
            riftHerald.setKills(objectivesEntity.getRiftherald_kills());

            ObjectiveDto tower = new ObjectiveDto();
            tower.setFirst(objectivesEntity.isTower_first());
            tower.setKills(objectivesEntity.getTower_kills());

            objectivesDto.setBaron(baron);
            objectivesDto.setChampion(champion);
            objectivesDto.setDragon(dragon);
            objectivesDto.setInhibitor(inhibitor);
            objectivesDto.setRiftHeraId(riftHerald);
            objectivesDto.setTower(tower);
        }

        return objectivesDto;
    }

    public ObjectivesDto getObjectivesDto_byEntity(MatchObjectivesEntity objectivesEntity) {
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
