package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchBanRepository {
    public List<MatchBanEntity> findByMatchid(String matchid);
}
