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

    public MetadataDto(MatchMasterEntity matchMasterEntity, List<MatchParticipantEntity> participantsList) {
        List<String> participantsPuuidList = new ArrayList<>();

        this.dataVersion = matchMasterEntity.getMatchMasterId().getDataVersion();
        this.matchId = matchMasterEntity.getMatchMasterId().getMatchId();

        for(MatchParticipantEntity participantEntity : participantsList) {
            participantsPuuidList.add(participantEntity.getMatchParticipantId().getPuuid());
        }

        this.participants = participantsPuuidList;
    }
}
