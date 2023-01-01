package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.dto.SummonerDto;
import dev.saariselka.lcsgg.entity.Summoner;
import dev.saariselka.lcsgg.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;

@Controller
public class SummonerController extends BaseConfig {

    @Autowired
    private SummonerService summonerService;

    public String getPuuidByName(String name) {
        return summonerService.findPuuidByName(name);
    }

    public SummonerDto getSummonerDtoByPuuid(String puuid) {
        return modelMapper.map(summonerService.findSummonerByPuuid(puuid), SummonerDto.class);
    }

    public SummonerDto getSummonerDtoByName(String name) {
        return modelMapper.map(summonerService.findSummonerByName(name), SummonerDto.class);
    }

    public void insertSummoner(SummonerDto summonerDto) {
        summonerService.insert(modelMapper.map(summonerDto, Summoner.class));
    }

}
