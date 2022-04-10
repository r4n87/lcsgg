package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.service.MatchParticipantService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/Participants")
public class MatchParticipantController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MatchParticipantService matchParticipantService;

    public void insertParticipantInfo(String puuid, String dataVersion, String matchId, int assists, int baronKills, int bountyLevel, int champExperience,
                                      int champLevel, int championId, String championName, int championTransform, int consumablesPurchased, int damageDealtToBuildings,
                                      int damageDealtToObjectives, int damageDealtToTurrets, int damageSelfMitigated, int deaths, int detectorWardsPlaced,
                                      int doubleKills, int dragonKills, boolean firstBloodAssist, boolean firstBloodKill, boolean firstTowerAssist, boolean firstTowerKill,
                                      boolean gameEndedInEarlySurrender, boolean gameEndedInSurrender, int goldEarned, int goldSpent, String individualPosition,
                                      int inhibitorKills, int inhibitorTakedowns, int inhibitorsLost, int item0, int item1, int item2, int item3, int item4,
                                      int item5, int item6, int itemsPurchased, int killingSprees, int kills, String lane, int largestCriticalStrike,
                                      int largestKillingSpree, int largestMultiKill, int longestTimeSpentLiving, int magicDamageDealt, int magicDamageDealtToChampions,
                                      int magicDamageTaken, int neutralMinionsKilled, int nexusKills, int nexusTakedowns, int nexusLost, int objectivesStolen,
                                      int objectivesStolenAssists, int participantId, int pentaKills, int physicalDamageDealt, int physicalDamageDealtToChampions,
                                      int physicalDamageTaken, int profileIcon, int quadraKills, String riotIdName, String riotIdTagline, String role, int sightWardsBoughtInGame,
                                      int spell1Casts, int spell2Casts, int spell3Casts, int spell4Casts, int summoner1Casts, int summoner1Id,
                                      int summoner2Casts, int summoner2Id, String summonerId, int summonerLevel, String summonerName, boolean teamEarlySurrendered,
                                      int teamId, String teamPosition, int timeCCingOthers, int timePlayed, int totalDamageDealt, int totalDamageDealtToChampions,
                                      int totalDamageShieldedOnTeammates, int totalDamageTaken, int totalHeal, int totalHealsOnTeammates, int totalMinionsKilled,
                                      int totalTimeCCDealt, int totalTimeSpentDead, int totalUnitsHealed, int tripleKills, int trueDamageDealt, int trueDamageDealtToChampions,
                                      int trueDamageTaken, int turretKills, int turretTakedowns, int turretsLost, int unrealKills, int visionScore, int visionWardsBoughtInGame,
                                      int wardsKilled, int wardsPlaced, boolean win) {
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
                turretTakedowns, turretsLost, unrealKills, visionScore, visionWardsBoughtInGame, wardsKilled, wardsPlaced, win);
    }
}
