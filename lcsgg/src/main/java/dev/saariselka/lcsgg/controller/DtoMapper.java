package dev.saariselka.lcsgg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.saariselka.lcsgg.dto.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Component
public class DtoMapper {
    private final ObjectMapper mapper = new ObjectMapper();

    public TeamDto toTeamDto(JsonObject teamObject) throws JsonProcessingException {

        String jsonString = teamObject.toString();

        //ObjectMapper mapper = new ObjectMapper();
        TeamDto teamDto = mapper.readValue(jsonString,TeamDto.class);

        return teamDto;
    }
    public SummonerDto toSummonerDto(JsonObject summonerObject) throws JsonProcessingException {
        String jsonString = summonerObject.toString();

        SummonerDto summonerDto = mapper.readValue(jsonString, SummonerDto.class);

        return summonerDto;
    }

    public LeagueEntryDto toLeagueEntryDto(JsonObject leagueEntryObject) throws JsonProcessingException{
        String jsonString = leagueEntryObject.toString();
        //ObjectMapper mapper = new ObjectMapper();
        LeagueEntryDto leagueEntryDto = mapper.readValue(jsonString,LeagueEntryDto.class);
        leagueEntryDto.setMiniSeries(toMiniSeriesDto((JsonObject)leagueEntryObject.get("miniSeries")));
        return leagueEntryDto;

//        return new LeagueEntryDto(
//                leagueEntryObject.get("leagueId").toString(),
//                leagueEntryObject.get("summonerId").toString(),
//                leagueEntryObject.get("summonerName").toString(),
//                leagueEntryObject.get("queueType").toString(),
//                leagueEntryObject.get("tier").toString(),
//                leagueEntryObject.get("rank").toString(),
//                Integer.parseInt(String.valueOf(leagueEntryObject.get("leaguePoints"))),
//                Integer.parseInt(String.valueOf(leagueEntryObject.get("wins"))),
//                Integer.parseInt(String.valueOf(leagueEntryObject.get("losses"))),
//                Boolean.parseBoolean(leagueEntryObject.get("hotStreak").toString()),
//                Boolean.parseBoolean(leagueEntryObject.get("veteran").toString()),
//                Boolean.parseBoolean(leagueEntryObject.get("freshBlood").toString()),
//                Boolean.parseBoolean(leagueEntryObject.get("inactive").toString()),
//                toMiniSeriesDto((JsonObject)leagueEntryObject.get("miniSeries"))
//                );

    }

    public MiniSeriesDto toMiniSeriesDto(JsonObject miniSeriesObject) throws JsonProcessingException {
        String jsonString = miniSeriesObject.toString();

        ObjectMapper mapper = new ObjectMapper();
        MiniSeriesDto miniSeriesDto = mapper.readValue(jsonString, MiniSeriesDto.class);
        return miniSeriesDto;

//        return new MiniSeriesDto(
//                Integer.parseInt(String.valueOf(miniSeriesObject.get("wins"))),
//                Integer.parseInt(String.valueOf(miniSeriesObject.get("losses"))),
//                Integer.parseInt(String.valueOf(miniSeriesObject.get("target"))),
//                miniSeriesObject.get("progress").toString()
//        );
    }

    public List<PerkStyleSelectionDto> toPerkStyleSelectionDtoList(JsonArray perkStyleSelectionObjectList) throws JsonProcessingException {
        List<PerkStyleSelectionDto> perkStyleSelectionDtoList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for (Object perkStyleSelectionObject : perkStyleSelectionObjectList) {
            String jsonString = perkStyleSelectionObject.toString();
            PerkStyleSelectionDto perkStyleSelectionDto = mapper.readValue(jsonString, PerkStyleSelectionDto.class);
            perkStyleSelectionDtoList.add(perkStyleSelectionDto);
        }

        return perkStyleSelectionDtoList;
    }

    public List<PerkStyleDto> toPerkStyleDtoList(JsonArray perkStyleObjectList) throws JsonProcessingException {
        List<PerkStyleDto> perkStyleDtoList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for(Object perkStyleObject : perkStyleObjectList) {
            String jsonString = perkStyleObject.toString();
            PerkStyleDto perkStyleDto = mapper.readValue(jsonString, PerkStyleDto.class);

            perkStyleDtoList.add(perkStyleDto);
        }

        return perkStyleDtoList;
    }

    public PerkStatsDto toPerkStatsDto(JsonObject perkStatsObject) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = perkStatsObject.toString();

        return mapper.readValue(jsonString, PerkStatsDto.class);
    }

    public PerksDto toPerksDto(JsonObject perksObject) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = perksObject.toString();

        return mapper.readValue(jsonString, PerksDto.class);
    }

    public List<ParticipantDto> toParticipantDtoList(JsonArray participantObjectList) throws JsonProcessingException {
        List<ParticipantDto> participantDtoList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for(Object participantObject : participantObjectList) {
            String jsonString = participantObject.toString();
            ParticipantDto participantDto = mapper.readValue(jsonString, ParticipantDto.class);
            participantDtoList.add(participantDto);
        }

        return participantDtoList;
    }

    public MetadataDto toMetadataDto(JsonObject metadataObject) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = metadataObject.toString();

        return mapper.readValue(jsonString, MetadataDto.class);
    }

    public List<TeamDto> toTeamDtoList(JsonArray teamObjectList) throws JsonProcessingException {
        List<TeamDto> teamDtoList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for (Object teamObject : teamObjectList) {
            String jsonString = teamObject.toString();
            TeamDto teamDto = mapper.readValue(jsonString, TeamDto.class);
            teamDtoList.add(teamDto);
        }

        return teamDtoList;
    }

    public InfoDto toInfoDto(JsonObject infoObject) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = infoObject.toString();

        return mapper.readValue(jsonString, InfoDto.class);
    }

    public MatchDto toMatchDto(JsonObject matchObject) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = matchObject.toString();

        return mapper.readValue(jsonString, MatchDto.class);
    }
}
