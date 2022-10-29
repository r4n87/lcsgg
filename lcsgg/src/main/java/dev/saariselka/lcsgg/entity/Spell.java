package dev.saariselka.lcsgg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spell_id")
    private Long id;

    private int spellKey;
    private String name;
    private String description;
    private String image;

}
