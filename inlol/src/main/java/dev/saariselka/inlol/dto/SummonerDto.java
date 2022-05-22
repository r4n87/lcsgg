package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.SummonerEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfileIconId(String profileIconId) {
        this.profileIconId = profileIconId;
    }

    public void setRevisionDate(String revisionDate) {
        this.revisionDate = revisionDate;
    }

    public void setSummonerLevel(String summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public String getPuuid() { return puuid; }
    public String getAccountId() { return accountId; }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getSummonerLevel() { return summonerLevel; }
    public String getProfileIconId() { return profileIconId; }
    public String getRevisionDate() { return revisionDate; }
    public String getRefreshAgoTime() { return refreshAgoTime; }
    public void setRefreshAgoTime(String refreshAgoTime) { this.refreshAgoTime = refreshAgoTime; }

    public long getLastRefreshTime() {
        return lastRefreshTime;
    }

    public void setLastRefreshTime(long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }
}
