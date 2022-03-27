package dev.saariselka.inlol.controller;

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

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<SummonerEntity>  getSummoner(@PathVariable("puuid") Long puuid) {
        Optional<SummonerEntity> summoner = summonerService.findById(puuid);

        if(summoner.isPresent()) {
            return new ResponseEntity<SummonerEntity>(summoner.get(), HttpStatus.OK);
        } else {
            return null;
        }
    }

}
