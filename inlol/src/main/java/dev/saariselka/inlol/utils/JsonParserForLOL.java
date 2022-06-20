package dev.saariselka.inlol.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

// TODO : exception 부분 리팩토링 필요
public class JsonParserForLOL {
    public static String getKRChampionNameByENGChampionName(String championName) {
        ClassPathResource resource = new ClassPathResource("json/champions.json");
        JsonObject jsonObject = null;

        try {
            jsonObject = JsonParser.parseReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject jsonChampions = (JsonObject) jsonObject.get("data");
        JsonObject jsonMyChampion = (JsonObject) jsonChampions.get(championName);

        return jsonMyChampion.get("name").getAsString();
    }

    public static String getKRGameModeByQueueId(int queueId){
        JsonArray jsonArray = null;
        ClassPathResource resource = new ClassPathResource("json/queueTypes.json");
        try {
            jsonArray = JsonParser.parseReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)).getAsJsonArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Object typeObj : jsonArray)
        {
            JsonObject type = (JsonObject)typeObj;

            if(type.get("queueId").getAsInt() == queueId)
                return type.get("description").getAsString();
        }

        return "NoneType"; // TODO : 예외처리인데 하드코딩말고 교체할까?
    }

    public static String getSpellImageBySpellId(int spellId){
        ClassPathResource summonerResource = new ClassPathResource("json/summoner.json");
        JsonObject summonerJson = null;

        try {
            summonerJson = JsonParser.parseReader(new InputStreamReader(summonerResource.getInputStream(), StandardCharsets.UTF_8)).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject jsonObjectForSummonersData = (JsonObject)summonerJson.get("data");

        JsonObject jsonObjectForSummonerBarrier = (JsonObject)jsonObjectForSummonersData.get("SummonerBarrier");
        JsonObject jsonObjectForSummonerBoost = (JsonObject)jsonObjectForSummonersData.get("SummonerBoost");
        JsonObject jsonObjectForSummonerDot = (JsonObject)jsonObjectForSummonersData.get("SummonerDot");
        JsonObject jsonObjectForSummonerExhaust = (JsonObject)jsonObjectForSummonersData.get("SummonerExhaust");
        JsonObject jsonObjectForSummonerFlash = (JsonObject)jsonObjectForSummonersData.get("SummonerFlash");
        JsonObject jsonObjectForSummonerHaste = (JsonObject)jsonObjectForSummonersData.get("SummonerHaste");
        JsonObject jsonObjectForSummonerHeal = (JsonObject)jsonObjectForSummonersData.get("SummonerHeal");
        JsonObject jsonObjectForSummonerMana = (JsonObject)jsonObjectForSummonersData.get("SummonerMana");
        JsonObject jsonObjectForSummonerPoroRecall = (JsonObject)jsonObjectForSummonersData.get("SummonerPoroRecall");
        JsonObject jsonObjectForSummonerPoroThrow = (JsonObject)jsonObjectForSummonersData.get("SummonerPoroThrow");
        JsonObject jsonObjectForSummonerSmite = (JsonObject)jsonObjectForSummonersData.get("SummonerSmite");
        JsonObject jsonObjectForSummonerSnowURFSnowball_Mark = (JsonObject)jsonObjectForSummonersData.get("SummonerSnowURFSnowball_Mark");
        JsonObject jsonObjectForSummonerSnowball = (JsonObject)jsonObjectForSummonersData.get("SummonerSnowball");
        JsonObject jsonObjectForSummonerTeleport = (JsonObject)jsonObjectForSummonersData.get("SummonerTeleport");
        JsonObject jsonObjectForSummoner_UltBookPlaceholder = (JsonObject)jsonObjectForSummonersData.get("Summoner_UltBookPlaceholder");
        JsonObject jsonObjectForSummoner_UltBookSmitePlaceholder = (JsonObject)jsonObjectForSummonersData.get("Summoner_UltBookSmitePlaceholder");

        HashMap<Integer,JsonObject> hashMapForSummonersData = new HashMap<>();

        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerBarrier.get("key").getAsString()),(JsonObject) jsonObjectForSummonerBarrier.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerBoost.get("key").getAsString()),(JsonObject) jsonObjectForSummonerBoost.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerDot.get("key").getAsString()),(JsonObject) jsonObjectForSummonerDot.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerExhaust.get("key").getAsString()),(JsonObject) jsonObjectForSummonerExhaust.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerFlash.get("key").getAsString()),(JsonObject) jsonObjectForSummonerFlash.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerHaste.get("key").getAsString()),(JsonObject) jsonObjectForSummonerHaste.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerHeal.get("key").getAsString()),(JsonObject) jsonObjectForSummonerHeal.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerMana.get("key").getAsString()),(JsonObject) jsonObjectForSummonerMana.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerPoroRecall.get("key").getAsString()),(JsonObject) jsonObjectForSummonerPoroRecall.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerPoroThrow.get("key").getAsString()),(JsonObject) jsonObjectForSummonerPoroThrow.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerSmite.get("key").getAsString()),(JsonObject) jsonObjectForSummonerSmite.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerSnowURFSnowball_Mark.get("key").getAsString()),(JsonObject) jsonObjectForSummonerSnowURFSnowball_Mark.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerSnowball.get("key").getAsString()),(JsonObject) jsonObjectForSummonerSnowball.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummonerTeleport.get("key").getAsString()),(JsonObject) jsonObjectForSummonerTeleport.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummoner_UltBookPlaceholder.get("key").getAsString()),(JsonObject) jsonObjectForSummoner_UltBookPlaceholder.get("image"));
        hashMapForSummonersData.put(Integer.parseInt(jsonObjectForSummoner_UltBookSmitePlaceholder.get("key").getAsString()),(JsonObject) jsonObjectForSummoner_UltBookSmitePlaceholder.get("image"));

        if(spellId != 0) {
            return String.valueOf(hashMapForSummonersData.get(spellId).get("full")).replaceAll("\"", "");
        } else {
            return  "bot";
        }
    }

    public static String getRuneIconImageByPerkStyle(String type, int styleId, int perkId) {
        ClassPathResource runeImages = new ClassPathResource("json/runes.json");
        JsonArray runeJsonArray = null;
        String iconPath = "";

        try {
            runeJsonArray = JsonParser.parseReader(new InputStreamReader(runeImages.getInputStream(), StandardCharsets.UTF_8)).getAsJsonArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(runeJsonArray == null) return "";

        for(Object obj : runeJsonArray) {
            JsonObject runeObj = (JsonObject) obj;
            if(runeObj.get("id").getAsInt() == styleId) {
                if("sub".equals(type)) {
                    iconPath = runeObj.get("icon").getAsString();
                    break;
                }

                JsonArray detailRuneJsonArray = runeObj.get("slots").getAsJsonArray();
                for(Object detailObj : detailRuneJsonArray) {
                    JsonObject detailRuneObj = (JsonObject) detailObj;
                    JsonArray lastDepthRuneJsonArray = detailRuneObj.get("runes").getAsJsonArray();

                    for(Object lastDepthObj : lastDepthRuneJsonArray) {
                        JsonObject lastDepthRuneObj = (JsonObject) lastDepthObj;
                        if(lastDepthRuneObj.get("id").getAsInt() == perkId) {
                            iconPath =  lastDepthRuneObj.get("icon").getAsString();
                        }
                    }

                }
            }
        }

        return iconPath;
    }
}
