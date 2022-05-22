package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchBanEntity;

import java.util.ArrayList;
import java.util.List;

public class BanDto_Assembly {

    public List<BanDto> getBanDtoListByEntity(List<MatchBanEntity> matchBanEntityList) {
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
