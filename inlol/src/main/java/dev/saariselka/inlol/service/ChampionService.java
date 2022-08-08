package dev.saariselka.inlol.service;

import dev.saariselka.inlol.repository.ChampionRepository;
import dev.saariselka.inlol.vo.ChampionVO;
import dev.saariselka.inlol.vo.VOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionService {
    @Autowired
    ChampionRepository championRepository;
    @Autowired
    VOMapper mapper;

    public void insertAll(List<ChampionVO> entities) {
        championRepository.saveAll(mapper.toChampionEntityList(entities));
    }

    public String findImagePathByNameEng(String nameEng) {
        return championRepository.findByNameEng(nameEng).get(0).getImagePath();
    }

    public String findNameKoByNameEng(String nameEng) {
        return championRepository.findByNameEng(nameEng).get(0).getNameKo();
    }
}
