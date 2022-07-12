package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.QueueTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueTypeRepository extends JpaRepository<QueueTypeEntity, Integer> {
    List<QueueTypeEntity> findByQueueId(int queueId);
}
