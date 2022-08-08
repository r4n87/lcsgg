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
    @DisplayName("Get QueueType By QueueId")
    void getQueueTypeByQueueId() {
        // given

        // when
        String solo = queueTypeController.getQueueTypeByQueueId(420);
        String normal = queueTypeController.getQueueTypeByQueueId(430);
        String free = queueTypeController.getQueueTypeByQueueId(440);
        String wind = queueTypeController.getQueueTypeByQueueId(450);
        String ai1 = queueTypeController.getQueueTypeByQueueId(830);
        String ai2 = queueTypeController.getQueueTypeByQueueId(840);
        String ai3 = queueTypeController.getQueueTypeByQueueId(850);
        String urf = queueTypeController.getQueueTypeByQueueId(900);

        // then
        assertThat(solo).isEqualTo("솔랭");
        assertThat(normal).isEqualTo("일반");
        assertThat(free).isEqualTo("자유 5:5 랭크");
        assertThat(wind).isEqualTo("무작위 총력전");
        assertThat(ai1).isEqualTo("입문");
        assertThat(ai2).isEqualTo("초보");
        assertThat(ai3).isEqualTo("중급");
        assertThat(urf).isEqualTo("U.R.F.");
    }

}