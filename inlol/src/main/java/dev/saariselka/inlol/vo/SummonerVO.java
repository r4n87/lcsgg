package dev.saariselka.inlol.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SummonerVO {
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
}
