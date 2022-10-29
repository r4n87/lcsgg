package dev.saariselka.lcsgg.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.saariselka.lcsgg.dto.BanDto;
import dev.saariselka.lcsgg.dto.ObjectiveDto;
import dev.saariselka.lcsgg.dto.ObjectivesDto;
import dev.saariselka.lcsgg.dto.TeamDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Component
public class DtoMapper {

    public TeamDto toTeamDto(JsonObject teamObject) {

        List<BanDto> banDtoList = toBanDtoList((JsonArray)teamObject.get("bans"));

        ObjectivesDto objectivesDto = toObjectivesDto((JsonObject)teamObject.get("objectives"));

        TeamDto teamDto = new TeamDto(Integer.parseInt(teamObject.get("teamId").getAsString()),Boolean.parseBoolean(teamObject.get("win").getAsString()),banDtoList,objectivesDto);

        return  teamDto;
    }

    public List<BanDto> toBanDtoList(JsonArray banObjectList) {

        List<BanDto> banDtoList = new ArrayList<>();

        for (Object banObject : banObjectList) {
            JsonObject banJsonObject = (JsonObject)banObject;
            BanDto banDto = new BanDto(Integer.parseInt(banJsonObject.get("championId").getAsString()),Integer.parseInt(banJsonObject.get("pickTurn").getAsString()));
            banDtoList.add(banDto);
        }

        return banDtoList;
    }

    public ObjectivesDto toObjectivesDto(JsonObject objectivesObject) {
        return new ObjectivesDto(toObjectiveDto((JsonObject)objectivesObject.get("baron")),
                toObjectiveDto((JsonObject)objectivesObject.get("champion")),
                toObjectiveDto((JsonObject)objectivesObject.get("dragon")),
                toObjectiveDto((JsonObject)objectivesObject.get("inhibitor")),
                toObjectiveDto((JsonObject)objectivesObject.get("riftHerald")),
                toObjectiveDto((JsonObject)objectivesObject.get("tower")));
    }

    public ObjectiveDto toObjectiveDto(JsonObject objectiveObject) {
        return new ObjectiveDto(Boolean.parseBoolean(objectiveObject.get("first").getAsString()),Integer.parseInt(objectiveObject.get("kills").getAsString()));
    }
}
