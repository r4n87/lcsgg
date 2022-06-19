package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchBanEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BanDto {
    private String championId;
    private String pickTurn;

    public BanDto(MatchBanEntity matchBanEntity) {
        this.championId = String.valueOf(matchBanEntity.getChampionId());
        this.pickTurn = String.valueOf(matchBanEntity.getMatchBanId().getPickTurn());
    }
}
