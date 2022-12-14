package dev.saariselka.inlol.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class MatchObjectiveDtoTest {
    boolean first;
    int kills;

    @BeforeEach
    void init() {
        first = true;
        kills = 10;
    }

    @Test
    @DisplayName("ObjectiveDto Lombok Get Function Test")
    public void testLombokGetFunction() {
        //given
        //when
        MatchObjectiveDto objectiveDto = new MatchObjectiveDto(first, kills);

        //then
        assertThat(objectiveDto.isFirst()).isEqualTo(first);
        assertThat(objectiveDto.getKills()).isEqualTo(kills);
    }

    @Test
    @DisplayName("ObjectiveDto Lombok Set Function Test")
    public void testLombokSetFunction() {
        //given
        MatchObjectiveDto objectiveDto = new MatchObjectiveDto(first, kills);

        //when
        objectiveDto.setFirst(false);
        objectiveDto.setKills(5);

        //then
        assertThat(objectiveDto.isFirst()).isEqualTo(false);
        assertThat(objectiveDto.getKills()).isEqualTo(5);
    }
}
