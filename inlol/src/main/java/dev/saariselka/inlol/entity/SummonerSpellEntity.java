package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="RIOT_SUMMONER_SPELL")
public class SummonerSpellEntity {
    @Id
    private int spellKey;

    private String name;
    private String description;
    private String image;

    public SummonerSpellEntity(String name, String description, int spellKey, String image) {
        this.spellKey = spellKey;
        this.name = name;
        this.description = description;
        this.image = image;
    }
}
