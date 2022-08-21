package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchMasterEntity;
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

    public MetadataDto(MatchMasterDto matchMasterDto, List<MatchParticipantDto> participantsList) {
        List<String> participantsPuuidList = new ArrayList<>();

        this.dataVersion = matchMasterDto.getDataVersion();
        this.matchId = matchMasterDto.getMatchId();

        for(MatchParticipantDto matchParticipantDto : participantsList) {
            participantsPuuidList.add(matchParticipantDto.getPuuid());
        }

        this.participants = participantsPuuidList;
    }
}
