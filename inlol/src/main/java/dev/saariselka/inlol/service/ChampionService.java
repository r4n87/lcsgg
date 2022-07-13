package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.ChampionEntity;
import dev.saariselka.inlol.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionService {
    @Autowired
    ChampionRepository championRepository;

    public void insertAll(List<ChampionEntity> entities) {
        championRepository.saveAll(entities);
    }

    public String findImagePathByNameEng(String nameEng) {
        return championRepository.findByNameEng(nameEng).get(0).getImagePath();
    }

    public String findNameKoByNameEng(String nameEng) {
        return championRepository.findByNameEng(nameEng).get(0).getNameKo();
    }
}
