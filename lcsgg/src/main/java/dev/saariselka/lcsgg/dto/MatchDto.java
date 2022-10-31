package dev.saariselka.lcsgg.dto;

import dev.saariselka.lcsgg.entity.Info;
import dev.saariselka.lcsgg.entity.Metadata;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MatchDto {
    private MetadataDto metadata;
    private InfoDto info;
}
