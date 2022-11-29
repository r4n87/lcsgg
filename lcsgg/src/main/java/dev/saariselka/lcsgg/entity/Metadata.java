package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Metadata extends BaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "metadata_id")
    private Long id;

    private String dataVersion;
    private String matchId;

    @Transient
    private List<String> participants = new ArrayList<>();

    @Builder
    public Metadata(String dataVersion, String matchId, List<String> participants) {
        this.dataVersion = dataVersion;
        this.matchId = matchId;
        this.participants = participants;
    }
}
