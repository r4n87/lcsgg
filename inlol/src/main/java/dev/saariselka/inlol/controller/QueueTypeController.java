package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.QueueTypeEntity;
import dev.saariselka.inlol.service.QueueTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QueueTypeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    QueueTypeService queueTypeService;

    public QueueTypeEntity getQueueTypeByQueueId(int queueId) {
        return queueTypeService.findByQueueId(queueId).get(0);
    }
}
