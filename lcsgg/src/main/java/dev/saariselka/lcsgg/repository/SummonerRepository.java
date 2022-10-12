package dev.saariselka.lcsgg.repository;


import dev.saariselka.lcsgg.entity.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SummonerRepository extends JpaRepository<Summoner, Long> {
    Optional<Summoner> findByPuuid(String puuid);
    Optional<Summoner> findByName(String name);
}
