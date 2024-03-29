package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Participant extends BaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long id;

    private int allInPings;
    private int assistMePings;
    private int assists;
    private int baitPings;
    private int baronKills;
    private int basicPings;
    private int bountyLevel;
    private int champExperience;
    private int champLevel;
    private int championId;
    private String championName;
    private int championTransform;
    private int commandPings;
    private int consumablesPurchased;
    private int damageDealtToBuildings;
    private int damageDealtToObjectives;
    private int damageDealtToTurrets;
    private int damageSelfMitigated;
    private int deaths;
    private int detectorWardsPlaced;
    private int doubleKills;
    private int dragonKills;
    private boolean eligibleForProgression;
    private int enemyMissingPings;
    private int enemyVisionPings;
    private boolean firstBloodAssists;
    private boolean firstBloodKill;
    private boolean firstTowerAssist;
    private boolean firstTowerKill;
    private boolean gameEndedInEarlySurrender;
    private boolean gameEndedInSurrender;
    private int getBackPings;
    private int goldEarned;
    private int goldSpent;
    private int holdPings;
    private String individualPosition;
    private int inhibitorKills;
    private int inhibitorTakedowns;
    private int inhibitorsLost;
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;
    private int itemsPurchased;
    private int killingSprees;
    private int kills;
    private String lane;
    private int largestCriticalStrike;
    private int largestKillingSpree;
    private int largestMultiKill;
    private int longestTimeSpentLiving;
    private int magicDamageDealt;
    private int magicDamageDealtToChampions;
    private int magicDamageTaken;
    private int needVisionPings;
    private int neutralMinionsKilled;
    private int nexusKills;
    private int nexusLost;
    private int nexusTakedowns;
    private int objectivesStolen;
    private int objectivesStolenAssists;
    private int onMyWayPings;
    private int pentaKills;
    private int physicalDamageDealt;
    private int physicalDamageDealtToChampions;
    private int physicalDamageTaken;
    private int profileIcon;
    private int pushPings;
    private String puuid;
    private int quadraKills;
    private String riotIdName;
    private String riotIdTagline;
    private String role;
    private int sightWardsBoughtInGame;
    private int spell1Casts;
    private int spell2Casts;
    private int spell3Casts;
    private int spell4Casts;
    private int summoner1Casts;
    private int summoner1Id;
    private int summoner2Casts;
    private int summoner2Id;
    private String summonerId;
    private int summonerLevel;
    private String summonerName;
    private boolean teamEarlySurrendered;
    private int teamId;
    private String teamPosition;
    private int timeCCingOthers;
    private int timePlayed;
    private int totalDamageDealt;
    private int totalDamageDealtToChampions;
    private int totalDamageShieldedOnTeammates;
    private int totalDamageTaken;
    private int totalHeal;
    private int totalHealsOnTeammates;
    private int totalMinionsKilled;
    private int totalTimeCCDealt;
    private int totalTimeSpentDead;
    private int totalUnitsHealed;
    private int tripleKills;
    private int trueDamageDealt;
    private int trueDamageDealtToChampions;
    private int trueDamageTaken;
    private int turretKills;
    private int turretTakedowns;
    private int turretsLost;
    private int unrealKills;
    private int visionClearedPings;
    private int visionScore;
    private int visionWardsBoughtInGame;
    private int wardsKilled;
    private int wardsPlaced;
    private boolean win;

    // 연관관계 매핑
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "perks_id")
    private Perks perks;

    @ManyToOne
    @JoinColumn(name = "info_id")
    private Info info_participants;

    @OneToOne
    @JoinColumn(name = "challenges_id")
    private Challenges challenges;

    // 연관관계 설정
    public void setPerks(Perks perks) { this.perks = perks; }
    public void setInfo(Info info) { this.info_participants = info; }
    public void setChallenges(Challenges challenges) { this.challenges = challenges; }



    @Builder
    public Participant(int allInPings
            , int assistMePings
            , int assists
            , int baitPings
            , int baronKills
            , int basicPings
            , int bountyLevel
            , int champExperience
            , int champLevel
            , int championId
            , String championName
            , int championTransform
            , int commandPings
            , int consumablesPurchased
            , int damageDealtToBuildings
            , int damageDealtToObjectives
            , int damageDealtToTurrets
            , int damageSelfMitigated
            , int deaths
            , int detectorWardsPlaced
            , int doubleKills
            , int dragonKills
            , boolean eligibleForProgression
            , int enemyMissingPings
            , int enemyVisionPings
            , boolean firstBloodAssists
            , boolean firstBloodKill
            , boolean firstTowerAssist
            , boolean firstTowerKill
            , boolean gameEndedInEarlySurrender
            , boolean gameEndedInSurrender
            , int getBackPings
            , int goldEarned
            , int goldSpent
            , int holdPings
            , String individualPosition
            , int inhibitorKills
            , int inhibitorTakedowns
            , int inhibitorsLost
            , int item0
            , int item1
            , int item2
            , int item3
            , int item4
            , int item5
            , int item6
            , int itemsPurchased
            , int killingSprees
            , int kills
            , String lane
            , int largestCriticalStrike
            , int largestKillingSpree
            , int largestMultiKill
            , int longestTimeSpentLiving
            , int magicDamageDealt
            , int magicDamageDealtToChampions
            , int magicDamageTaken
            , int needVisionPings
            , int neutralMinionsKilled
            , int nexusKills
            , int nexusLost
            , int nexusTakedowns
            , int objectivesStolen
            , int objectivesStolenAssists
            , int onMyWayPings
            , int pentaKills
            , int physicalDamageDealt
            , int physicalDamageDealtToChampions
            , int physicalDamageTaken
            , int profileIcon
            , int pushPings
            , String puuid
            , int quadraKills
            , String riotIdName
            , String riotIdTagline
            , String role
            , int sightWardsBoughtInGame
            , int spell1Casts
            , int spell2Casts
            , int spell3Casts
            , int spell4Casts
            , int summoner1Casts
            , int summoner1Id
            , int summoner2Casts
            , int summoner2Id
            , String summonerId
            , int summonerLevel
            , String summonerName
            , boolean teamEarlySurrendered
            , int teamId
            , String teamPosition
            , int timeCCingOthers
            , int timePlayed
            , int totalDamageDealt
            , int totalDamageDealtToChampions
            , int totalDamageShieldedOnTeammates
            , int totalDamageTaken
            , int totalHeal
            , int totalHealsOnTeammates
            , int totalMinionsKilled
            , int totalTimeCCDealt
            , int totalTimeSpentDead
            , int totalUnitsHealed
            , int tripleKills
            , int trueDamageDealt
            , int trueDamageDealtToChampions
            , int trueDamageTaken
            , int turretKills
            , int turretTakedowns
            , int turretsLost
            , int unrealKills
            , int visionClearedPings
            , int visionScore
            , int visionWardsBoughtInGame
            , int wardsKilled
            , int wardsPlaced
            , boolean win
            , Perks perks
//            , Challenges challenges
            , Info info) {
        this.allInPings = allInPings;
        this.assistMePings = assistMePings;
        this.assists = assists;
        this.baitPings = baitPings;
        this.baronKills = baronKills;
        this.basicPings = basicPings;
        this.bountyLevel = bountyLevel;
        this.champExperience = champExperience;
        this.champLevel = champLevel;
        this.championId = championId;
        this.championName = championName;
        this.championTransform = championTransform;
        this.consumablesPurchased = consumablesPurchased;
        this.commandPings = commandPings;
        this.damageDealtToBuildings = damageDealtToBuildings;
        this.damageDealtToObjectives = damageDealtToObjectives;
        this.damageDealtToTurrets = damageDealtToTurrets;
        this.damageSelfMitigated = damageSelfMitigated;
        this.deaths = deaths;
        this.detectorWardsPlaced = detectorWardsPlaced;
        this.doubleKills = doubleKills;
        this.dragonKills = dragonKills;
        this.eligibleForProgression = eligibleForProgression;
        this.enemyMissingPings = enemyMissingPings;
        this.enemyVisionPings = enemyVisionPings;
        this.firstBloodAssists = firstBloodAssists;
        this.firstBloodKill = firstBloodKill;
        this.firstTowerAssist = firstTowerAssist;
        this.firstTowerKill = firstTowerKill;
        this.gameEndedInEarlySurrender = gameEndedInEarlySurrender;
        this.gameEndedInSurrender = gameEndedInSurrender;
        this.getBackPings = getBackPings;
        this.goldEarned = goldEarned;
        this.goldSpent = goldSpent;
        this.holdPings = holdPings;
        this.individualPosition = individualPosition;
        this.inhibitorKills = inhibitorKills;
        this.inhibitorTakedowns = inhibitorTakedowns;
        this.inhibitorsLost = inhibitorsLost;
        this.item0 = item0;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
        this.itemsPurchased = itemsPurchased;
        this.killingSprees = killingSprees;
        this.kills = kills;
        this.lane = lane;
        this.largestCriticalStrike = largestCriticalStrike;
        this.largestKillingSpree = largestKillingSpree;
        this.largestMultiKill = largestMultiKill;
        this.longestTimeSpentLiving = longestTimeSpentLiving;
        this.magicDamageDealt = magicDamageDealt;
        this.magicDamageDealtToChampions = magicDamageDealtToChampions;
        this.magicDamageTaken = magicDamageTaken;
        this.needVisionPings = needVisionPings;
        this.neutralMinionsKilled = neutralMinionsKilled;
        this.nexusKills = nexusKills;
        this.nexusLost = nexusLost;
        this.nexusTakedowns = nexusTakedowns;
        this.objectivesStolen = objectivesStolen;
        this.objectivesStolenAssists = objectivesStolenAssists;
        this.onMyWayPings = onMyWayPings;
        this.pentaKills = pentaKills;
        this.physicalDamageDealt = physicalDamageDealt;
        this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
        this.physicalDamageTaken = physicalDamageTaken;
        this.profileIcon = profileIcon;
        this.pushPings = pushPings;
        this.puuid = puuid;
        this.quadraKills = quadraKills;
        this.riotIdName = riotIdName;
        this.riotIdTagline = riotIdTagline;
        this.role = role;
        this.sightWardsBoughtInGame = sightWardsBoughtInGame;
        this.spell1Casts = spell1Casts;
        this.spell2Casts = spell2Casts;
        this.spell3Casts = spell3Casts;
        this.spell4Casts = spell4Casts;
        this.summoner1Casts = summoner1Casts;
        this.summoner1Id = summoner1Id;
        this.summoner2Casts = summoner2Casts;
        this.summoner2Id = summoner2Id;
        this.summonerId = summonerId;
        this.summonerLevel = summonerLevel;
        this.summonerName = summonerName;
        this.teamEarlySurrendered = teamEarlySurrendered;
        this.teamId = teamId;
        this.teamPosition = teamPosition;
        this.timeCCingOthers = timeCCingOthers;
        this.timePlayed = timePlayed;
        this.totalDamageDealt = totalDamageDealt;
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
        this.totalDamageShieldedOnTeammates = totalDamageShieldedOnTeammates;
        this.totalDamageTaken = totalDamageTaken;
        this.totalHeal = totalHeal;
        this.totalHealsOnTeammates = totalHealsOnTeammates;
        this.totalMinionsKilled = totalMinionsKilled;
        this.totalTimeCCDealt = totalTimeCCDealt;
        this.totalTimeSpentDead = totalTimeSpentDead;
        this.totalUnitsHealed = totalUnitsHealed;
        this.tripleKills = tripleKills;
        this.trueDamageDealt = trueDamageDealt;
        this.trueDamageDealtToChampions = trueDamageDealtToChampions;
        this.trueDamageTaken = trueDamageTaken;
        this.turretKills = turretKills;
        this.turretTakedowns = turretTakedowns;
        this.turretsLost = turretsLost;
        this.unrealKills = unrealKills;
        this.visionClearedPings = visionClearedPings;
        this.visionScore = visionScore;
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
        this.wardsKilled = wardsKilled;
        this.wardsPlaced = wardsPlaced;
        this.win = win;

        setPerks(perks);

//        setChallenges(challenges);

        if(this.info_participants != null) {
            this.info_participants.getParticipants().remove(this);
        }
        setInfo(info);
        info.getParticipants().add(this);
    }
}
