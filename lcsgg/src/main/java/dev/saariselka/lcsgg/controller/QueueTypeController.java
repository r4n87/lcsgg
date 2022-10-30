package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.service.QueueTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QueueTypeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    QueueTypeService queueTypeService;

    public String getQueueTypeByQueueId(int queueId) {
        return queueTypeService.findByQueueId(queueId).get(0).getDescription();
    }
}
