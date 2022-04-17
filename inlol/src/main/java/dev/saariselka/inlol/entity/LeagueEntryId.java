package dev.saariselka.inlol.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class LeagueEntryId implements Serializable {
    private String summonerId;
    private String queueType;
}
