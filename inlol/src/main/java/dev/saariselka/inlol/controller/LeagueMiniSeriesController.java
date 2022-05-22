package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesId;
import dev.saariselka.inlol.service.LeagueMiniSeriesService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/league_miniseries")
public class LeagueMiniSeriesController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LeagueMiniSeriesService leagueMiniSeriesService;

    public LeagueMiniSeriesEntity getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId(String summonerId, String queueType) {
        return leagueMiniSeriesService.findByLeagueMiniSeriesId(new LeagueMiniSeriesId(summonerId, queueType));
    }

    public void insertLeagueMiniSeriesInfo(String summonerId, String queueType, int losses, String progress, int target, int wins, Timestamp rrt) {
        leagueMiniSeriesService.insert(summonerId, queueType, losses, progress, target, wins, rrt);
    }
}
