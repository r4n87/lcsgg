package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchObjectivesRepository {
    public List<MatchObjectivesEntity> findByMatchidAndTeamid(String matchid, Integer teamid);
}
