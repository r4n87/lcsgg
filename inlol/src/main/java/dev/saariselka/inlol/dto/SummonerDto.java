package dev.saariselka.inlol.dto;

public class SummonerDto {

    private String puuid;
    private String accountId;
    private String id;
    private String name;
    private String profileIconId;
    private String revisionDate;
    private String summonerLevel;

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
}
