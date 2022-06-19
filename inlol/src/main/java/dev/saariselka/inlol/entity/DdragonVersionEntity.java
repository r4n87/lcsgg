package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="MST_VERSION")
public class DdragonVersionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String version;
    private String current;

    public DdragonVersionEntity(String version, String current) {
        this.version = version;
        this.current = current;
    }
}
