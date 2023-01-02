package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ban extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ban_id")
    private Long id;

    private int championId;
    private int pickTurn;

    // 연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="matchteam_id")
    private Team team_bans;

    // 연관관계 설정
    public void setTeam(Team team) { this.team_bans = team; }

    @Builder
    public Ban(int championId, int pickTurn, Team team) {
        this.championId = championId;
        this.pickTurn = pickTurn;

        if(this.team_bans != null) {
            this.team_bans.getBans().remove(this);
        }

        setTeam(team);
        team.getBans().add(this);
    }
}
