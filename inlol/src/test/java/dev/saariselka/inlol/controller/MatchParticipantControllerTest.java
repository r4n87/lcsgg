package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.MatchParticipantDto;
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
        long gameDuration = 12345L;

        List<MatchParticipantDto> listBeforeAdd = matchParticipantController.getMatchParticipantListByDataVersionAndMatchId(dataVersion, matchId, gameDuration);
        MatchParticipantDto matchParticipantDto =
                new MatchParticipantDto(
                        puuid, dataVersion, matchId, participantId, assists, baronKills,
                        bountyLevel, champExperience, champLevel, championId, championName, championNameKR, championImg,
                        championTransform, consumablesPurchased, damageDealtToBuildings,
                        damageDealtToObjectives, damageDealtToTurrets, damageSelfMitigated, deaths, detectorWardsPlaced, doubleKills, dragonKills,
                        firstBloodAssist, firstBloodKill, firstTowerAssist, firstTowerKill, gameEndedInEarlySurrender, gameEndedInSurrender, goldEarned,
                        goldSpent, individualPosition, inhibitorKills, inhibitorTakedowns, inhibitorsLost, item0, item1, item2, item3, item4, item5, item6,
                        itemsPurchased, killingSprees, kills, lane, largestCriticalStrike, largestKillingSpree, largestMultiKill, longestTimeSpentLiving,
                        magicDamageDealt, magicDamageDealtToChampions, magicDamageTaken, neutralMinionsKilled, nexusKills, nexusTakedowns, nexusLost,
                        objectivesStolen, objectivesStolenAssists, pentaKills, physicalDamageDealt, physicalDamageDealtToChampions,
                        physicalDamageTaken, profileIcon, quadraKills, riotIdName, riotIdTagline, role, sightWardsBoughtInGame, spell1Casts, spell2Casts,
                        spell3Casts, spell4Casts, summoner1Casts, summoner1Id, summoner2Casts, summoner2Id, summonerId, summonerLevel, summonerName,
                        teamEarlySurrendered, teamId, teamPosition, timeCCingOthers, timePlayed, totalDamageDealt, totalDamageDealtToChampions,
                        totalDamageShieldedOnTeammates, totalDamageTaken, totalHeal, totalHealsOnTeammates, totalMinionsKilled, totalTimeCCDealt,
                        totalTimeSpentDead, totalUnitsHealed, tripleKills, trueDamageDealt, trueDamageDealtToChampions, trueDamageTaken, turretKills,
                        turretTakedowns, turretsLost, unrealKills, visionScore, visionWardsBoughtInGame, wardsKilled, wardsPlaced, win, rrt
                );

        //when
        matchParticipantController.insertParticipantInfo(matchParticipantDto);

        //then
        List<MatchParticipantDto> listAfterAdd = matchParticipantController.getMatchParticipantListByDataVersionAndMatchId(dataVersion, matchId, gameDuration);
        assertThat(listAfterAdd.size()).isEqualTo(listBeforeAdd.size() + 1);
    }

    @Test
    @DisplayName("Find Entities By DataVersion, MatchId")
    public void getMatchParticipantListByDataVersionAndMatchId() {
        //given
        MatchParticipantDto matchParticipantDtoA = createMatchParticipantDtoA();
        MatchParticipantDto matchParticipantDtoB = createMatchParticipantDtoB();
        matchParticipantController.insertParticipantInfo(matchParticipantDtoA);
        matchParticipantController.insertParticipantInfo(matchParticipantDtoB);
        long gameDuration = 12345L;

        //when
        List<MatchParticipantDto> matchMatchParticipantDtoList
                = matchParticipantController.getMatchParticipantListByDataVersionAndMatchId(
                matchParticipantDtoA.getDataVersion(),
                matchParticipantDtoA.getMatchId(),
                gameDuration);

        //then
        assertThat(matchMatchParticipantDtoList.size()).isGreaterThanOrEqualTo(2);
        for(MatchParticipantDto matchParticipantDto : matchMatchParticipantDtoList) {
            String puuid = matchParticipantDto.getPuuid();
            String puuidA = matchParticipantDtoA.getPuuid();
            String puuidB = matchParticipantDtoB.getPuuid();

            if (puuid.equals(puuidA)) {
                assertFunction(matchParticipantDto, matchParticipantDtoA);
            } else if (puuid.equals(puuidB)) {
                assertFunction(matchParticipantDto, matchParticipantDtoB);
            }
        }
    }

    @Test
    @DisplayName("Find Entities By Puuid")
    public void getMatchParticipantListByPuuid() {
        //given
        MatchParticipantDto matchParticipantDtoA = createMatchParticipantDtoA();
        MatchParticipantDto matchParticipantDtoC = createMatchParticipantDtoC();
        matchParticipantController.insertParticipantInfo(matchParticipantDtoA);
        matchParticipantController.insertParticipantInfo(matchParticipantDtoC);

        //when
        List<MatchParticipantDto> matchMatchParticipantDtoList
                = matchParticipantController
                    .getMatchParticipantListByPuuid(matchParticipantDtoA.getPuuid());

        //then
        assertThat(matchMatchParticipantDtoList.size()).isGreaterThanOrEqualTo(2);
        for(MatchParticipantDto matchParticipantDto : matchMatchParticipantDtoList) {
            String puuid = matchParticipantDto.getPuuid();
            String puuidA = matchParticipantDtoA.getPuuid();
            String puuidC = matchParticipantDtoC.getPuuid();

            assertThat(puuid).isEqualTo(puuidA);
            assertThat(puuid).isEqualTo(puuidC);
        }
    }

    private MatchParticipantDto createMatchParticipantDtoA() {
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

        return new MatchParticipantDto(
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
    }

    private MatchParticipantDto createMatchParticipantDtoB() {
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

        return new MatchParticipantDto(
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
    }

    private MatchParticipantDto createMatchParticipantDtoC() {
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

        return new MatchParticipantDto(
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
    }

    private void assertFunction(MatchParticipantDto matchParticipantDto, MatchParticipantDto matchParticipantDtoForTest) {
            assertThat(matchParticipantDto.getPuuid()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getPuuid()));
            assertThat(matchParticipantDto.getDataVersion()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getDataVersion()));
            assertThat(matchParticipantDto.getMatchId()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getMatchId()));
            assertThat(matchParticipantDto.getParticipantId()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getParticipantId()));
            assertThat(matchParticipantDto.getAssists()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getAssists()));
            assertThat(matchParticipantDto.getBaronKills()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getBaronKills()));
            assertThat(matchParticipantDto.getBountyLevel()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getBountyLevel()));
            assertThat(matchParticipantDto.getChampExperience()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getChampExperience()));
            assertThat(matchParticipantDto.getChampLevel()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getChampLevel()));
            assertThat(matchParticipantDto.getChampionId()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getChampionId()));
            assertThat(matchParticipantDto.getChampionName()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getChampionName()));
            assertThat(matchParticipantDto.getChampionNameKR()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getChampionNameKR()));
            assertThat(matchParticipantDto.getChampionImg()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getChampionImg()));
            assertThat(matchParticipantDto.getChampionTransform()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getChampionTransform()));
            assertThat(matchParticipantDto.getConsumablesPurchased()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getConsumablesPurchased()));
            assertThat(matchParticipantDto.getDamageDealtToBuildings()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getDamageDealtToBuildings()));
            assertThat(matchParticipantDto.getDamageDealtToObjectives()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getDamageDealtToObjectives()));
            assertThat(matchParticipantDto.getDamageSelfMitigated()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getDamageSelfMitigated()));
            assertThat(matchParticipantDto.getDeaths()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getDeaths()));
            assertThat(matchParticipantDto.getDetectorWardsPlaced()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getDetectorWardsPlaced()));
            assertThat(matchParticipantDto.getDoubleKills()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getDoubleKills()));
            assertThat(matchParticipantDto.getDragonKills()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getDragonKills()));
            assertThat(matchParticipantDto.getFirstBloodAssist()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getFirstBloodAssist()));
            assertThat(matchParticipantDto.getFirstBloodKill()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getFirstBloodKill()));
            assertThat(matchParticipantDto.getFirstTowerAssist()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getFirstTowerAssist()));
            assertThat(matchParticipantDto.getFirstTowerKill()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getFirstTowerKill()));
            assertThat(matchParticipantDto.getGameEndedInEarlySurrender()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getGameEndedInEarlySurrender()));
            assertThat(matchParticipantDto.getGameEndedInSurrender()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getGameEndedInSurrender()));
            assertThat(matchParticipantDto.getGoldEarned()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getGoldEarned()));
            assertThat(matchParticipantDto.getGoldSpent()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getGoldSpent()));
            assertThat(matchParticipantDto.getIndividualPosition()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getIndividualPosition()));
            assertThat(matchParticipantDto.getInhibitorKills()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getInhibitorKills()));
            assertThat(matchParticipantDto.getInhibitorTakedowns()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getInhibitorTakedowns()));
            assertThat(matchParticipantDto.getInhibitorsLost()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getInhibitorsLost()));
            assertThat(matchParticipantDto.getItem0()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getItem0()));
            assertThat(matchParticipantDto.getItem1()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getItem1()));
            assertThat(matchParticipantDto.getItem2()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getItem2()));
            assertThat(matchParticipantDto.getItem3()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getItem3()));
            assertThat(matchParticipantDto.getItem4()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getItem4()));
            assertThat(matchParticipantDto.getItem5()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getItem5()));
            assertThat(matchParticipantDto.getItem6()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getItem6()));
            assertThat(matchParticipantDto.getItemsPurchased()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getItemsPurchased()));
            assertThat(matchParticipantDto.getKillingSprees()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getKillingSprees()));
            assertThat(matchParticipantDto.getKills()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getKills()));
            assertThat(matchParticipantDto.getLane()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getLane()));
            assertThat(matchParticipantDto.getLargestCriticalStrike()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getLargestCriticalStrike()));
            assertThat(matchParticipantDto.getLargestKillingSpree()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getLargestKillingSpree()));
            assertThat(matchParticipantDto.getLongestTimeSpentLiving()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getLongestTimeSpentLiving()));
            assertThat(matchParticipantDto.getMagicDamageDealt()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getMagicDamageDealt()));
            assertThat(matchParticipantDto.getMagicDamageDealtToChampions()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getMagicDamageDealtToChampions()));
            assertThat(matchParticipantDto.getMagicDamageTaken()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getMagicDamageTaken()));
            assertThat(matchParticipantDto.getNeutralMinionsKilled()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getNeutralMinionsKilled()));
            assertThat(matchParticipantDto.getNexusKills()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getNexusKills()));
            assertThat(matchParticipantDto.getNexusLost()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getNexusLost()));
            assertThat(matchParticipantDto.getNexusTakedowns()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getNexusTakedowns()));
            assertThat(matchParticipantDto.getObjectivesStolen()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getObjectivesStolen()));
            assertThat(matchParticipantDto.getObjectivesStolenAssists()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getObjectivesStolenAssists()));
            assertThat(matchParticipantDto.getPentaKills()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getPentaKills()));
            assertThat(matchParticipantDto.getPhysicalDamageDealt()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getPhysicalDamageDealt()));
            assertThat(matchParticipantDto.getPhysicalDamageDealtToChampions()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getPhysicalDamageDealtToChampions()));
            assertThat(matchParticipantDto.getPhysicalDamageTaken()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getPhysicalDamageTaken()));
            assertThat(matchParticipantDto.getProfileIcon()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getProfileIcon()));
            assertThat(matchParticipantDto.getQuadraKills()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getQuadraKills()));
            assertThat(matchParticipantDto.getRiotIdName()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getRiotIdName()));
            assertThat(matchParticipantDto.getRiotIdTagline()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getRiotIdTagline()));
            assertThat(matchParticipantDto.getRole()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getRole()));
            assertThat(matchParticipantDto.getSightWardsBoughtInGame()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSightWardsBoughtInGame()));
            assertThat(matchParticipantDto.getSpell1Casts()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSpell1Casts()));
            assertThat(matchParticipantDto.getSpell2Casts()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSpell2Casts()));
            assertThat(matchParticipantDto.getSpell3Casts()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSpell3Casts()));
            assertThat(matchParticipantDto.getSpell4Casts()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSpell4Casts()));
            assertThat(matchParticipantDto.getSummoner1Casts()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSummoner1Casts()));
            assertThat(matchParticipantDto.getSummoner1Id()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSummoner1Id()));
            assertThat(matchParticipantDto.getSummoner2Casts()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSummoner2Casts()));
            assertThat(matchParticipantDto.getSummoner2Id()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSummoner2Id()));
            assertThat(matchParticipantDto.getSummonerId()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSummonerId()));
            assertThat(matchParticipantDto.getSummonerLevel()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSummonerLevel()));
            assertThat(matchParticipantDto.getSummonerName()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getSummonerName()));
            assertThat(matchParticipantDto.getTeamEarlySurrendered()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTeamEarlySurrendered()));
            assertThat(matchParticipantDto.getTeamId()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTeamId()));
            assertThat(matchParticipantDto.getTeamPosition()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTeamPosition()));
            assertThat(matchParticipantDto.getTimeCCingOthers()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTimeCCingOthers()));
            assertThat(matchParticipantDto.getTimePlayed()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTimePlayed()));
            assertThat(matchParticipantDto.getTotalDamageDealt()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTotalDamageDealt()));
            assertThat(matchParticipantDto.getTotalDamageDealtToChampions()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTotalDamageDealtToChampions()));
            assertThat(matchParticipantDto.getTotalDamageTaken()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTotalDamageTaken()));
            assertThat(matchParticipantDto.getTotalHeal()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTotalHeal()));
            assertThat(matchParticipantDto.getTotalHealsOnTeammates()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTotalHealsOnTeammates()));
            assertThat(matchParticipantDto.getTotalMinionsKilled()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTotalMinionsKilled()));
            assertThat(matchParticipantDto.getTotalTimeCCDealt()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTotalTimeCCDealt()));
            assertThat(matchParticipantDto.getTotalTimeSpentDead()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTotalTimeSpentDead()));
            assertThat(matchParticipantDto.getTotalUnitsHealed()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTotalUnitsHealed()));
            assertThat(matchParticipantDto.getTripleKills()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTripleKills()));
            assertThat(matchParticipantDto.getTrueDamageDealt()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTrueDamageDealt()));
            assertThat(matchParticipantDto.getTrueDamageDealtToChampions()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTrueDamageDealtToChampions()));
            assertThat(matchParticipantDto.getTrueDamageTaken()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTrueDamageTaken()));
            assertThat(matchParticipantDto.getTurretKills()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTurretKills()));
            assertThat(matchParticipantDto.getTurretTakedowns()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTurretTakedowns()));
            assertThat(matchParticipantDto.getTurretsLost()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getTurretsLost()));
            assertThat(matchParticipantDto.getUnrealKills()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getUnrealKills()));
            assertThat(matchParticipantDto.getVisionScore()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getVisionScore()));
            assertThat(matchParticipantDto.getVisionWardsBoughtInGame()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getVisionWardsBoughtInGame()));
            assertThat(matchParticipantDto.getWardsKilled()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getWardsKilled()));
            assertThat(matchParticipantDto.getWardsPlaced()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getWardsPlaced()));
            assertThat(matchParticipantDto.getWin()).isEqualTo(
                    String.valueOf(matchParticipantDtoForTest.getWin()));
            assertThat(matchParticipantDto.getRrt()).isEqualTo(
                    matchParticipantDtoForTest.getRrt());
        }
}
