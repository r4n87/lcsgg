package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.SummonerSpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummonerSpellRepository extends JpaRepository<SummonerSpellEntity, Integer> {
    List<SummonerSpellEntity> findByspellKey(int spellKey);
}
