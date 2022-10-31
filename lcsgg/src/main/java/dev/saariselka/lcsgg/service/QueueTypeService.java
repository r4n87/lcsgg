package dev.saariselka.lcsgg.service;

import dev.saariselka.lcsgg.entity.QueueType;
import dev.saariselka.lcsgg.repository.QueueTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueTypeService {
    @Autowired
    QueueTypeRepository queueTypeRepository;

    public List<QueueType> findByQueueId(int queueId) {
        return queueTypeRepository.findByQueueId(queueId);
    }
}
