package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.ChampionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionRepository extends JpaRepository<ChampionEntity, Integer> {
    List<ChampionEntity> findByNameEng(String nameEng);
}
