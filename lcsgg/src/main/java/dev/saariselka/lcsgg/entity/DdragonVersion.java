package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class DdragonVersion extends BaseInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ddragon_version_id")
    private Long id;

    private String version;
    private String current;

    @Builder
    public DdragonVersion(String version, String current) {
        this.version = version;
        this.current = current;
    }
}
