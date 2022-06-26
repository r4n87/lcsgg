package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.entity.MatchMasterId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MatchMasterRepositoryTest {

    @Autowired
    private MatchMasterRepository matchMasterRepository;

    @Test
    @DisplayName("MatchMaster Entity  Save Test")
    public void saveMatchMasterEntity() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        String dataVersion = "2";
        String matchId = "KR_5804413147";
        long gameCreation = 1646753771000L;
        long gameDuration = 694L;
        long gameEndTimeStamp = 1646754647544L;
        long gameId = 5803564866L;
        String gameMode = "ARAM";
        String gameName = "hondoner 님의 게임";
        long gameStartTimeStamp = 1646753953169L;
        String gameType = "CUSTOM_GAME";
        String gameVersion = "12.5.425.9171";
        int mapId = 12;
        String platformId = "KR";
        int queueId = 0;
        int teamId1 = 100;
        int teamId2 = 200;
        String tournamentCode = null;

        MatchMasterEntity matchMasterEntity = new MatchMasterEntity(new MatchMasterId(dataVersion, matchId),gameCreation,gameDuration,
                                                                    gameEndTimeStamp,gameId,gameMode,gameName,gameStartTimeStamp,gameType,
                                                                    gameVersion,mapId,platformId,queueId,teamId1,teamId2, tournamentCode, rrt);

        // when
        MatchMasterEntity matchMasterEntity_save = matchMasterRepository.save(matchMasterEntity);

        // then
        assertThat(matchMasterEntity.getMatchMasterId()).isEqualTo(matchMasterEntity_save.getMatchMasterId());
        assertThat(matchMasterEntity_save.getMatchMasterId()).isNotNull();
        assertThat(matchMasterRepository.count()).isGreaterThan(0);
    }

    @Test
    @DisplayName("MatchMaster Entity FindByMatchMasterId Test")
    public void findByMatchMasterId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        String dataVersionFirst = "2";
        String dataVersionSecond = "2";
        String matchIdFirst = "KR_5804413147";
        String matchIdSecond = "KR_5803565065";
        long gameCreationFirst = 1646753771000L;
        long gameCreationSecond = 1646754660000L;
        long gameDurationFirst = 694L;
        long gameDurationSecond = 1921L;
        long gameEndTimeStampFirst = 1646754647544L;
        long gameEndTimeStampSecond = 1646756796297L;
        long gameIdFirst = 5803564866L;
        long gameIdSecond = 5803565065L;
        String gameModeFirst = "ARAM";
        String gameModeSecond = "CLASSIC";
        String gameNameFirst = "hondoner 님의 게임";
        String gameNameSecond = "hondoner 님의 게임";
        long gameStartTimeStampFirst = 1646753953169L;
        long gameStartTimeStampSecond = 1646754874366L;
        String gameTypeFirst = "CUSTOM_GAME";
        String gameTypeSecond = "CUSTOM_GAME";
        String gameVersionFirst = "12.5.425.9171";
        String gameVersionSecond = "12.5.425.9171";
        int mapIdFirst = 12;
        int mapIdSecond = 12;
        String platformIdFirst = "KR";
        String platformIdSecond = "KR";
        int queueIdFirst = 0;
        int queueIdSecond = 0;
        int teamId1First = 100;
        int teamId1Second = 100;
        int teamId2First = 200;
        int teamId2Second = 200;
        String tournamentCodeFirst = null;
        String tournamentCodeSecond = null;

        MatchMasterEntity matchMasterEntityFirst = new MatchMasterEntity(new MatchMasterId(dataVersionFirst, matchIdFirst),gameCreationFirst,gameDurationFirst,
                gameEndTimeStampFirst,gameIdFirst,gameModeFirst,gameNameFirst,gameStartTimeStampFirst,gameTypeFirst,
                gameVersionFirst,mapIdFirst,platformIdFirst,queueIdFirst,teamId1First,teamId2First, tournamentCodeFirst, rrt);

        MatchMasterEntity matchMasterEntitySecond = new MatchMasterEntity(new MatchMasterId(dataVersionSecond, matchIdSecond),gameCreationSecond,gameDurationSecond,
                gameEndTimeStampSecond,gameIdSecond,gameModeSecond,gameNameSecond,gameStartTimeStampSecond,gameTypeSecond,
                gameVersionSecond,mapIdSecond,platformIdSecond,queueIdSecond,teamId1Second,teamId2Second, tournamentCodeSecond, rrt);

        MatchMasterEntity matchMasterEntitySavedFirst = matchMasterRepository.save(matchMasterEntityFirst);
        MatchMasterEntity matchMasterEntitySavedSecond = matchMasterRepository.save(matchMasterEntitySecond);

        // when
        MatchMasterEntity matchMasterEntityFindFirst = matchMasterRepository.findByMatchMasterId(matchMasterEntitySavedFirst.getMatchMasterId()).get(0);
        MatchMasterEntity matchMasterEntityFindSecond = matchMasterRepository.findByMatchMasterId(matchMasterEntitySavedSecond.getMatchMasterId()).get(0);

        // then
        assertThat(matchMasterRepository.count()).isGreaterThan(0);
        assertThat(matchMasterEntityFindFirst.getMatchMasterId().getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchMasterEntityFindFirst.getGameId()).isEqualTo(5803564866L);
        assertThat(matchMasterEntityFindSecond.getMatchMasterId().getMatchId()).isEqualTo("KR_5803565065");
        assertThat(matchMasterEntityFindSecond.getGameId()).isEqualTo(5803565065L);
    }

    @Test
    @DisplayName("MatchMaster Entity FindByMatchMasterId_MatchId Test")
    public void findByMatchMasterId_MatchId() {
        // given
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        String dataVersionFirst = "2";
        String dataVersionSecond = "2";
        String matchIdFirst = "KR_5804413147";
        String matchIdSecond = "KR_5803565065";
        long gameCreationFirst = 1646753771000L;
        long gameCreationSecond = 1646754660000L;
        long gameDurationFirst = 694L;
        long gameDurationSecond = 1921L;
        long gameEndTimeStampFirst = 1646754647544L;
        long gameEndTimeStampSecond = 1646756796297L;
        long gameIdFirst = 5803564866L;
        long gameIdSecond = 5803565065L;
        String gameModeFirst = "ARAM";
        String gameModeSecond = "CLASSIC";
        String gameNameFirst = "hondoner 님의 게임";
        String gameNameSecond = "hondoner 님의 게임";
        long gameStartTimeStampFirst = 1646753953169L;
        long gameStartTimeStampSecond = 1646754874366L;
        String gameTypeFirst = "CUSTOM_GAME";
        String gameTypeSecond = "CUSTOM_GAME";
        String gameVersionFirst = "12.5.425.9171";
        String gameVersionSecond = "12.5.425.9171";
        int mapIdFirst = 12;
        int mapIdSecond = 12;
        String platformIdFirst = "KR";
        String platformIdSecond = "KR";
        int queueIdFirst = 0;
        int queueIdSecond = 0;
        int teamId1First = 100;
        int teamId1Second = 100;
        int teamId2First = 200;
        int teamId2Second = 200;
        String tournamentCodeFirst = null;
        String tournamentCodeSecond = null;

        MatchMasterEntity matchMasterEntityFirst = new MatchMasterEntity(new MatchMasterId(dataVersionFirst, matchIdFirst),gameCreationFirst,gameDurationFirst,
                gameEndTimeStampFirst,gameIdFirst,gameModeFirst,gameNameFirst,gameStartTimeStampFirst,gameTypeFirst,
                gameVersionFirst,mapIdFirst,platformIdFirst,queueIdFirst,teamId1First,teamId2First, tournamentCodeFirst, rrt);

        MatchMasterEntity matchMasterEntitySecond = new MatchMasterEntity(new MatchMasterId(dataVersionSecond, matchIdSecond),gameCreationSecond,gameDurationSecond,
                gameEndTimeStampSecond,gameIdSecond,gameModeSecond,gameNameSecond,gameStartTimeStampSecond,gameTypeSecond,
                gameVersionSecond,mapIdSecond,platformIdSecond,queueIdSecond,teamId1Second,teamId2Second, tournamentCodeSecond, rrt);

        MatchMasterEntity matchMasterEntitySavedFirst = matchMasterRepository.save(matchMasterEntityFirst);
        MatchMasterEntity matchMasterEntitySavedSecond = matchMasterRepository.save(matchMasterEntitySecond);

        // when
        MatchMasterEntity matchMasterEntityFindFirst = matchMasterRepository.findByMatchMasterId_MatchId(matchMasterEntitySavedFirst.getMatchMasterId().getMatchId()).get(0);
        MatchMasterEntity matchMasterEntityFindSecond = matchMasterRepository.findByMatchMasterId_MatchId(matchMasterEntitySavedSecond.getMatchMasterId().getMatchId()).get(0);

        // then
        assertThat(matchMasterRepository.count()).isGreaterThan(0);
        assertThat(matchMasterEntityFindFirst.getMatchMasterId().getMatchId()).isEqualTo("KR_5804413147");
        assertThat(matchMasterEntityFindFirst.getGameId()).isEqualTo(5803564866L);
        assertThat(matchMasterEntityFindSecond.getMatchMasterId().getMatchId()).isEqualTo("KR_5803565065");
        assertThat(matchMasterEntityFindSecond.getGameId()).isEqualTo(5803565065L);
    }
}

