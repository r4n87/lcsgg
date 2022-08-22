package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.*;
import dev.saariselka.inlol.vo.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Component
public class DtoMapper {

    public List<ChampionVO> toChampionVOList(List<ChampionDto> dtoList) {
        List<ChampionVO> voList = new ArrayList<>();
        for(ChampionDto dto : dtoList) {
            ChampionVO vo = new ChampionVO();
            vo.setId(dto.getId());
            vo.setImagePath(dto.getImagePath());
            vo.setNameEng(dto.getNameEng());
            vo.setNameKo(dto.getNameKo());
            voList.add(vo);
        }
        return voList;
    }

    public List<SummonerSpellVO> toSummonerSpellVOList(List<SummonerSpellDto> summonerSpellDtoList) {
        List<SummonerSpellVO> summonerSpellVOList = new ArrayList<>();

        for(SummonerSpellDto summonerSpell : summonerSpellDtoList) {
            SummonerSpellVO summonerSpellVO = new SummonerSpellVO(summonerSpell.getName(),summonerSpell.getDescription(),summonerSpell.getSpellKey(),summonerSpell.getImage());
            summonerSpellVOList.add(summonerSpellVO);
        }

        return summonerSpellVOList;
    }

    public List<SummonerSpellDto> toSummonerSpellDtoList(List<SummonerSpellVO> summonerSpellVOList) {
        List<SummonerSpellDto> summonerSpellDtoList = new ArrayList<>();

        for(SummonerSpellVO summonerSpell : summonerSpellVOList) {
            SummonerSpellDto summonerSpellDto = new SummonerSpellDto(summonerSpell.getName(),summonerSpell.getDescription(),summonerSpell.getSpellKey(),summonerSpell.getImage());
            summonerSpellDtoList.add(summonerSpellDto);
        }

        return summonerSpellDtoList;
    }

    public List<MatchBanDto> toMatchBanDtoList(List<MatchBanVO> matchBanVOList) {
        List<MatchBanDto> matchBanDtoList = new ArrayList<>();

        if(matchBanVOList == null)
            return matchBanDtoList;

        for(MatchBanVO matchBanVO : matchBanVOList) {
            MatchBanDto matchBanDto = new MatchBanDto(matchBanVO.getMatchId(),matchBanVO.getPickTurn(),matchBanVO.getTeamId(),matchBanVO.getChampionId());
            matchBanDtoList.add(matchBanDto);
        }

        return matchBanDtoList;
    }

    public List<MatchBanVO> toMatchBanVOList(List<MatchBanDto> matchBanDtoList) {
        List<MatchBanVO> matchBanVOList = new ArrayList<>();

        for(MatchBanDto matchBanDto : matchBanDtoList) {
            MatchBanVO matchBanVO = new MatchBanVO(matchBanDto.getMatchId(),matchBanDto.getPickTurn(),matchBanDto.getTeamId(),matchBanDto.getChampionId());
            matchBanVOList.add(matchBanVO);
        }

        return matchBanVOList;
    }

    public List<DdragonVersionDto> toDdragonVersionDtoList(List<DdragonVersionVO> ddragonVersionVOList) {
        List<DdragonVersionDto> ddragonVersionDtoList = new ArrayList<>();

        for(DdragonVersionVO ddragonVersionVO : ddragonVersionVOList) {
            DdragonVersionDto ddragonVersionDto = new DdragonVersionDto(
                    ddragonVersionVO.getId()
                    , ddragonVersionVO.getVersion()
                    , ddragonVersionVO.getCurrent());
            ddragonVersionDtoList.add(ddragonVersionDto);
        }

        return ddragonVersionDtoList;
    }

    public MatchParticipantVO toMatchParticipantVO(MatchParticipantDto matchParticipantDto) {
        return new MatchParticipantVO(
                matchParticipantDto.getPuuid()
                , matchParticipantDto.getDataVersion()
                , matchParticipantDto.getMatchId()
                , Integer.parseInt(matchParticipantDto.getParticipantId())
                , Integer.parseInt(matchParticipantDto.getAssists())
                , Integer.parseInt(matchParticipantDto.getBaronKills())
                , Integer.parseInt(matchParticipantDto.getBountyLevel())
                , Integer.parseInt(matchParticipantDto.getChampExperience())
                , Integer.parseInt(matchParticipantDto.getChampLevel())
                , Integer.parseInt(matchParticipantDto.getChampionId())
                , matchParticipantDto.getChampionName()
                , matchParticipantDto.getChampionNameKR()
                , matchParticipantDto.getChampionImg()
                , Integer.parseInt(matchParticipantDto.getChampionTransform())
                , Integer.parseInt(matchParticipantDto.getConsumablesPurchased())
                , Integer.parseInt(matchParticipantDto.getDamageDealtToBuildings())
                , Integer.parseInt(matchParticipantDto.getDamageDealtToObjectives())
                , Integer.parseInt(matchParticipantDto.getDamageDealtToTurrets())
                , Integer.parseInt(matchParticipantDto.getDamageSelfMitigated())
                , Integer.parseInt(matchParticipantDto.getDeaths())
                , Integer.parseInt(matchParticipantDto.getDetectorWardsPlaced())
                , Integer.parseInt(matchParticipantDto.getDoubleKills())
                , Integer.parseInt(matchParticipantDto.getDragonKills())
                , Boolean.parseBoolean(matchParticipantDto.getFirstBloodAssist())
                , Boolean.parseBoolean(matchParticipantDto.getFirstBloodKill())
                , Boolean.parseBoolean(matchParticipantDto.getFirstTowerAssist())
                , Boolean.parseBoolean(matchParticipantDto.getFirstTowerKill())
                , Boolean.parseBoolean(matchParticipantDto.getGameEndedInEarlySurrender())
                , Boolean.parseBoolean(matchParticipantDto.getGameEndedInSurrender())
                , Integer.parseInt(matchParticipantDto.getGoldEarned())
                , Integer.parseInt(matchParticipantDto.getGoldSpent())
                , matchParticipantDto.getIndividualPosition()
                , Integer.parseInt(matchParticipantDto.getInhibitorKills())
                , Integer.parseInt(matchParticipantDto.getInhibitorTakedowns())
                , Integer.parseInt(matchParticipantDto.getInhibitorsLost())
                , Integer.parseInt(matchParticipantDto.getItem0())
                , Integer.parseInt(matchParticipantDto.getItem1())
                , Integer.parseInt(matchParticipantDto.getItem2())
                , Integer.parseInt(matchParticipantDto.getItem3())
                , Integer.parseInt(matchParticipantDto.getItem4())
                , Integer.parseInt(matchParticipantDto.getItem5())
                , Integer.parseInt(matchParticipantDto.getItem6())
                , Integer.parseInt(matchParticipantDto.getItemsPurchased())
                , Integer.parseInt(matchParticipantDto.getKillingSprees())
                , Integer.parseInt(matchParticipantDto.getKills())
                , matchParticipantDto.getLane()
                , Integer.parseInt(matchParticipantDto.getLargestCriticalStrike())
                , Integer.parseInt(matchParticipantDto.getLargestKillingSpree())
                , Integer.parseInt(matchParticipantDto.getLargestMultiKill())
                , Integer.parseInt(matchParticipantDto.getLongestTimeSpentLiving())
                , Integer.parseInt(matchParticipantDto.getMagicDamageDealt())
                , Integer.parseInt(matchParticipantDto.getMagicDamageDealtToChampions())
                , Integer.parseInt(matchParticipantDto.getMagicDamageTaken())
                , Integer.parseInt(matchParticipantDto.getNeutralMinionsKilled())
                , Integer.parseInt(matchParticipantDto.getNexusKills())
                , Integer.parseInt(matchParticipantDto.getNexusTakedowns())
                , Integer.parseInt(matchParticipantDto.getNexusLost())
                , Integer.parseInt(matchParticipantDto.getObjectivesStolen())
                , Integer.parseInt(matchParticipantDto.getObjectivesStolenAssists())
                , Integer.parseInt(matchParticipantDto.getPentaKills())
                , Integer.parseInt(matchParticipantDto.getPhysicalDamageDealt())
                , Integer.parseInt(matchParticipantDto.getPhysicalDamageDealtToChampions())
                , Integer.parseInt(matchParticipantDto.getPhysicalDamageTaken())
                , Integer.parseInt(matchParticipantDto.getProfileIcon())
                , Integer.parseInt(matchParticipantDto.getQuadraKills())
                , matchParticipantDto.getRiotIdName()
                , matchParticipantDto.getRiotIdTagline()
                , matchParticipantDto.getRole()
                , Integer.parseInt(matchParticipantDto.getSightWardsBoughtInGame())
                , Integer.parseInt(matchParticipantDto.getSpell1Casts())
                , Integer.parseInt(matchParticipantDto.getSpell2Casts())
                , Integer.parseInt(matchParticipantDto.getSpell3Casts())
                , Integer.parseInt(matchParticipantDto.getSpell4Casts())
                , Integer.parseInt(matchParticipantDto.getSummoner1Casts())
                , matchParticipantDto.getSummoner1Id()
                , Integer.parseInt(matchParticipantDto.getSummoner2Casts())
                , matchParticipantDto.getSummoner2Id()
                , matchParticipantDto.getSummonerId()
                , Integer.parseInt(matchParticipantDto.getSummonerLevel())
                , matchParticipantDto.getSummonerName()
                , Boolean.parseBoolean(matchParticipantDto.getTeamEarlySurrendered())
                , Integer.parseInt(matchParticipantDto.getTeamId())
                , matchParticipantDto.getTeamPosition()
                , Integer.parseInt(matchParticipantDto.getTimeCCingOthers())
                , Integer.parseInt(matchParticipantDto.getTimePlayed())
                , Integer.parseInt(matchParticipantDto.getTotalDamageDealt())
                , Integer.parseInt(matchParticipantDto.getTotalDamageDealtToChampions())
                , Integer.parseInt(matchParticipantDto.getTotalDamageShieldedOnTeammates())
                , Integer.parseInt(matchParticipantDto.getTotalDamageTaken())
                , Integer.parseInt(matchParticipantDto.getTotalHeal())
                , Integer.parseInt(matchParticipantDto.getTotalHealsOnTeammates())
                , Integer.parseInt(matchParticipantDto.getTotalMinionsKilled())
                , Integer.parseInt(matchParticipantDto.getTotalTimeCCDealt())
                , Integer.parseInt(matchParticipantDto.getTotalTimeSpentDead())
                , Integer.parseInt(matchParticipantDto.getTotalUnitsHealed())
                , Integer.parseInt(matchParticipantDto.getTripleKills())
                , Integer.parseInt(matchParticipantDto.getTrueDamageDealt())
                , Integer.parseInt(matchParticipantDto.getTrueDamageDealtToChampions())
                , Integer.parseInt(matchParticipantDto.getTrueDamageTaken())
                , Integer.parseInt(matchParticipantDto.getTurretKills())
                , Integer.parseInt(matchParticipantDto.getTurretTakedowns())
                , Integer.parseInt(matchParticipantDto.getTurretsLost())
                , Integer.parseInt(matchParticipantDto.getUnrealKills())
                , Integer.parseInt(matchParticipantDto.getVisionScore())
                , Integer.parseInt(matchParticipantDto.getVisionWardsBoughtInGame())
                , Integer.parseInt(matchParticipantDto.getWardsKilled())
                , Integer.parseInt(matchParticipantDto.getWardsPlaced())
                , Boolean.parseBoolean(matchParticipantDto.getWin())
                , matchParticipantDto.getRrt()
        );
    }

    public List<MatchParticipantDto> toMatchParticipantDtoListWithGameDuration(
            List<MatchParticipantVO> matchParticipantVOList, long gameDuration
    ) {
        List<MatchParticipantDto> matchParticipantDtoList = new ArrayList<>();

        if(matchParticipantVOList == null)
            return matchParticipantDtoList;

        for(MatchParticipantVO matchParticipantVO : matchParticipantVOList) {
            MatchParticipantDto matchParticipantDto =
                    new MatchParticipantDto(
                            matchParticipantVO.getPuuid()
                            , matchParticipantVO.getDataVersion()
                            , matchParticipantVO.getMatchId()
                            , String.valueOf(matchParticipantVO.getParticipantId())
                            , String.valueOf(matchParticipantVO.getAssists())
                            , String.valueOf(matchParticipantVO.getBaronKills())
                            , String.valueOf(matchParticipantVO.getBountyLevel())
                            , String.valueOf(matchParticipantVO.getChampExperience())
                            , String.valueOf(matchParticipantVO.getChampLevel())
                            , String.valueOf(matchParticipantVO.getChampionId())
                            , matchParticipantVO.getChampionName()
                            , matchParticipantVO.getChampionNameKR()
                            , matchParticipantVO.getChampionImg()
                            , String.valueOf(matchParticipantVO.getChampionTransform())
                            , String.valueOf(matchParticipantVO.getConsumablesPurchased())
                            , String.valueOf(matchParticipantVO.getDamageDealtToBuildings())
                            , String.valueOf(matchParticipantVO.getDamageDealtToObjectives())
                            , String.valueOf(matchParticipantVO.getDamageDealtToTurrets())
                            , String.valueOf(matchParticipantVO.getDamageSelfMitigated())
                            , String.valueOf(matchParticipantVO.getDeaths())
                            , String.valueOf(matchParticipantVO.getDetectorWardsPlaced())
                            , String.valueOf(matchParticipantVO.getDoubleKills())
                            , String.valueOf(matchParticipantVO.getDragonKills())
                            , String.valueOf(matchParticipantVO.isFirstBloodAssist())
                            , String.valueOf(matchParticipantVO.isFirstBloodKill())
                            , String.valueOf(matchParticipantVO.isFirstTowerAssist())
                            , String.valueOf(matchParticipantVO.isFirstTowerKill())
                            , String.valueOf(matchParticipantVO.isGameEndedInEarlySurrender())
                            , String.valueOf(matchParticipantVO.isGameEndedInSurrender())
                            , String.valueOf(matchParticipantVO.getGoldEarned())
                            , String.valueOf(matchParticipantVO.getGoldSpent())
                            , matchParticipantVO.getIndividualPosition()
                            , String.valueOf(matchParticipantVO.getInhibitorKills())
                            , String.valueOf(matchParticipantVO.getInhibitorTakedowns())
                            , String.valueOf(matchParticipantVO.getInhibitorsLost())
                            , String.valueOf(matchParticipantVO.getItem0())
                            , String.valueOf(matchParticipantVO.getItem1())
                            , String.valueOf(matchParticipantVO.getItem2())
                            , String.valueOf(matchParticipantVO.getItem3())
                            , String.valueOf(matchParticipantVO.getItem4())
                            , String.valueOf(matchParticipantVO.getItem5())
                            , String.valueOf(matchParticipantVO.getItem6())
                            , String.valueOf(matchParticipantVO.getItemsPurchased())
                            , String.valueOf(matchParticipantVO.getKillingSprees())
                            , String.valueOf(matchParticipantVO.getKills())
                            , matchParticipantVO.getLane()
                            , String.valueOf(matchParticipantVO.getLargestCriticalStrike())
                            , String.valueOf(matchParticipantVO.getLargestKillingSpree())
                            , String.valueOf(matchParticipantVO.getLargestMultiKill())
                            , String.valueOf(matchParticipantVO.getLongestTimeSpentLiving())
                            , String.valueOf(matchParticipantVO.getMagicDamageDealt())
                            , String.valueOf(matchParticipantVO.getMagicDamageDealtToChampions())
                            , String.valueOf(matchParticipantVO.getMagicDamageTaken())
                            , String.valueOf(matchParticipantVO.getNeutralMinionsKilled())
                            , String.valueOf(matchParticipantVO.getNexusKills())
                            , String.valueOf(matchParticipantVO.getNexusTakedowns())
                            , String.valueOf(matchParticipantVO.getNexusLost())
                            , String.valueOf(matchParticipantVO.getObjectivesStolen())
                            , String.valueOf(matchParticipantVO.getObjectivesStolenAssists())
                            , String.valueOf(matchParticipantVO.getPentaKills())
                            , String.valueOf(matchParticipantVO.getPhysicalDamageDealt())
                            , String.valueOf(matchParticipantVO.getPhysicalDamageDealtToChampions())
                            , String.valueOf(matchParticipantVO.getPhysicalDamageTaken())
                            , String.valueOf(matchParticipantVO.getProfileIcon())
                            , String.valueOf(matchParticipantVO.getQuadraKills())
                            , matchParticipantVO.getRiotIdName()
                            , matchParticipantVO.getRiotIdTagline()
                            , matchParticipantVO.getRole()
                            , String.valueOf(matchParticipantVO.getSightWardsBoughtInGame())
                            , String.valueOf(matchParticipantVO.getSpell1Casts())
                            , String.valueOf(matchParticipantVO.getSpell2Casts())
                            , String.valueOf(matchParticipantVO.getSpell3Casts())
                            , String.valueOf(matchParticipantVO.getSpell4Casts())
                            , String.valueOf(matchParticipantVO.getSummoner1Casts())
                            , matchParticipantVO.getSummoner1Id()
                            , String.valueOf(matchParticipantVO.getSummoner2Casts())
                            , matchParticipantVO.getSummoner2Id()
                            , matchParticipantVO.getSummonerId()
                            , String.valueOf(matchParticipantVO.getSummonerLevel())
                            , getSummonerName(matchParticipantVO.getPuuid(), matchParticipantVO.getSummonerName())
                            , String.valueOf(matchParticipantVO.isTeamEarlySurrendered())
                            , String.valueOf(matchParticipantVO.getTeamId())
                            , matchParticipantVO.getTeamPosition()
                            , String.valueOf(matchParticipantVO.getTimeCCingOthers())
                            , String.valueOf(matchParticipantVO.getTimePlayed())
                            , String.valueOf(matchParticipantVO.getTotalDamageDealt())
                            , String.valueOf(matchParticipantVO.getTotalDamageDealtToChampions())
                            , String.valueOf(matchParticipantVO.getTotalDamageShieldedOnTeammates())
                            , String.valueOf(matchParticipantVO.getTotalDamageTaken())
                            , String.valueOf(matchParticipantVO.getTotalHeal())
                            , String.valueOf(matchParticipantVO.getTotalHealsOnTeammates())
                            , String.valueOf(matchParticipantVO.getTotalMinionsKilled())
                            , String.valueOf(matchParticipantVO.getTotalTimeCCDealt())
                            , String.valueOf(matchParticipantVO.getTotalTimeSpentDead())
                            , String.valueOf(matchParticipantVO.getTotalUnitsHealed())
                            , String.valueOf(matchParticipantVO.getTripleKills())
                            , String.valueOf(matchParticipantVO.getTrueDamageDealt())
                            , String.valueOf(matchParticipantVO.getTrueDamageDealtToChampions())
                            , String.valueOf(matchParticipantVO.getTrueDamageTaken())
                            , String.valueOf(matchParticipantVO.getTurretKills())
                            , String.valueOf(matchParticipantVO.getTurretTakedowns())
                            , String.valueOf(matchParticipantVO.getTurretsLost())
                            , String.valueOf(matchParticipantVO.getUnrealKills())
                            , String.valueOf(matchParticipantVO.getVisionScore())
                            , String.valueOf(matchParticipantVO.getVisionWardsBoughtInGame())
                            , String.valueOf(matchParticipantVO.getWardsKilled())
                            , String.valueOf(matchParticipantVO.getWardsPlaced())
                            , String.valueOf(matchParticipantVO.isWin())
                            , matchParticipantVO.getRrt()
                            , null
                            , getKda(matchParticipantVO.getKills(), matchParticipantVO.getDeaths(), matchParticipantVO.getAssists())
                            , getMinionsKilledPerMin(matchParticipantVO.getTotalMinionsKilled(), gameDuration)
                            , null
                            , getMultiKills(matchParticipantVO.getDoubleKills()
                                    , matchParticipantVO.getTripleKills()
                                    , matchParticipantVO.getQuadraKills()
                                    , matchParticipantVO.getPentaKills())
            );
            matchParticipantDtoList.add(matchParticipantDto);
        }

        return matchParticipantDtoList;
    }

    public List<MatchParticipantDto> toMatchParticipantDtoList(List<MatchParticipantVO> matchParticipantVOList) {
        List<MatchParticipantDto> matchParticipantDtoList = new ArrayList<>();

        if(matchParticipantVOList == null)
            return matchParticipantDtoList;

        for(MatchParticipantVO matchParticipantVO : matchParticipantVOList) {
            MatchParticipantDto matchParticipantDto =
                    new MatchParticipantDto(
                            matchParticipantVO.getPuuid()
                            , matchParticipantVO.getDataVersion()
                            , matchParticipantVO.getMatchId()
                            , String.valueOf(matchParticipantVO.getParticipantId())
                            , String.valueOf(matchParticipantVO.getAssists())
                            , String.valueOf(matchParticipantVO.getBaronKills())
                            , String.valueOf(matchParticipantVO.getBountyLevel())
                            , String.valueOf(matchParticipantVO.getChampExperience())
                            , String.valueOf(matchParticipantVO.getChampLevel())
                            , String.valueOf(matchParticipantVO.getChampionId())
                            , matchParticipantVO.getChampionName()
                            , matchParticipantVO.getChampionNameKR()
                            , matchParticipantVO.getChampionImg()
                            , String.valueOf(matchParticipantVO.getChampionTransform())
                            , String.valueOf(matchParticipantVO.getConsumablesPurchased())
                            , String.valueOf(matchParticipantVO.getDamageDealtToBuildings())
                            , String.valueOf(matchParticipantVO.getDamageDealtToObjectives())
                            , String.valueOf(matchParticipantVO.getDamageDealtToTurrets())
                            , String.valueOf(matchParticipantVO.getDamageSelfMitigated())
                            , String.valueOf(matchParticipantVO.getDeaths())
                            , String.valueOf(matchParticipantVO.getDetectorWardsPlaced())
                            , String.valueOf(matchParticipantVO.getDoubleKills())
                            , String.valueOf(matchParticipantVO.getDragonKills())
                            , String.valueOf(matchParticipantVO.isFirstBloodAssist())
                            , String.valueOf(matchParticipantVO.isFirstBloodKill())
                            , String.valueOf(matchParticipantVO.isFirstTowerAssist())
                            , String.valueOf(matchParticipantVO.isFirstTowerKill())
                            , String.valueOf(matchParticipantVO.isGameEndedInEarlySurrender())
                            , String.valueOf(matchParticipantVO.isGameEndedInSurrender())
                            , String.valueOf(matchParticipantVO.getGoldEarned())
                            , String.valueOf(matchParticipantVO.getGoldSpent())
                            , matchParticipantVO.getIndividualPosition()
                            , String.valueOf(matchParticipantVO.getInhibitorKills())
                            , String.valueOf(matchParticipantVO.getInhibitorTakedowns())
                            , String.valueOf(matchParticipantVO.getInhibitorsLost())
                            , String.valueOf(matchParticipantVO.getItem0())
                            , String.valueOf(matchParticipantVO.getItem1())
                            , String.valueOf(matchParticipantVO.getItem2())
                            , String.valueOf(matchParticipantVO.getItem3())
                            , String.valueOf(matchParticipantVO.getItem4())
                            , String.valueOf(matchParticipantVO.getItem5())
                            , String.valueOf(matchParticipantVO.getItem6())
                            , String.valueOf(matchParticipantVO.getItemsPurchased())
                            , String.valueOf(matchParticipantVO.getKillingSprees())
                            , String.valueOf(matchParticipantVO.getKills())
                            , matchParticipantVO.getLane()
                            , String.valueOf(matchParticipantVO.getLargestCriticalStrike())
                            , String.valueOf(matchParticipantVO.getLargestKillingSpree())
                            , String.valueOf(matchParticipantVO.getLargestMultiKill())
                            , String.valueOf(matchParticipantVO.getLongestTimeSpentLiving())
                            , String.valueOf(matchParticipantVO.getMagicDamageDealt())
                            , String.valueOf(matchParticipantVO.getMagicDamageDealtToChampions())
                            , String.valueOf(matchParticipantVO.getMagicDamageTaken())
                            , String.valueOf(matchParticipantVO.getNeutralMinionsKilled())
                            , String.valueOf(matchParticipantVO.getNexusKills())
                            , String.valueOf(matchParticipantVO.getNexusTakedowns())
                            , String.valueOf(matchParticipantVO.getNexusLost())
                            , String.valueOf(matchParticipantVO.getObjectivesStolen())
                            , String.valueOf(matchParticipantVO.getObjectivesStolenAssists())
                            , String.valueOf(matchParticipantVO.getPentaKills())
                            , String.valueOf(matchParticipantVO.getPhysicalDamageDealt())
                            , String.valueOf(matchParticipantVO.getPhysicalDamageDealtToChampions())
                            , String.valueOf(matchParticipantVO.getPhysicalDamageTaken())
                            , String.valueOf(matchParticipantVO.getProfileIcon())
                            , String.valueOf(matchParticipantVO.getQuadraKills())
                            , matchParticipantVO.getRiotIdName()
                            , matchParticipantVO.getRiotIdTagline()
                            , matchParticipantVO.getRole()
                            , String.valueOf(matchParticipantVO.getSightWardsBoughtInGame())
                            , String.valueOf(matchParticipantVO.getSpell1Casts())
                            , String.valueOf(matchParticipantVO.getSpell2Casts())
                            , String.valueOf(matchParticipantVO.getSpell3Casts())
                            , String.valueOf(matchParticipantVO.getSpell4Casts())
                            , String.valueOf(matchParticipantVO.getSummoner1Casts())
                            , matchParticipantVO.getSummoner1Id()
                            , String.valueOf(matchParticipantVO.getSummoner2Casts())
                            , matchParticipantVO.getSummoner2Id()
                            , matchParticipantVO.getSummonerId()
                            , String.valueOf(matchParticipantVO.getSummonerLevel())
                            , getSummonerName(matchParticipantVO.getPuuid(), matchParticipantVO.getSummonerName())
                            , String.valueOf(matchParticipantVO.isTeamEarlySurrendered())
                            , String.valueOf(matchParticipantVO.getTeamId())
                            , matchParticipantVO.getTeamPosition()
                            , String.valueOf(matchParticipantVO.getTimeCCingOthers())
                            , String.valueOf(matchParticipantVO.getTimePlayed())
                            , String.valueOf(matchParticipantVO.getTotalDamageDealt())
                            , String.valueOf(matchParticipantVO.getTotalDamageDealtToChampions())
                            , String.valueOf(matchParticipantVO.getTotalDamageShieldedOnTeammates())
                            , String.valueOf(matchParticipantVO.getTotalDamageTaken())
                            , String.valueOf(matchParticipantVO.getTotalHeal())
                            , String.valueOf(matchParticipantVO.getTotalHealsOnTeammates())
                            , String.valueOf(matchParticipantVO.getTotalMinionsKilled())
                            , String.valueOf(matchParticipantVO.getTotalTimeCCDealt())
                            , String.valueOf(matchParticipantVO.getTotalTimeSpentDead())
                            , String.valueOf(matchParticipantVO.getTotalUnitsHealed())
                            , String.valueOf(matchParticipantVO.getTripleKills())
                            , String.valueOf(matchParticipantVO.getTrueDamageDealt())
                            , String.valueOf(matchParticipantVO.getTrueDamageDealtToChampions())
                            , String.valueOf(matchParticipantVO.getTrueDamageTaken())
                            , String.valueOf(matchParticipantVO.getTurretKills())
                            , String.valueOf(matchParticipantVO.getTurretTakedowns())
                            , String.valueOf(matchParticipantVO.getTurretsLost())
                            , String.valueOf(matchParticipantVO.getUnrealKills())
                            , String.valueOf(matchParticipantVO.getVisionScore())
                            , String.valueOf(matchParticipantVO.getVisionWardsBoughtInGame())
                            , String.valueOf(matchParticipantVO.getWardsKilled())
                            , String.valueOf(matchParticipantVO.getWardsPlaced())
                            , String.valueOf(matchParticipantVO.isWin())
                            , matchParticipantVO.getRrt()
                            , null
                            , getKda(matchParticipantVO.getKills(), matchParticipantVO.getDeaths(), matchParticipantVO.getAssists())
                            , null
                            , null
                            , getMultiKills(matchParticipantVO.getDoubleKills()
                                , matchParticipantVO.getTripleKills()
                                , matchParticipantVO.getQuadraKills()
                                , matchParticipantVO.getPentaKills())
                    );
            matchParticipantDtoList.add(matchParticipantDto);
        }

        return matchParticipantDtoList;
    }

    private String getSummonerName(String puuid, String summonerName) {
        if("BOT".equals(puuid)) {
            return "(봇)";
        }

        return summonerName;
    }

    private String getKda(int kill, int death, int assist) {
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

    private String getMinionsKilledPerMin(int totalMinionsKilled, long gameDuration) {
        BigDecimal minionsKilledCount = new BigDecimal(totalMinionsKilled);
        BigDecimal gameDurationMin = BigDecimal.valueOf(gameDuration).divide(BigDecimal.valueOf(60), RoundingMode.FLOOR);

        return minionsKilledCount.divide(gameDurationMin, 1, RoundingMode.HALF_UP).toString();
    }

    private String getMultiKills(int doubleKills, int tripleKills, int quadraKills, int pentaKills) {
        if(0 < pentaKills) {
            return "펜타킬";
        } else if (0 < quadraKills) {
            return "쿼드라킬";
        } else if (0 < tripleKills) {
            return "트리플킬";
        } else if (0 < doubleKills) {
            return "더블킬";
        }

        return null;
    }

    public LeagueMiniSeriesDto toLeagueMiniseriesDto(LeagueMiniSeriesVO leagueMiniSeriesVO) {
        if(leagueMiniSeriesVO == null) {
            return new LeagueMiniSeriesDto();
        }
        else {
            return new LeagueMiniSeriesDto(leagueMiniSeriesVO.getSummonerId(),leagueMiniSeriesVO.getQueueType(), leagueMiniSeriesVO.getWins(),
                    leagueMiniSeriesVO.getLosses(), leagueMiniSeriesVO.getTarget(),leagueMiniSeriesVO.getProgress().toCharArray());
        }

    }

    public List<MatchObjectivesDto> toMatchObjectivesDtoList(List<MatchObjectivesVO> voList)
    {
        List<MatchObjectivesDto> dtoList = new ArrayList<>();

        for(MatchObjectivesVO vo : voList) {
            MatchObjectivesDto dto = toMatchObjectivesDto(vo);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public MatchObjectivesDto toMatchObjectivesDto(MatchObjectivesVO vo)
    {
        if(vo == null)
            return new MatchObjectivesDto();

        return new MatchObjectivesDto(
                new MatchObjectiveDto(vo.getBaron().isFirst(), vo.getBaron().getKills()),
                new MatchObjectiveDto(vo.getChampion().isFirst(), vo.getChampion().getKills()),
                new MatchObjectiveDto(vo.getDragon().isFirst(), vo.getDragon().getKills()),
                new MatchObjectiveDto(vo.getInhibitor().isFirst(), vo.getInhibitor().getKills()),
                new MatchObjectiveDto(vo.getRiftHeraId().isFirst(), vo.getRiftHeraId().getKills()),
                new MatchObjectiveDto(vo.getTower().isFirst(), vo.getTower().getKills())
        );
    }


    public List<MatchTeamDto> toMatchTeamDtoList(List<MatchTeamVO> voList)
    {
        List<MatchTeamDto> dtoList = new ArrayList<>();

        for(MatchTeamVO vo : voList)
        {
            MatchTeamDto dto = new MatchTeamDto(
                    toMatchBanDtoList(vo.getBans()),
                    toMatchObjectivesDto(vo.getObjectives()),
                    vo.getTeamId(),
                    vo.getWin(),
                    vo.getTeamKills(),
                    toMatchParticipantDtoList(vo.getParticipants())
            );
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<LeagueEntryDto> toLeagueEntryDtoList(List<LeagueEntryVO> leagueEntryVOList) {
        List<LeagueEntryDto> leagueEntryDtoList = new ArrayList<>();

        for(LeagueEntryVO leagueEntryVO : leagueEntryVOList) {
            LeagueEntryDto leagueEntryDto = new LeagueEntryDto();

            leagueEntryDto.setSummonerId(leagueEntryVO.getSummonerId());
            leagueEntryDto.setQueueType(leagueEntryVO.getQueueType());
            leagueEntryDto.setLeagueId(leagueEntryVO.getLeagueId());
            leagueEntryDto.setSummonerName(leagueEntryVO.getSummonerName());
            leagueEntryDto.setLeaguePoints(leagueEntryVO.getLeaguePoints());
            leagueEntryDto.setTier(leagueEntryVO.getTier());
            if(leagueEntryVO.getTier().equals("MASTER")||leagueEntryVO.getTier().equals("GRANDMASTER")||leagueEntryVO.getTier().equals("CHALLENGER"))
            {
                leagueEntryDto.setRank("");
            }
            else {
                leagueEntryDto.setRank(leagueEntryVO.getRanks());
            }
            leagueEntryDto.setWins(leagueEntryVO.getWins());
            leagueEntryDto.setLosses(leagueEntryVO.getLosses());
            leagueEntryDto.setHotStreak(leagueEntryVO.isHotStreak());
            leagueEntryDto.setVeteran(leagueEntryVO.isVeteran());
            leagueEntryDto.setFreshBlood(leagueEntryVO.isFreshBlood());
            leagueEntryDto.setInactive(leagueEntryVO.isInactive());

            leagueEntryDtoList.add(leagueEntryDto);
        }

        return leagueEntryDtoList;
    }

    public List<SummonerPerkVO> toSummonerPerkVOList(List<SummonerPerkDto> summonerPerkDtoList) {
        List<SummonerPerkVO> summonerPerkVOList = new ArrayList<>();

        for(SummonerPerkDto summonerPerkDto : summonerPerkDtoList) {
            SummonerPerkVO summonerPerkVO =
                    new SummonerPerkVO(
                            summonerPerkDto.getPerkId()
                            , summonerPerkDto.getNameEng()
                            , summonerPerkDto.getNameKor()
                            , summonerPerkDto.getIcon()
                            , summonerPerkDto.getDescription()
                    );

            summonerPerkVOList.add(summonerPerkVO);
        }

        return summonerPerkVOList;
    }

    public List<SummonerPerkDto> toSummonerPerkDtoList(List<SummonerPerkVO> summonerPerkVOList) {
        List<SummonerPerkDto> summonerPerkDtoList = new ArrayList<>();

        for(SummonerPerkVO summonerPerkVO : summonerPerkVOList) {
            SummonerPerkDto summonerPerkDto =
                    new SummonerPerkDto(
                            summonerPerkVO.getPerkId()
                            , summonerPerkVO.getNameEng()
                            , summonerPerkVO.getNameKor()
                            , summonerPerkVO.getIcon()
                            , summonerPerkVO.getDescription()
                    );

            summonerPerkDtoList.add(summonerPerkDto);
        }

        return summonerPerkDtoList;
    }

    public List<MatchPerksDto> toMatchPerksDtoList(List<MatchPerksVO> matchPerksVOList) {
        List<MatchPerksDto> matchPerksDtoList = new ArrayList<>();

        for(MatchPerksVO matchPerksVO : matchPerksVOList) {
            MatchPerksDto matchPerksDto =
                    new MatchPerksDto(
                            matchPerksVO.getMatchId()
                            , matchPerksVO.getPuuid()
                            , matchPerksVO.getPrimaryStyle()
                            , matchPerksVO.getPrimaryPerk1()
                            , matchPerksVO.getPrimaryPerk2()
                            , matchPerksVO.getPrimaryPerk3()
                            , matchPerksVO.getPrimaryPerk4()
                            , matchPerksVO.getSubStyle()
                            , matchPerksVO.getSubPerk1()
                            , matchPerksVO.getSubPerk2()
                            , matchPerksVO.getStatPerkDefense()
                            , matchPerksVO.getStatPerkFlex()
                            , matchPerksVO.getStatPerkOffense()
                    );

            matchPerksDtoList.add(matchPerksDto);
        }

        return matchPerksDtoList;
    }

    public List<MatchMasterDto> toMatchMasterDtoList(List<MatchMasterVO> matchMasterVOList) {
        List<MatchMasterDto> matchMasterDtoList = new ArrayList<>();

        for(MatchMasterVO matchMasterVO : matchMasterVOList) {
            MatchMasterDto matchMasterDto = new MatchMasterDto(matchMasterVO.getDataVersion(), matchMasterVO.getMatchId(),
                    matchMasterVO.getGameCreation(), matchMasterVO.getGameDuration(), matchMasterVO.getGameEndTimeStamp(), matchMasterVO.getGameId(),
                    matchMasterVO.getGameMode(), matchMasterVO.getGameName(), matchMasterVO.getGameStartTimeStamp(), matchMasterVO.getGameType(),
                    matchMasterVO.getGameVersion(), matchMasterVO.getMapId(), matchMasterVO.getPlatformId(), matchMasterVO.getQueueId(), matchMasterVO.getQueueType(),
                    matchMasterVO.getTeamId1(), matchMasterVO.getTeamId2(), matchMasterVO.getTournamentCode());
            matchMasterDtoList.add(matchMasterDto);
        }

        return matchMasterDtoList;
    }

    public List<SummonerDto> toSummonerDtoList(List<SummonerVO> summonerVOList) {
        List<SummonerDto> summonerDtoList = new ArrayList<>();

        for(SummonerVO summonerVO : summonerVOList) {
            SummonerDto summonerDto = new SummonerDto(summonerVO.getPuuid(), summonerVO.getAccountId(),
                    summonerVO.getId(), summonerVO.getName(), summonerVO.getProfileIconId(), summonerVO.getRevisionDate(),
                    summonerVO.getSummonerLevel(), summonerVO.getLastRefreshTimeForUI(), summonerVO.getLastRefreshTimeForAPI());

            summonerDtoList.add(summonerDto);
        }

        return summonerDtoList;
    }
}
