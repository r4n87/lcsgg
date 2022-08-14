package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.MatchParticipantDto;
import dev.saariselka.inlol.service.MatchParticipantService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/Participants")
public class MatchParticipantController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MatchParticipantService matchParticipantService;
    @Autowired
    DtoMapper dtoMapper;

    public void insertParticipantInfo(MatchParticipantDto matchParticipantDto) {
        matchParticipantService.insert(dtoMapper.toMatchParticipantVO(matchParticipantDto));
    }

    public List<MatchParticipantDto> getMatchParticipantListByDataVersionAndMatchId(
            String dataVersion
            , String matchId
            , long gameDuration) {
        return dtoMapper.toMatchParticipantDtoListWithGameDuration(matchParticipantService.findByDataVersionAndMatchId(dataVersion, matchId), gameDuration);
    }

    public List<MatchParticipantDto> getMatchParticipantListByPuuid(String puuid) {
        return dtoMapper.toMatchParticipantDtoList(matchParticipantService.findByPuuid(puuid));
    }
}
