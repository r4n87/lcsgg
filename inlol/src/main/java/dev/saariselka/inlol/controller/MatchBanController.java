package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.BanDto;
import dev.saariselka.inlol.dto.MatchDto;
import dev.saariselka.inlol.dto.TeamDto;
import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.service.MatchBanService;
import dev.saariselka.inlol.service.MatchMasterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/match_ban")
public class MatchBanController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MatchBanService matchBanService;


    @GetMapping(value ="/{matchid}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<BanDto> getMatchBan_ByMatchid(@PathVariable("matchid") String matchid) {
        List<MatchBanEntity> ban = matchBanService.findByMatchid(matchid);

        BanDto banDto1 = new BanDto();
        banDto1.setPickTurn(ban.get(0).getPickTurn());
        banDto1.setChampionId(ban.get(0).getChampionId());

        BanDto banDto2 = new BanDto();
        banDto2.setPickTurn(ban.get(1).getPickTurn());
        banDto2.setChampionId(ban.get(1).getChampionId());

        List<BanDto> bans = new ArrayList<>();
        bans.add(banDto1);
        bans.add(banDto2);

        return bans;
    }
}
