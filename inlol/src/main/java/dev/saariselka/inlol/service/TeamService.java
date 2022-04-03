package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.TeamEntity;
import dev.saariselka.inlol.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {

    @Autowired
    private final TeamRepository TeamRepository;

    public List<TeamEntity> findAll() {
        List<TeamEntity> keys = new ArrayList<>();
        TeamRepository.findAll().forEach(e -> keys.add(e));

        return keys;
    }

    public List<TeamEntity> findByMatchid(String matchid) {
        List<TeamEntity> key = TeamRepository.findByMatchid(matchid);
        return key;
    }

    public List<TeamEntity> findByMatchidAndTeamid(String matchid, int teamid) {
        List<TeamEntity> key = TeamRepository.findByMatchidAndTeamid(matchid, teamid);
        return key;
    }
}
