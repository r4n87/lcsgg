package dev.saariselka.lcsgg.service;

import dev.saariselka.lcsgg.entity.Ban;
import dev.saariselka.lcsgg.entity.Info;
import dev.saariselka.lcsgg.entity.Match;
import dev.saariselka.lcsgg.entity.Team;
import dev.saariselka.lcsgg.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public Match getMatchByMatchId(String matchId) {
        return matchRepository.findByMetadata_MatchId(matchId).get();
    }

    public void insert(Match match) {

        Info newInfo = new Info(match.getInfo().getGameCreation(),
                match.getInfo().getGameDuration(),
                match.getInfo().getGameEndTimestamp(),
                match.getInfo().getGameId(),
                match.getInfo().getGameMode(),
                match.getInfo().getGameName(),
                match.getInfo().getGameStartTimestamp(),
                match.getInfo().getGameType(),
                match.getInfo().getGameVersion(),
                match.getInfo().getMapId(),
                match.getInfo().getPlatformId(),
                match.getInfo().getQueueId(),
                match.getInfo().getTournamentCode());

        List<Team> newTeams = new ArrayList<>();

        for (Team team : match.getInfo().getTeams().stream().collect(Collectors.toList())) {

            Team newTeam = new Team(team.isWin(), team.getTeamId(), team.getObjectives(), newInfo);

            List<Ban> newBans = new ArrayList<>();

            for(Ban ban : team.getBans().stream().collect(Collectors.toList())) {
                Ban newBan = new Ban(ban.getChampionId(), ban.getPickTurn(), newTeam);
                newBans.add(newBan);
            }

            newTeam.setBans(newBans);

            newTeams.add(newTeam);
        }

        newInfo.setTeams(newTeams);

        match.setInfo(newInfo);

        matchRepository.save(match);
    }
}
