package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.dto.BanDto;
import dev.saariselka.lcsgg.dto.ObjectivesDto;
import dev.saariselka.lcsgg.dto.TeamDto;
import dev.saariselka.lcsgg.entity.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MacthControllerTest {

    @Autowired
    MatchController matchController;

    @Test
    @DisplayName("get TeamDto By TeamEntity")
    public void getTeamDtoByTeamEntity() {
        //given
        Match match = createMatchEntity();

        //when
        TeamDto teamDto = matchController.getTeamDtoByTeamEntity(match.getInfo().getTeams().get(0));

        //then
        assertThat(teamDto.getTeamId()).isEqualTo(match.getInfo().getTeams().get(0).getMatchTeamId());
        assertThat(teamDto.getObjectives().getBaron().getKills()).isEqualTo(match.getInfo().getTeams().get(0).getObjectives().getBaron().getKills());
        assertThat(teamDto.getBans().get(0).getPickTurn()).isEqualTo(match.getInfo().getTeams().get(0).getBanList().get(0).getPickTurn());
    }

    @Test
    @DisplayName("get ObjectivesDto By ObjectivesEntity")
    public void getObjectivesDtoByObjectivesEntity() {
        //given
        Match match = createMatchEntity();

        //when
        ObjectivesDto objectivesDto = matchController.getObjectivesDtoByObjectivesEntity(match.getInfo().getTeams().get(0).getObjectives());

        //then
        assertThat(objectivesDto.getBaron().getKills()).isEqualTo(match.getInfo().getTeams().get(0).getObjectives().getBaron().getKills());
    }

    @Test
    @DisplayName("get Ban Dto List By Ban Entity List")
    public void getBanDtoListByBanEntityList() {
        //given
        Match match = createMatchEntity();

        //when
        List<BanDto> banDtoList = matchController.getBanDtoListByBanEntityList(match.getInfo().getTeams().get(0).getBanList());

        //then
        assertThat(banDtoList.get(0).getChampionId()).isEqualTo(match.getInfo().getTeams().get(0).getBanList().get(0).getChampionId());

    }

    Match createMatchEntity() {
        Match match = new Match();

        match.setId(1L);
        match.setInfo(createInfoEntity());
        match.setMetadata(createMetadataEntity());

        return match;
    }

    Metadata createMetadataEntity() {
        Metadata metadata = new Metadata();

        return metadata;
    }

    Info createInfoEntity() {
        Info info = new Info();

        info.setTeams(createTeamEntityList());
        //info.setParticipants(createParticipantEntityList());

        return info;
    }

    List<Team> createTeamEntityList() {
        List<Team> teamList = new ArrayList<>();

        teamList.add(createTeamEntity());

        return teamList;
    }

    Team createTeamEntity() {
        Team team = new Team();

        team.setMatchTeamId(100);
        team.setWin(true);
        team.setBanList(createBanEntityList());
        team.setObjectives(createObjectivesEntity());

        return team;
    }

    List<Ban> createBanEntityList() {
        List<Ban> banList = new ArrayList<>();

        banList.add(createBanEntity());

        return banList;
    }

    Ban createBanEntity() {
        Ban ban = new Ban();

        ban.setPickTurn(1);
        ban.setChampionId(100);

        return ban;
    }

    Objectives createObjectivesEntity() {
        Objectives objectives = new Objectives();

        objectives.setBaron(createObjectiveEntity());
        objectives.setChampion(createObjectiveEntity());
        objectives.setDragon(createObjectiveEntity());
        objectives.setInhibitor(createObjectiveEntity());
        objectives.setRiftHerald(createObjectiveEntity());
        objectives.setTower(createObjectiveEntity());

        return objectives;
    }

    Objective createObjectiveEntity() {
        Objective objective = new Objective();

        objective.setFirst(true);
        objective.setKills(1);

        return objective;
    }
}
