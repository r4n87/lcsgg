package dev.saariselka.inlol.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStreamReader;

// TODO : exception 부분 리팩토링 필요
public class JSONParserForLOL {
    private static JsonParser jsonParser = new JsonParser();

    public static String getKRChampionNameByENGChampionName(String championName) {

        ClassPathResource resource = new ClassPathResource("json/champions.json");
        JsonObject jsonObject = null;

        try {
            jsonObject = (JsonObject) jsonParser.parse(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject jsonChampions = (JsonObject) jsonObject.get("data");
        JsonObject jsonMyChampion = (JsonObject) jsonChampions.get(championName);

        return jsonMyChampion.get("name").getAsString();
    }

    public static String getKRGameModeByQueueId(int queueId){
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = null;
        ClassPathResource resource = new ClassPathResource("json/queueTypes.json");
        try {
            jsonArray = (JsonArray) jsonParser.parse(new InputStreamReader(resource.getInputStream(), "UTF-8"));
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
}
