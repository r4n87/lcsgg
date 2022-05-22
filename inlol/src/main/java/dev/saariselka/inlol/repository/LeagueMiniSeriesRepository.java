package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.LeagueEntryEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeagueMiniSeriesRepository  extends JpaRepository<LeagueMiniSeriesEntity, LeagueMiniSeriesId> {
    LeagueMiniSeriesEntity findByLeagueMiniSeriesId(LeagueMiniSeriesId leagueMiniSeriesId);
}
