package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
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
    @JoinColumn(name="team_id")
    private Team team;

    // 연관관계 설정
    public void setTeam(Team team) { this.team = team; }

    @Builder
    public Ban(int championId, int pickTurn, Team team) {
        this.championId = championId;
        this.pickTurn = pickTurn;

        if(this.team != null) {
            this.team.getBanList().remove(this);
        }

        this.team = team;
        team.getBanList().add(this);
    }
}
