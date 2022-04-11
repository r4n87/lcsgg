package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import dev.saariselka.inlol.entity.MatchObjectivesId;
import dev.saariselka.inlol.repository.MatchObjectivesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class MatchObjectivesService {
    @Autowired
    private final MatchObjectivesRepository matchObjectivesRepository;

    public List<MatchObjectivesEntity> findAll() {
        List<MatchObjectivesEntity> objectives = new ArrayList<>();
        matchObjectivesRepository.findAll().forEach(e -> objectives.add(e));

        return objectives;
    }

    public List<MatchObjectivesEntity> findByMatchObjectivesId(MatchObjectivesId matchObjectivesId) {
        List<MatchObjectivesEntity> matchs = matchObjectivesRepository.findByMatchObjectivesId(matchObjectivesId);
        return matchs;
    }

    public void insert(String matchId, int teamId, boolean baronFirst, int baronKills, boolean championFirst, int championKills,
                       boolean dragonFirst, int dragonKills, boolean inhibitorFirst, int inhibitorKills,
                       boolean riftheraldFirst, int riftheraldKills, boolean towerFirst, int towerKills, Timestamp rrt) {

        matchObjectivesRepository.save( new MatchObjectivesEntity(new MatchObjectivesId(matchId, teamId), baronFirst, baronKills, championFirst, championKills, dragonFirst, dragonKills, inhibitorFirst, inhibitorKills, riftheraldFirst, riftheraldKills, towerFirst, towerKills, rrt));
    }
}
