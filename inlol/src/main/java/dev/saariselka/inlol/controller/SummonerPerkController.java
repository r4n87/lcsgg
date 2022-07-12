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

    @GetMapping("/insert")
    public void insertSummonerPerk() {
        int id;
        String nameEng;
        String nameKor;
        String icon;
        String desc;

        ClassPathResource runeImages = new ClassPathResource("json/runes.json");
        JsonArray runeJsonArray = null;

        try {
            runeJsonArray = JsonParser.parseReader(new InputStreamReader(runeImages.getInputStream(), StandardCharsets.UTF_8)).getAsJsonArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Object obj : runeJsonArray) {
            JsonObject runeObj = (JsonObject) obj;
            id = runeObj.get("id").getAsInt();
            nameEng = runeObj.get("key").getAsString();
            nameKor = runeObj.get("name").getAsString();
            icon = runeObj.get("icon").getAsString();

            summonerPerkService.insert(id, nameEng, nameKor, icon, "");

            JsonArray detailRuneJsonArray = runeObj.get("slots").getAsJsonArray();
            for(Object detailObj : detailRuneJsonArray) {
                JsonObject detailRuneObj = (JsonObject) detailObj;
                JsonArray lastDepthRuneJsonArray = detailRuneObj.get("runes").getAsJsonArray();

                for(Object lastDepthObj : lastDepthRuneJsonArray) {
                    JsonObject lastDepthRuneObj = (JsonObject) lastDepthObj;
                    id = lastDepthRuneObj.get("id").getAsInt();
                    nameEng = lastDepthRuneObj.get("key").getAsString();
                    nameKor = lastDepthRuneObj.get("name").getAsString();
                    icon = lastDepthRuneObj.get("icon").getAsString();
                    desc = lastDepthRuneObj.get("shortDesc").getAsString();

                    summonerPerkService.insert(id, nameEng, nameKor, icon, desc);
                }
            }
        }
    }

    public List<SummonerPerkEntity> getSummonerPerkByPerkId(int perkId) {
        System.out.println(summonerPerkService);
        return summonerPerkService.findByPerkId(perkId);
    }
}
