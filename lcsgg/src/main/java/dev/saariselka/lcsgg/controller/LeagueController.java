package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.dto.LeagueEntryDto;
import dev.saariselka.lcsgg.dto.MiniSeriesDto;
import dev.saariselka.lcsgg.entity.LeagueEntry;
import dev.saariselka.lcsgg.service.LeagueService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LeagueController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LeagueService leagueService;

    public List<LeagueEntryDto> getLeagueEntryDtosBySummonerId(String summonerId) {
        ModelMapper modelMapper = new ModelMapper();        // TODO : 중복이니 추후 appconfig 같은 곳으로 통합해야함
        List<LeagueEntry> leagueEntries = leagueService.getLeagueEntriesBySummonerId(summonerId);
        List<LeagueEntryDto> leagueEntryDtos = new ArrayList<>();

        for(LeagueEntry leagueEntry : leagueEntries) {
            LeagueEntryDto leagueEntryDto = modelMapper.map(leagueEntry, LeagueEntryDto.class);
            MiniSeriesDto miniSeriesDto = modelMapper.map(leagueEntry.getMiniSeries(), MiniSeriesDto.class);
            leagueEntryDto.setMiniSeries(miniSeriesDto);
            leagueEntryDtos.add(leagueEntryDto);
        }

        return leagueEntryDtos;
    }
}
