package dev.saariselka.lcsgg.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.saariselka.lcsgg.dto.BanDto;
import dev.saariselka.lcsgg.dto.ObjectiveDto;
import dev.saariselka.lcsgg.dto.ObjectivesDto;
import dev.saariselka.lcsgg.dto.TeamDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DtoMapperTest {

    @Autowired
    DtoMapper dtoMapper;

    @Test
    @DisplayName("Convert JsonObject To TeamDto")
    public void toTeamDto() {
        //given
        JsonObject teamJsonObject = createTeamJsonObject();

        //when
        TeamDto teamDto = dtoMapper.toTeamDto(teamJsonObject);

        //then
        assertThat(teamDto.getMatchTeamId()).isEqualTo(Integer.parseInt(teamJsonObject.get("teamId").getAsString()));
        assertThat(teamDto.isWin()).isEqualTo(Boolean.parseBoolean(teamJsonObject.get("win").getAsString()));

    }

    @Test
    @DisplayName("Convert JsonArray To BanDtoList")
    public void toBanDtoList() {
        //given
        JsonArray banJsonArray = createBanJsonArray();

        //when
        List<BanDto> banDtoList = dtoMapper.toBanDtoList(banJsonArray);

        //then
        int index = 0;

        for (Object banObject : banJsonArray) {
            JsonObject banJsonObject = (JsonObject)banObject;

            assertThat(banDtoList.get(index).getChampionId()).isEqualTo(Integer.parseInt(banJsonObject.get("championId").getAsString()));
            assertThat(banDtoList.get(index).getPickTurn()).isEqualTo(Integer.parseInt(banJsonObject.get("pickTurn").getAsString()));

            index++;
        }
    }

    @Test
    @DisplayName("Convert JsonObject To ObjectivesDto")
    public void toObjectivesDto() {
        //given
        JsonObject objectivesJsonObject = createObjectivesJsonObject();

        //when
        ObjectivesDto objectivesDto = dtoMapper.toObjectivesDto(objectivesJsonObject);

        //then
        assertThat(objectivesDto.getBaron().getKills()).isEqualTo(
                Integer.parseInt(((JsonObject)objectivesJsonObject.get("baron")).get("kills").getAsString()));
        assertThat(objectivesDto.getBaron().isFirst()).isEqualTo(
                Boolean.parseBoolean(((JsonObject)objectivesJsonObject.get("baron")).get("first").getAsString()));
    }

    @Test
    @DisplayName("Convert JsonObject To ObjectiveDto")
    public void toObjectiveDto() {
        //given
        JsonObject objectiveJsonObject = createObjectiveJsonObject();

        //when
        ObjectiveDto objectiveDto = dtoMapper.toObjectiveDto(objectiveJsonObject);

        //then
        assertThat(objectiveDto.getKills()).isEqualTo(Integer.parseInt(objectiveJsonObject.get("kills").getAsString()));
        assertThat(objectiveDto.isFirst()).isEqualTo(Boolean.parseBoolean(objectiveJsonObject.get("first").getAsString()));
    }

    JsonObject createTeamJsonObject() {
        JsonObject teamJsonObject = new JsonObject();

        teamJsonObject.add("bans",createBanJsonArray());
        teamJsonObject.add("objectives",createObjectivesJsonObject());
        teamJsonObject.addProperty("teamId","100");
        teamJsonObject.addProperty("win","true");

        return teamJsonObject;
    }

    JsonArray createBanJsonArray() {
        JsonArray banJsonArray = new JsonArray();

        banJsonArray.add(createBanJsonObject());
        banJsonArray.add(createBanJsonObject());
        banJsonArray.add(createBanJsonObject());
        banJsonArray.add(createBanJsonObject());
        banJsonArray.add(createBanJsonObject());

        return banJsonArray;
    }

    JsonObject createBanJsonObject() {
        JsonObject banJsonObject = new JsonObject();

        banJsonObject.addProperty("championId","100");
        banJsonObject.addProperty("pickTurn","1");

        return banJsonObject;
    }

    JsonObject createObjectivesJsonObject() {
        JsonObject objectivesJsonObject = new JsonObject();

        objectivesJsonObject.add("baron",createObjectiveJsonObject());
        objectivesJsonObject.add("champion",createObjectiveJsonObject());
        objectivesJsonObject.add("dragon",createObjectiveJsonObject());
        objectivesJsonObject.add("inhibitor",createObjectiveJsonObject());
        objectivesJsonObject.add("riftHerald",createObjectiveJsonObject());
        objectivesJsonObject.add("tower",createObjectiveJsonObject());

        return objectivesJsonObject;
    }

    JsonObject createObjectiveJsonObject() {
        JsonObject objectiveJsonObject = new JsonObject();

        objectiveJsonObject.addProperty("first","true");
        objectiveJsonObject.addProperty("kills","1");

        return objectiveJsonObject;
    }
}
