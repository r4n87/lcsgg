package dev.saariselka.lcsgg.service;

import dev.saariselka.lcsgg.entity.*;
import dev.saariselka.lcsgg.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public Match getMatchByMatchId(String matchId) {
        return matchRepository.findByMetadata_MatchId(matchId).get();
    }

    public void insert(Match match) {

        Info newInfo = new Info(match.getInfo().getGameCreation(),
                match.getInfo().getGameDuration(),
                match.getInfo().getGameEndTimestamp(),
                match.getInfo().getGameId(),
                match.getInfo().getGameMode(),
                match.getInfo().getGameName(),
                match.getInfo().getGameStartTimestamp(),
                match.getInfo().getGameType(),
                match.getInfo().getGameVersion(),
                match.getInfo().getMapId(),
                match.getInfo().getPlatformId(),
                match.getInfo().getQueueId(),
                match.getInfo().getTournamentCode());

        List<Team> newTeams = new ArrayList<>();

        for (Team team : match.getInfo().getTeams().stream().collect(Collectors.toList())) {

            Team newTeam = new Team(team.isWin(), team.getTeamId(), team.getObjectives(), newInfo);

            List<Ban> newBans = new ArrayList<>();

            for(Ban ban : team.getBans().stream().collect(Collectors.toList())) {
                Ban newBan = new Ban(ban.getChampionId(), ban.getPickTurn(), newTeam);
                newBans.add(newBan);
            }

            newTeam.setBans(newBans);

            newTeams.add(newTeam);
        }

        List<Participant> newParticipants = new ArrayList<>();

        for(Participant participant : match.getInfo().getParticipants().stream().collect(Collectors.toList())) {

            Perks newPerks = new Perks();

            PerkStats newPerkStats = new PerkStats(participant.getPerks().getStatPerks().getDefense(),
                    participant.getPerks().getStatPerks().getFlex(),
                    participant.getPerks().getStatPerks().getOffense());

            List<PerkStyle> newPerkStyles = new ArrayList<>();

            for(PerkStyle perkStyle : participant.getPerks().getStyles().stream().collect(Collectors.toList())) {

                PerkStyle newPerkStyle = new PerkStyle(perkStyle.getDescription(),
                        perkStyle.getStyle(),
                        newPerks);

                List<PerkStyleSelection> newPerkStyleSelections = new ArrayList<>();

                for(PerkStyleSelection perkStyleSelection : perkStyle.getSelections().stream().collect(Collectors.toList())) {
                    PerkStyleSelection newPerkStyleSelection = new PerkStyleSelection(perkStyleSelection.getPerk(),
                            perkStyleSelection.getVar1(),
                            perkStyleSelection.getVar2(),
                            perkStyleSelection.getVar3(),
                            newPerkStyle);

                    newPerkStyleSelections.add(newPerkStyleSelection);
                }

                newPerkStyles.add(newPerkStyle);
            }

            newPerks.setStyles(newPerkStyles);
            newPerks.setStatPerks(newPerkStats);

//            Challenges newChallenges;
//
//            if(participant.getChallenges() != null) {
//                newChallenges = new Challenges(
//                        participant.getChallenges().getAssistStreakCount(),
//                        participant.getChallenges().getAbilityUses(),
//                        participant.getChallenges().getAcesBefore15Minutes(),
//                        participant.getChallenges().getAlliedJungleMonsterKills(),
//                        participant.getChallenges().getBaronTakedowns(),
//                        participant.getChallenges().getBlastConeOppositeOpponentCount(),
//                        participant.getChallenges().getBountyGold(),
//                        participant.getChallenges().getBuffsStolen(),
//                        participant.getChallenges().getCompleteSupportQuestInTime(),
//                        participant.getChallenges().getControlWardsPlaced(),
//                        participant.getChallenges().getDamagePerMinute(),
//                        participant.getChallenges().getDamageTakenOnTeamPercentage(),
//                        participant.getChallenges().getDancedWithRiftHerald(),
//                        participant.getChallenges().getDeathsByEnemyChamps(),
//                        participant.getChallenges().getDodgeSkillShotsSmallWindow(),
//                        participant.getChallenges().getDoubleAces(),
//                        participant.getChallenges().getDragonTakedowns(),
//                        participant.getChallenges().getEarlyLaningPhaseGoldExpAdvantage(),
//                        participant.getChallenges().getEffectiveHealAndShielding(),
//                        participant.getChallenges().getElderDragonKillsWithOpposingSoul(),
//                        participant.getChallenges().getElderDragonMultikills(),
//                        participant.getChallenges().getEnemyChampionImmobilizations(),
//                        participant.getChallenges().getEnemyJungleMonsterKills(),
//                        participant.getChallenges().getEpicMonsterKillsNearEnemyJungler(),
//                        participant.getChallenges().getEpicMonsterKillsWithin30SecondsOfSpawn(),
//                        participant.getChallenges().getEpicMonsterSteals(),
//                        participant.getChallenges().getEpicMonsterStolenWithoutSmite(),
//                        participant.getChallenges().getFlawlessAces(),
//                        participant.getChallenges().getFullTeamTakedown(),
//                        participant.getChallenges().getGameLength(),
//                        participant.getChallenges().getGetTakedownsInAllLanesEarlyJungleAsLaner(),
//                        participant.getChallenges().getGoldPerMinute(),
//                        participant.getChallenges().getHadOpenNexus(),
//                        participant.getChallenges().getImmobilizeAndKillWithAlly(),
//                        participant.getChallenges().getInitialBuffCount(),
//                        participant.getChallenges().getInitialCrabCount(),
//                        participant.getChallenges().getJungleCsBefore10Minutes(),
//                        participant.getChallenges().getJunglerTakedownsNearDamagedEpicMonster(),
//                        participant.getChallenges().getKTurretsDestroyedBeforePlatesFall(),
//                        participant.getChallenges().getKda(),
//                        participant.getChallenges().getKillAfterHiddenWithAlly(),
//                        participant.getChallenges().getKillParticipation(),
//                        participant.getChallenges().getKilledChampTookFullTeamDamageSurvived(),
//                        participant.getChallenges().getKillsNearEnemyTurret(),
//                        participant.getChallenges().getKillsOnOtherLanesEarlyJungleAsLaner(),
//                        participant.getChallenges().getKillsOnOtherLanesEarlyJungleAsLaner(),
//                        participant.getChallenges().getKillsUnderOwnTurret(),
//                        participant.getChallenges().getKillsWithHelpFromEpicMonster(),
//                        participant.getChallenges().getKnockEnemyIntoTeamAndKill(),
//                        participant.getChallenges().getLandSkillShotsEarlyGame(),
//                        participant.getChallenges().getLaneMinionsFirst10Minutes(),
//                        participant.getChallenges().getLaningPhaseGoldExpAdvantage(),
//                        participant.getChallenges().getLegendaryCount(),
//                        participant.getChallenges().getLostAnInhibitor(),
//                        participant.getChallenges().getMaxCsAdvantageOnLaneOpponent(),
//                        participant.getChallenges().getMaxKillDeficit(),
//                        participant.getChallenges().getMaxLevelLeadLaneOpponent(),
//                        participant.getChallenges().getMoreEnemyJungleThanOpponent(),
//                        participant.getChallenges().getMultiKillOneSpell(),
//                        participant.getChallenges().getMultiTurretRiftHeraldCount(),
//                        participant.getChallenges().getMultikills(),
//                        participant.getChallenges().getMultikillsAfterAggressiveFlash(),
//                        participant.getChallenges().getMythicItemUsed(),
//                        participant.getChallenges().getOuterTurretExecutesBefore10Minutes(),
//                        participant.getChallenges().getOutnumberedKills(),
//                        participant.getChallenges().getOutnumberedNexusKill(),
//                        participant.getChallenges().getPerfectDragonSoulsTaken(),
//                        participant.getChallenges().getPerfectGame(),
//                        participant.getChallenges().getPickKillWithAlly(),
//                        participant.getChallenges().getPlayedChampSelectPosition(),
//                        participant.getChallenges().getPoroExplosions(),
//                        participant.getChallenges().getQuickCleanse(),
//                        participant.getChallenges().getQuickFirstTurret(),
//                        participant.getChallenges().getQuickSoloKills(),
//                        participant.getChallenges().getRiftHeraldTakedowns(),
//                        participant.getChallenges().getSaveAllyFromDeath(),
//                        participant.getChallenges().getScuttleCrabKills(),
//                        participant.getChallenges().getSkillshotsDodged(),
//                        participant.getChallenges().getSkillshotsHit(),
//                        participant.getChallenges().getSnowballsHit(),
//                        participant.getChallenges().getSoloBaronKills(),
//                        participant.getChallenges().getSoloKills(),
//                        participant.getChallenges().getStealthWardsPlaced(),
//                        participant.getChallenges().getSurvivedSingleDigitHpCount(),
//                        participant.getChallenges().getSurvivedThreeImmobilizesInFight(),
//                        participant.getChallenges().getTakedownOnFirstTurret(),
//                        participant.getChallenges().getTakedowns(),
//                        participant.getChallenges().getTakedownsAfterGainingLevelAdvantage(),
//                        participant.getChallenges().getTakedownsBeforeJungleMinionSpawn(),
//                        participant.getChallenges().getTakedownsFirstXMinutes(),
//                        participant.getChallenges().getTakedownsInAlcove(),
//                        participant.getChallenges().getTakedownsInEnemyFountain(),
//                        participant.getChallenges().getTeamBaronKills(),
//                        participant.getChallenges().getTeamDamagePercentage(),
//                        participant.getChallenges().getTeamElderDragonKills(),
//                        participant.getChallenges().getTeamRiftHeraldKills(),
//                        participant.getChallenges().getThreeWardsOneSweeperCount(),
//                        participant.getChallenges().getTookLargeDamageSurvived(),
//                        participant.getChallenges().getTurretPlatesTaken(),
//                        participant.getChallenges().getTurretTakedowns(),
//                        participant.getChallenges().getTurretsTakenWithRiftHerald(),
//                        participant.getChallenges().getTwentyMinionsIn3SecondsCount(),
//                        participant.getChallenges().getUnseenRecalls(),
//                        participant.getChallenges().getVisionScoreAdvantageLaneOpponent(),
//                        participant.getChallenges().getVisionScorePerMinute(),
//                        participant.getChallenges().getWardTakedowns(),
//                        participant.getChallenges().getWardTakedownsBefore20M(),
//                        participant.getChallenges().getWardsGuarded()
//                );
//            }
//            else {
//                newChallenges = new Challenges();
//            }

            Participant newParticipant = new Participant(participant.getAllInPings(),
                    participant.getAssistMePings(),
                    participant.getAssists(),
                    participant.getBaitPings(),
                    participant.getBaronKills(),
                    participant.getBasicPings(),
                    participant.getBountyLevel(),
                    participant.getChampExperience(),
                    participant.getChampLevel(),
                    participant.getChampionId(),
                    participant.getChampionName(),
                    participant.getChampionTransform(),
                    participant.getCommandPings(),
                    participant.getConsumablesPurchased(),
                    participant.getDamageDealtToBuildings(),
                    participant.getDamageDealtToObjectives(),
                    participant.getDamageDealtToTurrets(),
                    participant.getDamageSelfMitigated(),
                    participant.getDeaths(),
                    participant.getDetectorWardsPlaced(),
                    participant.getDoubleKills(),
                    participant.getDragonKills(),
                    participant.isEligibleForProgression(),
                    participant.getEnemyMissingPings(),
                    participant.getEnemyVisionPings(),
                    participant.isFirstBloodAssists(),
                    participant.isFirstBloodKill(),
                    participant.isFirstTowerAssist(),
                    participant.isFirstTowerKill(),
                    participant.isGameEndedInEarlySurrender(),
                    participant.isGameEndedInSurrender(),
                    participant.getGetBackPings(),
                    participant.getGoldEarned(),
                    participant.getGoldSpent(),
                    participant.getHoldPings(),
                    participant.getIndividualPosition(),
                    participant.getInhibitorKills(),
                    participant.getInhibitorTakedowns(),
                    participant.getInhibitorsLost(),
                    participant.getItem0(),
                    participant.getItem1(),
                    participant.getItem2(),
                    participant.getItem3(),
                    participant.getItem4(),
                    participant.getItem5(),
                    participant.getItem6(),
                    participant.getItemsPurchased(),
                    participant.getKillingSprees(),
                    participant.getKills(),
                    participant.getLane(),
                    participant.getLargestCriticalStrike(),
                    participant.getLargestKillingSpree(),
                    participant.getLargestMultiKill(),
                    participant.getLongestTimeSpentLiving(),
                    participant.getMagicDamageDealt(),
                    participant.getMagicDamageDealtToChampions(),
                    participant.getMagicDamageTaken(),
                    participant.getNeedVisionPings(),
                    participant.getNeutralMinionsKilled(),
                    participant.getNexusKills(),
                    participant.getNexusLost(),
                    participant.getNexusTakedowns(),
                    participant.getObjectivesStolen(),
                    participant.getObjectivesStolenAssists(),
                    participant.getOnMyWayPings(),
                    participant.getPentaKills(),
                    participant.getPhysicalDamageDealt(),
                    participant.getPhysicalDamageDealtToChampions(),
                    participant.getPhysicalDamageTaken(),
                    participant.getProfileIcon(),
                    participant.getPushPings(),
                    participant.getPuuid(),
                    participant.getQuadraKills(),
                    participant.getRiotIdName(),
                    participant.getRiotIdTagline(),
                    participant.getRole(),
                    participant.getSightWardsBoughtInGame(),
                    participant.getSpell1Casts(),
                    participant.getSpell2Casts(),
                    participant.getSpell3Casts(),
                    participant.getSpell4Casts(),
                    participant.getSummoner1Casts(),
                    participant.getSummoner1Id(),
                    participant.getSummoner2Casts(),
                    participant.getSummoner2Id(),
                    participant.getSummonerId(),
                    participant.getSummonerLevel(),
                    participant.getSummonerName(),
                    participant.isTeamEarlySurrendered(),
                    participant.getTeamId(),
                    participant.getTeamPosition(),
                    participant.getTimeCCingOthers(),
                    participant.getTimePlayed(),
                    participant.getTotalDamageDealt(),
                    participant.getTotalDamageDealtToChampions(),
                    participant.getTotalDamageShieldedOnTeammates(),
                    participant.getTotalDamageTaken(),
                    participant.getTotalHeal(),
                    participant.getTotalHealsOnTeammates(),
                    participant.getTotalMinionsKilled(),
                    participant.getTotalTimeCCDealt(),
                    participant.getTotalTimeSpentDead(),
                    participant.getTotalUnitsHealed(),
                    participant.getTripleKills(),
                    participant.getTrueDamageDealt(),
                    participant.getTrueDamageDealtToChampions(),
                    participant.getTrueDamageTaken(),
                    participant.getTurretKills(),
                    participant.getTurretTakedowns(),
                    participant.getTurretsLost(),
                    participant.getUnrealKills(),
                    participant.getVisionClearedPings(),
                    participant.getVisionScore(),
                    participant.getVisionWardsBoughtInGame(),
                    participant.getWardsKilled(),
                    participant.getWardsPlaced(),
                    participant.isWin(),
                    newPerks,
//                    newChallenges,
                    newInfo);

            newParticipants.add(newParticipant);
        }

        newInfo.setParticipants(newParticipants);

        newInfo.setTeams(newTeams);

        List<Participant> newParticipants = new ArrayList<>();
        for(Participant participant : new ArrayList<>(match.getInfo().getParticipants())) {
            Participant newParticipant = new Participant(
                    participant.getAllInPings(),
                    participant.getAssistMePings(),
                    participant.getAssists(),
                    participant.getBaitPings(),
                    participant.getBaronKills(),
                    participant.getBasicPings(),
                    participant.getBountyLevel(),
                    participant.getChampExperience(),
                    participant.getChampLevel(),
                    participant.getChampionId(),
                    participant.getChampionName(),
                    participant.getChampionTransform(),
                    participant.getCommandPings(),
                    participant.getConsumablesPurchased(),
                    participant.getDamageDealtToBuildings(),
                    participant.getDamageDealtToObjectives(),
                    participant.getDamageDealtToTurrets(),
                    participant.getDamageSelfMitigated(),
                    participant.getDeaths(),
                    participant.getDetectorWardsPlaced(),
                    participant.getDoubleKills(),
                    participant.getDragonKills(),
                    participant.isEligibleForProgression(),
                    participant.getEnemyMissingPings(),
                    participant.getEnemyVisionPings(),
                    participant.isFirstBloodAssists(),
                    participant.isFirstBloodKill(),
                    participant.isFirstTowerAssist(),
                    participant.isFirstTowerKill(),
                    participant.isGameEndedInEarlySurrender(),
                    participant.isGameEndedInSurrender(),
                    participant.getGetBackPings(),
                    participant.getGoldEarned(),
                    participant.getGoldSpent(),
                    participant.getHoldPings(),
                    participant.getIndividualPosition(),
                    participant.getInhibitorKills(),
                    participant.getInhibitorTakedowns(),
                    participant.getInhibitorsLost(),
                    participant.getItem0(),
                    participant.getItem1(),
                    participant.getItem2(),
                    participant.getItem3(),
                    participant.getItem4(),
                    participant.getItem5(),
                    participant.getItem6(),
                    participant.getItemsPurchased(),
                    participant.getKillingSprees(),
                    participant.getKills(),
                    participant.getLane(),
                    participant.getLargestCriticalStrike(),
                    participant.getLargestKillingSpree(),
                    participant.getLargestMultiKill(),
                    participant.getLongestTimeSpentLiving(),
                    participant.getMagicDamageDealt(),
                    participant.getMagicDamageDealtToChampions(),
                    participant.getMagicDamageTaken(),
                    participant.getNeedVisionPings(),
                    participant.getNeutralMinionsKilled(),
                    participant.getNexusKills(),
                    participant.getNexusLost(),
                    participant.getNexusTakedowns(),
                    participant.getObjectivesStolen(),
                    participant.getObjectivesStolenAssists(),
                    participant.getOnMyWayPings(),
                    participant.getPentaKills(),
                    participant.getPhysicalDamageDealt(),
                    participant.getPhysicalDamageDealtToChampions(),
                    participant.getPhysicalDamageTaken(),
                    participant.getProfileIcon(),
                    participant.getPushPings(),
                    participant.getPuuid(),
                    participant.getQuadraKills(),
                    participant.getRiotIdName(),
                    participant.getRiotIdTagline(),
                    participant.getRole(),
                    participant.getSightWardsBoughtInGame(),
                    participant.getSpell1Casts(),
                    participant.getSpell2Casts(),
                    participant.getSpell3Casts(),
                    participant.getSpell4Casts(),
                    participant.getSummoner1Casts(),
                    participant.getSummoner1Id(),
                    participant.getSummoner2Casts(),
                    participant.getSummoner2Id(),
                    participant.getSummonerId(),
                    participant.getSummonerLevel(),
                    participant.getSummonerName(),
                    participant.isTeamEarlySurrendered(),
                    participant.getTeamId(),
                    participant.getTeamPosition(),
                    participant.getTimeCCingOthers(),
                    participant.getTimePlayed(),
                    participant.getTotalDamageDealt(),
                    participant.getTotalDamageDealtToChampions(),
                    participant.getTotalDamageShieldedOnTeammates(),
                    participant.getTotalDamageTaken(),
                    participant.getTotalHeal(),
                    participant.getTotalHealsOnTeammates(),
                    participant.getTotalMinionsKilled(),
                    participant.getTotalTimeCCDealt(),
                    participant.getTotalTimeSpentDead(),
                    participant.getTotalUnitsHealed(),
                    participant.getTripleKills(),
                    participant.getTrueDamageDealt(),
                    participant.getTrueDamageDealtToChampions(),
                    participant.getTrueDamageTaken(),
                    participant.getTurretKills(),
                    participant.getTurretTakedowns(),
                    participant.getTurretsLost(),
                    participant.getUnrealKills(),
                    participant.getVisionClearedPings(),
                    participant.getVisionScore(),
                    participant.getVisionWardsBoughtInGame(),
                    participant.getWardsKilled(),
                    participant.getWardsPlaced(),
                    participant.isWin(),
                    participant.getPerks(),
                    newInfo
            );

            Perks newPerks = new Perks(participant.getPerks().getStatPerks());
            List<PerkStyle> newPerkStyles = new ArrayList<>();
            for(PerkStyle perkStyle : new ArrayList<>(newParticipant.getPerks().getStyles())) {
                PerkStyle newPerkStyle = new PerkStyle(
                        perkStyle.getDescription(),
                        perkStyle.getStyle(),
                        newPerks
                );

                newPerkStyles.add(newPerkStyle);
            }

            newPerks.setStyles(newPerkStyles);
            newParticipant.setPerks(newPerks);
            newParticipants.add(newParticipant);
        }

        newInfo.setParticipants(newParticipants);
        match.setInfo(newInfo);

        matchRepository.save(match);
    }
}
