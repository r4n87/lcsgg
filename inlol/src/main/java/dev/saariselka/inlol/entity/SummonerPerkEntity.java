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
@Table(name="RIOT_SUMMONER_PERK")
public class SummonerPerkEntity {
    @Id
    private int perkId;

    private String nameEng;
    private String nameKor;
    private String icon;
    private String description;
}
