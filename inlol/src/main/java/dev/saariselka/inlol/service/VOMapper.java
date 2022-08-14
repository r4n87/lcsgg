package dev.saariselka.inlol.service;

import java.sql.Timestamp;
import java.util.List;

import dev.saariselka.inlol.entity.*;
import dev.saariselka.inlol.vo.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@Component
public class VOMapper {

    public List<QueueTypeVO> toQueueTypeVOList(List<QueueTypeEntity> entityList)
    {
        List<QueueTypeVO> voList = new ArrayList<>();

        for(QueueTypeEntity entity : entityList)
        {
            QueueTypeVO vo = new QueueTypeVO();
            vo.setQueueId(entity.getQueueId());
            vo.setMap(entity.getMap());
            vo.setDescription(entity.getDescription());
            voList.add(vo);
        }

        return voList;
    }

    public List<ChampionEntity> toChampionEntityList(List<ChampionVO> voList)
    {
        List<ChampionEntity> entityList = new ArrayList<>();
        for(ChampionVO vo : voList)
        {
            ChampionEntity entity = new ChampionEntity();
            entity.setId(vo.getId());
            entity.setImagePath(vo.getImagePath());
            entity.setNameEng(vo.getNameEng());
            entity.setNameKo(vo.getNameKo());
            entityList.add(entity);
        }
        return entityList;
    }

    public List<SummonerSpellVO> toSummonerSpellVOList(List<SummonerSpellEntity> summonerSpellEntities) {
        List<SummonerSpellVO> summonerSpellVOList = new ArrayList<>();
        for(SummonerSpellEntity summonerSpellEntity : summonerSpellEntities) {
            SummonerSpellVO summonerSpellVO = new SummonerSpellVO(summonerSpellEntity.getName(), summonerSpellEntity.getDescription(), summonerSpellEntity.getSpellKey(), summonerSpellEntity.getImage());
            summonerSpellVOList.add(summonerSpellVO);
        }
        return  summonerSpellVOList;
    }

    public List<SummonerSpellEntity> toSummonerSpellEntityList(List<SummonerSpellVO> summonerSpellVOList) {
        List<SummonerSpellEntity> summonerSpellEntities = new ArrayList<>();
        for(SummonerSpellVO summonerSpellVO : summonerSpellVOList) {
            SummonerSpellEntity summonerSpellEntity = new SummonerSpellEntity(summonerSpellVO.getName(), summonerSpellVO.getDescription(), summonerSpellVO.getSpellKey(), summonerSpellVO.getImage());
            summonerSpellEntities.add(summonerSpellEntity);
        }
        return  summonerSpellEntities;
    }

    public List<MatchBanVO> toMatchBanVOList(List<MatchBanEntity> matchBanEntityList) {
        List<MatchBanVO> matchBanVOList = new ArrayList<>();
        for(MatchBanEntity matchBanEntity : matchBanEntityList) {
            MatchBanVO matchBanVO = new MatchBanVO(matchBanEntity.getMatchBanId().getMatchId(),matchBanEntity.getMatchBanId().getPickTurn(),matchBanEntity.getMatchBanId().getTeamId(),matchBanEntity.getChampionId());
            matchBanVOList.add(matchBanVO);
        }
        return  matchBanVOList;
    }

    public List<MatchBanEntity> toMatchBanEntityList(List<MatchBanVO> matchBanVOList) {
        List<MatchBanEntity> matchBanEntityList = new ArrayList<>();
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        for(MatchBanVO matchBanVO : matchBanVOList) {
            MatchBanEntity matchBanEntity = new MatchBanEntity(new MatchBanId(matchBanVO.getMatchId(),matchBanVO.getPickTurn(),matchBanVO.getTeamId()),matchBanVO.getChampionId(),rrt);
            matchBanEntityList.add(matchBanEntity);
        }
        return  matchBanEntityList;
    }

    public List<DdragonVersionVO> toDdragonVersionVOList(List<DdragonVersionEntity> ddragonVersionEntityList) {
        List<DdragonVersionVO> ddragonVersionVOList = new ArrayList<>();
        for(DdragonVersionEntity ddragonVersionEntity : ddragonVersionEntityList) {
            DdragonVersionVO ddragonVersionVO = new DdragonVersionVO(ddragonVersionEntity.getId(), ddragonVersionEntity.getVersion(), ddragonVersionEntity.getCurrent());
            ddragonVersionVOList.add(ddragonVersionVO);
        }

        return ddragonVersionVOList;
    }

    public Optional<DdragonVersionVO> toDdragonVersionVO(Optional<DdragonVersionEntity> ddragonVersionEntity) {
        return Optional.of(new DdragonVersionVO(ddragonVersionEntity.get().getId(), ddragonVersionEntity.get().getVersion(), ddragonVersionEntity.get().getCurrent()));
    }

    public List<MatchParticipantVO> toMatchParticipantVOList(List<MatchParticipantEntity> matchParticipantEntityList) {
        List<MatchParticipantVO> matchParticipantVOList = new ArrayList<>();
        for(MatchParticipantEntity matchParticipantEntity : matchParticipantEntityList) {
            MatchParticipantVO matchParticipantVO = new MatchParticipantVO(
                    matchParticipantEntity.getMatchParticipantId().getPuuid(),
                    matchParticipantEntity.getMatchParticipantId().getDataVersion(),
                    matchParticipantEntity.getMatchParticipantId().getMatchId(),
                    matchParticipantEntity.getMatchParticipantId().getParticipantId(),
                    matchParticipantEntity.getAssists(),
                    matchParticipantEntity.getBaronKills(),
                    matchParticipantEntity.getBountyLevel(),
                    matchParticipantEntity.getChampExperience(),
                    matchParticipantEntity.getChampLevel(),
                    matchParticipantEntity.getChampionId(),
                    matchParticipantEntity.getChampionName(),
                    matchParticipantEntity.getChampionNameKR(),
                    matchParticipantEntity.getChampionImg(),
                    matchParticipantEntity.getChampionTransform(),
                    matchParticipantEntity.getConsumablesPurchased(),
                    matchParticipantEntity.getDamageDealtToBuildings(),
                    matchParticipantEntity.getDamageDealtToObjectives(),
                    matchParticipantEntity.getDamageDealtToTurrets(),
                    matchParticipantEntity.getDamageSelfMitigated(),
                    matchParticipantEntity.getDeaths(),
                    matchParticipantEntity.getDetectorWardsPlaced(),
                    matchParticipantEntity.getDoubleKills(),
                    matchParticipantEntity.getDragonKills(),
                    matchParticipantEntity.isFirstBloodAssist(),
                    matchParticipantEntity.isFirstBloodKill(),
                    matchParticipantEntity.isFirstTowerAssist(),
                    matchParticipantEntity.isFirstTowerKill(),
                    matchParticipantEntity.isGameEndedInEarlySurrender(),
                    matchParticipantEntity.isGameEndedInSurrender(),
                    matchParticipantEntity.getGoldEarned(),
                    matchParticipantEntity.getGoldSpent(),
                    matchParticipantEntity.getIndividualPosition(),
                    matchParticipantEntity.getInhibitorKills(),
                    matchParticipantEntity.getInhibitorTakedowns(),
                    matchParticipantEntity.getInhibitorsLost(),
                    matchParticipantEntity.getItem0(),
                    matchParticipantEntity.getItem1(),
                    matchParticipantEntity.getItem2(),
                    matchParticipantEntity.getItem3(),
                    matchParticipantEntity.getItem4(),
                    matchParticipantEntity.getItem5(),
                    matchParticipantEntity.getItem6(),
                    matchParticipantEntity.getItemsPurchased(),
                    matchParticipantEntity.getKillingSprees(),
                    matchParticipantEntity.getKills(),
                    matchParticipantEntity.getLane(),
                    matchParticipantEntity.getLargestCriticalStrike(),
                    matchParticipantEntity.getLargestKillingSpree(),
                    matchParticipantEntity.getLargestMultiKill(),
                    matchParticipantEntity.getLongestTimeSpentLiving(),
                    matchParticipantEntity.getMagicDamageDealt(),
                    matchParticipantEntity.getMagicDamageDealtToChampions(),
                    matchParticipantEntity.getMagicDamageTaken(),
                    matchParticipantEntity.getNeutralMinionsKilled(),
                    matchParticipantEntity.getNexusKills(),
                    matchParticipantEntity.getNexusTakedowns(),
                    matchParticipantEntity.getNexusLost(),
                    matchParticipantEntity.getObjectivesStolen(),
                    matchParticipantEntity.getObjectivesStolenAssists(),
                    matchParticipantEntity.getPentaKills(),
                    matchParticipantEntity.getPhysicalDamageDealt(),
                    matchParticipantEntity.getPhysicalDamageDealtToChampions(),
                    matchParticipantEntity.getPhysicalDamageTaken(),
                    matchParticipantEntity.getProfileIcon(),
                    matchParticipantEntity.getQuadraKills(),
                    matchParticipantEntity.getRiotIdName(),
                    matchParticipantEntity.getRiotIdTagline(),
                    matchParticipantEntity.getRole(),
                    matchParticipantEntity.getSightWardsBoughtInGame(),
                    matchParticipantEntity.getSpell1Casts(),
                    matchParticipantEntity.getSpell2Casts(),
                    matchParticipantEntity.getSpell3Casts(),
                    matchParticipantEntity.getSpell4Casts(),
                    matchParticipantEntity.getSummoner1Casts(),
                    matchParticipantEntity.getSummoner1Id(),
                    matchParticipantEntity.getSummoner2Casts(),
                    matchParticipantEntity.getSummoner2Id(),
                    matchParticipantEntity.getSummonerId(),
                    matchParticipantEntity.getSummonerLevel(),
                    matchParticipantEntity.getSummonerName(),
                    matchParticipantEntity.isTeamEarlySurrendered(),
                    matchParticipantEntity.getTeamId(),
                    matchParticipantEntity.getTeamPosition(),
                    matchParticipantEntity.getTimeCCingOthers(),
                    matchParticipantEntity.getTimePlayed(),
                    matchParticipantEntity.getTotalDamageDealt(),
                    matchParticipantEntity.getTotalDamageDealtToChampions(),
                    matchParticipantEntity.getTotalDamageShieldedOnTeammates(),
                    matchParticipantEntity.getTotalDamageTaken(),
                    matchParticipantEntity.getTotalHeal(),
                    matchParticipantEntity.getTotalHealsOnTeammates(),
                    matchParticipantEntity.getTotalMinionsKilled(),
                    matchParticipantEntity.getTotalTimeCCDealt(),
                    matchParticipantEntity.getTotalTimeSpentDead(),
                    matchParticipantEntity.getTotalUnitsHealed(),
                    matchParticipantEntity.getTripleKills(),
                    matchParticipantEntity.getTrueDamageDealt(),
                    matchParticipantEntity.getTrueDamageDealtToChampions(),
                    matchParticipantEntity.getTrueDamageTaken(),
                    matchParticipantEntity.getTurretKills(),
                    matchParticipantEntity.getTurretTakedowns(),
                    matchParticipantEntity.getTurretsLost(),
                    matchParticipantEntity.getUnrealKills(),
                    matchParticipantEntity.getVisionScore(),
                    matchParticipantEntity.getVisionWardsBoughtInGame(),
                    matchParticipantEntity.getWardsKilled(),
                    matchParticipantEntity.getWardsPlaced(),
                    matchParticipantEntity.isWin(),
                    matchParticipantEntity.getRrt()
            );
            matchParticipantVOList.add(matchParticipantVO);
        }

        return matchParticipantVOList;
    }

    public MatchParticipantEntity toMatchParticipantEntity(MatchParticipantVO matchParticipantVO) {
        return new MatchParticipantEntity(
                new MatchParticipantId(
                        matchParticipantVO.getPuuid(),
                        matchParticipantVO.getDataVersion(),
                        matchParticipantVO.getMatchId(),
                        matchParticipantVO.getParticipantId()
                ),
                matchParticipantVO.getAssists(),
                matchParticipantVO.getBaronKills(),
                matchParticipantVO.getBountyLevel(),
                matchParticipantVO.getChampExperience(),
                matchParticipantVO.getChampLevel(),
                matchParticipantVO.getChampionId(),
                matchParticipantVO.getChampionName(),
                matchParticipantVO.getChampionNameKR(),
                matchParticipantVO.getChampionImg(),
                matchParticipantVO.getChampionTransform(),
                matchParticipantVO.getConsumablesPurchased(),
                matchParticipantVO.getDamageDealtToBuildings(),
                matchParticipantVO.getDamageDealtToObjectives(),
                matchParticipantVO.getDamageDealtToTurrets(),
                matchParticipantVO.getDamageSelfMitigated(),
                matchParticipantVO.getDeaths(),
                matchParticipantVO.getDetectorWardsPlaced(),
                matchParticipantVO.getDoubleKills(),
                matchParticipantVO.getDragonKills(),
                matchParticipantVO.isFirstBloodAssist(),
                matchParticipantVO.isFirstBloodKill(),
                matchParticipantVO.isFirstTowerAssist(),
                matchParticipantVO.isFirstTowerKill(),
                matchParticipantVO.isGameEndedInEarlySurrender(),
                matchParticipantVO.isGameEndedInSurrender(),
                matchParticipantVO.getGoldEarned(),
                matchParticipantVO.getGoldSpent(),
                matchParticipantVO.getIndividualPosition(),
                matchParticipantVO.getInhibitorKills(),
                matchParticipantVO.getInhibitorTakedowns(),
                matchParticipantVO.getInhibitorsLost(),
                matchParticipantVO.getItem0(),
                matchParticipantVO.getItem1(),
                matchParticipantVO.getItem2(),
                matchParticipantVO.getItem3(),
                matchParticipantVO.getItem4(),
                matchParticipantVO.getItem5(),
                matchParticipantVO.getItem6(),
                matchParticipantVO.getItemsPurchased(),
                matchParticipantVO.getKillingSprees(),
                matchParticipantVO.getKills(),
                matchParticipantVO.getLane(),
                matchParticipantVO.getLargestCriticalStrike(),
                matchParticipantVO.getLargestKillingSpree(),
                matchParticipantVO.getLargestMultiKill(),
                matchParticipantVO.getLongestTimeSpentLiving(),
                matchParticipantVO.getMagicDamageDealt(),
                matchParticipantVO.getMagicDamageDealtToChampions(),
                matchParticipantVO.getMagicDamageTaken(),
                matchParticipantVO.getNeutralMinionsKilled(),
                matchParticipantVO.getNexusKills(),
                matchParticipantVO.getNexusTakedowns(),
                matchParticipantVO.getNexusLost(),
                matchParticipantVO.getObjectivesStolen(),
                matchParticipantVO.getObjectivesStolenAssists(),
                matchParticipantVO.getPentaKills(),
                matchParticipantVO.getPhysicalDamageDealt(),
                matchParticipantVO.getPhysicalDamageDealtToChampions(),
                matchParticipantVO.getPhysicalDamageTaken(),
                matchParticipantVO.getProfileIcon(),
                matchParticipantVO.getQuadraKills(),
                matchParticipantVO.getRiotIdName(),
                matchParticipantVO.getRiotIdTagline(),
                matchParticipantVO.getRole(),
                matchParticipantVO.getSightWardsBoughtInGame(),
                matchParticipantVO.getSpell1Casts(),
                matchParticipantVO.getSpell2Casts(),
                matchParticipantVO.getSpell3Casts(),
                matchParticipantVO.getSpell4Casts(),
                matchParticipantVO.getSummoner1Casts(),
                matchParticipantVO.getSummoner1Id(),
                matchParticipantVO.getSummoner2Casts(),
                matchParticipantVO.getSummoner2Id(),
                matchParticipantVO.getSummonerId(),
                matchParticipantVO.getSummonerLevel(),
                matchParticipantVO.getSummonerName(),
                matchParticipantVO.isTeamEarlySurrendered(),
                matchParticipantVO.getTeamId(),
                matchParticipantVO.getTeamPosition(),
                matchParticipantVO.getTimeCCingOthers(),
                matchParticipantVO.getTimePlayed(),
                matchParticipantVO.getTotalDamageDealt(),
                matchParticipantVO.getTotalDamageDealtToChampions(),
                matchParticipantVO.getTotalDamageShieldedOnTeammates(),
                matchParticipantVO.getTotalDamageTaken(),
                matchParticipantVO.getTotalHeal(),
                matchParticipantVO.getTotalHealsOnTeammates(),
                matchParticipantVO.getTotalMinionsKilled(),
                matchParticipantVO.getTotalTimeCCDealt(),
                matchParticipantVO.getTotalTimeSpentDead(),
                matchParticipantVO.getTotalUnitsHealed(),
                matchParticipantVO.getTripleKills(),
                matchParticipantVO.getTrueDamageDealt(),
                matchParticipantVO.getTrueDamageDealtToChampions(),
                matchParticipantVO.getTrueDamageTaken(),
                matchParticipantVO.getTurretKills(),
                matchParticipantVO.getTurretTakedowns(),
                matchParticipantVO.getTurretsLost(),
                matchParticipantVO.getUnrealKills(),
                matchParticipantVO.getVisionScore(),
                matchParticipantVO.getVisionWardsBoughtInGame(),
                matchParticipantVO.getWardsKilled(),
                matchParticipantVO.getWardsPlaced(),
                matchParticipantVO.isWin(),
                matchParticipantVO.getRrt()
        );
    }

    public LeagueMiniSeriesVO toLeagueMiniseriesVO(LeagueMiniSeriesEntity leagueMiniSeriesEntity) {
        if(leagueMiniSeriesEntity == null) {
            return null;
        }
        else {
            return new LeagueMiniSeriesVO(leagueMiniSeriesEntity.getLeagueMiniSeriesId().getSummonerId(),leagueMiniSeriesEntity.getLeagueMiniSeriesId().getQueueType(),
                    leagueMiniSeriesEntity.getLosses(),leagueMiniSeriesEntity.getProgress(), leagueMiniSeriesEntity.getTarget(), leagueMiniSeriesEntity.getWins());
        }
    }

    public List<MatchObjectivesVO> toMatchObjectivesVOList(List<MatchObjectivesEntity> entityList)
    {
        List<MatchObjectivesVO> voList = new ArrayList<>();

        for(MatchObjectivesEntity entity : entityList)
        {
            MatchObjectivesVO vo = new MatchObjectivesVO(
                    new MatchObjectiveVO(entity.isBaron_first(), entity.getBaron_kills()),
                    new MatchObjectiveVO(entity.isChampion_first(), entity.getChampion_kills()),
                    new MatchObjectiveVO(entity.isDragon_first(), entity.getDragon_kills()),
                    new MatchObjectiveVO(entity.isInhibitor_first(), entity.getInhibitor_kills()),
                    new MatchObjectiveVO(entity.isRiftherald_first(), entity.getRiftherald_kills()),
                    new MatchObjectiveVO(entity.isTower_first(), entity.getTower_kills())
            );
            voList.add(vo);
        }

        return voList;
    }

    public List<TeamVO> toTeamVOList(List<TeamEntity> entityList)
    {
        List<TeamVO> voList = new ArrayList<>();

        for(TeamEntity entity : entityList)
        {
            TeamVO vo = new TeamVO();
            vo.setTeamId(String.valueOf(entity.getTeamId().getTeamId()));
            vo.setWin(String.valueOf(entity.isWin()));

            voList.add(vo);
        }

        return voList;
    }

    public List<LeagueEntryVO> toLeagueEntryVOList(List<LeagueEntryEntity> leagueEntryEntityList) {
        List<LeagueEntryVO> leagueEntryVOList = new ArrayList<>();

        for(LeagueEntryEntity leagueEntryEntity  : leagueEntryEntityList) {
            LeagueEntryVO leagueEntryVO = new LeagueEntryVO(leagueEntryEntity.getLeagueEntryId().getSummonerId(),leagueEntryEntity.getLeagueEntryId().getQueueType(),
                    leagueEntryEntity.getLeagueId(),leagueEntryEntity.getSummonerName(),leagueEntryEntity.getTier(),leagueEntryEntity.getRanks(),leagueEntryEntity.getLeaguePoints(),
                    leagueEntryEntity.getWins(),leagueEntryEntity.getLosses(), leagueEntryEntity.isHotStreak(),leagueEntryEntity.isVeteran(),leagueEntryEntity.isFreshBlood(),leagueEntryEntity.isInactive());

            leagueEntryVOList.add(leagueEntryVO);
        }

        return leagueEntryVOList;
    }

    public List<SummonerPerkVO> toSummonerPerkVOList(List<SummonerPerkEntity> summonerPerkEntityList) {
        List<SummonerPerkVO> summonerPerkVOList = new ArrayList<>();

        for(SummonerPerkEntity summonerPerkEntity : summonerPerkEntityList) {
            SummonerPerkVO summonerPerkVO =
                    new SummonerPerkVO(
                            summonerPerkEntity.getPerkId()
                            , summonerPerkEntity.getNameEng()
                            , summonerPerkEntity.getNameKor()
                            , summonerPerkEntity.getIcon()
                            , summonerPerkEntity.getDescription());
            summonerPerkVOList.add(summonerPerkVO);
        }

        return summonerPerkVOList;
    }

    public List<SummonerPerkEntity> toSummonerPerkEntityList(List<SummonerPerkVO> summonerPerkVOList) {
        List<SummonerPerkEntity> summonerPerkEntityList = new ArrayList<>();

        for(SummonerPerkVO summonerPerkVO : summonerPerkVOList) {
            SummonerPerkEntity summonerPerkEntity =
                    new SummonerPerkEntity(
                            summonerPerkVO.getPerkId()
                            , summonerPerkVO.getNameEng()
                            , summonerPerkVO.getNameKor()
                            , summonerPerkVO.getIcon()
                            , summonerPerkVO.getDescription());
            summonerPerkEntityList.add(summonerPerkEntity);
        }

        return summonerPerkEntityList;
    }

    public List<MatchPerksVO> toMatchPerksVOList(List<MatchPerksEntity> matchPerksEntityList) {
        List<MatchPerksVO> matchPerksVOList = new ArrayList<>();

        for(MatchPerksEntity matchPerksEntity : matchPerksEntityList) {
            MatchPerksVO matchPerksVO =
                    new MatchPerksVO(
                            matchPerksEntity.getMatchPerksId().getMatchId()
                            , matchPerksEntity.getMatchPerksId().getPuuid()
                            , matchPerksEntity.getPrimaryStyle()
                            , matchPerksEntity.getPrimaryPerk1()
                            , matchPerksEntity.getPrimaryPerk2()
                            , matchPerksEntity.getPrimaryPerk3()
                            , matchPerksEntity.getPrimaryPerk4()
                            , matchPerksEntity.getSubStyle()
                            , matchPerksEntity.getSubPerk1()
                            , matchPerksEntity.getSubPerk2()
                            , matchPerksEntity.getStatPerkDefense()
                            , matchPerksEntity.getStatPerkFlex()
                            , matchPerksEntity.getStatPerkOffense()
                            , matchPerksEntity.getRrt()
                    );

            matchPerksVOList.add(matchPerksVO);
        }

        return matchPerksVOList;
    }
}
