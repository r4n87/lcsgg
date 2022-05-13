package dev.saariselka.inlol;

import dev.saariselka.inlol.controller.*;
import dev.saariselka.inlol.dto.*;
import dev.saariselka.inlol.entity.*;
import dev.saariselka.inlol.util.JSONParserForLOL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    public ArrayList<MatchDto> getMatchInfoFromDB(String puuid) {
        ArrayList<MatchDto> result = new ArrayList<>();
        List<MatchParticipantEntity> matchList = matchParticipantController.getMatchParticipantList_ByPuuid(puuid);

        if(0 == matchList.size()) return null;

        String matchId;
        String dataVersion;

        for(MatchParticipantEntity match : matchList) {
            MatchMasterEntity masterEntity = matchMasterController.getMatchMaster_ByMatchId(match.getMatchParticipantId().getMatchId()).get(0);
            matchId = masterEntity.getMatchMasterId().getMatchId();
            dataVersion = masterEntity.getMatchMasterId().getDataVersion();

            MatchDto matchInfo = new MatchDto();
            MetadataDto metadataDto = new MetadataDto();
            InfoDto infoDto = new InfoDto();

            //시간 차이 계산
            String gameDuration = String.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())))
                    + "분 "
                    + String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) - (ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) * 60))
                    + "초";

            String gameAgoTime = null;

            if (ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.now()) >= 24)
            {
                gameAgoTime = String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                        + "일 전";
            }
            else
            {
                gameAgoTime = String.valueOf(ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                        + "시간 전";
            }

            //1. Match Master 정보 생성
            metadataDto.setDataVersion(masterEntity.getMatchMasterId().getDataVersion());
            metadataDto.setMatchId(masterEntity.getMatchMasterId().getMatchId());

            infoDto.setGameCreation(masterEntity.getGameCreation());
            infoDto.setGameDuration(gameDuration);
            infoDto.setGameEndTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()));
            infoDto.setGameId(masterEntity.getGameId());
            //infoDto.setGameMode(masterEntity.getGameMode());
            infoDto.setGameMode(JSONParserForLOL.getKRGameModeByQueueId(masterEntity.getQueueId()));
            infoDto.setGameName(masterEntity.getGameName());
            infoDto.setGameStartTimeStamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()),TimeZone.getDefault().toZoneId()));
            infoDto.setGameType(masterEntity.getGameType());
            infoDto.setGameVersion(masterEntity.getGameVersion());
            infoDto.setMapId(String.valueOf(masterEntity.getMapId()));
            infoDto.setPlatformId(masterEntity.getPlatformId());
            infoDto.setQueueId(String.valueOf(masterEntity.getQueueId()));
            infoDto.setTournamentCode(masterEntity.getTournamentCode());
            infoDto.setGameAgoTime(gameAgoTime);

            //2. Team 정보 생성
            List<TeamEntity> teamsList = teamController.getTeams_ByMatchId(matchId);
            List<TeamDto> teamDtoList = new ArrayList<>();

            int index = 0;

            for(TeamEntity teamEntity : teamsList) {
                TeamDto teamDto = new TeamDto();
                teamDto.setTeamId(String.valueOf(teamEntity.getTeamId().getTeamId()));
                teamDto.setWin(String.valueOf(teamEntity.isWin()));

                //3. Match Ban 정보 생성
                List<MatchBanEntity> bansList = matchBanController.getBans_ByMatchBanIdAndTeamId(matchId, teamEntity.getTeamId().getTeamId());

                List<BanDto> banDtoList = new ArrayList<>();

                for(MatchBanEntity banEntity : bansList) {
                    BanDto banDto = new BanDto();
                    banDto.setChampionId(String.valueOf(banEntity.getChampionId()));
                    banDto.setPickTurn(String.valueOf(banEntity.getMatchBanId().getPickTurn()));

                    banDtoList.add(banDto);
                }

                teamDto.setBans(banDtoList);

                //4. Match Objectives 정보 생성
                MatchObjectivesEntity objectivesEntity = matchObjectivesController
                        .getMatchObjectives_ByMatchIdAndTeamId(matchId, teamEntity.getTeamId().getTeamId())
                        .get(0);

                ObjectivesDto objectivesDto = new ObjectivesDto();
                ObjectiveDto baron = new ObjectiveDto();
                ObjectiveDto champion = new ObjectiveDto();
                ObjectiveDto dragon = new ObjectiveDto();
                ObjectiveDto inhibitor = new ObjectiveDto();
                ObjectiveDto riftHerald = new ObjectiveDto();
                ObjectiveDto tower = new ObjectiveDto();

                baron.setFirst(objectivesEntity.isBaron_first());
                baron.setKills(objectivesEntity.getBaron_kills());
                champion.setFirst(objectivesEntity.isChampion_first());
                champion.setKills(objectivesEntity.getChampion_kills());
                dragon.setFirst(objectivesEntity.isDragon_first());
                dragon.setKills(objectivesEntity.getDragon_kills());
                inhibitor.setFirst(objectivesEntity.isInhibitor_first());
                inhibitor.setKills(objectivesEntity.getInhibitor_kills());
                riftHerald.setFirst(objectivesEntity.isRiftherald_first());
                riftHerald.setKills(objectivesEntity.getRiftherald_kills());
                tower.setFirst(objectivesEntity.isTower_first());
                tower.setKills(objectivesEntity.getTower_kills());

                objectivesDto.setBaron(baron);
                objectivesDto.setChampion(champion);
                objectivesDto.setDragon(dragon);
                objectivesDto.setInhibitor(inhibitor);
                objectivesDto.setRiftHeraId(riftHerald);
                objectivesDto.setTower(tower);

                teamDto.setObjectives(objectivesDto);

                teamDtoList.add(teamDto);
            }

            infoDto.setTeams(teamDtoList);

            //5. Match Participants 정보 생성
            List<MatchParticipantEntity> participantsList = matchParticipantController.getMatchParticipantList_ByDataVersionAndMatchId(dataVersion, matchId);
            List<String> participantsPuuidList = new ArrayList<>();
            List<ParticipantDto> blueParticipantDtoList = new ArrayList<>();
            List<ParticipantDto> redParticipantDtoList = new ArrayList<>();
            ParticipantDto summonerInfo = new ParticipantDto();

            index = 0;
            for(MatchParticipantEntity participantEntity : participantsList) {
                participantsPuuidList.add(participantEntity.getMatchParticipantId().getPuuid());

                if(puuid.equals(participantsPuuidList.get(index))) {
                    summonerInfo.setAssists(String.valueOf(participantEntity.getAssists()));
                    summonerInfo.setBaronKills(String.valueOf(participantEntity.getBaronKills()));
                    summonerInfo.setBountyLevel(String.valueOf(participantEntity.getBountyLevel()));
                    summonerInfo.setChampExperience(String.valueOf(participantEntity.getChampExperience()));
                    summonerInfo.setChampLevel(String.valueOf(participantEntity.getChampLevel()));
                    summonerInfo.setChampionId(String.valueOf(participantEntity.getChampionName()));
                    summonerInfo.setChampionNameENG(participantEntity.getChampionName());
                    summonerInfo.setChampionTransform(String.valueOf(participantEntity.getChampionTransform()));
                    summonerInfo.setConsumablesPurchased(String.valueOf(participantEntity.getConsumablesPurchased()));
                    summonerInfo.setDamageDealtToBuildings(String.valueOf(participantEntity.getDamageDealtToBuildings()));
                    summonerInfo.setDamageDealtToObjectives(String.valueOf(participantEntity.getDamageDealtToObjectives()));
                    summonerInfo.setDamageDealtToTurrets(String.valueOf(participantEntity.getDamageDealtToTurrets()));
                    summonerInfo.setDamageSelfMitigated(String.valueOf(participantEntity.getDamageSelfMitigated()));
                    summonerInfo.setDeaths(String.valueOf(participantEntity.getDeaths()));
                    summonerInfo.setDetectorWardsPlaced(String.valueOf(participantEntity.getDetectorWardsPlaced()));
                    summonerInfo.setDoubleKills(String.valueOf(participantEntity.getDoubleKills()));
                    summonerInfo.setDragonKills(String.valueOf(participantEntity.getDragonKills()));
                    summonerInfo.setFirstBloodAssist(String.valueOf(participantEntity.isFirstBloodAssist()));
                    summonerInfo.setFirstBloodKill(String.valueOf(participantEntity.isFirstBloodKill()));
                    summonerInfo.setFirstTowerAssist(String.valueOf(participantEntity.isFirstTowerAssist()));
                    summonerInfo.setFirstTowerKill(String.valueOf(participantEntity.isFirstTowerKill()));
                    summonerInfo.setGameEndedInEarlySurrender(String.valueOf(participantEntity.isGameEndedInEarlySurrender()));
                    summonerInfo.setGameEndedInSurrender(String.valueOf(participantEntity.isGameEndedInSurrender()));
                    summonerInfo.setGoldEarned(String.valueOf(participantEntity.getGoldEarned()));
                    summonerInfo.setGoldSpent(String.valueOf(participantEntity.getGoldSpent()));
                    summonerInfo.setIndividualPosition(participantEntity.getIndividualPosition());
                    summonerInfo.setInhibitorKills(String.valueOf(participantEntity.getInhibitorKills()));
                    summonerInfo.setInhibitorTakedowns(String.valueOf(participantEntity.getInhibitorTakedowns()));
                    summonerInfo.setInhibitorsLost(String.valueOf(participantEntity.getInhibitorsLost()));
                    summonerInfo.setItem0(String.valueOf(participantEntity.getItem0()));
                    summonerInfo.setItem1(String.valueOf(participantEntity.getItem1()));
                    summonerInfo.setItem2(String.valueOf(participantEntity.getItem2()));
                    summonerInfo.setItem3(String.valueOf(participantEntity.getItem3()));
                    summonerInfo.setItem4(String.valueOf(participantEntity.getItem4()));
                    summonerInfo.setItem5(String.valueOf(participantEntity.getItem5()));
                    summonerInfo.setItem6(String.valueOf(participantEntity.getItem6()));
                    summonerInfo.setItemsPurchased(String.valueOf(participantEntity.getItemsPurchased()));
                    summonerInfo.setKillingSprees(String.valueOf(participantEntity.getKillingSprees()));
                    summonerInfo.setKills(String.valueOf(participantEntity.getKills()));
                    summonerInfo.setLane(participantEntity.getLane());
                    summonerInfo.setLargestCriticalStrike(String.valueOf(participantEntity.getLargestCriticalStrike()));
                    summonerInfo.setLargestKillingSpree(String.valueOf(participantEntity.getLargestKillingSpree()));
                    summonerInfo.setLargestMultiKill(String.valueOf(participantEntity.getLargestMultiKill()));
                    summonerInfo.setLongestTimeSpentLiving(String.valueOf(participantEntity.getLongestTimeSpentLiving()));
                    summonerInfo.setMagicDamageDealt(String.valueOf(participantEntity.getMagicDamageDealt()));
                    summonerInfo.setMagicDamageDealtToChampions(String.valueOf(participantEntity.getMagicDamageDealtToChampions()));
                    summonerInfo.setMagicDamageTaken(String.valueOf(participantEntity.getMagicDamageTaken()));
                    summonerInfo.setNeutralMinionsKilled(String.valueOf(participantEntity.getNeutralMinionsKilled()));
                    summonerInfo.setNexusKills(String.valueOf(participantEntity.getNexusKills()));
                    summonerInfo.setNexusLost(String.valueOf(participantEntity.getNexusLost()));
                    summonerInfo.setNexusTakedowns(String.valueOf(participantEntity.getNexusTakedowns()));
                    summonerInfo.setObjectivesStolen(String.valueOf(participantEntity.getObjectivesStolen()));
                    summonerInfo.setObjectivesStolenAssists(String.valueOf(participantEntity.getObjectivesStolenAssists()));
                    summonerInfo.setParticipantId(String.valueOf(participantEntity.getParticipantId()));
                    summonerInfo.setPentaKills(String.valueOf(participantEntity.getPentaKills()));
                    summonerInfo.setPhysicalDamageDealt(String.valueOf(participantEntity.getPhysicalDamageDealt()));
                    summonerInfo.setPhysicalDamageDealtToChampions(String.valueOf(participantEntity.getPhysicalDamageDealtToChampions()));
                    summonerInfo.setPhysicalDamageTaken(String.valueOf(participantEntity.getPhysicalDamageTaken()));
                    summonerInfo.setPuuid(participantsPuuidList.get(index));
                    summonerInfo.setProfileIcon(String.valueOf(participantEntity.getProfileIcon()));
                    summonerInfo.setQuadraKills(String.valueOf(participantEntity.getQuadraKills()));
                    summonerInfo.setRiotIdName(participantEntity.getRiotIdName());
                    summonerInfo.setRiotIdTagline(participantEntity.getRiotIdTagline());
                    summonerInfo.setRole(participantEntity.getRole());
                    summonerInfo.setSightWardsBoughtInGame(String.valueOf(participantEntity.getSightWardsBoughtInGame()));
                    summonerInfo.setSpell1Casts(String.valueOf(participantEntity.getSpell1Casts()));
                    summonerInfo.setSpell2Casts(String.valueOf(participantEntity.getSpell2Casts()));
                    summonerInfo.setSpell3Casts(String.valueOf(participantEntity.getSpell3Casts()));
                    summonerInfo.setSpell4Casts(String.valueOf(participantEntity.getSpell4Casts()));
                    summonerInfo.setSummoner1Casts(String.valueOf(participantEntity.getSummoner1Casts()));
                    summonerInfo.setSummoner1Id(String.valueOf(participantEntity.getSummoner1Id()));
                    summonerInfo.setSummoner2Casts(String.valueOf(participantEntity.getSummoner2Casts()));
                    summonerInfo.setSummoner2Id(String.valueOf(participantEntity.getSummoner2Id()));
                    summonerInfo.setSummonerId(participantEntity.getSummonerId());
                    summonerInfo.setSummonerLevel(String.valueOf(participantEntity.getSummonerLevel()));
                    summonerInfo.setSummonerName(participantEntity.getSummonerName());
                    summonerInfo.setTeamEarlySurrendered(String.valueOf(participantEntity.isTeamEarlySurrendered()));
                    summonerInfo.setTeamId(String.valueOf(participantEntity.getTeamId()));
                    summonerInfo.setTeamPosition(participantEntity.getTeamPosition());
                    summonerInfo.setTimeCCingOthers(String.valueOf(participantEntity.getTimeCCingOthers()));
                    summonerInfo.setTimePlayed(String.valueOf(participantEntity.getTimePlayed()));
                    summonerInfo.setTotalDamageDealt(String.valueOf(participantEntity.getTotalDamageDealt()));
                    summonerInfo.setTotalDamageDealtToChampions( String.valueOf(participantEntity.getTotalDamageDealtToChampions()));
                    summonerInfo.setTotalDamageShieldedOnTeammates(String.valueOf(participantEntity.getTotalDamageShieldedOnTeammates()));
                    summonerInfo.setTotalDamageTaken(String.valueOf(participantEntity.getTotalDamageTaken()));
                    summonerInfo.setTotalHeal(String.valueOf(participantEntity.getTotalHeal()));
                    summonerInfo.setTotalHealsOnTeammates(String.valueOf(participantEntity.getTotalHealsOnTeammates()));
                    summonerInfo.setTotalMinionsKilled(String.valueOf(participantEntity.getTotalMinionsKilled()));
                    summonerInfo.setTotalTimeCCDealt(String.valueOf(participantEntity.getTotalTimeCCDealt()));
                    summonerInfo.setTotalTimeSpentDead(String.valueOf(participantEntity.getTotalTimeSpentDead()));
                    summonerInfo.setTotalUnitsHealed(String.valueOf(participantEntity.getTotalUnitsHealed()));
                    summonerInfo.setTripleKills(String.valueOf(participantEntity.getTripleKills()));
                    summonerInfo.setTrueDamageDealt(String.valueOf(participantEntity.getTrueDamageDealt()));
                    summonerInfo.setTrueDamageDealtToChampions(String.valueOf(participantEntity.getTrueDamageDealtToChampions()));
                    summonerInfo.setTrueDamageTaken(String.valueOf(participantEntity.getTrueDamageTaken()));
                    summonerInfo.setTurretKills(String.valueOf(participantEntity.getTurretKills()));
                    summonerInfo.setTurretTakedowns(String.valueOf(participantEntity.getTurretTakedowns()));
                    summonerInfo.setTurretsLost(String.valueOf(participantEntity.getTurretsLost()));
                    summonerInfo.setUnrealKills(String.valueOf(participantEntity.getUnrealKills()));
                    summonerInfo.setVisionScore(String.valueOf(participantEntity.getVisionScore()));
                    summonerInfo.setVisionWardsBoughtInGame(String.valueOf(participantEntity.getVisionWardsBoughtInGame()));
                    summonerInfo.setWardsKilled(String.valueOf(participantEntity.getWardsKilled()));
                    summonerInfo.setWardsPlaced(String.valueOf(participantEntity.getWardsPlaced()));
                    summonerInfo.setWin(String.valueOf(participantEntity.isWin()));
                }

                ParticipantDto participantDto = new ParticipantDto();

                participantDto.setAssists(String.valueOf(participantEntity.getAssists()));
                participantDto.setBaronKills(String.valueOf(participantEntity.getBaronKills()));
                participantDto.setBountyLevel(String.valueOf(participantEntity.getBountyLevel()));
                participantDto.setChampExperience(String.valueOf(participantEntity.getChampExperience()));
                participantDto.setChampLevel(String.valueOf(participantEntity.getChampLevel()));
                participantDto.setChampionId(String.valueOf(participantEntity.getChampionName()));
                participantDto.setChampionNameENG(participantEntity.getChampionName());
                participantDto.setChampionTransform(String.valueOf(participantEntity.getChampionTransform()));
                participantDto.setConsumablesPurchased(String.valueOf(participantEntity.getConsumablesPurchased()));
                participantDto.setDamageDealtToBuildings(String.valueOf(participantEntity.getDamageDealtToBuildings()));
                participantDto.setDamageDealtToObjectives(String.valueOf(participantEntity.getDamageDealtToObjectives()));
                participantDto.setDamageDealtToTurrets(String.valueOf(participantEntity.getDamageDealtToTurrets()));
                participantDto.setDamageSelfMitigated(String.valueOf(participantEntity.getDamageSelfMitigated()));
                participantDto.setDeaths(String.valueOf(participantEntity.getDeaths()));
                participantDto.setDetectorWardsPlaced(String.valueOf(participantEntity.getDetectorWardsPlaced()));
                participantDto.setDoubleKills(String.valueOf(participantEntity.getDoubleKills()));
                participantDto.setDragonKills(String.valueOf(participantEntity.getDragonKills()));
                participantDto.setFirstBloodAssist(String.valueOf(participantEntity.isFirstBloodAssist()));
                participantDto.setFirstBloodKill(String.valueOf(participantEntity.isFirstBloodKill()));
                participantDto.setFirstTowerAssist(String.valueOf(participantEntity.isFirstTowerAssist()));
                participantDto.setFirstTowerKill(String.valueOf(participantEntity.isFirstTowerKill()));
                participantDto.setGameEndedInEarlySurrender(String.valueOf(participantEntity.isGameEndedInEarlySurrender()));
                participantDto.setGameEndedInSurrender(String.valueOf(participantEntity.isGameEndedInSurrender()));
                participantDto.setGoldEarned(String.valueOf(participantEntity.getGoldEarned()));
                participantDto.setGoldSpent(String.valueOf(participantEntity.getGoldSpent()));
                participantDto.setIndividualPosition(participantEntity.getIndividualPosition());
                participantDto.setInhibitorKills(String.valueOf(participantEntity.getInhibitorKills()));
                participantDto.setInhibitorTakedowns(String.valueOf(participantEntity.getInhibitorTakedowns()));
                participantDto.setInhibitorsLost(String.valueOf(participantEntity.getInhibitorsLost()));
                participantDto.setItem0(String.valueOf(participantEntity.getItem0()));
                participantDto.setItem1(String.valueOf(participantEntity.getItem1()));
                participantDto.setItem2(String.valueOf(participantEntity.getItem2()));
                participantDto.setItem3(String.valueOf(participantEntity.getItem3()));
                participantDto.setItem4(String.valueOf(participantEntity.getItem4()));
                participantDto.setItem5(String.valueOf(participantEntity.getItem5()));
                participantDto.setItem6(String.valueOf(participantEntity.getItem6()));
                participantDto.setItemsPurchased(String.valueOf(participantEntity.getItemsPurchased()));
                participantDto.setKillingSprees(String.valueOf(participantEntity.getKillingSprees()));
                participantDto.setKills(String.valueOf(participantEntity.getKills()));
                participantDto.setLane(participantEntity.getLane());
                participantDto.setLargestCriticalStrike(String.valueOf(participantEntity.getLargestCriticalStrike()));
                participantDto.setLargestKillingSpree(String.valueOf(participantEntity.getLargestKillingSpree()));
                participantDto.setLargestMultiKill(String.valueOf(participantEntity.getLargestMultiKill()));
                participantDto.setLongestTimeSpentLiving(String.valueOf(participantEntity.getLongestTimeSpentLiving()));
                participantDto.setMagicDamageDealt(String.valueOf(participantEntity.getMagicDamageDealt()));
                participantDto.setMagicDamageDealtToChampions(String.valueOf(participantEntity.getMagicDamageDealtToChampions()));
                participantDto.setMagicDamageTaken(String.valueOf(participantEntity.getMagicDamageTaken()));
                participantDto.setNeutralMinionsKilled(String.valueOf(participantEntity.getNeutralMinionsKilled()));
                participantDto.setNexusKills(String.valueOf(participantEntity.getNexusKills()));
                participantDto.setNexusLost(String.valueOf(participantEntity.getNexusLost()));
                participantDto.setNexusTakedowns(String.valueOf(participantEntity.getNexusTakedowns()));
                participantDto.setObjectivesStolen(String.valueOf(participantEntity.getObjectivesStolen()));
                participantDto.setObjectivesStolenAssists(String.valueOf(participantEntity.getObjectivesStolenAssists()));
                participantDto.setParticipantId(String.valueOf(participantEntity.getParticipantId()));
                participantDto.setPentaKills(String.valueOf(participantEntity.getPentaKills()));
                participantDto.setPhysicalDamageDealt(String.valueOf(participantEntity.getPhysicalDamageDealt()));
                participantDto.setPhysicalDamageDealtToChampions(String.valueOf(participantEntity.getPhysicalDamageDealtToChampions()));
                participantDto.setPhysicalDamageTaken(String.valueOf(participantEntity.getPhysicalDamageTaken()));
                participantDto.setPuuid(participantsPuuidList.get(index));
                participantDto.setProfileIcon(String.valueOf(participantEntity.getProfileIcon()));
                participantDto.setQuadraKills(String.valueOf(participantEntity.getQuadraKills()));
                participantDto.setRiotIdName(participantEntity.getRiotIdName());
                participantDto.setRiotIdTagline(participantEntity.getRiotIdTagline());
                participantDto.setRole(participantEntity.getRole());
                participantDto.setSightWardsBoughtInGame(String.valueOf(participantEntity.getSightWardsBoughtInGame()));
                participantDto.setSpell1Casts(String.valueOf(participantEntity.getSpell1Casts()));
                participantDto.setSpell2Casts(String.valueOf(participantEntity.getSpell2Casts()));
                participantDto.setSpell3Casts(String.valueOf(participantEntity.getSpell3Casts()));
                participantDto.setSpell4Casts(String.valueOf(participantEntity.getSpell4Casts()));
                participantDto.setSummoner1Casts(String.valueOf(participantEntity.getSummoner1Casts()));
                participantDto.setSummoner1Id(String.valueOf(participantEntity.getSummoner1Id()));
                participantDto.setSummoner2Casts(String.valueOf(participantEntity.getSummoner2Casts()));
                participantDto.setSummoner2Id(String.valueOf(participantEntity.getSummoner2Id()));
                participantDto.setSummonerId(participantEntity.getSummonerId());
                participantDto.setSummonerLevel(String.valueOf(participantEntity.getSummonerLevel()));
                participantDto.setSummonerName(participantEntity.getSummonerName());
                participantDto.setTeamEarlySurrendered(String.valueOf(participantEntity.isTeamEarlySurrendered()));
                participantDto.setTeamId(String.valueOf(participantEntity.getTeamId()));
                participantDto.setTeamPosition(participantEntity.getTeamPosition());
                participantDto.setTimeCCingOthers(String.valueOf(participantEntity.getTimeCCingOthers()));
                participantDto.setTimePlayed(String.valueOf(participantEntity.getTimePlayed()));
                participantDto.setTotalDamageDealt(String.valueOf(participantEntity.getTotalDamageDealt()));
                participantDto.setTotalDamageDealtToChampions( String.valueOf(participantEntity.getTotalDamageDealtToChampions()));
                participantDto.setTotalDamageShieldedOnTeammates(String.valueOf(participantEntity.getTotalDamageShieldedOnTeammates()));
                participantDto.setTotalDamageTaken(String.valueOf(participantEntity.getTotalDamageTaken()));
                participantDto.setTotalHeal(String.valueOf(participantEntity.getTotalHeal()));
                participantDto.setTotalHealsOnTeammates(String.valueOf(participantEntity.getTotalHealsOnTeammates()));
                participantDto.setTotalMinionsKilled(String.valueOf(participantEntity.getTotalMinionsKilled()));
                participantDto.setTotalTimeCCDealt(String.valueOf(participantEntity.getTotalTimeCCDealt()));
                participantDto.setTotalTimeSpentDead(String.valueOf(participantEntity.getTotalTimeSpentDead()));
                participantDto.setTotalUnitsHealed(String.valueOf(participantEntity.getTotalUnitsHealed()));
                participantDto.setTripleKills(String.valueOf(participantEntity.getTripleKills()));
                participantDto.setTrueDamageDealt(String.valueOf(participantEntity.getTrueDamageDealt()));
                participantDto.setTrueDamageDealtToChampions(String.valueOf(participantEntity.getTrueDamageDealtToChampions()));
                participantDto.setTrueDamageTaken(String.valueOf(participantEntity.getTrueDamageTaken()));
                participantDto.setTurretKills(String.valueOf(participantEntity.getTurretKills()));
                participantDto.setTurretTakedowns(String.valueOf(participantEntity.getTurretTakedowns()));
                participantDto.setTurretsLost(String.valueOf(participantEntity.getTurretsLost()));
                participantDto.setUnrealKills(String.valueOf(participantEntity.getUnrealKills()));
                participantDto.setVisionScore(String.valueOf(participantEntity.getVisionScore()));
                participantDto.setVisionWardsBoughtInGame(String.valueOf(participantEntity.getVisionWardsBoughtInGame()));
                participantDto.setWardsKilled(String.valueOf(participantEntity.getWardsKilled()));
                participantDto.setWardsPlaced(String.valueOf(participantEntity.getWardsPlaced()));
                participantDto.setWin(String.valueOf(participantEntity.isWin()));

                if("100".equals(participantDto.getTeamId())) {
                    blueParticipantDtoList.add(participantDto);
                } else if("200".equals(participantDto.getTeamId())) {
                    redParticipantDtoList.add(participantDto);
                }

                index++;
            }

            metadataDto.setParticipants(participantsPuuidList);

            sortParticipationDtoList(blueParticipantDtoList, redParticipantDtoList);

            infoDto.setBlueParticipants(blueParticipantDtoList);
            infoDto.setRedParticipants(redParticipantDtoList);

            summonerInfo.setChampionNameKR(JSONParserForLOL.getKRChampionNameByENGChampionName(summonerInfo.getChampionNameENG()));
            infoDto.setSummoner(summonerInfo);

            matchInfo.setMetadata(metadataDto);
            matchInfo.setInfo(infoDto);

            result.add(matchInfo);
        }

        return result;
    }

    private void sortParticipationDtoList(List<ParticipantDto> blueParticipantDtoList, List<ParticipantDto> redParticipantDtoList) {
        blueParticipantDtoList.sort((o1, o2) -> {
            int score1 = getScore(o1);
            int score2 = getScore(o2);

            return score2 - score1;
        });

        redParticipantDtoList.sort((o1, o2) -> {
            int score1 = getScore(o1);
            int score2 = getScore(o2);

            return score2 - score1;
        });
    }

    private int getScore(ParticipantDto participant) {
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

    public ArrayList<String> getMatchList(String name, long startTime) {
        apiKey = apiKeyController.getAPIKey_ByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();
        ArrayList<String> matchList = new ArrayList<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("MATCH", "GET_MATCHES_BY_PUUID")
                    + summonerController.getSummoner_Puuid_ByName(name)
                    + "/ids?startTime=" + startTime + "&count=20&api_key="
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

    public HashSet<String> getMatchListFromDB(String puuid) {
        List<MatchParticipantEntity> list = matchParticipantController.getMatchParticipantList_ByPuuid(puuid);
        HashSet<String> matchList = new HashSet<>();

        for(MatchParticipantEntity entity : list) {
            matchList.add(entity.getMatchParticipantId().getMatchId());
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

    public SummonerDto getSummonerInfoFromDB(String name) {
        SummonerDto summonerDto = new SummonerDto();

        String puuid = summonerController.getSummoner_Puuid_ByName(name);
        if(null == puuid) return null;

        SummonerEntity summoner = summonerController.getSummoner(puuid).get(0);
        String refreshAgoTime = null;

        if (ChronoUnit.HOURS.between(summoner.getRrt().toLocalDateTime(), LocalDateTime.now()) >= 24)
        {
            refreshAgoTime = String.valueOf(ChronoUnit.DAYS.between(summoner.getRrt().toLocalDateTime(), LocalDateTime.now()))
                    + "일 전";
        }
        else if (ChronoUnit.MINUTES.between(summoner.getRrt().toLocalDateTime(), LocalDateTime.now()) >= 60)
        {
            refreshAgoTime = String.valueOf(ChronoUnit.HOURS.between(summoner.getRrt().toLocalDateTime(), LocalDateTime.now()))
                    + "시간 전";
        }
        else
        {
            refreshAgoTime = String.valueOf(ChronoUnit.MINUTES.between(summoner.getRrt().toLocalDateTime(), LocalDateTime.now()))
                    + "분 전";
        }

        summonerDto.setPuuid(summoner.getPuuid());
        summonerDto.setAccountId(summoner.getAccountid());
        summonerDto.setId(summoner.getId());
        summonerDto.setName(summoner.getName());
        summonerDto.setProfileIconId(String.valueOf(summoner.getProfileiconid()));
        summonerDto.setRevisionDate(String.valueOf(summoner.getRevisiondate()));
        summonerDto.setSummonerLevel(String.valueOf(summoner.getSummonerlevel()));
        summonerDto.setRefreshAgoTime(refreshAgoTime);
        summonerDto.setLastRefreshTime(summoner.getRrt().toInstant().getEpochSecond());

        return summonerDto;
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

    public HashSet<Object> getLeagueInfoFromDB(String summonerId) {
        HashSet<Object> result = new HashSet<>();

        List<LeagueEntryEntity> leagueEntryEntityList = leagueEntryController.getLeagueEntries_BySummonerId(summonerId);
        HashMap<String, Object> leagueEntryInfo;

        for(LeagueEntryEntity entryEntity : leagueEntryEntityList) {
            leagueEntryInfo = new HashMap<>();

            leagueEntryInfo.put("leagueId", entryEntity.getLeagueId());
            leagueEntryInfo.put("queueType", entryEntity.getLeagueEntryId().getQueueType());
            leagueEntryInfo.put("tier", entryEntity.getTier());
            leagueEntryInfo.put("rank", entryEntity.getRanks());
            leagueEntryInfo.put("summonerId", entryEntity.getLeagueEntryId().getSummonerId());
            leagueEntryInfo.put("summonerName", entryEntity.getSummonerName());
            leagueEntryInfo.put("leaguePoints", entryEntity.getLeaguePoints());
            leagueEntryInfo.put("wins", entryEntity.getWins());
            leagueEntryInfo.put("losses", entryEntity.getLosses());
            leagueEntryInfo.put("veteran", entryEntity.isVeteran());
            leagueEntryInfo.put("inactive", entryEntity.isInactive());
            leagueEntryInfo.put("freshBlood", entryEntity.isFreshBlood());
            leagueEntryInfo.put("hotStreak", entryEntity.isHotStreak());

            result.add(leagueEntryInfo);
        }

        return result;
    }

}
