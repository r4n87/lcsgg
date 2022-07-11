package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.QueueTypeEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
public class QueueTypeControllerTest {
    @Autowired
    QueueTypeController queueTypeController;

    @Test
    @DisplayName("Get Entity By QueueId")
    void getQueueTypeByQueueId() {
        // given

        // when
        QueueTypeEntity solo = queueTypeController.getQueueTypeByQueueId(420);
        QueueTypeEntity normal = queueTypeController.getQueueTypeByQueueId(430);
        QueueTypeEntity free = queueTypeController.getQueueTypeByQueueId(440);
        QueueTypeEntity wind = queueTypeController.getQueueTypeByQueueId(450);
        QueueTypeEntity ai1 = queueTypeController.getQueueTypeByQueueId(830);
        QueueTypeEntity ai2 = queueTypeController.getQueueTypeByQueueId(840);
        QueueTypeEntity ai3 = queueTypeController.getQueueTypeByQueueId(850);
        QueueTypeEntity urf = queueTypeController.getQueueTypeByQueueId(900);

        // then
        assertThat(solo.getDescription()).isEqualTo("솔랭");
        assertThat(normal.getDescription()).isEqualTo("일반");
        assertThat(free.getDescription()).isEqualTo("자유 5:5 랭크");
        assertThat(wind.getDescription()).isEqualTo("무작위 총력전");
        assertThat(ai1.getDescription()).isEqualTo("입문");
        assertThat(ai2.getDescription()).isEqualTo("초보");
        assertThat(ai3.getDescription()).isEqualTo("중급");
        assertThat(urf.getDescription()).isEqualTo("U.R.F.");
    }

}