package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.Ban;
import dev.saariselka.lcsgg.entity.MiniSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanRepository extends JpaRepository<Ban, Long> {
}
