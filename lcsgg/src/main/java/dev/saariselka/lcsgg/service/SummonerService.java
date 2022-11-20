package dev.saariselka.lcsgg.service;

import dev.saariselka.lcsgg.entity.Summoner;
import dev.saariselka.lcsgg.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SummonerService {
    @Autowired
    private SummonerRepository summonerRepository;

    public String findPuuidByName(String name)
    {
        Summoner summoner = summonerRepository.findByName(name).orElse(null);

        if (summoner != null)
            return summoner.getPuuid();
        return null;
    }

    public Summoner findSummonerByPuuid(String puuid) {
        return summonerRepository.findByPuuid(puuid).orElse(null);
    }

    public Summoner findSummonerByName(String name) {
        return summonerRepository.findByName(name).orElse(null);
    }

    //public void insert(String puuid, String accountId, int profileIconId, long revisionDate, String name, String id, long summonerLevel) {
    public void insert(Summoner summoner) {

//        Summoner summoner = Summoner.builder()
//                .puuid(puuid)
//                .accountId(accountId)
//                .profileIconId(profileIconId)
//                .revisionDate(revisionDate)
//                .name(name)
//                .id(id)
//                .summonerLevel(summonerLevel)
//                .build();

        summonerRepository.save(summoner);
    }
}
