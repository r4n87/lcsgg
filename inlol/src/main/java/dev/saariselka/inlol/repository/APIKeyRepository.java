package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.APIKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface APIKeyRepository extends JpaRepository<APIKeyEntity, Long> {

    Optional<APIKeyEntity> findById(Long id);
    List<APIKeyEntity> findByCategory(String category);
}
