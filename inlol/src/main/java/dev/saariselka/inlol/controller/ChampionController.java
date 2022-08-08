package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.ChampionDto;
import dev.saariselka.inlol.dto.DtoMapper;
import dev.saariselka.inlol.service.ChampionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ChampionController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ChampionService championService;
    @Autowired
    DtoMapper mapper;

    public void insertAll(List<ChampionDto> entities) {
        championService.insertAll(mapper.toChampionVOList(entities));
    }

    public String getImagePathByNameEng(String nameEng) {
        return championService.findImagePathByNameEng(nameEng);
    }

    public String getNameKoByNameEng(String nameEng) {
        return championService.findNameKoByNameEng(nameEng);
    }
}
