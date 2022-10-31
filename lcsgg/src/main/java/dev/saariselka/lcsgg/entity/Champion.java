package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
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
