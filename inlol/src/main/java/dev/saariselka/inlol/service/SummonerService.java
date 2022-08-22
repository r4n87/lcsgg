package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.SummonerEntity;
import dev.saariselka.inlol.repository.SummonerRepository;
import dev.saariselka.inlol.vo.SummonerVO;
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

    @Autowired
    private final VOMapper voMapper;

    public List<SummonerVO> findByPuuid(String puuid) {
        return voMapper.toSummonerVOList(summonerRepository.findByPuuid(puuid));
    }

    public List<SummonerVO> findByName(String name) {
        return voMapper.toSummonerVOList(summonerRepository.findByName(name));
    }

    public void insert(String accountId,int profileIconid, long revisionDate, String name, String id, long summonerLevel, String puuid, Timestamp rrt) {
        summonerRepository.save(new SummonerEntity(accountId,profileIconid,revisionDate,name,id,summonerLevel,puuid, rrt));
    }
}
