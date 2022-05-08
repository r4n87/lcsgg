package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeagueMiniSeriesRepository  extends JpaRepository<LeagueMiniSeriesEntity, LeagueMiniSeriesId> {
    List<LeagueMiniSeriesEntity> findByLeagueMiniSeriesId(LeagueMiniSeriesId leagueMiniSeriesId);
}
