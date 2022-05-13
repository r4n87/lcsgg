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
}