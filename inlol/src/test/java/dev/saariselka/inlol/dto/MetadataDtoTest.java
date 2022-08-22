package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.DtoMapper;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchMasterId;
import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.entity.MatchParticipantId;
import dev.saariselka.inlol.service.VOMapper;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MetadataDtoTest {
    MatchMasterDto matchMasterDto;
    List<MatchParticipantDto> participantsList;
    DtoMapper dtoMapper;
    VOMapper voMapper;

    @BeforeEach
    void init() {
        matchMasterDto = createMatchMasterDto();
        participantsList = createParticipantsList();
    }

//    @Test
//    @DisplayName("MetadataDto Lombok Get Function Test")
//    public void testLombokGetFunction() {
//        //Given
//        //When
//        MetadataDto metadataDto = new MetadataDto(matchMasterEntity, participantsList);
//
//        //Then
//        assertThat(metadataDto.getMatchId()).isEqualTo(matchMasterEntity.getMatchMasterId().getMatchId());
//        assertThat(metadataDto.getDataVersion()).isEqualTo(matchMasterEntity.getMatchMasterId().getDataVersion());
//        assertThat(metadataDto.getParticipants().get(0)).isEqualTo(participantsList.get(0).getPuuid());
//    }
//
//    @Test
//    @DisplayName("MetadataDto Lombok Set Function Test")
//    public void testLombokSetFunction() {
//        //Given
//        MetadataDto metadataDto = new MetadataDto(matchMasterEntity, participantsList);
//        MatchMasterEntity matchMasterEntityForTest = new MatchMasterEntity(new MatchMasterId("3", "AAAAAA"));
//        List<String> participantsListForTest = new ArrayList<>();
//        participantsListForTest.add("ABCD");
//        participantsListForTest.add("EFGH");
//
//        //When
//        metadataDto.setMatchId(matchMasterEntityForTest.getMatchMasterId().getMatchId());
//        metadataDto.setDataVersion(matchMasterEntityForTest.getMatchMasterId().getDataVersion());
//        metadataDto.setParticipants(participantsListForTest);
//
//        //Then
//        assertThat(metadataDto.getMatchId()).isEqualTo(matchMasterEntityForTest.getMatchMasterId().getMatchId());
//        assertThat(metadataDto.getDataVersion()).isEqualTo(matchMasterEntityForTest.getMatchMasterId().getDataVersion());
//        assertThat(metadataDto.getParticipants()).isEqualTo(participantsListForTest);
//    }

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
        List<MatchParticipantEntity> participantsList = new ArrayList<>();

        participantsList.add(new MatchParticipantEntity(
                new MatchParticipantId("1c7fL59Z_lHlUwQtB4T61txfn9HevjPHLi0tanRbihMffOg1jijmiQXWnQLl3mweFQQmeXdrrTBP7w", "2", "KR_5804413147", 4))
        );
        participantsList.add(new MatchParticipantEntity(
                new MatchParticipantId("Edk2OfT0Ziz0WqRGLB3KZM4-fJlApcTg82aGfvZrxFPmg7qwOxoAqNUVO6IB2WYuidTH90n6F13z5w", "2", "KR_5804413147", 7))
        );
        participantsList.add(new MatchParticipantEntity(
                new MatchParticipantId("fs2-ex5K0QMWm6k3l7Y4BIJHZ8rDs5fP8x1btr3HtXqpPICow4lc1VWfO6MQYtXWwhRS_ZSfHuIDVQ", "2", "KR_5804413147", 9))
        );
        participantsList.add(new MatchParticipantEntity(
                new MatchParticipantId("krWdPGZalsgtfMgj9zgbiLcEHsmU7joNwcm0r0xFxduASXgZPYoZsf6zJE5sd9zezPe1t3vws_BakA", "2", "KR_5804413147", 2))
        );
        participantsList.add(new MatchParticipantEntity(
                new MatchParticipantId("lfCtM97Oi5ueC73j8WvwifK3yfk1WKu8QiKDlQ8AcsSleP8bXJlrSojCFxQyBNuK9r7HZ7O0McKTww", "2", "KR_5804413147", 1))
        );
        participantsList.add(new MatchParticipantEntity(
                new MatchParticipantId("lt4fA1padwj5hVt6bVpWvlwd_cd9pJ9pfITGuLNtb2XahcwhbXvhcjIhg-E_G8AS46PTefYDlBIQRg", "2", "KR_5804413147", 3))
        );
        participantsList.add(new MatchParticipantEntity(
                new MatchParticipantId("N6iDhmoN5wKrXqzDPgi6N0Ua8I-zdU89RGgtKwsxiEf2M-GzXsY6K8ZPy1c-VPiGyRTf9E0pvGecJg", "2", "KR_5804413147", 5))
        );
        participantsList.add(new MatchParticipantEntity(
                new MatchParticipantId("o-sa_ADR8DbBJtr_BvbYMfULnn6P3RK9z-nmQJPFuRg0C2-J1hEhW_M6cZuzMlSl8E5eNyXlLq_WGg", "2", "KR_5804413147", 6))
        );
        participantsList.add(new MatchParticipantEntity(
                new MatchParticipantId("oKmk3Pc4rtmSRk8UNcrEgLqwjREVi3o790uHRKJ61Tt1-SgsWQrSE0Tt_15NszDbVR3JytvUYGajFA", "2", "KR_5804413147", 8))
        );
        participantsList.add(new MatchParticipantEntity(
                new MatchParticipantId("UaX2DtUVIdsIuc-chtJJ-hUSgtL32HQPZZhfsqLt6bPzudr80EIbYwAgPQfV8b8eC4sKCkRjx4wrZg", "2", "KR_5804413147", 10))
        );

        return dtoMapper.toMatchParticipantDtoList(voMapper.toMatchParticipantVOList(participantsList));
    }
}
