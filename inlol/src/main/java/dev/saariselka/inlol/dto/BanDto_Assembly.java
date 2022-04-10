package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.MatchBanController;
import dev.saariselka.inlol.entity.MatchBanEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BanDto_Assembly {

    @Autowired
    MatchBanController matchBanController;

    public BanDto getBans_ByMatchId(String matchId){
        List<MatchBanEntity> banList = matchBanController.getBans_ByMatchId(matchId);
        BanDto banDto = new BanDto();

        for(MatchBanEntity banEntity : banList)
        {
            banDto.setPickTurn(banEntity.getMatchBanId().getPickTurn());
            banDto.setChampionId(banEntity.getChampionId());
        }

        return banDto;
    }

    public BanDto getBans_ByMatchBanId(String matchId, int pickTurn, int teamId){
        List<MatchBanEntity> banList = matchBanController.getBans_ByMatchBanId(matchId, pickTurn, teamId);
        BanDto banDto = new BanDto();

        for(MatchBanEntity banEntity : banList)
        {
            //banDto.setPickTurn(banEntity.getMatchBanId().getPickTurn());
            banDto.setChampionId(banEntity.getChampionId());
        }

        return banDto;
    }
}
