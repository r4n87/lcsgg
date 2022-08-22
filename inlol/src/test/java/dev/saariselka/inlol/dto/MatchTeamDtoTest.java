package dev.saariselka.inlol.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTeamDtoTest {

    List<MatchBanDto> matchBanDtoList;
    MatchObjectivesDto matchObjectivesDto;

    List<MatchParticipantDto> matchParticipantDtoList;

    MatchPerksDto matchPerksDto;

    long gameDuration;

    @BeforeEach
    void init() {
        matchPerksDto = createPerksDto();
        matchBanDtoList = createTestMatchBanDtoList();
        matchObjectivesDto = createTestObjectivesDto();
        matchParticipantDtoList = createTestParticipantDtoList();
        gameDuration = 123456L;
    }

    @Test
    @DisplayName("Constructor")
    void constructor() {
        //given
        //TeamEntity entity = createTestTeamEntity();

        //when
        MatchTeamDto dto = new MatchTeamDto(matchBanDtoList, matchObjectivesDto, "100", "true", 10, matchParticipantDtoList);

        //then
        assertThat(dto.getBans().get(0).getChampionId()).isEqualTo(221);
        assertThat(dto.getBans().get(0).getPickTurn()).isEqualTo(1);
        assertThat(dto.getBans().get(1).getChampionId()).isEqualTo(-1);
        assertThat(dto.getBans().get(1).getPickTurn()).isEqualTo(2);
        assertThat(dto.getBans().get(2).getChampionId()).isEqualTo(200);
        assertThat(dto.getBans().get(2).getPickTurn()).isEqualTo(3);
        assertThat(dto.getBans().get(3).getChampionId()).isEqualTo(55);
        assertThat(dto.getBans().get(3).getPickTurn()).isEqualTo(4);
        assertThat(dto.getBans().get(4).getChampionId()).isEqualTo(10);
        assertThat(dto.getBans().get(4).getPickTurn()).isEqualTo(5);

        assertThat(dto.getObjectives().getBaron().isFirst()).isTrue();
        assertThat(dto.getObjectives().getBaron().getKills()).isEqualTo(2);
        assertThat(dto.getObjectives().getChampion().isFirst()).isFalse();
        assertThat(dto.getObjectives().getChampion().getKills()).isEqualTo(40);
        assertThat(dto.getObjectives().getDragon().isFirst()).isFalse();
        assertThat(dto.getObjectives().getDragon().getKills()).isEqualTo(1);
        assertThat(dto.getObjectives().getInhibitor().isFirst()).isTrue();
        assertThat(dto.getObjectives().getInhibitor().getKills()).isEqualTo(1);
        assertThat(dto.getObjectives().getRiftHeraId().isFirst()).isFalse();
        assertThat(dto.getObjectives().getRiftHeraId().getKills()).isEqualTo(0);
        assertThat(dto.getObjectives().getTower().isFirst()).isFalse();
        assertThat(dto.getObjectives().getTower().getKills()).isEqualTo(11);

        assertThat(dto.getTeamId()).isEqualTo("100");
        assertThat(dto.getWin()).isEqualTo("true");     // boolean?

        assertThat(dto.getParticipants().get(0).getPuuid()).isEqualTo(matchParticipantDtoList.get(0).getPuuid());
        assertThat(dto.getParticipants().get(0).getDataVersion()).isEqualTo(matchParticipantDtoList.get(0).getDataVersion());
        assertThat(dto.getParticipants().get(0).getMatchId()).isEqualTo(matchParticipantDtoList.get(0).getMatchId());
        assertThat(dto.getParticipants().get(0).getParticipantId()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getParticipantId()));
        assertThat(dto.getParticipants().get(0).getAssists()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getAssists()));
        assertThat(dto.getParticipants().get(0).getBaronKills()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getBaronKills()));
        assertThat(dto.getParticipants().get(0).getBountyLevel()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getBountyLevel()));
        assertThat(dto.getParticipants().get(0).getChampExperience()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getChampExperience()));
        assertThat(dto.getParticipants().get(0).getChampLevel()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getChampLevel()));
        assertThat(dto.getParticipants().get(0).getChampionId()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getChampionId()));
        assertThat(dto.getParticipants().get(0).getChampionName()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getChampionName()));
        assertThat(dto.getParticipants().get(0).getChampionNameKR()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getChampionNameKR()));
        assertThat(dto.getParticipants().get(0).getChampionImg()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getChampionImg()));
        assertThat(dto.getParticipants().get(0).getChampionTransform()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getChampionTransform()));
        assertThat(dto.getParticipants().get(0).getConsumablesPurchased()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getConsumablesPurchased()));
        assertThat(dto.getParticipants().get(0).getDamageDealtToBuildings()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getDamageDealtToBuildings()));
        assertThat(dto.getParticipants().get(0).getDamageDealtToObjectives()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getDamageDealtToObjectives()));
        assertThat(dto.getParticipants().get(0).getDamageSelfMitigated()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getDamageSelfMitigated()));
        assertThat(dto.getParticipants().get(0).getDeaths()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getDeaths()));
        assertThat(dto.getParticipants().get(0).getDetectorWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getDetectorWardsPlaced()));
        assertThat(dto.getParticipants().get(0).getDoubleKills()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getDoubleKills()));
        assertThat(dto.getParticipants().get(0).getDragonKills()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getDragonKills()));
        assertThat(dto.getParticipants().get(0).getFirstBloodAssist()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getFirstBloodAssist()));
        assertThat(dto.getParticipants().get(0).getFirstBloodKill()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getFirstBloodKill()));
        assertThat(dto.getParticipants().get(0).getFirstTowerAssist()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getFirstTowerAssist()));
        assertThat(dto.getParticipants().get(0).getFirstTowerKill()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getFirstTowerKill()));
        assertThat(dto.getParticipants().get(0).getGameEndedInEarlySurrender()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getGameEndedInEarlySurrender()));
        assertThat(dto.getParticipants().get(0).getGameEndedInSurrender()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getGameEndedInSurrender()));
        assertThat(dto.getParticipants().get(0).getGoldEarned()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getGoldEarned()));
        assertThat(dto.getParticipants().get(0).getGoldSpent()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getGoldSpent()));
        assertThat(dto.getParticipants().get(0).getIndividualPosition()).isEqualTo(
                matchParticipantDtoList.get(0).getIndividualPosition());
        assertThat(dto.getParticipants().get(0).getInhibitorKills()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getInhibitorKills()));
        assertThat(dto.getParticipants().get(0).getInhibitorTakedowns()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getInhibitorTakedowns()));
        assertThat(dto.getParticipants().get(0).getInhibitorsLost()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getInhibitorsLost()));
        assertThat(dto.getParticipants().get(0).getItem0()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getItem0()));
        assertThat(dto.getParticipants().get(0).getItem1()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getItem1()));
        assertThat(dto.getParticipants().get(0).getItem2()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getItem2()));
        assertThat(dto.getParticipants().get(0).getItem3()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getItem3()));
        assertThat(dto.getParticipants().get(0).getItem4()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getItem4()));
        assertThat(dto.getParticipants().get(0).getItem5()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getItem5()));
        assertThat(dto.getParticipants().get(0).getItem6()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getItem6()));
        assertThat(dto.getParticipants().get(0).getItemsPurchased()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getItemsPurchased()));
        assertThat(dto.getParticipants().get(0).getKillingSprees()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getKillingSprees()));
        assertThat(dto.getParticipants().get(0).getKills()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getKills()));
        assertThat(dto.getParticipants().get(0).getLane()).isEqualTo(
                matchParticipantDtoList.get(0).getLane());
        assertThat(dto.getParticipants().get(0).getLargestCriticalStrike()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getLargestCriticalStrike()));
        assertThat(dto.getParticipants().get(0).getLargestKillingSpree()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getLargestKillingSpree()));
        assertThat(dto.getParticipants().get(0).getLongestTimeSpentLiving()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getLongestTimeSpentLiving()));
        assertThat(dto.getParticipants().get(0).getMagicDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getMagicDamageDealt()));
        assertThat(dto.getParticipants().get(0).getMagicDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getMagicDamageDealtToChampions()));
        assertThat(dto.getParticipants().get(0).getMagicDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getMagicDamageTaken()));
        assertThat(dto.getParticipants().get(0).getNeutralMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getNeutralMinionsKilled()));
        assertThat(dto.getParticipants().get(0).getNexusKills()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getNexusKills()));
        assertThat(dto.getParticipants().get(0).getNexusLost()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getNexusLost()));
        assertThat(dto.getParticipants().get(0).getNexusTakedowns()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getNexusTakedowns()));
        assertThat(dto.getParticipants().get(0).getObjectivesStolen()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getObjectivesStolen()));
        assertThat(dto.getParticipants().get(0).getObjectivesStolenAssists()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getObjectivesStolenAssists()));
        assertThat(dto.getParticipants().get(0).getPentaKills()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getPentaKills()));
        assertThat(dto.getParticipants().get(0).getPhysicalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getPhysicalDamageDealt()));
        assertThat(dto.getParticipants().get(0).getPhysicalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getPhysicalDamageDealtToChampions()));
        assertThat(dto.getParticipants().get(0).getPhysicalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getPhysicalDamageTaken()));
        assertThat(dto.getParticipants().get(0).getProfileIcon()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getProfileIcon()));
        assertThat(dto.getParticipants().get(0).getQuadraKills()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getQuadraKills()));
        assertThat(dto.getParticipants().get(0).getRiotIdName()).isEqualTo(
                matchParticipantDtoList.get(0).getRiotIdName());
        assertThat(dto.getParticipants().get(0).getRiotIdTagline()).isEqualTo(
                matchParticipantDtoList.get(0).getRiotIdTagline());
        assertThat(dto.getParticipants().get(0).getRole()).isEqualTo(
                matchParticipantDtoList.get(0).getRole());
        assertThat(dto.getParticipants().get(0).getSightWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getSightWardsBoughtInGame()));
        assertThat(dto.getParticipants().get(0).getSpell1Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getSpell1Casts()));
        assertThat(dto.getParticipants().get(0).getSpell2Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getSpell2Casts()));
        assertThat(dto.getParticipants().get(0).getSpell3Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getSpell3Casts()));
        assertThat(dto.getParticipants().get(0).getSpell4Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getSpell4Casts()));
        assertThat(dto.getParticipants().get(0).getSummoner1Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getSummoner1Casts()));
        assertThat(dto.getParticipants().get(0).getSummoner1Id()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getSummoner1Id()));
        assertThat(dto.getParticipants().get(0).getSummoner2Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getSummoner2Casts()));
        assertThat(dto.getParticipants().get(0).getSummoner2Id()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getSummoner2Id()));
        assertThat(dto.getParticipants().get(0).getSummonerId()).isEqualTo(
                matchParticipantDtoList.get(0).getSummonerId());
        assertThat(dto.getParticipants().get(0).getSummonerLevel()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getSummonerLevel()));
        assertThat(dto.getParticipants().get(0).getSummonerName()).isEqualTo(
                matchParticipantDtoList.get(0).getPuuid().equals("BOT")
                        ? "(봇)" : matchParticipantDtoList.get(0).getSummonerName());
        assertThat(dto.getParticipants().get(0).getTeamEarlySurrendered()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTeamEarlySurrendered()));
        assertThat(dto.getParticipants().get(0).getTeamId()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTeamId()));
        assertThat(dto.getParticipants().get(0).getTeamPosition()).isEqualTo(
                matchParticipantDtoList.get(0).getTeamPosition());
        assertThat(dto.getParticipants().get(0).getTimeCCingOthers()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTimeCCingOthers()));
        assertThat(dto.getParticipants().get(0).getTimePlayed()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTimePlayed()));
        assertThat(dto.getParticipants().get(0).getTotalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTotalDamageDealt()));
        assertThat(dto.getParticipants().get(0).getTotalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTotalDamageDealtToChampions()));
        assertThat(dto.getParticipants().get(0).getTotalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTotalDamageTaken()));
        assertThat(dto.getParticipants().get(0).getTotalHeal()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTotalHeal()));
        assertThat(dto.getParticipants().get(0).getTotalHealsOnTeammates()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTotalHealsOnTeammates()));
        assertThat(dto.getParticipants().get(0).getTotalMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTotalMinionsKilled()));
        assertThat(dto.getParticipants().get(0).getTotalTimeCCDealt()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTotalTimeCCDealt()));
        assertThat(dto.getParticipants().get(0).getTotalTimeSpentDead()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTotalTimeSpentDead()));
        assertThat(dto.getParticipants().get(0).getTotalUnitsHealed()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTotalUnitsHealed()));
        assertThat(dto.getParticipants().get(0).getTripleKills()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTripleKills()));
        assertThat(dto.getParticipants().get(0).getTrueDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTrueDamageDealt()));
        assertThat(dto.getParticipants().get(0).getTrueDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTrueDamageDealtToChampions()));
        assertThat(dto.getParticipants().get(0).getTrueDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTrueDamageTaken()));
        assertThat(dto.getParticipants().get(0).getTurretKills()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTurretKills()));
        assertThat(dto.getParticipants().get(0).getTurretTakedowns()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTurretTakedowns()));
        assertThat(dto.getParticipants().get(0).getTurretsLost()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getTurretsLost()));
        assertThat(dto.getParticipants().get(0).getUnrealKills()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getUnrealKills()));
        assertThat(dto.getParticipants().get(0).getVisionScore()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getVisionScore()));
        assertThat(dto.getParticipants().get(0).getVisionWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getVisionWardsBoughtInGame()));
        assertThat(dto.getParticipants().get(0).getWardsKilled()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getWardsKilled()));
        assertThat(dto.getParticipants().get(0).getWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getWardsPlaced()));
        assertThat(dto.getParticipants().get(0).getWin()).isEqualTo(
                String.valueOf(matchParticipantDtoList.get(0).getWin()));
        assertThat(dto.getParticipants().get(0).getRrt()).isEqualTo(
                matchParticipantDtoList.get(0).getRrt());
        assertThat(dto.getParticipants().get(0).getMultiKills()).isEqualTo(
                matchParticipantDtoList.get(0).getMultiKills());
        assertThat(dto.getParticipants().get(0).getKda()).isEqualTo(
                matchParticipantDtoList.get(0).getKda());
        assertThat(dto.getParticipants().get(0).getMinionsKilledPerMin()).isEqualTo(
                matchParticipantDtoList.get(0).getMinionsKilledPerMin());
    }

    @Test
    @DisplayName("Setter")
    void setter() {
        // given
        MatchTeamDto dto = new MatchTeamDto(matchBanDtoList, matchObjectivesDto, "100", "true", 10, matchParticipantDtoList);
        List<MatchParticipantDto> matchParticipantDtoListForSet = createTestParticipantDtoForSetTest();

        // when
        dto.getBans().get(0).setChampionId(220);
        dto.getBans().get(0).setPickTurn(2);
        dto.getBans().get(1).setChampionId(2);
        dto.getBans().get(1).setPickTurn(3);
        dto.getBans().get(2).setChampionId(199);
        dto.getBans().get(2).setPickTurn(4);
        dto.getBans().get(3).setChampionId(50);
        dto.getBans().get(3).setPickTurn(5);
        dto.getBans().get(4).setChampionId(8);
        dto.getBans().get(4).setPickTurn(1);

        dto.getObjectives().getBaron().setFirst(false);
        dto.getObjectives().getBaron().setKills(3);
        dto.getObjectives().getChampion().setFirst(true);
        dto.getObjectives().getChampion().setKills(41);
        dto.getObjectives().getDragon().setFirst(true);
        dto.getObjectives().getDragon().setKills(2);
        dto.getObjectives().getInhibitor().setFirst(false);
        dto.getObjectives().getInhibitor().setKills(2);
        dto.getObjectives().getRiftHeraId().setFirst(true);
        dto.getObjectives().getRiftHeraId().setKills(1);
        dto.getObjectives().getTower().setFirst(true);
        dto.getObjectives().getTower().setKills(0);

        dto.setTeamId("200");
        dto.setWin("false");

        dto.setParticipants(matchParticipantDtoListForSet);

        // then
        assertThat(dto.getBans().get(0).getChampionId()).isEqualTo(220);
        assertThat(dto.getBans().get(0).getPickTurn()).isEqualTo(2);
        assertThat(dto.getBans().get(1).getChampionId()).isEqualTo(2);
        assertThat(dto.getBans().get(1).getPickTurn()).isEqualTo(3);
        assertThat(dto.getBans().get(2).getChampionId()).isEqualTo(199);
        assertThat(dto.getBans().get(2).getPickTurn()).isEqualTo(4);
        assertThat(dto.getBans().get(3).getChampionId()).isEqualTo(50);
        assertThat(dto.getBans().get(3).getPickTurn()).isEqualTo(5);
        assertThat(dto.getBans().get(4).getChampionId()).isEqualTo(8);
        assertThat(dto.getBans().get(4).getPickTurn()).isEqualTo(1);

        assertThat(dto.getObjectives().getBaron().isFirst()).isFalse();
        assertThat(dto.getObjectives().getBaron().getKills()).isEqualTo(3);
        assertThat(dto.getObjectives().getChampion().isFirst()).isTrue();
        assertThat(dto.getObjectives().getChampion().getKills()).isEqualTo(41);
        assertThat(dto.getObjectives().getDragon().isFirst()).isTrue();
        assertThat(dto.getObjectives().getDragon().getKills()).isEqualTo(2);
        assertThat(dto.getObjectives().getInhibitor().isFirst()).isFalse();
        assertThat(dto.getObjectives().getInhibitor().getKills()).isEqualTo(2);
        assertThat(dto.getObjectives().getRiftHeraId().isFirst()).isTrue();
        assertThat(dto.getObjectives().getRiftHeraId().getKills()).isEqualTo(1);
        assertThat(dto.getObjectives().getTower().isFirst()).isTrue();
        assertThat(dto.getObjectives().getTower().getKills()).isEqualTo(0);

        assertThat(dto.getTeamId()).isEqualTo("200");
        assertThat(dto.getWin()).isEqualTo("false");

        assertThat(dto.getParticipants().get(0).getPuuid()).isEqualTo(matchParticipantDtoListForSet.get(0).getPuuid());
        assertThat(dto.getParticipants().get(0).getDataVersion()).isEqualTo(matchParticipantDtoListForSet.get(0).getDataVersion());
        assertThat(dto.getParticipants().get(0).getMatchId()).isEqualTo(matchParticipantDtoListForSet.get(0).getMatchId());
        assertThat(dto.getParticipants().get(0).getParticipantId()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getParticipantId()));
        assertThat(dto.getParticipants().get(0).getAssists()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getAssists()));
        assertThat(dto.getParticipants().get(0).getBaronKills()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getBaronKills()));
        assertThat(dto.getParticipants().get(0).getBountyLevel()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getBountyLevel()));
        assertThat(dto.getParticipants().get(0).getChampExperience()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getChampExperience()));
        assertThat(dto.getParticipants().get(0).getChampLevel()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getChampLevel()));
        assertThat(dto.getParticipants().get(0).getChampionId()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getChampionId()));
        assertThat(dto.getParticipants().get(0).getChampionName()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getChampionName()));
        assertThat(dto.getParticipants().get(0).getChampionNameKR()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getChampionNameKR()));
        assertThat(dto.getParticipants().get(0).getChampionImg()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getChampionImg()));
        assertThat(dto.getParticipants().get(0).getChampionTransform()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getChampionTransform()));
        assertThat(dto.getParticipants().get(0).getConsumablesPurchased()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getConsumablesPurchased()));
        assertThat(dto.getParticipants().get(0).getDamageDealtToBuildings()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getDamageDealtToBuildings()));
        assertThat(dto.getParticipants().get(0).getDamageDealtToObjectives()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getDamageDealtToObjectives()));
        assertThat(dto.getParticipants().get(0).getDamageSelfMitigated()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getDamageSelfMitigated()));
        assertThat(dto.getParticipants().get(0).getDeaths()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getDeaths()));
        assertThat(dto.getParticipants().get(0).getDetectorWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getDetectorWardsPlaced()));
        assertThat(dto.getParticipants().get(0).getDoubleKills()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getDoubleKills()));
        assertThat(dto.getParticipants().get(0).getDragonKills()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getDragonKills()));
        assertThat(dto.getParticipants().get(0).getFirstBloodAssist()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getFirstBloodAssist()));
        assertThat(dto.getParticipants().get(0).getFirstBloodKill()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getFirstBloodKill()));
        assertThat(dto.getParticipants().get(0).getFirstTowerAssist()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getFirstTowerAssist()));
        assertThat(dto.getParticipants().get(0).getFirstTowerKill()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getFirstTowerKill()));
        assertThat(dto.getParticipants().get(0).getGameEndedInEarlySurrender()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getGameEndedInEarlySurrender()));
        assertThat(dto.getParticipants().get(0).getGameEndedInSurrender()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getGameEndedInSurrender()));
        assertThat(dto.getParticipants().get(0).getGoldEarned()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getGoldEarned()));
        assertThat(dto.getParticipants().get(0).getGoldSpent()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getGoldSpent()));
        assertThat(dto.getParticipants().get(0).getIndividualPosition()).isEqualTo(
                matchParticipantDtoListForSet.get(0).getIndividualPosition());
        assertThat(dto.getParticipants().get(0).getInhibitorKills()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getInhibitorKills()));
        assertThat(dto.getParticipants().get(0).getInhibitorTakedowns()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getInhibitorTakedowns()));
        assertThat(dto.getParticipants().get(0).getInhibitorsLost()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getInhibitorsLost()));
        assertThat(dto.getParticipants().get(0).getItem0()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getItem0()));
        assertThat(dto.getParticipants().get(0).getItem1()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getItem1()));
        assertThat(dto.getParticipants().get(0).getItem2()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getItem2()));
        assertThat(dto.getParticipants().get(0).getItem3()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getItem3()));
        assertThat(dto.getParticipants().get(0).getItem4()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getItem4()));
        assertThat(dto.getParticipants().get(0).getItem5()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getItem5()));
        assertThat(dto.getParticipants().get(0).getItem6()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getItem6()));
        assertThat(dto.getParticipants().get(0).getItemsPurchased()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getItemsPurchased()));
        assertThat(dto.getParticipants().get(0).getKillingSprees()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getKillingSprees()));
        assertThat(dto.getParticipants().get(0).getKills()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getKills()));
        assertThat(dto.getParticipants().get(0).getLane()).isEqualTo(
                matchParticipantDtoListForSet.get(0).getLane());
        assertThat(dto.getParticipants().get(0).getLargestCriticalStrike()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getLargestCriticalStrike()));
        assertThat(dto.getParticipants().get(0).getLargestKillingSpree()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getLargestKillingSpree()));
        assertThat(dto.getParticipants().get(0).getLongestTimeSpentLiving()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getLongestTimeSpentLiving()));
        assertThat(dto.getParticipants().get(0).getMagicDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getMagicDamageDealt()));
        assertThat(dto.getParticipants().get(0).getMagicDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getMagicDamageDealtToChampions()));
        assertThat(dto.getParticipants().get(0).getMagicDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getMagicDamageTaken()));
        assertThat(dto.getParticipants().get(0).getNeutralMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getNeutralMinionsKilled()));
        assertThat(dto.getParticipants().get(0).getNexusKills()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getNexusKills()));
        assertThat(dto.getParticipants().get(0).getNexusLost()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getNexusLost()));
        assertThat(dto.getParticipants().get(0).getNexusTakedowns()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getNexusTakedowns()));
        assertThat(dto.getParticipants().get(0).getObjectivesStolen()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getObjectivesStolen()));
        assertThat(dto.getParticipants().get(0).getObjectivesStolenAssists()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getObjectivesStolenAssists()));
        assertThat(dto.getParticipants().get(0).getPentaKills()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getPentaKills()));
        assertThat(dto.getParticipants().get(0).getPhysicalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getPhysicalDamageDealt()));
        assertThat(dto.getParticipants().get(0).getPhysicalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getPhysicalDamageDealtToChampions()));
        assertThat(dto.getParticipants().get(0).getPhysicalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getPhysicalDamageTaken()));
        assertThat(dto.getParticipants().get(0).getProfileIcon()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getProfileIcon()));
        assertThat(dto.getParticipants().get(0).getQuadraKills()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getQuadraKills()));
        assertThat(dto.getParticipants().get(0).getRiotIdName()).isEqualTo(
                matchParticipantDtoListForSet.get(0).getRiotIdName());
        assertThat(dto.getParticipants().get(0).getRiotIdTagline()).isEqualTo(
                matchParticipantDtoListForSet.get(0).getRiotIdTagline());
        assertThat(dto.getParticipants().get(0).getRole()).isEqualTo(
                matchParticipantDtoListForSet.get(0).getRole());
        assertThat(dto.getParticipants().get(0).getSightWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getSightWardsBoughtInGame()));
        assertThat(dto.getParticipants().get(0).getSpell1Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getSpell1Casts()));
        assertThat(dto.getParticipants().get(0).getSpell2Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getSpell2Casts()));
        assertThat(dto.getParticipants().get(0).getSpell3Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getSpell3Casts()));
        assertThat(dto.getParticipants().get(0).getSpell4Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getSpell4Casts()));
        assertThat(dto.getParticipants().get(0).getSummoner1Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getSummoner1Casts()));
        assertThat(dto.getParticipants().get(0).getSummoner1Id()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getSummoner1Id()));
        assertThat(dto.getParticipants().get(0).getSummoner2Casts()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getSummoner2Casts()));
        assertThat(dto.getParticipants().get(0).getSummoner2Id()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getSummoner2Id()));
        assertThat(dto.getParticipants().get(0).getSummonerId()).isEqualTo(
                matchParticipantDtoListForSet.get(0).getSummonerId());
        assertThat(dto.getParticipants().get(0).getSummonerLevel()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getSummonerLevel()));
        assertThat(dto.getParticipants().get(0).getSummonerName()).isEqualTo(
                matchParticipantDtoListForSet.get(0).getSummonerName());
        assertThat(dto.getParticipants().get(0).getTeamEarlySurrendered()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTeamEarlySurrendered()));
        assertThat(dto.getParticipants().get(0).getTeamId()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTeamId()));
        assertThat(dto.getParticipants().get(0).getTeamPosition()).isEqualTo(
                matchParticipantDtoListForSet.get(0).getTeamPosition());
        assertThat(dto.getParticipants().get(0).getTimeCCingOthers()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTimeCCingOthers()));
        assertThat(dto.getParticipants().get(0).getTimePlayed()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTimePlayed()));
        assertThat(dto.getParticipants().get(0).getTotalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTotalDamageDealt()));
        assertThat(dto.getParticipants().get(0).getTotalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTotalDamageDealtToChampions()));
        assertThat(dto.getParticipants().get(0).getTotalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTotalDamageTaken()));
        assertThat(dto.getParticipants().get(0).getTotalHeal()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTotalHeal()));
        assertThat(dto.getParticipants().get(0).getTotalHealsOnTeammates()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTotalHealsOnTeammates()));
        assertThat(dto.getParticipants().get(0).getTotalMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTotalMinionsKilled()));
        assertThat(dto.getParticipants().get(0).getTotalTimeCCDealt()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTotalTimeCCDealt()));
        assertThat(dto.getParticipants().get(0).getTotalTimeSpentDead()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTotalTimeSpentDead()));
        assertThat(dto.getParticipants().get(0).getTotalUnitsHealed()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTotalUnitsHealed()));
        assertThat(dto.getParticipants().get(0).getTripleKills()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTripleKills()));
        assertThat(dto.getParticipants().get(0).getTrueDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTrueDamageDealt()));
        assertThat(dto.getParticipants().get(0).getTrueDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTrueDamageDealtToChampions()));
        assertThat(dto.getParticipants().get(0).getTrueDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTrueDamageTaken()));
        assertThat(dto.getParticipants().get(0).getTurretKills()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTurretKills()));
        assertThat(dto.getParticipants().get(0).getTurretTakedowns()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTurretTakedowns()));
        assertThat(dto.getParticipants().get(0).getTurretsLost()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getTurretsLost()));
        assertThat(dto.getParticipants().get(0).getUnrealKills()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getUnrealKills()));
        assertThat(dto.getParticipants().get(0).getVisionScore()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getVisionScore()));
        assertThat(dto.getParticipants().get(0).getVisionWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getVisionWardsBoughtInGame()));
        assertThat(dto.getParticipants().get(0).getWardsKilled()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getWardsKilled()));
        assertThat(dto.getParticipants().get(0).getWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getWardsPlaced()));
        assertThat(dto.getParticipants().get(0).getWin()).isEqualTo(
                String.valueOf(matchParticipantDtoListForSet.get(0).getWin()));
        assertThat(dto.getParticipants().get(0).getRrt()).isEqualTo(
                matchParticipantDtoListForSet.get(0).getRrt());
        assertThat(dto.getParticipants().get(0).getPerks()).isEqualTo(matchParticipantDtoListForSet.get(0).getPerks());
        assertThat(dto.getParticipants().get(0).getMultiKills()).isEqualTo(matchParticipantDtoListForSet.get(0).getMultiKills());
        assertThat(dto.getParticipants().get(0).getKda()).isEqualTo(matchParticipantDtoListForSet.get(0).getKda());
        assertThat(dto.getParticipants().get(0).getMinionsKilledPerMin()).isEqualTo(matchParticipantDtoListForSet.get(0).getMinionsKilledPerMin());
    }

    private List<MatchBanDto> createTestMatchBanDtoList() {
        List<MatchBanDto> list = new ArrayList<>();
        list.add(new MatchBanDto("KR_5976412008", 1, 100, 221));
        list.add(new MatchBanDto("KR_5976412008", 2, 100, -1));
        list.add(new MatchBanDto("KR_5976412008", 3, 100, 200));
        list.add(new MatchBanDto("KR_5976412008", 4, 100, 55));
        list.add(new MatchBanDto("KR_5976412008", 5, 100, 10));
        return list;
    }

    private MatchObjectivesDto createTestObjectivesDto() {
        return new MatchObjectivesDto(
                new MatchObjectiveDto(true, 2),
                new MatchObjectiveDto(false, 40),
                new MatchObjectiveDto(false, 1),
                new MatchObjectiveDto(true, 1),
                new MatchObjectiveDto(false, 0),
                new MatchObjectiveDto(false, 11)
                );
    }

    private List<MatchParticipantDto> createTestParticipantDtoList() {
        List<MatchParticipantDto> matchParticipantDtos = new ArrayList<>();

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
        MatchParticipantDto dto = new MatchParticipantDto(
                puuid,
                dataVersion,
                matchId,
                participantId,
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

        dto.setPerks(matchPerksDto);
        matchParticipantDtos.add(dto);

        return matchParticipantDtos;
    }

    private List<MatchParticipantDto> createTestParticipantDtoForSetTest() {
        List<MatchParticipantDto> matchParticipantDtos = new ArrayList<>();

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

        MatchParticipantDto dto = new MatchParticipantDto(
                puuid,
                dataVersion,
                matchId,
                participantId,
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

        dto.setPerks(matchPerksDto);
        matchParticipantDtos.add(dto);

        return matchParticipantDtos;
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

    private MatchPerksDto createPerksDto() {
        return new MatchPerksDto();
    }
}