package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchPerksEntity;
import dev.saariselka.inlol.entity.MatchPerksId;
import dev.saariselka.inlol.repository.MatchPerksRepository;
import dev.saariselka.inlol.vo.MatchPerksVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MatchPerksService {
    private final MatchPerksRepository matchPerksRepository;
    @Autowired
    private VOMapper voMapper;

    public MatchPerksService(MatchPerksRepository matchPerksRepository) {
        this.matchPerksRepository = matchPerksRepository;
    }

    public List<MatchPerksVO> findByMatchPerksId(MatchPerksId matchPerksId) {
        return voMapper.toMatchPerksVOList(matchPerksRepository.findByMatchPerksId(matchPerksId));
    }

    public void insert(String matchId
                       , String puuid
                       , int primaryStyle
                       , int primaryPerk1
                       , int primaryPerk2
                       , int primaryPerk3
                       , int primaryPerk4
                       , int subStyle
                       , int subPerk1
                       , int subPerk2
                       , int statPerkDefense
                       , int statPerkFlex
                       , int statPerkOffense
                       , Timestamp rrt) {
        matchPerksRepository.save(new MatchPerksEntity(new MatchPerksId(matchId, puuid)
                                                    , primaryStyle
                                                    , primaryPerk1
                                                    , primaryPerk2
                                                    , primaryPerk3
                                                    , primaryPerk4
                                                    , subStyle
                                                    , subPerk1
                                                    , subPerk2
                                                    , statPerkDefense
                                                    , statPerkFlex
                                                    , statPerkOffense
                                                    , rrt));
    }
}
