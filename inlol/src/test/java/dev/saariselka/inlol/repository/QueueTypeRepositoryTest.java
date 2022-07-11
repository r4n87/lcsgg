package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.QueueTypeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QueueTypeRepositoryTest {
    @Autowired
    QueueTypeRepository queueTypeRepository;

    @Test
    @DisplayName("Find Entity By QueueId")
    void findByQueueId() {
        // given

        // when
        QueueTypeEntity solo = queueTypeRepository.findByQueueId(420).get(0);
        QueueTypeEntity normal = queueTypeRepository.findByQueueId(430).get(0);
        QueueTypeEntity free = queueTypeRepository.findByQueueId(440).get(0);
        QueueTypeEntity wind = queueTypeRepository.findByQueueId(450).get(0);
        QueueTypeEntity ai1 = queueTypeRepository.findByQueueId(830).get(0);
        QueueTypeEntity ai2 = queueTypeRepository.findByQueueId(840).get(0);
        QueueTypeEntity ai3 = queueTypeRepository.findByQueueId(850).get(0);
        QueueTypeEntity urf = queueTypeRepository.findByQueueId(900).get(0);

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