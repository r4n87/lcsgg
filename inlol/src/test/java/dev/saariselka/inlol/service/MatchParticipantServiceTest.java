package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.entity.MatchParticipantId;
import dev.saariselka.inlol.repository.MatchParticipantRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MatchParticipantServiceTest {

    @Autowired
    private MatchParticipantService matchParticipantService;
    @Autowired
    private MatchParticipantRepository matchParticipantRepository;

    @Test
    @DisplayName("Insert Entity")
    public void insert() {
        //given
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

        //when
        matchParticipantService.insert(puuid, dataVersion, matchId, assists, baronKills,
                bountyLevel, champExperience, champLevel, championId, championName, championTransform, consumablesPurchased, damageDealtToBuildings,
                damageDealtToObjectives, damageDealtToTurrets, damageSelfMitigated, deaths, detectorWardsPlaced, doubleKills, dragonKills,
                firstBloodAssist, firstBloodKill, firstTowerAssist, firstTowerKill, gameEndedInEarlySurrender, gameEndedInSurrender, goldEarned,
                goldSpent, individualPosition, inhibitorKills, inhibitorTakedowns, inhibitorsLost, item0, item1, item2, item3, item4, item5, item6,
                itemsPurchased, killingSprees, kills, lane, largestCriticalStrike, largestKillingSpree, largestMultiKill, longestTimeSpentLiving,
                magicDamageDealt, magicDamageDealtToChampions, magicDamageTaken, neutralMinionsKilled, nexusKills, nexusTakedowns, nexusLost,
                objectivesStolen, objectivesStolenAssists, participantId, pentaKills, physicalDamageDealt, physicalDamageDealtToChampions,
                physicalDamageTaken, profileIcon, quadraKills, riotIdName, riotIdTagline, role, sightWardsBoughtInGame, spell1Casts, spell2Casts,
                spell3Casts, spell4Casts, summoner1Casts, summoner1Id, summoner2Casts, summoner2Id, summonerId, summonerLevel, summonerName,
                teamEarlySurrendered, teamId, teamPosition, timeCCingOthers, timePlayed, totalDamageDealt, totalDamageDealtToChampions,
                totalDamageShieldedOnTeammates, totalDamageTaken, totalHeal, totalHealsOnTeammates, totalMinionsKilled, totalTimeCCDealt,
                totalTimeSpentDead, totalUnitsHealed, tripleKills, trueDamageDealt, trueDamageDealtToChampions, trueDamageTaken, turretKills,
                turretTakedowns, turretsLost, unrealKills, visionScore, visionWardsBoughtInGame, wardsKilled, wardsPlaced, win, rrt);

        //then
        MatchParticipantEntity matchParticipantEntity = matchParticipantService.findById(new MatchParticipantId(puuid, dataVersion, matchId, participantId)).get(0);

        assertThat(matchParticipantEntity.getMatchParticipantId().getPuuid()).isEqualTo(puuid);
        assertThat(matchParticipantEntity.getMatchParticipantId().getDataVersion()).isEqualTo(dataVersion);
        assertThat(matchParticipantEntity.getMatchParticipantId().getMatchId()).isEqualTo(matchId);
        assertThat(matchParticipantEntity.getMatchParticipantId().getParticipantId()).isEqualTo(participantId);
        assertThat(matchParticipantEntity.getAssists()).isEqualTo(assists);
        assertThat(matchParticipantEntity.getBaronKills()).isEqualTo(baronKills);
        assertThat(matchParticipantEntity.getBountyLevel()).isEqualTo(bountyLevel);
        assertThat(matchParticipantEntity.getChampExperience()).isEqualTo(champExperience);
        assertThat(matchParticipantEntity.getChampLevel()).isEqualTo(champLevel);
        assertThat(matchParticipantEntity.getChampionId()).isEqualTo(championId);
        assertThat(matchParticipantEntity.getChampionName()).isEqualTo(championName);
        assertThat(matchParticipantEntity.getChampionTransform()).isEqualTo(championTransform);
        assertThat(matchParticipantEntity.getConsumablesPurchased()).isEqualTo(consumablesPurchased);
        assertThat(matchParticipantEntity.getDamageDealtToBuildings()).isEqualTo(damageDealtToBuildings);
        assertThat(matchParticipantEntity.getDamageDealtToObjectives()).isEqualTo(damageDealtToObjectives);
        assertThat(matchParticipantEntity.getDamageSelfMitigated()).isEqualTo(damageSelfMitigated);
        assertThat(matchParticipantEntity.getDeaths()).isEqualTo(deaths);
        assertThat(matchParticipantEntity.getDetectorWardsPlaced()).isEqualTo(detectorWardsPlaced);
        assertThat(matchParticipantEntity.getDoubleKills()).isEqualTo(doubleKills);
        assertThat(matchParticipantEntity.getDragonKills()).isEqualTo(dragonKills);
        assertThat(matchParticipantEntity.isFirstBloodAssist()).isEqualTo(firstBloodAssist);
        assertThat(matchParticipantEntity.isFirstBloodKill()).isEqualTo(firstBloodKill);
        assertThat(matchParticipantEntity.isFirstTowerAssist()).isEqualTo(firstTowerAssist);
        assertThat(matchParticipantEntity.isFirstTowerKill()).isEqualTo(firstTowerKill);
        assertThat(matchParticipantEntity.isGameEndedInEarlySurrender()).isEqualTo(gameEndedInEarlySurrender);
        assertThat(matchParticipantEntity.isGameEndedInSurrender()).isEqualTo(gameEndedInSurrender);
        assertThat(matchParticipantEntity.getGoldEarned()).isEqualTo(goldEarned);
        assertThat(matchParticipantEntity.getGoldSpent()).isEqualTo(goldSpent);
        assertThat(matchParticipantEntity.getIndividualPosition()).isEqualTo(individualPosition);
        assertThat(matchParticipantEntity.getInhibitorKills()).isEqualTo(inhibitorKills);
        assertThat(matchParticipantEntity.getInhibitorTakedowns()).isEqualTo(inhibitorTakedowns);
        assertThat(matchParticipantEntity.getInhibitorsLost()).isEqualTo(inhibitorsLost);
        assertThat(matchParticipantEntity.getItem0()).isEqualTo(item0);
        assertThat(matchParticipantEntity.getItem1()).isEqualTo(item1);
        assertThat(matchParticipantEntity.getItem2()).isEqualTo(item2);
        assertThat(matchParticipantEntity.getItem3()).isEqualTo(item3);
        assertThat(matchParticipantEntity.getItem4()).isEqualTo(item4);
        assertThat(matchParticipantEntity.getItem5()).isEqualTo(item5);
        assertThat(matchParticipantEntity.getItem6()).isEqualTo(item6);
        assertThat(matchParticipantEntity.getItemsPurchased()).isEqualTo(itemsPurchased);
        assertThat(matchParticipantEntity.getKillingSprees()).isEqualTo(killingSprees);
        assertThat(matchParticipantEntity.getKills()).isEqualTo(kills);
        assertThat(matchParticipantEntity.getLane()).isEqualTo(lane);
        assertThat(matchParticipantEntity.getLargestCriticalStrike()).isEqualTo(largestCriticalStrike);
        assertThat(matchParticipantEntity.getLargestKillingSpree()).isEqualTo(largestKillingSpree);
        assertThat(matchParticipantEntity.getLongestTimeSpentLiving()).isEqualTo(longestTimeSpentLiving);
        assertThat(matchParticipantEntity.getMagicDamageDealt()).isEqualTo(magicDamageDealt);
        assertThat(matchParticipantEntity.getMagicDamageDealtToChampions()).isEqualTo(magicDamageDealtToChampions);
        assertThat(matchParticipantEntity.getMagicDamageTaken()).isEqualTo(magicDamageTaken);
        assertThat(matchParticipantEntity.getNeutralMinionsKilled()).isEqualTo(neutralMinionsKilled);
        assertThat(matchParticipantEntity.getNexusKills()).isEqualTo(nexusKills);
        assertThat(matchParticipantEntity.getNexusLost()).isEqualTo(nexusLost);
        assertThat(matchParticipantEntity.getNexusTakedowns()).isEqualTo(nexusTakedowns);
        assertThat(matchParticipantEntity.getObjectivesStolen()).isEqualTo(objectivesStolen);
        assertThat(matchParticipantEntity.getObjectivesStolenAssists()).isEqualTo(objectivesStolenAssists);
        assertThat(matchParticipantEntity.getPentaKills()).isEqualTo(pentaKills);
        assertThat(matchParticipantEntity.getPhysicalDamageDealt()).isEqualTo(physicalDamageDealt);
        assertThat(matchParticipantEntity.getPhysicalDamageDealtToChampions()).isEqualTo(physicalDamageDealtToChampions);
        assertThat(matchParticipantEntity.getPhysicalDamageTaken()).isEqualTo(physicalDamageTaken);
        assertThat(matchParticipantEntity.getProfileIcon()).isEqualTo(profileIcon);
        assertThat(matchParticipantEntity.getQuadraKills()).isEqualTo(quadraKills);
        assertThat(matchParticipantEntity.getRiotIdName()).isEqualTo(riotIdName);
        assertThat(matchParticipantEntity.getRiotIdTagline()).isEqualTo(riotIdTagline);
        assertThat(matchParticipantEntity.getRole()).isEqualTo(role);
        assertThat(matchParticipantEntity.getSightWardsBoughtInGame()).isEqualTo(sightWardsBoughtInGame);
        assertThat(matchParticipantEntity.getSpell1Casts()).isEqualTo(spell1Casts);
        assertThat(matchParticipantEntity.getSpell2Casts()).isEqualTo(spell2Casts);
        assertThat(matchParticipantEntity.getSpell3Casts()).isEqualTo(spell3Casts);
        assertThat(matchParticipantEntity.getSpell4Casts()).isEqualTo(spell4Casts);
        assertThat(matchParticipantEntity.getSummoner1Casts()).isEqualTo(summoner1Casts);
        assertThat(matchParticipantEntity.getSummoner1Id()).isEqualTo(summoner1Id);
        assertThat(matchParticipantEntity.getSummoner2Casts()).isEqualTo(summoner2Casts);
        assertThat(matchParticipantEntity.getSummoner2Id()).isEqualTo(summoner2Id);
        assertThat(matchParticipantEntity.getSummonerId()).isEqualTo(summonerId);
        assertThat(matchParticipantEntity.getSummonerLevel()).isEqualTo(summonerLevel);
        assertThat(matchParticipantEntity.getSummonerName()).isEqualTo(summonerName);
        assertThat(matchParticipantEntity.isTeamEarlySurrendered()).isEqualTo(teamEarlySurrendered);
        assertThat(matchParticipantEntity.getTeamId()).isEqualTo(teamId);
        assertThat(matchParticipantEntity.getTeamPosition()).isEqualTo(teamPosition);
        assertThat(matchParticipantEntity.getTimeCCingOthers()).isEqualTo(timeCCingOthers);
        assertThat(matchParticipantEntity.getTimePlayed()).isEqualTo(timePlayed);
        assertThat(matchParticipantEntity.getTotalDamageDealt()).isEqualTo(totalDamageDealt);
        assertThat(matchParticipantEntity.getTotalDamageDealtToChampions()).isEqualTo(totalDamageDealtToChampions);
        assertThat(matchParticipantEntity.getTotalDamageTaken()).isEqualTo(totalDamageTaken);
        assertThat(matchParticipantEntity.getTotalHeal()).isEqualTo(totalHeal);
        assertThat(matchParticipantEntity.getTotalHealsOnTeammates()).isEqualTo(totalHealsOnTeammates);
        assertThat(matchParticipantEntity.getTotalMinionsKilled()).isEqualTo(totalMinionsKilled);
        assertThat(matchParticipantEntity.getTotalTimeCCDealt()).isEqualTo(totalTimeCCDealt);
        assertThat(matchParticipantEntity.getTotalTimeSpentDead()).isEqualTo(totalTimeSpentDead);
        assertThat(matchParticipantEntity.getTotalUnitsHealed()).isEqualTo(totalUnitsHealed);
        assertThat(matchParticipantEntity.getTripleKills()).isEqualTo(tripleKills);
        assertThat(matchParticipantEntity.getTrueDamageDealt()).isEqualTo(trueDamageDealt);
        assertThat(matchParticipantEntity.getTrueDamageDealtToChampions()).isEqualTo(trueDamageDealtToChampions);
        assertThat(matchParticipantEntity.getTrueDamageTaken()).isEqualTo(trueDamageTaken);
        assertThat(matchParticipantEntity.getTurretKills()).isEqualTo(turretKills);
        assertThat(matchParticipantEntity.getTurretTakedowns()).isEqualTo(turretTakedowns);
        assertThat(matchParticipantEntity.getTurretsLost()).isEqualTo(turretsLost);
        assertThat(matchParticipantEntity.getUnrealKills()).isEqualTo(unrealKills);
        assertThat(matchParticipantEntity.getVisionScore()).isEqualTo(visionScore);
        assertThat(matchParticipantEntity.getVisionWardsBoughtInGame()).isEqualTo(visionWardsBoughtInGame);
        assertThat(matchParticipantEntity.getWardsKilled()).isEqualTo(wardsKilled);
        assertThat(matchParticipantEntity.getWardsPlaced()).isEqualTo(wardsPlaced);
        assertThat(matchParticipantEntity.isWin()).isEqualTo(win);
        assertThat(matchParticipantEntity.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Find Entity By Id")
    public void findById() {
        //given
        MatchParticipantEntity matchParticipantEntity = createMatchParticipantEntityA();
        MatchParticipantEntity matchParticipantEntityForTest = matchParticipantRepository.save(matchParticipantEntity);

        //when
        MatchParticipantEntity matchParticipantEntityFindById
                = matchParticipantService.findById(matchParticipantEntityForTest.getMatchParticipantId()).get(0);

        //then
        assertFunction(matchParticipantEntityFindById, matchParticipantEntityForTest);
    }

    @Test
    @DisplayName("Find Entity By DataVersion, MatchId")
    public void findByMatchParticipantId_DataVersionAndMatchParticipantId_MatchId() {
        //given
        MatchParticipantEntity matchParticipantEntityA = createMatchParticipantEntityA();
        MatchParticipantEntity matchParticipantEntityB = createMatchParticipantEntityB();
        MatchParticipantEntity matchParticipantEntityAForTest
                = matchParticipantRepository.save(matchParticipantEntityA);
        MatchParticipantEntity matchParticipantEntityBForTest
                = matchParticipantRepository.save(matchParticipantEntityB);

        //when
        List<MatchParticipantEntity> matchParticipantEntityList
                = matchParticipantService.findByDataVersionAndMatchId(
                matchParticipantEntityA.getMatchParticipantId().getDataVersion(),
                matchParticipantEntityB.getMatchParticipantId().getMatchId());

        //then
        assertThat(matchParticipantEntityList.size()).isEqualTo(2);
        for(MatchParticipantEntity matchParticipantEntity : matchParticipantEntityList) {
            String puuid = matchParticipantEntity.getMatchParticipantId().getPuuid();
            String puuidA = matchParticipantEntityAForTest.getMatchParticipantId().getPuuid();
            String puuidB = matchParticipantEntityBForTest.getMatchParticipantId().getPuuid();

            if(puuid.equals(puuidA)) {
                assertFunction(matchParticipantEntity, matchParticipantEntityAForTest);
            } else if (puuid.equals(puuidB)) {
                assertFunction(matchParticipantEntity, matchParticipantEntityBForTest);
            }
        }
    }

    @Test
    @DisplayName("Find Entity By Puuid")
    public void findByPuuid() {
        //given
        MatchParticipantEntity matchParticipantEntityA = createMatchParticipantEntityA();
        MatchParticipantEntity matchParticipantEntityB = createMatchParticipantEntityB();
        MatchParticipantEntity matchParticipantEntityAForTest
                = matchParticipantRepository.save(matchParticipantEntityA);
        MatchParticipantEntity matchParticipantEntityBForTest
                = matchParticipantRepository.save(matchParticipantEntityB);

        //when
        MatchParticipantEntity matchParticipantEntityAFindByPuuid
                = matchParticipantService.findByPuuid(matchParticipantEntityAForTest.getMatchParticipantId().getPuuid()).get(0);
        MatchParticipantEntity matchParticipantEntityBFindByPuuid
                = matchParticipantService.findByPuuid(matchParticipantEntityBForTest.getMatchParticipantId().getPuuid()).get(0);

        //then
        assertFunction(matchParticipantEntityAFindByPuuid, matchParticipantEntityAForTest);
        assertFunction(matchParticipantEntityBFindByPuuid, matchParticipantEntityBForTest);
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

    private MatchParticipantEntity createMatchParticipantEntityB() {
        String puuid = "UUUUUUUU";
        String dataVersion = "2";
        String matchId = "AAAAAA";
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

    private void assertFunction(MatchParticipantEntity matchParticipantEntity, MatchParticipantEntity matchParticipantEntityForTest) {
        assertThat(matchParticipantEntity.getMatchParticipantId().getPuuid()).isEqualTo(
                matchParticipantEntityForTest.getMatchParticipantId().getPuuid());
        assertThat(matchParticipantEntity.getMatchParticipantId().getDataVersion()).isEqualTo(
                matchParticipantEntityForTest.getMatchParticipantId().getDataVersion());
        assertThat(matchParticipantEntity.getMatchParticipantId().getMatchId()).isEqualTo(
                matchParticipantEntityForTest.getMatchParticipantId().getMatchId());
        assertThat(matchParticipantEntity.getMatchParticipantId().getParticipantId()).isEqualTo(
                matchParticipantEntityForTest.getMatchParticipantId().getParticipantId());
        assertThat(matchParticipantEntity.getAssists()).isEqualTo(
                matchParticipantEntityForTest.getAssists());
        assertThat(matchParticipantEntity.getBaronKills()).isEqualTo(
                matchParticipantEntityForTest.getBaronKills());
        assertThat(matchParticipantEntity.getBountyLevel()).isEqualTo(
                matchParticipantEntityForTest.getBountyLevel());
        assertThat(matchParticipantEntity.getChampExperience()).isEqualTo(
                matchParticipantEntityForTest.getChampExperience());
        assertThat(matchParticipantEntity.getChampLevel()).isEqualTo(
                matchParticipantEntityForTest.getChampLevel());
        assertThat(matchParticipantEntity.getChampionId()).isEqualTo(
                matchParticipantEntityForTest.getChampionId());
        assertThat(matchParticipantEntity.getChampionName()).isEqualTo(
                matchParticipantEntityForTest.getChampionName());
        assertThat(matchParticipantEntity.getChampionTransform()).isEqualTo(
                matchParticipantEntityForTest.getChampionTransform());
        assertThat(matchParticipantEntity.getConsumablesPurchased()).isEqualTo(
                matchParticipantEntityForTest.getConsumablesPurchased());
        assertThat(matchParticipantEntity.getDamageDealtToBuildings()).isEqualTo(
                matchParticipantEntityForTest.getDamageDealtToBuildings());
        assertThat(matchParticipantEntity.getDamageDealtToObjectives()).isEqualTo(
                matchParticipantEntityForTest.getDamageDealtToObjectives());
        assertThat(matchParticipantEntity.getDamageSelfMitigated()).isEqualTo(
                matchParticipantEntityForTest.getDamageSelfMitigated());
        assertThat(matchParticipantEntity.getDeaths()).isEqualTo(
                matchParticipantEntityForTest.getDeaths());
        assertThat(matchParticipantEntity.getDetectorWardsPlaced()).isEqualTo(
                matchParticipantEntityForTest.getDetectorWardsPlaced());
        assertThat(matchParticipantEntity.getDoubleKills()).isEqualTo(
                matchParticipantEntityForTest.getDoubleKills());
        assertThat(matchParticipantEntity.getDragonKills()).isEqualTo(
                matchParticipantEntityForTest.getDragonKills());
        assertThat(matchParticipantEntity.isFirstBloodAssist()).isEqualTo(
                matchParticipantEntityForTest.isFirstBloodAssist());
        assertThat(matchParticipantEntity.isFirstBloodKill()).isEqualTo(
                matchParticipantEntityForTest.isFirstBloodKill());
        assertThat(matchParticipantEntity.isFirstTowerAssist()).isEqualTo(
                matchParticipantEntityForTest.isFirstTowerAssist());
        assertThat(matchParticipantEntity.isFirstTowerKill()).isEqualTo(
                matchParticipantEntityForTest.isFirstTowerKill());
        assertThat(matchParticipantEntity.isGameEndedInEarlySurrender()).isEqualTo(
                matchParticipantEntityForTest.isGameEndedInEarlySurrender());
        assertThat(matchParticipantEntity.isGameEndedInSurrender()).isEqualTo(
                matchParticipantEntityForTest.isGameEndedInSurrender());
        assertThat(matchParticipantEntity.getGoldEarned()).isEqualTo(
                matchParticipantEntityForTest.getGoldEarned());
        assertThat(matchParticipantEntity.getGoldSpent()).isEqualTo(
                matchParticipantEntityForTest.getGoldSpent());
        assertThat(matchParticipantEntity.getIndividualPosition()).isEqualTo(
                matchParticipantEntityForTest.getIndividualPosition());
        assertThat(matchParticipantEntity.getInhibitorKills()).isEqualTo(
                matchParticipantEntityForTest.getInhibitorKills());
        assertThat(matchParticipantEntity.getInhibitorTakedowns()).isEqualTo(
                matchParticipantEntityForTest.getInhibitorTakedowns());
        assertThat(matchParticipantEntity.getInhibitorsLost()).isEqualTo(
                matchParticipantEntityForTest.getInhibitorsLost());
        assertThat(matchParticipantEntity.getItem0()).isEqualTo(
                matchParticipantEntityForTest.getItem0());
        assertThat(matchParticipantEntity.getItem1()).isEqualTo(
                matchParticipantEntityForTest.getItem1());
        assertThat(matchParticipantEntity.getItem2()).isEqualTo(
                matchParticipantEntityForTest.getItem2());
        assertThat(matchParticipantEntity.getItem3()).isEqualTo(
                matchParticipantEntityForTest.getItem3());
        assertThat(matchParticipantEntity.getItem4()).isEqualTo(
                matchParticipantEntityForTest.getItem4());
        assertThat(matchParticipantEntity.getItem5()).isEqualTo(
                matchParticipantEntityForTest.getItem5());
        assertThat(matchParticipantEntity.getItem6()).isEqualTo(
                matchParticipantEntityForTest.getItem6());
        assertThat(matchParticipantEntity.getItemsPurchased()).isEqualTo(
                matchParticipantEntityForTest.getItemsPurchased());
        assertThat(matchParticipantEntity.getKillingSprees()).isEqualTo(
                matchParticipantEntityForTest.getKillingSprees());
        assertThat(matchParticipantEntity.getKills()).isEqualTo(
                matchParticipantEntityForTest.getKills());
        assertThat(matchParticipantEntity.getLane()).isEqualTo(
                matchParticipantEntityForTest.getLane());
        assertThat(matchParticipantEntity.getLargestCriticalStrike()).isEqualTo(
                matchParticipantEntityForTest.getLargestCriticalStrike());
        assertThat(matchParticipantEntity.getLargestKillingSpree()).isEqualTo(
                matchParticipantEntityForTest.getLargestKillingSpree());
        assertThat(matchParticipantEntity.getLongestTimeSpentLiving()).isEqualTo(
                matchParticipantEntityForTest.getLongestTimeSpentLiving());
        assertThat(matchParticipantEntity.getMagicDamageDealt()).isEqualTo(
                matchParticipantEntityForTest.getMagicDamageDealt());
        assertThat(matchParticipantEntity.getMagicDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityForTest.getMagicDamageDealtToChampions());
        assertThat(matchParticipantEntity.getMagicDamageTaken()).isEqualTo(
                matchParticipantEntityForTest.getMagicDamageTaken());
        assertThat(matchParticipantEntity.getNeutralMinionsKilled()).isEqualTo(
                matchParticipantEntityForTest.getNeutralMinionsKilled());
        assertThat(matchParticipantEntity.getNexusKills()).isEqualTo(
                matchParticipantEntityForTest.getNexusKills());
        assertThat(matchParticipantEntity.getNexusLost()).isEqualTo(
                matchParticipantEntityForTest.getNexusLost());
        assertThat(matchParticipantEntity.getNexusTakedowns()).isEqualTo(
                matchParticipantEntityForTest.getNexusTakedowns());
        assertThat(matchParticipantEntity.getObjectivesStolen()).isEqualTo(
                matchParticipantEntityForTest.getObjectivesStolen());
        assertThat(matchParticipantEntity.getObjectivesStolenAssists()).isEqualTo(
                matchParticipantEntityForTest.getObjectivesStolenAssists());
        assertThat(matchParticipantEntity.getPentaKills()).isEqualTo(
                matchParticipantEntityForTest.getPentaKills());
        assertThat(matchParticipantEntity.getPhysicalDamageDealt()).isEqualTo(
                matchParticipantEntityForTest.getPhysicalDamageDealt());
        assertThat(matchParticipantEntity.getPhysicalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityForTest.getPhysicalDamageDealtToChampions());
        assertThat(matchParticipantEntity.getPhysicalDamageTaken()).isEqualTo(
                matchParticipantEntityForTest.getPhysicalDamageTaken());
        assertThat(matchParticipantEntity.getProfileIcon()).isEqualTo(
                matchParticipantEntityForTest.getProfileIcon());
        assertThat(matchParticipantEntity.getQuadraKills()).isEqualTo(
                matchParticipantEntityForTest.getQuadraKills());
        assertThat(matchParticipantEntity.getRiotIdName()).isEqualTo(
                matchParticipantEntityForTest.getRiotIdName());
        assertThat(matchParticipantEntity.getRiotIdTagline()).isEqualTo(
                matchParticipantEntityForTest.getRiotIdTagline());
        assertThat(matchParticipantEntity.getRole()).isEqualTo(
                matchParticipantEntityForTest.getRole());
        assertThat(matchParticipantEntity.getSightWardsBoughtInGame()).isEqualTo(
                matchParticipantEntityForTest.getSightWardsBoughtInGame());
        assertThat(matchParticipantEntity.getSpell1Casts()).isEqualTo(
                matchParticipantEntityForTest.getSpell1Casts());
        assertThat(matchParticipantEntity.getSpell2Casts()).isEqualTo(
                matchParticipantEntityForTest.getSpell2Casts());
        assertThat(matchParticipantEntity.getSpell3Casts()).isEqualTo(
                matchParticipantEntityForTest.getSpell3Casts());
        assertThat(matchParticipantEntity.getSpell4Casts()).isEqualTo(
                matchParticipantEntityForTest.getSpell4Casts());
        assertThat(matchParticipantEntity.getSummoner1Casts()).isEqualTo(
                matchParticipantEntityForTest.getSummoner1Casts());
        assertThat(matchParticipantEntity.getSummoner1Id()).isEqualTo(
                matchParticipantEntityForTest.getSummoner1Id());
        assertThat(matchParticipantEntity.getSummoner2Casts()).isEqualTo(
                matchParticipantEntityForTest.getSummoner2Casts());
        assertThat(matchParticipantEntity.getSummoner2Id()).isEqualTo(
                matchParticipantEntityForTest.getSummoner2Id());
        assertThat(matchParticipantEntity.getSummonerId()).isEqualTo(
                matchParticipantEntityForTest.getSummonerId());
        assertThat(matchParticipantEntity.getSummonerLevel()).isEqualTo(
                matchParticipantEntityForTest.getSummonerLevel());
        assertThat(matchParticipantEntity.getSummonerName()).isEqualTo(
                matchParticipantEntityForTest.getSummonerName());
        assertThat(matchParticipantEntity.isTeamEarlySurrendered()).isEqualTo(
                matchParticipantEntityForTest.isTeamEarlySurrendered());
        assertThat(matchParticipantEntity.getTeamId()).isEqualTo(
                matchParticipantEntityForTest.getTeamId());
        assertThat(matchParticipantEntity.getTeamPosition()).isEqualTo(
                matchParticipantEntityForTest.getTeamPosition());
        assertThat(matchParticipantEntity.getTimeCCingOthers()).isEqualTo(
                matchParticipantEntityForTest.getTimeCCingOthers());
        assertThat(matchParticipantEntity.getTimePlayed()).isEqualTo(
                matchParticipantEntityForTest.getTimePlayed());
        assertThat(matchParticipantEntity.getTotalDamageDealt()).isEqualTo(
                matchParticipantEntityForTest.getTotalDamageDealt());
        assertThat(matchParticipantEntity.getTotalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityForTest.getTotalDamageDealtToChampions());
        assertThat(matchParticipantEntity.getTotalDamageTaken()).isEqualTo(
                matchParticipantEntityForTest.getTotalDamageTaken());
        assertThat(matchParticipantEntity.getTotalHeal()).isEqualTo(
                matchParticipantEntityForTest.getTotalHeal());
        assertThat(matchParticipantEntity.getTotalHealsOnTeammates()).isEqualTo(
                matchParticipantEntityForTest.getTotalHealsOnTeammates());
        assertThat(matchParticipantEntity.getTotalMinionsKilled()).isEqualTo(
                matchParticipantEntityForTest.getTotalMinionsKilled());
        assertThat(matchParticipantEntity.getTotalTimeCCDealt()).isEqualTo(
                matchParticipantEntityForTest.getTotalTimeCCDealt());
        assertThat(matchParticipantEntity.getTotalTimeSpentDead()).isEqualTo(
                matchParticipantEntityForTest.getTotalTimeSpentDead());
        assertThat(matchParticipantEntity.getTotalUnitsHealed()).isEqualTo(
                matchParticipantEntityForTest.getTotalUnitsHealed());
        assertThat(matchParticipantEntity.getTripleKills()).isEqualTo(
                matchParticipantEntityForTest.getTripleKills());
        assertThat(matchParticipantEntity.getTrueDamageDealt()).isEqualTo(
                matchParticipantEntityForTest.getTrueDamageDealt());
        assertThat(matchParticipantEntity.getTrueDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityForTest.getTrueDamageDealtToChampions());
        assertThat(matchParticipantEntity.getTrueDamageTaken()).isEqualTo(
                matchParticipantEntityForTest.getTrueDamageTaken());
        assertThat(matchParticipantEntity.getTurretKills()).isEqualTo(
                matchParticipantEntityForTest.getTurretKills());
        assertThat(matchParticipantEntity.getTurretTakedowns()).isEqualTo(
                matchParticipantEntityForTest.getTurretTakedowns());
        assertThat(matchParticipantEntity.getTurretsLost()).isEqualTo(
                matchParticipantEntityForTest.getTurretsLost());
        assertThat(matchParticipantEntity.getUnrealKills()).isEqualTo(
                matchParticipantEntityForTest.getUnrealKills());
        assertThat(matchParticipantEntity.getVisionScore()).isEqualTo(
                matchParticipantEntityForTest.getVisionScore());
        assertThat(matchParticipantEntity.getVisionWardsBoughtInGame()).isEqualTo(
                matchParticipantEntityForTest.getVisionWardsBoughtInGame());
        assertThat(matchParticipantEntity.getWardsKilled()).isEqualTo(
                matchParticipantEntityForTest.getWardsKilled());
        assertThat(matchParticipantEntity.getWardsPlaced()).isEqualTo(
                matchParticipantEntityForTest.getWardsPlaced());
        assertThat(matchParticipantEntity.isWin()).isEqualTo(
                matchParticipantEntityForTest.isWin());
        assertThat(matchParticipantEntity.getRrt()).isEqualTo(
                matchParticipantEntityForTest.getRrt());
    }
}
