package dev.saariselka.inlol.dto;

public class MatchDto_Assembly {

    public MatchDto getMatchDtoByMatadataDtoAndInfoDto(MetadataDto metadataDto, InfoDto infoDto) {
        MatchDto matchDto = new MatchDto();
        matchDto.setInfo(infoDto);
        matchDto.setMetadata(metadataDto);
        return matchDto;
    }
}
