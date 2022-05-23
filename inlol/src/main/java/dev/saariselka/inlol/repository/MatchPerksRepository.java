package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchPerksEntity;
import dev.saariselka.inlol.entity.MatchPerksId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchPerksRepository extends JpaRepository<MatchPerksEntity, MatchPerksId> {
    List<MatchPerksEntity> findByMatchPerksId(MatchPerksId matchPerksId);
}
