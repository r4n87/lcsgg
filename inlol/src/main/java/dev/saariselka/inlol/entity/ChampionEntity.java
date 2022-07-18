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
@Table(name="RIOT_CHAMPIONS")
public class ChampionEntity {
    @Id
    int id;

    String nameEng;
    String nameKo;
    String imagePath;
}
