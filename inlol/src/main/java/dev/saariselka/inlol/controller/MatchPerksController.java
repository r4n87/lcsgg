package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.MatchPerksDto;
import dev.saariselka.inlol.entity.MatchPerksEntity;
import dev.saariselka.inlol.entity.MatchPerksId;
import dev.saariselka.inlol.service.MatchPerksService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchPerksController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    MatchPerksService matchPerksService;
    @Autowired
    private DtoMapper dtoMapper;

    @Autowired
    public MatchPerksController(MatchPerksService matchPerksService) {
        this.matchPerksService = matchPerksService;
    }

    public void insertPerks(String matchId
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
        matchPerksService.insert(matchId
                                , puuid
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
                                , rrt);
    }

    public List<MatchPerksDto> getMatchPerksListByMatchIdAndPuuid(String matchId, String puuid) {
        return dtoMapper.toMatchPerksDtoList(matchPerksService.findByMatchPerksId(new MatchPerksId(matchId, puuid)));
    }
}
