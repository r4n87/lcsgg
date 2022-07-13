package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.entity.MatchParticipantId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MatchParticipantRepositoryTest {

    @Autowired
    private MatchParticipantRepository matchParticipantRepository;

    @Test
    @DisplayName("Save Entity")
    public void saveMatchParticipantEntity() {
        //given
        MatchParticipantEntity matchParticipantEntity = createMatchParticipantEntityA();

        //when
        MatchParticipantEntity matchParticipantEntityForTest = matchParticipantRepository.save(matchParticipantEntity);

        //then
        assertThat(matchParticipantEntityForTest.getMatchParticipantId().getPuuid()).isEqualTo(
                matchParticipantEntity.getMatchParticipantId().getPuuid());
        assertThat(matchParticipantEntityForTest.getMatchParticipantId().getDataVersion()).isEqualTo(
                matchParticipantEntity.getMatchParticipantId().getDataVersion());
        assertThat(matchParticipantEntityForTest.getMatchParticipantId().getMatchId()).isEqualTo(
                matchParticipantEntity.getMatchParticipantId().getMatchId());
        assertThat(matchParticipantEntityForTest.getMatchParticipantId().getParticipantId()).isEqualTo(
                matchParticipantEntity.getMatchParticipantId().getParticipantId());
        assertThat(matchParticipantEntityForTest.getAssists()).isEqualTo(
                matchParticipantEntity.getAssists());
        assertThat(matchParticipantEntityForTest.getBaronKills()).isEqualTo(
                matchParticipantEntity.getBaronKills());
        assertThat(matchParticipantEntityForTest.getBountyLevel()).isEqualTo(
                matchParticipantEntity.getBountyLevel());
        assertThat(matchParticipantEntityForTest.getChampExperience()).isEqualTo(
                matchParticipantEntity.getChampExperience());
        assertThat(matchParticipantEntityForTest.getChampLevel()).isEqualTo(
                matchParticipantEntity.getChampLevel());
        assertThat(matchParticipantEntityForTest.getChampionId()).isEqualTo(
                matchParticipantEntity.getChampionId());
        assertThat(matchParticipantEntityForTest.getChampionName()).isEqualTo(
                matchParticipantEntity.getChampionName());
        assertThat(matchParticipantEntityForTest.getChampionTransform()).isEqualTo(
                matchParticipantEntity.getChampionTransform());
        assertThat(matchParticipantEntityForTest.getConsumablesPurchased()).isEqualTo(
                matchParticipantEntity.getConsumablesPurchased());
        assertThat(matchParticipantEntityForTest.getDamageDealtToBuildings()).isEqualTo(
                matchParticipantEntity.getDamageDealtToBuildings());
        assertThat(matchParticipantEntityForTest.getDamageDealtToObjectives()).isEqualTo(
                matchParticipantEntity.getDamageDealtToObjectives());
        assertThat(matchParticipantEntityForTest.getDamageSelfMitigated()).isEqualTo(
                matchParticipantEntity.getDamageSelfMitigated());
        assertThat(matchParticipantEntityForTest.getDeaths()).isEqualTo(
                matchParticipantEntity.getDeaths());
        assertThat(matchParticipantEntityForTest.getDetectorWardsPlaced()).isEqualTo(
                matchParticipantEntity.getDetectorWardsPlaced());
        assertThat(matchParticipantEntityForTest.getDoubleKills()).isEqualTo(
                matchParticipantEntity.getDoubleKills());
        assertThat(matchParticipantEntityForTest.getDragonKills()).isEqualTo(
                matchParticipantEntity.getDragonKills());
        assertThat(matchParticipantEntityForTest.isFirstBloodAssist()).isEqualTo(
                matchParticipantEntity.isFirstBloodAssist());
        assertThat(matchParticipantEntityForTest.isFirstBloodKill()).isEqualTo(
                matchParticipantEntity.isFirstBloodKill());
        assertThat(matchParticipantEntityForTest.isFirstTowerAssist()).isEqualTo(
                matchParticipantEntity.isFirstTowerAssist());
        assertThat(matchParticipantEntityForTest.isFirstTowerKill()).isEqualTo(
                matchParticipantEntity.isFirstTowerKill());
        assertThat(matchParticipantEntityForTest.isGameEndedInEarlySurrender()).isEqualTo(
                matchParticipantEntity.isGameEndedInEarlySurrender());
        assertThat(matchParticipantEntityForTest.isGameEndedInSurrender()).isEqualTo(
                matchParticipantEntity.isGameEndedInSurrender());
        assertThat(matchParticipantEntityForTest.getGoldEarned()).isEqualTo(
                matchParticipantEntity.getGoldEarned());
        assertThat(matchParticipantEntityForTest.getGoldSpent()).isEqualTo(
                matchParticipantEntity.getGoldSpent());
        assertThat(matchParticipantEntityForTest.getIndividualPosition()).isEqualTo(
                matchParticipantEntity.getIndividualPosition());
        assertThat(matchParticipantEntityForTest.getInhibitorKills()).isEqualTo(
                matchParticipantEntity.getInhibitorKills());
        assertThat(matchParticipantEntityForTest.getInhibitorTakedowns()).isEqualTo(
                matchParticipantEntity.getInhibitorTakedowns());
        assertThat(matchParticipantEntityForTest.getInhibitorsLost()).isEqualTo(
                matchParticipantEntity.getInhibitorsLost());
        assertThat(matchParticipantEntityForTest.getItem0()).isEqualTo(
                matchParticipantEntity.getItem0());
        assertThat(matchParticipantEntityForTest.getItem1()).isEqualTo(
                matchParticipantEntity.getItem1());
        assertThat(matchParticipantEntityForTest.getItem2()).isEqualTo(
                matchParticipantEntity.getItem2());
        assertThat(matchParticipantEntityForTest.getItem3()).isEqualTo(
                matchParticipantEntity.getItem3());
        assertThat(matchParticipantEntityForTest.getItem4()).isEqualTo(
                matchParticipantEntity.getItem4());
        assertThat(matchParticipantEntityForTest.getItem5()).isEqualTo(
                matchParticipantEntity.getItem5());
        assertThat(matchParticipantEntityForTest.getItem6()).isEqualTo(
                matchParticipantEntity.getItem6());
        assertThat(matchParticipantEntityForTest.getItemsPurchased()).isEqualTo(
                matchParticipantEntity.getItemsPurchased());
        assertThat(matchParticipantEntityForTest.getKillingSprees()).isEqualTo(
                matchParticipantEntity.getKillingSprees());
        assertThat(matchParticipantEntityForTest.getKills()).isEqualTo(
                matchParticipantEntity.getKills());
        assertThat(matchParticipantEntityForTest.getLane()).isEqualTo(
                matchParticipantEntity.getLane());
        assertThat(matchParticipantEntityForTest.getLargestCriticalStrike()).isEqualTo(
                matchParticipantEntity.getLargestCriticalStrike());
        assertThat(matchParticipantEntityForTest.getLargestKillingSpree()).isEqualTo(
                matchParticipantEntity.getLargestKillingSpree());
        assertThat(matchParticipantEntityForTest.getLongestTimeSpentLiving()).isEqualTo(
                matchParticipantEntity.getLongestTimeSpentLiving());
        assertThat(matchParticipantEntityForTest.getMagicDamageDealt()).isEqualTo(
                matchParticipantEntity.getMagicDamageDealt());
        assertThat(matchParticipantEntityForTest.getMagicDamageDealtToChampions()).isEqualTo(
                matchParticipantEntity.getMagicDamageDealtToChampions());
        assertThat(matchParticipantEntityForTest.getMagicDamageTaken()).isEqualTo(
                matchParticipantEntity.getMagicDamageTaken());
        assertThat(matchParticipantEntityForTest.getNeutralMinionsKilled()).isEqualTo(
                matchParticipantEntity.getNeutralMinionsKilled());
        assertThat(matchParticipantEntityForTest.getNexusKills()).isEqualTo(
                matchParticipantEntity.getNexusKills());
        assertThat(matchParticipantEntityForTest.getNexusLost()).isEqualTo(
                matchParticipantEntity.getNexusLost());
        assertThat(matchParticipantEntityForTest.getNexusTakedowns()).isEqualTo(
                matchParticipantEntity.getNexusTakedowns());
        assertThat(matchParticipantEntityForTest.getObjectivesStolen()).isEqualTo(
                matchParticipantEntity.getObjectivesStolen());
        assertThat(matchParticipantEntityForTest.getObjectivesStolenAssists()).isEqualTo(
                matchParticipantEntity.getObjectivesStolenAssists());
        assertThat(matchParticipantEntityForTest.getPentaKills()).isEqualTo(
                matchParticipantEntity.getPentaKills());
        assertThat(matchParticipantEntityForTest.getPhysicalDamageDealt()).isEqualTo(
                matchParticipantEntity.getPhysicalDamageDealt());
        assertThat(matchParticipantEntityForTest.getPhysicalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntity.getPhysicalDamageDealtToChampions());
        assertThat(matchParticipantEntityForTest.getPhysicalDamageTaken()).isEqualTo(
                matchParticipantEntity.getPhysicalDamageTaken());
        assertThat(matchParticipantEntityForTest.getProfileIcon()).isEqualTo(
                matchParticipantEntity.getProfileIcon());
        assertThat(matchParticipantEntityForTest.getQuadraKills()).isEqualTo(
                matchParticipantEntity.getQuadraKills());
        assertThat(matchParticipantEntityForTest.getRiotIdName()).isEqualTo(
                matchParticipantEntity.getRiotIdName());
        assertThat(matchParticipantEntityForTest.getRiotIdTagline()).isEqualTo(
                matchParticipantEntity.getRiotIdTagline());
        assertThat(matchParticipantEntityForTest.getRole()).isEqualTo(
                matchParticipantEntity.getRole());
        assertThat(matchParticipantEntityForTest.getSightWardsBoughtInGame()).isEqualTo(
                matchParticipantEntity.getSightWardsBoughtInGame());
        assertThat(matchParticipantEntityForTest.getSpell1Casts()).isEqualTo(
                matchParticipantEntity.getSpell1Casts());
        assertThat(matchParticipantEntityForTest.getSpell2Casts()).isEqualTo(
                matchParticipantEntity.getSpell2Casts());
        assertThat(matchParticipantEntityForTest.getSpell3Casts()).isEqualTo(
                matchParticipantEntity.getSpell3Casts());
        assertThat(matchParticipantEntityForTest.getSpell4Casts()).isEqualTo(
                matchParticipantEntity.getSpell4Casts());
        assertThat(matchParticipantEntityForTest.getSummoner1Casts()).isEqualTo(
                matchParticipantEntity.getSummoner1Casts());
        assertThat(matchParticipantEntityForTest.getSummoner1Id()).isEqualTo(
                matchParticipantEntity.getSummoner1Id());
        assertThat(matchParticipantEntityForTest.getSummoner2Casts()).isEqualTo(
                matchParticipantEntity.getSummoner2Casts());
        assertThat(matchParticipantEntityForTest.getSummoner2Id()).isEqualTo(
                matchParticipantEntity.getSummoner2Id());
        assertThat(matchParticipantEntityForTest.getSummonerId()).isEqualTo(
                matchParticipantEntity.getSummonerId());
        assertThat(matchParticipantEntityForTest.getSummonerLevel()).isEqualTo(
                matchParticipantEntity.getSummonerLevel());
        assertThat(matchParticipantEntityForTest.getSummonerName()).isEqualTo(
                matchParticipantEntity.getSummonerName());
        assertThat(matchParticipantEntityForTest.isTeamEarlySurrendered()).isEqualTo(
                matchParticipantEntity.isTeamEarlySurrendered());
        assertThat(matchParticipantEntityForTest.getTeamId()).isEqualTo(
                matchParticipantEntity.getTeamId());
        assertThat(matchParticipantEntityForTest.getTeamPosition()).isEqualTo(
                matchParticipantEntity.getTeamPosition());
        assertThat(matchParticipantEntityForTest.getTimeCCingOthers()).isEqualTo(
                matchParticipantEntity.getTimeCCingOthers());
        assertThat(matchParticipantEntityForTest.getTimePlayed()).isEqualTo(
                matchParticipantEntity.getTimePlayed());
        assertThat(matchParticipantEntityForTest.getTotalDamageDealt()).isEqualTo(
                matchParticipantEntity.getTotalDamageDealt());
        assertThat(matchParticipantEntityForTest.getTotalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntity.getTotalDamageDealtToChampions());
        assertThat(matchParticipantEntityForTest.getTotalDamageTaken()).isEqualTo(
                matchParticipantEntity.getTotalDamageTaken());
        assertThat(matchParticipantEntityForTest.getTotalHeal()).isEqualTo(
                matchParticipantEntity.getTotalHeal());
        assertThat(matchParticipantEntityForTest.getTotalHealsOnTeammates()).isEqualTo(
                matchParticipantEntity.getTotalHealsOnTeammates());
        assertThat(matchParticipantEntityForTest.getTotalMinionsKilled()).isEqualTo(
                matchParticipantEntity.getTotalMinionsKilled());
        assertThat(matchParticipantEntityForTest.getTotalTimeCCDealt()).isEqualTo(
                matchParticipantEntity.getTotalTimeCCDealt());
        assertThat(matchParticipantEntityForTest.getTotalTimeSpentDead()).isEqualTo(
                matchParticipantEntity.getTotalTimeSpentDead());
        assertThat(matchParticipantEntityForTest.getTotalUnitsHealed()).isEqualTo(
                matchParticipantEntity.getTotalUnitsHealed());
        assertThat(matchParticipantEntityForTest.getTripleKills()).isEqualTo(
                matchParticipantEntity.getTripleKills());
        assertThat(matchParticipantEntityForTest.getTrueDamageDealt()).isEqualTo(
                matchParticipantEntity.getTrueDamageDealt());
        assertThat(matchParticipantEntityForTest.getTrueDamageDealtToChampions()).isEqualTo(
                matchParticipantEntity.getTrueDamageDealtToChampions());
        assertThat(matchParticipantEntityForTest.getTrueDamageTaken()).isEqualTo(
                matchParticipantEntity.getTrueDamageTaken());
        assertThat(matchParticipantEntityForTest.getTurretKills()).isEqualTo(
                matchParticipantEntity.getTurretKills());
        assertThat(matchParticipantEntityForTest.getTurretTakedowns()).isEqualTo(
                matchParticipantEntity.getTurretTakedowns());
        assertThat(matchParticipantEntityForTest.getTurretsLost()).isEqualTo(
                matchParticipantEntity.getTurretsLost());
        assertThat(matchParticipantEntityForTest.getUnrealKills()).isEqualTo(
                matchParticipantEntity.getUnrealKills());
        assertThat(matchParticipantEntityForTest.getVisionScore()).isEqualTo(
                matchParticipantEntity.getVisionScore());
        assertThat(matchParticipantEntityForTest.getVisionWardsBoughtInGame()).isEqualTo(
                matchParticipantEntity.getVisionWardsBoughtInGame());
        assertThat(matchParticipantEntityForTest.getWardsKilled()).isEqualTo(
                matchParticipantEntity.getWardsKilled());
        assertThat(matchParticipantEntityForTest.getWardsPlaced()).isEqualTo(
                matchParticipantEntity.getWardsPlaced());
        assertThat(matchParticipantEntityForTest.isWin()).isEqualTo(
                matchParticipantEntity.isWin());
        assertThat(matchParticipantEntityForTest.getRrt()).isEqualTo(
                matchParticipantEntity.getRrt());
    }

    @Test
    @DisplayName("Find Entity By MatchParticipantId")
    public void findMatchParticipantEntityByMatchParticipantId() {
        //given
        MatchParticipantEntity matchParticipantEntityA = createMatchParticipantEntityA();
        MatchParticipantEntity matchParticipantEntityB = createMatchParticipantEntityB();

        MatchParticipantEntity matchParticipantEntityAForTest =
                matchParticipantRepository.save(matchParticipantEntityA);
        MatchParticipantEntity matchParticipantEntityBForTest =
                matchParticipantRepository.save(matchParticipantEntityB);

        //when
        MatchParticipantEntity matchParticipantEntityForFindTest = matchParticipantRepository.findByMatchParticipantId(
                new MatchParticipantId(
                        matchParticipantEntityAForTest.getMatchParticipantId().getPuuid(),
                        matchParticipantEntityAForTest.getMatchParticipantId().getDataVersion(),
                        matchParticipantEntityAForTest.getMatchParticipantId().getMatchId(),
                        matchParticipantEntityAForTest.getMatchParticipantId().getParticipantId()
                )).get(0);

        //then
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getPuuid()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getPuuid());
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getDataVersion()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getDataVersion());
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getMatchId()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getMatchId());
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getParticipantId()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getParticipantId());
        assertThat(matchParticipantEntityForFindTest.getAssists()).isEqualTo(
                matchParticipantEntityAForTest.getAssists());
        assertThat(matchParticipantEntityForFindTest.getBaronKills()).isEqualTo(
                matchParticipantEntityAForTest.getBaronKills());
        assertThat(matchParticipantEntityForFindTest.getBountyLevel()).isEqualTo(
                matchParticipantEntityAForTest.getBountyLevel());
        assertThat(matchParticipantEntityForFindTest.getChampExperience()).isEqualTo(
                matchParticipantEntityAForTest.getChampExperience());
        assertThat(matchParticipantEntityForFindTest.getChampLevel()).isEqualTo(
                matchParticipantEntityAForTest.getChampLevel());
        assertThat(matchParticipantEntityForFindTest.getChampionId()).isEqualTo(
                matchParticipantEntityAForTest.getChampionId());
        assertThat(matchParticipantEntityForFindTest.getChampionName()).isEqualTo(
                matchParticipantEntityAForTest.getChampionName());
        assertThat(matchParticipantEntityForFindTest.getChampionTransform()).isEqualTo(
                matchParticipantEntityAForTest.getChampionTransform());
        assertThat(matchParticipantEntityForFindTest.getConsumablesPurchased()).isEqualTo(
                matchParticipantEntityAForTest.getConsumablesPurchased());
        assertThat(matchParticipantEntityForFindTest.getDamageDealtToBuildings()).isEqualTo(
                matchParticipantEntityAForTest.getDamageDealtToBuildings());
        assertThat(matchParticipantEntityForFindTest.getDamageDealtToObjectives()).isEqualTo(
                matchParticipantEntityAForTest.getDamageDealtToObjectives());
        assertThat(matchParticipantEntityForFindTest.getDamageSelfMitigated()).isEqualTo(
                matchParticipantEntityAForTest.getDamageSelfMitigated());
        assertThat(matchParticipantEntityForFindTest.getDeaths()).isEqualTo(
                matchParticipantEntityAForTest.getDeaths());
        assertThat(matchParticipantEntityForFindTest.getDetectorWardsPlaced()).isEqualTo(
                matchParticipantEntityAForTest.getDetectorWardsPlaced());
        assertThat(matchParticipantEntityForFindTest.getDoubleKills()).isEqualTo(
                matchParticipantEntityAForTest.getDoubleKills());
        assertThat(matchParticipantEntityForFindTest.getDragonKills()).isEqualTo(
                matchParticipantEntityAForTest.getDragonKills());
        assertThat(matchParticipantEntityForFindTest.isFirstBloodAssist()).isEqualTo(
                matchParticipantEntityAForTest.isFirstBloodAssist());
        assertThat(matchParticipantEntityForFindTest.isFirstBloodKill()).isEqualTo(
                matchParticipantEntityAForTest.isFirstBloodKill());
        assertThat(matchParticipantEntityForFindTest.isFirstTowerAssist()).isEqualTo(
                matchParticipantEntityAForTest.isFirstTowerAssist());
        assertThat(matchParticipantEntityForFindTest.isFirstTowerKill()).isEqualTo(
                matchParticipantEntityAForTest.isFirstTowerKill());
        assertThat(matchParticipantEntityForFindTest.isGameEndedInEarlySurrender()).isEqualTo(
                matchParticipantEntityAForTest.isGameEndedInEarlySurrender());
        assertThat(matchParticipantEntityForFindTest.isGameEndedInSurrender()).isEqualTo(
                matchParticipantEntityAForTest.isGameEndedInSurrender());
        assertThat(matchParticipantEntityForFindTest.getGoldEarned()).isEqualTo(
                matchParticipantEntityAForTest.getGoldEarned());
        assertThat(matchParticipantEntityForFindTest.getGoldSpent()).isEqualTo(
                matchParticipantEntityAForTest.getGoldSpent());
        assertThat(matchParticipantEntityForFindTest.getIndividualPosition()).isEqualTo(
                matchParticipantEntityAForTest.getIndividualPosition());
        assertThat(matchParticipantEntityForFindTest.getInhibitorKills()).isEqualTo(
                matchParticipantEntityAForTest.getInhibitorKills());
        assertThat(matchParticipantEntityForFindTest.getInhibitorTakedowns()).isEqualTo(
                matchParticipantEntityAForTest.getInhibitorTakedowns());
        assertThat(matchParticipantEntityForFindTest.getInhibitorsLost()).isEqualTo(
                matchParticipantEntityAForTest.getInhibitorsLost());
        assertThat(matchParticipantEntityForFindTest.getItem0()).isEqualTo(
                matchParticipantEntityAForTest.getItem0());
        assertThat(matchParticipantEntityForFindTest.getItem1()).isEqualTo(
                matchParticipantEntityAForTest.getItem1());
        assertThat(matchParticipantEntityForFindTest.getItem2()).isEqualTo(
                matchParticipantEntityAForTest.getItem2());
        assertThat(matchParticipantEntityForFindTest.getItem3()).isEqualTo(
                matchParticipantEntityAForTest.getItem3());
        assertThat(matchParticipantEntityForFindTest.getItem4()).isEqualTo(
                matchParticipantEntityAForTest.getItem4());
        assertThat(matchParticipantEntityForFindTest.getItem5()).isEqualTo(
                matchParticipantEntityAForTest.getItem5());
        assertThat(matchParticipantEntityForFindTest.getItem6()).isEqualTo(
                matchParticipantEntityAForTest.getItem6());
        assertThat(matchParticipantEntityForFindTest.getItemsPurchased()).isEqualTo(
                matchParticipantEntityAForTest.getItemsPurchased());
        assertThat(matchParticipantEntityForFindTest.getKillingSprees()).isEqualTo(
                matchParticipantEntityAForTest.getKillingSprees());
        assertThat(matchParticipantEntityForFindTest.getKills()).isEqualTo(
                matchParticipantEntityAForTest.getKills());
        assertThat(matchParticipantEntityForFindTest.getLane()).isEqualTo(
                matchParticipantEntityAForTest.getLane());
        assertThat(matchParticipantEntityForFindTest.getLargestCriticalStrike()).isEqualTo(
                matchParticipantEntityAForTest.getLargestCriticalStrike());
        assertThat(matchParticipantEntityForFindTest.getLargestKillingSpree()).isEqualTo(
                matchParticipantEntityAForTest.getLargestKillingSpree());
        assertThat(matchParticipantEntityForFindTest.getLongestTimeSpentLiving()).isEqualTo(
                matchParticipantEntityAForTest.getLongestTimeSpentLiving());
        assertThat(matchParticipantEntityForFindTest.getMagicDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getMagicDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getMagicDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getMagicDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getMagicDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getMagicDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getNeutralMinionsKilled()).isEqualTo(
                matchParticipantEntityAForTest.getNeutralMinionsKilled());
        assertThat(matchParticipantEntityForFindTest.getNexusKills()).isEqualTo(
                matchParticipantEntityAForTest.getNexusKills());
        assertThat(matchParticipantEntityForFindTest.getNexusLost()).isEqualTo(
                matchParticipantEntityAForTest.getNexusLost());
        assertThat(matchParticipantEntityForFindTest.getNexusTakedowns()).isEqualTo(
                matchParticipantEntityAForTest.getNexusTakedowns());
        assertThat(matchParticipantEntityForFindTest.getObjectivesStolen()).isEqualTo(
                matchParticipantEntityAForTest.getObjectivesStolen());
        assertThat(matchParticipantEntityForFindTest.getObjectivesStolenAssists()).isEqualTo(
                matchParticipantEntityAForTest.getObjectivesStolenAssists());
        assertThat(matchParticipantEntityForFindTest.getPentaKills()).isEqualTo(
                matchParticipantEntityAForTest.getPentaKills());
        assertThat(matchParticipantEntityForFindTest.getPhysicalDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getPhysicalDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getPhysicalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getPhysicalDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getPhysicalDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getPhysicalDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getProfileIcon()).isEqualTo(
                matchParticipantEntityAForTest.getProfileIcon());
        assertThat(matchParticipantEntityForFindTest.getQuadraKills()).isEqualTo(
                matchParticipantEntityAForTest.getQuadraKills());
        assertThat(matchParticipantEntityForFindTest.getRiotIdName()).isEqualTo(
                matchParticipantEntityAForTest.getRiotIdName());
        assertThat(matchParticipantEntityForFindTest.getRiotIdTagline()).isEqualTo(
                matchParticipantEntityAForTest.getRiotIdTagline());
        assertThat(matchParticipantEntityForFindTest.getRole()).isEqualTo(
                matchParticipantEntityAForTest.getRole());
        assertThat(matchParticipantEntityForFindTest.getSightWardsBoughtInGame()).isEqualTo(
                matchParticipantEntityAForTest.getSightWardsBoughtInGame());
        assertThat(matchParticipantEntityForFindTest.getSpell1Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell1Casts());
        assertThat(matchParticipantEntityForFindTest.getSpell2Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell2Casts());
        assertThat(matchParticipantEntityForFindTest.getSpell3Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell3Casts());
        assertThat(matchParticipantEntityForFindTest.getSpell4Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell4Casts());
        assertThat(matchParticipantEntityForFindTest.getSummoner1Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner1Casts());
        assertThat(matchParticipantEntityForFindTest.getSummoner1Id()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner1Id());
        assertThat(matchParticipantEntityForFindTest.getSummoner2Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner2Casts());
        assertThat(matchParticipantEntityForFindTest.getSummoner2Id()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner2Id());
        assertThat(matchParticipantEntityForFindTest.getSummonerId()).isEqualTo(
                matchParticipantEntityAForTest.getSummonerId());
        assertThat(matchParticipantEntityForFindTest.getSummonerLevel()).isEqualTo(
                matchParticipantEntityAForTest.getSummonerLevel());
        assertThat(matchParticipantEntityForFindTest.getSummonerName()).isEqualTo(
                matchParticipantEntityAForTest.getSummonerName());
        assertThat(matchParticipantEntityForFindTest.isTeamEarlySurrendered()).isEqualTo(
                matchParticipantEntityAForTest.isTeamEarlySurrendered());
        assertThat(matchParticipantEntityForFindTest.getTeamId()).isEqualTo(
                matchParticipantEntityAForTest.getTeamId());
        assertThat(matchParticipantEntityForFindTest.getTeamPosition()).isEqualTo(
                matchParticipantEntityAForTest.getTeamPosition());
        assertThat(matchParticipantEntityForFindTest.getTimeCCingOthers()).isEqualTo(
                matchParticipantEntityAForTest.getTimeCCingOthers());
        assertThat(matchParticipantEntityForFindTest.getTimePlayed()).isEqualTo(
                matchParticipantEntityAForTest.getTimePlayed());
        assertThat(matchParticipantEntityForFindTest.getTotalDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getTotalDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getTotalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getTotalDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getTotalDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getTotalDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getTotalHeal()).isEqualTo(
                matchParticipantEntityAForTest.getTotalHeal());
        assertThat(matchParticipantEntityForFindTest.getTotalHealsOnTeammates()).isEqualTo(
                matchParticipantEntityAForTest.getTotalHealsOnTeammates());
        assertThat(matchParticipantEntityForFindTest.getTotalMinionsKilled()).isEqualTo(
                matchParticipantEntityAForTest.getTotalMinionsKilled());
        assertThat(matchParticipantEntityForFindTest.getTotalTimeCCDealt()).isEqualTo(
                matchParticipantEntityAForTest.getTotalTimeCCDealt());
        assertThat(matchParticipantEntityForFindTest.getTotalTimeSpentDead()).isEqualTo(
                matchParticipantEntityAForTest.getTotalTimeSpentDead());
        assertThat(matchParticipantEntityForFindTest.getTotalUnitsHealed()).isEqualTo(
                matchParticipantEntityAForTest.getTotalUnitsHealed());
        assertThat(matchParticipantEntityForFindTest.getTripleKills()).isEqualTo(
                matchParticipantEntityAForTest.getTripleKills());
        assertThat(matchParticipantEntityForFindTest.getTrueDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getTrueDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getTrueDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getTrueDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getTrueDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getTrueDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getTurretKills()).isEqualTo(
                matchParticipantEntityAForTest.getTurretKills());
        assertThat(matchParticipantEntityForFindTest.getTurretTakedowns()).isEqualTo(
                matchParticipantEntityAForTest.getTurretTakedowns());
        assertThat(matchParticipantEntityForFindTest.getTurretsLost()).isEqualTo(
                matchParticipantEntityAForTest.getTurretsLost());
        assertThat(matchParticipantEntityForFindTest.getUnrealKills()).isEqualTo(
                matchParticipantEntityAForTest.getUnrealKills());
        assertThat(matchParticipantEntityForFindTest.getVisionScore()).isEqualTo(
                matchParticipantEntityAForTest.getVisionScore());
        assertThat(matchParticipantEntityForFindTest.getVisionWardsBoughtInGame()).isEqualTo(
                matchParticipantEntityAForTest.getVisionWardsBoughtInGame());
        assertThat(matchParticipantEntityForFindTest.getWardsKilled()).isEqualTo(
                matchParticipantEntityAForTest.getWardsKilled());
        assertThat(matchParticipantEntityForFindTest.getWardsPlaced()).isEqualTo(
                matchParticipantEntityAForTest.getWardsPlaced());
        assertThat(matchParticipantEntityForFindTest.isWin()).isEqualTo(
                matchParticipantEntityAForTest.isWin());
        assertThat(matchParticipantEntityForFindTest.getRrt()).isEqualTo(
                matchParticipantEntityAForTest.getRrt());
    }

    @Test
    @DisplayName("Find Entity By MatchParticipantId.DataVersion, MatchParticipantId.MatchId")
    public void findMatchParticipantEntityByMatchParticipantId_DataVersionAndMatchParticipantId_MatchId() {
        //given
        MatchParticipantEntity matchParticipantEntityA = createMatchParticipantEntityA();
        MatchParticipantEntity matchParticipantEntityB = createMatchParticipantEntityB();

        MatchParticipantEntity matchParticipantEntityAForTest = matchParticipantRepository.save(matchParticipantEntityA);
        MatchParticipantEntity matchParticipantEntityBForTest = matchParticipantRepository.save(matchParticipantEntityB);

        //when
        MatchParticipantEntity matchParticipantEntityForFindTest = matchParticipantRepository.findByMatchParticipantId_DataVersionAndMatchParticipantId_MatchId(
                        matchParticipantEntityAForTest.getMatchParticipantId().getDataVersion(),
                        matchParticipantEntityAForTest.getMatchParticipantId().getMatchId()).get(0);

        //then
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getPuuid()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getPuuid());
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getDataVersion()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getDataVersion());
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getMatchId()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getMatchId());
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getParticipantId()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getParticipantId());
        assertThat(matchParticipantEntityForFindTest.getAssists()).isEqualTo(
                matchParticipantEntityAForTest.getAssists());
        assertThat(matchParticipantEntityForFindTest.getBaronKills()).isEqualTo(
                matchParticipantEntityAForTest.getBaronKills());
        assertThat(matchParticipantEntityForFindTest.getBountyLevel()).isEqualTo(
                matchParticipantEntityAForTest.getBountyLevel());
        assertThat(matchParticipantEntityForFindTest.getChampExperience()).isEqualTo(
                matchParticipantEntityAForTest.getChampExperience());
        assertThat(matchParticipantEntityForFindTest.getChampLevel()).isEqualTo(
                matchParticipantEntityAForTest.getChampLevel());
        assertThat(matchParticipantEntityForFindTest.getChampionId()).isEqualTo(
                matchParticipantEntityAForTest.getChampionId());
        assertThat(matchParticipantEntityForFindTest.getChampionName()).isEqualTo(
                matchParticipantEntityAForTest.getChampionName());
        assertThat(matchParticipantEntityForFindTest.getChampionTransform()).isEqualTo(
                matchParticipantEntityAForTest.getChampionTransform());
        assertThat(matchParticipantEntityForFindTest.getConsumablesPurchased()).isEqualTo(
                matchParticipantEntityAForTest.getConsumablesPurchased());
        assertThat(matchParticipantEntityForFindTest.getDamageDealtToBuildings()).isEqualTo(
                matchParticipantEntityAForTest.getDamageDealtToBuildings());
        assertThat(matchParticipantEntityForFindTest.getDamageDealtToObjectives()).isEqualTo(
                matchParticipantEntityAForTest.getDamageDealtToObjectives());
        assertThat(matchParticipantEntityForFindTest.getDamageSelfMitigated()).isEqualTo(
                matchParticipantEntityAForTest.getDamageSelfMitigated());
        assertThat(matchParticipantEntityForFindTest.getDeaths()).isEqualTo(
                matchParticipantEntityAForTest.getDeaths());
        assertThat(matchParticipantEntityForFindTest.getDetectorWardsPlaced()).isEqualTo(
                matchParticipantEntityAForTest.getDetectorWardsPlaced());
        assertThat(matchParticipantEntityForFindTest.getDoubleKills()).isEqualTo(
                matchParticipantEntityAForTest.getDoubleKills());
        assertThat(matchParticipantEntityForFindTest.getDragonKills()).isEqualTo(
                matchParticipantEntityAForTest.getDragonKills());
        assertThat(matchParticipantEntityForFindTest.isFirstBloodAssist()).isEqualTo(
                matchParticipantEntityAForTest.isFirstBloodAssist());
        assertThat(matchParticipantEntityForFindTest.isFirstBloodKill()).isEqualTo(
                matchParticipantEntityAForTest.isFirstBloodKill());
        assertThat(matchParticipantEntityForFindTest.isFirstTowerAssist()).isEqualTo(
                matchParticipantEntityAForTest.isFirstTowerAssist());
        assertThat(matchParticipantEntityForFindTest.isFirstTowerKill()).isEqualTo(
                matchParticipantEntityAForTest.isFirstTowerKill());
        assertThat(matchParticipantEntityForFindTest.isGameEndedInEarlySurrender()).isEqualTo(
                matchParticipantEntityAForTest.isGameEndedInEarlySurrender());
        assertThat(matchParticipantEntityForFindTest.isGameEndedInSurrender()).isEqualTo(
                matchParticipantEntityAForTest.isGameEndedInSurrender());
        assertThat(matchParticipantEntityForFindTest.getGoldEarned()).isEqualTo(
                matchParticipantEntityAForTest.getGoldEarned());
        assertThat(matchParticipantEntityForFindTest.getGoldSpent()).isEqualTo(
                matchParticipantEntityAForTest.getGoldSpent());
        assertThat(matchParticipantEntityForFindTest.getIndividualPosition()).isEqualTo(
                matchParticipantEntityAForTest.getIndividualPosition());
        assertThat(matchParticipantEntityForFindTest.getInhibitorKills()).isEqualTo(
                matchParticipantEntityAForTest.getInhibitorKills());
        assertThat(matchParticipantEntityForFindTest.getInhibitorTakedowns()).isEqualTo(
                matchParticipantEntityAForTest.getInhibitorTakedowns());
        assertThat(matchParticipantEntityForFindTest.getInhibitorsLost()).isEqualTo(
                matchParticipantEntityAForTest.getInhibitorsLost());
        assertThat(matchParticipantEntityForFindTest.getItem0()).isEqualTo(
                matchParticipantEntityAForTest.getItem0());
        assertThat(matchParticipantEntityForFindTest.getItem1()).isEqualTo(
                matchParticipantEntityAForTest.getItem1());
        assertThat(matchParticipantEntityForFindTest.getItem2()).isEqualTo(
                matchParticipantEntityAForTest.getItem2());
        assertThat(matchParticipantEntityForFindTest.getItem3()).isEqualTo(
                matchParticipantEntityAForTest.getItem3());
        assertThat(matchParticipantEntityForFindTest.getItem4()).isEqualTo(
                matchParticipantEntityAForTest.getItem4());
        assertThat(matchParticipantEntityForFindTest.getItem5()).isEqualTo(
                matchParticipantEntityAForTest.getItem5());
        assertThat(matchParticipantEntityForFindTest.getItem6()).isEqualTo(
                matchParticipantEntityAForTest.getItem6());
        assertThat(matchParticipantEntityForFindTest.getItemsPurchased()).isEqualTo(
                matchParticipantEntityAForTest.getItemsPurchased());
        assertThat(matchParticipantEntityForFindTest.getKillingSprees()).isEqualTo(
                matchParticipantEntityAForTest.getKillingSprees());
        assertThat(matchParticipantEntityForFindTest.getKills()).isEqualTo(
                matchParticipantEntityAForTest.getKills());
        assertThat(matchParticipantEntityForFindTest.getLane()).isEqualTo(
                matchParticipantEntityAForTest.getLane());
        assertThat(matchParticipantEntityForFindTest.getLargestCriticalStrike()).isEqualTo(
                matchParticipantEntityAForTest.getLargestCriticalStrike());
        assertThat(matchParticipantEntityForFindTest.getLargestKillingSpree()).isEqualTo(
                matchParticipantEntityAForTest.getLargestKillingSpree());
        assertThat(matchParticipantEntityForFindTest.getLongestTimeSpentLiving()).isEqualTo(
                matchParticipantEntityAForTest.getLongestTimeSpentLiving());
        assertThat(matchParticipantEntityForFindTest.getMagicDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getMagicDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getMagicDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getMagicDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getMagicDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getMagicDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getNeutralMinionsKilled()).isEqualTo(
                matchParticipantEntityAForTest.getNeutralMinionsKilled());
        assertThat(matchParticipantEntityForFindTest.getNexusKills()).isEqualTo(
                matchParticipantEntityAForTest.getNexusKills());
        assertThat(matchParticipantEntityForFindTest.getNexusLost()).isEqualTo(
                matchParticipantEntityAForTest.getNexusLost());
        assertThat(matchParticipantEntityForFindTest.getNexusTakedowns()).isEqualTo(
                matchParticipantEntityAForTest.getNexusTakedowns());
        assertThat(matchParticipantEntityForFindTest.getObjectivesStolen()).isEqualTo(
                matchParticipantEntityAForTest.getObjectivesStolen());
        assertThat(matchParticipantEntityForFindTest.getObjectivesStolenAssists()).isEqualTo(
                matchParticipantEntityAForTest.getObjectivesStolenAssists());
        assertThat(matchParticipantEntityForFindTest.getPentaKills()).isEqualTo(
                matchParticipantEntityAForTest.getPentaKills());
        assertThat(matchParticipantEntityForFindTest.getPhysicalDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getPhysicalDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getPhysicalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getPhysicalDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getPhysicalDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getPhysicalDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getProfileIcon()).isEqualTo(
                matchParticipantEntityAForTest.getProfileIcon());
        assertThat(matchParticipantEntityForFindTest.getQuadraKills()).isEqualTo(
                matchParticipantEntityAForTest.getQuadraKills());
        assertThat(matchParticipantEntityForFindTest.getRiotIdName()).isEqualTo(
                matchParticipantEntityAForTest.getRiotIdName());
        assertThat(matchParticipantEntityForFindTest.getRiotIdTagline()).isEqualTo(
                matchParticipantEntityAForTest.getRiotIdTagline());
        assertThat(matchParticipantEntityForFindTest.getRole()).isEqualTo(
                matchParticipantEntityAForTest.getRole());
        assertThat(matchParticipantEntityForFindTest.getSightWardsBoughtInGame()).isEqualTo(
                matchParticipantEntityAForTest.getSightWardsBoughtInGame());
        assertThat(matchParticipantEntityForFindTest.getSpell1Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell1Casts());
        assertThat(matchParticipantEntityForFindTest.getSpell2Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell2Casts());
        assertThat(matchParticipantEntityForFindTest.getSpell3Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell3Casts());
        assertThat(matchParticipantEntityForFindTest.getSpell4Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell4Casts());
        assertThat(matchParticipantEntityForFindTest.getSummoner1Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner1Casts());
        assertThat(matchParticipantEntityForFindTest.getSummoner1Id()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner1Id());
        assertThat(matchParticipantEntityForFindTest.getSummoner2Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner2Casts());
        assertThat(matchParticipantEntityForFindTest.getSummoner2Id()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner2Id());
        assertThat(matchParticipantEntityForFindTest.getSummonerId()).isEqualTo(
                matchParticipantEntityAForTest.getSummonerId());
        assertThat(matchParticipantEntityForFindTest.getSummonerLevel()).isEqualTo(
                matchParticipantEntityAForTest.getSummonerLevel());
        assertThat(matchParticipantEntityForFindTest.getSummonerName()).isEqualTo(
                matchParticipantEntityAForTest.getSummonerName());
        assertThat(matchParticipantEntityForFindTest.isTeamEarlySurrendered()).isEqualTo(
                matchParticipantEntityAForTest.isTeamEarlySurrendered());
        assertThat(matchParticipantEntityForFindTest.getTeamId()).isEqualTo(
                matchParticipantEntityAForTest.getTeamId());
        assertThat(matchParticipantEntityForFindTest.getTeamPosition()).isEqualTo(
                matchParticipantEntityAForTest.getTeamPosition());
        assertThat(matchParticipantEntityForFindTest.getTimeCCingOthers()).isEqualTo(
                matchParticipantEntityAForTest.getTimeCCingOthers());
        assertThat(matchParticipantEntityForFindTest.getTimePlayed()).isEqualTo(
                matchParticipantEntityAForTest.getTimePlayed());
        assertThat(matchParticipantEntityForFindTest.getTotalDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getTotalDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getTotalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getTotalDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getTotalDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getTotalDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getTotalHeal()).isEqualTo(
                matchParticipantEntityAForTest.getTotalHeal());
        assertThat(matchParticipantEntityForFindTest.getTotalHealsOnTeammates()).isEqualTo(
                matchParticipantEntityAForTest.getTotalHealsOnTeammates());
        assertThat(matchParticipantEntityForFindTest.getTotalMinionsKilled()).isEqualTo(
                matchParticipantEntityAForTest.getTotalMinionsKilled());
        assertThat(matchParticipantEntityForFindTest.getTotalTimeCCDealt()).isEqualTo(
                matchParticipantEntityAForTest.getTotalTimeCCDealt());
        assertThat(matchParticipantEntityForFindTest.getTotalTimeSpentDead()).isEqualTo(
                matchParticipantEntityAForTest.getTotalTimeSpentDead());
        assertThat(matchParticipantEntityForFindTest.getTotalUnitsHealed()).isEqualTo(
                matchParticipantEntityAForTest.getTotalUnitsHealed());
        assertThat(matchParticipantEntityForFindTest.getTripleKills()).isEqualTo(
                matchParticipantEntityAForTest.getTripleKills());
        assertThat(matchParticipantEntityForFindTest.getTrueDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getTrueDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getTrueDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getTrueDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getTrueDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getTrueDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getTurretKills()).isEqualTo(
                matchParticipantEntityAForTest.getTurretKills());
        assertThat(matchParticipantEntityForFindTest.getTurretTakedowns()).isEqualTo(
                matchParticipantEntityAForTest.getTurretTakedowns());
        assertThat(matchParticipantEntityForFindTest.getTurretsLost()).isEqualTo(
                matchParticipantEntityAForTest.getTurretsLost());
        assertThat(matchParticipantEntityForFindTest.getUnrealKills()).isEqualTo(
                matchParticipantEntityAForTest.getUnrealKills());
        assertThat(matchParticipantEntityForFindTest.getVisionScore()).isEqualTo(
                matchParticipantEntityAForTest.getVisionScore());
        assertThat(matchParticipantEntityForFindTest.getVisionWardsBoughtInGame()).isEqualTo(
                matchParticipantEntityAForTest.getVisionWardsBoughtInGame());
        assertThat(matchParticipantEntityForFindTest.getWardsKilled()).isEqualTo(
                matchParticipantEntityAForTest.getWardsKilled());
        assertThat(matchParticipantEntityForFindTest.getWardsPlaced()).isEqualTo(
                matchParticipantEntityAForTest.getWardsPlaced());
        assertThat(matchParticipantEntityForFindTest.isWin()).isEqualTo(
                matchParticipantEntityAForTest.isWin());
        assertThat(matchParticipantEntityForFindTest.getRrt()).isEqualTo(
                matchParticipantEntityAForTest.getRrt());
    }

    @Test
    @DisplayName("Find Entity By MatchParticipantId.Puuid Order By MatchParticipantId.MatchId Desc")
    public void findMatchParticipantEntityByMatchParticipantId_PuuidOrderByMatchParticipantId_MatchIdDesc() {     //given
        MatchParticipantEntity matchParticipantEntityA = createMatchParticipantEntityA();
        MatchParticipantEntity matchParticipantEntityB = createMatchParticipantEntityB();

        MatchParticipantEntity matchParticipantEntityAForTest =
                matchParticipantRepository.save(matchParticipantEntityA);
        MatchParticipantEntity matchParticipantEntityBForTest =
                matchParticipantRepository.save(matchParticipantEntityB);

        //when
        MatchParticipantEntity matchParticipantEntityForFindTest =
                matchParticipantRepository.findByMatchParticipantId_PuuidOrderByMatchParticipantId_MatchIdDesc(
                matchParticipantEntityAForTest.getMatchParticipantId().getPuuid()).get(0);

        //then
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getPuuid()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getPuuid());
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getDataVersion()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getDataVersion());
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getMatchId()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getMatchId());
        assertThat(matchParticipantEntityForFindTest.getMatchParticipantId().getParticipantId()).isEqualTo(
                matchParticipantEntityAForTest.getMatchParticipantId().getParticipantId());
        assertThat(matchParticipantEntityForFindTest.getAssists()).isEqualTo(
                matchParticipantEntityAForTest.getAssists());
        assertThat(matchParticipantEntityForFindTest.getBaronKills()).isEqualTo(
                matchParticipantEntityAForTest.getBaronKills());
        assertThat(matchParticipantEntityForFindTest.getBountyLevel()).isEqualTo(
                matchParticipantEntityAForTest.getBountyLevel());
        assertThat(matchParticipantEntityForFindTest.getChampExperience()).isEqualTo(
                matchParticipantEntityAForTest.getChampExperience());
        assertThat(matchParticipantEntityForFindTest.getChampLevel()).isEqualTo(
                matchParticipantEntityAForTest.getChampLevel());
        assertThat(matchParticipantEntityForFindTest.getChampionId()).isEqualTo(
                matchParticipantEntityAForTest.getChampionId());
        assertThat(matchParticipantEntityForFindTest.getChampionName()).isEqualTo(
                matchParticipantEntityAForTest.getChampionName());
        assertThat(matchParticipantEntityForFindTest.getChampionTransform()).isEqualTo(
                matchParticipantEntityAForTest.getChampionTransform());
        assertThat(matchParticipantEntityForFindTest.getConsumablesPurchased()).isEqualTo(
                matchParticipantEntityAForTest.getConsumablesPurchased());
        assertThat(matchParticipantEntityForFindTest.getDamageDealtToBuildings()).isEqualTo(
                matchParticipantEntityAForTest.getDamageDealtToBuildings());
        assertThat(matchParticipantEntityForFindTest.getDamageDealtToObjectives()).isEqualTo(
                matchParticipantEntityAForTest.getDamageDealtToObjectives());
        assertThat(matchParticipantEntityForFindTest.getDamageSelfMitigated()).isEqualTo(
                matchParticipantEntityAForTest.getDamageSelfMitigated());
        assertThat(matchParticipantEntityForFindTest.getDeaths()).isEqualTo(
                matchParticipantEntityAForTest.getDeaths());
        assertThat(matchParticipantEntityForFindTest.getDetectorWardsPlaced()).isEqualTo(
                matchParticipantEntityAForTest.getDetectorWardsPlaced());
        assertThat(matchParticipantEntityForFindTest.getDoubleKills()).isEqualTo(
                matchParticipantEntityAForTest.getDoubleKills());
        assertThat(matchParticipantEntityForFindTest.getDragonKills()).isEqualTo(
                matchParticipantEntityAForTest.getDragonKills());
        assertThat(matchParticipantEntityForFindTest.isFirstBloodAssist()).isEqualTo(
                matchParticipantEntityAForTest.isFirstBloodAssist());
        assertThat(matchParticipantEntityForFindTest.isFirstBloodKill()).isEqualTo(
                matchParticipantEntityAForTest.isFirstBloodKill());
        assertThat(matchParticipantEntityForFindTest.isFirstTowerAssist()).isEqualTo(
                matchParticipantEntityAForTest.isFirstTowerAssist());
        assertThat(matchParticipantEntityForFindTest.isFirstTowerKill()).isEqualTo(
                matchParticipantEntityAForTest.isFirstTowerKill());
        assertThat(matchParticipantEntityForFindTest.isGameEndedInEarlySurrender()).isEqualTo(
                matchParticipantEntityAForTest.isGameEndedInEarlySurrender());
        assertThat(matchParticipantEntityForFindTest.isGameEndedInSurrender()).isEqualTo(
                matchParticipantEntityAForTest.isGameEndedInSurrender());
        assertThat(matchParticipantEntityForFindTest.getGoldEarned()).isEqualTo(
                matchParticipantEntityAForTest.getGoldEarned());
        assertThat(matchParticipantEntityForFindTest.getGoldSpent()).isEqualTo(
                matchParticipantEntityAForTest.getGoldSpent());
        assertThat(matchParticipantEntityForFindTest.getIndividualPosition()).isEqualTo(
                matchParticipantEntityAForTest.getIndividualPosition());
        assertThat(matchParticipantEntityForFindTest.getInhibitorKills()).isEqualTo(
                matchParticipantEntityAForTest.getInhibitorKills());
        assertThat(matchParticipantEntityForFindTest.getInhibitorTakedowns()).isEqualTo(
                matchParticipantEntityAForTest.getInhibitorTakedowns());
        assertThat(matchParticipantEntityForFindTest.getInhibitorsLost()).isEqualTo(
                matchParticipantEntityAForTest.getInhibitorsLost());
        assertThat(matchParticipantEntityForFindTest.getItem0()).isEqualTo(
                matchParticipantEntityAForTest.getItem0());
        assertThat(matchParticipantEntityForFindTest.getItem1()).isEqualTo(
                matchParticipantEntityAForTest.getItem1());
        assertThat(matchParticipantEntityForFindTest.getItem2()).isEqualTo(
                matchParticipantEntityAForTest.getItem2());
        assertThat(matchParticipantEntityForFindTest.getItem3()).isEqualTo(
                matchParticipantEntityAForTest.getItem3());
        assertThat(matchParticipantEntityForFindTest.getItem4()).isEqualTo(
                matchParticipantEntityAForTest.getItem4());
        assertThat(matchParticipantEntityForFindTest.getItem5()).isEqualTo(
                matchParticipantEntityAForTest.getItem5());
        assertThat(matchParticipantEntityForFindTest.getItem6()).isEqualTo(
                matchParticipantEntityAForTest.getItem6());
        assertThat(matchParticipantEntityForFindTest.getItemsPurchased()).isEqualTo(
                matchParticipantEntityAForTest.getItemsPurchased());
        assertThat(matchParticipantEntityForFindTest.getKillingSprees()).isEqualTo(
                matchParticipantEntityAForTest.getKillingSprees());
        assertThat(matchParticipantEntityForFindTest.getKills()).isEqualTo(
                matchParticipantEntityAForTest.getKills());
        assertThat(matchParticipantEntityForFindTest.getLane()).isEqualTo(
                matchParticipantEntityAForTest.getLane());
        assertThat(matchParticipantEntityForFindTest.getLargestCriticalStrike()).isEqualTo(
                matchParticipantEntityAForTest.getLargestCriticalStrike());
        assertThat(matchParticipantEntityForFindTest.getLargestKillingSpree()).isEqualTo(
                matchParticipantEntityAForTest.getLargestKillingSpree());
        assertThat(matchParticipantEntityForFindTest.getLongestTimeSpentLiving()).isEqualTo(
                matchParticipantEntityAForTest.getLongestTimeSpentLiving());
        assertThat(matchParticipantEntityForFindTest.getMagicDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getMagicDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getMagicDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getMagicDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getMagicDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getMagicDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getNeutralMinionsKilled()).isEqualTo(
                matchParticipantEntityAForTest.getNeutralMinionsKilled());
        assertThat(matchParticipantEntityForFindTest.getNexusKills()).isEqualTo(
                matchParticipantEntityAForTest.getNexusKills());
        assertThat(matchParticipantEntityForFindTest.getNexusLost()).isEqualTo(
                matchParticipantEntityAForTest.getNexusLost());
        assertThat(matchParticipantEntityForFindTest.getNexusTakedowns()).isEqualTo(
                matchParticipantEntityAForTest.getNexusTakedowns());
        assertThat(matchParticipantEntityForFindTest.getObjectivesStolen()).isEqualTo(
                matchParticipantEntityAForTest.getObjectivesStolen());
        assertThat(matchParticipantEntityForFindTest.getObjectivesStolenAssists()).isEqualTo(
                matchParticipantEntityAForTest.getObjectivesStolenAssists());
        assertThat(matchParticipantEntityForFindTest.getPentaKills()).isEqualTo(
                matchParticipantEntityAForTest.getPentaKills());
        assertThat(matchParticipantEntityForFindTest.getPhysicalDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getPhysicalDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getPhysicalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getPhysicalDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getPhysicalDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getPhysicalDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getProfileIcon()).isEqualTo(
                matchParticipantEntityAForTest.getProfileIcon());
        assertThat(matchParticipantEntityForFindTest.getQuadraKills()).isEqualTo(
                matchParticipantEntityAForTest.getQuadraKills());
        assertThat(matchParticipantEntityForFindTest.getRiotIdName()).isEqualTo(
                matchParticipantEntityAForTest.getRiotIdName());
        assertThat(matchParticipantEntityForFindTest.getRiotIdTagline()).isEqualTo(
                matchParticipantEntityAForTest.getRiotIdTagline());
        assertThat(matchParticipantEntityForFindTest.getRole()).isEqualTo(
                matchParticipantEntityAForTest.getRole());
        assertThat(matchParticipantEntityForFindTest.getSightWardsBoughtInGame()).isEqualTo(
                matchParticipantEntityAForTest.getSightWardsBoughtInGame());
        assertThat(matchParticipantEntityForFindTest.getSpell1Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell1Casts());
        assertThat(matchParticipantEntityForFindTest.getSpell2Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell2Casts());
        assertThat(matchParticipantEntityForFindTest.getSpell3Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell3Casts());
        assertThat(matchParticipantEntityForFindTest.getSpell4Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSpell4Casts());
        assertThat(matchParticipantEntityForFindTest.getSummoner1Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner1Casts());
        assertThat(matchParticipantEntityForFindTest.getSummoner1Id()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner1Id());
        assertThat(matchParticipantEntityForFindTest.getSummoner2Casts()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner2Casts());
        assertThat(matchParticipantEntityForFindTest.getSummoner2Id()).isEqualTo(
                matchParticipantEntityAForTest.getSummoner2Id());
        assertThat(matchParticipantEntityForFindTest.getSummonerId()).isEqualTo(
                matchParticipantEntityAForTest.getSummonerId());
        assertThat(matchParticipantEntityForFindTest.getSummonerLevel()).isEqualTo(
                matchParticipantEntityAForTest.getSummonerLevel());
        assertThat(matchParticipantEntityForFindTest.getSummonerName()).isEqualTo(
                matchParticipantEntityAForTest.getSummonerName());
        assertThat(matchParticipantEntityForFindTest.isTeamEarlySurrendered()).isEqualTo(
                matchParticipantEntityAForTest.isTeamEarlySurrendered());
        assertThat(matchParticipantEntityForFindTest.getTeamId()).isEqualTo(
                matchParticipantEntityAForTest.getTeamId());
        assertThat(matchParticipantEntityForFindTest.getTeamPosition()).isEqualTo(
                matchParticipantEntityAForTest.getTeamPosition());
        assertThat(matchParticipantEntityForFindTest.getTimeCCingOthers()).isEqualTo(
                matchParticipantEntityAForTest.getTimeCCingOthers());
        assertThat(matchParticipantEntityForFindTest.getTimePlayed()).isEqualTo(
                matchParticipantEntityAForTest.getTimePlayed());
        assertThat(matchParticipantEntityForFindTest.getTotalDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getTotalDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getTotalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getTotalDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getTotalDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getTotalDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getTotalHeal()).isEqualTo(
                matchParticipantEntityAForTest.getTotalHeal());
        assertThat(matchParticipantEntityForFindTest.getTotalHealsOnTeammates()).isEqualTo(
                matchParticipantEntityAForTest.getTotalHealsOnTeammates());
        assertThat(matchParticipantEntityForFindTest.getTotalMinionsKilled()).isEqualTo(
                matchParticipantEntityAForTest.getTotalMinionsKilled());
        assertThat(matchParticipantEntityForFindTest.getTotalTimeCCDealt()).isEqualTo(
                matchParticipantEntityAForTest.getTotalTimeCCDealt());
        assertThat(matchParticipantEntityForFindTest.getTotalTimeSpentDead()).isEqualTo(
                matchParticipantEntityAForTest.getTotalTimeSpentDead());
        assertThat(matchParticipantEntityForFindTest.getTotalUnitsHealed()).isEqualTo(
                matchParticipantEntityAForTest.getTotalUnitsHealed());
        assertThat(matchParticipantEntityForFindTest.getTripleKills()).isEqualTo(
                matchParticipantEntityAForTest.getTripleKills());
        assertThat(matchParticipantEntityForFindTest.getTrueDamageDealt()).isEqualTo(
                matchParticipantEntityAForTest.getTrueDamageDealt());
        assertThat(matchParticipantEntityForFindTest.getTrueDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityAForTest.getTrueDamageDealtToChampions());
        assertThat(matchParticipantEntityForFindTest.getTrueDamageTaken()).isEqualTo(
                matchParticipantEntityAForTest.getTrueDamageTaken());
        assertThat(matchParticipantEntityForFindTest.getTurretKills()).isEqualTo(
                matchParticipantEntityAForTest.getTurretKills());
        assertThat(matchParticipantEntityForFindTest.getTurretTakedowns()).isEqualTo(
                matchParticipantEntityAForTest.getTurretTakedowns());
        assertThat(matchParticipantEntityForFindTest.getTurretsLost()).isEqualTo(
                matchParticipantEntityAForTest.getTurretsLost());
        assertThat(matchParticipantEntityForFindTest.getUnrealKills()).isEqualTo(
                matchParticipantEntityAForTest.getUnrealKills());
        assertThat(matchParticipantEntityForFindTest.getVisionScore()).isEqualTo(
                matchParticipantEntityAForTest.getVisionScore());
        assertThat(matchParticipantEntityForFindTest.getVisionWardsBoughtInGame()).isEqualTo(
                matchParticipantEntityAForTest.getVisionWardsBoughtInGame());
        assertThat(matchParticipantEntityForFindTest.getWardsKilled()).isEqualTo(
                matchParticipantEntityAForTest.getWardsKilled());
        assertThat(matchParticipantEntityForFindTest.getWardsPlaced()).isEqualTo(
                matchParticipantEntityAForTest.getWardsPlaced());
        assertThat(matchParticipantEntityForFindTest.isWin()).isEqualTo(
                matchParticipantEntityAForTest.isWin());
        assertThat(matchParticipantEntityForFindTest.getRrt()).isEqualTo(
                matchParticipantEntityAForTest.getRrt());
    }

    private MatchParticipantEntity createMatchParticipantEntityA() {
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

    private MatchParticipantEntity createMatchParticipantEntityB() {
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
}
