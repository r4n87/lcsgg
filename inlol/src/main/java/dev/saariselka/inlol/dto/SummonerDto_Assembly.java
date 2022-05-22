package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.SummonerEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SummonerDto_Assembly {

    public SummonerDto getSummonerDtoByEntity(SummonerEntity summonerEntity) {
        SummonerDto summonerDto = new SummonerDto();

        String refreshAgoTime = null;

        if (ChronoUnit.HOURS.between(summonerEntity.getRrt().toLocalDateTime(), LocalDateTime.now()) >= 24)
        {
            refreshAgoTime = String.valueOf(ChronoUnit.DAYS.between(summonerEntity.getRrt().toLocalDateTime(), LocalDateTime.now()))
                    + "일 전";
        }
        else if (ChronoUnit.MINUTES.between(summonerEntity.getRrt().toLocalDateTime(), LocalDateTime.now()) >= 60)
        {
            refreshAgoTime = String.valueOf(ChronoUnit.HOURS.between(summonerEntity.getRrt().toLocalDateTime(), LocalDateTime.now()))
                    + "시간 전";
        }
        else
        {
            refreshAgoTime = String.valueOf(ChronoUnit.MINUTES.between(summonerEntity.getRrt().toLocalDateTime(), LocalDateTime.now()))
                    + "분 전";
        }

        summonerDto.setPuuid(summonerEntity.getPuuid());
        summonerDto.setAccountId(summonerEntity.getAccountid());
        summonerDto.setId(summonerEntity.getId());
        summonerDto.setName(summonerEntity.getName());
        summonerDto.setProfileIconId(String.valueOf(summonerEntity.getProfileiconid()));
        summonerDto.setRevisionDate(String.valueOf(summonerEntity.getRevisiondate()));
        summonerDto.setSummonerLevel(String.valueOf(summonerEntity.getSummonerlevel()));
        summonerDto.setRefreshAgoTime(refreshAgoTime);
        summonerDto.setLastRefreshTime(summonerEntity.getRrt().toInstant().getEpochSecond());

        return summonerDto;
    }
}
