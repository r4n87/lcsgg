package dev.saariselka.inlol.dto;

import java.util.List;

public class MetadataDto {
    private String dataVersion;
    private String matchId;
    private List<String> participants;

    public MetadataDto(String dataVersion, String matchId) {
        this.dataVersion = dataVersion;
        this.matchId = matchId;
    }

    public MetadataDto(String dataVersion, String matchId, List<String> participants) {
        this.dataVersion = dataVersion;
        this.matchId = matchId;
        this.participants = participants;
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