package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.SummonerPerkEntity;
import dev.saariselka.inlol.repository.SummonerPerkRepository;
import dev.saariselka.inlol.vo.SummonerPerkVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SummonerPerkService {
    @Autowired
    private SummonerPerkRepository summonerPerkRepository;
    @Autowired
    private VOMapper voMapper;

    public void insert(int id, String nameEng, String nameKor, String icon, String description) {
        summonerPerkRepository.save(new SummonerPerkEntity(id, nameEng, nameKor, icon, description));
    }

    public void insertAll(List<SummonerPerkVO> summonerPerkVOList) {
        summonerPerkRepository.saveAll(voMapper.toSummonerPerkEntityList(summonerPerkVOList));
    }

    public List<SummonerPerkVO> findByPerkId(int perkId) {
        return voMapper.toSummonerPerkVOList(summonerPerkRepository.findByPerkId(perkId));
    }
}
