package dev.saariselka.lcsgg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Team extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    // 연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "info_id")
    private Info info;

    // 연관관계 설정
    public void setInfo(Info info) { this.info = info; }
}
