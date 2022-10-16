package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.Objectives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectivesRepository extends JpaRepository<Objectives, Long> {
}