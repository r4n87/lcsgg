package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.SummonerPerkDto;
import dev.saariselka.inlol.service.SummonerPerkService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path="/test/SummonerPerk")
public class SummonerPerkController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SummonerPerkService summonerPerkService;
    @Autowired
    private DtoMapper dtoMapper;

    public void insertAll(List<SummonerPerkDto> summonerPerkDtoList) {
        summonerPerkService.insertAll(dtoMapper.toSummonerPerkVOList(summonerPerkDtoList));
    }

    public List<SummonerPerkDto> getSummonerPerkByPerkId(int perkId) {
        return dtoMapper.toSummonerPerkDtoList(summonerPerkService.findByPerkId(perkId));
    }
}
