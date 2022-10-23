package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class MiniSeries extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mini_series_id")
    private Long id;

    private int wins;
    private int losses;
    private int target;
    private String progress;

    @Builder
    public MiniSeries(int wins, int losses, int target, String progress) {
        this.wins = wins;
        this.losses = losses;
        this.target = target;
        this.progress = progress;
    }
}
