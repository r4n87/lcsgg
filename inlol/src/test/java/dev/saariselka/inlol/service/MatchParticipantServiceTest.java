package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.entity.MatchParticipantId;
import dev.saariselka.inlol.repository.MatchParticipantRepository;
import dev.saariselka.inlol.vo.MatchParticipantVO;
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
    @Autowired
    private VOMapper voMapper;

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

        //when
        matchParticipantService.insert(puuid, dataVersion, matchId, assists, baronKills,
                bountyLevel, champExperience, champLevel, championId, championName, championNameKR, championImg, championTransform, consumablesPurchased, damageDealtToBuildings,
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
        MatchParticipantVO matchParticipantVO = matchParticipantService.findById(new MatchParticipantId(puuid, dataVersion, matchId, participantId)).get(0);

        assertThat(matchParticipantVO.getPuuid()).isEqualTo(puuid);
        assertThat(matchParticipantVO.getDataVersion()).isEqualTo(dataVersion);
        assertThat(matchParticipantVO.getMatchId()).isEqualTo(matchId);
        assertThat(matchParticipantVO.getParticipantId()).isEqualTo(participantId);
        assertThat(matchParticipantVO.getAssists()).isEqualTo(assists);
        assertThat(matchParticipantVO.getBaronKills()).isEqualTo(baronKills);
        assertThat(matchParticipantVO.getBountyLevel()).isEqualTo(bountyLevel);
        assertThat(matchParticipantVO.getChampExperience()).isEqualTo(champExperience);
        assertThat(matchParticipantVO.getChampLevel()).isEqualTo(champLevel);
        assertThat(matchParticipantVO.getChampionId()).isEqualTo(championId);
        assertThat(matchParticipantVO.getChampionName()).isEqualTo(championName);
        assertThat(matchParticipantVO.getChampionTransform()).isEqualTo(championTransform);
        assertThat(matchParticipantVO.getConsumablesPurchased()).isEqualTo(consumablesPurchased);
        assertThat(matchParticipantVO.getDamageDealtToBuildings()).isEqualTo(damageDealtToBuildings);
        assertThat(matchParticipantVO.getDamageDealtToObjectives()).isEqualTo(damageDealtToObjectives);
        assertThat(matchParticipantVO.getDamageSelfMitigated()).isEqualTo(damageSelfMitigated);
        assertThat(matchParticipantVO.getDeaths()).isEqualTo(deaths);
        assertThat(matchParticipantVO.getDetectorWardsPlaced()).isEqualTo(detectorWardsPlaced);
        assertThat(matchParticipantVO.getDoubleKills()).isEqualTo(doubleKills);
        assertThat(matchParticipantVO.getDragonKills()).isEqualTo(dragonKills);
        assertThat(matchParticipantVO.isFirstBloodAssist()).isEqualTo(firstBloodAssist);
        assertThat(matchParticipantVO.isFirstBloodKill()).isEqualTo(firstBloodKill);
        assertThat(matchParticipantVO.isFirstTowerAssist()).isEqualTo(firstTowerAssist);
        assertThat(matchParticipantVO.isFirstTowerKill()).isEqualTo(firstTowerKill);
        assertThat(matchParticipantVO.isGameEndedInEarlySurrender()).isEqualTo(gameEndedInEarlySurrender);
        assertThat(matchParticipantVO.isGameEndedInSurrender()).isEqualTo(gameEndedInSurrender);
        assertThat(matchParticipantVO.getGoldEarned()).isEqualTo(goldEarned);
        assertThat(matchParticipantVO.getGoldSpent()).isEqualTo(goldSpent);
        assertThat(matchParticipantVO.getIndividualPosition()).isEqualTo(individualPosition);
        assertThat(matchParticipantVO.getInhibitorKills()).isEqualTo(inhibitorKills);
        assertThat(matchParticipantVO.getInhibitorTakedowns()).isEqualTo(inhibitorTakedowns);
        assertThat(matchParticipantVO.getInhibitorsLost()).isEqualTo(inhibitorsLost);
        assertThat(matchParticipantVO.getItem0()).isEqualTo(item0);
        assertThat(matchParticipantVO.getItem1()).isEqualTo(item1);
        assertThat(matchParticipantVO.getItem2()).isEqualTo(item2);
        assertThat(matchParticipantVO.getItem3()).isEqualTo(item3);
        assertThat(matchParticipantVO.getItem4()).isEqualTo(item4);
        assertThat(matchParticipantVO.getItem5()).isEqualTo(item5);
        assertThat(matchParticipantVO.getItem6()).isEqualTo(item6);
        assertThat(matchParticipantVO.getItemsPurchased()).isEqualTo(itemsPurchased);
        assertThat(matchParticipantVO.getKillingSprees()).isEqualTo(killingSprees);
        assertThat(matchParticipantVO.getKills()).isEqualTo(kills);
        assertThat(matchParticipantVO.getLane()).isEqualTo(lane);
        assertThat(matchParticipantVO.getLargestCriticalStrike()).isEqualTo(largestCriticalStrike);
        assertThat(matchParticipantVO.getLargestKillingSpree()).isEqualTo(largestKillingSpree);
        assertThat(matchParticipantVO.getLongestTimeSpentLiving()).isEqualTo(longestTimeSpentLiving);
        assertThat(matchParticipantVO.getMagicDamageDealt()).isEqualTo(magicDamageDealt);
        assertThat(matchParticipantVO.getMagicDamageDealtToChampions()).isEqualTo(magicDamageDealtToChampions);
        assertThat(matchParticipantVO.getMagicDamageTaken()).isEqualTo(magicDamageTaken);
        assertThat(matchParticipantVO.getNeutralMinionsKilled()).isEqualTo(neutralMinionsKilled);
        assertThat(matchParticipantVO.getNexusKills()).isEqualTo(nexusKills);
        assertThat(matchParticipantVO.getNexusLost()).isEqualTo(nexusLost);
        assertThat(matchParticipantVO.getNexusTakedowns()).isEqualTo(nexusTakedowns);
        assertThat(matchParticipantVO.getObjectivesStolen()).isEqualTo(objectivesStolen);
        assertThat(matchParticipantVO.getObjectivesStolenAssists()).isEqualTo(objectivesStolenAssists);
        assertThat(matchParticipantVO.getPentaKills()).isEqualTo(pentaKills);
        assertThat(matchParticipantVO.getPhysicalDamageDealt()).isEqualTo(physicalDamageDealt);
        assertThat(matchParticipantVO.getPhysicalDamageDealtToChampions()).isEqualTo(physicalDamageDealtToChampions);
        assertThat(matchParticipantVO.getPhysicalDamageTaken()).isEqualTo(physicalDamageTaken);
        assertThat(matchParticipantVO.getProfileIcon()).isEqualTo(profileIcon);
        assertThat(matchParticipantVO.getQuadraKills()).isEqualTo(quadraKills);
        assertThat(matchParticipantVO.getRiotIdName()).isEqualTo(riotIdName);
        assertThat(matchParticipantVO.getRiotIdTagline()).isEqualTo(riotIdTagline);
        assertThat(matchParticipantVO.getRole()).isEqualTo(role);
        assertThat(matchParticipantVO.getSightWardsBoughtInGame()).isEqualTo(sightWardsBoughtInGame);
        assertThat(matchParticipantVO.getSpell1Casts()).isEqualTo(spell1Casts);
        assertThat(matchParticipantVO.getSpell2Casts()).isEqualTo(spell2Casts);
        assertThat(matchParticipantVO.getSpell3Casts()).isEqualTo(spell3Casts);
        assertThat(matchParticipantVO.getSpell4Casts()).isEqualTo(spell4Casts);
        assertThat(matchParticipantVO.getSummoner1Casts()).isEqualTo(summoner1Casts);
        assertThat(matchParticipantVO.getSummoner1Id()).isEqualTo(summoner1Id);
        assertThat(matchParticipantVO.getSummoner2Casts()).isEqualTo(summoner2Casts);
        assertThat(matchParticipantVO.getSummoner2Id()).isEqualTo(summoner2Id);
        assertThat(matchParticipantVO.getSummonerId()).isEqualTo(summonerId);
        assertThat(matchParticipantVO.getSummonerLevel()).isEqualTo(summonerLevel);
        assertThat(matchParticipantVO.getSummonerName()).isEqualTo(summonerName);
        assertThat(matchParticipantVO.isTeamEarlySurrendered()).isEqualTo(teamEarlySurrendered);
        assertThat(matchParticipantVO.getTeamId()).isEqualTo(teamId);
        assertThat(matchParticipantVO.getTeamPosition()).isEqualTo(teamPosition);
        assertThat(matchParticipantVO.getTimeCCingOthers()).isEqualTo(timeCCingOthers);
        assertThat(matchParticipantVO.getTimePlayed()).isEqualTo(timePlayed);
        assertThat(matchParticipantVO.getTotalDamageDealt()).isEqualTo(totalDamageDealt);
        assertThat(matchParticipantVO.getTotalDamageDealtToChampions()).isEqualTo(totalDamageDealtToChampions);
        assertThat(matchParticipantVO.getTotalDamageTaken()).isEqualTo(totalDamageTaken);
        assertThat(matchParticipantVO.getTotalHeal()).isEqualTo(totalHeal);
        assertThat(matchParticipantVO.getTotalHealsOnTeammates()).isEqualTo(totalHealsOnTeammates);
        assertThat(matchParticipantVO.getTotalMinionsKilled()).isEqualTo(totalMinionsKilled);
        assertThat(matchParticipantVO.getTotalTimeCCDealt()).isEqualTo(totalTimeCCDealt);
        assertThat(matchParticipantVO.getTotalTimeSpentDead()).isEqualTo(totalTimeSpentDead);
        assertThat(matchParticipantVO.getTotalUnitsHealed()).isEqualTo(totalUnitsHealed);
        assertThat(matchParticipantVO.getTripleKills()).isEqualTo(tripleKills);
        assertThat(matchParticipantVO.getTrueDamageDealt()).isEqualTo(trueDamageDealt);
        assertThat(matchParticipantVO.getTrueDamageDealtToChampions()).isEqualTo(trueDamageDealtToChampions);
        assertThat(matchParticipantVO.getTrueDamageTaken()).isEqualTo(trueDamageTaken);
        assertThat(matchParticipantVO.getTurretKills()).isEqualTo(turretKills);
        assertThat(matchParticipantVO.getTurretTakedowns()).isEqualTo(turretTakedowns);
        assertThat(matchParticipantVO.getTurretsLost()).isEqualTo(turretsLost);
        assertThat(matchParticipantVO.getUnrealKills()).isEqualTo(unrealKills);
        assertThat(matchParticipantVO.getVisionScore()).isEqualTo(visionScore);
        assertThat(matchParticipantVO.getVisionWardsBoughtInGame()).isEqualTo(visionWardsBoughtInGame);
        assertThat(matchParticipantVO.getWardsKilled()).isEqualTo(wardsKilled);
        assertThat(matchParticipantVO.getWardsPlaced()).isEqualTo(wardsPlaced);
        assertThat(matchParticipantVO.isWin()).isEqualTo(win);
        assertThat(matchParticipantVO.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Find Entity By Id")
    public void findById() {
        //given
        MatchParticipantEntity matchParticipantEntity = createMatchParticipantEntityA();
        MatchParticipantEntity matchParticipantEntityForTest = matchParticipantRepository.save(matchParticipantEntity);

        //when
        MatchParticipantVO matchParticipantVOFindById
                = matchParticipantService.findById(matchParticipantEntityForTest.getMatchParticipantId()).get(0);

        //then
        assertFunction(matchParticipantVOFindById, matchParticipantEntityForTest);
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
        List<MatchParticipantVO> matchParticipantVOList
                = matchParticipantService.findByDataVersionAndMatchId(
                matchParticipantEntityAForTest.getMatchParticipantId().getDataVersion(),
                matchParticipantEntityAForTest.getMatchParticipantId().getMatchId());

        //then
        assertThat(matchParticipantVOList.size()).isEqualTo(2);
        for(MatchParticipantVO matchParticipantVO : matchParticipantVOList) {
            String puuid = matchParticipantVO.getPuuid();
            String puuidA = matchParticipantEntityAForTest.getMatchParticipantId().getPuuid();
            String puuidB = matchParticipantEntityBForTest.getMatchParticipantId().getPuuid();

            if(puuid.equals(puuidA)) {
                assertFunction(matchParticipantVO, matchParticipantEntityAForTest);
            } else if (puuid.equals(puuidB)) {
                assertFunction(matchParticipantVO, matchParticipantEntityBForTest);
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
        MatchParticipantVO matchParticipantVOAFindByPuuid
                = matchParticipantService.findByPuuid(matchParticipantEntityAForTest.getMatchParticipantId().getPuuid()).get(0);
        MatchParticipantVO matchParticipantVOBFindByPuuid
                = matchParticipantService.findByPuuid(matchParticipantEntityBForTest.getMatchParticipantId().getPuuid()).get(0);

        //then
        assertFunction(matchParticipantVOAFindByPuuid, matchParticipantEntityAForTest);
        assertFunction(matchParticipantVOBFindByPuuid, matchParticipantEntityBForTest);
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

    private void assertFunction(MatchParticipantVO matchParticipantVO, MatchParticipantEntity matchParticipantEntityForTest) {
        assertThat(matchParticipantVO.getPuuid()).isEqualTo(
                matchParticipantEntityForTest.getMatchParticipantId().getPuuid());
        assertThat(matchParticipantVO.getDataVersion()).isEqualTo(
                matchParticipantEntityForTest.getMatchParticipantId().getDataVersion());
        assertThat(matchParticipantVO.getMatchId()).isEqualTo(
                matchParticipantEntityForTest.getMatchParticipantId().getMatchId());
        assertThat(matchParticipantVO.getParticipantId()).isEqualTo(
                matchParticipantEntityForTest.getMatchParticipantId().getParticipantId());
        assertThat(matchParticipantVO.getAssists()).isEqualTo(
                matchParticipantEntityForTest.getAssists());
        assertThat(matchParticipantVO.getBaronKills()).isEqualTo(
                matchParticipantEntityForTest.getBaronKills());
        assertThat(matchParticipantVO.getBountyLevel()).isEqualTo(
                matchParticipantEntityForTest.getBountyLevel());
        assertThat(matchParticipantVO.getChampExperience()).isEqualTo(
                matchParticipantEntityForTest.getChampExperience());
        assertThat(matchParticipantVO.getChampLevel()).isEqualTo(
                matchParticipantEntityForTest.getChampLevel());
        assertThat(matchParticipantVO.getChampionId()).isEqualTo(
                matchParticipantEntityForTest.getChampionId());
        assertThat(matchParticipantVO.getChampionName()).isEqualTo(
                matchParticipantEntityForTest.getChampionName());
        assertThat(matchParticipantVO.getChampionTransform()).isEqualTo(
                matchParticipantEntityForTest.getChampionTransform());
        assertThat(matchParticipantVO.getConsumablesPurchased()).isEqualTo(
                matchParticipantEntityForTest.getConsumablesPurchased());
        assertThat(matchParticipantVO.getDamageDealtToBuildings()).isEqualTo(
                matchParticipantEntityForTest.getDamageDealtToBuildings());
        assertThat(matchParticipantVO.getDamageDealtToObjectives()).isEqualTo(
                matchParticipantEntityForTest.getDamageDealtToObjectives());
        assertThat(matchParticipantVO.getDamageSelfMitigated()).isEqualTo(
                matchParticipantEntityForTest.getDamageSelfMitigated());
        assertThat(matchParticipantVO.getDeaths()).isEqualTo(
                matchParticipantEntityForTest.getDeaths());
        assertThat(matchParticipantVO.getDetectorWardsPlaced()).isEqualTo(
                matchParticipantEntityForTest.getDetectorWardsPlaced());
        assertThat(matchParticipantVO.getDoubleKills()).isEqualTo(
                matchParticipantEntityForTest.getDoubleKills());
        assertThat(matchParticipantVO.getDragonKills()).isEqualTo(
                matchParticipantEntityForTest.getDragonKills());
        assertThat(matchParticipantVO.isFirstBloodAssist()).isEqualTo(
                matchParticipantEntityForTest.isFirstBloodAssist());
        assertThat(matchParticipantVO.isFirstBloodKill()).isEqualTo(
                matchParticipantEntityForTest.isFirstBloodKill());
        assertThat(matchParticipantVO.isFirstTowerAssist()).isEqualTo(
                matchParticipantEntityForTest.isFirstTowerAssist());
        assertThat(matchParticipantVO.isFirstTowerKill()).isEqualTo(
                matchParticipantEntityForTest.isFirstTowerKill());
        assertThat(matchParticipantVO.isGameEndedInEarlySurrender()).isEqualTo(
                matchParticipantEntityForTest.isGameEndedInEarlySurrender());
        assertThat(matchParticipantVO.isGameEndedInSurrender()).isEqualTo(
                matchParticipantEntityForTest.isGameEndedInSurrender());
        assertThat(matchParticipantVO.getGoldEarned()).isEqualTo(
                matchParticipantEntityForTest.getGoldEarned());
        assertThat(matchParticipantVO.getGoldSpent()).isEqualTo(
                matchParticipantEntityForTest.getGoldSpent());
        assertThat(matchParticipantVO.getIndividualPosition()).isEqualTo(
                matchParticipantEntityForTest.getIndividualPosition());
        assertThat(matchParticipantVO.getInhibitorKills()).isEqualTo(
                matchParticipantEntityForTest.getInhibitorKills());
        assertThat(matchParticipantVO.getInhibitorTakedowns()).isEqualTo(
                matchParticipantEntityForTest.getInhibitorTakedowns());
        assertThat(matchParticipantVO.getInhibitorsLost()).isEqualTo(
                matchParticipantEntityForTest.getInhibitorsLost());
        assertThat(matchParticipantVO.getItem0()).isEqualTo(
                matchParticipantEntityForTest.getItem0());
        assertThat(matchParticipantVO.getItem1()).isEqualTo(
                matchParticipantEntityForTest.getItem1());
        assertThat(matchParticipantVO.getItem2()).isEqualTo(
                matchParticipantEntityForTest.getItem2());
        assertThat(matchParticipantVO.getItem3()).isEqualTo(
                matchParticipantEntityForTest.getItem3());
        assertThat(matchParticipantVO.getItem4()).isEqualTo(
                matchParticipantEntityForTest.getItem4());
        assertThat(matchParticipantVO.getItem5()).isEqualTo(
                matchParticipantEntityForTest.getItem5());
        assertThat(matchParticipantVO.getItem6()).isEqualTo(
                matchParticipantEntityForTest.getItem6());
        assertThat(matchParticipantVO.getItemsPurchased()).isEqualTo(
                matchParticipantEntityForTest.getItemsPurchased());
        assertThat(matchParticipantVO.getKillingSprees()).isEqualTo(
                matchParticipantEntityForTest.getKillingSprees());
        assertThat(matchParticipantVO.getKills()).isEqualTo(
                matchParticipantEntityForTest.getKills());
        assertThat(matchParticipantVO.getLane()).isEqualTo(
                matchParticipantEntityForTest.getLane());
        assertThat(matchParticipantVO.getLargestCriticalStrike()).isEqualTo(
                matchParticipantEntityForTest.getLargestCriticalStrike());
        assertThat(matchParticipantVO.getLargestKillingSpree()).isEqualTo(
                matchParticipantEntityForTest.getLargestKillingSpree());
        assertThat(matchParticipantVO.getLongestTimeSpentLiving()).isEqualTo(
                matchParticipantEntityForTest.getLongestTimeSpentLiving());
        assertThat(matchParticipantVO.getMagicDamageDealt()).isEqualTo(
                matchParticipantEntityForTest.getMagicDamageDealt());
        assertThat(matchParticipantVO.getMagicDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityForTest.getMagicDamageDealtToChampions());
        assertThat(matchParticipantVO.getMagicDamageTaken()).isEqualTo(
                matchParticipantEntityForTest.getMagicDamageTaken());
        assertThat(matchParticipantVO.getNeutralMinionsKilled()).isEqualTo(
                matchParticipantEntityForTest.getNeutralMinionsKilled());
        assertThat(matchParticipantVO.getNexusKills()).isEqualTo(
                matchParticipantEntityForTest.getNexusKills());
        assertThat(matchParticipantVO.getNexusLost()).isEqualTo(
                matchParticipantEntityForTest.getNexusLost());
        assertThat(matchParticipantVO.getNexusTakedowns()).isEqualTo(
                matchParticipantEntityForTest.getNexusTakedowns());
        assertThat(matchParticipantVO.getObjectivesStolen()).isEqualTo(
                matchParticipantEntityForTest.getObjectivesStolen());
        assertThat(matchParticipantVO.getObjectivesStolenAssists()).isEqualTo(
                matchParticipantEntityForTest.getObjectivesStolenAssists());
        assertThat(matchParticipantVO.getPentaKills()).isEqualTo(
                matchParticipantEntityForTest.getPentaKills());
        assertThat(matchParticipantVO.getPhysicalDamageDealt()).isEqualTo(
                matchParticipantEntityForTest.getPhysicalDamageDealt());
        assertThat(matchParticipantVO.getPhysicalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityForTest.getPhysicalDamageDealtToChampions());
        assertThat(matchParticipantVO.getPhysicalDamageTaken()).isEqualTo(
                matchParticipantEntityForTest.getPhysicalDamageTaken());
        assertThat(matchParticipantVO.getProfileIcon()).isEqualTo(
                matchParticipantEntityForTest.getProfileIcon());
        assertThat(matchParticipantVO.getQuadraKills()).isEqualTo(
                matchParticipantEntityForTest.getQuadraKills());
        assertThat(matchParticipantVO.getRiotIdName()).isEqualTo(
                matchParticipantEntityForTest.getRiotIdName());
        assertThat(matchParticipantVO.getRiotIdTagline()).isEqualTo(
                matchParticipantEntityForTest.getRiotIdTagline());
        assertThat(matchParticipantVO.getRole()).isEqualTo(
                matchParticipantEntityForTest.getRole());
        assertThat(matchParticipantVO.getSightWardsBoughtInGame()).isEqualTo(
                matchParticipantEntityForTest.getSightWardsBoughtInGame());
        assertThat(matchParticipantVO.getSpell1Casts()).isEqualTo(
                matchParticipantEntityForTest.getSpell1Casts());
        assertThat(matchParticipantVO.getSpell2Casts()).isEqualTo(
                matchParticipantEntityForTest.getSpell2Casts());
        assertThat(matchParticipantVO.getSpell3Casts()).isEqualTo(
                matchParticipantEntityForTest.getSpell3Casts());
        assertThat(matchParticipantVO.getSpell4Casts()).isEqualTo(
                matchParticipantEntityForTest.getSpell4Casts());
        assertThat(matchParticipantVO.getSummoner1Casts()).isEqualTo(
                matchParticipantEntityForTest.getSummoner1Casts());
        assertThat(matchParticipantVO.getSummoner1Id()).isEqualTo(
                matchParticipantEntityForTest.getSummoner1Id());
        assertThat(matchParticipantVO.getSummoner2Casts()).isEqualTo(
                matchParticipantEntityForTest.getSummoner2Casts());
        assertThat(matchParticipantVO.getSummoner2Id()).isEqualTo(
                matchParticipantEntityForTest.getSummoner2Id());
        assertThat(matchParticipantVO.getSummonerId()).isEqualTo(
                matchParticipantEntityForTest.getSummonerId());
        assertThat(matchParticipantVO.getSummonerLevel()).isEqualTo(
                matchParticipantEntityForTest.getSummonerLevel());
        assertThat(matchParticipantVO.getSummonerName()).isEqualTo(
                matchParticipantEntityForTest.getSummonerName());
        assertThat(matchParticipantVO.isTeamEarlySurrendered()).isEqualTo(
                matchParticipantEntityForTest.isTeamEarlySurrendered());
        assertThat(matchParticipantVO.getTeamId()).isEqualTo(
                matchParticipantEntityForTest.getTeamId());
        assertThat(matchParticipantVO.getTeamPosition()).isEqualTo(
                matchParticipantEntityForTest.getTeamPosition());
        assertThat(matchParticipantVO.getTimeCCingOthers()).isEqualTo(
                matchParticipantEntityForTest.getTimeCCingOthers());
        assertThat(matchParticipantVO.getTimePlayed()).isEqualTo(
                matchParticipantEntityForTest.getTimePlayed());
        assertThat(matchParticipantVO.getTotalDamageDealt()).isEqualTo(
                matchParticipantEntityForTest.getTotalDamageDealt());
        assertThat(matchParticipantVO.getTotalDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityForTest.getTotalDamageDealtToChampions());
        assertThat(matchParticipantVO.getTotalDamageTaken()).isEqualTo(
                matchParticipantEntityForTest.getTotalDamageTaken());
        assertThat(matchParticipantVO.getTotalHeal()).isEqualTo(
                matchParticipantEntityForTest.getTotalHeal());
        assertThat(matchParticipantVO.getTotalHealsOnTeammates()).isEqualTo(
                matchParticipantEntityForTest.getTotalHealsOnTeammates());
        assertThat(matchParticipantVO.getTotalMinionsKilled()).isEqualTo(
                matchParticipantEntityForTest.getTotalMinionsKilled());
        assertThat(matchParticipantVO.getTotalTimeCCDealt()).isEqualTo(
                matchParticipantEntityForTest.getTotalTimeCCDealt());
        assertThat(matchParticipantVO.getTotalTimeSpentDead()).isEqualTo(
                matchParticipantEntityForTest.getTotalTimeSpentDead());
        assertThat(matchParticipantVO.getTotalUnitsHealed()).isEqualTo(
                matchParticipantEntityForTest.getTotalUnitsHealed());
        assertThat(matchParticipantVO.getTripleKills()).isEqualTo(
                matchParticipantEntityForTest.getTripleKills());
        assertThat(matchParticipantVO.getTrueDamageDealt()).isEqualTo(
                matchParticipantEntityForTest.getTrueDamageDealt());
        assertThat(matchParticipantVO.getTrueDamageDealtToChampions()).isEqualTo(
                matchParticipantEntityForTest.getTrueDamageDealtToChampions());
        assertThat(matchParticipantVO.getTrueDamageTaken()).isEqualTo(
                matchParticipantEntityForTest.getTrueDamageTaken());
        assertThat(matchParticipantVO.getTurretKills()).isEqualTo(
                matchParticipantEntityForTest.getTurretKills());
        assertThat(matchParticipantVO.getTurretTakedowns()).isEqualTo(
                matchParticipantEntityForTest.getTurretTakedowns());
        assertThat(matchParticipantVO.getTurretsLost()).isEqualTo(
                matchParticipantEntityForTest.getTurretsLost());
        assertThat(matchParticipantVO.getUnrealKills()).isEqualTo(
                matchParticipantEntityForTest.getUnrealKills());
        assertThat(matchParticipantVO.getVisionScore()).isEqualTo(
                matchParticipantEntityForTest.getVisionScore());
        assertThat(matchParticipantVO.getVisionWardsBoughtInGame()).isEqualTo(
                matchParticipantEntityForTest.getVisionWardsBoughtInGame());
        assertThat(matchParticipantVO.getWardsKilled()).isEqualTo(
                matchParticipantEntityForTest.getWardsKilled());
        assertThat(matchParticipantVO.getWardsPlaced()).isEqualTo(
                matchParticipantEntityForTest.getWardsPlaced());
        assertThat(matchParticipantVO.isWin()).isEqualTo(
                matchParticipantEntityForTest.isWin());
        assertThat(matchParticipantVO.getRrt()).isEqualTo(
                matchParticipantEntityForTest.getRrt());
    }
}
