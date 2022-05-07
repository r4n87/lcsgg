package dev.saariselka.inlol.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
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
    private String championName;
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

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getBaronKills() {
        return baronKills;
    }

    public void setBaronKills(String baronKills) {
        this.baronKills = baronKills;
    }

    public String getBountyLevel() {
        return bountyLevel;
    }

    public void setBountyLevel(String bountyLevel) {
        this.bountyLevel = bountyLevel;
    }

    public String getChampExperience() {
        return champExperience;
    }

    public void setChampExperience(String champExperience) {
        this.champExperience = champExperience;
    }

    public String getChampLevel() {
        return champLevel;
    }

    public void setChampLevel(String champLevel) {
        this.champLevel = champLevel;
    }

    public String getChampionId() {
        return championId;
    }

    public void setChampionId(String championId) {
        this.championId = championId;
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public String getChampionTransform() {
        return championTransform;
    }

    public void setChampionTransform(String championTransform) {
        this.championTransform = championTransform;
    }

    public String getConsumablesPurchased() {
        return consumablesPurchased;
    }

    public void setConsumablesPurchased(String consumablesPurchased) {
        this.consumablesPurchased = consumablesPurchased;
    }

    public String getDamageDealtToBuildings() {
        return damageDealtToBuildings;
    }

    public void setDamageDealtToBuildings(String damageDealtToBuildings) {
        this.damageDealtToBuildings = damageDealtToBuildings;
    }

    public String getDamageDealtToObjectives() {
        return damageDealtToObjectives;
    }

    public void setDamageDealtToObjectives(String damageDealtToObjectives) {
        this.damageDealtToObjectives = damageDealtToObjectives;
    }

    public String getDamageDealtToTurrets() {
        return damageDealtToTurrets;
    }

    public void setDamageDealtToTurrets(String damageDealtToTurrets) {
        this.damageDealtToTurrets = damageDealtToTurrets;
    }

    public String getDamageSelfMitigated() {
        return damageSelfMitigated;
    }

    public void setDamageSelfMitigated(String damageSelfMitigated) {
        this.damageSelfMitigated = damageSelfMitigated;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getDetectorWardsPlaced() {
        return detectorWardsPlaced;
    }

    public void setDetectorWardsPlaced(String detectorWardsPlaced) {
        this.detectorWardsPlaced = detectorWardsPlaced;
    }

    public String getDoubleKills() {
        return doubleKills;
    }

    public void setDoubleKills(String doubleKills) {
        this.doubleKills = doubleKills;
    }

    public String getDragonKills() {
        return dragonKills;
    }

    public void setDragonKills(String dragonKills) {
        this.dragonKills = dragonKills;
    }

    public String isFirstBloodAssist() {
        return firstBloodAssist;
    }

    public void setFirstBloodAssist(String firstBloodAssist) {
        this.firstBloodAssist = firstBloodAssist;
    }

    public String isFirstBloodKill() {
        return firstBloodKill;
    }

    public void setFirstBloodKill(String firstBloodKill) {
        this.firstBloodKill = firstBloodKill;
    }

    public String isFirstTowerAssist() {
        return firstTowerAssist;
    }

    public void setFirstTowerAssist(String firstTowerAssist) {
        this.firstTowerAssist = firstTowerAssist;
    }

    public String isFirstTowerKill() {
        return firstTowerKill;
    }

    public void setFirstTowerKill(String firstTowerKill) {
        this.firstTowerKill = firstTowerKill;
    }

    public String isGameEndedInEarlySurrender() {
        return gameEndedInEarlySurrender;
    }

    public void setGameEndedInEarlySurrender(String gameEndedInEarlySurrender) {
        this.gameEndedInEarlySurrender = gameEndedInEarlySurrender;
    }

    public String isGameEndedInSurrender() {
        return gameEndedInSurrender;
    }

    public void setGameEndedInSurrender(String gameEndedInSurrender) {
        this.gameEndedInSurrender = gameEndedInSurrender;
    }

    public String getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(String goldEarned) {
        this.goldEarned = goldEarned;
    }

    public String getGoldSpent() {
        return goldSpent;
    }

    public void setGoldSpent(String goldSpent) {
        this.goldSpent = goldSpent;
    }

    public String getIndividualPosition() {
        return individualPosition;
    }

    public void setIndividualPosition(String individualPosition) {
        this.individualPosition = individualPosition;
    }

    public String getInhibitorKills() {
        return inhibitorKills;
    }

    public void setInhibitorKills(String inhibitorKills) {
        this.inhibitorKills = inhibitorKills;
    }

    public String getInhibitorTakedowns() {
        return inhibitorTakedowns;
    }

    public void setInhibitorTakedowns(String inhibitorTakedowns) {
        this.inhibitorTakedowns = inhibitorTakedowns;
    }

    public String getInhibitorsLost() {
        return inhibitorsLost;
    }

    public void setInhibitorsLost(String inhibitorsLost) {
        this.inhibitorsLost = inhibitorsLost;
    }

    public String getItem0() {
        return item0;
    }

    public void setItem0(String item0) {
        this.item0 = item0;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    public String getItem4() {
        return item4;
    }

    public void setItem4(String item4) {
        this.item4 = item4;
    }

    public String getItem5() {
        return item5;
    }

    public void setItem5(String item5) {
        this.item5 = item5;
    }

    public String getItem6() {
        return item6;
    }

    public void setItem6(String item6) {
        this.item6 = item6;
    }

    public String getItemsPurchased() {
        return itemsPurchased;
    }

    public void setItemsPurchased(String itemsPurchased) {
        this.itemsPurchased = itemsPurchased;
    }

    public String getKillingSprees() {
        return killingSprees;
    }

    public void setKillingSprees(String killingSprees) {
        this.killingSprees = killingSprees;
    }

    public String getKills() {
        return kills;
    }

    public void setKills(String kills) {
        this.kills = kills;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getLargestCriticalStrike() {
        return largestCriticalStrike;
    }

    public void setLargestCriticalStrike(String largestCriticalStrike) {
        this.largestCriticalStrike = largestCriticalStrike;
    }

    public String getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public void setLargestKillingSpree(String largestKillingSpree) {
        this.largestKillingSpree = largestKillingSpree;
    }

    public String getLargestMultiKill() {
        return largestMultiKill;
    }

    public void setLargestMultiKill(String largestMultiKill) {
        this.largestMultiKill = largestMultiKill;
    }

    public String getLongestTimeSpentLiving() {
        return longestTimeSpentLiving;
    }

    public void setLongestTimeSpentLiving(String longestTimeSpentLiving) {
        this.longestTimeSpentLiving = longestTimeSpentLiving;
    }

    public String getMagicDamageDealt() {
        return magicDamageDealt;
    }

    public void setMagicDamageDealt(String magicDamageDealt) {
        this.magicDamageDealt = magicDamageDealt;
    }

    public String getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    public void setMagicDamageDealtToChampions(String magicDamageDealtToChampions) {
        this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    }

    public String getMagicDamageTaken() {
        return magicDamageTaken;
    }

    public void setMagicDamageTaken(String magicDamageTaken) {
        this.magicDamageTaken = magicDamageTaken;
    }

    public String getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public void setNeutralMinionsKilled(String neutralMinionsKilled) {
        this.neutralMinionsKilled = neutralMinionsKilled;
    }

    public String getNexusKills() {
        return nexusKills;
    }

    public void setNexusKills(String nexusKills) {
        this.nexusKills = nexusKills;
    }

    public String getNexusTakedowns() {
        return nexusTakedowns;
    }

    public void setNexusTakedowns(String nexusTakedowns) {
        this.nexusTakedowns = nexusTakedowns;
    }

    public String getNexusLost() {
        return nexusLost;
    }

    public void setNexusLost(String nexusLost) {
        this.nexusLost = nexusLost;
    }

    public String getObjectivesStolen() {
        return objectivesStolen;
    }

    public void setObjectivesStolen(String objectivesStolen) {
        this.objectivesStolen = objectivesStolen;
    }

    public String getObjectivesStolenAssists() {
        return objectivesStolenAssists;
    }

    public void setObjectivesStolenAssists(String objectivesStolenAssists) {
        this.objectivesStolenAssists = objectivesStolenAssists;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getPentaKills() {
        return pentaKills;
    }

    public void setPentaKills(String pentaKills) {
        this.pentaKills = pentaKills;
    }

    public String getPhysicalDamageDealt() {
        return physicalDamageDealt;
    }

    public void setPhysicalDamageDealt(String physicalDamageDealt) {
        this.physicalDamageDealt = physicalDamageDealt;
    }

    public String getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    public void setPhysicalDamageDealtToChampions(String physicalDamageDealtToChampions) {
        this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    }

    public String getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public void setPhysicalDamageTaken(String physicalDamageTaken) {
        this.physicalDamageTaken = physicalDamageTaken;
    }

    public String getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(String profileIcon) {
        this.profileIcon = profileIcon;
    }

    public String getQuadraKills() {
        return quadraKills;
    }

    public void setQuadraKills(String quadraKills) {
        this.quadraKills = quadraKills;
    }

    public String getRiotIdName() {
        return riotIdName;
    }

    public void setRiotIdName(String riotIdName) {
        this.riotIdName = riotIdName;
    }

    public String getRiotIdTagline() {
        return riotIdTagline;
    }

    public void setRiotIdTagline(String riotIdTagline) {
        this.riotIdTagline = riotIdTagline;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSightWardsBoughtInGame() {
        return sightWardsBoughtInGame;
    }

    public void setSightWardsBoughtInGame(String sightWardsBoughtInGame) {
        this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    }

    public String getSpell1Casts() {
        return spell1Casts;
    }

    public void setSpell1Casts(String spell1Casts) {
        this.spell1Casts = spell1Casts;
    }

    public String getSpell2Casts() {
        return spell2Casts;
    }

    public void setSpell2Casts(String spell2Casts) {
        this.spell2Casts = spell2Casts;
    }

    public String getSpell3Casts() {
        return spell3Casts;
    }

    public void setSpell3Casts(String spell3Casts) {
        this.spell3Casts = spell3Casts;
    }

    public String getSpell4Casts() {
        return spell4Casts;
    }

    public void setSpell4Casts(String spell4Casts) {
        this.spell4Casts = spell4Casts;
    }

    public String getSummoner1Casts() {
        return summoner1Casts;
    }

    public void setSummoner1Casts(String summoner1Casts) {
        this.summoner1Casts = summoner1Casts;
    }

    public String getSummoner1Id() {
        return summoner1Id;
    }

    public void setSummoner1Id(String summoner1Id) {
        this.summoner1Id = summoner1Id;
    }

    public String getSummoner2Casts() {
        return summoner2Casts;
    }

    public void setSummoner2Casts(String summoner2Casts) {
        this.summoner2Casts = summoner2Casts;
    }

    public String getSummoner2Id() {
        return summoner2Id;
    }

    public void setSummoner2Id(String summoner2Id) {
        this.summoner2Id = summoner2Id;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(String summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String isTeamEarlySurrendered() {
        return teamEarlySurrendered;
    }

    public void setTeamEarlySurrendered(String teamEarlySurrendered) {
        this.teamEarlySurrendered = teamEarlySurrendered;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamPosition() {
        return teamPosition;
    }

    public void setTeamPosition(String teamPosition) {
        this.teamPosition = teamPosition;
    }

    public String getTimeCCingOthers() {
        return timeCCingOthers;
    }

    public void setTimeCCingOthers(String timeCCingOthers) {
        this.timeCCingOthers = timeCCingOthers;
    }

    public String getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(String timePlayed) {
        this.timePlayed = timePlayed;
    }

    public String getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt(String totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public String getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public void setTotalDamageDealtToChampions(String totalDamageDealtToChampions) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    public String getTotalDamageShieldedOnTeammates() {
        return totalDamageShieldedOnTeammates;
    }

    public void setTotalDamageShieldedOnTeammates(String totalDamageShieldedOnTeammates) {
        this.totalDamageShieldedOnTeammates = totalDamageShieldedOnTeammates;
    }

    public String getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public void setTotalDamageTaken(String totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    public String getTotalHeal() {
        return totalHeal;
    }

    public void setTotalHeal(String totalHeal) {
        this.totalHeal = totalHeal;
    }

    public String getTotalHealsOnTeammates() {
        return totalHealsOnTeammates;
    }

    public void setTotalHealsOnTeammates(String totalHealsOnTeammates) {
        this.totalHealsOnTeammates = totalHealsOnTeammates;
    }

    public String getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public void setTotalMinionsKilled(String totalMinionsKilled) {
        this.totalMinionsKilled = totalMinionsKilled;
    }

    public String getTotalTimeCCDealt() {
        return totalTimeCCDealt;
    }

    public void setTotalTimeCCDealt(String totalTimeCCDealt) {
        this.totalTimeCCDealt = totalTimeCCDealt;
    }

    public String getTotalTimeSpentDead() {
        return totalTimeSpentDead;
    }

    public void setTotalTimeSpentDead(String totalTimeSpentDead) {
        this.totalTimeSpentDead = totalTimeSpentDead;
    }

    public String getTotalUnitsHealed() {
        return totalUnitsHealed;
    }

    public void setTotalUnitsHealed(String totalUnitsHealed) {
        this.totalUnitsHealed = totalUnitsHealed;
    }

    public String getTripleKills() {
        return tripleKills;
    }

    public void setTripleKills(String tripleKills) {
        this.tripleKills = tripleKills;
    }

    public String getTrueDamageDealt() {
        return trueDamageDealt;
    }

    public void setTrueDamageDealt(String trueDamageDealt) {
        this.trueDamageDealt = trueDamageDealt;
    }

    public String getTrueDamageDealtToChampions() {
        return trueDamageDealtToChampions;
    }

    public void setTrueDamageDealtToChampions(String trueDamageDealtToChampions) {
        this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    }

    public String getTrueDamageTaken() {
        return trueDamageTaken;
    }

    public void setTrueDamageTaken(String trueDamageTaken) {
        this.trueDamageTaken = trueDamageTaken;
    }

    public String getTurretKills() {
        return turretKills;
    }

    public void setTurretKills(String turretKills) {
        this.turretKills = turretKills;
    }

    public String getTurretTakedowns() {
        return turretTakedowns;
    }

    public void setTurretTakedowns(String turretTakedowns) {
        this.turretTakedowns = turretTakedowns;
    }

    public String getTurretsLost() {
        return turretsLost;
    }

    public void setTurretsLost(String turretsLost) {
        this.turretsLost = turretsLost;
    }

    public String getUnrealKills() {
        return unrealKills;
    }

    public void setUnrealKills(String unrealKills) {
        this.unrealKills = unrealKills;
    }

    public String getVisionScore() {
        return visionScore;
    }

    public void setVisionScore(String visionScore) {
        this.visionScore = visionScore;
    }

    public String getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    public void setVisionWardsBoughtInGame(String visionWardsBoughtInGame) {
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    }

    public String getWardsKilled() {
        return wardsKilled;
    }

    public void setWardsKilled(String wardsKilled) {
        this.wardsKilled = wardsKilled;
    }

    public String getWardsPlaced() {
        return wardsPlaced;
    }

    public void setWardsPlaced(String wardsPlaced) {
        this.wardsPlaced = wardsPlaced;
    }

    public String isWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public Timestamp getRrt() {
        return rrt;
    }

    public void setRrt(Timestamp rrt) {
        this.rrt = rrt;
    }
}
