package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class LeagueEntry extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="league_entry_id")
    private Long id;

    private String leagueId;
    private String summonerId;
    private String summonerName;
    private String queueType;
    private String tier;
    private String ranks;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean veteran;
    private boolean freshBlood;
    private boolean inactive;

    // 연관관계 매핑
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="mini_series_id")
    private MiniSeries miniSeries;

    // 연관관계 설정
    public void setMiniSeries(MiniSeries miniSeries) {
        this.miniSeries = miniSeries;
    }

    @Builder
    public LeagueEntry(String leagueId, String summonerId, String summonerName, String queueType,
                       String tier, String ranks, int leaguePoints, int wins, int losses,
                       boolean hotStreak, boolean veteran, boolean freshBlood, boolean inactive,
                       MiniSeries miniSeries) {
        this.leagueId = leagueId;
        this.summonerId = summonerId;
        this.summonerName = summonerName;
        this.queueType = queueType;
        this.tier = tier;
        this.ranks = ranks;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        this.hotStreak = hotStreak;
        this.veteran = veteran;
        this.freshBlood = freshBlood;
        this.inactive = inactive;
        this.miniSeries = miniSeries;
    }

}
