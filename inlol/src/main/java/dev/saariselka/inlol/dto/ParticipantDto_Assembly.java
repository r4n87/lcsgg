package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.MatchParticipantController;
import dev.saariselka.inlol.entity.MatchParticipantEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ParticipantDto_Assembly {
    @Autowired
    MatchParticipantController matchParticipantController;

    public List<ParticipantDto> getMatchParticipantList_ByMatchParticipantId(String dataVersion, String matchId) {
        List<MatchParticipantEntity> participants
                = matchParticipantController.getMatchParticipantList_ByDataVersionAndMatchId(dataVersion, matchId);
        List<ParticipantDto> participantDtos = new ArrayList<>();
        ParticipantDto participantDto = null;

        for(MatchParticipantEntity participantEntity : participants) {
            participantDto = new ParticipantDto();
            makeParticipantDto(participantDto, participantEntity);
            participantDtos.add(participantDto);
        }

        return participantDtos;
    }

    public ParticipantDto getMatchParticipant_ByMatchParticipantId(String puuid, String dataVersion, String matchId) {
        List<MatchParticipantEntity> participants
                = matchParticipantController.getMatchParticipant_ByMatchParticipantId(puuid, dataVersion, matchId);
        MatchParticipantEntity participantEntity = participants.get(0);

        ParticipantDto participantDto = new ParticipantDto();
        makeParticipantDto(participantDto, participantEntity);

        return participantDto;
    }

    private void makeParticipantDto(ParticipantDto participantDto, MatchParticipantEntity participantEntity) {
        participantDto.setPuuid(participantEntity.getMatchParticipantId().getPuuid());
        participantDto.setDataVersion(participantEntity.getMatchParticipantId().getDataVersion());
        participantDto.setMatchId(participantEntity.getMatchParticipantId().getMatchId());

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
        participantDto.setRrt(participantEntity.getRrt());
    }
    
    public ParticipantDto getParticipantDto_byEntity(MatchParticipantEntity matchParticipantEntity) {
        ParticipantDto participantDto = new ParticipantDto();

        participantDto.setPuuid(matchParticipantEntity.getMatchParticipantId().getPuuid());
        participantDto.setDataVersion(matchParticipantEntity.getMatchParticipantId().getDataVersion());
        participantDto.setMatchId(matchParticipantEntity.getMatchParticipantId().getMatchId());
        participantDto.setAssists(String.valueOf(matchParticipantEntity.getAssists()));
        participantDto.setBaronKills(String.valueOf(matchParticipantEntity.getBaronKills()));
        participantDto.setBountyLevel(String.valueOf(matchParticipantEntity.getBountyLevel()));
        participantDto.setChampExperience(String.valueOf(matchParticipantEntity.getChampExperience()));
        participantDto.setChampLevel(String.valueOf(matchParticipantEntity.getChampLevel()));
        participantDto.setChampionId(String.valueOf(matchParticipantEntity.getChampionName()));
        participantDto.setChampionNameENG(matchParticipantEntity.getChampionName());
        participantDto.setChampionTransform(String.valueOf(matchParticipantEntity.getChampionTransform()));
        participantDto.setConsumablesPurchased(String.valueOf(matchParticipantEntity.getConsumablesPurchased()));
        participantDto.setDamageDealtToBuildings(String.valueOf(matchParticipantEntity.getDamageDealtToBuildings()));
        participantDto.setDamageDealtToObjectives(String.valueOf(matchParticipantEntity.getDamageDealtToObjectives()));
        participantDto.setDamageDealtToTurrets(String.valueOf(matchParticipantEntity.getDamageDealtToTurrets()));
        participantDto.setDamageSelfMitigated(String.valueOf(matchParticipantEntity.getDamageSelfMitigated()));
        participantDto.setDeaths(String.valueOf(matchParticipantEntity.getDeaths()));
        participantDto.setDetectorWardsPlaced(String.valueOf(matchParticipantEntity.getDetectorWardsPlaced()));
        participantDto.setDoubleKills(String.valueOf(matchParticipantEntity.getDoubleKills()));
        participantDto.setDragonKills(String.valueOf(matchParticipantEntity.getDragonKills()));
        participantDto.setFirstBloodAssist(String.valueOf(matchParticipantEntity.isFirstBloodAssist()));
        participantDto.setFirstBloodKill(String.valueOf(matchParticipantEntity.isFirstBloodKill()));
        participantDto.setFirstTowerAssist(String.valueOf(matchParticipantEntity.isFirstTowerAssist()));
        participantDto.setFirstTowerKill(String.valueOf(matchParticipantEntity.isFirstTowerKill()));
        participantDto.setGameEndedInEarlySurrender(String.valueOf(matchParticipantEntity.isGameEndedInEarlySurrender()));
        participantDto.setGameEndedInSurrender(String.valueOf(matchParticipantEntity.isGameEndedInSurrender()));
        participantDto.setGoldEarned(String.valueOf(matchParticipantEntity.getGoldEarned()));
        participantDto.setGoldSpent(String.valueOf(matchParticipantEntity.getGoldSpent()));
        participantDto.setIndividualPosition(matchParticipantEntity.getIndividualPosition());
        participantDto.setInhibitorKills(String.valueOf(matchParticipantEntity.getInhibitorKills()));
        participantDto.setInhibitorTakedowns(String.valueOf(matchParticipantEntity.getInhibitorTakedowns()));
        participantDto.setInhibitorsLost(String.valueOf(matchParticipantEntity.getInhibitorsLost()));
        participantDto.setItem0(String.valueOf(matchParticipantEntity.getItem0()));
        participantDto.setItem1(String.valueOf(matchParticipantEntity.getItem1()));
        participantDto.setItem2(String.valueOf(matchParticipantEntity.getItem2()));
        participantDto.setItem3(String.valueOf(matchParticipantEntity.getItem3()));
        participantDto.setItem4(String.valueOf(matchParticipantEntity.getItem4()));
        participantDto.setItem5(String.valueOf(matchParticipantEntity.getItem5()));
        participantDto.setItem6(String.valueOf(matchParticipantEntity.getItem6()));
        participantDto.setItemsPurchased(String.valueOf(matchParticipantEntity.getItemsPurchased()));
        participantDto.setKillingSprees(String.valueOf(matchParticipantEntity.getKillingSprees()));
        participantDto.setKills(String.valueOf(matchParticipantEntity.getKills()));
        participantDto.setLane(matchParticipantEntity.getLane());
        participantDto.setLargestCriticalStrike(String.valueOf(matchParticipantEntity.getLargestCriticalStrike()));
        participantDto.setLargestKillingSpree(String.valueOf(matchParticipantEntity.getLargestKillingSpree()));
        participantDto.setLargestMultiKill(String.valueOf(matchParticipantEntity.getLargestMultiKill()));
        participantDto.setLongestTimeSpentLiving(String.valueOf(matchParticipantEntity.getLongestTimeSpentLiving()));
        participantDto.setMagicDamageDealt(String.valueOf(matchParticipantEntity.getMagicDamageDealt()));
        participantDto.setMagicDamageDealtToChampions(String.valueOf(matchParticipantEntity.getMagicDamageDealtToChampions()));
        participantDto.setMagicDamageTaken(String.valueOf(matchParticipantEntity.getMagicDamageTaken()));
        participantDto.setNeutralMinionsKilled(String.valueOf(matchParticipantEntity.getNeutralMinionsKilled()));
        participantDto.setNexusKills(String.valueOf(matchParticipantEntity.getNexusKills()));
        participantDto.setNexusLost(String.valueOf(matchParticipantEntity.getNexusLost()));
        participantDto.setNexusTakedowns(String.valueOf(matchParticipantEntity.getNexusTakedowns()));
        participantDto.setObjectivesStolen(String.valueOf(matchParticipantEntity.getObjectivesStolen()));
        participantDto.setObjectivesStolenAssists(String.valueOf(matchParticipantEntity.getObjectivesStolenAssists()));
        participantDto.setParticipantId(String.valueOf(matchParticipantEntity.getParticipantId()));
        participantDto.setPentaKills(String.valueOf(matchParticipantEntity.getPentaKills()));
        participantDto.setPhysicalDamageDealt(String.valueOf(matchParticipantEntity.getPhysicalDamageDealt()));
        participantDto.setPhysicalDamageDealtToChampions(String.valueOf(matchParticipantEntity.getPhysicalDamageDealtToChampions()));
        participantDto.setPhysicalDamageTaken(String.valueOf(matchParticipantEntity.getPhysicalDamageTaken()));
        participantDto.setProfileIcon(String.valueOf(matchParticipantEntity.getProfileIcon()));
        participantDto.setQuadraKills(String.valueOf(matchParticipantEntity.getQuadraKills()));
        participantDto.setRiotIdName(matchParticipantEntity.getRiotIdName());
        participantDto.setRiotIdTagline(matchParticipantEntity.getRiotIdTagline());
        participantDto.setRole(matchParticipantEntity.getRole());
        participantDto.setSightWardsBoughtInGame(String.valueOf(matchParticipantEntity.getSightWardsBoughtInGame()));
        participantDto.setSpell1Casts(String.valueOf(matchParticipantEntity.getSpell1Casts()));
        participantDto.setSpell2Casts(String.valueOf(matchParticipantEntity.getSpell2Casts()));
        participantDto.setSpell3Casts(String.valueOf(matchParticipantEntity.getSpell3Casts()));
        participantDto.setSpell4Casts(String.valueOf(matchParticipantEntity.getSpell4Casts()));
        participantDto.setSummoner1Casts(String.valueOf(matchParticipantEntity.getSummoner1Casts()));
        participantDto.setSummoner1Id(String.valueOf(matchParticipantEntity.getSummoner1Id()));
        participantDto.setSummoner2Casts(String.valueOf(matchParticipantEntity.getSummoner2Casts()));
        participantDto.setSummoner2Id(String.valueOf(matchParticipantEntity.getSummoner2Id()));
        participantDto.setSummonerId(matchParticipantEntity.getSummonerId());
        participantDto.setSummonerLevel(String.valueOf(matchParticipantEntity.getSummonerLevel()));
        participantDto.setSummonerName(matchParticipantEntity.getSummonerName());
        participantDto.setTeamEarlySurrendered(String.valueOf(matchParticipantEntity.isTeamEarlySurrendered()));
        participantDto.setTeamId(String.valueOf(matchParticipantEntity.getTeamId()));
        participantDto.setTeamPosition(matchParticipantEntity.getTeamPosition());
        participantDto.setTimeCCingOthers(String.valueOf(matchParticipantEntity.getTimeCCingOthers()));
        participantDto.setTimePlayed(String.valueOf(matchParticipantEntity.getTimePlayed()));
        participantDto.setTotalDamageDealt(String.valueOf(matchParticipantEntity.getTotalDamageDealt()));
        participantDto.setTotalDamageDealtToChampions( String.valueOf(matchParticipantEntity.getTotalDamageDealtToChampions()));
        participantDto.setTotalDamageShieldedOnTeammates(String.valueOf(matchParticipantEntity.getTotalDamageShieldedOnTeammates()));
        participantDto.setTotalDamageTaken(String.valueOf(matchParticipantEntity.getTotalDamageTaken()));
        participantDto.setTotalHeal(String.valueOf(matchParticipantEntity.getTotalHeal()));
        participantDto.setTotalHealsOnTeammates(String.valueOf(matchParticipantEntity.getTotalHealsOnTeammates()));
        participantDto.setTotalMinionsKilled(String.valueOf(matchParticipantEntity.getTotalMinionsKilled()));
        participantDto.setTotalTimeCCDealt(String.valueOf(matchParticipantEntity.getTotalTimeCCDealt()));
        participantDto.setTotalTimeSpentDead(String.valueOf(matchParticipantEntity.getTotalTimeSpentDead()));
        participantDto.setTotalUnitsHealed(String.valueOf(matchParticipantEntity.getTotalUnitsHealed()));
        participantDto.setTripleKills(String.valueOf(matchParticipantEntity.getTripleKills()));
        participantDto.setTrueDamageDealt(String.valueOf(matchParticipantEntity.getTrueDamageDealt()));
        participantDto.setTrueDamageDealtToChampions(String.valueOf(matchParticipantEntity.getTrueDamageDealtToChampions()));
        participantDto.setTrueDamageTaken(String.valueOf(matchParticipantEntity.getTrueDamageTaken()));
        participantDto.setTurretKills(String.valueOf(matchParticipantEntity.getTurretKills()));
        participantDto.setTurretTakedowns(String.valueOf(matchParticipantEntity.getTurretTakedowns()));
        participantDto.setTurretsLost(String.valueOf(matchParticipantEntity.getTurretsLost()));
        participantDto.setUnrealKills(String.valueOf(matchParticipantEntity.getUnrealKills()));
        participantDto.setVisionScore(String.valueOf(matchParticipantEntity.getVisionScore()));
        participantDto.setVisionWardsBoughtInGame(String.valueOf(matchParticipantEntity.getVisionWardsBoughtInGame()));
        participantDto.setWardsKilled(String.valueOf(matchParticipantEntity.getWardsKilled()));
        participantDto.setWardsPlaced(String.valueOf(matchParticipantEntity.getWardsPlaced()));
        participantDto.setWin(String.valueOf(matchParticipantEntity.isWin()));
        participantDto.setRrt(matchParticipantEntity.getRrt());

        return  participantDto;
    }
}