package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.APIKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface APIKeyRepository extends JpaRepository<APIKeyEntity, Long> {

    public List<APIKeyEntity> findById(String id);
    public List<APIKeyEntity> findByCategory(String category);
}
