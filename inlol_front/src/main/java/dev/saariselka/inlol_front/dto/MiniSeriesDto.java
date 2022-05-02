package dev.saariselka.inlol_front.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MiniSeriesDto {
    int losses;
    String progress;
    int target;
    int wins;
}
