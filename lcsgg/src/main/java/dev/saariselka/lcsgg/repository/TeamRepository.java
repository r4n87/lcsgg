package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByTeamId(int teamId);
}
