package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.APIKeyEntity;
import dev.saariselka.inlol.entity.SummonerEntity;
import dev.saariselka.inlol.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/test/Summoner")

public class SummonerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SummonerService summonerService;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<SummonerEntity>> getAllSummoners() {
        List<SummonerEntity> summonerList = summonerService.findAll();
        return new ResponseEntity<List<SummonerEntity>>(summonerList, HttpStatus.OK);
    }

    @GetMapping(value ="/{puuid}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<SummonerEntity> getSummoner(@PathVariable("puuid") String puuid) {
        return summonerService.findByPuuid(puuid);
    }

    @GetMapping(value ="/{name}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public String getSummoner_Puuid_ByName(@PathVariable("name") String name) {
        List<SummonerEntity> summoner = summonerService.findByName(name);

        if(!summoner.isEmpty()) {
            return summoner.get(0).getPuuid();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/insert/{accountid,profileIconid,revisiondate,name,id,summonerlevel,puuid,rrt}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public void insertSummoner(@PathVariable("accountid") String accountId
            , @PathVariable("profileiconid") int profileIconid, @PathVariable("revisionDate") long revisiondate
            , @PathVariable("name") String name, @PathVariable("id") String id
            , @PathVariable("summonerLevel") long summonerlevel, @PathVariable("puuid") String puuid
            , @PathVariable("rrt") Timestamp rrt
    ) {
        summonerService.insert(accountId,profileIconid,revisiondate,name,id,summonerlevel,puuid, rrt);
    }


}
