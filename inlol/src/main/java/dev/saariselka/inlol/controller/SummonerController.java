package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.SummonerDto;
import dev.saariselka.inlol.entity.SummonerEntity;
import dev.saariselka.inlol.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SummonerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final SummonerService summonerService;

    @Autowired
    private final DtoMapper dtoMapper;

    public List<SummonerDto> getSummoner(String puuid) {
        return dtoMapper.toSummonerDtoList(summonerService.findByPuuid(puuid));
    }

    public String getSummonerPuuidByName(String name) {
        List<SummonerDto> summoner = dtoMapper.toSummonerDtoList(summonerService.findByName(name));

        if(!summoner.isEmpty()) {
            return summoner.get(0).getPuuid();
        } else {
            return null;
        }
    }

    public void insertSummoner(String accountId, int profileIconid, long revisiondate
            , String name, String id, long summonerlevel, String puuid, Timestamp rrt) {
        summonerService.insert(accountId,profileIconid,revisiondate,name,id,summonerlevel,puuid, rrt);
    }


}
