package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="RIOT_CHAMPIONS")
public class Champion extends BaseInfo{
    @Id
    private int id;

    private String nameEng;
    private String nameKo;
    private String imagePath;

    @Builder
    public Champion(int id, String nameEng, String nameKo, String imagePath) {
        this.id = id;
        this.nameEng = nameEng;
        this.nameKo = nameKo;
        this.imagePath = imagePath;
    }
}
