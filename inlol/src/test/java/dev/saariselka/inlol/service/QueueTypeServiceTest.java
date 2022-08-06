package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.QueueTypeEntity;
import dev.saariselka.inlol.vo.QueueTypeVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class QueueTypeServiceTest {
    @Autowired
    QueueTypeService queueTypeService;

    @Test
    @DisplayName("Find Entity By QueueId")
    void findByQueueId() {
        // given

        // when
        QueueTypeVO solo = queueTypeService.findByQueueId(420).get(0);
        QueueTypeVO normal = queueTypeService.findByQueueId(430).get(0);
        QueueTypeVO free = queueTypeService.findByQueueId(440).get(0);
        QueueTypeVO wind = queueTypeService.findByQueueId(450).get(0);
        QueueTypeVO ai1 = queueTypeService.findByQueueId(830).get(0);
        QueueTypeVO ai2 = queueTypeService.findByQueueId(840).get(0);
        QueueTypeVO ai3 = queueTypeService.findByQueueId(850).get(0);
        QueueTypeVO urf = queueTypeService.findByQueueId(900).get(0);

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