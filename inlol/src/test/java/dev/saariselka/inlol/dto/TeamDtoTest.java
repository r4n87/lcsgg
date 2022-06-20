package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamDtoTest {
    TeamEntity entity;
    List<BanDto> banDtoList;
    ObjectivesDto objectivesDto;

    @BeforeEach
    void init() {
        entity = createTestTeamEntity();
        banDtoList = createTestBanDtoList();
        objectivesDto = createTestObjectivesDto();
    }

    @Test
    @DisplayName("TeamDto 생성자 테스트")
    void TeamDto_생성자_테스트() {
        //given
        //TeamEntity entity = createTestTeamEntity();
        //List<BanDto> banDtoList = createTestBanDtoList();
        //ObjectivesDto objectivesDto = createTestObjectivesDto();

        //when
        TeamDto dto = new TeamDto(entity, banDtoList, objectivesDto);

        //then
        assertThat(dto.getBans().get(0).getChampionId()).isEqualTo("221");
        assertThat(dto.getBans().get(0).getPickTurn()).isEqualTo("1");
        assertThat(dto.getBans().get(1).getChampionId()).isEqualTo("-1");
        assertThat(dto.getBans().get(1).getPickTurn()).isEqualTo("2");
        assertThat(dto.getBans().get(2).getChampionId()).isEqualTo("200");
        assertThat(dto.getBans().get(2).getPickTurn()).isEqualTo("3");
        assertThat(dto.getBans().get(3).getChampionId()).isEqualTo("55");
        assertThat(dto.getBans().get(3).getPickTurn()).isEqualTo("4");
        assertThat(dto.getBans().get(4).getChampionId()).isEqualTo("10");
        assertThat(dto.getBans().get(4).getPickTurn()).isEqualTo("5");

        assertThat(dto.getObjectives().getBaron().isFirst()).isTrue();
        assertThat(dto.getObjectives().getBaron().getKills()).isEqualTo(2);
        assertThat(dto.getObjectives().getChampion().isFirst()).isFalse();
        assertThat(dto.getObjectives().getChampion().getKills()).isEqualTo(40);
        assertThat(dto.getObjectives().getDragon().isFirst()).isFalse();
        assertThat(dto.getObjectives().getDragon().getKills()).isEqualTo(1);
        assertThat(dto.getObjectives().getInhibitor().isFirst()).isTrue();
        assertThat(dto.getObjectives().getInhibitor().getKills()).isEqualTo(1);
        assertThat(dto.getObjectives().getRiftHeraId().isFirst()).isFalse();
        assertThat(dto.getObjectives().getRiftHeraId().getKills()).isEqualTo(0);
        assertThat(dto.getObjectives().getTower().isFirst()).isFalse();
        assertThat(dto.getObjectives().getTower().getKills()).isEqualTo(11);

        assertThat(dto.getTeamId()).isEqualTo("100");
        assertThat(dto.getWin()).isEqualTo("true");     // boolean?
    }

    @Test
    @DisplayName("TeamDto Setter 테스트")
    void TeamDto_Setter_테스트() {
        // given
        TeamDto dto = new TeamDto(entity, banDtoList, objectivesDto);

        // when
        dto.getBans().get(0).setChampionId("220");
        dto.getBans().get(0).setPickTurn("2");
        dto.getBans().get(1).setChampionId("2");
        dto.getBans().get(1).setPickTurn("3");
        dto.getBans().get(2).setChampionId("199");
        dto.getBans().get(2).setPickTurn("4");
        dto.getBans().get(3).setChampionId("50");
        dto.getBans().get(3).setPickTurn("5");
        dto.getBans().get(4).setChampionId("8");
        dto.getBans().get(4).setPickTurn("1");

        dto.getObjectives().getBaron().setFirst(false);
        dto.getObjectives().getBaron().setKills(3);
        dto.getObjectives().getChampion().setFirst(true);
        dto.getObjectives().getChampion().setKills(41);
        dto.getObjectives().getDragon().setFirst(true);
        dto.getObjectives().getDragon().setKills(2);
        dto.getObjectives().getInhibitor().setFirst(false);
        dto.getObjectives().getInhibitor().setKills(2);
        dto.getObjectives().getRiftHeraId().setFirst(true);
        dto.getObjectives().getRiftHeraId().setKills(1);
        dto.getObjectives().getTower().setFirst(true);
        dto.getObjectives().getTower().setKills(0);

        dto.setTeamId("200");
        dto.setWin("false");

        // then
        assertThat(dto.getBans().get(0).getChampionId()).isEqualTo("220");
        assertThat(dto.getBans().get(0).getPickTurn()).isEqualTo("2");
        assertThat(dto.getBans().get(1).getChampionId()).isEqualTo("2");
        assertThat(dto.getBans().get(1).getPickTurn()).isEqualTo("3");
        assertThat(dto.getBans().get(2).getChampionId()).isEqualTo("199");
        assertThat(dto.getBans().get(2).getPickTurn()).isEqualTo("4");
        assertThat(dto.getBans().get(3).getChampionId()).isEqualTo("50");
        assertThat(dto.getBans().get(3).getPickTurn()).isEqualTo("5");
        assertThat(dto.getBans().get(4).getChampionId()).isEqualTo("8");
        assertThat(dto.getBans().get(4).getPickTurn()).isEqualTo("1");

        assertThat(dto.getObjectives().getBaron().isFirst()).isFalse();
        assertThat(dto.getObjectives().getBaron().getKills()).isEqualTo(3);
        assertThat(dto.getObjectives().getChampion().isFirst()).isTrue();
        assertThat(dto.getObjectives().getChampion().getKills()).isEqualTo(41);
        assertThat(dto.getObjectives().getDragon().isFirst()).isTrue();
        assertThat(dto.getObjectives().getDragon().getKills()).isEqualTo(2);
        assertThat(dto.getObjectives().getInhibitor().isFirst()).isFalse();
        assertThat(dto.getObjectives().getInhibitor().getKills()).isEqualTo(2);
        assertThat(dto.getObjectives().getRiftHeraId().isFirst()).isTrue();
        assertThat(dto.getObjectives().getRiftHeraId().getKills()).isEqualTo(1);
        assertThat(dto.getObjectives().getTower().isFirst()).isTrue();
        assertThat(dto.getObjectives().getTower().getKills()).isEqualTo(0);

        assertThat(dto.getTeamId()).isEqualTo("200");
        assertThat(dto.getWin()).isEqualTo("false");
    }

    TeamEntity createTestTeamEntity() {
        return new TeamEntity(new TeamId("KR_5976412008", 100 ), true, new Timestamp(System.currentTimeMillis()));
    }

    List<BanDto> createTestBanDtoList() {
        List<BanDto> list = new ArrayList<>();
        list.add(new BanDto(new MatchBanEntity(new MatchBanId("KR_5976412008", 1, 100), 221, new Timestamp(System.currentTimeMillis()))));
        list.add(new BanDto(new MatchBanEntity(new MatchBanId("KR_5976412008", 2, 100), -1, new Timestamp(System.currentTimeMillis()))));
        list.add(new BanDto(new MatchBanEntity(new MatchBanId("KR_5976412008", 3, 100), 200, new Timestamp(System.currentTimeMillis()))));
        list.add(new BanDto(new MatchBanEntity(new MatchBanId("KR_5976412008", 4, 100), 55, new Timestamp(System.currentTimeMillis()))));
        list.add(new BanDto(new MatchBanEntity(new MatchBanId("KR_5976412008", 5, 100), 10, new Timestamp(System.currentTimeMillis()))));
        return list;
    }

    ObjectivesDto createTestObjectivesDto() {
        return new ObjectivesDto(new MatchObjectivesEntity(new MatchObjectivesId("KR_5976412008", 100),
                true, 2, false, 40, false, 1, true, 1, false, 0, false, 11, new Timestamp(System.currentTimeMillis())));
    }
}