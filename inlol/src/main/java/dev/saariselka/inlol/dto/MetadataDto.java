package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchParticipantEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
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

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }
}
