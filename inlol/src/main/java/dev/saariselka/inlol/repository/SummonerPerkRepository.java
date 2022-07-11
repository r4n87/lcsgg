package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.SummonerPerkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummonerPerkRepository extends JpaRepository<SummonerPerkEntity, Integer> {
    List<SummonerPerkEntity> findByPerkId(int perkId);
}
