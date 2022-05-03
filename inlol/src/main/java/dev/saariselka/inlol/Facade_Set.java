package dev.saariselka.inlol;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import dev.saariselka.inlol.controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class Facade_Set {

    @Autowired
    SummonerController summonerController;
    @Autowired
    MatchMasterController matchMasterController;
    @Autowired
    TeamController teamController;
    @Autowired
    MatchParticipantController matchParticipantController;
    @Autowired
    MatchBanController matchBanController;
    @Autowired
    MatchObjectivesController matchObjectivesController;
    @Autowired
    LeagueEntryController leagueEntryController;

    public void setMatchInfoAtDB(HashMap<String, Object> matchInfo) throws JsonProcessingException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(matchInfo);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(jsonInString);
        JsonObject jsonObjectForMetadata = (JsonObject) jsonObject.get("metadata");
        JsonObject jsonObjectForInfo = (JsonObject) jsonObject.get("info");
        JsonArray jsonArrayForTeams = (JsonArray)jsonObjectForInfo.get("teams");
        JsonArray jsonArrayForParticipants = (JsonArray)jsonObjectForInfo.get("participants");

        //DB Insert
        matchMasterController.insertMatchMaster(jsonObjectForMetadata.get("dataVersion").getAsString(),jsonObjectForMetadata.get("matchId").getAsString(),
                Long.parseLong(jsonObjectForInfo.get("gameCreation").getAsString()),Long.parseLong(jsonObjectForInfo.get("gameDuration").getAsString()),
                Long.parseLong(jsonObjectForInfo.get("gameEndTimestamp").getAsString()),Long.parseLong(jsonObjectForInfo.get("gameId").getAsString()),
                jsonObjectForInfo.get("gameMode").getAsString(),jsonObjectForInfo.get("gameName").getAsString(),
                Long.parseLong(jsonObjectForInfo.get("gameStartTimestamp").getAsString()),jsonObjectForInfo.get("gameType").getAsString(),
                jsonObjectForInfo.get("gameVersion").getAsString(),Integer.parseInt(jsonObjectForInfo.get("mapId").getAsString()),

                jsonObjectForInfo.get("platformId").getAsString(),Integer.parseInt(jsonObjectForInfo.get("queueId").getAsString()),
                jsonObjectForInfo.get("tournamentCode").getAsString(), 100, 200
                ,timestamp);
      
        for (Object teamsObj : jsonArrayForTeams) {
            JsonObject teamObj = (JsonObject)teamsObj;

            teamController.insertTeamInfo(jsonObjectForMetadata.get("matchId").getAsString()
                    ,Integer.parseInt(teamObj.get("teamId").getAsString())
                    ,Boolean.parseBoolean(teamObj.get("win").getAsString())
                    ,timestamp);

            JsonArray jsonArrayForBans = (JsonArray)teamObj.get("bans");

            for (Object bansObj : jsonArrayForBans) {
                JsonObject banObj = (JsonObject)bansObj;
                matchBanController.insertBanInfo(jsonObjectForMetadata.get("matchId").getAsString()
                        ,Integer.parseInt(banObj.get("pickTurn").getAsString())
                        ,Integer.parseInt(teamObj.get("teamId").getAsString())
                        ,Integer.parseInt(banObj.get("championId").getAsString())
                        ,timestamp);
            }

            JsonObject objectivesObj = (JsonObject)teamObj.get("objectives");
            JsonObject baronObj = (JsonObject)objectivesObj.get("baron");
            JsonObject championObj = (JsonObject)objectivesObj.get("champion");
            JsonObject dragonObj = (JsonObject)objectivesObj.get("dragon");
            JsonObject inhibitorObj = (JsonObject)objectivesObj.get("inhibitor");
            JsonObject riftHeraldObj = (JsonObject)objectivesObj.get("riftHerald");
            JsonObject towerObj = (JsonObject)objectivesObj.get("tower");

            matchObjectivesController.insertObjectivesInfo(jsonObjectForMetadata.get("matchId").getAsString()
                    ,Integer.parseInt(teamObj.get("teamId").getAsString())
                    ,Boolean.parseBoolean(baronObj.get("first").getAsString())
                    ,Integer.parseInt(baronObj.get("kills").getAsString())
                    ,Boolean.parseBoolean(championObj.get("first").getAsString())
                    ,Integer.parseInt(championObj.get("kills").getAsString())
                    ,Boolean.parseBoolean(dragonObj.get("first").getAsString())
                    ,Integer.parseInt(dragonObj.get("kills").getAsString())
                    ,Boolean.parseBoolean(inhibitorObj.get("first").getAsString())
                    ,Integer.parseInt(inhibitorObj.get("kills").getAsString())
                    ,Boolean.parseBoolean(riftHeraldObj.get("first").getAsString())
                    ,Integer.parseInt(riftHeraldObj.get("kills").getAsString())
                    ,Boolean.parseBoolean(towerObj.get("first").getAsString())
                    ,Integer.parseInt(towerObj.get("kills").getAsString())
                    ,timestamp);
        }

        for (Object obj : jsonArrayForParticipants) {
            JsonObject participantObj = (JsonObject)obj;
            matchParticipantController.insertParticipantInfo(
                    participantObj.get("puuid").getAsString(),
                    jsonObjectForMetadata.get("dataVersion").getAsString(),
                    jsonObjectForMetadata.get("matchId").getAsString(),
                    Integer.parseInt(participantObj.get("assists").getAsString()),
                    Integer.parseInt(participantObj.get("baronKills").getAsString()),
                    Integer.parseInt(participantObj.get("bountyLevel").getAsString()),
                    Integer.parseInt(participantObj.get("champExperience").getAsString()),
                    Integer.parseInt(participantObj.get("champLevel").getAsString()),
                    Integer.parseInt(participantObj.get("championId").getAsString()),
                    participantObj.get("championName").getAsString(),
                    Integer.parseInt(participantObj.get("championTransform").getAsString()),
                    Integer.parseInt(participantObj.get("consumablesPurchased").getAsString()),
                    Integer.parseInt(participantObj.get("damageDealtToBuildings").getAsString()),
                    Integer.parseInt(participantObj.get("damageDealtToObjectives").getAsString()),
                    Integer.parseInt(participantObj.get("damageDealtToTurrets").getAsString()),
                    Integer.parseInt(participantObj.get("damageSelfMitigated").getAsString()),
                    Integer.parseInt(participantObj.get("deaths").getAsString()),
                    Integer.parseInt(participantObj.get("detectorWardsPlaced").getAsString()),
                    Integer.parseInt(participantObj.get("doubleKills").getAsString()),
                    Integer.parseInt(participantObj.get("dragonKills").getAsString()),
                    Boolean.parseBoolean(participantObj.get("firstBloodAssist").getAsString()),
                    Boolean.parseBoolean(participantObj.get("firstBloodKill").getAsString()),
                    Boolean.parseBoolean(participantObj.get("firstTowerAssist").getAsString()),
                    Boolean.parseBoolean(participantObj.get("firstTowerKill").getAsString()),
                    Boolean.parseBoolean(participantObj.get("gameEndedInEarlySurrender").getAsString()),
                    Boolean.parseBoolean(participantObj.get("gameEndedInSurrender").getAsString()),
                    Integer.parseInt(participantObj.get("goldEarned").getAsString()),
                    Integer.parseInt(participantObj.get("goldSpent").getAsString()),
                    participantObj.get("individualPosition").getAsString(),
                    Integer.parseInt(participantObj.get("inhibitorKills").getAsString()),
                    Integer.parseInt(participantObj.get("inhibitorTakedowns").getAsString()),
                    Integer.parseInt(participantObj.get("inhibitorsLost").getAsString()),
                    Integer.parseInt(participantObj.get("item0").getAsString()),
                    Integer.parseInt(participantObj.get("item1").getAsString()),
                    Integer.parseInt(participantObj.get("item2").getAsString()),
                    Integer.parseInt(participantObj.get("item3").getAsString()),
                    Integer.parseInt(participantObj.get("item4").getAsString()),
                    Integer.parseInt(participantObj.get("item5").getAsString()),
                    Integer.parseInt(participantObj.get("item6").getAsString()),
                    Integer.parseInt(participantObj.get("itemsPurchased").getAsString()),
                    Integer.parseInt(participantObj.get("killingSprees").getAsString()),
                    Integer.parseInt(participantObj.get("kills").getAsString()),
                    participantObj.get("lane").getAsString(),
                    Integer.parseInt(participantObj.get("largestCriticalStrike").getAsString()),
                    Integer.parseInt(participantObj.get("largestKillingSpree").getAsString()),
                    Integer.parseInt(participantObj.get("largestMultiKill").getAsString()),
                    Integer.parseInt(participantObj.get("longestTimeSpentLiving").getAsString()),
                    Integer.parseInt(participantObj.get("magicDamageDealt").getAsString()),
                    Integer.parseInt(participantObj.get("magicDamageDealtToChampions").getAsString()),
                    Integer.parseInt(participantObj.get("magicDamageTaken").getAsString()),
                    Integer.parseInt(participantObj.get("neutralMinionsKilled").getAsString()),
                    Integer.parseInt(participantObj.get("nexusKills").getAsString()),
                    Integer.parseInt(participantObj.get("nexusLost").getAsString()),
                    Integer.parseInt(participantObj.get("nexusTakedowns").getAsString()),
                    Integer.parseInt(participantObj.get("objectivesStolen").getAsString()),
                    Integer.parseInt(participantObj.get("objectivesStolenAssists").getAsString()),
                    Integer.parseInt(participantObj.get("participantId").getAsString()),
                    Integer.parseInt(participantObj.get("pentaKills").getAsString()),
                    Integer.parseInt(participantObj.get("physicalDamageDealt").getAsString()),
                    Integer.parseInt(participantObj.get("physicalDamageDealtToChampions").getAsString()),
                    Integer.parseInt(participantObj.get("physicalDamageTaken").getAsString()),
                    Integer.parseInt(participantObj.get("profileIcon").getAsString()),
                    Integer.parseInt(participantObj.get("quadraKills").getAsString()),
                    participantObj.get("riotIdName").getAsString(),
                    participantObj.get("riotIdTagline").getAsString(),
                    participantObj.get("role").getAsString(),
                    Integer.parseInt(participantObj.get("sightWardsBoughtInGame").getAsString()),
                    Integer.parseInt(participantObj.get("spell1Casts").getAsString()),
                    Integer.parseInt(participantObj.get("spell2Casts").getAsString()),
                    Integer.parseInt(participantObj.get("spell3Casts").getAsString()),
                    Integer.parseInt(participantObj.get("spell4Casts").getAsString()),
                    Integer.parseInt(participantObj.get("summoner1Casts").getAsString()),
                    Integer.parseInt(participantObj.get("summoner1Id").getAsString()),
                    Integer.parseInt(participantObj.get("summoner2Casts").getAsString()),
                    Integer.parseInt(participantObj.get("summoner2Id").getAsString()),
                    participantObj.get("summonerId").getAsString(),
                    Integer.parseInt(participantObj.get("summonerLevel").getAsString()),
                    participantObj.get("summonerName").getAsString(),
                    Boolean.parseBoolean(participantObj.get("teamEarlySurrendered").getAsString()),
                    Integer.parseInt(participantObj.get("teamId").getAsString()),
                    participantObj.get("teamPosition").getAsString(),
                    Integer.parseInt(participantObj.get("timeCCingOthers").getAsString()),
                    Integer.parseInt(participantObj.get("timePlayed").getAsString()),
                    Integer.parseInt(participantObj.get("totalDamageDealt").getAsString()),
                    Integer.parseInt(participantObj.get("totalDamageDealtToChampions").getAsString()),
                    Integer.parseInt(participantObj.get("totalDamageShieldedOnTeammates").getAsString()),
                    Integer.parseInt(participantObj.get("totalDamageTaken").getAsString()),
                    Integer.parseInt(participantObj.get("totalHeal").getAsString()),
                    Integer.parseInt(participantObj.get("totalHealsOnTeammates").getAsString()),
                    Integer.parseInt(participantObj.get("totalMinionsKilled").getAsString()),
                    Integer.parseInt(participantObj.get("totalTimeCCDealt").getAsString()),
                    Integer.parseInt(participantObj.get("totalTimeSpentDead").getAsString()),
                    Integer.parseInt(participantObj.get("totalUnitsHealed").getAsString()),
                    Integer.parseInt(participantObj.get("tripleKills").getAsString()),
                    Integer.parseInt(participantObj.get("trueDamageDealt").getAsString()),
                    Integer.parseInt(participantObj.get("trueDamageDealtToChampions").getAsString()),
                    Integer.parseInt(participantObj.get("trueDamageTaken").getAsString()),
                    Integer.parseInt(participantObj.get("turretKills").getAsString()),
                    Integer.parseInt(participantObj.get("turretTakedowns").getAsString()),
                    Integer.parseInt(participantObj.get("turretsLost").getAsString()),
                    Integer.parseInt(participantObj.get("unrealKills").getAsString()),
                    Integer.parseInt(participantObj.get("visionScore").getAsString()),
                    Integer.parseInt(participantObj.get("visionWardsBoughtInGame").getAsString()),
                    Integer.parseInt(participantObj.get("wardsKilled").getAsString()),
                    Integer.parseInt(participantObj.get("wardsPlaced").getAsString()),
                    Boolean.parseBoolean(participantObj.get("win").getAsString()),
                    timestamp
                    );
        }
    }

    public void setSummonerInfoAtDB(HashMap<String, String> result) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // DB Insert
        summonerController.insertSummoner(result.get("accountId"),Integer.parseInt(String.valueOf(result.get("profileIconId"))),
                Long.parseLong(String.valueOf(result.get("revisionDate"))),result.get("name"),result.get("id"),
                Long.parseLong(String.valueOf(result.get("summonerLevel"))),result.get("puuid"), timestamp);
    }

    public void setLeagueInfoAtDB(HashSet<Object> result) {
        // parsing
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Iterator<Object> it = result.iterator();
        while(it.hasNext())
        {
            LinkedHashMap<String, Object> data = (LinkedHashMap) it.next();
            // DB Insert
            leagueEntryController.insertLeagueEntryInfo(data.get("summonerId").toString(), data.get("queueType").toString(), data.get("leagueId").toString(),
                    data.get("summonerName").toString(), data.get("tier").toString(), data.get("rank").toString(), Integer.parseInt(String.valueOf(data.get("leaguePoints"))),
                    Integer.parseInt(String.valueOf(data.get("wins"))), Integer.parseInt(String.valueOf(data.get("losses"))),
                    Boolean.parseBoolean(data.get("hotStreak").toString()), Boolean.parseBoolean(data.get("veteran").toString()),
                    Boolean.parseBoolean(data.get("freshBlood").toString()), Boolean.parseBoolean(data.get("inactive").toString()),
                    timestamp
            );
        }

    }
}
