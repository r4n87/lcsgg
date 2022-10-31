package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Integer> {
    List<Champion> findByNameEng(String nameEng);
}
