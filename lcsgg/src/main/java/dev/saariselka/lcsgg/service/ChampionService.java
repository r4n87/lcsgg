package dev.saariselka.lcsgg.service;

import dev.saariselka.lcsgg.dto.ChampionDto;
import dev.saariselka.lcsgg.entity.Champion;
import dev.saariselka.lcsgg.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionService {
    @Autowired
    ChampionRepository championRepository;

    public void insertAll(List<Champion> entities) {
        championRepository.saveAll(entities);
    }

    public String findImagePathByNameEng(String nameEng) {
        return championRepository.findByNameEng(nameEng).get(0).getImagePath();
    }

    public String findNameKoByNameEng(String nameEng) {
        return championRepository.findByNameEng(nameEng).get(0).getNameKo();
    }
}
