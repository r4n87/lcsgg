package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchPerksEntity;
import dev.saariselka.inlol.entity.MatchPerksId;
import dev.saariselka.inlol.vo.MatchPerksVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.*;

public class MatchPerksDtoTest {

    MatchPerksDto dto;
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
        String primaryIconPath = "1111";
        String subIconPath = "2222";

        //when
        MatchPerksDto test = new MatchPerksDto(dto, primaryIconPath, subIconPath);

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
        assertThat(test.getStatPerkOffense()).isEqualTo(dto.getStatPerkOffense());
        assertThat(test.getPrimaryIconPath()).isEqualTo(dto.getPrimaryIconPath());
        assertThat(test.getSubIconPath()).isEqualTo(dto.getSubIconPath());
    }

    @Test
    @DisplayName("Lombok Get Function")
    void testLombokGetFunction() {
        //given
        String matchId = "KR12345";
        String puuid = "FEFEFE";
        int primaryStyle = 11111;
        int primaryPerk1 = 22222;
        int primaryPerk2 = 33333;
        int primaryPerk3 = 44444;
        int primaryPerk4 = 55555;
        int subStyle = 66666;
        int subPerk1 = 77777;
        int subPerk2 = 88888;
        int statPerkDefense = 4321;
        int statPerkFlex = 1234;
        int statPerkOffense = 8765;

        //when
        MatchPerksDto matchPerksDto =
                new MatchPerksDto(
                        matchId
                        , puuid
                        , primaryStyle
                        , primaryPerk1
                        , primaryPerk2
                        , primaryPerk3
                        , primaryPerk4
                        , subStyle
                        , subPerk1
                        , subPerk2
                        , statPerkDefense
                        , statPerkFlex
                        , statPerkOffense
                );

        //then
        assertThat(matchPerksDto.getMatchId()).isEqualTo(matchId);
        assertThat(matchPerksDto.getPuuid()).isEqualTo(puuid);
        assertThat(matchPerksDto.getPrimaryStyle()).isEqualTo(primaryStyle);
        assertThat(matchPerksDto.getPrimaryPerk1()).isEqualTo(primaryPerk1);
        assertThat(matchPerksDto.getPrimaryPerk2()).isEqualTo(primaryPerk2);
        assertThat(matchPerksDto.getPrimaryPerk3()).isEqualTo(primaryPerk3);
        assertThat(matchPerksDto.getPrimaryPerk4()).isEqualTo(primaryPerk4);
        assertThat(matchPerksDto.getSubStyle()).isEqualTo(subStyle);
        assertThat(matchPerksDto.getSubPerk1()).isEqualTo(subPerk1);
        assertThat(matchPerksDto.getSubPerk2()).isEqualTo(subPerk2);
        assertThat(matchPerksDto.getStatPerkDefense()).isEqualTo(statPerkDefense);
        assertThat(matchPerksDto.getStatPerkFlex()).isEqualTo(statPerkFlex);
        assertThat(matchPerksDto.getStatPerkOffense()).isEqualTo(statPerkOffense);
    }

    @Test
    @DisplayName("Lombok Set Function")
    void testLombokSetFunction() {
        //given
        String matchId = "KR12345";
        String puuid = "FEFEFE";
        int primaryStyle = 11111;
        int primaryPerk1 = 22222;
        int primaryPerk2 = 33333;
        int primaryPerk3 = 44444;
        int primaryPerk4 = 55555;
        int subStyle = 66666;
        int subPerk1 = 77777;
        int subPerk2 = 88888;
        int statPerkDefense = 4321;
        int statPerkFlex = 1234;
        int statPerkOffense = 8765;

        MatchPerksDto matchPerksDto =
                new MatchPerksDto(
                        matchId
                        , puuid
                        , primaryStyle
                        , primaryPerk1
                        , primaryPerk2
                        , primaryPerk3
                        , primaryPerk4
                        , subStyle
                        , subPerk1
                        , subPerk2
                        , statPerkDefense
                        , statPerkFlex
                        , statPerkOffense
                );

        //when
        String newMatchId = "KR67890";
        String newPuuid = "EXEXEX";
        int newPrimaryStyle = 99999;
        int newPrimaryPerk1 = 88888;
        int newPrimaryPerk2 = 77777;
        int newPrimaryPerk3 = 66666;
        int newPrimaryPerk4 = 55555;
        int newSubStyle = 44444;
        int newSubPerk1 = 33333;
        int newSubPerk2 = 22222;
        int newStatPerkDefense = 8765;
        int newStatPerkFlex = 6789;
        int newStatPerkOffense = 4321;

        matchPerksDto.setMatchId(newMatchId);
        matchPerksDto.setPuuid(newPuuid);
        matchPerksDto.setPrimaryStyle(newPrimaryStyle);
        matchPerksDto.setPrimaryPerk1(newPrimaryPerk1);
        matchPerksDto.setPrimaryPerk2(newPrimaryPerk2);
        matchPerksDto.setPrimaryPerk3(newPrimaryPerk3);
        matchPerksDto.setPrimaryPerk4(newPrimaryPerk4);
        matchPerksDto.setSubStyle(newSubStyle);
        matchPerksDto.setSubPerk1(newSubPerk1);
        matchPerksDto.setSubPerk2(newSubPerk2);
        matchPerksDto.setStatPerkDefense(newStatPerkDefense);
        matchPerksDto.setStatPerkFlex(newStatPerkFlex);
        matchPerksDto.setStatPerkOffense(newStatPerkOffense);

        //then
        assertThat(matchPerksDto.getMatchId()).isEqualTo(newMatchId);
        assertThat(matchPerksDto.getPuuid()).isEqualTo(newPuuid);
        assertThat(matchPerksDto.getPrimaryStyle()).isEqualTo(newPrimaryStyle);
        assertThat(matchPerksDto.getPrimaryPerk1()).isEqualTo(newPrimaryPerk1);
        assertThat(matchPerksDto.getPrimaryPerk2()).isEqualTo(newPrimaryPerk2);
        assertThat(matchPerksDto.getPrimaryPerk3()).isEqualTo(newPrimaryPerk3);
        assertThat(matchPerksDto.getPrimaryPerk4()).isEqualTo(newPrimaryPerk4);
        assertThat(matchPerksDto.getSubStyle()).isEqualTo(newSubStyle);
        assertThat(matchPerksDto.getSubPerk1()).isEqualTo(newSubPerk1);
        assertThat(matchPerksDto.getSubPerk2()).isEqualTo(newSubPerk2);
        assertThat(matchPerksDto.getStatPerkDefense()).isEqualTo(newStatPerkDefense);
        assertThat(matchPerksDto.getStatPerkFlex()).isEqualTo(newStatPerkFlex);
        assertThat(matchPerksDto.getStatPerkOffense()).isEqualTo(newStatPerkOffense);
    }

    MatchPerksEntity createTestMatchPerksEntity() {
        return new MatchPerksEntity(new MatchPerksId("KR_5976412008", "ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw"),
                8200, 8230, 8226, 8233, 8236,
                8300, 8304, 8345, 5003, 5008, 5008, new Timestamp(System.currentTimeMillis()));
    }

    MatchPerksDto createTestPerksDtoUsingSetter() {
        MatchPerksDto dto = new MatchPerksDto();
        dto.setMatchId("KR_5976412008");
        dto.setPuuid("ccqTGM6gk-LlPZyyQFW-igW1ENV-hkic4NZ636GGAmLQ4ENlnf0tVS5Z3LddB49pKLFj1aEXpea4Nw");
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
        dto.setStatPerkOffense(5008);
        dto.setPrimaryIconPath("1111");
        dto.setSubIconPath("2222");
        return dto;
    }
}