package dev.saariselka.lcsgg.facade;

import dev.saariselka.lcsgg.controller.LeagueController;
import dev.saariselka.lcsgg.controller.MatchController;
import dev.saariselka.lcsgg.controller.SummonerController;
import dev.saariselka.lcsgg.dto.LeagueEntryDto;
import dev.saariselka.lcsgg.dto.MatchDto;
import dev.saariselka.lcsgg.dto.SummonerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.*;

// TODO : db insert 실패했을 때 처리 필요해보임
@Service
public class DBFacade {
    @Autowired
    private SummonerController summonerController;

    @Autowired
    private LeagueController leagueController;

    @Autowired
    private MatchController matchController;

    public String getSummonerPuuidBySummonerName(String name) {
        return summonerController.getPuuidByName(name);
    }

    public void setSummonerInfo(SummonerDto summonerDto) {
        summonerController.insertSummoner(summonerDto);
    }

    public void setLeagueInfo(List<LeagueEntryDto> leagueEntryDtos) {
        // parsing
        for(LeagueEntryDto leagueEntryDto : leagueEntryDtos) {
            String queueType = leagueEntryDto.getQueueType();
            if(queueType.equals("RANKED_FLEX_SR") || queueType.equals("RANKED_SOLO_5x5"))
                leagueController.insertLeagueEntry(leagueEntryDto);
        }
    }

    public void setMatch(MatchDto matchDto) { matchController.insertMatch(matchDto); }

    public HashSet<String> getMatchIdListBySummonerPuuid(String puuid) {
        // TODO : match를 puuid 가준으로 찾아오는 방법?
        return null;
    }

    // TODO : SummonerName -> LastRefreshTime 바로 가지고 오는 METHOD 만들지
    public long getLastRefreshTimeBySummonerName(String puuid) {
        return summonerController.getSummonerDtoByPuuid(puuid).getLastRefreshTimeForAPI();
    }
}
