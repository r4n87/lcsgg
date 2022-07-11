package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.APIEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface APIRepository extends JpaRepository<APIEntity, Long> {
    Optional<APIEntity> findById(Long id);
    List<APIEntity> findByCategoryAndOperation(String category, String operation);
}
