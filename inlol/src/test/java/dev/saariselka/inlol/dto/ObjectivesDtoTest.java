package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import dev.saariselka.inlol.entity.MatchObjectivesId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ObjectivesDtoTest {

    MatchObjectivesEntity entity;

    @BeforeEach
    void init() {
        entity = createMatchObjectivesEntity();
    }

    @Test
    @DisplayName("Constructor")
    void constructor() {
        // given

        // when
        ObjectivesDto dto = new ObjectivesDto(entity);

        // then
        assertThat(dto.getBaron().isFirst()).isTrue();
        assertThat(dto.getBaron().getKills()).isEqualTo(2);
        assertThat(dto.getChampion().isFirst()).isFalse();
        assertThat(dto.getChampion().getKills()).isEqualTo(40);
        assertThat(dto.getDragon().isFirst()).isFalse();
        assertThat(dto.getDragon().getKills()).isEqualTo(1);
        assertThat(dto.getInhibitor().isFirst()).isTrue();
        assertThat(dto.getInhibitor().getKills()).isEqualTo(1);
        assertThat(dto.getRiftHeraId().isFirst()).isFalse();
        assertThat(dto.getRiftHeraId().getKills()).isEqualTo(0);
        assertThat(dto.getTower().isFirst()).isFalse();
        assertThat(dto.getTower().getKills()).isEqualTo(11);
    }

    @Test
    @DisplayName("Setter")
    void setter() {
        // given
        ObjectivesDto dto = new ObjectivesDto(entity);

        // when
        dto.getBaron().setFirst(false);
        dto.getBaron().setKills(3);
        dto.getChampion().setFirst(true);
        dto.getChampion().setKills(41);
        dto.getDragon().setFirst(true);
        dto.getDragon().setKills(2);
        dto.getInhibitor().setFirst(false);
        dto.getInhibitor().setKills(2);
        dto.getRiftHeraId().setFirst(true);
        dto.getRiftHeraId().setKills(1);
        dto.getTower().setFirst(true);
        dto.getTower().setKills(0);

        // then
        assertThat(dto.getBaron().isFirst()).isFalse();
        assertThat(dto.getBaron().getKills()).isEqualTo(3);
        assertThat(dto.getChampion().isFirst()).isTrue();
        assertThat(dto.getChampion().getKills()).isEqualTo(41);
        assertThat(dto.getDragon().isFirst()).isTrue();
        assertThat(dto.getDragon().getKills()).isEqualTo(2);
        assertThat(dto.getInhibitor().isFirst()).isFalse();
        assertThat(dto.getInhibitor().getKills()).isEqualTo(2);
        assertThat(dto.getRiftHeraId().isFirst()).isTrue();
        assertThat(dto.getRiftHeraId().getKills()).isEqualTo(1);
        assertThat(dto.getTower().isFirst()).isTrue();
        assertThat(dto.getTower().getKills()).isEqualTo(0);
    }

    MatchObjectivesEntity createMatchObjectivesEntity() {
        return new MatchObjectivesEntity(new MatchObjectivesId("KR_5976412008", 100),
                true, 2, false, 40, false, 1,
                true, 1, false, 0, false, 11, new Timestamp(System.currentTimeMillis()));
    }

}