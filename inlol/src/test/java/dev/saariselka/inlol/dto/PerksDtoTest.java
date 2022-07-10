package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchPerksEntity;
import dev.saariselka.inlol.entity.MatchPerksId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PerksDtoTest {

    PerksDto dto;
    MatchPerksEntity entity;

    @BeforeEach
    void init() {
        dto = createTestPerksDtoUsingSetter();
        entity = createTestMatchPerksEntity();
    }

    @Test
    @DisplayName("Constructor")
    void constructor() {
        //given

        //when
        PerksDto test = new PerksDto(entity);

        //then
        assertThat(test.getPrimaryStyle()).isEqualTo(dto.getPrimaryStyle());
        assertThat(test.getPrimaryPerk1()).isEqualTo(dto.getPrimaryPerk1());
        assertThat(test.getPrimaryPerk2()).isEqualTo(dto.getPrimaryPerk2());
        assertThat(test.getPrimaryPerk3()).isEqualTo(dto.getPrimaryPerk3());
        assertThat(test.getPrimaryPerk4()).isEqualTo(dto.getPrimaryPerk4());
        assertThat(test.getSubStyle()).isEqualTo(dto.getSubStyle());
        assertThat(test.getSubPerk1()).isEqualTo(dto.getSubPerk1());
        assertThat(test.getSubPerk2()).isEqualTo(dto.getSubPerk2());
        assertThat(test.getStatPerkDefense()).isEqualTo(dto.getStatPerkDefense());
        assertThat(test.getStatPerkFlex()).isEqualTo(dto.getStatPerkFlex());
        assertThat(test.getStatPerkOffence()).isEqualTo(dto.getStatPerkOffence());

    }

    MatchPerksEntity createTestMatchPerksEntity() {
        return new MatchPerksEntity(new MatchPerksId("KR_5976412008", "ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw"),
                8200, 8230, 8226, 8233, 8236,
                8300, 8304, 8345, 5003, 5008, 5008, new Timestamp(System.currentTimeMillis()));
    }

    PerksDto createTestPerksDtoUsingSetter() {
        PerksDto dto = new PerksDto();
        dto.setPrimaryStyle(8200);
        dto.setPrimaryPerk1(8230);
        dto.setPrimaryPerk2(8226);
        dto.setPrimaryPerk3(8233);
        dto.setPrimaryPerk4(8236);
        dto.setSubStyle(8300);
        dto.setSubPerk1(8304);
        dto.setSubPerk2(8345);
        dto.setStatPerkDefense(5003);
        dto.setStatPerkFlex(5008);
        dto.setStatPerkOffence(5008);
        return dto;
    }
}