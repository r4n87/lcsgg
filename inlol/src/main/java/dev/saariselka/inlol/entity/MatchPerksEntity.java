package dev.saariselka.inlol.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@ToString
@Table(name="RIOT_MATCH_PERKS")
public class MatchPerksEntity {
    @EmbeddedId
    private MatchPerksId matchPerksId;

    private int primaryStyle;
    private int primaryPerk1;
    private int primaryPerk2;
    private int primaryPerk3;
    private int primaryPerk4;
    private int subStyle;
    private int subPerk1;
    private int subPerk2;
    private int statPerkDefense;
    private int statPerkFlex;
    private int statPerkOffense;
    private Timestamp rrt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MatchPerksEntity that = (MatchPerksEntity) o;
        return matchPerksId != null && Objects.equals(matchPerksId, that.matchPerksId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchPerksId);
    }
}
