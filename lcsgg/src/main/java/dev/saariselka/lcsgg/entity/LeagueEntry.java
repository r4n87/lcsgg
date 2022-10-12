package dev.saariselka.lcsgg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
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
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean veteran;
    private boolean freshBlood;
    private boolean inactive;

    // 연관관계 매핑
    @OneToOne
    @JoinColumn(name="mini_series_id")
    private MiniSeries miniSeries;

    // 연관관계 설정
    public void setMiniSeries(MiniSeries miniSeries) {
        this.miniSeries = miniSeries;
    }
}
