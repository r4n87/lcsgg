package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchBanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchBanRepository extends JpaRepository<MatchBanEntity, Long> {
    public List<MatchBanEntity> findByMatchId(String matchId);
}
