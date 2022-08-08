package dev.saariselka.inlol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DdragonVersionDto {
    private long id;
    private String version;
    private String current;
}
