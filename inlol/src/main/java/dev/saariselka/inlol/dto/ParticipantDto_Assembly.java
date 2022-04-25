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

        participantDto.setAssists(participantEntity.getAssists());
        participantDto.setBaronKills(participantEntity.getBaronKills());
        participantDto.setBountyLevel(participantEntity.getBountyLevel());
        participantDto.setChampExperience(participantEntity.getChampExperience());
        participantDto.setChampLevel(participantEntity.getChampLevel());
        participantDto.setChampionId(participantEntity.getChampionId());
        participantDto.setChampionName(participantEntity.getChampionName());
        participantDto.setChampionTransform(participantEntity.getChampionTransform());
        participantDto.setConsumablesPurchased(participantEntity.getConsumablesPurchased());
        participantDto.setDamageDealtToBuildings(participantEntity.getDamageDealtToBuildings());
        participantDto.setDamageDealtToObjectives(participantEntity.getDamageDealtToObjectives());
        participantDto.setDamageDealtToTurrets(participantEntity.getDamageDealtToTurrets());
        participantDto.setDamageSelfMitigated(participantEntity.getDamageSelfMitigated());
        participantDto.setDeaths(participantEntity.getDeaths());
        participantDto.setDetectorWardsPlaced(participantEntity.getDetectorWardsPlaced());
        participantDto.setDoubleKills(participantEntity.getDoubleKills());
        participantDto.setDragonKills(participantEntity.getDragonKills());
        participantDto.setFirstBloodAssist(participantEntity.isFirstBloodAssist());
        participantDto.setFirstBloodKill(participantEntity.isFirstBloodKill());
        participantDto.setFirstTowerAssist(participantEntity.isFirstTowerAssist());
        participantDto.setFirstTowerKill(participantEntity.isFirstTowerKill());
        participantDto.setGameEndedInEarlySurrender(participantEntity.isGameEndedInEarlySurrender());
        participantDto.setGameEndedInSurrender(participantEntity.isGameEndedInSurrender());
        participantDto.setGoldEarned(participantEntity.getGoldEarned());
        participantDto.setGoldSpent(participantEntity.getGoldSpent());
        participantDto.setIndividualPosition(participantEntity.getIndividualPosition());
        participantDto.setInhibitorKills(participantEntity.getInhibitorKills());
        participantDto.setInhibitorTakedowns(participantEntity.getInhibitorTakedowns());
        participantDto.setInhibitorsLost(participantEntity.getInhibitorsLost());
        participantDto.setItem0(participantEntity.getItem0());
        participantDto.setItem1(participantEntity.getItem1());
        participantDto.setItem2(participantEntity.getItem2());
        participantDto.setItem3(participantEntity.getItem3());
        participantDto.setItem4(participantEntity.getItem4());
        participantDto.setItem5(participantEntity.getItem5());
        participantDto.setItem6(participantEntity.getItem6());
        participantDto.setItemsPurchased(participantEntity.getItemsPurchased());
        participantDto.setKillingSprees(participantEntity.getKillingSprees());
        participantDto.setKills(participantEntity.getKills());
        participantDto.setLane(participantEntity.getLane());
        participantDto.setLargestCriticalStrike(participantEntity.getLargestCriticalStrike());
        participantDto.setLargestKillingSpree(participantEntity.getLargestKillingSpree());
        participantDto.setLargestMultiKill(participantEntity.getLargestMultiKill());
        participantDto.setLongestTimeSpentLiving(participantEntity.getLongestTimeSpentLiving());
        participantDto.setMagicDamageDealt(participantEntity.getMagicDamageDealt());
        participantDto.setMagicDamageDealtToChampions(participantEntity.getMagicDamageDealtToChampions());
        participantDto.setMagicDamageTaken(participantEntity.getMagicDamageTaken());
        participantDto.setNeutralMinionsKilled(participantEntity.getNeutralMinionsKilled());
        participantDto.setNexusKills(participantEntity.getNexusKills());
        participantDto.setNexusTakedowns(participantEntity.getNexusTakedowns());
        participantDto.setNexusLost(participantEntity.getNexusLost());
        participantDto.setObjectivesStolen(participantEntity.getObjectivesStolen());
        participantDto.setObjectivesStolenAssists(participantEntity.getObjectivesStolenAssists());
        participantDto.setParticipantId(participantEntity.getParticipantId());
        participantDto.setPentaKills(participantEntity.getPentaKills());
        participantDto.setPhysicalDamageDealt(participantEntity.getPhysicalDamageDealt());
        participantDto.setPhysicalDamageDealtToChampions(participantEntity.getPhysicalDamageDealtToChampions());
        participantDto.setPhysicalDamageTaken(participantEntity.getPhysicalDamageTaken());
        participantDto.setProfileIcon(participantEntity.getProfileIcon());
        participantDto.setQuadraKills(participantEntity.getQuadraKills());
        participantDto.setRiotIdName(participantEntity.getRiotIdName());
        participantDto.setRiotIdTagline(participantEntity.getRiotIdTagline());
        participantDto.setRole(participantEntity.getRole());
        participantDto.setSightWardsBoughtInGame(participantEntity.getSightWardsBoughtInGame());
        participantDto.setSpell1Casts(participantEntity.getSpell1Casts());
        participantDto.setSpell2Casts(participantEntity.getSpell2Casts());
        participantDto.setSpell3Casts(participantEntity.getSpell3Casts());
        participantDto.setSpell4Casts(participantEntity.getSpell4Casts());
        participantDto.setSummoner1Casts(participantEntity.getSummoner1Casts());
        participantDto.setSummoner1Id(participantEntity.getSummoner1Id());
        participantDto.setSummoner2Casts(participantEntity.getSummoner2Casts());
        participantDto.setSummoner2Id(participantEntity.getSummoner2Id());
        participantDto.setSummonerId(participantEntity.getSummonerId());
        participantDto.setSummonerLevel(participantEntity.getSummonerLevel());
        participantDto.setSummonerName(participantEntity.getSummonerName());
        participantDto.setTeamEarlySurrendered(participantEntity.isTeamEarlySurrendered());
        participantDto.setTeamId(participantEntity.getTeamId());
        participantDto.setTeamPosition(participantEntity.getTeamPosition());
        participantDto.setTimeCCingOthers(participantEntity.getTimeCCingOthers());
        participantDto.setTimePlayed(participantEntity.getTimePlayed());
        participantDto.setTotalDamageDealt(participantEntity.getTotalDamageDealt());
        participantDto.setTotalDamageDealtToChampions(participantEntity.getTotalDamageDealtToChampions());
        participantDto.setTotalDamageShieldedOnTeammates(participantEntity.getTotalDamageShieldedOnTeammates());
        participantDto.setTotalDamageTaken(participantEntity.getTotalDamageTaken());
        participantDto.setTotalHeal(participantEntity.getTotalHeal());
        participantDto.setTotalHealsOnTeammates(participantEntity.getTotalHealsOnTeammates());
        participantDto.setTotalMinionsKilled(participantEntity.getTotalMinionsKilled());
        participantDto.setTotalTimeCCDealt(participantEntity.getTotalTimeCCDealt());
        participantDto.setTotalTimeSpentDead(participantEntity.getTotalTimeSpentDead());
        participantDto.setTotalUnitsHealed(participantEntity.getTotalUnitsHealed());
        participantDto.setTripleKills(participantEntity.getTripleKills());
        participantDto.setTrueDamageDealt(participantEntity.getTrueDamageDealt());
        participantDto.setTrueDamageDealtToChampions(participantEntity.getTrueDamageDealtToChampions());
        participantDto.setTrueDamageTaken(participantEntity.getTrueDamageTaken());
        participantDto.setTurretKills(participantEntity.getTurretKills());
        participantDto.setTurretTakedowns(participantEntity.getTurretTakedowns());
        participantDto.setTurretsLost(participantEntity.getTurretsLost());
        participantDto.setUnrealKills(participantEntity.getUnrealKills());
        participantDto.setVisionScore(participantEntity.getVisionScore());
        participantDto.setVisionWardsBoughtInGame(participantEntity.getVisionWardsBoughtInGame());
        participantDto.setWardsKilled(participantEntity.getWardsKilled());
        participantDto.setWardsPlaced(participantEntity.getWardsPlaced());
        participantDto.setWin(participantEntity.isWin());
        participantDto.setRrt(participantEntity.getRrt());
    }
}