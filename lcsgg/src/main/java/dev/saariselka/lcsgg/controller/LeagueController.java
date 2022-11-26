package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.dto.LeagueEntryDto;
import dev.saariselka.lcsgg.dto.MiniSeriesDto;
import dev.saariselka.lcsgg.entity.LeagueEntry;
import dev.saariselka.lcsgg.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LeagueController extends BaseConfig {
    //private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LeagueService leagueService;

    public List<LeagueEntryDto> getLeagueEntryDtosBySummonerId(String summonerId) {
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

    public void insertLeagueEntry(LeagueEntryDto leagueEntryDto) {
        leagueService.insert(modelMapper.map(leagueEntryDto, LeagueEntry.class));
    }
}
