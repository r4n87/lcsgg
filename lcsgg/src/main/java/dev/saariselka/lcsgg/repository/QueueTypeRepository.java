package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.QueueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueTypeRepository extends JpaRepository<QueueType, Integer> {
    List<QueueType> findByQueueId(int queueId);
}
