package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.MatchTeamDto;
import dev.saariselka.inlol.service.MatchTeamService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchTeamController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final MatchTeamService MatchTeamService;

    @Autowired
    private final DtoMapper mapper;

    public List<MatchTeamDto> getTeamsByMatchId(String matchId) {
        return mapper.toMatchTeamDtoList(MatchTeamService.findByMatchId(matchId));
    }

    public List<MatchTeamDto> getTeamsByMatchIdAndTeamId(String matchId, int teamId) {
        return mapper.toMatchTeamDtoList(MatchTeamService.findByMatchIdAndTeamId(matchId, teamId));
    }

    public void insertTeamInfo(String matchId, int teamId, boolean win, Timestamp rrt) {
        MatchTeamService.insert(matchId,teamId,win, rrt);
    }
}
