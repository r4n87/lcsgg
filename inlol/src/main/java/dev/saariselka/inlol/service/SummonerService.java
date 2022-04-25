package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.SummonerEntity;
import dev.saariselka.inlol.repository.SummonerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    public List<SummonerEntity> findByPuuid(String puuid) {
        return summonerRepository.findByPuuid(puuid);
    }

    public List<SummonerEntity> findByName(String name) {
        return summonerRepository.findByName(name);
    }

    public void insert(String accountId,int profileIconid, long revisionDate, String name, String id, long summonerLevel, String puuid, Timestamp rrt) {
        summonerRepository.save(new SummonerEntity(accountId,profileIconid,revisionDate,name,id,summonerLevel,puuid, rrt));
    }
}
