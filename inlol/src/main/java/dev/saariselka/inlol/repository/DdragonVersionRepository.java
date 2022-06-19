package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.DdragonVersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DdragonVersionRepository extends JpaRepository<DdragonVersionEntity, Long> {

    public List<DdragonVersionEntity> findById(String id);
    public List<DdragonVersionEntity> findByCurrent(String current);

    @Query(value = "select id, version, current from mst_version where current = 'Y'", nativeQuery = true)
    public List<DdragonVersionEntity> getCurrentDdragonVersion();
}
