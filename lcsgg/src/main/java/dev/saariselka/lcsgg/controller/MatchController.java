package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.dto.*;
import dev.saariselka.lcsgg.entity.*;
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
        return modelMapper.map(objectives,ObjectivesDto.class);
    }

    public List<BanDto> getBanDtoListByBanEntityList(List<Ban> banList) {
        return   banList
                .stream()
                .map(banEntity -> modelMapper.map(banEntity, BanDto.class))
                .collect(Collectors.toList());
    }

    public TeamDto getTeamDtoByTeamEntity(Team team) {
        TeamDto teamDto = modelMapper.map(team,TeamDto.class);
        teamDto.setObjectives(getObjectivesDtoByObjectivesEntity(team.getObjectives()));
        teamDto.setBans(getBanDtoListByBanEntityList(team.getBanList()));

        return teamDto;
    }

    public PerkStatsDto getPerkStatsDtoByPerkStatsEntity(PerkStats perkStats) {
        return modelMapper.map(perkStats, PerkStatsDto.class);
    }

    public List<PerkStyleSelectionDto> getPerkStyleSelectionDtoListByPerkStyleSelectionEntityList(List<PerkStyleSelection> perkStyleSelectionList) {
        return  perkStyleSelectionList
                .stream()
                .map(perkStyleSelectionEntity -> modelMapper.map(perkStyleSelectionEntity, PerkStyleSelectionDto.class))
                .collect(Collectors.toList());
    }

    public PerkStyleDto getPerkStyleDtoByPerkStyleEntity(PerkStyle perkStyle) {
        PerkStyleDto perkStyleDto = modelMapper.map(perkStyle, PerkStyleDto.class);
        perkStyleDto.setSelections(getPerkStyleSelectionDtoListByPerkStyleSelectionEntityList(perkStyle.getSelections()));

        return perkStyleDto;
    }

    public List<PerkStyleDto> getPerkStyleDtoListByPerkStyleList(List<PerkStyle> perkStyleList) {
        List<PerkStyleDto> perkStyleDtoList = new ArrayList<>();

        for (PerkStyle perkStyle : perkStyleList) {
            PerkStyleDto perkStyleDto = getPerkStyleDtoByPerkStyleEntity(perkStyle);
            perkStyleDtoList.add(perkStyleDto);
        }

        return perkStyleDtoList;
    }


    public PerksDto getPerksDtoByPerksEntity(Perks perks) {
        PerksDto perksDto = modelMapper.map(perks, PerksDto.class);
        perksDto.setStatPerks(getPerkStatsDtoByPerkStatsEntity(perks.getStatPerks()));
        perksDto.setStyles(getPerkStyleDtoListByPerkStyleList(perks.getStyles()));

        return perksDto;
    }

    public ParticipantDto getParticipantDtoByParticipantEntity(Participant participant) {
        ParticipantDto participantDto = modelMapper.map(participant, ParticipantDto.class);
        participantDto.setPerks(getPerksDtoByPerksEntity(participant.getPerks()));

        return participantDto;
    }


    public MatchDto getMatchDtoByMatchId(String matchId) {
        Match match = matchService.getMatchByMatchId(matchId);

        MatchDto matchDto = modelMapper.map(match, MatchDto.class);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        MetadataDto metadataDto = modelMapper.map(match.getMetadata(), MetadataDto.class);

        List<ParticipantDto> participantDtos = new ArrayList<>();
        List<String> participants = new ArrayList<>();
        for (Participant participant : match.getInfo().getParticipants()) {
            ParticipantDto participantDto = getParticipantDtoByParticipantEntity(participant);
            participantDtos.add(participantDto);
            participants.add(participantDto.getPuuid());
        }

        metadataDto.setParticipants(participants);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        InfoDto infoDto = modelMapper.map(match.getInfo(), InfoDto.class);

        List<TeamDto> teamDtos = new ArrayList<>();
        for(Team team : match.getInfo().getTeams()) {
            TeamDto teamDto = getTeamDtoByTeamEntity(team);
            teamDtos.add(teamDto);
        }

        infoDto.setTeams(teamDtos);
        infoDto.setParitcipants(participantDtos);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        matchDto.setMetadata(metadataDto);
        matchDto.setInfo(infoDto);

        return matchDto;
    }
}
