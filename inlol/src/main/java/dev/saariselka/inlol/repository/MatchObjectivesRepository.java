package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchObjectivesRepository extends JpaRepository<MatchObjectivesEntity, Long> {
    public List<MatchObjectivesEntity> findByMatchIdAndTeamId(String matchId, Integer teamId);
}
