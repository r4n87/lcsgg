package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Optional<Participant> findParticipantByPuuid(String puuid);
}
