package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.SummonerEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class SummonerDto {

    private String puuid;
    private String accountId;
    private String id;
    private String name;
    private String profileIconId;
    private String revisionDate;
    private String summonerLevel;

    // TODO : 아래 두개 변수 관련해서 리팩토링 -> 하나로 합칠지, 변수명을 명확하게 바꿀지
    private String refreshAgoTime;
    private long lastRefreshTime;

    public SummonerDto(SummonerEntity summonerEntity) {
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

        this.puuid = summonerEntity.getPuuid();
        this.accountId = summonerEntity.getAccountid();
        this.id = summonerEntity.getId();
        this.name = summonerEntity.getName();
        this.profileIconId = String.valueOf(summonerEntity.getProfileiconid());
        this.revisionDate = String.valueOf(summonerEntity.getRevisiondate());
        this.summonerLevel = String.valueOf(summonerEntity.getSummonerlevel());
        this.refreshAgoTime = refreshAgoTime;
        this.lastRefreshTime = summonerEntity.getRrt().toInstant().getEpochSecond();
    }
}
