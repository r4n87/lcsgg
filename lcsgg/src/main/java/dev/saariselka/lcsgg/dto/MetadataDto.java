package dev.saariselka.lcsgg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MetadataDto {
    private String dataVersion;
    private String matchId;

    List<ParticipantDto> participants;
}
