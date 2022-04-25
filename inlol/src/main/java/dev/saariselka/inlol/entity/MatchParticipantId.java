package dev.saariselka.inlol.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MatchParticipantId implements Serializable {
    @Column(nullable = false)
    private String puuid;
    @Column(nullable = false)
    private String dataVersion;
    @Column(nullable = false)
    private String matchId;

    public MatchParticipantId(String dataVersion, String matchId) {
        this.dataVersion = dataVersion;
        this.matchId = matchId;
    }

    public MatchParticipantId(String puuid) {
        this.puuid = puuid;
    }
}
