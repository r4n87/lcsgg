package dev.saariselka.inlol.service;

import java.sql.Timestamp;
import java.util.List;

import dev.saariselka.inlol.entity.*;
import dev.saariselka.inlol.vo.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
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
        Optional<DdragonVersionVO> ddragonVersionVO = Optional.of(new DdragonVersionVO(ddragonVersionEntity.get().getId(), ddragonVersionEntity.get().getVersion(), ddragonVersionEntity.get().getCurrent()));

        return ddragonVersionVO;
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
}
