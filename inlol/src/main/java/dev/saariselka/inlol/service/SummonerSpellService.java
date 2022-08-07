package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.SummonerSpellEntity;
import dev.saariselka.inlol.repository.SummonerSpellRepository;
import dev.saariselka.inlol.vo.SummonerSpellVO;
import dev.saariselka.inlol.vo.VOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SummonerSpellService {
    @Autowired
    private final SummonerSpellRepository summonerSpellRepository;
    @Autowired
    private VOMapper voMapper;

    public void insert(String name, String description, int spellKey, String image) {
        summonerSpellRepository.save(new SummonerSpellEntity(name, description, spellKey, image));
    }

    public List<SummonerSpellVO> findByspellKey(int spellKey) {
        return voMapper.toSummonerSpellVOList(summonerSpellRepository.findByspellKey(spellKey));
    }

    public void insertAll(List<SummonerSpellVO> summonerSpellVOList) {
        summonerSpellRepository.saveAll(voMapper.toSummonerSpellEntityList(summonerSpellVOList));
    }
}
