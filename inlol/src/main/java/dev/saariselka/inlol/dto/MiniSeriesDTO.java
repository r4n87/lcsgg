package dev.saariselka.inlol.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MiniSeriesDTO {
    int losses;
    String progress;
    int target;
    int wins;
}
