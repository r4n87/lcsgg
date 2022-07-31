package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.SummonerPerkEntity;
import dev.saariselka.inlol.entity.SummonerSpellEntity;
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

    public void insertSummonerSpell(String name, String description, int spellKey, String image) {
        summonerSpellService.insert(name, description, spellKey, image);
    }

    public List<SummonerSpellEntity> getSummonerSpellByKey(int summonerSpellKey) {
        return summonerSpellService.findByspellKey(summonerSpellKey);
    }

    public void insertAllSummonerSpell(List<SummonerSpellEntity> summonerSpellEntities) {
        summonerSpellService.insertAll(summonerSpellEntities);
    }
}
