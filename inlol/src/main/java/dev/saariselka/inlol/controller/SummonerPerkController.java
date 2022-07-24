package dev.saariselka.inlol.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.saariselka.inlol.entity.SummonerPerkEntity;
import dev.saariselka.inlol.service.SummonerPerkService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path="/test/SummonerPerk")
public class SummonerPerkController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SummonerPerkService summonerPerkService;

    public void insertAll(List<SummonerPerkEntity> summonerPerkEntities) {
        summonerPerkService.insertAll(summonerPerkEntities);
    }

    public List<SummonerPerkEntity> getSummonerPerkByPerkId(int perkId) {
        System.out.println(summonerPerkService);
        return summonerPerkService.findByPerkId(perkId);
    }
}
