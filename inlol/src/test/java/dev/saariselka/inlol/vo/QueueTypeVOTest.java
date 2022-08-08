package dev.saariselka.inlol.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueTypeVOTest {
    @Test
    @DisplayName("Constructor")
    void Constructor() {
        // given

        // when
        QueueTypeVO vo = new QueueTypeVO();

        // then
        assertThat(vo).isNotNull();
    }

    @Test
    @DisplayName("Setter")
    void setter() {
        // given
        QueueTypeVO vo = new QueueTypeVO();

        // when
        vo.setQueueId(999);
        vo.setMap("TestMap");
        vo.setDescription("TestDes");

        // then
        assertThat(vo.getQueueId()).isEqualTo(999);
        assertThat(vo.getMap()).isEqualTo("TestMap");
        assertThat(vo.getDescription()).isEqualTo("TestDes");

    }
}