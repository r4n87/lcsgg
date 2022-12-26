package dev.saariselka.lcsgg.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class MiniSeriesDto {
    private Long id;
    private int wins;
    private int losses;
    private int target;
    private String progress;

    @Builder
    public MiniSeriesDto(Long id, int wins, int losses, int target, String progress) {
        this.id = id;
        this.wins = wins;
        this.losses = losses;
        this.target = target;
        this.progress = progress;
    }
}
