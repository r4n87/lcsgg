package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.entity.MatchParticipantId;
import dev.saariselka.inlol.vo.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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

    public List<ParticipantDto> toParticipantDtoList(List<MatchParticipantVO> matchParticipantVOList) {
        List<ParticipantDto> participantDtoList = new ArrayList<>();
        for(MatchParticipantVO matchParticipantVO : matchParticipantVOList) {
            ParticipantDto participantDto = new ParticipantDto(
                    new MatchParticipantEntity(
                            new MatchParticipantId(matchParticipantVO.getPuuid(),
                                    matchParticipantVO.getDataVersion(),
                                    matchParticipantVO.getMatchId(),
                                    matchParticipantVO.getParticipantId()),
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
                    )
            );
            participantDtoList.add(participantDto);
        }

        return participantDtoList;
    }

}
