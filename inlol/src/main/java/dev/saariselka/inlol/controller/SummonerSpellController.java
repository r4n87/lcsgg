package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.SummonerSpellDto;
import dev.saariselka.inlol.service.SummonerSpellService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/test/SummonerSpell")
public class SummonerSpellController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SummonerSpellService summonerSpellService;
    @Autowired
    DtoMapper dtoMapper;

    public void insertSummonerSpell(String name, String description, int spellKey, String image) {
        summonerSpellService.insert(name, description, spellKey, image);
    }

    public List<SummonerSpellDto> getSummonerSpellByKey(int summonerSpellKey) {
        return dtoMapper.toSummonerSpellDtoList(summonerSpellService.findByspellKey(summonerSpellKey));
    }

    public void insertAllSummonerSpell(List<SummonerSpellDto> summonerSpellDtos) {
        summonerSpellService.insertAll(dtoMapper.toSummonerSpellVOList(summonerSpellDtos));
    }
}
