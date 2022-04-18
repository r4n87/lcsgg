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
public class LeagueEntryId implements Serializable {
    @Column(nullable = false)
    private String summonerId;
    @Column(nullable = false)
    private String queueType;
}
