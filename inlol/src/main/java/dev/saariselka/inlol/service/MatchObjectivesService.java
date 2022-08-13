package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import dev.saariselka.inlol.entity.MatchObjectivesId;
import dev.saariselka.inlol.repository.MatchObjectivesRepository;
import dev.saariselka.inlol.vo.MatchObjectivesVO;
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

    @Autowired
    private VOMapper mapper;

    public List<MatchObjectivesVO> findByMatchIdAndTeamId(String matchId, int teamId) {
        return mapper.toMatchObjectivesVOList(matchObjectivesRepository.findByMatchObjectivesId(new MatchObjectivesId(matchId, teamId)));
    }

    public void insert(String matchId, int teamId, boolean baronFirst, int baronKills, boolean championFirst, int championKills,
                       boolean dragonFirst, int dragonKills, boolean inhibitorFirst, int inhibitorKills,
                       boolean riftheraldFirst, int riftheraldKills, boolean towerFirst, int towerKills, Timestamp rrt) {

        matchObjectivesRepository.save( new MatchObjectivesEntity(new MatchObjectivesId(matchId, teamId), baronFirst, baronKills, championFirst, championKills, dragonFirst, dragonKills, inhibitorFirst, inhibitorKills, riftheraldFirst, riftheraldKills, towerFirst, towerKills, rrt));
    }
}
