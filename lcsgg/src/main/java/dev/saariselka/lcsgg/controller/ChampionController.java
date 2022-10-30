package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.dto.ChampionDto;
import dev.saariselka.lcsgg.service.ChampionService;
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
        championService.insertAll(entities);
    }

    public String getImagePathByNameEng(String nameEng) {
        return championService.findImagePathByNameEng(nameEng);
    }

    public String getNameKoByNameEng(String nameEng) {
        return championService.findNameKoByNameEng(nameEng);
    }
}
