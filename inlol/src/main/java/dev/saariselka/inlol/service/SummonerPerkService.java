package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.SummonerPerkEntity;
import dev.saariselka.inlol.repository.SummonerPerkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SummonerPerkService {
    @Autowired
    private SummonerPerkRepository summonerPerkRepository;

    public void insert(int id, String nameEng, String nameKor, String icon, String description) {
        summonerPerkRepository.save(new SummonerPerkEntity(id, nameEng, nameKor, icon, description));
    }

    public void insertAll(List<SummonerPerkEntity> summonerPerkEntities) {
        summonerPerkRepository.saveAll(summonerPerkEntities);
    }

    public List<SummonerPerkEntity> findByPerkId(int perkId) {
        return summonerPerkRepository.findByPerkId(perkId);
    }
}
