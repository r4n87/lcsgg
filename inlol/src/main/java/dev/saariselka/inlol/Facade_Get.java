package dev.saariselka.inlol;

import dev.saariselka.inlol.controller.*;
import dev.saariselka.inlol.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
public class Facade_Get {

    @Autowired
    APIController apiController;
    @Autowired
    APIKeyController apiKeyController;
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

    private API api;
    private String apiKey;

    public Facade_Get()
    {
        api = new API();
    }

    public HashMap<String, Object> getMatchInfo(ArrayList<String> matchList, int i) {

        apiKey = apiKeyController.getAPIKey_ByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri;
            uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("MATCH","GET_MATCH_BY_MATCHID")
                    + matchList.get(i)
                    + "?"
                    + "api_key=" + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, HashMap.class);


        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("error~");
            System.out.println(e);

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion~");
            System.out.println(e);
        }
        return result;
    }

    public ArrayList<HashMap<String,Object>> getMatchInfoFromDB(String puuid) {
        ArrayList<HashMap<String,Object>> result = new ArrayList<>();
        List<MatchParticipantEntity> matchList = matchParticipantController.getMatchParticipantList_ByPuuid(puuid);
        if(0 == matchList.size()) return null;

        HashMap<String,Object> matchInfo = new HashMap<>();
        HashMap<String,Object> metadataMap = new HashMap<>();
        HashMap<String,Object> infoMap = new HashMap<>();

        String matchId;
        String dataVersion;

        for(MatchParticipantEntity match : matchList) {
            MatchMasterEntity masterEntity = matchMasterController.getMatchMaster_ByMatchId(match.getMatchParticipantId().getMatchId()).get(0);
            matchId = masterEntity.getMatchMasterId().getMatchId();
            dataVersion = masterEntity.getMatchMasterId().getDataVersion();

            //1. Match Master 정보 생성
            metadataMap.put("dataVersion", masterEntity.getMatchMasterId().getDataVersion());
            metadataMap.put("matchId", masterEntity.getMatchMasterId().getMatchId());
            infoMap.put("gameCreation", masterEntity.getGameCreation());
            infoMap.put("gameDuration", masterEntity.getGameDuration());
            infoMap.put("gameEndTimestamp", masterEntity.getGameEndTimeStamp());
            infoMap.put("gameId", masterEntity.getGameId());
            infoMap.put("gameMode", masterEntity.getGameMode());
            infoMap.put("gameName", masterEntity.getGameName());
            infoMap.put("gameStartTimestamp", String.valueOf(masterEntity.getGameStartTimeStamp()));
            infoMap.put("gameType", masterEntity.getGameType());
            infoMap.put("gameVersion", masterEntity.getGameVersion());
            infoMap.put("mapId", String.valueOf(masterEntity.getMapId()));
            infoMap.put("platformId", masterEntity.getPlatformId());
            infoMap.put("queueId", String.valueOf(masterEntity.getQueueId()));
            infoMap.put("tournamentCode", masterEntity.getTournamentCode());

            //2. Team 정보 생성
            List<TeamEntity> teamsList = teamController.getTeams_ByMatchId(matchId);
            Object[] teamsInfo = new Object[2];
            int index = 0;

            for(TeamEntity teamEntity : teamsList) {
                HashMap<String, Object> teamInfo = new HashMap<>();
                teamInfo.put("teamId", String.valueOf(teamEntity.getTeamId().getTeamId()));
                teamInfo.put("win", String.valueOf(teamEntity.isWin()));


                //3. Match Ban 정보 생성
                List<MatchBanEntity> bansList = matchBanController.getBans_ByMatchBanIdAndTeamId(matchId, teamEntity.getTeamId().getTeamId());
                Object[] bansInfo = new Object[5];

                int tempIndex = 0;
                for(MatchBanEntity banEntity : bansList) {
                    HashMap<String, String> banInfo = new HashMap<>();
                    banInfo.put("championId", String.valueOf(banEntity.getChampionId()));
                    banInfo.put("pickTurn", String.valueOf(banEntity.getMatchBanId().getPickTurn()));

                    bansInfo[tempIndex] = banInfo;
                    tempIndex++;
                }

                teamInfo.put("bans", bansInfo);

                //4. Match Objectives 정보 생성
                MatchObjectivesEntity objectivesEntity = matchObjectivesController
                                                        .getMatchObjectives_ByMatchIdAndTeamId(matchId, teamEntity.getTeamId().getTeamId())
                                                        .get(0);

                HashMap<String, Object> objectivesInfo = new HashMap<>();
                HashMap<String, Object> baron = new HashMap<>();
                HashMap<String, Object> champion = new HashMap<>();
                HashMap<String, Object> dragon = new HashMap<>();
                HashMap<String, Object> inhibitor = new HashMap<>();
                HashMap<String, Object> riftHerald = new HashMap<>();
                HashMap<String, Object> tower = new HashMap<>();


                baron.put("first", objectivesEntity.isBaron_first());
                baron.put("kills", objectivesEntity.getBaron_kills());
                champion.put("first", objectivesEntity.isChampion_first());
                champion.put("kills", objectivesEntity.getChampion_kills());
                dragon.put("first", objectivesEntity.isDragon_first());
                dragon.put("kills", objectivesEntity.getDragon_kills());
                inhibitor.put("first", objectivesEntity.isInhibitor_first());
                inhibitor.put("kills", objectivesEntity.getInhibitor_kills());
                riftHerald.put("first", objectivesEntity.isRiftherald_first());
                riftHerald.put("kills", objectivesEntity.getRiftherald_kills());
                tower.put("first", objectivesEntity.isTower_first());
                tower.put("kills", objectivesEntity.getTower_kills());

                objectivesInfo.put("baron", baron);
                objectivesInfo.put("champion", champion);
                objectivesInfo.put("dragon", dragon);
                objectivesInfo.put("inhibitor", inhibitor);
                objectivesInfo.put("riftHerald", riftHerald);
                objectivesInfo.put("tower", tower);

                teamInfo.put("objectives", objectivesInfo);


                teamsInfo[index] = teamInfo;
                index++;
            }

            infoMap.put("teams", teamsInfo);


            //5. Match Participants 정보 생성
            List<MatchParticipantEntity> participantsList = matchParticipantController.getMatchParticipantList_ByDataVersionAndMatchId(dataVersion, matchId);
            String[] participantsPuuid = new String[10];
            Object[] participantsInfo = new Object[10];

            index = 0;
            for(MatchParticipantEntity participantEntity : participantsList) {
                participantsPuuid[index] = participantEntity.getMatchParticipantId().getPuuid();
                HashMap<String, Object> participantInfo = new HashMap<>();

                participantInfo.put("assists", String.valueOf(participantEntity.getAssists()));
                participantInfo.put("baronKills", String.valueOf(participantEntity.getBaronKills()));
                participantInfo.put("bountyLevel", String.valueOf(participantEntity.getBountyLevel()));
                participantInfo.put("champExperience", String.valueOf(participantEntity.getChampExperience()));
                participantInfo.put("champLevel", String.valueOf(participantEntity.getChampLevel()));
                participantInfo.put("championId", String.valueOf(participantEntity.getChampionName()));
                participantInfo.put("championName", participantEntity.getChampionName());
                participantInfo.put("championTransform",String.valueOf(participantEntity.getChampionTransform()));
                participantInfo.put("consumablesPurchased", String.valueOf(participantEntity.getConsumablesPurchased()));
                participantInfo.put("damageDealtToBuildings", String.valueOf(participantEntity.getDamageDealtToBuildings()));
                participantInfo.put("damageDealtToObjectives", String.valueOf(participantEntity.getDamageDealtToObjectives()));
                participantInfo.put("damageDealtToTurrets", String.valueOf(participantEntity.getDamageDealtToTurrets()));
                participantInfo.put("damageSelfMitigated", String.valueOf(participantEntity.getDamageSelfMitigated()));
                participantInfo.put("deaths", String.valueOf(participantEntity.getDeaths()));
                participantInfo.put("detectorWardsPlaced", String.valueOf(participantEntity.getDetectorWardsPlaced()));
                participantInfo.put("doubleKills", String.valueOf(participantEntity.getDoubleKills()));
                participantInfo.put("dragonKills", String.valueOf(participantEntity.getDragonKills()));
                participantInfo.put("firstBloodAssist", String.valueOf(participantEntity.isFirstBloodAssist()));
                participantInfo.put("firstBloodKill", String.valueOf(participantEntity.isFirstBloodKill()));
                participantInfo.put("firstTowerAssist", String.valueOf(participantEntity.isFirstTowerAssist()));
                participantInfo.put("firstTowerKill", String.valueOf(participantEntity.isFirstTowerKill()));
                participantInfo.put("gameEndedInEarlySurrender", String.valueOf(participantEntity.isGameEndedInEarlySurrender()));
                participantInfo.put("gameEndedInSurrender", String.valueOf(participantEntity.isGameEndedInSurrender()));
                participantInfo.put("goldEarned", String.valueOf(participantEntity.getGoldEarned()));
                participantInfo.put("goldSpent", String.valueOf(participantEntity.getGoldSpent()));
                participantInfo.put("individualPosition", participantEntity.getIndividualPosition());
                participantInfo.put("inhibitorKills", String.valueOf(participantEntity.getInhibitorKills()));
                participantInfo.put("inhibitorTakedowns", String.valueOf(participantEntity.getInhibitorTakedowns()));
                participantInfo.put("inhibitorsLost", String.valueOf(participantEntity.getInhibitorsLost()));
                participantInfo.put("item0", String.valueOf(participantEntity.getItem0()));
                participantInfo.put("item1", String.valueOf(participantEntity.getItem1()));
                participantInfo.put("item2", String.valueOf(participantEntity.getItem2()));
                participantInfo.put("item3", String.valueOf(participantEntity.getItem3()));
                participantInfo.put("item4", String.valueOf(participantEntity.getItem4()));
                participantInfo.put("item5", String.valueOf(participantEntity.getItem5()));
                participantInfo.put("item6", String.valueOf(participantEntity.getItem6()));
                participantInfo.put("itemsPurchased", String.valueOf(participantEntity.getItemsPurchased()));
                participantInfo.put("killingSprees", String.valueOf(participantEntity.getKillingSprees()));
                participantInfo.put("kills", String.valueOf(participantEntity.getKills()));
                participantInfo.put("lane", participantEntity.getLane());
                participantInfo.put("largestCriticalStrike", String.valueOf(participantEntity.getLargestCriticalStrike()));
                participantInfo.put("largestKillingSpree", String.valueOf(participantEntity.getLargestKillingSpree()));
                participantInfo.put("largestMultiKill", String.valueOf(participantEntity.getLargestMultiKill()));
                participantInfo.put("longestTimeSpentLiving", String.valueOf(participantEntity.getLongestTimeSpentLiving()));
                participantInfo.put("magicDamageDealt", String.valueOf(participantEntity.getMagicDamageDealt()));
                participantInfo.put("magicDamageDealtToChampions", String.valueOf(participantEntity.getMagicDamageDealtToChampions()));
                participantInfo.put("magicDamageTaken", String.valueOf(participantEntity.getMagicDamageTaken()));
                participantInfo.put("neutralMinionsKilled", String.valueOf(participantEntity.getNeutralMinionsKilled()));
                participantInfo.put("nexusKills", String.valueOf(participantEntity.getNexusKills()));
                participantInfo.put("nexusLost", String.valueOf(participantEntity.getNexusLost()));
                participantInfo.put("nexusTakedowns", String.valueOf(participantEntity.getNexusTakedowns()));
                participantInfo.put("objectivesStolen", String.valueOf(participantEntity.getObjectivesStolen()));
                participantInfo.put("objectivesStolenAssists", String.valueOf(participantEntity.getObjectivesStolenAssists()));
                participantInfo.put("participantId", String.valueOf(participantEntity.getParticipantId()));
                participantInfo.put("pentaKills", String.valueOf(participantEntity.getPentaKills()));
                participantInfo.put("physicalDamageDealt", String.valueOf(participantEntity.getPhysicalDamageDealt()));
                participantInfo.put("physicalDamageDealtToChampions", String.valueOf(participantEntity.getPhysicalDamageDealtToChampions()));
                participantInfo.put("physicalDamageTaken", String.valueOf(participantEntity.getPhysicalDamageTaken()));
                participantInfo.put("puuid", participantsPuuid[index]);
                participantInfo.put("profileIcon", String.valueOf(participantEntity.getProfileIcon()));
                participantInfo.put("quadraKills", String.valueOf(participantEntity.getQuadraKills()));
                participantInfo.put("riotIdName", participantEntity.getRiotIdName());
                participantInfo.put("riotIdTagline", participantEntity.getRiotIdTagline());
                participantInfo.put("role", participantEntity.getRole());
                participantInfo.put("sightWardsBoughtInGame", String.valueOf(participantEntity.getSightWardsBoughtInGame()));
                participantInfo.put("spell1Casts", String.valueOf(participantEntity.getSpell1Casts()));
                participantInfo.put("spell2Casts", String.valueOf(participantEntity.getSpell2Casts()));
                participantInfo.put("spell3Casts", String.valueOf(participantEntity.getSpell3Casts()));
                participantInfo.put("spell4Casts", String.valueOf(participantEntity.getSpell4Casts()));
                participantInfo.put("summoner1Casts", String.valueOf(participantEntity.getSummoner1Casts()));
                participantInfo.put("summoner1Id", String.valueOf(participantEntity.getSummoner1Id()));
                participantInfo.put("summoner2Casts", String.valueOf(participantEntity.getSummoner2Casts()));
                participantInfo.put("summoner2Id", String.valueOf(participantEntity.getSummoner2Id()));
                participantInfo.put("summonerId", participantEntity.getSummonerId());
                participantInfo.put("summonerLevel", String.valueOf(participantEntity.getSummonerLevel()));
                participantInfo.put("summonerName", participantEntity.getSummonerName());
                participantInfo.put("teamEarlySurrendered", String.valueOf(participantEntity.isTeamEarlySurrendered()));
                participantInfo.put("teamId", String.valueOf(participantEntity.getTeamId()));
                participantInfo.put("teamPosition", participantEntity.getTeamPosition());
                participantInfo.put("timeCCingOthers", String.valueOf(participantEntity.getTimeCCingOthers()));
                participantInfo.put("timePlayed", String.valueOf(participantEntity.getTimePlayed()));
                participantInfo.put("totalDamageDealt", String.valueOf(participantEntity.getTotalDamageDealt()));
                participantInfo.put("totalDamageDealtToChampions", String.valueOf(participantEntity.getTotalDamageDealtToChampions()));
                participantInfo.put("totalDamageShieldedOnTeammates", String.valueOf(participantEntity.getTotalDamageShieldedOnTeammates()));
                participantInfo.put("totalDamageTaken", String.valueOf(participantEntity.getTotalDamageTaken()));
                participantInfo.put("totalHeal", String.valueOf(participantEntity.getTotalHeal()));
                participantInfo.put("totalHealsOnTeammates", String.valueOf(participantEntity.getTotalHealsOnTeammates()));
                participantInfo.put("totalMinionsKilled", String.valueOf(participantEntity.getTotalMinionsKilled()));
                participantInfo.put("totalTimeCCDealt", String.valueOf(participantEntity.getTotalTimeCCDealt()));
                participantInfo.put("totalTimeSpentDead", String.valueOf(participantEntity.getTotalTimeSpentDead()));
                participantInfo.put("totalUnitsHealed", String.valueOf(participantEntity.getTotalUnitsHealed()));
                participantInfo.put("tripleKills", String.valueOf(participantEntity.getTripleKills()));
                participantInfo.put("trueDamageDealt", String.valueOf(participantEntity.getTrueDamageDealt()));
                participantInfo.put("trueDamageDealtToChampions", String.valueOf(participantEntity.getTrueDamageDealtToChampions()));
                participantInfo.put("trueDamageTaken", String.valueOf(participantEntity.getTrueDamageTaken()));
                participantInfo.put("turretKills", String.valueOf(participantEntity.getTurretKills()));
                participantInfo.put("turretTakedowns", String.valueOf(participantEntity.getTurretTakedowns()));
                participantInfo.put("turretsLost", String.valueOf(participantEntity.getTurretsLost()));
                participantInfo.put("unrealKills", String.valueOf(participantEntity.getUnrealKills()));
                participantInfo.put("visionScore", String.valueOf(participantEntity.getVisionScore()));
                participantInfo.put("visionWardsBoughtInGame", String.valueOf(participantEntity.getVisionWardsBoughtInGame()));
                participantInfo.put("wardsKilled", String.valueOf(participantEntity.getWardsKilled()));
                participantInfo.put("wardsPlaced", String.valueOf(participantEntity.getWardsPlaced()));
                participantInfo.put("win", String.valueOf(participantEntity.isWin()));

                participantsInfo[index] = participantInfo;
                index++;
            }

            metadataMap.put("participants", participantsPuuid);
            infoMap.put("participants", participantsInfo);
            System.out.println(infoMap.get("participants").toString());

            matchInfo.put("metadata", metadataMap);
            matchInfo.put("info", infoMap);

            result.add(matchInfo);
        }

        return result;
    }

    public ArrayList<String> getMatchList(String name) {

        apiKey = apiKeyController.getAPIKey_ByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();
        ArrayList<String> matchList = new ArrayList<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("MATCH", "GET_MATCHES_BY_PUUID")
                    + summonerController.getSummoner_Puuid_ByName(name)
                    + "/ids?start=0&count=20&api_key="
                    + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, List.class);

            // parsing
            matchList = (ArrayList) result.get("body");
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body", e.getStatusText());
            System.out.println("get match list error");
            System.out.println(e);

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body", "get match list exception");
            System.out.println(e);
        }
        return matchList;
    }


    public HashMap<String, Object> getSummonerInfo(String name) {

        apiKey = apiKeyController.getAPIKey_ByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("SUMMONER","GET_PUUID_BY_NAME")
                    + name
                    + "?"+"api_key="
                    + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, Map.class);


        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("summoner info get error");
            System.out.println(e);

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "summoner info get exception");
            System.out.println(e);
        }
        return result;
    }

    public LinkedHashMap<String, String> getSummonerInfoFromDB(String name) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        String puuid = summonerController.getSummoner_Puuid_ByName(name);
        if(null == puuid) return null;

        SummonerEntity summoner = summonerController.getSummoner(puuid).get(0);
        result.put("puuid", summoner.getPuuid());
        result.put("accountId", summoner.getAccountid());
        result.put("id", summoner.getId());
        result.put("name", summoner.getName());
        result.put("profileIconId", String.valueOf(summoner.getProfileiconid()));
        result.put("revisionDate", String.valueOf(summoner.getRevisiondate()));
        result.put("summonerLevel", String.valueOf(summoner.getSummonerlevel()));

        return result;
    }

    public HashMap<String, Object> getLeagueInfo(String encryptedSummonerId) {
        apiKey = apiKeyController.getAPIKey_ByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("LEAGUE","GET_LEAGUE_BY_ENCRYPTEDID")
                    + encryptedSummonerId
                    + "?"+"api_key="
                    + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, Set.class);

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body", e.getStatusText());
            System.out.println("league info get error");
            System.out.println(e);

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body", "league info get exception");
            System.out.println(e);
        }
        return result;
    }
}
