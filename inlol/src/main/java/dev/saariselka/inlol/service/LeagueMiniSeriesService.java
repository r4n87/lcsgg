package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesId;
import dev.saariselka.inlol.repository.LeagueMiniSeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeagueMiniSeriesService {
    @Autowired
    private final LeagueMiniSeriesRepository leagueMiniSeriesRepository;

    public LeagueMiniSeriesEntity findByLeagueMiniSeriesId(LeagueMiniSeriesId leagueMiniSeriesId) {
        return leagueMiniSeriesRepository.findByLeagueMiniSeriesId(leagueMiniSeriesId);
    }

    public void insert(String summonerId, String queueType, int losses, String progress, int target, int wins, Timestamp rrt) {
        leagueMiniSeriesRepository.save(new LeagueMiniSeriesEntity(new LeagueMiniSeriesId(summonerId, queueType), losses, progress, target, wins, rrt));
    }
}
