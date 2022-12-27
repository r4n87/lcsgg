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
    @ManyToOne
    @JoinColumn(name="matchteam_id")
    private Team team;

    // 연관관계 설정
    public void setTeam(Team team) { this.team = team; }

    @Builder
    public Ban(int championId, int pickTurn, Team team) {
        this.championId = championId;
        this.pickTurn = pickTurn;

        if(this.team != null) {
            this.team.getBans().remove(this);
        }

        this.team = team;
        team.getBans().add(this);
    }
}
