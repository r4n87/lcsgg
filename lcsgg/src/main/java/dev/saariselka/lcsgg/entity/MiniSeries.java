package dev.saariselka.lcsgg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class MiniSeries extends BaseInfo{
    @Id
    @Column(name="mini_series_id")
    private Long id;

    private int wins;
    private int losses;
    private int target;
    private String progress;
}
