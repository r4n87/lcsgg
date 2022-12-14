package dev.saariselka.lcsgg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChallengesDto {
    @JsonProperty("12AssistStreakCount")
    private int assistStreakCount;
    private int abilityUses;
    private int acesBefore15Minutes;
    private int alliedJungleMonsterKills;
    private int baronTakedowns;
    private int blastConeOppositeOpponentCount;
    private int bountyGold;
    private int buffsStolen;
    private int completeSupportQuestInTime;
    private int controlWardsPlaced;
    private int damagePerMinute;
    private int damageTakenOnTeamPercentage;
    private int dancedWithRiftHerald;
    private int deathsByEnemyChamps;
    private int dodgeSkillShotsSmallWindow;
    private int doubleAces;
    private int dragonTakedowns;
    private int earlyLaningPhaseGoldExpAdvantage;
    private int effectiveHealAndShielding;
    private int elderDragonKillsWithOpposingSoul;
    private int elderDragonMultikills;
    private int enemyChampionImmobilizations;
    private int enemyJungleMonsterKills;
    private int epicMonsterKillsNearEnemyJungler;
    private int epicMonsterKillsWithin30SecondsOfSpawn;
    private int epicMonsterSteals;
    private int epicMonsterStolenWithoutSmite;
    private int flawlessAces;
    private int fullTeamTakedown;
    private int gameLength;
    private int getTakedownsInAllLanesEarlyJungleAsLaner;
    private int goldPerMinute;
    private int hadOpenNexus;
    private int immobilizeAndKillWithAlly;
    private int initialBuffCount;
    private int initialCrabCount;
    private int jungleCsBefore10Minutes;
    private int junglerTakedownsNearDamagedEpicMonster;
    private int kTurretsDestroyedBeforePlatesFall;
    private int kda;
    private int killAfterHiddenWithAlly;
    private int killParticipation;
    private int killedChampTookFullTeamDamageSurvived;
    private int killsNearEnemyTurret;
    private int killsOnOtherLanesEarlyJungleAsLaner;
    private int killsOnRecentlyHealedByAramPack;
    private int killsUnderOwnTurret;
    private int killsWithHelpFromEpicMonster;
    private int knockEnemyIntoTeamAndKill;
    private int landSkillShotsEarlyGame;
    private int laneMinionsFirst10Minutes;
    private int laningPhaseGoldExpAdvantage;
    private int legendaryCount;
    private int lostAnInhibitor;
    private int maxCsAdvantageOnLaneOpponent;
    private int maxKillDeficit;
    private int maxLevelLeadLaneOpponent;
    private int moreEnemyJungleThanOpponent;
    private int multiKillOneSpell;
    private int multiTurretRiftHeraldCount;
    private int multikills;
    private int multikillsAfterAggressiveFlash;
    private int mythicItemUsed;
    private int outerTurretExecutesBefore10Minutes;
    private int outnumberedKills;
    private int outnumberedNexusKill;
    private int perfectDragonSoulsTaken;
    private int perfectGame;
    private int pickKillWithAlly;
    private int playedChampSelectPosition;
    private int poroExplosions;
    private int quickCleanse;
    private int quickFirstTurret;
    private int quickSoloKills;
    private int riftHeraldTakedowns;
    private int saveAllyFromDeath;
    private int scuttleCrabKills;
    private int skillshotsDodged;
    private int skillshotsHit;
    private int snowballsHit;
    private int soloBaronKills;
    private int soloKills;
    private int stealthWardsPlaced;
    private int survivedSingleDigitHpCount;
    private int survivedThreeImmobilizesInFight;
    private int takedownOnFirstTurret;
    private int takedowns;
    private int takedownsAfterGainingLevelAdvantage;
    private int takedownsBeforeJungleMinionSpawn;
    private int takedownsFirstXMinutes;
    private int takedownsInAlcove;
    private int takedownsInEnemyFountain;
    private int teamBaronKills;
    private int teamDamagePercentage;
    private int teamElderDragonKills;
    private int teamRiftHeraldKills;
    private int threeWardsOneSweeperCount;
    private int tookLargeDamageSurvived;
    private int turretPlatesTaken;
    private int turretTakedowns;
    private int turretsTakenWithRiftHerald;
    private int twentyMinionsIn3SecondsCount;
    private int unseenRecalls;
    private int visionScoreAdvantageLaneOpponent;
    private int visionScorePerMinute;
    private int wardTakedowns;
    private int wardTakedownsBefore20M;
    private int wardsGuarded;

    private ParticipantDto participantDto;
}
