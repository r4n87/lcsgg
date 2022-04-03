package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.APIEntity;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchMasterRepository extends JpaRepository<MatchMasterEntity, Long> {
    public List<MatchMasterEntity> findByDataversionAndMatchid(String dataversion,String matchid);
}


