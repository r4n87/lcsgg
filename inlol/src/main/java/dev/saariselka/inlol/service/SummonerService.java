package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.SummonerEntity;
import dev.saariselka.inlol.repository.SummonerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<SummonerEntity> findById(Long puuid) {
        Optional<SummonerEntity> summoner = summonerRepository.findById(puuid);
        return summoner;
    }

}
