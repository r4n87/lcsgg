package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.entity.MatchParticipantId;
import dev.saariselka.inlol.utils.JsonParserForLOL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantDtoTest {
    MatchParticipantEntity matchParticipantEntity;
    PerksDto perksDto;
    long gameDuration;

    @BeforeEach
    void init() {
        matchParticipantEntity = createMatchParticipantEntity();
        perksDto = createPerksDto();
        gameDuration = 123456L;
    }

    @Test
    @DisplayName("ParticipantDto Lombok Get Function Test")
    public void testLombokGetFunction() {
        //Given
        //When
        ParticipantDto participantDto = new ParticipantDto(matchParticipantEntity, perksDto, gameDuration);

        //Then
        assertThat(participantDto.getPuuid()).isEqualTo(matchParticipantEntity.getMatchParticipantId().getPuuid());
        assertThat(participantDto.getDataVersion()).isEqualTo(matchParticipantEntity.getMatchParticipantId().getDataVersion());
        assertThat(participantDto.getMatchId()).isEqualTo(matchParticipantEntity.getMatchParticipantId().getMatchId());
        assertThat(participantDto.getParticipantId()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMatchParticipantId().getParticipantId()));
        assertThat(participantDto.getAssists()).isEqualTo(
                String.valueOf(matchParticipantEntity.getAssists()));
        assertThat(participantDto.getBaronKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getBaronKills()));
        assertThat(participantDto.getBountyLevel()).isEqualTo(
                String.valueOf(matchParticipantEntity.getBountyLevel()));
        assertThat(participantDto.getChampExperience()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampExperience()));
        assertThat(participantDto.getChampLevel()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampLevel()));
        assertThat(participantDto.getChampionId()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampionId()));
        assertThat(participantDto.getChampionNameENG()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampionName()));
        assertThat(participantDto.getChampionTransform()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampionTransform()));
        assertThat(participantDto.getConsumablesPurchased()).isEqualTo(
                String.valueOf(matchParticipantEntity.getConsumablesPurchased()));
        assertThat(participantDto.getDamageDealtToBuildings()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDamageDealtToBuildings()));
        assertThat(participantDto.getDamageDealtToObjectives()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDamageDealtToObjectives()));
        assertThat(participantDto.getDamageSelfMitigated()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDamageSelfMitigated()));
        assertThat(participantDto.getDeaths()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDeaths()));
        assertThat(participantDto.getDetectorWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDetectorWardsPlaced()));
        assertThat(participantDto.getDoubleKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDoubleKills()));
        assertThat(participantDto.getDragonKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDragonKills()));
        assertThat(participantDto.getFirstBloodAssist()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstBloodAssist()));
        assertThat(participantDto.getFirstBloodKill()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstBloodKill()));
        assertThat(participantDto.getFirstTowerAssist()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstTowerAssist()));
        assertThat(participantDto.getFirstTowerKill()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstTowerKill()));
        assertThat(participantDto.getGameEndedInEarlySurrender()).isEqualTo(
                String.valueOf(matchParticipantEntity.isGameEndedInEarlySurrender()));
        assertThat(participantDto.getGameEndedInSurrender()).isEqualTo(
                String.valueOf(matchParticipantEntity.isGameEndedInSurrender()));
        assertThat(participantDto.getGoldEarned()).isEqualTo(
                String.valueOf(matchParticipantEntity.getGoldEarned()));
        assertThat(participantDto.getGoldSpent()).isEqualTo(
                String.valueOf(matchParticipantEntity.getGoldSpent()));
        assertThat(participantDto.getIndividualPosition()).isEqualTo(
                matchParticipantEntity.getIndividualPosition());
        assertThat(participantDto.getInhibitorKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getInhibitorKills()));
        assertThat(participantDto.getInhibitorTakedowns()).isEqualTo(
                String.valueOf(matchParticipantEntity.getInhibitorTakedowns()));
        assertThat(participantDto.getInhibitorsLost()).isEqualTo(
                String.valueOf(matchParticipantEntity.getInhibitorsLost()));
        assertThat(participantDto.getItem0()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem0()));
        assertThat(participantDto.getItem1()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem1()));
        assertThat(participantDto.getItem2()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem2()));
        assertThat(participantDto.getItem3()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem3()));
        assertThat(participantDto.getItem4()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem4()));
        assertThat(participantDto.getItem5()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem5()));
        assertThat(participantDto.getItem6()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem6()));
        assertThat(participantDto.getItemsPurchased()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItemsPurchased()));
        assertThat(participantDto.getKillingSprees()).isEqualTo(
                String.valueOf(matchParticipantEntity.getKillingSprees()));
        assertThat(participantDto.getKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getKills()));
        assertThat(participantDto.getLane()).isEqualTo(
                matchParticipantEntity.getLane());
        assertThat(participantDto.getLargestCriticalStrike()).isEqualTo(
                String.valueOf(matchParticipantEntity.getLargestCriticalStrike()));
        assertThat(participantDto.getLargestKillingSpree()).isEqualTo(
                String.valueOf(matchParticipantEntity.getLargestKillingSpree()));
        assertThat(participantDto.getLongestTimeSpentLiving()).isEqualTo(
                String.valueOf(matchParticipantEntity.getLongestTimeSpentLiving()));
        assertThat(participantDto.getMagicDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMagicDamageDealt()));
        assertThat(participantDto.getMagicDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMagicDamageDealtToChampions()));
        assertThat(participantDto.getMagicDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMagicDamageTaken()));
        assertThat(participantDto.getNeutralMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNeutralMinionsKilled()));
        assertThat(participantDto.getNexusKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNexusKills()));
        assertThat(participantDto.getNexusLost()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNexusLost()));
        assertThat(participantDto.getNexusTakedowns()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNexusTakedowns()));
        assertThat(participantDto.getObjectivesStolen()).isEqualTo(
                String.valueOf(matchParticipantEntity.getObjectivesStolen()));
        assertThat(participantDto.getObjectivesStolenAssists()).isEqualTo(
                String.valueOf(matchParticipantEntity.getObjectivesStolenAssists()));
        assertThat(participantDto.getPentaKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPentaKills()));
        assertThat(participantDto.getPhysicalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPhysicalDamageDealt()));
        assertThat(participantDto.getPhysicalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPhysicalDamageDealtToChampions()));
        assertThat(participantDto.getPhysicalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPhysicalDamageTaken()));
        assertThat(participantDto.getProfileIcon()).isEqualTo(
                String.valueOf(matchParticipantEntity.getProfileIcon()));
        assertThat(participantDto.getQuadraKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getQuadraKills()));
        assertThat(participantDto.getRiotIdName()).isEqualTo(
                matchParticipantEntity.getRiotIdName());
        assertThat(participantDto.getRiotIdTagline()).isEqualTo(
                matchParticipantEntity.getRiotIdTagline());
        assertThat(participantDto.getRole()).isEqualTo(
                matchParticipantEntity.getRole());
        assertThat(participantDto.getSightWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSightWardsBoughtInGame()));
        assertThat(participantDto.getSpell1Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell1Casts()));
        assertThat(participantDto.getSpell2Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell2Casts()));
        assertThat(participantDto.getSpell3Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell3Casts()));
        assertThat(participantDto.getSpell4Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell4Casts()));
        assertThat(participantDto.getSummoner1Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSummoner1Casts()));
        assertThat(participantDto.getSummoner1Id()).isEqualTo(
                JsonParserForLOL.getSpellImageBySpellId(matchParticipantEntity.getSummoner1Id()));
        assertThat(participantDto.getSummoner2Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSummoner2Casts()));
        assertThat(participantDto.getSummoner2Id()).isEqualTo(
                JsonParserForLOL.getSpellImageBySpellId(matchParticipantEntity.getSummoner2Id()));
        assertThat(participantDto.getSummonerId()).isEqualTo(
                matchParticipantEntity.getSummonerId());
        assertThat(participantDto.getSummonerLevel()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSummonerLevel()));
        assertThat(participantDto.getSummonerName()).isEqualTo(
                matchParticipantEntity.getMatchParticipantId().getPuuid().equals("BOT")
                        ? "(봇)" : matchParticipantEntity.getSummonerName());
        assertThat(participantDto.getTeamEarlySurrendered()).isEqualTo(
                String.valueOf(matchParticipantEntity.isTeamEarlySurrendered()));
        assertThat(participantDto.getTeamId()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTeamId()));
        assertThat(participantDto.getTeamPosition()).isEqualTo(
                matchParticipantEntity.getTeamPosition());
        assertThat(participantDto.getTimeCCingOthers()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTimeCCingOthers()));
        assertThat(participantDto.getTimePlayed()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTimePlayed()));
        assertThat(participantDto.getTotalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalDamageDealt()));
        assertThat(participantDto.getTotalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalDamageDealtToChampions()));
        assertThat(participantDto.getTotalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalDamageTaken()));
        assertThat(participantDto.getTotalHeal()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalHeal()));
        assertThat(participantDto.getTotalHealsOnTeammates()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalHealsOnTeammates()));
        assertThat(participantDto.getTotalMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalMinionsKilled()));
        assertThat(participantDto.getTotalTimeCCDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalTimeCCDealt()));
        assertThat(participantDto.getTotalTimeSpentDead()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalTimeSpentDead()));
        assertThat(participantDto.getTotalUnitsHealed()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalUnitsHealed()));
        assertThat(participantDto.getTripleKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTripleKills()));
        assertThat(participantDto.getTrueDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTrueDamageDealt()));
        assertThat(participantDto.getTrueDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTrueDamageDealtToChampions()));
        assertThat(participantDto.getTrueDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTrueDamageTaken()));
        assertThat(participantDto.getTurretKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTurretKills()));
        assertThat(participantDto.getTurretTakedowns()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTurretTakedowns()));
        assertThat(participantDto.getTurretsLost()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTurretsLost()));
        assertThat(participantDto.getUnrealKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getUnrealKills()));
        assertThat(participantDto.getVisionScore()).isEqualTo(
                String.valueOf(matchParticipantEntity.getVisionScore()));
        assertThat(participantDto.getVisionWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantEntity.getVisionWardsBoughtInGame()));
        assertThat(participantDto.getWardsKilled()).isEqualTo(
                String.valueOf(matchParticipantEntity.getWardsKilled()));
        assertThat(participantDto.getWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantEntity.getWardsPlaced()));
        assertThat(participantDto.getWin()).isEqualTo(
                String.valueOf(matchParticipantEntity.isWin()));
        assertThat(participantDto.getRrt()).isEqualTo(
                matchParticipantEntity.getRrt());
        assertThat(participantDto.getPerks()).isEqualTo(perksDto);
        assertThat(participantDto.getMultiKills()).isEqualTo(
                getMultiKills(
                        String.valueOf(matchParticipantEntity.getDoubleKills()),
                        String.valueOf(matchParticipantEntity.getTripleKills()),
                        String.valueOf(matchParticipantEntity.getQuadraKills()),
                        String.valueOf(matchParticipantEntity.getPentaKills())
                ));
        assertThat(participantDto.getKda()).isEqualTo(
                getKda(
                        String.valueOf(matchParticipantEntity.getKills()),
                        String.valueOf(matchParticipantEntity.getDeaths()),
                        String.valueOf(matchParticipantEntity.getAssists())
                ));
        assertThat(participantDto.getMinionsKilledPerMin()).isEqualTo(
                getMinionsKilledPerMin(
                        String.valueOf(matchParticipantEntity.getTotalMinionsKilled()),
                        gameDuration
                ));
    }

    @Test
    @DisplayName("ParticipantDto Lombok Set Function Test")
    public void testLombokSetFunction() {
        //Given
        ParticipantDto participantDto = new ParticipantDto(matchParticipantEntity, perksDto, gameDuration);
        MatchParticipantEntity matchParticipantEntity = createMatchParticipantEntityForSetTest();
        PerksDto perksDto = new PerksDto();
        long gameDuration = 79797L;

        //When
        participantDto.setPuuid(matchParticipantEntity.getMatchParticipantId().getPuuid());
        participantDto.setDataVersion(matchParticipantEntity.getMatchParticipantId().getDataVersion());
        participantDto.setMatchId(matchParticipantEntity.getMatchParticipantId().getMatchId());
        participantDto.setParticipantId(
                String.valueOf(matchParticipantEntity.getMatchParticipantId().getParticipantId()));
        participantDto.setAssists(
                String.valueOf(matchParticipantEntity.getAssists()));
        participantDto.setBaronKills(
                String.valueOf(matchParticipantEntity.getBaronKills()));
        participantDto.setBountyLevel(
                String.valueOf(matchParticipantEntity.getBountyLevel()));
        participantDto.setChampExperience(
                String.valueOf(matchParticipantEntity.getChampExperience()));
        participantDto.setChampLevel(
                String.valueOf(matchParticipantEntity.getChampLevel()));
        participantDto.setChampionId(
                String.valueOf(matchParticipantEntity.getChampionId()));
        participantDto.setChampionNameENG(
                String.valueOf(matchParticipantEntity.getChampionName()));
        participantDto.setChampionTransform(
                String.valueOf(matchParticipantEntity.getChampionTransform()));
        participantDto.setConsumablesPurchased(
                String.valueOf(matchParticipantEntity.getConsumablesPurchased()));
        participantDto.setDamageDealtToBuildings(
                String.valueOf(matchParticipantEntity.getDamageDealtToBuildings()));
        participantDto.setDamageDealtToObjectives(
                String.valueOf(matchParticipantEntity.getDamageDealtToObjectives()));
        participantDto.setDamageSelfMitigated(
                String.valueOf(matchParticipantEntity.getDamageSelfMitigated()));
        participantDto.setDeaths(
                String.valueOf(matchParticipantEntity.getDeaths()));
        participantDto.setDetectorWardsPlaced(
                String.valueOf(matchParticipantEntity.getDetectorWardsPlaced()));
        participantDto.setDoubleKills(
                String.valueOf(matchParticipantEntity.getDoubleKills()));
        participantDto.setDragonKills(
                String.valueOf(matchParticipantEntity.getDragonKills()));
        participantDto.setFirstBloodAssist(
                String.valueOf(matchParticipantEntity.isFirstBloodAssist()));
        participantDto.setFirstBloodKill(
                String.valueOf(matchParticipantEntity.isFirstBloodKill()));
        participantDto.setFirstTowerAssist(
                String.valueOf(matchParticipantEntity.isFirstTowerAssist()));
        participantDto.setFirstTowerKill(
                String.valueOf(matchParticipantEntity.isFirstTowerKill()));
        participantDto.setGameEndedInEarlySurrender(
                String.valueOf(matchParticipantEntity.isGameEndedInEarlySurrender()));
        participantDto.setGameEndedInSurrender(
                String.valueOf(matchParticipantEntity.isGameEndedInSurrender()));
        participantDto.setGoldEarned(
                String.valueOf(matchParticipantEntity.getGoldEarned()));
        participantDto.setGoldSpent(
                String.valueOf(matchParticipantEntity.getGoldSpent()));
        participantDto.setIndividualPosition(
                matchParticipantEntity.getIndividualPosition());
        participantDto.setInhibitorKills(
                String.valueOf(matchParticipantEntity.getInhibitorKills()));
        participantDto.setInhibitorTakedowns(
                String.valueOf(matchParticipantEntity.getInhibitorTakedowns()));
        participantDto.setInhibitorsLost(
                String.valueOf(matchParticipantEntity.getInhibitorsLost()));
        participantDto.setItem0(
                String.valueOf(matchParticipantEntity.getItem0()));
        participantDto.setItem1(
                String.valueOf(matchParticipantEntity.getItem1()));
        participantDto.setItem2(
                String.valueOf(matchParticipantEntity.getItem2()));
        participantDto.setItem3(
                String.valueOf(matchParticipantEntity.getItem3()));
        participantDto.setItem4(
                String.valueOf(matchParticipantEntity.getItem4()));
        participantDto.setItem5(
                String.valueOf(matchParticipantEntity.getItem5()));
        participantDto.setItem6(
                String.valueOf(matchParticipantEntity.getItem6()));
        participantDto.setItemsPurchased(
                String.valueOf(matchParticipantEntity.getItemsPurchased()));
        participantDto.setKillingSprees(
                String.valueOf(matchParticipantEntity.getKillingSprees()));
        participantDto.setKills(
                String.valueOf(matchParticipantEntity.getKills()));
        participantDto.setLane(
                matchParticipantEntity.getLane());
        participantDto.setLargestCriticalStrike(
                String.valueOf(matchParticipantEntity.getLargestCriticalStrike()));
        participantDto.setLargestKillingSpree(
                String.valueOf(matchParticipantEntity.getLargestKillingSpree()));
        participantDto.setLongestTimeSpentLiving(
                String.valueOf(matchParticipantEntity.getLongestTimeSpentLiving()));
        participantDto.setMagicDamageDealt(
                String.valueOf(matchParticipantEntity.getMagicDamageDealt()));
        participantDto.setMagicDamageDealtToChampions(
                String.valueOf(matchParticipantEntity.getMagicDamageDealtToChampions()));
        participantDto.setMagicDamageTaken(
                String.valueOf(matchParticipantEntity.getMagicDamageTaken()));
        participantDto.setNeutralMinionsKilled(
                String.valueOf(matchParticipantEntity.getNeutralMinionsKilled()));
        participantDto.setNexusKills(
                String.valueOf(matchParticipantEntity.getNexusKills()));
        participantDto.setNexusLost(
                String.valueOf(matchParticipantEntity.getNexusLost()));
        participantDto.setNexusTakedowns(
                String.valueOf(matchParticipantEntity.getNexusTakedowns()));
        participantDto.setObjectivesStolen(
                String.valueOf(matchParticipantEntity.getObjectivesStolen()));
        participantDto.setObjectivesStolenAssists(
                String.valueOf(matchParticipantEntity.getObjectivesStolenAssists()));
        participantDto.setPentaKills(
                String.valueOf(matchParticipantEntity.getPentaKills()));
        participantDto.setPhysicalDamageDealt(
                String.valueOf(matchParticipantEntity.getPhysicalDamageDealt()));
        participantDto.setPhysicalDamageDealtToChampions(
                String.valueOf(matchParticipantEntity.getPhysicalDamageDealtToChampions()));
        participantDto.setPhysicalDamageTaken(
                String.valueOf(matchParticipantEntity.getPhysicalDamageTaken()));
        participantDto.setProfileIcon(
                String.valueOf(matchParticipantEntity.getProfileIcon()));
        participantDto.setQuadraKills(
                String.valueOf(matchParticipantEntity.getQuadraKills()));
        participantDto.setRiotIdName(
                matchParticipantEntity.getRiotIdName());
        participantDto.setRiotIdTagline(
                matchParticipantEntity.getRiotIdTagline());
        participantDto.setRole(
                matchParticipantEntity.getRole());
        participantDto.setSightWardsBoughtInGame(
                String.valueOf(matchParticipantEntity.getSightWardsBoughtInGame()));
        participantDto.setSpell1Casts(
                String.valueOf(matchParticipantEntity.getSpell1Casts()));
        participantDto.setSpell2Casts(
                String.valueOf(matchParticipantEntity.getSpell2Casts()));
        participantDto.setSpell3Casts(
                String.valueOf(matchParticipantEntity.getSpell3Casts()));
        participantDto.setSpell4Casts(
                String.valueOf(matchParticipantEntity.getSpell4Casts()));
        participantDto.setSummoner1Casts(
                String.valueOf(matchParticipantEntity.getSummoner1Casts()));
        participantDto.setSummoner1Id(
                JsonParserForLOL.getSpellImageBySpellId(matchParticipantEntity.getSummoner1Id()));
        participantDto.setSummoner2Casts(
                String.valueOf(matchParticipantEntity.getSummoner2Casts()));
        participantDto.setSummoner2Id(
                JsonParserForLOL.getSpellImageBySpellId(matchParticipantEntity.getSummoner2Id()));
        participantDto.setSummonerId(
                matchParticipantEntity.getSummonerId());
        participantDto.setSummonerLevel(
                String.valueOf(matchParticipantEntity.getSummonerLevel()));
        participantDto.setSummonerName(
                matchParticipantEntity.getMatchParticipantId().getPuuid().equals("BOT")
                        ? "(봇)" : matchParticipantEntity.getSummonerName());
        participantDto.setTeamEarlySurrendered(
                String.valueOf(matchParticipantEntity.isTeamEarlySurrendered()));
        participantDto.setTeamId(
                String.valueOf(matchParticipantEntity.getTeamId()));
        participantDto.setTeamPosition(
                matchParticipantEntity.getTeamPosition());
        participantDto.setTimeCCingOthers(
                String.valueOf(matchParticipantEntity.getTimeCCingOthers()));
        participantDto.setTimePlayed(
                String.valueOf(matchParticipantEntity.getTimePlayed()));
        participantDto.setTotalDamageDealt(
                String.valueOf(matchParticipantEntity.getTotalDamageDealt()));
        participantDto.setTotalDamageDealtToChampions(
                String.valueOf(matchParticipantEntity.getTotalDamageDealtToChampions()));
        participantDto.setTotalDamageTaken(
                String.valueOf(matchParticipantEntity.getTotalDamageTaken()));
        participantDto.setTotalHeal(
                String.valueOf(matchParticipantEntity.getTotalHeal()));
        participantDto.setTotalHealsOnTeammates(
                String.valueOf(matchParticipantEntity.getTotalHealsOnTeammates()));
        participantDto.setTotalMinionsKilled(
                String.valueOf(matchParticipantEntity.getTotalMinionsKilled()));
        participantDto.setTotalTimeCCDealt(
                String.valueOf(matchParticipantEntity.getTotalTimeCCDealt()));
        participantDto.setTotalTimeSpentDead(
                String.valueOf(matchParticipantEntity.getTotalTimeSpentDead()));
        participantDto.setTotalUnitsHealed(
                String.valueOf(matchParticipantEntity.getTotalUnitsHealed()));
        participantDto.setTripleKills(
                String.valueOf(matchParticipantEntity.getTripleKills()));
        participantDto.setTrueDamageDealt(
                String.valueOf(matchParticipantEntity.getTrueDamageDealt()));
        participantDto.setTrueDamageDealtToChampions(
                String.valueOf(matchParticipantEntity.getTrueDamageDealtToChampions()));
        participantDto.setTrueDamageTaken(
                String.valueOf(matchParticipantEntity.getTrueDamageTaken()));
        participantDto.setTurretKills(
                String.valueOf(matchParticipantEntity.getTurretKills()));
        participantDto.setTurretTakedowns(
                String.valueOf(matchParticipantEntity.getTurretTakedowns()));
        participantDto.setTurretsLost(
                String.valueOf(matchParticipantEntity.getTurretsLost()));
        participantDto.setUnrealKills(
                String.valueOf(matchParticipantEntity.getUnrealKills()));
        participantDto.setVisionScore(
                String.valueOf(matchParticipantEntity.getVisionScore()));
        participantDto.setVisionWardsBoughtInGame(
                String.valueOf(matchParticipantEntity.getVisionWardsBoughtInGame()));
        participantDto.setWardsKilled(
                String.valueOf(matchParticipantEntity.getWardsKilled()));
        participantDto.setWardsPlaced(
                String.valueOf(matchParticipantEntity.getWardsPlaced()));
        participantDto.setWin(
                String.valueOf(matchParticipantEntity.isWin()));
        participantDto.setRrt(
                matchParticipantEntity.getRrt());
        participantDto.setPerks(perksDto);
        participantDto.setMultiKills(
                getMultiKills(
                        String.valueOf(matchParticipantEntity.getDoubleKills()),
                        String.valueOf(matchParticipantEntity.getTripleKills()),
                        String.valueOf(matchParticipantEntity.getQuadraKills()),
                        String.valueOf(matchParticipantEntity.getPentaKills())
                ));
        participantDto.setKda(
                getKda(
                        String.valueOf(matchParticipantEntity.getKills()),
                        String.valueOf(matchParticipantEntity.getDeaths()),
                        String.valueOf(matchParticipantEntity.getAssists())
                ));
        participantDto.setMinionsKilledPerMin(
                getMinionsKilledPerMin(
                        String.valueOf(matchParticipantEntity.getTotalMinionsKilled()),
                        gameDuration
                ));

        //Then
        assertThat(participantDto.getPuuid()).isEqualTo(matchParticipantEntity.getMatchParticipantId().getPuuid());
        assertThat(participantDto.getDataVersion()).isEqualTo(matchParticipantEntity.getMatchParticipantId().getDataVersion());
        assertThat(participantDto.getMatchId()).isEqualTo(matchParticipantEntity.getMatchParticipantId().getMatchId());
        assertThat(participantDto.getParticipantId()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMatchParticipantId().getParticipantId()));
        assertThat(participantDto.getAssists()).isEqualTo(
                String.valueOf(matchParticipantEntity.getAssists()));
        assertThat(participantDto.getBaronKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getBaronKills()));
        assertThat(participantDto.getBountyLevel()).isEqualTo(
                String.valueOf(matchParticipantEntity.getBountyLevel()));
        assertThat(participantDto.getChampExperience()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampExperience()));
        assertThat(participantDto.getChampLevel()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampLevel()));
        assertThat(participantDto.getChampionId()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampionId()));
        assertThat(participantDto.getChampionNameENG()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampionName()));
        assertThat(participantDto.getChampionTransform()).isEqualTo(
                String.valueOf(matchParticipantEntity.getChampionTransform()));
        assertThat(participantDto.getConsumablesPurchased()).isEqualTo(
                String.valueOf(matchParticipantEntity.getConsumablesPurchased()));
        assertThat(participantDto.getDamageDealtToBuildings()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDamageDealtToBuildings()));
        assertThat(participantDto.getDamageDealtToObjectives()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDamageDealtToObjectives()));
        assertThat(participantDto.getDamageSelfMitigated()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDamageSelfMitigated()));
        assertThat(participantDto.getDeaths()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDeaths()));
        assertThat(participantDto.getDetectorWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDetectorWardsPlaced()));
        assertThat(participantDto.getDoubleKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDoubleKills()));
        assertThat(participantDto.getDragonKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getDragonKills()));
        assertThat(participantDto.getFirstBloodAssist()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstBloodAssist()));
        assertThat(participantDto.getFirstBloodKill()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstBloodKill()));
        assertThat(participantDto.getFirstTowerAssist()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstTowerAssist()));
        assertThat(participantDto.getFirstTowerKill()).isEqualTo(
                String.valueOf(matchParticipantEntity.isFirstTowerKill()));
        assertThat(participantDto.getGameEndedInEarlySurrender()).isEqualTo(
                String.valueOf(matchParticipantEntity.isGameEndedInEarlySurrender()));
        assertThat(participantDto.getGameEndedInSurrender()).isEqualTo(
                String.valueOf(matchParticipantEntity.isGameEndedInSurrender()));
        assertThat(participantDto.getGoldEarned()).isEqualTo(
                String.valueOf(matchParticipantEntity.getGoldEarned()));
        assertThat(participantDto.getGoldSpent()).isEqualTo(
                String.valueOf(matchParticipantEntity.getGoldSpent()));
        assertThat(participantDto.getIndividualPosition()).isEqualTo(
                matchParticipantEntity.getIndividualPosition());
        assertThat(participantDto.getInhibitorKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getInhibitorKills()));
        assertThat(participantDto.getInhibitorTakedowns()).isEqualTo(
                String.valueOf(matchParticipantEntity.getInhibitorTakedowns()));
        assertThat(participantDto.getInhibitorsLost()).isEqualTo(
                String.valueOf(matchParticipantEntity.getInhibitorsLost()));
        assertThat(participantDto.getItem0()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem0()));
        assertThat(participantDto.getItem1()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem1()));
        assertThat(participantDto.getItem2()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem2()));
        assertThat(participantDto.getItem3()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem3()));
        assertThat(participantDto.getItem4()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem4()));
        assertThat(participantDto.getItem5()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem5()));
        assertThat(participantDto.getItem6()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItem6()));
        assertThat(participantDto.getItemsPurchased()).isEqualTo(
                String.valueOf(matchParticipantEntity.getItemsPurchased()));
        assertThat(participantDto.getKillingSprees()).isEqualTo(
                String.valueOf(matchParticipantEntity.getKillingSprees()));
        assertThat(participantDto.getKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getKills()));
        assertThat(participantDto.getLane()).isEqualTo(
                matchParticipantEntity.getLane());
        assertThat(participantDto.getLargestCriticalStrike()).isEqualTo(
                String.valueOf(matchParticipantEntity.getLargestCriticalStrike()));
        assertThat(participantDto.getLargestKillingSpree()).isEqualTo(
                String.valueOf(matchParticipantEntity.getLargestKillingSpree()));
        assertThat(participantDto.getLongestTimeSpentLiving()).isEqualTo(
                String.valueOf(matchParticipantEntity.getLongestTimeSpentLiving()));
        assertThat(participantDto.getMagicDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMagicDamageDealt()));
        assertThat(participantDto.getMagicDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMagicDamageDealtToChampions()));
        assertThat(participantDto.getMagicDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getMagicDamageTaken()));
        assertThat(participantDto.getNeutralMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNeutralMinionsKilled()));
        assertThat(participantDto.getNexusKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNexusKills()));
        assertThat(participantDto.getNexusLost()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNexusLost()));
        assertThat(participantDto.getNexusTakedowns()).isEqualTo(
                String.valueOf(matchParticipantEntity.getNexusTakedowns()));
        assertThat(participantDto.getObjectivesStolen()).isEqualTo(
                String.valueOf(matchParticipantEntity.getObjectivesStolen()));
        assertThat(participantDto.getObjectivesStolenAssists()).isEqualTo(
                String.valueOf(matchParticipantEntity.getObjectivesStolenAssists()));
        assertThat(participantDto.getPentaKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPentaKills()));
        assertThat(participantDto.getPhysicalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPhysicalDamageDealt()));
        assertThat(participantDto.getPhysicalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPhysicalDamageDealtToChampions()));
        assertThat(participantDto.getPhysicalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getPhysicalDamageTaken()));
        assertThat(participantDto.getProfileIcon()).isEqualTo(
                String.valueOf(matchParticipantEntity.getProfileIcon()));
        assertThat(participantDto.getQuadraKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getQuadraKills()));
        assertThat(participantDto.getRiotIdName()).isEqualTo(
                matchParticipantEntity.getRiotIdName());
        assertThat(participantDto.getRiotIdTagline()).isEqualTo(
                matchParticipantEntity.getRiotIdTagline());
        assertThat(participantDto.getRole()).isEqualTo(
                matchParticipantEntity.getRole());
        assertThat(participantDto.getSightWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSightWardsBoughtInGame()));
        assertThat(participantDto.getSpell1Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell1Casts()));
        assertThat(participantDto.getSpell2Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell2Casts()));
        assertThat(participantDto.getSpell3Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell3Casts()));
        assertThat(participantDto.getSpell4Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSpell4Casts()));
        assertThat(participantDto.getSummoner1Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSummoner1Casts()));
        assertThat(participantDto.getSummoner1Id()).isEqualTo(
                JsonParserForLOL.getSpellImageBySpellId(matchParticipantEntity.getSummoner1Id()));
        assertThat(participantDto.getSummoner2Casts()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSummoner2Casts()));
        assertThat(participantDto.getSummoner2Id()).isEqualTo(
                JsonParserForLOL.getSpellImageBySpellId(matchParticipantEntity.getSummoner2Id()));
        assertThat(participantDto.getSummonerId()).isEqualTo(
                matchParticipantEntity.getSummonerId());
        assertThat(participantDto.getSummonerLevel()).isEqualTo(
                String.valueOf(matchParticipantEntity.getSummonerLevel()));
        assertThat(participantDto.getSummonerName()).isEqualTo(
                matchParticipantEntity.getMatchParticipantId().getPuuid().equals("BOT")
                        ? "(봇)" : matchParticipantEntity.getSummonerName());
        assertThat(participantDto.getTeamEarlySurrendered()).isEqualTo(
                String.valueOf(matchParticipantEntity.isTeamEarlySurrendered()));
        assertThat(participantDto.getTeamId()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTeamId()));
        assertThat(participantDto.getTeamPosition()).isEqualTo(
                matchParticipantEntity.getTeamPosition());
        assertThat(participantDto.getTimeCCingOthers()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTimeCCingOthers()));
        assertThat(participantDto.getTimePlayed()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTimePlayed()));
        assertThat(participantDto.getTotalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalDamageDealt()));
        assertThat(participantDto.getTotalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalDamageDealtToChampions()));
        assertThat(participantDto.getTotalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalDamageTaken()));
        assertThat(participantDto.getTotalHeal()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalHeal()));
        assertThat(participantDto.getTotalHealsOnTeammates()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalHealsOnTeammates()));
        assertThat(participantDto.getTotalMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalMinionsKilled()));
        assertThat(participantDto.getTotalTimeCCDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalTimeCCDealt()));
        assertThat(participantDto.getTotalTimeSpentDead()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalTimeSpentDead()));
        assertThat(participantDto.getTotalUnitsHealed()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTotalUnitsHealed()));
        assertThat(participantDto.getTripleKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTripleKills()));
        assertThat(participantDto.getTrueDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTrueDamageDealt()));
        assertThat(participantDto.getTrueDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTrueDamageDealtToChampions()));
        assertThat(participantDto.getTrueDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTrueDamageTaken()));
        assertThat(participantDto.getTurretKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTurretKills()));
        assertThat(participantDto.getTurretTakedowns()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTurretTakedowns()));
        assertThat(participantDto.getTurretsLost()).isEqualTo(
                String.valueOf(matchParticipantEntity.getTurretsLost()));
        assertThat(participantDto.getUnrealKills()).isEqualTo(
                String.valueOf(matchParticipantEntity.getUnrealKills()));
        assertThat(participantDto.getVisionScore()).isEqualTo(
                String.valueOf(matchParticipantEntity.getVisionScore()));
        assertThat(participantDto.getVisionWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantEntity.getVisionWardsBoughtInGame()));
        assertThat(participantDto.getWardsKilled()).isEqualTo(
                String.valueOf(matchParticipantEntity.getWardsKilled()));
        assertThat(participantDto.getWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantEntity.getWardsPlaced()));
        assertThat(participantDto.getWin()).isEqualTo(
                String.valueOf(matchParticipantEntity.isWin()));
        assertThat(participantDto.getRrt()).isEqualTo(
                matchParticipantEntity.getRrt());
        assertThat(participantDto.getPerks()).isEqualTo(perksDto);
        assertThat(participantDto.getMultiKills()).isEqualTo(
                getMultiKills(
                        String.valueOf(matchParticipantEntity.getDoubleKills()),
                        String.valueOf(matchParticipantEntity.getTripleKills()),
                        String.valueOf(matchParticipantEntity.getQuadraKills()),
                        String.valueOf(matchParticipantEntity.getPentaKills())
                ));
        assertThat(participantDto.getKda()).isEqualTo(
                getKda(
                        String.valueOf(matchParticipantEntity.getKills()),
                        String.valueOf(matchParticipantEntity.getDeaths()),
                        String.valueOf(matchParticipantEntity.getAssists())
                ));
        assertThat(participantDto.getMinionsKilledPerMin()).isEqualTo(
                getMinionsKilledPerMin(
                        String.valueOf(matchParticipantEntity.getTotalMinionsKilled()),
                        gameDuration
                ));
    }

    private MatchParticipantEntity createMatchParticipantEntity() {
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
        int summoner1Id = 6;
        int summoner2Casts = 7;
        int summoner2Id = 8;
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

        return new MatchParticipantEntity(
                new MatchParticipantId(puuid, dataVersion, matchId, participantId),
                assists,
                baronKills,
                bountyLevel,
                champExperience,
                champLevel,
                championId,
                championName,
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
        int summoner1Id = 53;
        int summoner2Casts = 52;
        int summoner2Id = 50;
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

    private PerksDto createPerksDto() {
        return new PerksDto();
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
