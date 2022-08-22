package dev.saariselka.inlol.vo;

import dev.saariselka.inlol.dto.MatchParticipantDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTeamVOTest {
    @Test
    @DisplayName("Constructor")
    void constructor() {
        // given
        List<MatchBanVO> bans = createMatchBanVOList();
        MatchObjectivesVO objectives = createMatchObjectivesVO();
        String teamId = "100";
        String win = "true";
        int teamKills = 10;
        MatchParticipantVO matchParticipantVO = createMatchParticipantVO();
        List<MatchParticipantVO> participants = new ArrayList<>();
        participants.add(matchParticipantVO);

        // when
        MatchTeamVO vo = new MatchTeamVO(bans, objectives, teamId, win, teamKills, participants);

        // then
        assertThat(vo.getBans().get(0).getMatchId()).isEqualTo("KR_5804413147");
        assertThat(vo.getBans().get(0).getPickTurn()).isEqualTo(1);
        assertThat(vo.getBans().get(0).getTeamId()).isEqualTo(100);
        assertThat(vo.getBans().get(0).getChampionId()).isEqualTo(99);
        assertThat(vo.getObjectives().getBaron().isFirst()).isTrue();
        assertThat(vo.getObjectives().getBaron().getKills()).isEqualTo(1);
        assertThat(vo.getObjectives().getChampion().isFirst()).isFalse();
        assertThat(vo.getObjectives().getChampion().getKills()).isEqualTo(2);
        assertThat(vo.getObjectives().getDragon().isFirst()).isTrue();
        assertThat(vo.getObjectives().getDragon().getKills()).isEqualTo(3);
        assertThat(vo.getObjectives().getInhibitor().isFirst()).isFalse();
        assertThat(vo.getObjectives().getInhibitor().getKills()).isEqualTo(4);
        assertThat(vo.getObjectives().getRiftHeraId().isFirst()).isTrue();
        assertThat(vo.getObjectives().getRiftHeraId().getKills()).isEqualTo(5);
        assertThat(vo.getObjectives().getTower().isFirst()).isFalse();
        assertThat(vo.getObjectives().getTower().getKills()).isEqualTo(6);
        assertThat(vo.getTeamId()).isEqualTo("100");
        assertThat(vo.getWin()).isEqualTo("true");
        assertThat(vo.getTeamKills()).isEqualTo(10);

        assertThat(vo.getParticipants().get(0).getPuuid()).isEqualTo(matchParticipantVO.getPuuid());
        assertThat(vo.getParticipants().get(0).getDataVersion()).isEqualTo(matchParticipantVO.getDataVersion());
        assertThat(vo.getParticipants().get(0).getMatchId()).isEqualTo(matchParticipantVO.getMatchId());
        assertThat(vo.getParticipants().get(0).getParticipantId()).isEqualTo(matchParticipantVO.getParticipantId());
        assertThat(vo.getParticipants().get(0).getAssists()).isEqualTo(matchParticipantVO.getAssists());
        assertThat(vo.getParticipants().get(0).getBaronKills()).isEqualTo(matchParticipantVO.getBaronKills());
        assertThat(vo.getParticipants().get(0).getBountyLevel()).isEqualTo(matchParticipantVO.getBountyLevel());
        assertThat(vo.getParticipants().get(0).getChampExperience()).isEqualTo(matchParticipantVO.getChampExperience());
        assertThat(vo.getParticipants().get(0).getChampLevel()).isEqualTo(matchParticipantVO.getChampLevel());
        assertThat(vo.getParticipants().get(0).getChampionId()).isEqualTo(matchParticipantVO.getChampionId());
        assertThat(vo.getParticipants().get(0).getChampionName()).isEqualTo(matchParticipantVO.getChampionName());
        assertThat(vo.getParticipants().get(0).getChampionNameKR()).isEqualTo(matchParticipantVO.getChampionNameKR());
        assertThat(vo.getParticipants().get(0).getChampionImg()).isEqualTo(matchParticipantVO.getChampionImg());
        assertThat(vo.getParticipants().get(0).getChampionTransform()).isEqualTo(matchParticipantVO.getChampionTransform());
        assertThat(vo.getParticipants().get(0).getConsumablesPurchased()).isEqualTo(matchParticipantVO.getConsumablesPurchased());
        assertThat(vo.getParticipants().get(0).getDamageDealtToBuildings()).isEqualTo(
                matchParticipantVO.getDamageDealtToBuildings());
        assertThat(vo.getParticipants().get(0).getDamageDealtToObjectives()).isEqualTo(
                matchParticipantVO.getDamageDealtToObjectives());
        assertThat(vo.getParticipants().get(0).getDamageSelfMitigated()).isEqualTo(
                matchParticipantVO.getDamageSelfMitigated());
        assertThat(vo.getParticipants().get(0).getDeaths()).isEqualTo(
                matchParticipantVO.getDeaths());
        assertThat(vo.getParticipants().get(0).getDetectorWardsPlaced()).isEqualTo(
                matchParticipantVO.getDetectorWardsPlaced());
        assertThat(vo.getParticipants().get(0).getDoubleKills()).isEqualTo(
                matchParticipantVO.getDoubleKills());
        assertThat(vo.getParticipants().get(0).getDragonKills()).isEqualTo(
                matchParticipantVO.getDragonKills());
        assertThat(vo.getParticipants().get(0).isFirstBloodAssist()).isEqualTo(
                matchParticipantVO.isFirstBloodAssist());
        assertThat(vo.getParticipants().get(0).isFirstBloodKill()).isEqualTo(
                matchParticipantVO.isFirstBloodKill());
        assertThat(vo.getParticipants().get(0).isFirstTowerAssist()).isEqualTo(
                matchParticipantVO.isFirstTowerAssist());
        assertThat(vo.getParticipants().get(0).isFirstTowerKill()).isEqualTo(
                matchParticipantVO.isFirstTowerKill());
        assertThat(vo.getParticipants().get(0).isGameEndedInEarlySurrender()).isEqualTo(
                matchParticipantVO.isGameEndedInEarlySurrender());
        assertThat(vo.getParticipants().get(0).isGameEndedInSurrender()).isEqualTo(
                matchParticipantVO.isGameEndedInSurrender());
        assertThat(vo.getParticipants().get(0).getGoldEarned()).isEqualTo(
                matchParticipantVO.getGoldEarned());
        assertThat(vo.getParticipants().get(0).getGoldSpent()).isEqualTo(
                matchParticipantVO.getGoldSpent());
        assertThat(vo.getParticipants().get(0).getIndividualPosition()).isEqualTo(
                matchParticipantVO.getIndividualPosition());
        assertThat(vo.getParticipants().get(0).getInhibitorKills()).isEqualTo(
                matchParticipantVO.getInhibitorKills());
        assertThat(vo.getParticipants().get(0).getInhibitorTakedowns()).isEqualTo(
                matchParticipantVO.getInhibitorTakedowns());
        assertThat(vo.getParticipants().get(0).getInhibitorsLost()).isEqualTo(
                matchParticipantVO.getInhibitorsLost());
        assertThat(vo.getParticipants().get(0).getItem0()).isEqualTo(
                matchParticipantVO.getItem0());
        assertThat(vo.getParticipants().get(0).getItem1()).isEqualTo(
                matchParticipantVO.getItem1());
        assertThat(vo.getParticipants().get(0).getItem2()).isEqualTo(
                matchParticipantVO.getItem2());
        assertThat(vo.getParticipants().get(0).getItem3()).isEqualTo(
                matchParticipantVO.getItem3());
        assertThat(vo.getParticipants().get(0).getItem4()).isEqualTo(
                matchParticipantVO.getItem4());
        assertThat(vo.getParticipants().get(0).getItem5()).isEqualTo(
                matchParticipantVO.getItem5());
        assertThat(vo.getParticipants().get(0).getItem6()).isEqualTo(
                matchParticipantVO.getItem6());
        assertThat(vo.getParticipants().get(0).getItemsPurchased()).isEqualTo(
                matchParticipantVO.getItemsPurchased());
        assertThat(vo.getParticipants().get(0).getKillingSprees()).isEqualTo(
                matchParticipantVO.getKillingSprees());
        assertThat(vo.getParticipants().get(0).getKills()).isEqualTo(
                matchParticipantVO.getKills());
        assertThat(vo.getParticipants().get(0).getLane()).isEqualTo(
                matchParticipantVO.getLane());
        assertThat(vo.getParticipants().get(0).getLargestCriticalStrike()).isEqualTo(
                matchParticipantVO.getLargestCriticalStrike());
        assertThat(vo.getParticipants().get(0).getLargestKillingSpree()).isEqualTo(
                matchParticipantVO.getLargestKillingSpree());
        assertThat(vo.getParticipants().get(0).getLongestTimeSpentLiving()).isEqualTo(
                matchParticipantVO.getLongestTimeSpentLiving());
        assertThat(vo.getParticipants().get(0).getMagicDamageDealt()).isEqualTo(
                matchParticipantVO.getMagicDamageDealt());
        assertThat(vo.getParticipants().get(0).getMagicDamageDealtToChampions()).isEqualTo(
                matchParticipantVO.getMagicDamageDealtToChampions());
        assertThat(vo.getParticipants().get(0).getMagicDamageTaken()).isEqualTo(
                matchParticipantVO.getMagicDamageTaken());
        assertThat(vo.getParticipants().get(0).getNeutralMinionsKilled()).isEqualTo(
                matchParticipantVO.getNeutralMinionsKilled());
        assertThat(vo.getParticipants().get(0).getNexusKills()).isEqualTo(
                matchParticipantVO.getNexusKills());
        assertThat(vo.getParticipants().get(0).getNexusLost()).isEqualTo(
                matchParticipantVO.getNexusLost());
        assertThat(vo.getParticipants().get(0).getNexusTakedowns()).isEqualTo(
                matchParticipantVO.getNexusTakedowns());
        assertThat(vo.getParticipants().get(0).getObjectivesStolen()).isEqualTo(
                matchParticipantVO.getObjectivesStolen());
        assertThat(vo.getParticipants().get(0).getObjectivesStolenAssists()).isEqualTo(
                matchParticipantVO.getObjectivesStolenAssists());
        assertThat(vo.getParticipants().get(0).getPentaKills()).isEqualTo(
                matchParticipantVO.getPentaKills());
        assertThat(vo.getParticipants().get(0).getPhysicalDamageDealt()).isEqualTo(
                matchParticipantVO.getPhysicalDamageDealt());
        assertThat(vo.getParticipants().get(0).getPhysicalDamageDealtToChampions()).isEqualTo(
                matchParticipantVO.getPhysicalDamageDealtToChampions());
        assertThat(vo.getParticipants().get(0).getPhysicalDamageTaken()).isEqualTo(
                matchParticipantVO.getPhysicalDamageTaken());
        assertThat(vo.getParticipants().get(0).getProfileIcon()).isEqualTo(
                matchParticipantVO.getProfileIcon());
        assertThat(vo.getParticipants().get(0).getQuadraKills()).isEqualTo(
                matchParticipantVO.getQuadraKills());
        assertThat(vo.getParticipants().get(0).getRiotIdName()).isEqualTo(
                matchParticipantVO.getRiotIdName());
        assertThat(vo.getParticipants().get(0).getRiotIdTagline()).isEqualTo(
                matchParticipantVO.getRiotIdTagline());
        assertThat(vo.getParticipants().get(0).getRole()).isEqualTo(
                matchParticipantVO.getRole());
        assertThat(vo.getParticipants().get(0).getSightWardsBoughtInGame()).isEqualTo(
                matchParticipantVO.getSightWardsBoughtInGame());
        assertThat(vo.getParticipants().get(0).getSpell1Casts()).isEqualTo(
                matchParticipantVO.getSpell1Casts());
        assertThat(vo.getParticipants().get(0).getSpell2Casts()).isEqualTo(
                matchParticipantVO.getSpell2Casts());
        assertThat(vo.getParticipants().get(0).getSpell3Casts()).isEqualTo(
                matchParticipantVO.getSpell3Casts());
        assertThat(vo.getParticipants().get(0).getSpell4Casts()).isEqualTo(
                matchParticipantVO.getSpell4Casts());
        assertThat(vo.getParticipants().get(0).getSummoner1Casts()).isEqualTo(
                matchParticipantVO.getSummoner1Casts());
        assertThat(vo.getParticipants().get(0).getSummoner1Id()).isEqualTo(
                matchParticipantVO.getSummoner1Id());
        assertThat(vo.getParticipants().get(0).getSummoner2Casts()).isEqualTo(
                matchParticipantVO.getSummoner2Casts());
        assertThat(vo.getParticipants().get(0).getSummoner2Id()).isEqualTo(
                matchParticipantVO.getSummoner2Id());
        assertThat(vo.getParticipants().get(0).getSummonerId()).isEqualTo(
                matchParticipantVO.getSummonerId());
        assertThat(vo.getParticipants().get(0).getSummonerLevel()).isEqualTo(
                matchParticipantVO.getSummonerLevel());
        assertThat(vo.getParticipants().get(0).getSummonerName()).isEqualTo(
                matchParticipantVO.getPuuid().equals("BOT")
                        ? "(봇)" : vo.getParticipants().get(0).getSummonerName());
        assertThat(vo.getParticipants().get(0).isTeamEarlySurrendered()).isEqualTo(
                matchParticipantVO.isTeamEarlySurrendered());
        assertThat(vo.getParticipants().get(0).getTeamId()).isEqualTo(
                matchParticipantVO.getTeamId());
        assertThat(vo.getParticipants().get(0).getTeamPosition()).isEqualTo(
                matchParticipantVO.getTeamPosition());
        assertThat(vo.getParticipants().get(0).getTimeCCingOthers()).isEqualTo(
                matchParticipantVO.getTimeCCingOthers());
        assertThat(vo.getParticipants().get(0).getTimePlayed()).isEqualTo(
                matchParticipantVO.getTimePlayed());
        assertThat(vo.getParticipants().get(0).getTotalDamageDealt()).isEqualTo(
                matchParticipantVO.getTotalDamageDealt());
        assertThat(vo.getParticipants().get(0).getTotalDamageDealtToChampions()).isEqualTo(
                matchParticipantVO.getTotalDamageDealtToChampions());
        assertThat(vo.getParticipants().get(0).getTotalDamageTaken()).isEqualTo(
                matchParticipantVO.getTotalDamageTaken());
        assertThat(vo.getParticipants().get(0).getTotalHeal()).isEqualTo(
                matchParticipantVO.getTotalHeal());
        assertThat(vo.getParticipants().get(0).getTotalHealsOnTeammates()).isEqualTo(
                matchParticipantVO.getTotalHealsOnTeammates());
        assertThat(vo.getParticipants().get(0).getTotalMinionsKilled()).isEqualTo(
                matchParticipantVO.getTotalMinionsKilled());
        assertThat(vo.getParticipants().get(0).getTotalTimeCCDealt()).isEqualTo(
                matchParticipantVO.getTotalTimeCCDealt());
        assertThat(vo.getParticipants().get(0).getTotalTimeSpentDead()).isEqualTo(
                matchParticipantVO.getTotalTimeSpentDead());
        assertThat(vo.getParticipants().get(0).getTotalUnitsHealed()).isEqualTo(
                matchParticipantVO.getTotalUnitsHealed());
        assertThat(vo.getParticipants().get(0).getTripleKills()).isEqualTo(
                matchParticipantVO.getTripleKills());
        assertThat(vo.getParticipants().get(0).getTrueDamageDealt()).isEqualTo(
                matchParticipantVO.getTrueDamageDealt());
        assertThat(vo.getParticipants().get(0).getTrueDamageDealtToChampions()).isEqualTo(
                matchParticipantVO.getTrueDamageDealtToChampions());
        assertThat(vo.getParticipants().get(0).getTrueDamageTaken()).isEqualTo(
                matchParticipantVO.getTrueDamageTaken());
        assertThat(vo.getParticipants().get(0).getTurretKills()).isEqualTo(
                matchParticipantVO.getTurretKills());
        assertThat(vo.getParticipants().get(0).getTurretTakedowns()).isEqualTo(
                matchParticipantVO.getTurretTakedowns());
        assertThat(vo.getParticipants().get(0).getTurretsLost()).isEqualTo(
                matchParticipantVO.getTurretsLost());
        assertThat(vo.getParticipants().get(0).getUnrealKills()).isEqualTo(
                matchParticipantVO.getUnrealKills());
        assertThat(vo.getParticipants().get(0).getVisionScore()).isEqualTo(
                matchParticipantVO.getVisionScore());
        assertThat(vo.getParticipants().get(0).getVisionWardsBoughtInGame()).isEqualTo(
                matchParticipantVO.getVisionWardsBoughtInGame());
        assertThat(vo.getParticipants().get(0).getWardsKilled()).isEqualTo(
                matchParticipantVO.getWardsKilled());
        assertThat(vo.getParticipants().get(0).getWardsPlaced()).isEqualTo(
                matchParticipantVO.getWardsPlaced());
        assertThat(vo.getParticipants().get(0).isWin()).isEqualTo(
                matchParticipantVO.isWin());
        assertThat(vo.getParticipants().get(0).getRrt()).isEqualTo(
                matchParticipantVO.getRrt());

        // TODO
//        assertThat(vo.getParticipants().get(0).getMultiKills()).isEqualTo(
//                matchParticipantVO.getMultiKills());
//        assertThat(vo.getParticipants().get(0).getKda()).isEqualTo(
//                matchParticipantVO.getKda());
//        assertThat(vo.getParticipants().get(0).getMinionsKilledPerMin()).isEqualTo(
//                matchParticipantVO.getMinionsKilledPerMin());

    }

    @Test
    @DisplayName("Setter")
    void setter() {
        // given
        MatchTeamVO vo = new MatchTeamVO();
        MatchParticipantVO matchParticipantVO = createMatchParticipantVO();
        List<MatchParticipantVO> participants = new ArrayList<>();
        participants.add(matchParticipantVO);

        // when
        vo.setBans(createMatchBanVOList());
        vo.setObjectives(createMatchObjectivesVO());
        vo.setTeamId("100");
        vo.setWin("true");
        vo.setTeamKills(10);
        vo.setParticipants(participants);

        // then
        assertThat(vo.getBans().get(0).getMatchId()).isEqualTo("KR_5804413147");
        assertThat(vo.getBans().get(0).getPickTurn()).isEqualTo(1);
        assertThat(vo.getBans().get(0).getTeamId()).isEqualTo(100);
        assertThat(vo.getBans().get(0).getChampionId()).isEqualTo(99);
        assertThat(vo.getObjectives().getBaron().isFirst()).isTrue();
        assertThat(vo.getObjectives().getBaron().getKills()).isEqualTo(1);
        assertThat(vo.getObjectives().getChampion().isFirst()).isFalse();
        assertThat(vo.getObjectives().getChampion().getKills()).isEqualTo(2);
        assertThat(vo.getObjectives().getDragon().isFirst()).isTrue();
        assertThat(vo.getObjectives().getDragon().getKills()).isEqualTo(3);
        assertThat(vo.getObjectives().getInhibitor().isFirst()).isFalse();
        assertThat(vo.getObjectives().getInhibitor().getKills()).isEqualTo(4);
        assertThat(vo.getObjectives().getRiftHeraId().isFirst()).isTrue();
        assertThat(vo.getObjectives().getRiftHeraId().getKills()).isEqualTo(5);
        assertThat(vo.getObjectives().getTower().isFirst()).isFalse();
        assertThat(vo.getObjectives().getTower().getKills()).isEqualTo(6);
        assertThat(vo.getTeamId()).isEqualTo("100");
        assertThat(vo.getWin()).isEqualTo("true");
        assertThat(vo.getTeamKills()).isEqualTo(10);

        assertThat(vo.getParticipants().get(0).getPuuid()).isEqualTo(matchParticipantVO.getPuuid());
        assertThat(vo.getParticipants().get(0).getDataVersion()).isEqualTo(matchParticipantVO.getDataVersion());
        assertThat(vo.getParticipants().get(0).getMatchId()).isEqualTo(matchParticipantVO.getMatchId());
        assertThat(vo.getParticipants().get(0).getParticipantId()).isEqualTo(matchParticipantVO.getParticipantId());
        assertThat(vo.getParticipants().get(0).getAssists()).isEqualTo(matchParticipantVO.getAssists());
        assertThat(vo.getParticipants().get(0).getBaronKills()).isEqualTo(matchParticipantVO.getBaronKills());
        assertThat(vo.getParticipants().get(0).getBountyLevel()).isEqualTo(matchParticipantVO.getBountyLevel());
        assertThat(vo.getParticipants().get(0).getChampExperience()).isEqualTo(matchParticipantVO.getChampExperience());
        assertThat(vo.getParticipants().get(0).getChampLevel()).isEqualTo(matchParticipantVO.getChampLevel());
        assertThat(vo.getParticipants().get(0).getChampionId()).isEqualTo(matchParticipantVO.getChampionId());
        assertThat(vo.getParticipants().get(0).getChampionName()).isEqualTo(matchParticipantVO.getChampionName());
        assertThat(vo.getParticipants().get(0).getChampionNameKR()).isEqualTo(matchParticipantVO.getChampionNameKR());
        assertThat(vo.getParticipants().get(0).getChampionImg()).isEqualTo(matchParticipantVO.getChampionImg());
        assertThat(vo.getParticipants().get(0).getChampionTransform()).isEqualTo(matchParticipantVO.getChampionTransform());
        assertThat(vo.getParticipants().get(0).getConsumablesPurchased()).isEqualTo(matchParticipantVO.getConsumablesPurchased());
        assertThat(vo.getParticipants().get(0).getDamageDealtToBuildings()).isEqualTo(
                matchParticipantVO.getDamageDealtToBuildings());
        assertThat(vo.getParticipants().get(0).getDamageDealtToObjectives()).isEqualTo(
                matchParticipantVO.getDamageDealtToObjectives());
        assertThat(vo.getParticipants().get(0).getDamageSelfMitigated()).isEqualTo(
                matchParticipantVO.getDamageSelfMitigated());
        assertThat(vo.getParticipants().get(0).getDeaths()).isEqualTo(
                matchParticipantVO.getDeaths());
        assertThat(vo.getParticipants().get(0).getDetectorWardsPlaced()).isEqualTo(
                matchParticipantVO.getDetectorWardsPlaced());
        assertThat(vo.getParticipants().get(0).getDoubleKills()).isEqualTo(
                matchParticipantVO.getDoubleKills());
        assertThat(vo.getParticipants().get(0).getDragonKills()).isEqualTo(
                matchParticipantVO.getDragonKills());
        assertThat(vo.getParticipants().get(0).isFirstBloodAssist()).isEqualTo(
                matchParticipantVO.isFirstBloodAssist());
        assertThat(vo.getParticipants().get(0).isFirstBloodKill()).isEqualTo(
                matchParticipantVO.isFirstBloodKill());
        assertThat(vo.getParticipants().get(0).isFirstTowerAssist()).isEqualTo(
                matchParticipantVO.isFirstTowerAssist());
        assertThat(vo.getParticipants().get(0).isFirstTowerKill()).isEqualTo(
                matchParticipantVO.isFirstTowerKill());
        assertThat(vo.getParticipants().get(0).isGameEndedInEarlySurrender()).isEqualTo(
                matchParticipantVO.isGameEndedInEarlySurrender());
        assertThat(vo.getParticipants().get(0).isGameEndedInSurrender()).isEqualTo(
                matchParticipantVO.isGameEndedInSurrender());
        assertThat(vo.getParticipants().get(0).getGoldEarned()).isEqualTo(
                matchParticipantVO.getGoldEarned());
        assertThat(vo.getParticipants().get(0).getGoldSpent()).isEqualTo(
                matchParticipantVO.getGoldSpent());
        assertThat(vo.getParticipants().get(0).getIndividualPosition()).isEqualTo(
                matchParticipantVO.getIndividualPosition());
        assertThat(vo.getParticipants().get(0).getInhibitorKills()).isEqualTo(
                matchParticipantVO.getInhibitorKills());
        assertThat(vo.getParticipants().get(0).getInhibitorTakedowns()).isEqualTo(
                matchParticipantVO.getInhibitorTakedowns());
        assertThat(vo.getParticipants().get(0).getInhibitorsLost()).isEqualTo(
                matchParticipantVO.getInhibitorsLost());
        assertThat(vo.getParticipants().get(0).getItem0()).isEqualTo(
                matchParticipantVO.getItem0());
        assertThat(vo.getParticipants().get(0).getItem1()).isEqualTo(
                matchParticipantVO.getItem1());
        assertThat(vo.getParticipants().get(0).getItem2()).isEqualTo(
                matchParticipantVO.getItem2());
        assertThat(vo.getParticipants().get(0).getItem3()).isEqualTo(
                matchParticipantVO.getItem3());
        assertThat(vo.getParticipants().get(0).getItem4()).isEqualTo(
                matchParticipantVO.getItem4());
        assertThat(vo.getParticipants().get(0).getItem5()).isEqualTo(
                matchParticipantVO.getItem5());
        assertThat(vo.getParticipants().get(0).getItem6()).isEqualTo(
                matchParticipantVO.getItem6());
        assertThat(vo.getParticipants().get(0).getItemsPurchased()).isEqualTo(
                matchParticipantVO.getItemsPurchased());
        assertThat(vo.getParticipants().get(0).getKillingSprees()).isEqualTo(
                matchParticipantVO.getKillingSprees());
        assertThat(vo.getParticipants().get(0).getKills()).isEqualTo(
                matchParticipantVO.getKills());
        assertThat(vo.getParticipants().get(0).getLane()).isEqualTo(
                matchParticipantVO.getLane());
        assertThat(vo.getParticipants().get(0).getLargestCriticalStrike()).isEqualTo(
                matchParticipantVO.getLargestCriticalStrike());
        assertThat(vo.getParticipants().get(0).getLargestKillingSpree()).isEqualTo(
                matchParticipantVO.getLargestKillingSpree());
        assertThat(vo.getParticipants().get(0).getLongestTimeSpentLiving()).isEqualTo(
                matchParticipantVO.getLongestTimeSpentLiving());
        assertThat(vo.getParticipants().get(0).getMagicDamageDealt()).isEqualTo(
                matchParticipantVO.getMagicDamageDealt());
        assertThat(vo.getParticipants().get(0).getMagicDamageDealtToChampions()).isEqualTo(
                matchParticipantVO.getMagicDamageDealtToChampions());
        assertThat(vo.getParticipants().get(0).getMagicDamageTaken()).isEqualTo(
                matchParticipantVO.getMagicDamageTaken());
        assertThat(vo.getParticipants().get(0).getNeutralMinionsKilled()).isEqualTo(
                matchParticipantVO.getNeutralMinionsKilled());
        assertThat(vo.getParticipants().get(0).getNexusKills()).isEqualTo(
                matchParticipantVO.getNexusKills());
        assertThat(vo.getParticipants().get(0).getNexusLost()).isEqualTo(
                matchParticipantVO.getNexusLost());
        assertThat(vo.getParticipants().get(0).getNexusTakedowns()).isEqualTo(
                matchParticipantVO.getNexusTakedowns());
        assertThat(vo.getParticipants().get(0).getObjectivesStolen()).isEqualTo(
                matchParticipantVO.getObjectivesStolen());
        assertThat(vo.getParticipants().get(0).getObjectivesStolenAssists()).isEqualTo(
                matchParticipantVO.getObjectivesStolenAssists());
        assertThat(vo.getParticipants().get(0).getPentaKills()).isEqualTo(
                matchParticipantVO.getPentaKills());
        assertThat(vo.getParticipants().get(0).getPhysicalDamageDealt()).isEqualTo(
                matchParticipantVO.getPhysicalDamageDealt());
        assertThat(vo.getParticipants().get(0).getPhysicalDamageDealtToChampions()).isEqualTo(
                matchParticipantVO.getPhysicalDamageDealtToChampions());
        assertThat(vo.getParticipants().get(0).getPhysicalDamageTaken()).isEqualTo(
                matchParticipantVO.getPhysicalDamageTaken());
        assertThat(vo.getParticipants().get(0).getProfileIcon()).isEqualTo(
                matchParticipantVO.getProfileIcon());
        assertThat(vo.getParticipants().get(0).getQuadraKills()).isEqualTo(
                matchParticipantVO.getQuadraKills());
        assertThat(vo.getParticipants().get(0).getRiotIdName()).isEqualTo(
                matchParticipantVO.getRiotIdName());
        assertThat(vo.getParticipants().get(0).getRiotIdTagline()).isEqualTo(
                matchParticipantVO.getRiotIdTagline());
        assertThat(vo.getParticipants().get(0).getRole()).isEqualTo(
                matchParticipantVO.getRole());
        assertThat(vo.getParticipants().get(0).getSightWardsBoughtInGame()).isEqualTo(
                matchParticipantVO.getSightWardsBoughtInGame());
        assertThat(vo.getParticipants().get(0).getSpell1Casts()).isEqualTo(
                matchParticipantVO.getSpell1Casts());
        assertThat(vo.getParticipants().get(0).getSpell2Casts()).isEqualTo(
                matchParticipantVO.getSpell2Casts());
        assertThat(vo.getParticipants().get(0).getSpell3Casts()).isEqualTo(
                matchParticipantVO.getSpell3Casts());
        assertThat(vo.getParticipants().get(0).getSpell4Casts()).isEqualTo(
                matchParticipantVO.getSpell4Casts());
        assertThat(vo.getParticipants().get(0).getSummoner1Casts()).isEqualTo(
                matchParticipantVO.getSummoner1Casts());
        assertThat(vo.getParticipants().get(0).getSummoner1Id()).isEqualTo(
                matchParticipantVO.getSummoner1Id());
        assertThat(vo.getParticipants().get(0).getSummoner2Casts()).isEqualTo(
                matchParticipantVO.getSummoner2Casts());
        assertThat(vo.getParticipants().get(0).getSummoner2Id()).isEqualTo(
                matchParticipantVO.getSummoner2Id());
        assertThat(vo.getParticipants().get(0).getSummonerId()).isEqualTo(
                matchParticipantVO.getSummonerId());
        assertThat(vo.getParticipants().get(0).getSummonerLevel()).isEqualTo(
                matchParticipantVO.getSummonerLevel());
        assertThat(vo.getParticipants().get(0).getSummonerName()).isEqualTo(
                matchParticipantVO.getPuuid().equals("BOT")
                        ? "(봇)" : vo.getParticipants().get(0).getSummonerName());
        assertThat(vo.getParticipants().get(0).isTeamEarlySurrendered()).isEqualTo(
                matchParticipantVO.isTeamEarlySurrendered());
        assertThat(vo.getParticipants().get(0).getTeamId()).isEqualTo(
                matchParticipantVO.getTeamId());
        assertThat(vo.getParticipants().get(0).getTeamPosition()).isEqualTo(
                matchParticipantVO.getTeamPosition());
        assertThat(vo.getParticipants().get(0).getTimeCCingOthers()).isEqualTo(
                matchParticipantVO.getTimeCCingOthers());
        assertThat(vo.getParticipants().get(0).getTimePlayed()).isEqualTo(
                matchParticipantVO.getTimePlayed());
        assertThat(vo.getParticipants().get(0).getTotalDamageDealt()).isEqualTo(
                matchParticipantVO.getTotalDamageDealt());
        assertThat(vo.getParticipants().get(0).getTotalDamageDealtToChampions()).isEqualTo(
                matchParticipantVO.getTotalDamageDealtToChampions());
        assertThat(vo.getParticipants().get(0).getTotalDamageTaken()).isEqualTo(
                matchParticipantVO.getTotalDamageTaken());
        assertThat(vo.getParticipants().get(0).getTotalHeal()).isEqualTo(
                matchParticipantVO.getTotalHeal());
        assertThat(vo.getParticipants().get(0).getTotalHealsOnTeammates()).isEqualTo(
                matchParticipantVO.getTotalHealsOnTeammates());
        assertThat(vo.getParticipants().get(0).getTotalMinionsKilled()).isEqualTo(
                matchParticipantVO.getTotalMinionsKilled());
        assertThat(vo.getParticipants().get(0).getTotalTimeCCDealt()).isEqualTo(
                matchParticipantVO.getTotalTimeCCDealt());
        assertThat(vo.getParticipants().get(0).getTotalTimeSpentDead()).isEqualTo(
                matchParticipantVO.getTotalTimeSpentDead());
        assertThat(vo.getParticipants().get(0).getTotalUnitsHealed()).isEqualTo(
                matchParticipantVO.getTotalUnitsHealed());
        assertThat(vo.getParticipants().get(0).getTripleKills()).isEqualTo(
                matchParticipantVO.getTripleKills());
        assertThat(vo.getParticipants().get(0).getTrueDamageDealt()).isEqualTo(
                matchParticipantVO.getTrueDamageDealt());
        assertThat(vo.getParticipants().get(0).getTrueDamageDealtToChampions()).isEqualTo(
                matchParticipantVO.getTrueDamageDealtToChampions());
        assertThat(vo.getParticipants().get(0).getTrueDamageTaken()).isEqualTo(
                matchParticipantVO.getTrueDamageTaken());
        assertThat(vo.getParticipants().get(0).getTurretKills()).isEqualTo(
                matchParticipantVO.getTurretKills());
        assertThat(vo.getParticipants().get(0).getTurretTakedowns()).isEqualTo(
                matchParticipantVO.getTurretTakedowns());
        assertThat(vo.getParticipants().get(0).getTurretsLost()).isEqualTo(
                matchParticipantVO.getTurretsLost());
        assertThat(vo.getParticipants().get(0).getUnrealKills()).isEqualTo(
                matchParticipantVO.getUnrealKills());
        assertThat(vo.getParticipants().get(0).getVisionScore()).isEqualTo(
                matchParticipantVO.getVisionScore());
        assertThat(vo.getParticipants().get(0).getVisionWardsBoughtInGame()).isEqualTo(
                matchParticipantVO.getVisionWardsBoughtInGame());
        assertThat(vo.getParticipants().get(0).getWardsKilled()).isEqualTo(
                matchParticipantVO.getWardsKilled());
        assertThat(vo.getParticipants().get(0).getWardsPlaced()).isEqualTo(
                matchParticipantVO.getWardsPlaced());
        assertThat(vo.getParticipants().get(0).isWin()).isEqualTo(
                matchParticipantVO.isWin());
        assertThat(vo.getParticipants().get(0).getRrt()).isEqualTo(
                matchParticipantVO.getRrt());

        // TODO
//        assertThat(vo.getParticipants().get(0).getMultiKills()).isEqualTo(
//                matchParticipantVO.getMultiKills());
//        assertThat(vo.getParticipants().get(0).getKda()).isEqualTo(
//                matchParticipantVO.getKda());
//        assertThat(vo.getParticipants().get(0).getMinionsKilledPerMin()).isEqualTo(
//                matchParticipantVO.getMinionsKilledPerMin());
    }

    private MatchObjectivesVO createMatchObjectivesVO()
    {
        MatchObjectiveVO baron = new MatchObjectiveVO(true, 1);
        MatchObjectiveVO champion = new MatchObjectiveVO(false, 2);
        MatchObjectiveVO dragon = new MatchObjectiveVO(true, 3);
        MatchObjectiveVO inhibitor = new MatchObjectiveVO(false, 4);
        MatchObjectiveVO riftHeraId = new MatchObjectiveVO(true, 5);
        MatchObjectiveVO tower = new MatchObjectiveVO(false, 6);

        return new MatchObjectivesVO(baron, champion, dragon, inhibitor, riftHeraId, tower);
    }

    private List<MatchBanVO> createMatchBanVOList()
    {
        List<MatchBanVO> matchBanVOList = new ArrayList<>();

        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;

        MatchBanVO matchBanVO = new MatchBanVO(matchId, pickTurn, teamId, championId);
        matchBanVOList.add(matchBanVO);

        return matchBanVOList;
    }

    private MatchParticipantVO createMatchParticipantVO()
    {
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
        MatchParticipantVO matchParticipantVO = new MatchParticipantVO(
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

        return matchParticipantVO;

    }

}