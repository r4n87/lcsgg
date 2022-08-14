package dev.saariselka.inlol.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.saariselka.inlol.controller.SummonerSpellController;
import dev.saariselka.inlol.dto.ChampionDto;
import dev.saariselka.inlol.dto.SummonerPerkDto;
import dev.saariselka.inlol.dto.SummonerSpellDto;
import dev.saariselka.inlol.entity.ChampionEntity;
import dev.saariselka.inlol.entity.SummonerPerkEntity;
import dev.saariselka.inlol.entity.SummonerSpellEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

// TODO : exception 부분 리팩토링 필요
public class JsonParserForLOL {

    @Autowired
    SummonerSpellController summonerSpellController;

    public static List<ChampionDto> getChampionEntities() {
        ClassPathResource resource = new ClassPathResource("json/champions.json");
        JsonObject jsonObject = null;

        try {
            jsonObject = JsonParser.parseReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ChampionDto> dtoList = new ArrayList<>();

        JsonObject jsonChampions = (JsonObject) jsonObject.get("data");
        Set<String> keys = jsonChampions.keySet();

        for(String key : keys) {
            JsonObject champion = (JsonObject) jsonChampions.get(key);

            int id = champion.get("key").getAsInt();
            String nameEng = champion.get("id").getAsString();
            String nameKo = champion.get("name").getAsString();

            JsonObject image = (JsonObject) champion.get("image");
            String imagePath = image.get("full").getAsString();

            dtoList.add(new ChampionDto(id, nameEng, nameKo, imagePath));
        }

        return dtoList;
    }

    public List<SummonerSpellDto> getSummonerSpellDtoList() {
        ClassPathResource summonerResource = new ClassPathResource("json/summoner.json");
        JsonObject summonerJson = null;

        try {
            summonerJson = JsonParser.parseReader(new InputStreamReader(summonerResource.getInputStream(), StandardCharsets.UTF_8)).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject summonerJsonObject = (JsonObject) summonerJson.get("data");
        Set<String> keys = summonerJsonObject.keySet();

        List<SummonerSpellDto> summonerSpellDtoList = new ArrayList<>();

        for(String key : keys) {
            JsonObject summonerSpell = (JsonObject) summonerJsonObject.get(key);

            String name = summonerSpell.get("name").getAsString();
            String description = summonerSpell.get("description").getAsString();
            int spellKey = summonerSpell.get("key").getAsInt();
            String image = ((JsonObject) summonerSpell.get("image")).get("full").getAsString();

            SummonerSpellDto summonerSpellDto = new SummonerSpellDto(name, description, spellKey, image);

            summonerSpellDtoList.add(summonerSpellDto);
        }

        return summonerSpellDtoList;
    }

    public List<SummonerPerkDto> getSummonerPerkDtoList() {
        int id;
        String nameEng;
        String nameKor;
        String icon;
        String desc;

        ClassPathResource runeImages = new ClassPathResource("json/runes.json");
        JsonArray runeJsonArray = null;
        List<SummonerPerkDto> summonerPerkDtoList = new ArrayList<>();

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

            summonerPerkDtoList.add(new SummonerPerkDto(id, nameEng, nameKor, icon, ""));

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

                    summonerPerkDtoList.add(new SummonerPerkDto(id, nameEng, nameKor, icon, desc));
                }
            }
        }

        return summonerPerkDtoList;
    }
}
