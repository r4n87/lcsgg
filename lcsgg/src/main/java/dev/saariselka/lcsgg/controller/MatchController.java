package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.dto.*;
import dev.saariselka.lcsgg.entity.Ban;
import dev.saariselka.lcsgg.entity.Match;
import dev.saariselka.lcsgg.entity.Objectives;
import dev.saariselka.lcsgg.entity.Team;
import dev.saariselka.lcsgg.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/match")
public class MatchController extends BaseConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MatchService matchService;

    public void insertMatch(MatchDto matchDto) {
        matchService.insert(modelMapper.map(matchDto, Match.class));
    }

    public ObjectivesDto getObjectivesDtoByObjectivesEntity(Objectives objectives) {
        ObjectivesDto objectivesDto = modelMapper.map(objectives,ObjectivesDto.class);

        return objectivesDto;
    }

    public List<BanDto> getBanDtoListByBanEntityList(List<Ban> banList) {
        List<BanDto> banDtoList = banList
                .stream()
                .map(banEntity -> modelMapper.map(banEntity, BanDto.class))
                .collect(Collectors.toList());

        return banDtoList;
    }

    public TeamDto getTeamDtoByTeamEntity(Team team) {
        TeamDto teamDto = modelMapper.map(team,TeamDto.class);
        teamDto.setObjectives(getObjectivesDtoByObjectivesEntity(team.getObjectives()));
        teamDto.setBans(getBanDtoListByBanEntityList(team.getBanList()));

        return teamDto;
    }

    public MatchDto getMatchDtoByMatchId(String matchId) {
        Match match = matchService.getMatchByMatchId(matchId);

        MatchDto matchDto = modelMapper.map(match, MatchDto.class);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        MetadataDto metadataDto = modelMapper.map(match.getMetadata(), MetadataDto.class);

        //metadataDto.setParticipants(participantDtos); 연관관계 수정해야할듯 ? riot api에서는 puuid String list임..


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        InfoDto infoDto = modelMapper.map(match.getInfo(), InfoDto.class);

        List<TeamDto> teamDtos = new ArrayList<>();

        for(Team team : match.getInfo().getTeams()) {

            TeamDto teamDto = getTeamDtoByTeamEntity(team);

            teamDtos.add(teamDto);
        }

        infoDto.setTeams(teamDtos);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        matchDto.setMetadata(metadataDto);
        matchDto.setInfo(infoDto);

        return matchDto;
    }
}
