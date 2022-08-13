package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchObjectivesEntity;
import dev.saariselka.inlol.entity.MatchObjectivesId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchObjectivesDtoTest {

    @Test
    @DisplayName("Constructor")
    void constructor() {
        // given

        // when
        MatchObjectivesDto dto = new MatchObjectivesDto(
                new MatchObjectiveDto(true, 2),
                new MatchObjectiveDto(false, 40),
                new MatchObjectiveDto(false, 1),
                new MatchObjectiveDto(true, 1),
                new MatchObjectiveDto( false, 0),
                new MatchObjectiveDto(false, 11)
        );

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
        MatchObjectivesDto dto = new MatchObjectivesDto(
                new MatchObjectiveDto(true, 2),
                new MatchObjectiveDto(false, 40),
                new MatchObjectiveDto(false, 1),
                new MatchObjectiveDto(true, 1),
                new MatchObjectiveDto( false, 0),
                new MatchObjectiveDto(false, 11)
        );

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

}