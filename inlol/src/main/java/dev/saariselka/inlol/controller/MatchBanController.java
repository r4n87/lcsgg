package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.DtoMapper;
import dev.saariselka.inlol.dto.MatchBanDto;
import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import dev.saariselka.inlol.service.MatchBanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/match_ban")
public class MatchBanController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MatchBanService matchBanService;
    @Autowired
    DtoMapper dtoMapper;

    public List<MatchBanDto> getBansByMatchId(String matchId) {
        return dtoMapper.toMatchBanDtoList(matchBanService.findByMatchId(matchId));
    }

    public List<MatchBanDto> getBansByMatchBanId(String matchId, int pickTurn, int teamId) {
        return dtoMapper.toMatchBanDtoList(matchBanService.findByMatchBanId(new MatchBanId(matchId, pickTurn, teamId)));
    }

    public List<MatchBanDto> getBansByMatchBanIdAndTeamId(String matchId, int teamId) {
        return dtoMapper.toMatchBanDtoList(matchBanService.findByMatchIdAndTeamId(matchId, teamId));
    }

    public void insertBanInfo(String matchId, int pickTurn, int teamId, int championId, Timestamp rrt) {
        matchBanService.insert(matchId, pickTurn, teamId, championId, rrt);
    }
}
