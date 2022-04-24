package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.SummonerEntity;
import dev.saariselka.inlol.repository.SummonerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class SummonerService {
    @Autowired
    private final SummonerRepository summonerRepository;

    public List<SummonerEntity> findAll() {
        List<SummonerEntity> summonerList = new ArrayList<>();
        summonerRepository.findAll().forEach(e -> summonerList.add(e));

        return summonerList;
    }

    public List<SummonerEntity> findById(String puuid) {
        List<SummonerEntity> summoner = summonerRepository.findById(puuid);
        return summoner;
    }

    public List<SummonerEntity> findByName(String name) {
        List<SummonerEntity> summoner = summonerRepository.findByName(name);
        return summoner;
    }

    public void insert(String accountId,int profileIconid, long revisionDate, String name, String id, long summonerLevel, String puuid, Timestamp rrt) {
        summonerRepository.save(new SummonerEntity(accountId,profileIconid,revisionDate,name,id,summonerLevel,puuid, rrt));
    }
}
