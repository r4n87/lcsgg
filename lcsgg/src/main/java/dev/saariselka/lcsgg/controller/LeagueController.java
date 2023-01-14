package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.dto.LeagueEntryDto;
import dev.saariselka.lcsgg.entity.LeagueEntry;
import dev.saariselka.lcsgg.service.LeagueService;
import org.modelmapper.TypeMap;
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
        TypeMap<LeagueEntry, LeagueEntryDto> typeMap = modelMapper.createTypeMap(LeagueEntry.class, LeagueEntryDto.class);
        typeMap.addMapping(LeagueEntry::getRanks, LeagueEntryDto::setRank);

        for(LeagueEntry leagueEntry : leagueEntries) {

            LeagueEntryDto leagueEntryDto = modelMapper.map(leagueEntry, LeagueEntryDto.class);
            leagueEntryDtos.add(leagueEntryDto);
        }

        return leagueEntryDtos;
    }

    public void insertLeagueEntry(LeagueEntryDto leagueEntryDto) {
        TypeMap<LeagueEntryDto, LeagueEntry> typeMap = modelMapper.createTypeMap(LeagueEntryDto.class, LeagueEntry.class);
        typeMap.addMapping(LeagueEntryDto::getRank, LeagueEntry::setRanks);
        leagueService.insert(modelMapper.map(leagueEntryDto, LeagueEntry.class));
    }

}
