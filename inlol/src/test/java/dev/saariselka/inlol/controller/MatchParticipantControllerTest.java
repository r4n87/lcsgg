package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.ParticipantDto;
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
public class MatchParticipantControllerTest {
    @Autowired
    private MatchParticipantController matchParticipantController;
    @Autowired
    private MatchParticipantRepository matchParticipantRepository;
    @Autowired
    private DtoMapper dtoMapper;

    @Test
    @DisplayName("Insert Entity")
    public void insertParticipantInfo() {
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

        List<ParticipantDto> listBeforeAdd = matchParticipantController.getMatchParticipantListByDataVersionAndMatchId(dataVersion, matchId);

        //when
        matchParticipantController.insertParticipantInfo(puuid, dataVersion, matchId, assists, baronKills,
                bountyLevel, champExperience, champLevel, championId, championName, championNameKR, championImg,
                championTransform, consumablesPurchased, damageDealtToBuildings,
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
        List<ParticipantDto> listAfterAdd = matchParticipantController.getMatchParticipantListByDataVersionAndMatchId(dataVersion, matchId);
        assertThat(listAfterAdd.size()).isEqualTo(listBeforeAdd.size() + 1);
    }

    @Test
    @DisplayName("Find Entities By DataVersion, MatchId")
    public void getMatchParticipantListByDataVersionAndMatchId() {
        //given
        MatchParticipantEntity matchParticipantEntityA = createMatchParticipantEntityA();
        MatchParticipantEntity matchParticipantEntityB = createMatchParticipantEntityB();
        MatchParticipantEntity matchParticipantEntityAForTest
                = matchParticipantRepository.save(matchParticipantEntityA);
        MatchParticipantEntity matchParticipantEntityBForTest
                = matchParticipantRepository.save(matchParticipantEntityB);

        //when
        List<ParticipantDto> matchParticipantDtoList
                = matchParticipantController.getMatchParticipantListByDataVersionAndMatchId(
                matchParticipantEntityAForTest.getMatchParticipantId().getDataVersion(),
                matchParticipantEntityAForTest.getMatchParticipantId().getMatchId());

        //then
        assertThat(matchParticipantDtoList.size()).isGreaterThanOrEqualTo(2);
        for(ParticipantDto matchParticipantDto : matchParticipantDtoList) {
            String puuid = matchParticipantDto.getPuuid();
            String puuidA = matchParticipantEntityAForTest.getMatchParticipantId().getPuuid();
            String puuidB = matchParticipantEntityBForTest.getMatchParticipantId().getPuuid();

            if (puuid.equals(puuidA)) {
                assertFunction(matchParticipantDto, matchParticipantEntityAForTest);
            } else if (puuid.equals(puuidB)) {
                assertFunction(matchParticipantDto, matchParticipantEntityBForTest);
            }
        }
    }

    @Test
    @DisplayName("Find Entities By Puuid")
    public void getMatchParticipantListByPuuid() {
        //given
        MatchParticipantEntity matchParticipantEntityA = createMatchParticipantEntityA();
        MatchParticipantEntity matchParticipantEntityC = createMatchParticipantEntityC();
        MatchParticipantEntity matchParticipantEntityAForTest
                = matchParticipantRepository.save(matchParticipantEntityA);
        MatchParticipantEntity matchParticipantEntityCForTest
                = matchParticipantRepository.save(matchParticipantEntityC);

        //when
        List<ParticipantDto> matchParticipantDtoList
                = matchParticipantController.getMatchParticipantListByPuuid(
                matchParticipantEntityAForTest.getMatchParticipantId().getPuuid());

        //then
        assertThat(matchParticipantDtoList.size()).isGreaterThanOrEqualTo(2);
        for(ParticipantDto matchParticipantDto : matchParticipantDtoList) {
            String puuid = matchParticipantDto.getPuuid();
            String puuidA = matchParticipantEntityAForTest.getMatchParticipantId().getPuuid();
            String puuidC = matchParticipantEntityCForTest.getMatchParticipantId().getPuuid();

            assertThat(puuid).isEqualTo(puuidA);
            assertThat(puuid).isEqualTo(puuidC);
        }
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

    private MatchParticipantEntity createMatchParticipantEntityC() {
        String puuid = "A1B2C3D4";
        String dataVersion = "2";
        String matchId = "BBBBBB";
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

    private void assertFunction(ParticipantDto matchParticipantDto, MatchParticipantEntity matchParticipantEntityForTest) {
            assertThat(matchParticipantDto.getPuuid()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getMatchParticipantId().getPuuid()));
            assertThat(matchParticipantDto.getDataVersion()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getMatchParticipantId().getDataVersion()));
            assertThat(matchParticipantDto.getMatchId()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getMatchParticipantId().getMatchId()));
            assertThat(matchParticipantDto.getParticipantId()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getMatchParticipantId().getParticipantId()));
            assertThat(matchParticipantDto.getAssists()).isEqualTo(
                    String.valueOf(String.valueOf(matchParticipantEntityForTest.getAssists())));
            assertThat(matchParticipantDto.getBaronKills()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getBaronKills()));
            assertThat(matchParticipantDto.getBountyLevel()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getBountyLevel()));
            assertThat(matchParticipantDto.getChampExperience()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getChampExperience()));
            assertThat(matchParticipantDto.getChampLevel()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getChampLevel()));
            assertThat(matchParticipantDto.getChampionId()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getChampionId()));
            assertThat(matchParticipantDto.getChampionNameENG()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getChampionName()));
            assertThat(matchParticipantDto.getChampionNameKR()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getChampionNameKR()));
            assertThat(matchParticipantDto.getChampionImg()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getChampionImg()));
            assertThat(matchParticipantDto.getChampionTransform()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getChampionTransform()));
            assertThat(matchParticipantDto.getConsumablesPurchased()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getConsumablesPurchased()));
            assertThat(matchParticipantDto.getDamageDealtToBuildings()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getDamageDealtToBuildings()));
            assertThat(matchParticipantDto.getDamageDealtToObjectives()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getDamageDealtToObjectives()));
            assertThat(matchParticipantDto.getDamageSelfMitigated()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getDamageSelfMitigated()));
            assertThat(matchParticipantDto.getDeaths()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getDeaths()));
            assertThat(matchParticipantDto.getDetectorWardsPlaced()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getDetectorWardsPlaced()));
            assertThat(matchParticipantDto.getDoubleKills()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getDoubleKills()));
            assertThat(matchParticipantDto.getDragonKills()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getDragonKills()));
            assertThat(matchParticipantDto.getFirstBloodAssist()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.isFirstBloodAssist()));
            assertThat(matchParticipantDto.getFirstBloodKill()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.isFirstBloodKill()));
            assertThat(matchParticipantDto.getFirstTowerAssist()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.isFirstTowerAssist()));
            assertThat(matchParticipantDto.getFirstTowerKill()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.isFirstTowerKill()));
            assertThat(matchParticipantDto.getGameEndedInEarlySurrender()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.isGameEndedInEarlySurrender()));
            assertThat(matchParticipantDto.getGameEndedInSurrender()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.isGameEndedInSurrender()));
            assertThat(matchParticipantDto.getGoldEarned()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getGoldEarned()));
            assertThat(matchParticipantDto.getGoldSpent()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getGoldSpent()));
            assertThat(matchParticipantDto.getIndividualPosition()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getIndividualPosition()));
            assertThat(matchParticipantDto.getInhibitorKills()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getInhibitorKills()));
            assertThat(matchParticipantDto.getInhibitorTakedowns()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getInhibitorTakedowns()));
            assertThat(matchParticipantDto.getInhibitorsLost()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getInhibitorsLost()));
            assertThat(matchParticipantDto.getItem0()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getItem0()));
            assertThat(matchParticipantDto.getItem1()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getItem1()));
            assertThat(matchParticipantDto.getItem2()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getItem2()));
            assertThat(matchParticipantDto.getItem3()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getItem3()));
            assertThat(matchParticipantDto.getItem4()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getItem4()));
            assertThat(matchParticipantDto.getItem5()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getItem5()));
            assertThat(matchParticipantDto.getItem6()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getItem6()));
            assertThat(matchParticipantDto.getItemsPurchased()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getItemsPurchased()));
            assertThat(matchParticipantDto.getKillingSprees()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getKillingSprees()));
            assertThat(matchParticipantDto.getKills()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getKills()));
            assertThat(matchParticipantDto.getLane()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getLane()));
            assertThat(matchParticipantDto.getLargestCriticalStrike()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getLargestCriticalStrike()));
            assertThat(matchParticipantDto.getLargestKillingSpree()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getLargestKillingSpree()));
            assertThat(matchParticipantDto.getLongestTimeSpentLiving()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getLongestTimeSpentLiving()));
            assertThat(matchParticipantDto.getMagicDamageDealt()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getMagicDamageDealt()));
            assertThat(matchParticipantDto.getMagicDamageDealtToChampions()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getMagicDamageDealtToChampions()));
            assertThat(matchParticipantDto.getMagicDamageTaken()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getMagicDamageTaken()));
            assertThat(matchParticipantDto.getNeutralMinionsKilled()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getNeutralMinionsKilled()));
            assertThat(matchParticipantDto.getNexusKills()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getNexusKills()));
            assertThat(matchParticipantDto.getNexusLost()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getNexusLost()));
            assertThat(matchParticipantDto.getNexusTakedowns()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getNexusTakedowns()));
            assertThat(matchParticipantDto.getObjectivesStolen()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getObjectivesStolen()));
            assertThat(matchParticipantDto.getObjectivesStolenAssists()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getObjectivesStolenAssists()));
            assertThat(matchParticipantDto.getPentaKills()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getPentaKills()));
            assertThat(matchParticipantDto.getPhysicalDamageDealt()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getPhysicalDamageDealt()));
            assertThat(matchParticipantDto.getPhysicalDamageDealtToChampions()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getPhysicalDamageDealtToChampions()));
            assertThat(matchParticipantDto.getPhysicalDamageTaken()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getPhysicalDamageTaken()));
            assertThat(matchParticipantDto.getProfileIcon()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getProfileIcon()));
            assertThat(matchParticipantDto.getQuadraKills()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getQuadraKills()));
            assertThat(matchParticipantDto.getRiotIdName()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getRiotIdName()));
            assertThat(matchParticipantDto.getRiotIdTagline()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getRiotIdTagline()));
            assertThat(matchParticipantDto.getRole()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getRole()));
            assertThat(matchParticipantDto.getSightWardsBoughtInGame()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSightWardsBoughtInGame()));
            assertThat(matchParticipantDto.getSpell1Casts()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSpell1Casts()));
            assertThat(matchParticipantDto.getSpell2Casts()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSpell2Casts()));
            assertThat(matchParticipantDto.getSpell3Casts()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSpell3Casts()));
            assertThat(matchParticipantDto.getSpell4Casts()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSpell4Casts()));
            assertThat(matchParticipantDto.getSummoner1Casts()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSummoner1Casts()));
            assertThat(matchParticipantDto.getSummoner1Id()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSummoner1Id()));
            assertThat(matchParticipantDto.getSummoner2Casts()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSummoner2Casts()));
            assertThat(matchParticipantDto.getSummoner2Id()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSummoner2Id()));
            assertThat(matchParticipantDto.getSummonerId()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSummonerId()));
            assertThat(matchParticipantDto.getSummonerLevel()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSummonerLevel()));
            assertThat(matchParticipantDto.getSummonerName()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getSummonerName()));
            assertThat(matchParticipantDto.getTeamEarlySurrendered()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.isTeamEarlySurrendered()));
            assertThat(matchParticipantDto.getTeamId()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTeamId()));
            assertThat(matchParticipantDto.getTeamPosition()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTeamPosition()));
            assertThat(matchParticipantDto.getTimeCCingOthers()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTimeCCingOthers()));
            assertThat(matchParticipantDto.getTimePlayed()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTimePlayed()));
            assertThat(matchParticipantDto.getTotalDamageDealt()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTotalDamageDealt()));
            assertThat(matchParticipantDto.getTotalDamageDealtToChampions()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTotalDamageDealtToChampions()));
            assertThat(matchParticipantDto.getTotalDamageTaken()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTotalDamageTaken()));
            assertThat(matchParticipantDto.getTotalHeal()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTotalHeal()));
            assertThat(matchParticipantDto.getTotalHealsOnTeammates()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTotalHealsOnTeammates()));
            assertThat(matchParticipantDto.getTotalMinionsKilled()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTotalMinionsKilled()));
            assertThat(matchParticipantDto.getTotalTimeCCDealt()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTotalTimeCCDealt()));
            assertThat(matchParticipantDto.getTotalTimeSpentDead()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTotalTimeSpentDead()));
            assertThat(matchParticipantDto.getTotalUnitsHealed()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTotalUnitsHealed()));
            assertThat(matchParticipantDto.getTripleKills()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTripleKills()));
            assertThat(matchParticipantDto.getTrueDamageDealt()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTrueDamageDealt()));
            assertThat(matchParticipantDto.getTrueDamageDealtToChampions()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTrueDamageDealtToChampions()));
            assertThat(matchParticipantDto.getTrueDamageTaken()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTrueDamageTaken()));
            assertThat(matchParticipantDto.getTurretKills()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTurretKills()));
            assertThat(matchParticipantDto.getTurretTakedowns()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTurretTakedowns()));
            assertThat(matchParticipantDto.getTurretsLost()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getTurretsLost()));
            assertThat(matchParticipantDto.getUnrealKills()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getUnrealKills()));
            assertThat(matchParticipantDto.getVisionScore()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getVisionScore()));
            assertThat(matchParticipantDto.getVisionWardsBoughtInGame()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getVisionWardsBoughtInGame()));
            assertThat(matchParticipantDto.getWardsKilled()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getWardsKilled()));
            assertThat(matchParticipantDto.getWardsPlaced()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.getWardsPlaced()));
            assertThat(matchParticipantDto.getWin()).isEqualTo(
                    String.valueOf(matchParticipantEntityForTest.isWin()));
            assertThat(matchParticipantDto.getRrt()).isEqualTo(
                    matchParticipantEntityForTest.getRrt());
        }
}
