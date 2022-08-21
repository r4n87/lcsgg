package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.DtoMapper;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchMasterId;
import dev.saariselka.inlol.service.VOMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchDtoTest {

    MatchMasterDto matchMasterDto;
    List<MatchParticipantDto> participantsList;
    MetadataDto metadataDto;
    List<TeamDto> teamsList;
    MatchParticipantDto matchParticipantDto;
    InfoDto infoDto;

    @BeforeEach
    public void init() {
        matchMasterDto = createMatchMasterDto();
        participantsList = createParticipantsList();
        metadataDto = createMetadataDto();
        teamsList = createTeamsList();
        matchParticipantDto = createParticipantDto();
        infoDto = createInfoDto();
    }

    @Test
    @DisplayName("MatchDto Lombok Get Function Test")
    public void testLombokGetFunction() {
        //Given
        //When
        MatchDto matchDto = new MatchDto(metadataDto, infoDto);

        //Then
        assertThat(matchDto.getMetadata()).isEqualTo(metadataDto);
        assertThat(matchDto.getInfo()).isEqualTo(infoDto);
    }

    @Test
    @DisplayName("MatchDto Lombok Set Function Test")
    public void testLombokSetFunction() {
        //Given
        MatchDto matchDto = new MatchDto(metadataDto, infoDto);

        String dataVersion = "2";
        String matchId = "KR_777777777";
        long gameCreation = 1646757704000L;
        long gameDuration = 2376L;
        long gameEndTimeStamp = 1646760107076L;
        long gameId = 5804413147L;
        String gameMode = "CLASSIC";
        String gameName = "teambuilder-match-777777777";
        long gameStartTimeStamp = 1646757730847L;
        String gameType = "MATCHED_GAME";
        String gameVersion = "12.5.425.9171";
        int mapId = 12;
        String platformId = "KR";
        int queueId = 500;
        String queueType = "칼바람바람";
        int teamId1 = 100;
        int teamId2 = 200;
        String tournamentCode = "";

        MatchMasterDto matchMasterDtoForSetTest = new MatchMasterDto(
                dataVersion, matchId, gameCreation, gameDuration, gameEndTimeStamp,
                gameId, gameMode, gameName, gameStartTimeStamp, gameType, gameVersion, mapId, platformId,
                queueId, queueType, teamId1, teamId2, tournamentCode);

        InfoDto infoDtoForSetTest = new InfoDto(matchMasterDtoForSetTest, new ArrayList<>(), new MatchParticipantDto());
        MetadataDto metadataDtoForSetTest = new MetadataDto("2", "5", new ArrayList<>());

        //When
        matchDto.setMetadata(metadataDtoForSetTest);
        matchDto.setInfo(infoDtoForSetTest);

        //Then
        assertThat(matchDto.getMetadata()).isEqualTo(metadataDtoForSetTest);
        assertThat(matchDto.getInfo()).isEqualTo(infoDtoForSetTest);
    }

    private MatchMasterDto createMatchMasterDto() {
        String dataVersion = "2";
        String matchId = "KR_5804413147";
        long gameCreation = 1646757704000L;
        long gameDuration = 2376L;
        long gameEndTimeStamp = 1646760107076L;
        long gameId = 5804413147L;
        String gameMode = "CLASSIC";
        String gameName = "teambuilder-match-5804413147";
        long gameStartTimeStamp = 1646757730847L;
        String gameType = "MATCHED_GAME";
        String gameVersion = "12.5.425.9171";
        int mapId = 11;
        String platformId = "KR";
        int queueId = 420;
        String queueType = "솔랭";
        int teamId1 = 100;
        int teamId2 = 200;
        String tournamentCode = "";

        return new MatchMasterDto(
                dataVersion, matchId,
                gameCreation,
                gameDuration,
                gameEndTimeStamp,
                gameId,
                gameMode,
                gameName,
                gameStartTimeStamp,
                gameType,
                gameVersion,
                mapId,
                platformId,
                queueId,
                queueType,
                teamId1,
                teamId2,
                tournamentCode);
    }

    private List<MatchParticipantDto> createParticipantsList() {
        List<MatchParticipantDto> participantsList = new ArrayList<>();

        participantsList.add(
                new MatchParticipantDto("1c7fL59Z_lHlUwQtB4T61txfn9HevjPHLi0tanRbihMffOg1jijmiQXWnQLl3mweFQQmeXdrrTBP7w", "2", "KR_5804413147", "4")
        );

        participantsList.add(
                new MatchParticipantDto("Edk2OfT0Ziz0WqRGLB3KZM4-fJlApcTg82aGfvZrxFPmg7qwOxoAqNUVO6IB2WYuidTH90n6F13z5w", "2", "KR_5804413147", "7")
        );
        participantsList.add(
                new MatchParticipantDto("fs2-ex5K0QMWm6k3l7Y4BIJHZ8rDs5fP8x1btr3HtXqpPICow4lc1VWfO6MQYtXWwhRS_ZSfHuIDVQ", "2", "KR_5804413147", "9")
        );
        participantsList.add(
                new MatchParticipantDto("krWdPGZalsgtfMgj9zgbiLcEHsmU7joNwcm0r0xFxduASXgZPYoZsf6zJE5sd9zezPe1t3vws_BakA", "2", "KR_5804413147", "2")
        );
        participantsList.add(
                new MatchParticipantDto("lfCtM97Oi5ueC73j8WvwifK3yfk1WKu8QiKDlQ8AcsSleP8bXJlrSojCFxQyBNuK9r7HZ7O0McKTww", "2", "KR_5804413147", "1")
        );
        participantsList.add(
                new MatchParticipantDto("lt4fA1padwj5hVt6bVpWvlwd_cd9pJ9pfITGuLNtb2XahcwhbXvhcjIhg-E_G8AS46PTefYDlBIQRg", "2", "KR_5804413147", "3")
        );
        participantsList.add(
                new MatchParticipantDto("N6iDhmoN5wKrXqzDPgi6N0Ua8I-zdU89RGgtKwsxiEf2M-GzXsY6K8ZPy1c-VPiGyRTf9E0pvGecJg", "2", "KR_5804413147", "5")
        );
        participantsList.add(
                new MatchParticipantDto("o-sa_ADR8DbBJtr_BvbYMfULnn6P3RK9z-nmQJPFuRg0C2-J1hEhW_M6cZuzMlSl8E5eNyXlLq_WGg", "2", "KR_5804413147", "6")
        );
        participantsList.add(
                new MatchParticipantDto("oKmk3Pc4rtmSRk8UNcrEgLqwjREVi3o790uHRKJ61Tt1-SgsWQrSE0Tt_15NszDbVR3JytvUYGajFA", "2", "KR_5804413147", "8")
        );
        participantsList.add(
                new MatchParticipantDto("UaX2DtUVIdsIuc-chtJJ-hUSgtL32HQPZZhfsqLt6bPzudr80EIbYwAgPQfV8b8eC4sKCkRjx4wrZg", "2", "KR_5804413147", "10")
        );

        return participantsList;
    }

    private MetadataDto createMetadataDto() {
        return new MetadataDto(matchMasterDto, participantsList);
    }

    private List<TeamDto> createTeamsList() {
        return new ArrayList<>();
    }

    private MatchParticipantDto createParticipantDto() {
        return new MatchParticipantDto();
    }

    private InfoDto createInfoDto() {
        return new InfoDto(matchMasterDto, teamsList, matchParticipantDto);
    }
}
