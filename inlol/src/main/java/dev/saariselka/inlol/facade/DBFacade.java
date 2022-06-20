package dev.saariselka.inlol.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.saariselka.inlol.controller.*;
import dev.saariselka.inlol.dto.*;
import dev.saariselka.inlol.entity.*;
import dev.saariselka.inlol.utils.JsonParserForLOL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.*;

@Service
public class DBFacade {

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
    @Autowired
    LeagueMiniSeriesController leagueMiniSeriesController;
    @Autowired
    MatchPerksController matchPerksController;
    @Autowired
    DdragonVersionController ddragonVersionController;

    public SummonerDto getSummonerDtoBySummonerName(String name) {
        String puuid = summonerController.getSummoner_Puuid_ByName(name);

        if(null == puuid) return null;

        SummonerEntity summonerEntity = summonerController.getSummoner(puuid).get(0);

        return new SummonerDto(summonerEntity);
    }

    public String getSummonerPuuidBySummonerName(String name) {
        return summonerController.getSummoner_Puuid_ByName(name);
    }

    public SummonerDto getSummonerDtoBySummonerPuuid(String puuid) {
        return new SummonerDto(summonerController.getSummoner(puuid).get(0));
    }

    private void sortParticipantDtoList(List<ParticipantDto> blueParticipantDtoList, List<ParticipantDto> redParticipantDtoList) {
        blueParticipantDtoList.sort((o1, o2) -> {
            int score1 = getParticipantPositionScore(o1);
            int score2 = getParticipantPositionScore(o2);

            return score2 - score1;
        });

        redParticipantDtoList.sort((o1, o2) -> {
            int score1 = getParticipantPositionScore(o1);
            int score2 = getParticipantPositionScore(o2);

            return score2 - score1;
        });
    }

    private int getParticipantPositionScore(ParticipantDto participant) {
        int score = 0;

        switch(participant.getTeamPosition()) {
            case "TOP" : score = 5; break;
            case "JUNGLE" : score = 4; break;
            case "MIDDLE" : score = 3; break;
            case "BOTTOM" : score = 2; break;
            case "UTILITY" : score = 1; break;
        }
        return score;
    }

    public void setSummonerInfo(HashMap<String, String> result) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // DB Insert
        summonerController.insertSummoner(result.get("accountId"),Integer.parseInt(String.valueOf(result.get("profileIconId"))),
                Long.parseLong(String.valueOf(result.get("revisionDate"))),result.get("name"),result.get("id"),
                Long.parseLong(String.valueOf(result.get("summonerLevel"))),result.get("puuid"), timestamp);
    }

    public void setLeagueInfo(HashSet<Object> leagueInfos) {
        // parsing
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        for(Object leagueInfo : leagueInfos) {
            LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) leagueInfo;

            if(data.get("queueType").toString().equals("RANKED_FLEX_SR") || data.get("queueType").toString().equals("RANKED_SOLO_5x5"))
            {
                // DB Insert
                leagueEntryController.insertLeagueEntryInfo(data.get("summonerId").toString(), data.get("queueType").toString(), data.get("leagueId").toString(),
                        data.get("summonerName").toString(), data.get("tier").toString(), data.get("rank").toString(), Integer.parseInt(String.valueOf(data.get("leaguePoints"))),
                        Integer.parseInt(String.valueOf(data.get("wins"))), Integer.parseInt(String.valueOf(data.get("losses"))),
                        Boolean.parseBoolean(data.get("hotStreak").toString()), Boolean.parseBoolean(data.get("veteran").toString()),
                        Boolean.parseBoolean(data.get("freshBlood").toString()), Boolean.parseBoolean(data.get("inactive").toString()),
                        timestamp);

                LinkedHashMap<String, Object> miniSeriesData = (LinkedHashMap<String, Object>) data.get("miniSeries");

                if (miniSeriesData != null) {
                    leagueMiniSeriesController.insertLeagueMiniSeriesInfo(
                            data.get("summonerId").toString(),
                            data.get("queueType").toString(),
                            Integer.parseInt(String.valueOf(miniSeriesData.get("losses"))),
                            miniSeriesData.get("progress").toString(),
                            Integer.parseInt(String.valueOf(miniSeriesData.get("target"))),
                            Integer.parseInt(String.valueOf(miniSeriesData.get("wins"))),
                            timestamp);
                }
            }
        }

    }

    public ArrayList<LeagueEntryDto> getLeagueEntryDtoListBySummonerId(String summonerId) {
        ArrayList<LeagueEntryDto> result = new ArrayList<>();

        List<LeagueEntryEntity> leagueEntryEntityList = leagueEntryController.getLeagueEntries_BySummonerId(summonerId);

        for(LeagueEntryEntity leagueEntryEntity : leagueEntryEntityList) {

            LeagueMiniSeriesEntity leagueMiniSeriesEntity = leagueMiniSeriesController.getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId(summonerId,leagueEntryEntity.getLeagueEntryId().getQueueType());
            LeagueMiniSeriesDto leagueMiniSeriesDto = new LeagueMiniSeriesDto();

            if(leagueMiniSeriesEntity != null)
            {
                leagueMiniSeriesDto = new LeagueMiniSeriesDto(leagueMiniSeriesEntity);
            }

            LeagueEntryDto leagueEntryDto = new LeagueEntryDto(leagueEntryEntity, leagueMiniSeriesDto);
            result.add(leagueEntryDto);
        }

        return result;
    }

    public ArrayList<MatchDto> getMatchDtoListBySummonerPuuid(String puuid) throws IOException {
        ArrayList<MatchDto> matchDtos = new ArrayList<>();

        List<MatchParticipantEntity> matchList = matchParticipantController.getMatchParticipantList_ByPuuid(puuid);

        if(0 == matchList.size()) return null;

        String matchId;
        String dataVersion;

        for(MatchParticipantEntity match : matchList) {
            MatchMasterEntity matchMasterEntity = matchMasterController.getMatchMaster_ByMatchId(match.getMatchParticipantId().getMatchId()).get(0);
            matchId = matchMasterEntity.getMatchMasterId().getMatchId();
            dataVersion = matchMasterEntity.getMatchMasterId().getDataVersion();

            //2. Team 정보 생성
            List<TeamEntity> teamEntityList = teamController.getTeams_ByMatchId(matchId);
            List<TeamDto> teamDtoList = new ArrayList<>();

            for(TeamEntity teamEntity : teamEntityList) {
                List<MatchBanEntity> matchBanEntityList = matchBanController.getBans_ByMatchBanIdAndTeamId(matchId, teamEntity.getTeamId().getTeamId());

                MatchObjectivesEntity matchObjectivesEntity = matchObjectivesController
                        .getMatchObjectives_ByMatchIdAndTeamId(matchId, teamEntity.getTeamId().getTeamId())
                        .get(0);

                List<BanDto> banDtoList = new ArrayList<>();

                for(MatchBanEntity matchBanEntity : matchBanEntityList) {
                    BanDto banDto = new BanDto(matchBanEntity);
                    banDtoList.add(banDto);
                }

                ObjectivesDto objectivesDto = new ObjectivesDto(matchObjectivesEntity);

                TeamDto teamDto = new TeamDto(teamEntity,banDtoList,objectivesDto);
                teamDtoList.add(teamDto);
            }

            //5. Match Participants 정보 생성
            List<MatchParticipantEntity> participantsList = matchParticipantController.getMatchParticipantList_ByDataVersionAndMatchId(dataVersion, matchId);
            List<ParticipantDto> blueParticipantDtoList = new ArrayList<>();
            List<ParticipantDto> redParticipantDtoList = new ArrayList<>();
            ParticipantDto summonerInfo = new ParticipantDto();
            int blueTeamKills = 0;
            int redTeamKills = 0;

            for(MatchParticipantEntity participantEntity : participantsList) {
                List<MatchPerksEntity> perksList = matchPerksController.getMatchPerksListByMatchIdAndPuuid(matchId, participantEntity.getMatchParticipantId().getPuuid());
                MatchPerksEntity perksEntity = (0 == perksList.size())
                        ? new MatchPerksEntity() : perksList.get(0);
                PerksDto perksDto = new PerksDto(perksEntity);
                ParticipantDto participantDto = new ParticipantDto(participantEntity, perksDto, matchMasterEntity.getGameDuration());

                if(puuid.equals(participantEntity.getMatchParticipantId().getPuuid())) {
                    summonerInfo = participantDto;
                    summonerInfo.setChampionNameKR(JsonParserForLOL.getKRChampionNameByENGChampionName(summonerInfo.getChampionNameENG()));
                }

                if("100".equals(participantDto.getTeamId())) {
                    blueTeamKills += Integer.parseInt(participantDto.getKills());
                    blueParticipantDtoList.add(participantDto);
                } else if("200".equals(participantDto.getTeamId())) {
                    redTeamKills += Integer.parseInt(participantDto.getKills());
                    redParticipantDtoList.add(participantDto);
                }
            }

            getAndSetKillRatio(blueParticipantDtoList, blueTeamKills);
            getAndSetKillRatio(redParticipantDtoList, redTeamKills);

            sortParticipantDtoList(blueParticipantDtoList, redParticipantDtoList);

            MetadataDto metadataDto = new MetadataDto(matchMasterEntity,participantsList);
            InfoDto infoDto = new InfoDto(matchMasterEntity,teamDtoList,blueParticipantDtoList,redParticipantDtoList,summonerInfo);

            MatchDto matchInfo = new MatchDto(metadataDto,infoDto);

            matchDtos.add(matchInfo);
        }

        return matchDtos;
    }

    private void getAndSetKillRatio(List<ParticipantDto> participantDtoList, int teamKills) {
        for(ParticipantDto participant : participantDtoList) {
            BigDecimal killAndAssists = new BigDecimal(participant.getKills()).add(new BigDecimal(participant.getAssists()));
            BigDecimal killRatio;

            if(teamKills == 0) {
                killRatio = BigDecimal.ZERO;
            } else {
                killRatio = killAndAssists.divide(new BigDecimal(teamKills), 2, RoundingMode.HALF_UP)
                        .multiply(BigDecimal.valueOf(100))
                        .setScale(0, RoundingMode.HALF_UP);
            }

            participant.setKillRatio(killRatio.toString());
        }
    }

    public void setMatch(HashMap<String, Object> matchInfo) throws JsonProcessingException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(matchInfo);

        JsonObject jsonObject = JsonParser.parseString(jsonInString).getAsJsonObject();
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

            JsonObject perks = (JsonObject) participantObj.get("perks");
            JsonObject statPerks = (JsonObject) perks.get("statPerks");
            JsonObject primaryStyle = null;
            JsonArray primaryPerks = null;
            JsonObject subStyle = null;
            JsonArray subPerks = null;

            for(Object styleObj : (JsonArray)perks.get("styles")) {
                JsonObject style = (JsonObject) styleObj;
                if("primaryStyle".equals(style.get("description").getAsString())) {
                    primaryStyle = style;
                    primaryPerks = (JsonArray) style.get("selections");
                } else {
                    subStyle = style;
                    subPerks = (JsonArray) style.get("selections");
                }
            }

            matchPerksController.insertPerks(jsonObjectForMetadata.get("matchId").getAsString()
                    , participantObj.get("puuid").getAsString()
                    , Integer.parseInt(primaryStyle.get("style").getAsString())
                    , Integer.parseInt(((JsonObject) primaryPerks.get(0)).get("perk").getAsString())
                    , Integer.parseInt(((JsonObject) primaryPerks.get(1)).get("perk").getAsString())
                    , Integer.parseInt(((JsonObject) primaryPerks.get(2)).get("perk").getAsString())
                    , Integer.parseInt(((JsonObject) primaryPerks.get(3)).get("perk").getAsString())
                    , Integer.parseInt(subStyle.get("style").getAsString())
                    , Integer.parseInt(((JsonObject) subPerks.get(0)).get("perk").getAsString())
                    , Integer.parseInt(((JsonObject) subPerks.get(1)).get("perk").getAsString())
                    , Integer.parseInt(statPerks.get("defense").getAsString())
                    , Integer.parseInt(statPerks.get("flex").getAsString())
                    , Integer.parseInt(statPerks.get("offense").getAsString())
                    , timestamp);
        }
    }

    public HashSet<String> getMatchIdListBySummonerPuuid(String puuid) {
        List<MatchParticipantEntity> list = matchParticipantController.getMatchParticipantList_ByPuuid(puuid);
        HashSet<String> matchList = new HashSet<>();

        for(MatchParticipantEntity entity : list) {
            matchList.add(entity.getMatchParticipantId().getMatchId());
        }

        return matchList;
    }

    public long getLastRefreshTimeBySummonerName(String puuid) {
        return getSummonerDtoBySummonerPuuid(puuid).getLastRefreshTime();
    }

    public void setSummoner(HashMap<String, String> result) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // DB Insert
        summonerController.insertSummoner(result.get("accountId"),Integer.parseInt(String.valueOf(result.get("profileIconId"))),
                Long.parseLong(String.valueOf(result.get("revisionDate"))),result.get("name"),result.get("id"),
                Long.parseLong(String.valueOf(result.get("summonerLevel"))),result.get("puuid"), timestamp);
    }

    public String getCurrentDdragonVersion() {
        return ddragonVersionController.getCurrentDdragonVersion();
    }
}
