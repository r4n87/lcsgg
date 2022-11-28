package dev.saariselka.lcsgg.facade;

import dev.saariselka.lcsgg.controller.LeagueController;
import dev.saariselka.lcsgg.controller.SummonerController;
import dev.saariselka.lcsgg.dto.LeagueEntryDto;
import dev.saariselka.lcsgg.dto.SummonerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.LinkedHashMap;

// TODO : db insert 실패했을 때 처리 필요해보임
@Service
public class DBFacade {
    @Autowired
    private SummonerController summonerController;

    @Autowired
    private LeagueController leagueController;

    public String getSummonerPuuidBySummonerName(String name) {
        return summonerController.getPuuidByName(name);
    }

    public void setSummonerInfo(SummonerDto summonerDto) {
        summonerController.insertSummoner(summonerDto);
    }

    public void setLeagueInfo(LeagueEntryDto leagueEntryDto) {
        // parsing
        String queueType = leagueEntryDto.getQueueType();
        if(queueType.equals("RANKED_FLEX_SR") || queueType.equals("RANKED_SOLO_5x5"))
            leagueController.insertLeagueEntry(leagueEntryDto);
    }
}
