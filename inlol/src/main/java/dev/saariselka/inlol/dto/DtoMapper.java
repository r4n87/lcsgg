package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.vo.ChampionVO;
import dev.saariselka.inlol.vo.MatchBanVO;
import dev.saariselka.inlol.vo.SummonerSpellVO;
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
}
