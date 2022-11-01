package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.DdragonVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DdragonVersionRepository extends JpaRepository<DdragonVersion, Long> {
    Optional<DdragonVersion> findDdragonVersionByCurrent(String current);
}
