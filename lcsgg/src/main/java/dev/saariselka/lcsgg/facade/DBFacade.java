package dev.saariselka.lcsgg.facade;

import dev.saariselka.lcsgg.controller.SummonerController;
import dev.saariselka.lcsgg.dto.SummonerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBFacade {
    @Autowired
    private SummonerController summonerController;

    public String getSummonerPuuidBySummonerName(String name) {
        return summonerController.getPuuidByName(name);
    }

    public void setSummonerInfo(SummonerDto summonerDto) {
        summonerController.insertSummoner(summonerDto);
    }
}
