package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.*;
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

    public List<ParticipantDto> toParticipantDtoList(List<MatchParticipantVO> matchParticipantVOList) {
        List<ParticipantDto> participantDtoList = new ArrayList<>();

        if(matchParticipantVOList == null)
            return participantDtoList;

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


    public List<TeamDto> toTeamDtoList(List<TeamVO> voList)
    {
        List<TeamDto> dtoList = new ArrayList<>();

        for(TeamVO vo : voList)
        {
            TeamDto dto = new TeamDto(
                    toMatchBanDtoList(vo.getBans()),
                    toMatchObjectivesDto(vo.getObjectives()),
                    vo.getTeamId(),
                    vo.getWin(),
                    vo.getTeamKills(),
                    toParticipantDtoList(vo.getParticipants())
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
}
