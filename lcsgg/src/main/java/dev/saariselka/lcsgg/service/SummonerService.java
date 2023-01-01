package dev.saariselka.lcsgg.service;

import dev.saariselka.lcsgg.entity.Summoner;
import dev.saariselka.lcsgg.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class SummonerService {
    @Autowired
    private SummonerRepository summonerRepository;

    public String findPuuidByName(String name)
    {
        Summoner summoner = summonerRepository.findByName(name).orElse(null);

        if (summoner != null)
            return summoner.getPuuid();
        return null;
    }

    public Summoner findSummonerByPuuid(String puuid) {
        Summoner summoner = summonerRepository.findByPuuid(puuid).orElse(null);
        summoner.setLastRefreshTimeForUI(calculateRefreshTimeForUI(summoner.getLastRefreshTimeForAPI()));
        return summoner;
    }

    public Summoner findSummonerByName(String name) {
        Summoner summoner = summonerRepository.findByName(name).orElse(null);
        summoner.setLastRefreshTimeForUI(calculateRefreshTimeForUI(summoner.getLastRefreshTimeForAPI()));
        return summoner;
    }

    //public void insert(String puuid, String accountId, int profileIconId, long revisionDate, String name, String id, long summonerLevel) {
    public void insert(Summoner summoner) {
        summonerRepository.save(summoner);
    }

    private String calculateRefreshTimeForUI(Timestamp lastRefreshTime) {
        String refreshAgoTime = null;

        if (ChronoUnit.HOURS.between(lastRefreshTime.toLocalDateTime(), LocalDateTime.now()) >= 24)
        {
            refreshAgoTime = ChronoUnit.DAYS.between(lastRefreshTime.toLocalDateTime(), LocalDateTime.now())
                    + "일 전";
        }
        else if (ChronoUnit.MINUTES.between(lastRefreshTime.toLocalDateTime(), LocalDateTime.now()) >= 60)
        {
            refreshAgoTime = ChronoUnit.HOURS.between(lastRefreshTime.toLocalDateTime(), LocalDateTime.now())
                    + "시간 전";
        }
        else
        {
            refreshAgoTime = ChronoUnit.MINUTES.between(lastRefreshTime.toLocalDateTime(), LocalDateTime.now())
                    + "분 전";
        }

        return refreshAgoTime;
    }
}
