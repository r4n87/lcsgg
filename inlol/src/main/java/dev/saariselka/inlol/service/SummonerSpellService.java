package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.SummonerSpellEntity;
import dev.saariselka.inlol.repository.SummonerSpellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SummonerSpellService {
    @Autowired
    private final SummonerSpellRepository summonerSpellRepository;

    public void insert(String name, String description, int spellKey, String image) {
        summonerSpellRepository.save(new SummonerSpellEntity(name, description, spellKey, image));
    }

    public List<SummonerSpellEntity> findByspellKey(int spellKey) {
        return summonerSpellRepository.findByspellKey(spellKey);
    }

    public void insertAll(List<SummonerSpellEntity> summonerSpellEntities) {
        summonerSpellRepository.saveAll(summonerSpellEntities);
    }
}
