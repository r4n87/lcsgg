package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchParticipantEntity;

import java.util.ArrayList;
import java.util.List;

public class MetadataDto_Assembly {

    public MetadataDto getMetadataDtoByEntity(MatchMasterEntity matchMasterEntity, List<MatchParticipantEntity> participantsList) {
        MetadataDto metadataDto = new MetadataDto();
        List<String> participantsPuuidList = new ArrayList<>();

        metadataDto.setDataVersion(matchMasterEntity.getMatchMasterId().getDataVersion());
        metadataDto.setMatchId(matchMasterEntity.getMatchMasterId().getMatchId());

        for(MatchParticipantEntity participantEntity : participantsList) {
            participantsPuuidList.add(participantEntity.getMatchParticipantId().getPuuid());
        }

        metadataDto.setParticipants(participantsPuuidList);

        return metadataDto;
    }
}
