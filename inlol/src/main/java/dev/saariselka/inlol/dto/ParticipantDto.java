package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.utils.JsonParserForLOL;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ParticipantDto {
    private String puuid;
    private String dataVersion;
    private String matchId;

    private String assists;
    private String baronKills;
    private String bountyLevel;
    private String champExperience;
    private String champLevel;
    private String championId;
    private String championNameENG;
    private String championNameKR;
    private String championTransform;
    private String consumablesPurchased;
    private String damageDealtToBuildings;
    private String damageDealtToObjectives;
    private String damageDealtToTurrets;
    private String damageSelfMitigated;
    private String deaths;
    private String detectorWardsPlaced;
    private String doubleKills;
    private String dragonKills;
    private String firstBloodAssist;
    private String firstBloodKill;
    private String firstTowerAssist;
    private String firstTowerKill;
    private String gameEndedInEarlySurrender;
    private String gameEndedInSurrender;
    private String goldEarned;
    private String goldSpent;
    private String individualPosition;
    private String inhibitorKills;
    private String inhibitorTakedowns;
    private String inhibitorsLost;
    private String item0;
    private String item1;
    private String item2;
    private String item3;
    private String item4;
    private String item5;
    private String item6;
    private String itemsPurchased;
    private String killingSprees;
    private String kills;
    private String lane;
    private String largestCriticalStrike;
    private String largestKillingSpree;
    private String largestMultiKill;
    private String longestTimeSpentLiving;
    private String magicDamageDealt;
    private String magicDamageDealtToChampions;
    private String magicDamageTaken;
    private String neutralMinionsKilled;
    private String nexusKills;
    private String nexusTakedowns;
    private String nexusLost;
    private String objectivesStolen;
    private String objectivesStolenAssists;
    private String participantId;
    private String pentaKills;
    private String physicalDamageDealt;
    private String physicalDamageDealtToChampions;
    private String physicalDamageTaken;
    private String profileIcon;
    private String quadraKills;
    private String riotIdName;
    private String riotIdTagline;
    private String role;
    private String sightWardsBoughtInGame;
    private String spell1Casts;
    private String spell2Casts;
    private String spell3Casts;
    private String spell4Casts;
    private String summoner1Casts;
    private String summoner1Id;
    private String summoner2Casts;
    private String summoner2Id;
    private String summonerId;
    private String summonerLevel;
    private String summonerName;
    private String teamEarlySurrendered;
    private String teamId;
    private String teamPosition;
    private String timeCCingOthers;
    private String timePlayed;
    private String totalDamageDealt;
    private String totalDamageDealtToChampions;
    private String totalDamageShieldedOnTeammates;
    private String totalDamageTaken;
    private String totalHeal;
    private String totalHealsOnTeammates;
    private String totalMinionsKilled;
    private String totalTimeCCDealt;
    private String totalTimeSpentDead;
    private String totalUnitsHealed;
    private String tripleKills;
    private String trueDamageDealt;
    private String trueDamageDealtToChampions;
    private String trueDamageTaken;
    private String turretKills;
    private String turretTakedowns;
    private String turretsLost;
    private String unrealKills;
    private String visionScore;
    private String visionWardsBoughtInGame;
    private String wardsKilled;
    private String wardsPlaced;
    private String win;
    private Timestamp rrt;

    private PerksDto perks;
    private String kda;
    private String minionsKilledPerMin;
    private String killRatio;
    private String multiKills;

    public ParticipantDto(MatchParticipantEntity matchParticipantEntity
                        , PerksDto perksDto
                        , long gameDuration) {

        this.puuid = matchParticipantEntity.getMatchParticipantId().getPuuid();
        this.dataVersion = matchParticipantEntity.getMatchParticipantId().getDataVersion();
        this.matchId = matchParticipantEntity.getMatchParticipantId().getMatchId();
        this.participantId = String.valueOf(matchParticipantEntity.getMatchParticipantId().getParticipantId());
        this.assists = String.valueOf(matchParticipantEntity.getAssists());
        this.baronKills = String.valueOf(matchParticipantEntity.getBaronKills());
        this.bountyLevel = String.valueOf(matchParticipantEntity.getBountyLevel());
        this.champExperience = String.valueOf(matchParticipantEntity.getChampExperience());
        this.champLevel = String.valueOf(matchParticipantEntity.getChampLevel());
        this.championId = String.valueOf(matchParticipantEntity.getChampionId());
        this.championNameENG = matchParticipantEntity.getChampionName();
        this.championTransform = String.valueOf(matchParticipantEntity.getChampionTransform());
        this.consumablesPurchased = String.valueOf(matchParticipantEntity.getConsumablesPurchased());
        this.damageDealtToBuildings = String.valueOf(matchParticipantEntity.getDamageDealtToBuildings());
        this.damageDealtToObjectives = String.valueOf(matchParticipantEntity.getDamageDealtToObjectives());
        this.damageDealtToTurrets = String.valueOf(matchParticipantEntity.getDamageDealtToTurrets());
        this.damageSelfMitigated = String.valueOf(matchParticipantEntity.getDamageSelfMitigated());
        this.deaths = String.valueOf(matchParticipantEntity.getDeaths());
        this.detectorWardsPlaced = String.valueOf(matchParticipantEntity.getDetectorWardsPlaced());
        this.doubleKills = String.valueOf(matchParticipantEntity.getDoubleKills());
        this.dragonKills = String.valueOf(matchParticipantEntity.getDragonKills());
        this.firstBloodAssist = String.valueOf(matchParticipantEntity.isFirstBloodAssist());
        this.firstBloodKill = String.valueOf(matchParticipantEntity.isFirstBloodKill());
        this.firstTowerAssist = String.valueOf(matchParticipantEntity.isFirstTowerAssist());
        this.firstTowerKill = String.valueOf(matchParticipantEntity.isFirstTowerKill());
        this.gameEndedInEarlySurrender = String.valueOf(matchParticipantEntity.isGameEndedInEarlySurrender());
        this.gameEndedInSurrender = String.valueOf(matchParticipantEntity.isGameEndedInSurrender());
        this.goldEarned = String.valueOf(matchParticipantEntity.getGoldEarned());
        this.goldSpent = String.valueOf(matchParticipantEntity.getGoldSpent());
        this.individualPosition = matchParticipantEntity.getIndividualPosition();
        this.inhibitorKills = String.valueOf(matchParticipantEntity.getInhibitorKills());
        this.inhibitorTakedowns = String.valueOf(matchParticipantEntity.getInhibitorTakedowns());
        this.inhibitorsLost = String.valueOf(matchParticipantEntity.getInhibitorsLost());
        this.item0 = String.valueOf(matchParticipantEntity.getItem0());
        this.item1 = String.valueOf(matchParticipantEntity.getItem1());
        this.item2 = String.valueOf(matchParticipantEntity.getItem2());
        this.item3 = String.valueOf(matchParticipantEntity.getItem3());
        this.item4 = String.valueOf(matchParticipantEntity.getItem4());
        this.item5 = String.valueOf(matchParticipantEntity.getItem5());
        this.item6 = String.valueOf(matchParticipantEntity.getItem6());
        this.itemsPurchased = String.valueOf(matchParticipantEntity.getItemsPurchased());
        this.killingSprees = String.valueOf(matchParticipantEntity.getKillingSprees());
        this.kills = String.valueOf(matchParticipantEntity.getKills());
        this.lane = matchParticipantEntity.getLane();
        this.largestCriticalStrike = String.valueOf(matchParticipantEntity.getLargestCriticalStrike());
        this.largestKillingSpree = String.valueOf(matchParticipantEntity.getLargestKillingSpree());
        this.largestMultiKill = String.valueOf(matchParticipantEntity.getLargestMultiKill());
        this.longestTimeSpentLiving = String.valueOf(matchParticipantEntity.getLongestTimeSpentLiving());
        this.magicDamageDealt = String.valueOf(matchParticipantEntity.getMagicDamageDealt());
        this.magicDamageDealtToChampions = String.valueOf(matchParticipantEntity.getMagicDamageDealtToChampions());
        this.magicDamageTaken = String.valueOf(matchParticipantEntity.getMagicDamageTaken());
        this.neutralMinionsKilled = String.valueOf(matchParticipantEntity.getNeutralMinionsKilled());
        this.nexusKills = String.valueOf(matchParticipantEntity.getNexusKills());
        this.nexusLost = String.valueOf(matchParticipantEntity.getNexusLost());
        this.nexusTakedowns = String.valueOf(matchParticipantEntity.getNexusTakedowns());
        this.objectivesStolen = String.valueOf(matchParticipantEntity.getObjectivesStolen());
        this.objectivesStolenAssists = String.valueOf(matchParticipantEntity.getObjectivesStolenAssists());
        this.pentaKills = String.valueOf(matchParticipantEntity.getPentaKills());
        this.physicalDamageDealt = String.valueOf(matchParticipantEntity.getPhysicalDamageDealt());
        this.physicalDamageDealtToChampions = String.valueOf(matchParticipantEntity.getPhysicalDamageDealtToChampions());
        this.physicalDamageTaken = String.valueOf(matchParticipantEntity.getPhysicalDamageTaken());
        this.profileIcon = String.valueOf(matchParticipantEntity.getProfileIcon());
        this.quadraKills = String.valueOf(matchParticipantEntity.getQuadraKills());
        this.riotIdName = matchParticipantEntity.getRiotIdName();
        this.riotIdTagline = matchParticipantEntity.getRiotIdTagline();
        this.role = matchParticipantEntity.getRole();
        this.sightWardsBoughtInGame = String.valueOf(matchParticipantEntity.getSightWardsBoughtInGame());
        this.spell1Casts = String.valueOf(matchParticipantEntity.getSpell1Casts());
        this.spell2Casts = String.valueOf(matchParticipantEntity.getSpell2Casts());
        this.spell3Casts = String.valueOf(matchParticipantEntity.getSpell3Casts());
        this.spell4Casts = String.valueOf(matchParticipantEntity.getSpell4Casts());
        this.summoner1Casts = String.valueOf(matchParticipantEntity.getSummoner1Casts());
        this.summoner1Id = JsonParserForLOL.getSpellImageBySpellId(matchParticipantEntity.getSummoner1Id());
        this.summoner2Casts = String.valueOf(matchParticipantEntity.getSummoner2Casts());
        this.summoner2Id = JsonParserForLOL.getSpellImageBySpellId(matchParticipantEntity.getSummoner2Id());
        this.summonerId = matchParticipantEntity.getSummonerId();
        this.summonerLevel = String.valueOf(matchParticipantEntity.getSummonerLevel());
        if(matchParticipantEntity.getMatchParticipantId().getPuuid().equals("BOT"))
        {
            this.summonerName = "(봇)";
        }
        else
        {
            this.summonerName = matchParticipantEntity.getSummonerName();
        }
        this.teamEarlySurrendered = String.valueOf(matchParticipantEntity.isTeamEarlySurrendered());
        this.teamId = String.valueOf(matchParticipantEntity.getTeamId());
        this.teamPosition = matchParticipantEntity.getTeamPosition();
        this.timeCCingOthers = String.valueOf(matchParticipantEntity.getTimeCCingOthers());
        this.timePlayed = String.valueOf(matchParticipantEntity.getTimePlayed());
        this.totalDamageDealt = String.valueOf(matchParticipantEntity.getTotalDamageDealt());
        this.totalDamageDealtToChampions = String.valueOf(matchParticipantEntity.getTotalDamageDealtToChampions());
        this.totalDamageShieldedOnTeammates = String.valueOf(matchParticipantEntity.getTotalDamageShieldedOnTeammates());
        this.totalDamageTaken = String.valueOf(matchParticipantEntity.getTotalDamageTaken());
        this.totalHeal = String.valueOf(matchParticipantEntity.getTotalHeal());
        this.totalHealsOnTeammates = String.valueOf(matchParticipantEntity.getTotalHealsOnTeammates());
        this.totalMinionsKilled = String.valueOf(matchParticipantEntity.getTotalMinionsKilled());
        this.totalTimeCCDealt = String.valueOf(matchParticipantEntity.getTotalTimeCCDealt());
        this.totalTimeSpentDead = String.valueOf(matchParticipantEntity.getTotalTimeSpentDead());
        this.totalUnitsHealed = String.valueOf(matchParticipantEntity.getTotalUnitsHealed());
        this.tripleKills = String.valueOf(matchParticipantEntity.getTripleKills());
        this.trueDamageDealt = String.valueOf(matchParticipantEntity.getTrueDamageDealt());
        this.trueDamageDealtToChampions = String.valueOf(matchParticipantEntity.getTrueDamageDealtToChampions());
        this.trueDamageTaken = String.valueOf(matchParticipantEntity.getTrueDamageTaken());
        this.turretKills = String.valueOf(matchParticipantEntity.getTurretKills());
        this.turretTakedowns = String.valueOf(matchParticipantEntity.getTurretTakedowns());
        this.turretsLost = String.valueOf(matchParticipantEntity.getTurretsLost());
        this.unrealKills = String.valueOf(matchParticipantEntity.getUnrealKills());
        this.visionScore = String.valueOf(matchParticipantEntity.getVisionScore());
        this.visionWardsBoughtInGame = String.valueOf(matchParticipantEntity.getVisionWardsBoughtInGame());
        this.wardsKilled = String.valueOf(matchParticipantEntity.getWardsKilled());
        this.wardsPlaced = String.valueOf(matchParticipantEntity.getWardsPlaced());
        this.win = String.valueOf(matchParticipantEntity.isWin());
        this.rrt = matchParticipantEntity.getRrt();
        this.perks = perksDto;

        this.multiKills = getMultiKills(this.doubleKills, this.tripleKills, this.quadraKills, this.pentaKills);
        this.kda = getKda(this.kills, this.deaths, this.assists);
        this.minionsKilledPerMin = getMinionsKilledPerMin(this.totalMinionsKilled, gameDuration);

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
