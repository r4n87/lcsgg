package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.MatchBanController;
import dev.saariselka.inlol.entity.MatchBanEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BanDto_Assembly {

    @Autowired
    MatchBanController matchBanController;

    public List<BanDto> getBans_ByMatchId(String matchId){
        List<MatchBanEntity> banList = matchBanController.getBans_ByMatchId(matchId);
        List<BanDto> bansDto = new ArrayList<>();

        for(MatchBanEntity banEntity : banList)
        {
            BanDto banDto = new BanDto();
            banDto.setPickTurn(String.valueOf(banEntity.getMatchBanId().getPickTurn()));
            banDto.setChampionId(String.valueOf(banEntity.getChampionId()));
            bansDto.add(banDto);
        }

        return bansDto;
    }

    public List<BanDto> getBans_ByMatchBanId(String matchId, int pickTurn, int teamId){
        List<MatchBanEntity> banList = matchBanController.getBans_ByMatchBanId(matchId, pickTurn, teamId);
        List<BanDto> bansDto = new ArrayList<>();

        for(MatchBanEntity banEntity : banList)
        {
            BanDto banDto = new BanDto();
            //banDto.setPickTurn(banEntity.getMatchBanId().getPickTurn());
            banDto.setChampionId(String.valueOf(banEntity.getChampionId()));
        }

        return bansDto;
    }

    public List<BanDto> getBanList_byEntity(List<MatchBanEntity> matchBanEntityList) {
        List<BanDto> banDtoList = new ArrayList<>();

        for(MatchBanEntity banEntity : matchBanEntityList) {
            BanDto banDto = new BanDto();
            banDto.setChampionId(String.valueOf(banEntity.getChampionId()));
            banDto.setPickTurn(String.valueOf(banEntity.getMatchBanId().getPickTurn()));

            banDtoList.add(banDto);
        }

        return banDtoList;
    }
}
