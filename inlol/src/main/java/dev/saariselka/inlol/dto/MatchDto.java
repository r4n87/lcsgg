package dev.saariselka.inlol.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MatchDto {
    private MetadataDto metadata;
    private InfoDto info;

    public MatchDto(MetadataDto metadataDto, InfoDto infoDto) {
        this.info = infoDto;
        this.metadata = metadataDto;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public InfoDto getInfo() {
        return info;
    }

    public void setInfo(InfoDto info) {
        this.info = info;
    }
}
