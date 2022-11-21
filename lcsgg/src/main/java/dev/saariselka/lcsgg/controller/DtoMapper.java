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

    public List<PerkStyleSelectionDto> toPerkStyleSelectionDtoList(JsonArray perkStyleSelectionObjectList) {
        List<PerkStyleSelectionDto> perkStyleSelectionDtoList = new ArrayList<>();

        for (Object perkStyleSelectionObject : perkStyleSelectionObjectList) {
            JsonObject perkStyleSelectionJsonObject = (JsonObject)perkStyleSelectionObject;
            PerkStyleSelectionDto perkStyleSelectionDto
                    = new PerkStyleSelectionDto(
                            perkStyleSelectionJsonObject.get("perk").getAsInt(),
                            perkStyleSelectionJsonObject.get("var1").getAsInt(),
                            perkStyleSelectionJsonObject.get("var2").getAsInt(),
                            perkStyleSelectionJsonObject.get("var3").getAsInt()
            );
            perkStyleSelectionDtoList.add(perkStyleSelectionDto);
        }

        return perkStyleSelectionDtoList;
    }

    public List<PerkStyleDto> toPerkStyleDtoList(JsonArray perkStyleObjectList) {
        List<PerkStyleDto> perkStyleDtoList = new ArrayList<>();

        for(Object perkStyleObject : perkStyleObjectList) {
            JsonObject perkStyleJsonObject = (JsonObject) perkStyleObject;
            PerkStyleDto perkStyleDto
                    = new PerkStyleDto(
                        perkStyleJsonObject.get("description").getAsString(),
                        perkStyleJsonObject.get("style").getAsInt(),
                        toPerkStyleSelectionDtoList((JsonArray)perkStyleJsonObject.get("selections"))
            );

            perkStyleDtoList.add(perkStyleDto);
        }

        return perkStyleDtoList;
    }

    public PerkStatsDto toPerkStatsDto(JsonObject perkStatsObject) {
        return new PerkStatsDto(
            perkStatsObject.get("defense").getAsInt(),
            perkStatsObject.get("flex").getAsInt(),
            perkStatsObject.get("offense").getAsInt()
        );
    }

    public PerksDto toPerksDto(JsonObject perksObject) {
        return new PerksDto(
            toPerkStatsDto(perksObject.getAsJsonObject("statPerks")),
            toPerkStyleDtoList(perksObject.getAsJsonArray("styles"))
        );
    }

    public List<ParticipantDto> toParticipantDtoList(JsonArray participantObjectList) {
        List<ParticipantDto> participantDtoList = new ArrayList<>();

        for(Object participantObject : participantObjectList) {
            JsonObject participantJsonObject = (JsonObject) participantObject;
            ParticipantDto participantDto
                = new ParticipantDto(
                    participantJsonObject.get("assists").getAsInt(),
                    participantJsonObject.get("baronKills").getAsInt(),
                    participantJsonObject.get("bountyLevel").getAsInt(),
                    participantJsonObject.get("champExperience").getAsInt(),
                    participantJsonObject.get("champLevel").getAsInt(),
                    participantJsonObject.get("championId").getAsInt(),
                    participantJsonObject.get("championName").getAsString(),
                    participantJsonObject.get("championTransform").getAsInt(),
                    participantJsonObject.get("consumablePurchased").getAsInt(),
                    participantJsonObject.get("damageDealtToBuildings").getAsInt(),
                    participantJsonObject.get("damageDealtToObjectives").getAsInt(),
                    participantJsonObject.get("damageDealtToTurrets").getAsInt(),
                    participantJsonObject.get("damageSelfMitigated").getAsInt(),
                    participantJsonObject.get("deaths").getAsInt(),
                    participantJsonObject.get("detectorWardsPlaced").getAsInt(),
                    participantJsonObject.get("doubleKills").getAsInt(),
                    participantJsonObject.get("dragonKills").getAsInt(),
                    participantJsonObject.get("firstBloodAssists").getAsBoolean(),
                    participantJsonObject.get("firstBloodKills").getAsBoolean(),
                    participantJsonObject.get("firstTowerAssists").getAsBoolean(),
                    participantJsonObject.get("firstTowerKill").getAsBoolean(),
                    participantJsonObject.get("gameEndedInEarlySurrender").getAsBoolean(),
                    participantJsonObject.get("gameEndedInSurrender").getAsBoolean(),
                    participantJsonObject.get("goldEarned").getAsInt(),
                    participantJsonObject.get("goldSpent").getAsInt(),
                    participantJsonObject.get("individualPosition").getAsString(),
                    participantJsonObject.get("inhibitorKills").getAsInt(),
                    participantJsonObject.get("inhibitorTakedowns").getAsInt(),
                    participantJsonObject.get("inhibitorsLost").getAsInt(),
                    participantJsonObject.get("item0").getAsInt(),
                    participantJsonObject.get("item1").getAsInt(),
                    participantJsonObject.get("item2").getAsInt(),
                    participantJsonObject.get("item3").getAsInt(),
                    participantJsonObject.get("item4").getAsInt(),
                    participantJsonObject.get("item5").getAsInt(),
                    participantJsonObject.get("item6").getAsInt(),
                    participantJsonObject.get("itemsPurchased").getAsInt(),
                    participantJsonObject.get("killingSprees").getAsInt(),
                    participantJsonObject.get("kills").getAsInt(),
                    participantJsonObject.get("lane").getAsString(),
                    participantJsonObject.get("largestCriticalStrike").getAsInt(),
                    participantJsonObject.get("largestKillingSpree").getAsInt(),
                    participantJsonObject.get("largestMultiKill").getAsInt(),
                    participantJsonObject.get("longestTimespentLiving").getAsInt(),
                    participantJsonObject.get("magicDamageDealt").getAsInt(),
                    participantJsonObject.get("magicDamageDealtToChampions").getAsInt(),
                    participantJsonObject.get("magicDamageTaken").getAsInt(),
                    participantJsonObject.get("neutralMinionsKilled").getAsInt(),
                    participantJsonObject.get("nexusKills").getAsInt(),
                    participantJsonObject.get("objectivesStolen").getAsInt(),
                    participantJsonObject.get("objectivesStolenAssists").getAsInt(),
                    participantJsonObject.get("pentaKills").getAsInt(),
                    participantJsonObject.get("physicalDamageDealt").getAsInt(),
                    participantJsonObject.get("physicalDamageDealtToChampions").getAsInt(),
                    participantJsonObject.get("physicalDamageTaken").getAsInt(),
                    participantJsonObject.get("profileIcon").getAsInt(),
                    participantJsonObject.get("puuid").getAsString(),
                    participantJsonObject.get("quadraKills").getAsInt(),
                    participantJsonObject.get("riotIdName").getAsString(),
                    participantJsonObject.get("riotIdTagLine").getAsString(),
                    participantJsonObject.get("role").getAsString(),
                    participantJsonObject.get("sightWardsBoughtInGame").getAsInt(),
                    participantJsonObject.get("spell1Casts").getAsInt(),
                    participantJsonObject.get("spell2Casts").getAsInt(),
                    participantJsonObject.get("spell3Casts").getAsInt(),
                    participantJsonObject.get("spell4Casts").getAsInt(),
                    participantJsonObject.get("summoner1Casts").getAsInt(),
                    participantJsonObject.get("summoner1Id").getAsInt(),
                    participantJsonObject.get("summoner2Casts").getAsInt(),
                    participantJsonObject.get("summoner2Id").getAsInt(),
                    participantJsonObject.get("summonerId").getAsString(),
                    participantJsonObject.get("summonerLevel").getAsInt(),
                    participantJsonObject.get("summonerName").getAsString(),
                    participantJsonObject.get("teamEarlySurrendered").getAsBoolean(),
                    participantJsonObject.get("teamId").getAsInt(),
                    participantJsonObject.get("teamPosition").getAsString(),
                    participantJsonObject.get("timeCCingOthers").getAsInt(),
                    participantJsonObject.get("timePlayed").getAsInt(),
                    participantJsonObject.get("totalDamageDealt").getAsInt(),
                    participantJsonObject.get("totalDamageDealtToChampions").getAsInt(),
                    participantJsonObject.get("totalDamageShieldedOnTeammates").getAsInt(),
                    participantJsonObject.get("totalDamageTaken").getAsInt(),
                    participantJsonObject.get("totalHeal").getAsInt(),
                    participantJsonObject.get("totalHealsOnTeammates").getAsInt(),
                    participantJsonObject.get("totalMinionsKilled").getAsInt(),
                    participantJsonObject.get("totalTimeCCDealt").getAsInt(),
                    participantJsonObject.get("totalTimeSpentDead").getAsInt(),
                    participantJsonObject.get("totalUnitsHealed").getAsInt(),
                    participantJsonObject.get("tripleKills").getAsInt(),
                    participantJsonObject.get("trueDamageDealt").getAsInt(),
                    participantJsonObject.get("trueDamageDealtToChampions").getAsInt(),
                    participantJsonObject.get("trueDamageTaken").getAsInt(),
                    participantJsonObject.get("turretKills").getAsInt(),
                    participantJsonObject.get("turretTakedowns").getAsInt(),
                    participantJsonObject.get("turretsLost").getAsInt(),
                    participantJsonObject.get("unrealKills").getAsInt(),
                    participantJsonObject.get("visionScore").getAsInt(),
                    participantJsonObject.get("visionWardsBoughtInGame").getAsInt(),
                    participantJsonObject.get("wardsKilled").getAsInt(),
                    participantJsonObject.get("wardsPlaced").getAsInt(),
                    participantJsonObject.get("win").getAsBoolean(),
                    toPerksDto(participantJsonObject.getAsJsonObject("perks")),
                    participantJsonObject.get("kda").getAsString(),
                    participantJsonObject.get("minionsKilledPerMin").getAsString(),
                    participantJsonObject.get("killRation").getAsString(),
                    participantJsonObject.get("multiKills").getAsString()
            );

            participantDtoList.add(participantDto);
        }

        return participantDtoList;
    }

    public MetadataDto toMetadataDto(JsonObject metadataObject) {
        return new MetadataDto(
            metadataObject.get("dataVersion").getAsString(),
            metadataObject.get("matchId").getAsString(),
            toParticipantDtoList(metadataObject.getAsJsonArray("participants"))
        );
    }

    public List<TeamDto> toTeamDtoList(JsonArray teamObjectList) throws JsonProcessingException {
        List<TeamDto> teamDtoList = new ArrayList<>();

        for (Object teamObject : teamObjectList) {
            JsonObject teamJsonObject = (JsonObject)teamObject;
            teamDtoList.add(toTeamDto(teamJsonObject));
        }

        return teamDtoList;
    }

    public InfoDto toInfoDto(JsonObject infoObject) throws JsonProcessingException {
        return new InfoDto(
            infoObject.get("gameCreation").getAsLong(),
            infoObject.get("gameDuration").getAsLong(),
            infoObject.get("gameEndTimestamp").getAsLong(),
            infoObject.get("gameId").getAsLong(),
            infoObject.get("gameMode").getAsString(),
            infoObject.get("gameName").getAsString(),
            infoObject.get("gameStartTimestamp").getAsLong(),
            infoObject.get("gameType").getAsString(),
            infoObject.get("gameVersion").getAsString(),
            infoObject.get("mapId").getAsInt(),
            infoObject.get("platformId").getAsString(),
            infoObject.get("queueId").getAsInt(),
            infoObject.get("tournamentCode").getAsString(),
            toParticipantDtoList(infoObject.getAsJsonArray("participants")),
            toTeamDtoList(infoObject.getAsJsonArray("teams"))
        );
    }

    public MatchDto toMatchDto(JsonObject matchObject) throws JsonProcessingException {
        return new MatchDto(
            toMetadataDto(matchObject.getAsJsonObject("metadata")),
            toInfoDto(matchObject.getAsJsonObject("info"))
        );
    }
}
