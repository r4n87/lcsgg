package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.repository.MatchBanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchBanService {
    @Autowired
    private final MatchBanRepository matchBanRepository;
/*
    public List<MatchBanEntity> findAll() {
        List<MatchBanEntity> bans = new ArrayList<>();
        matchBanRepository.findAll().forEach(e -> bans.add(e));

        return bans;
    }
*/
    public List<MatchBanEntity> findByMatchid(String matchid) {
        List<MatchBanEntity> bans = matchBanRepository.findByMatchid(matchid);
        return bans;
    }
}
