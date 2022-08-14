package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.DtoMapper;
import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.entity.MatchParticipantId;
import dev.saariselka.inlol.service.VOMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchParticipantDtoTest {
    MatchParticipantDto matchParticipantDto;
    MatchPerksDto matchPerksDto;
    long gameDuration;
    VOMapper voMapper;
    DtoMapper dtoMapper;

    @BeforeEach
    void init() {
        matchParticipantDto = createMatchParticipantDto();
        matchPerksDto = createPerksDto();
        gameDuration = 123456L;
    }

    @Test
    @DisplayName("ParticipantDto Lombok Get Function Test")
    public void testLombokGetFunction() {
        //Given
        //When
        MatchParticipantDto matchParticipantDto = new MatchParticipantDto(this.matchParticipantDto, matchPerksDto, gameDuration);

        //Then
        assertThat(matchParticipantDto.getPuuid()).isEqualTo(this.matchParticipantDto.getPuuid());
        assertThat(matchParticipantDto.getDataVersion()).isEqualTo(this.matchParticipantDto.getDataVersion());
        assertThat(matchParticipantDto.getMatchId()).isEqualTo(this.matchParticipantDto.getMatchId());
        assertThat(matchParticipantDto.getParticipantId()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getParticipantId()));
        assertThat(matchParticipantDto.getAssists()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getAssists()));
        assertThat(matchParticipantDto.getBaronKills()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getBaronKills()));
        assertThat(matchParticipantDto.getBountyLevel()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getBountyLevel()));
        assertThat(matchParticipantDto.getChampExperience()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getChampExperience()));
        assertThat(matchParticipantDto.getChampLevel()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getChampLevel()));
        assertThat(matchParticipantDto.getChampionId()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getChampionId()));
        assertThat(matchParticipantDto.getChampionNameENG()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getChampionNameENG()));
        assertThat(matchParticipantDto.getChampionNameKR()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getChampionNameKR()));
        assertThat(matchParticipantDto.getChampionImg()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getChampionImg()));
        assertThat(matchParticipantDto.getChampionTransform()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getChampionTransform()));
        assertThat(matchParticipantDto.getConsumablesPurchased()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getConsumablesPurchased()));
        assertThat(matchParticipantDto.getDamageDealtToBuildings()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getDamageDealtToBuildings()));
        assertThat(matchParticipantDto.getDamageDealtToObjectives()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getDamageDealtToObjectives()));
        assertThat(matchParticipantDto.getDamageSelfMitigated()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getDamageSelfMitigated()));
        assertThat(matchParticipantDto.getDeaths()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getDeaths()));
        assertThat(matchParticipantDto.getDetectorWardsPlaced()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getDetectorWardsPlaced()));
        assertThat(matchParticipantDto.getDoubleKills()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getDoubleKills()));
        assertThat(matchParticipantDto.getDragonKills()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getDragonKills()));
        assertThat(matchParticipantDto.getFirstBloodAssist()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getFirstBloodAssist()));
        assertThat(matchParticipantDto.getFirstBloodKill()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getFirstBloodKill()));
        assertThat(matchParticipantDto.getFirstTowerAssist()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getFirstTowerAssist()));
        assertThat(matchParticipantDto.getFirstTowerKill()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getFirstTowerKill()));
        assertThat(matchParticipantDto.getGameEndedInEarlySurrender()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getGameEndedInEarlySurrender()));
        assertThat(matchParticipantDto.getGameEndedInSurrender()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getGameEndedInSurrender()));
        assertThat(matchParticipantDto.getGoldEarned()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getGoldEarned()));
        assertThat(matchParticipantDto.getGoldSpent()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getGoldSpent()));
        assertThat(matchParticipantDto.getIndividualPosition()).isEqualTo(
                this.matchParticipantDto.getIndividualPosition());
        assertThat(matchParticipantDto.getInhibitorKills()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getInhibitorKills()));
        assertThat(matchParticipantDto.getInhibitorTakedowns()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getInhibitorTakedowns()));
        assertThat(matchParticipantDto.getInhibitorsLost()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getInhibitorsLost()));
        assertThat(matchParticipantDto.getItem0()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getItem0()));
        assertThat(matchParticipantDto.getItem1()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getItem1()));
        assertThat(matchParticipantDto.getItem2()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getItem2()));
        assertThat(matchParticipantDto.getItem3()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getItem3()));
        assertThat(matchParticipantDto.getItem4()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getItem4()));
        assertThat(matchParticipantDto.getItem5()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getItem5()));
        assertThat(matchParticipantDto.getItem6()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getItem6()));
        assertThat(matchParticipantDto.getItemsPurchased()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getItemsPurchased()));
        assertThat(matchParticipantDto.getKillingSprees()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getKillingSprees()));
        assertThat(matchParticipantDto.getKills()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getKills()));
        assertThat(matchParticipantDto.getLane()).isEqualTo(
                this.matchParticipantDto.getLane());
        assertThat(matchParticipantDto.getLargestCriticalStrike()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getLargestCriticalStrike()));
        assertThat(matchParticipantDto.getLargestKillingSpree()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getLargestKillingSpree()));
        assertThat(matchParticipantDto.getLongestTimeSpentLiving()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getLongestTimeSpentLiving()));
        assertThat(matchParticipantDto.getMagicDamageDealt()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getMagicDamageDealt()));
        assertThat(matchParticipantDto.getMagicDamageDealtToChampions()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getMagicDamageDealtToChampions()));
        assertThat(matchParticipantDto.getMagicDamageTaken()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getMagicDamageTaken()));
        assertThat(matchParticipantDto.getNeutralMinionsKilled()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getNeutralMinionsKilled()));
        assertThat(matchParticipantDto.getNexusKills()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getNexusKills()));
        assertThat(matchParticipantDto.getNexusLost()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getNexusLost()));
        assertThat(matchParticipantDto.getNexusTakedowns()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getNexusTakedowns()));
        assertThat(matchParticipantDto.getObjectivesStolen()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getObjectivesStolen()));
        assertThat(matchParticipantDto.getObjectivesStolenAssists()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getObjectivesStolenAssists()));
        assertThat(matchParticipantDto.getPentaKills()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getPentaKills()));
        assertThat(matchParticipantDto.getPhysicalDamageDealt()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getPhysicalDamageDealt()));
        assertThat(matchParticipantDto.getPhysicalDamageDealtToChampions()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getPhysicalDamageDealtToChampions()));
        assertThat(matchParticipantDto.getPhysicalDamageTaken()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getPhysicalDamageTaken()));
        assertThat(matchParticipantDto.getProfileIcon()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getProfileIcon()));
        assertThat(matchParticipantDto.getQuadraKills()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getQuadraKills()));
        assertThat(matchParticipantDto.getRiotIdName()).isEqualTo(
                this.matchParticipantDto.getRiotIdName());
        assertThat(matchParticipantDto.getRiotIdTagline()).isEqualTo(
                this.matchParticipantDto.getRiotIdTagline());
        assertThat(matchParticipantDto.getRole()).isEqualTo(
                this.matchParticipantDto.getRole());
        assertThat(matchParticipantDto.getSightWardsBoughtInGame()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getSightWardsBoughtInGame()));
        assertThat(matchParticipantDto.getSpell1Casts()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getSpell1Casts()));
        assertThat(matchParticipantDto.getSpell2Casts()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getSpell2Casts()));
        assertThat(matchParticipantDto.getSpell3Casts()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getSpell3Casts()));
        assertThat(matchParticipantDto.getSpell4Casts()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getSpell4Casts()));
        assertThat(matchParticipantDto.getSummoner1Casts()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getSummoner1Casts()));
        assertThat(matchParticipantDto.getSummoner1Id()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getSummoner1Id()));
        assertThat(matchParticipantDto.getSummoner2Casts()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getSummoner2Casts()));
        assertThat(matchParticipantDto.getSummoner2Id()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getSummoner2Id()));
        assertThat(matchParticipantDto.getSummonerId()).isEqualTo(
                this.matchParticipantDto.getSummonerId());
        assertThat(matchParticipantDto.getSummonerLevel()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getSummonerLevel()));
        assertThat(matchParticipantDto.getSummonerName()).isEqualTo(
                this.matchParticipantDto.getPuuid().equals("BOT")
                        ? "(봇)" : this.matchParticipantDto.getSummonerName());
        assertThat(matchParticipantDto.getTeamEarlySurrendered()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTeamEarlySurrendered()));
        assertThat(matchParticipantDto.getTeamId()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTeamId()));
        assertThat(matchParticipantDto.getTeamPosition()).isEqualTo(
                this.matchParticipantDto.getTeamPosition());
        assertThat(matchParticipantDto.getTimeCCingOthers()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTimeCCingOthers()));
        assertThat(matchParticipantDto.getTimePlayed()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTimePlayed()));
        assertThat(matchParticipantDto.getTotalDamageDealt()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTotalDamageDealt()));
        assertThat(matchParticipantDto.getTotalDamageDealtToChampions()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTotalDamageDealtToChampions()));
        assertThat(matchParticipantDto.getTotalDamageTaken()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTotalDamageTaken()));
        assertThat(matchParticipantDto.getTotalHeal()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTotalHeal()));
        assertThat(matchParticipantDto.getTotalHealsOnTeammates()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTotalHealsOnTeammates()));
        assertThat(matchParticipantDto.getTotalMinionsKilled()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTotalMinionsKilled()));
        assertThat(matchParticipantDto.getTotalTimeCCDealt()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTotalTimeCCDealt()));
        assertThat(matchParticipantDto.getTotalTimeSpentDead()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTotalTimeSpentDead()));
        assertThat(matchParticipantDto.getTotalUnitsHealed()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTotalUnitsHealed()));
        assertThat(matchParticipantDto.getTripleKills()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTripleKills()));
        assertThat(matchParticipantDto.getTrueDamageDealt()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTrueDamageDealt()));
        assertThat(matchParticipantDto.getTrueDamageDealtToChampions()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTrueDamageDealtToChampions()));
        assertThat(matchParticipantDto.getTrueDamageTaken()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTrueDamageTaken()));
        assertThat(matchParticipantDto.getTurretKills()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTurretKills()));
        assertThat(matchParticipantDto.getTurretTakedowns()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTurretTakedowns()));
        assertThat(matchParticipantDto.getTurretsLost()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getTurretsLost()));
        assertThat(matchParticipantDto.getUnrealKills()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getUnrealKills()));
        assertThat(matchParticipantDto.getVisionScore()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getVisionScore()));
        assertThat(matchParticipantDto.getVisionWardsBoughtInGame()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getVisionWardsBoughtInGame()));
        assertThat(matchParticipantDto.getWardsKilled()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getWardsKilled()));
        assertThat(matchParticipantDto.getWardsPlaced()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getWardsPlaced()));
        assertThat(matchParticipantDto.getWin()).isEqualTo(
                String.valueOf(this.matchParticipantDto.getWin()));
        assertThat(matchParticipantDto.getRrt()).isEqualTo(
                this.matchParticipantDto.getRrt());
        assertThat(matchParticipantDto.getPerks()).isEqualTo(matchPerksDto);
        assertThat(matchParticipantDto.getMultiKills()).isEqualTo(
                getMultiKills(
                        String.valueOf(this.matchParticipantDto.getDoubleKills()),
                        String.valueOf(this.matchParticipantDto.getTripleKills()),
                        String.valueOf(this.matchParticipantDto.getQuadraKills()),
                        String.valueOf(this.matchParticipantDto.getPentaKills())
                ));
        assertThat(matchParticipantDto.getKda()).isEqualTo(
                getKda(
                        String.valueOf(this.matchParticipantDto.getKills()),
                        String.valueOf(this.matchParticipantDto.getDeaths()),
                        String.valueOf(this.matchParticipantDto.getAssists())
                ));
        assertThat(matchParticipantDto.getMinionsKilledPerMin()).isEqualTo(
                getMinionsKilledPerMin(
                        String.valueOf(this.matchParticipantDto.getTotalMinionsKilled()),
                        gameDuration
                ));
    }

    @Test
    @DisplayName("ParticipantDto Lombok Set Function Test")
    public void testLombokSetFunction() {
        //Given
        MatchParticipantDto matchParticipantDto = new MatchParticipantDto(this.matchParticipantDto, this.matchPerksDto, gameDuration);
        MatchParticipantEntity matchParticipantEntity = createMatchParticipantEntityForSetTest();
        MatchPerksDto matchPerksDto = new MatchPerksDto();
        long gameDuration = 79797L;

        //When
        matchParticipantDto.setPuuid(matchParticipantEntity.getMatchParticipantId().getPuuid());
        matchParticipantDto.setDataVersion(matchParticipantEntity.getMatchParticipantId().getDataVersion());
        matchParticipantDto.setMatchId(matchParticipantEntity.getMatchParticipantId().getMatchId());
        matchParticipantDto.setParticipantId(
                String.valueOf(matchParticipantEntity.getMatchParticipantId().getParticipantId()));
        matchParticipantDto.setAssists(
                String.valueOf(matchParticipantEntity.getAssists()));
        matchParticipantDto.setBaronKills(
                String.valueOf(matchParticipantEntity.getBaronKills()));
        matchParticipantDto.setBountyLevel(
                String.valueOf(matchParticipantEntity.getBountyLevel()));
        matchParticipantDto.setChampExperience(
                String.valueOf(matchParticipantEntity.getChampExperience()));
        matchParticipantDto.setChampLevel(
                String.valueOf(matchParticipantEntity.getChampLevel()));
        matchParticipantDto.setChampionId(
                String.valueOf(matchParticipantEntity.getChampionId()));
        matchParticipantDto.setChampionNameENG(
                String.valueOf(matchParticipantEntity.getChampionName()));
        matchParticipantDto.setChampionNameKR(
                String.valueOf(matchParticipantEntity.getChampionNameKR()));
        matchParticipantDto.setChampionImg(
                String.valueOf(matchParticipantEntity.getChampionImg()));
        matchParticipantDto.setChampionTransform(
                String.valueOf(matchParticipantEntity.getChampionTransform()));
        matchParticipantDto.setConsumablesPurchased(
                String.valueOf(matchParticipantEntity.getConsumablesPurchased()));
        matchParticipantDto.setDamageDealtToBuildings(
                String.valueOf(matchParticipantEntity.getDamageDealtToBuildings()));
        matchParticipantDto.setDamageDealtToObjectives(
                String.valueOf(matchParticipantEntity.getDamageDealtToObjectives()));
        matchParticipantDto.setDamageSelfMitigated(
                String.valueOf(matchParticipantEntity.getDamageSelfMitigated()));
        matchParticipantDto.setDeaths(
                String.valueOf(matchParticipantEntity.getDeaths()));
        matchParticipantDto.setDetectorWardsPlaced(
                String.valueOf(matchParticipantEntity.getDetectorWardsPlaced()));
        matchParticipantDto.setDoubleKills(
                String.valueOf(matchParticipantEntity.getDoubleKills()));
        matchParticipantDto.setDragonKills(
                String.valueOf(matchParticipantEntity.getDragonKills()));
        matchParticipantDto.setFirstBloodAssist(
                String.valueOf(matchParticipantEntity.isFirstBloodAssist()));
        matchParticipantDto.setFirstBloodKill(
                String.valueOf(matchParticipantEntity.isFirstBloodKill()));
        matchParticipantDto.setFirstTowerAssist(
                String.valueOf(matchParticipantEntity.isFirstTowerAssist()));
        matchParticipantDto.setFirstTowerKill(
                String.valueOf(matchParticipantEntity.isFirstTowerKill()));
        matchParticipantDto.setGameEndedInEarlySurrender(
                String.valueOf(matchParticipantEntity.isGameEndedInEarlySurrender()));
        matchParticipantDto.setGameEndedInSurrender(
                String.valueOf(matchParticipantEntity.isGameEndedInSurrender()));
        matchParticipantDto.setGoldEarned(
                String.valueOf(matchParticipantEntity.getGoldEarned()));
        matchParticipantDto.setGoldSpent(
                String.valueOf(matchParticipantEntity.getGoldSpent()));
        matchParticipantDto.setIndividualPosition(
                matchParticipantEntity.getIndividualPosition());
        matchParticipantDto.setInhibitorKills(
                String.valueOf(matchParticipantEntity.getInhibitorKills()));
        matchParticipantDto.setInhibitorTakedowns(
                String.valueOf(matchParticipantEntity.getInhibitorTakedowns()));
        matchParticipantDto.setInhibitorsLost(
                String.valueOf(matchParticipantEntity.getInhibitorsLost()));
        matchParticipantDto.setItem0(
                String.valueOf(matchParticipantEntity.getItem0()));
        matchParticipantDto.setItem1(
                String.valueOf(matchParticipantEntity.getItem1()));
        matchParticipantDto.setItem2(
                String.valueOf(matchParticipantEntity.getItem2()));
        matchParticipantDto.setItem3(
                String.valueOf(matchParticipantEntity.getItem3()));
        matchParticipantDto.setItem4(
                String.valueOf(matchParticipantEntity.getItem4()));
        matchParticipantDto.setItem5(
                String.valueOf(matchParticipantEntity.getItem5()));
        matchParticipantDto.setItem6(
                String.valueOf(matchParticipantEntity.getItem6()));
        matchParticipantDto.setItemsPurchased(
                String.valueOf(matchParticipantEntity.getItemsPurchased()));
        matchParticipantDto.setKillingSprees(
                String.valueOf(matchParticipantEntity.getKillingSprees()));
        matchParticipantDto.setKills(
                String.valueOf(matchParticipantEntity.getKills()));
        matchParticipantDto.setLane(
                matchParticipantEntity.getLane());
        matchParticipantDto.setLargestCriticalStrike(
                String.valueOf(matchParticipantEntity.getLargestCriticalStrike()));
        matchParticipantDto.setLargestKillingSpree(
                String.valueOf(matchParticipantEntity.getLargestKillingSpree()));
        matchParticipantDto.setLongestTimeSpentLiving(
                String.valueOf(matchParticipantEntity.getLongestTimeSpentLiving()));
        matchParticipantDto.setMagicDamageDealt(
                String.valueOf(matchParticipantEntity.getMagicDamageDealt()));
        matchParticipantDto.setMagicDamageDealtToChampions(
                String.valueOf(matchParticipantEntity.getMagicDamageDealtToChampions()));
        matchParticipantDto.setMagicDamageTaken(
                String.valueOf(matchParticipantEntity.getMagicDamageTaken()));
        matchParticipantDto.setNeutralMinionsKilled(
                String.valueOf(matchParticipantEntity.getNeutralMinionsKilled()));
        matchParticipantDto.setNexusKills(
                String.valueOf(matchParticipantEntity.getNexusKills()));
        matchParticipantDto.setNexusLost(
                String.valueOf(matchParticipantEntity.getNexusLost()));
        matchParticipantDto.setNexusTakedowns(
                String.valueOf(matchParticipantEntity.getNexusTakedowns()));
        matchParticipantDto.setObjectivesStolen(
                String.valueOf(matchParticipantEntity.getObjectivesStolen()));
        matchParticipantDto.setObjectivesStolenAssists(
                String.valueOf(matchParticipantEntity.getObjectivesStolenAssists()));
        matchParticipantDto.setPentaKills(
                String.valueOf(matchParticipantEntity.getPentaKills()));
        matchParticipantDto.setPhysicalDamageDealt(
                String.valueOf(matchParticipantEntity.getPhysicalDamageDealt()));
        matchParticipantDto.setPhysicalDamageDealtToChampions(
                String.valueOf(matchParticipantEntity.getPhysicalDamageDealtToChampions()));
        matchParticipantDto.setPhysicalDamageTaken(
                String.valueOf(matchParticipantEntity.getPhysicalDamageTaken()));
        matchParticipantDto.setProfileIcon(
                String.valueOf(matchParticipantEntity.getProfileIcon()));
        matchParticipantDto.setQuadraKills(
                String.valueOf(matchParticipantEntity.getQuadraKills()));
        matchParticipantDto.setRiotIdName(
                matchParticipantEntity.getRiotIdName());
        matchParticipantDto.setRiotIdTagline(
                matchParticipantEntity.getRiotIdTagline());
        matchParticipantDto.setRole(
                matchParticipantEntity.getRole());
        matchParticipantDto.setSightWardsBoughtInGame(
                String.valueOf(matchParticipantEntity.getSightWardsBoughtInGame()));
        matchParticipantDto.setSpell1Casts(
                String.valueOf(matchParticipantEntity.getSpell1Casts()));
        matchParticipantDto.setSpell2Casts(
                String.valueOf(matchParticipantEntity.getSpell2Casts()));
        matchParticipantDto.setSpell3Casts(
                String.valueOf(matchParticipantEntity.getSpell3Casts()));
        matchParticipantDto.setSpell4Casts(
                String.valueOf(matchParticipantEntity.getSpell4Casts()));
        matchParticipantDto.setSummoner1Casts(
                String.valueOf(matchParticipantEntity.getSummoner1Casts()));
        matchParticipantDto.setSummoner1Id(
                String.valueOf(matchParticipantEntity.getSummoner1Id()));
        matchParticipantDto.setSummoner2Casts(
                String.valueOf(matchParticipantEntity.getSummoner2Casts()));
        matchParticipantDto.setSummoner2Id(
                String.valueOf(matchParticipantEntity.getSummoner2Id()));
        matchParticipantDto.setSummonerId(
                matchParticipantEntity.getSummonerId());
        matchParticipantDto.setSummonerLevel(
                String.valueOf(matchParticipantEntity.getSummonerLevel()));
        matchParticipantDto.setSummonerName(
                matchParticipantEntity.getMatchParticipantId().getPuuid().equals("BOT")
                        ? "(봇)" : matchParticipantEntity.getSummonerName());
        matchParticipantDto.setTeamEarlySurrendered(
                String.valueOf(matchParticipantEntity.isTeamEarlySurrendered()));
        matchParticipantDto.setTeamId(
                String.valueOf(matchParticipantEntity.getTeamId()));
        matchParticipantDto.setTeamPosition(
                matchParticipantEntity.getTeamPosition());
        matchParticipantDto.setTimeCCingOthers(
                String.valueOf(matchParticipantEntity.getTimeCCingOthers()));
        matchParticipantDto.setTimePlayed(
                String.valueOf(matchParticipantEntity.getTimePlayed()));
        matchParticipantDto.setTotalDamageDealt(
                String.valueOf(matchParticipantEntity.getTotalDamageDealt()));
        matchParticipantDto.setTotalDamageDealtToChampions(
                String.valueOf(matchParticipantEntity.getTotalDamageDealtToChampions()));
        matchParticipantDto.setTotalDamageTaken(
                String.valueOf(matchParticipantEntity.getTotalDamageTaken()));
        matchParticipantDto.setTotalHeal(
                String.valueOf(matchParticipantEntity.getTotalHeal()));
        matchParticipantDto.setTotalHealsOnTeammates(
                String.valueOf(matchParticipantEntity.getTotalHealsOnTeammates()));
        matchParticipantDto.setTotalMinionsKilled(
                String.valueOf(matchParticipantEntity.getTotalMinionsKilled()));
        matchParticipantDto.setTotalTimeCCDealt(
                String.valueOf(matchParticipantEntity.getTotalTimeCCDealt()));
        matchParticipantDto.setTotalTimeSpentDead(
                String.valueOf(matchParticipantEntity.getTotalTimeSpentDead()));
        matchParticipantDto.setTotalUnitsHealed(
                String.valueOf(matchParticipantEntity.getTotalUnitsHealed()));
        matchParticipantDto.setTripleKills(
                String.valueOf(matchParticipantEntity.getTripleKills()));
        matchParticipantDto.setTrueDamageDealt(
                String.valueOf(matchParticipantEntity.getTrueDamageDealt()));
        matchParticipantDto.setTrueDamageDealtToChampions(
                String.valueOf(matchParticipantEntity.getTrueDamageDealtToChampions()));
        matchParticipantDto.setTrueDamageTaken(
                String.valueOf(matchParticipantEntity.getTrueDamageTaken()));
        matchParticipantDto.setTurretKills(
                String.valueOf(matchParticipantEntity.getTurretKills()));
        matchParticipantDto.setTurretTakedowns(
                String.valueOf(matchParticipantEntity.getTurretTakedowns()));
        matchParticipantDto.setTurretsLost(
                String.valueOf(matchParticipantEntity.getTurretsLost()));
        matchParticipantDto.setUnrealKills(
                String.valueOf(matchParticipantEntity.getUnrealKills()));
        matchParticipantDto.setVisionScore(
                String.valueOf(matchParticipantEntity.getVisionScore()));
        matchParticipantDto.setVisionWardsBoughtInGame(
                String.valueOf(matchParticipantEntity.getVisionWardsBoughtInGame()));
        matchParticipantDto.setWardsKilled(
                String.valueOf(matchParticipantEntity.getWardsKilled()));
        matchParticipantDto.setWardsPlaced(
                String.valueOf(matchParticipantEntity.getWardsPlaced()));
        matchParticipantDto.setWin(
                String.valueOf(matchParticipantEntity.isWin()));
        matchParticipantDto.setRrt(
                matchParticipantEntity.getRrt());
        matchParticipantDto.setPerks(matchPerksDto);
        matchParticipantDto.setMultiKills(
                getMultiKills(
                        String.valueOf(matchParticipantEntity.getDoubleKills()),
                        String.valueOf(matchParticipantEntity.getTripleKills()),
                        String.valueOf(matchParticipantEntity.getQuadraKills()),
                        String.valueOf(matchParticipantEntity.getPentaKills())
                ));
        matchParticipantDto.setKda(
                getKda(
                        String.valueOf(matchParticipantEntity.getKills()),
                        String.valueOf(matchParticipantEntity.getDeaths()),
                        String.valueOf(matchParticipantEntity.getAssists())
                ));
        matchParticipantDto.setMinionsKilledPerMin(
                getMinionsKilledPerMin(
                        String.valueOf(matchParticipantEntity.getTotalMinionsKilled()),
                        gameDuration
                ));

        //Then
        assertThat(matchParticipantDto.getPuuid()).isEqualTo(matchParticipantEntity.getMatchParticipantId().getPuuid());
        assertThat(matchParticipantDto.getDataVersion()).isEqualTo(matchParticipantEntity.getMatchParticipantId().getDataVersion());
        assertThat(matchParticipantDto.getMatchId()).isEqualTo(matchParticipantEntity.getMatchParticipantId().getMatchId());
        assertThat(matchParticipantDto.getParticipantId()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMatchParticipantId().getParticipantId()));
        assertThat(matchParticipantDto.getAssists()).isEqualTo(
                String.valueOf(matchParticipantEntity.getAssists()));
        assertThat(matchParticipantDto.getBaronKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getBaronKills()));
        assertThat(matchParticipantDto.getBountyLevel()).isEqualTo(
                String.valueOf(matchParticipantEntity.getBountyLevel()));
        assertThat(matchParticipantDto.getChampExperience()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampExperience()));
        assertThat(matchParticipantDto.getChampLevel()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampLevel()));
        assertThat(matchParticipantDto.getChampionId()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampionId()));
        assertThat(matchParticipantDto.getChampionNameENG()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampionName()));
        assertThat(matchParticipantDto.getChampionNameKR()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampionNameKR()));
        assertThat(matchParticipantDto.getChampionImg()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampionImg()));
        assertThat(matchParticipantDto.getChampionTransform()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampionTransform()));
        assertThat(matchParticipantDto.getConsumablesPurchased()).isEqualTo(
                String.valueOf(matchParticipantEntity.getConsumablesPurchased()));
        assertThat(matchParticipantDto.getDamageDealtToBuildings()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDamageDealtToBuildings()));
        assertThat(matchParticipantDto.getDamageDealtToObjectives()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDamageDealtToObjectives()));
        assertThat(matchParticipantDto.getDamageSelfMitigated()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDamageSelfMitigated()));
        assertThat(matchParticipantDto.getDeaths()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDeaths()));
        assertThat(matchParticipantDto.getDetectorWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDetectorWardsPlaced()));
        assertThat(matchParticipantDto.getDoubleKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDoubleKills()));
        assertThat(matchParticipantDto.getDragonKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDragonKills()));
        assertThat(matchParticipantDto.getFirstBloodAssist()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstBloodAssist()));
        assertThat(matchParticipantDto.getFirstBloodKill()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstBloodKill()));
        assertThat(matchParticipantDto.getFirstTowerAssist()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstTowerAssist()));
        assertThat(matchParticipantDto.getFirstTowerKill()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstTowerKill()));
        assertThat(matchParticipantDto.getGameEndedInEarlySurrender()).isEqualTo(
                String.valueOf(matchParticipantEntity.isGameEndedInEarlySurrender()));
        assertThat(matchParticipantDto.getGameEndedInSurrender()).isEqualTo(
                String.valueOf(matchParticipantEntity.isGameEndedInSurrender()));
        assertThat(matchParticipantDto.getGoldEarned()).isEqualTo(
                String.valueOf(matchParticipantEntity.getGoldEarned()));
        assertThat(matchParticipantDto.getGoldSpent()).isEqualTo(
                String.valueOf(matchParticipantEntity.getGoldSpent()));
        assertThat(matchParticipantDto.getIndividualPosition()).isEqualTo(
                matchParticipantEntity.getIndividualPosition());
        assertThat(matchParticipantDto.getInhibitorKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getInhibitorKills()));
        assertThat(matchParticipantDto.getInhibitorTakedowns()).isEqualTo(
                String.valueOf(matchParticipantEntity.getInhibitorTakedowns()));
        assertThat(matchParticipantDto.getInhibitorsLost()).isEqualTo(
                String.valueOf(matchParticipantEntity.getInhibitorsLost()));
        assertThat(matchParticipantDto.getItem0()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem0()));
        assertThat(matchParticipantDto.getItem1()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem1()));
        assertThat(matchParticipantDto.getItem2()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem2()));
        assertThat(matchParticipantDto.getItem3()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem3()));
        assertThat(matchParticipantDto.getItem4()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem4()));
        assertThat(matchParticipantDto.getItem5()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem5()));
        assertThat(matchParticipantDto.getItem6()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem6()));
        assertThat(matchParticipantDto.getItemsPurchased()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItemsPurchased()));
        assertThat(matchParticipantDto.getKillingSprees()).isEqualTo(
                String.valueOf(matchParticipantEntity.getKillingSprees()));
        assertThat(matchParticipantDto.getKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getKills()));
        assertThat(matchParticipantDto.getLane()).isEqualTo(
                matchParticipantEntity.getLane());
        assertThat(matchParticipantDto.getLargestCriticalStrike()).isEqualTo(
                String.valueOf(matchParticipantEntity.getLargestCriticalStrike()));
        assertThat(matchParticipantDto.getLargestKillingSpree()).isEqualTo(
                String.valueOf(matchParticipantEntity.getLargestKillingSpree()));
        assertThat(matchParticipantDto.getLongestTimeSpentLiving()).isEqualTo(
                String.valueOf(matchParticipantEntity.getLongestTimeSpentLiving()));
        assertThat(matchParticipantDto.getMagicDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMagicDamageDealt()));
        assertThat(matchParticipantDto.getMagicDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMagicDamageDealtToChampions()));
        assertThat(matchParticipantDto.getMagicDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMagicDamageTaken()));
        assertThat(matchParticipantDto.getNeutralMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNeutralMinionsKilled()));
        assertThat(matchParticipantDto.getNexusKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNexusKills()));
        assertThat(matchParticipantDto.getNexusLost()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNexusLost()));
        assertThat(matchParticipantDto.getNexusTakedowns()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNexusTakedowns()));
        assertThat(matchParticipantDto.getObjectivesStolen()).isEqualTo(
                String.valueOf(matchParticipantEntity.getObjectivesStolen()));
        assertThat(matchParticipantDto.getObjectivesStolenAssists()).isEqualTo(
                String.valueOf(matchParticipantEntity.getObjectivesStolenAssists()));
        assertThat(matchParticipantDto.getPentaKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPentaKills()));
        assertThat(matchParticipantDto.getPhysicalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPhysicalDamageDealt()));
        assertThat(matchParticipantDto.getPhysicalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPhysicalDamageDealtToChampions()));
        assertThat(matchParticipantDto.getPhysicalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPhysicalDamageTaken()));
        assertThat(matchParticipantDto.getProfileIcon()).isEqualTo(
                String.valueOf(matchParticipantEntity.getProfileIcon()));
        assertThat(matchParticipantDto.getQuadraKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getQuadraKills()));
        assertThat(matchParticipantDto.getRiotIdName()).isEqualTo(
                matchParticipantEntity.getRiotIdName());
        assertThat(matchParticipantDto.getRiotIdTagline()).isEqualTo(
                matchParticipantEntity.getRiotIdTagline());
        assertThat(matchParticipantDto.getRole()).isEqualTo(
                matchParticipantEntity.getRole());
        assertThat(matchParticipantDto.getSightWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSightWardsBoughtInGame()));
        assertThat(matchParticipantDto.getSpell1Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell1Casts()));
        assertThat(matchParticipantDto.getSpell2Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell2Casts()));
        assertThat(matchParticipantDto.getSpell3Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell3Casts()));
        assertThat(matchParticipantDto.getSpell4Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell4Casts()));
        assertThat(matchParticipantDto.getSummoner1Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSummoner1Casts()));
        assertThat(matchParticipantDto.getSummoner1Id()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSummoner1Id()));
        assertThat(matchParticipantDto.getSummoner2Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSummoner2Casts()));
        assertThat(matchParticipantDto.getSummoner2Id()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSummoner2Id()));
        assertThat(matchParticipantDto.getSummonerId()).isEqualTo(
                matchParticipantEntity.getSummonerId());
        assertThat(matchParticipantDto.getSummonerLevel()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSummonerLevel()));
        assertThat(matchParticipantDto.getSummonerName()).isEqualTo(
                matchParticipantEntity.getMatchParticipantId().getPuuid().equals("BOT")
                        ? "(봇)" : matchParticipantEntity.getSummonerName());
        assertThat(matchParticipantDto.getTeamEarlySurrendered()).isEqualTo(
                String.valueOf(matchParticipantEntity.isTeamEarlySurrendered()));
        assertThat(matchParticipantDto.getTeamId()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTeamId()));
        assertThat(matchParticipantDto.getTeamPosition()).isEqualTo(
                matchParticipantEntity.getTeamPosition());
        assertThat(matchParticipantDto.getTimeCCingOthers()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTimeCCingOthers()));
        assertThat(matchParticipantDto.getTimePlayed()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTimePlayed()));
        assertThat(matchParticipantDto.getTotalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalDamageDealt()));
        assertThat(matchParticipantDto.getTotalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalDamageDealtToChampions()));
        assertThat(matchParticipantDto.getTotalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalDamageTaken()));
        assertThat(matchParticipantDto.getTotalHeal()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalHeal()));
        assertThat(matchParticipantDto.getTotalHealsOnTeammates()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalHealsOnTeammates()));
        assertThat(matchParticipantDto.getTotalMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalMinionsKilled()));
        assertThat(matchParticipantDto.getTotalTimeCCDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalTimeCCDealt()));
        assertThat(matchParticipantDto.getTotalTimeSpentDead()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalTimeSpentDead()));
        assertThat(matchParticipantDto.getTotalUnitsHealed()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalUnitsHealed()));
        assertThat(matchParticipantDto.getTripleKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTripleKills()));
        assertThat(matchParticipantDto.getTrueDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTrueDamageDealt()));
        assertThat(matchParticipantDto.getTrueDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTrueDamageDealtToChampions()));
        assertThat(matchParticipantDto.getTrueDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTrueDamageTaken()));
        assertThat(matchParticipantDto.getTurretKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTurretKills()));
        assertThat(matchParticipantDto.getTurretTakedowns()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTurretTakedowns()));
        assertThat(matchParticipantDto.getTurretsLost()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTurretsLost()));
        assertThat(matchParticipantDto.getUnrealKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getUnrealKills()));
        assertThat(matchParticipantDto.getVisionScore()).isEqualTo(
                String.valueOf(matchParticipantEntity.getVisionScore()));
        assertThat(matchParticipantDto.getVisionWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantEntity.getVisionWardsBoughtInGame()));
        assertThat(matchParticipantDto.getWardsKilled()).isEqualTo(
                String.valueOf(matchParticipantEntity.getWardsKilled()));
        assertThat(matchParticipantDto.getWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantEntity.getWardsPlaced()));
        assertThat(matchParticipantDto.getWin()).isEqualTo(
                String.valueOf(matchParticipantEntity.isWin()));
        assertThat(matchParticipantDto.getRrt()).isEqualTo(
                matchParticipantEntity.getRrt());
        assertThat(matchParticipantDto.getPerks()).isEqualTo(matchPerksDto);
        assertThat(matchParticipantDto.getMultiKills()).isEqualTo(
                getMultiKills(
                        String.valueOf(matchParticipantEntity.getDoubleKills()),
                        String.valueOf(matchParticipantEntity.getTripleKills()),
                        String.valueOf(matchParticipantEntity.getQuadraKills()),
                        String.valueOf(matchParticipantEntity.getPentaKills())
                ));
        assertThat(matchParticipantDto.getKda()).isEqualTo(
                getKda(
                        String.valueOf(matchParticipantEntity.getKills()),
                        String.valueOf(matchParticipantEntity.getDeaths()),
                        String.valueOf(matchParticipantEntity.getAssists())
                ));
        assertThat(matchParticipantDto.getMinionsKilledPerMin()).isEqualTo(
                getMinionsKilledPerMin(
                        String.valueOf(matchParticipantEntity.getTotalMinionsKilled()),
                        gameDuration
                ));
    }

    private MatchParticipantDto createMatchParticipantDto() {
        String puuid = "A1B2C3D4";
        String dataVersion = "2";
        String matchId = "AAAAAA";
        int participantId = 5;

        int assists = 6;
        int baronKills = 3;
        int bountyLevel = 6;
        int champExperience = 6;
        int champLevel = 10;
        int championId = 32;
        String championName = "Ezreal";
        String championNameKR = "이즈리얼";
        String championImg = "Ezreal.png";
        int championTransform = 0;
        int consumablesPurchased = 0;
        int damageDealtToBuildings = 562;
        int damageDealtToObjectives = 652;
        int damageDealtToTurrets = 424;
        int damageSelfMitigated = 456;
        int deaths = 3;
        int detectorWardsPlaced = 10;
        int doubleKills = 3;
        int dragonKills = 2;
        boolean firstBloodAssist = false;
        boolean firstBloodKill = true;
        boolean firstTowerAssist = false;
        boolean firstTowerKill = true;
        boolean gameEndedInEarlySurrender = false;
        boolean gameEndedInSurrender = true;
        int goldEarned = 5240;
        int goldSpent = 4270;
        String individualPosition = "BOTTOM";
        int inhibitorKills = 3;
        int inhibitorTakedowns = 6;
        int inhibitorsLost = 2;
        int item0 = 1;
        int item1 = 2;
        int item2 = 3;
        int item3 = 4;
        int item4 = 5;
        int item5 = 6;
        int item6 = 7;
        int itemsPurchased = 50;
        int killingSprees = 60;
        int kills = 7;
        String lane = "BOTTOM";
        int largestCriticalStrike = 5;
        int largestKillingSpree = 6;
        int largestMultiKill = 7;
        int longestTimeSpentLiving = 8;
        int magicDamageDealt = 9200;
        int magicDamageDealtToChampions = 6300;
        int magicDamageTaken = 5200;
        int neutralMinionsKilled = 52;
        int nexusKills = 3;
        int nexusTakedowns = 5;
        int nexusLost = 3;
        int objectivesStolen = 2;
        int objectivesStolenAssists = 1;
        int pentaKills = 1;
        int physicalDamageDealt = 12691;
        int physicalDamageDealtToChampions = 11591;
        int physicalDamageTaken = 6000;
        int profileIcon = 32;
        int quadraKills = 1;
        String riotIdName = "HIROO";
        String riotIdTagline = "HIROO321";
        String role = "HIHI";
        int sightWardsBoughtInGame = 5;
        int spell1Casts = 1;
        int spell2Casts = 2;
        int spell3Casts = 3;
        int spell4Casts = 4;
        int summoner1Casts = 5;
        String summoner1Id = "6";
        int summoner2Casts = 7;
        String summoner2Id = "8";
        String summonerId = "HelloSummoner";
        int summonerLevel = 10;
        String summonerName = "EZREALISGOD";
        boolean teamEarlySurrendered = false;
        int teamId = 100;
        String teamPosition = "RED";
        int timeCCingOthers = 5;
        int timePlayed = 10;
        int totalDamageDealt = 6000;
        int totalDamageDealtToChampions = 7000;
        int totalDamageShieldedOnTeammates = 8000;
        int totalDamageTaken = 9000;
        int totalHeal = 500;
        int totalHealsOnTeammates = 600;
        int totalMinionsKilled = 230;
        int totalTimeCCDealt = 100;
        int totalTimeSpentDead = 500;
        int totalUnitsHealed = 600;
        int tripleKills = 0;
        int trueDamageDealt = 18000;
        int trueDamageDealtToChampions = 17000;
        int trueDamageTaken = 16000;
        int turretKills = 3;
        int turretTakedowns = 60;
        int turretsLost = 2;
        int unrealKills = 1234;
        int visionScore = 10;
        int visionWardsBoughtInGame = 15;
        int wardsKilled = 6;
        int wardsPlaced = 1;
        boolean win = true;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        return new MatchParticipantDto(new MatchParticipantEntity(
                new MatchParticipantId(puuid, dataVersion, matchId, participantId),
                assists,
                baronKills,
                bountyLevel,
                champExperience,
                champLevel,
                championId,
                championName,
                championNameKR,
                championImg,
                championTransform,
                consumablesPurchased,
                damageDealtToBuildings,
                damageDealtToObjectives,
                damageDealtToTurrets,
                damageSelfMitigated,
                deaths,
                detectorWardsPlaced,
                doubleKills,
                dragonKills,
                firstBloodAssist,
                firstBloodKill,
                firstTowerAssist,
                firstTowerKill,
                gameEndedInEarlySurrender,
                gameEndedInSurrender,
                goldEarned,
                goldSpent,
                individualPosition,
                inhibitorKills,
                inhibitorTakedowns,
                inhibitorsLost,
                item0,
                item1,
                item2,
                item3,
                item4,
                item5,
                item6,
                itemsPurchased,
                killingSprees,
                kills,
                lane,
                largestCriticalStrike,
                largestKillingSpree,
                largestMultiKill,
                longestTimeSpentLiving,
                magicDamageDealt,
                magicDamageDealtToChampions,
                magicDamageTaken,
                neutralMinionsKilled,
                nexusKills,
                nexusTakedowns,
                nexusLost,
                objectivesStolen,
                objectivesStolenAssists,
                pentaKills,
                physicalDamageDealt,
                physicalDamageDealtToChampions,
                physicalDamageTaken,
                profileIcon,
                quadraKills,
                riotIdName,
                riotIdTagline,
                role,
                sightWardsBoughtInGame,
                spell1Casts,
                spell2Casts,
                spell3Casts,
                spell4Casts,
                summoner1Casts,
                summoner1Id,
                summoner2Casts,
                summoner2Id,
                summonerId,
                summonerLevel,
                summonerName,
                teamEarlySurrendered,
                teamId,
                teamPosition,
                timeCCingOthers,
                timePlayed,
                totalDamageDealt,
                totalDamageDealtToChampions,
                totalDamageShieldedOnTeammates,
                totalDamageTaken,
                totalHeal,
                totalHealsOnTeammates,
                totalMinionsKilled,
                totalTimeCCDealt,
                totalTimeSpentDead,
                totalUnitsHealed,
                tripleKills,
                trueDamageDealt,
                trueDamageDealtToChampions,
                trueDamageTaken,
                turretKills,
                turretTakedowns,
                turretsLost,
                unrealKills,
                visionScore,
                visionWardsBoughtInGame,
                wardsKilled,
                wardsPlaced,
                win,
                rrt
        ));
    }

    private MatchParticipantEntity createMatchParticipantEntityForSetTest() {
        String puuid = "UUUUUUUU";
        String dataVersion = "3";
        String matchId = "ABCDEFG";
        int participantId = 1;

        int assists = 9;
        int baronKills = 8;
        int bountyLevel = 7;
        int champExperience = 6;
        int champLevel = 5;
        int championId = 4;
        String championName = "Ari";
        String championNameKR = "아리";
        String championImg = "Ahri.png";
        int championTransform = 3;
        int consumablesPurchased = 2;
        int damageDealtToBuildings = 1;
        int damageDealtToObjectives = 100;
        int damageDealtToTurrets = 99;
        int damageSelfMitigated = 98;
        int deaths = 97;
        int detectorWardsPlaced = 96;
        int doubleKills = 95;
        int dragonKills = 94;
        boolean firstBloodAssist = true;
        boolean firstBloodKill = false;
        boolean firstTowerAssist = true;
        boolean firstTowerKill = false;
        boolean gameEndedInEarlySurrender = true;
        boolean gameEndedInSurrender = false;
        int goldEarned = 93;
        int goldSpent = 92;
        String individualPosition = "MIDDLE";
        int inhibitorKills = 91;
        int inhibitorTakedowns = 90;
        int inhibitorsLost = 89;
        int item0 = 88;
        int item1 = 87;
        int item2 = 86;
        int item3 = 85;
        int item4 = 84;
        int item5 = 83;
        int item6 = 82;
        int itemsPurchased = 81;
        int killingSprees = 80;
        int kills = 79;
        String lane = "MIDDLE";
        int largestCriticalStrike = 78;
        int largestKillingSpree = 77;
        int largestMultiKill = 76;
        int longestTimeSpentLiving = 75;
        int magicDamageDealt = 74;
        int magicDamageDealtToChampions = 73;
        int magicDamageTaken = 72;
        int neutralMinionsKilled = 71;
        int nexusKills = 70;
        int nexusTakedowns = 69;
        int nexusLost = 68;
        int objectivesStolen = 67;
        int objectivesStolenAssists = 66;
        int pentaKills = 65;
        int physicalDamageDealt = 64;
        int physicalDamageDealtToChampions = 63;
        int physicalDamageTaken = 62;
        int profileIcon = 61;
        int quadraKills = 60;
        String riotIdName = "BYEROO";
        String riotIdTagline = "BYEROO321";
        String role = "BYEBYE";
        int sightWardsBoughtInGame = 59;
        int spell1Casts = 58;
        int spell2Casts = 57;
        int spell3Casts = 56;
        int spell4Casts = 55;
        int summoner1Casts = 54;
        String summoner1Id = "53";
        int summoner2Casts = 52;
        String summoner2Id = "50";
        String summonerId = "ByeSummoner";
        int summonerLevel = 49;
        String summonerName = "ARIISGOD";
        boolean teamEarlySurrendered = true;
        int teamId = 48;
        String teamPosition = "BLUE";
        int timeCCingOthers = 47;
        int timePlayed = 46;
        int totalDamageDealt = 45;
        int totalDamageDealtToChampions = 44;
        int totalDamageShieldedOnTeammates = 43;
        int totalDamageTaken = 42;
        int totalHeal = 41;
        int totalHealsOnTeammates = 40;
        int totalMinionsKilled = 39;
        int totalTimeCCDealt = 38;
        int totalTimeSpentDead = 37;
        int totalUnitsHealed = 36;
        int tripleKills = 35;
        int trueDamageDealt = 34;
        int trueDamageDealtToChampions = 33;
        int trueDamageTaken = 32;
        int turretKills = 31;
        int turretTakedowns = 30;
        int turretsLost = 29;
        int unrealKills = 28;
        int visionScore = 27;
        int visionWardsBoughtInGame = 26;
        int wardsKilled = 25;
        int wardsPlaced = 24;
        boolean win = false;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        return new MatchParticipantEntity(
                new MatchParticipantId(puuid, dataVersion, matchId, participantId),
                assists,
                baronKills,
                bountyLevel,
                champExperience,
                champLevel,
                championId,
                championName,
                championNameKR,
                championImg,
                championTransform,
                consumablesPurchased,
                damageDealtToBuildings,
                damageDealtToObjectives,
                damageDealtToTurrets,
                damageSelfMitigated,
                deaths,
                detectorWardsPlaced,
                doubleKills,
                dragonKills,
                firstBloodAssist,
                firstBloodKill,
                firstTowerAssist,
                firstTowerKill,
                gameEndedInEarlySurrender,
                gameEndedInSurrender,
                goldEarned,
                goldSpent,
                individualPosition,
                inhibitorKills,
                inhibitorTakedowns,
                inhibitorsLost,
                item0,
                item1,
                item2,
                item3,
                item4,
                item5,
                item6,
                itemsPurchased,
                killingSprees,
                kills,
                lane,
                largestCriticalStrike,
                largestKillingSpree,
                largestMultiKill,
                longestTimeSpentLiving,
                magicDamageDealt,
                magicDamageDealtToChampions,
                magicDamageTaken,
                neutralMinionsKilled,
                nexusKills,
                nexusTakedowns,
                nexusLost,
                objectivesStolen,
                objectivesStolenAssists,
                pentaKills,
                physicalDamageDealt,
                physicalDamageDealtToChampions,
                physicalDamageTaken,
                profileIcon,
                quadraKills,
                riotIdName,
                riotIdTagline,
                role,
                sightWardsBoughtInGame,
                spell1Casts,
                spell2Casts,
                spell3Casts,
                spell4Casts,
                summoner1Casts,
                summoner1Id,
                summoner2Casts,
                summoner2Id,
                summonerId,
                summonerLevel,
                summonerName,
                teamEarlySurrendered,
                teamId,
                teamPosition,
                timeCCingOthers,
                timePlayed,
                totalDamageDealt,
                totalDamageDealtToChampions,
                totalDamageShieldedOnTeammates,
                totalDamageTaken,
                totalHeal,
                totalHealsOnTeammates,
                totalMinionsKilled,
                totalTimeCCDealt,
                totalTimeSpentDead,
                totalUnitsHealed,
                tripleKills,
                trueDamageDealt,
                trueDamageDealtToChampions,
                trueDamageTaken,
                turretKills,
                turretTakedowns,
                turretsLost,
                unrealKills,
                visionScore,
                visionWardsBoughtInGame,
                wardsKilled,
                wardsPlaced,
                win,
                rrt
        );
    }

    private MatchPerksDto createPerksDto() {
        return new MatchPerksDto();
    }

    private String getMultiKills(String doubleKills, String tripleKills, String quadraKills, String pentaKills) {
        if(Integer.parseInt(pentaKills) > 0)
            return "펜타킬";
        else if (Integer.parseInt(quadraKills) > 0)
            return "쿼드라킬";
        else if (Integer.parseInt(tripleKills) > 0)
            return "트리플킬";
        else if (Integer.parseInt(doubleKills) > 0)
            return "더블킬";
        else
            return null;
    }

    private String getMinionsKilledPerMin(String totalMinionsKilled, long gameDuration) {
        BigDecimal minionsKilledCount = new BigDecimal(totalMinionsKilled);
        BigDecimal gameDurationMin = BigDecimal.valueOf(gameDuration).divide(BigDecimal.valueOf(60), RoundingMode.FLOOR);

        return minionsKilledCount.divide(gameDurationMin, 1, RoundingMode.HALF_UP).toString();
    }

    private String getKda(String kill, String death, String assist) {
        String kda = ":1";
        BigDecimal kills = new BigDecimal(kill);
        BigDecimal deaths = new BigDecimal(death);
        BigDecimal assists = new BigDecimal(assist);

        if(0 == kills.compareTo(BigDecimal.ZERO)
                && 0 == assists.compareTo(BigDecimal.ZERO)) {
            kda = "0.00" + kda;
        } else if(0 == deaths.compareTo(BigDecimal.ZERO)) {
            kda = "Perfect";
        } else {
            BigDecimal ratio = kills.add(assists).divide(deaths, 2, RoundingMode.HALF_UP);
            kda = ratio + kda;
        }

        return kda;
    }

}
