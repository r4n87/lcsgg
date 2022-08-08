package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchParticipantEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class MetadataDto {
    private String dataVersion;
    private String matchId;
    private List<String> participants;

    public MetadataDto(MatchMasterEntity matchMasterEntity, List<ParticipantDto> participantsList) {
        List<String> participantsPuuidList = new ArrayList<>();

        this.dataVersion = matchMasterEntity.getMatchMasterId().getDataVersion();
        this.matchId = matchMasterEntity.getMatchMasterId().getMatchId();

        for(ParticipantDto participantDto : participantsList) {
            participantsPuuidList.add(participantDto.getPuuid());
        }

        this.participants = participantsPuuidList;
    }
}
