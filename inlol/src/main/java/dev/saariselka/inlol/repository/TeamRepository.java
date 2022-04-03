package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.APIKeyEntity;
import dev.saariselka.inlol.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

    public List<TeamEntity> findByMatchid(String matchid);
    public List<TeamEntity> findByMatchidAndTeamid(String matchid, int teamid);
}
