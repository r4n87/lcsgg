package dev.saariselka.inlol.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamVOTest {
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
        TeamVO vo = new TeamVO(bans, objectives, teamId, win, teamKills, participants);

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

    }

    @Test
    @DisplayName("Setter")
    void setter() {
        // given
        TeamVO vo = new TeamVO();
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

        return new MatchParticipantVO(
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

}