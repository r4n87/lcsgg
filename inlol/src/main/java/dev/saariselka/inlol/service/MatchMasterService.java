package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.repository.MatchMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchMasterService {
    @Autowired
    private final MatchMasterRepository matchMasterRepository;

    public List<MatchMasterEntity> findAll() {
        List<MatchMasterEntity> matchs = new ArrayList<>();
        matchMasterRepository.findAll().forEach(e -> matchs.add(e));

        return matchs;
    }

    public List<MatchMasterEntity> findByDataversionAndMatchid(String dataversion,String matchid) {
        List<MatchMasterEntity> matchs = matchMasterRepository.findByDataversionAndMatchid(dataversion,matchid);
        return matchs;
    }

}