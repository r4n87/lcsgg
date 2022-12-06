package dev.saariselka.lcsgg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.saariselka.lcsgg.dto.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public SummonerDto toSummonerDto(Map<String, Object> summonerObject) throws JsonProcessingException {
        // TODO : dto 변환클래스가 꼭 필요한지..?
        //SummonerDto summonerDto = mapper.readValue(jsonString, SummonerDto.class);
        return mapper.convertValue(summonerObject.get("body"), SummonerDto.class);
    }

    //public LeagueEntryDto toLeagueEntryDto(JsonObject leagueEntryObject) throws JsonProcessingException{
    public List<LeagueEntryDto> toLeagueEntryDto(Map<String, Object> leagueEntryObject) {
        ObjectMapper mapper = new ObjectMapper();
        //파라미터에서 DTO에 들어있지 않는 변수가 있어도 무시함.
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<LeagueEntryDto> leagueEntryDtos =
                mapper.convertValue(leagueEntryObject.get("body"), TypeFactory.defaultInstance().constructCollectionType(List.class, LeagueEntryDto.class));

        return leagueEntryDtos;
    }

    // 사용하지 않아서 주석처리
//    public MiniSeriesDto toMiniSeriesDto(JsonObject miniSeriesObject) throws JsonProcessingException {
//        String jsonString = miniSeriesObject.toString();
//
//        ObjectMapper mapper = new ObjectMapper();
//        MiniSeriesDto miniSeriesDto = mapper.readValue(jsonString, MiniSeriesDto.class);
//        return miniSeriesDto;
//    }

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
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonString, MatchDto.class);
    }
}
