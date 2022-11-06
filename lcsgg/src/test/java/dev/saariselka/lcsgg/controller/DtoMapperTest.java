package dev.saariselka.lcsgg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
    public void toTeamDto() throws JsonProcessingException {
        //given
        JsonObject teamJsonObject = createTeamJsonObject();

        //when
        TeamDto teamDto = dtoMapper.toTeamDto(teamJsonObject);

        //then
        assertThat(teamDto.getTeamId()).isEqualTo(Integer.parseInt(teamJsonObject.get("teamId").getAsString()));
        assertThat(teamDto.isWin()).isEqualTo(Boolean.parseBoolean(teamJsonObject.get("win").getAsString()));

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
