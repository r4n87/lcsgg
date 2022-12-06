package dev.saariselka.lcsgg.service;

import dev.saariselka.lcsgg.entity.Match;
import dev.saariselka.lcsgg.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public Match getMatchByMatchId(String matchId) {
        return matchRepository.findByMetadata_MatchId(matchId).get();
    }

    public void insert(Match match) {
        matchRepository.save(match);
    }
}
