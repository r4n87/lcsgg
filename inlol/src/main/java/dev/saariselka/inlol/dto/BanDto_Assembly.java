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
            banDto.setPickTurn(banEntity.getMatchBanId().getPickTurn());
            banDto.setChampionId(banEntity.getChampionId());
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
            banDto.setChampionId(banEntity.getChampionId());
        }

        return bansDto;
    }
}
