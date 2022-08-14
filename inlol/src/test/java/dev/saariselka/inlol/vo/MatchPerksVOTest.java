package dev.saariselka.inlol.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchPerksVOTest {
    @Test
    @DisplayName("Lombok Get Function")
    public void testLombokGetFunction() {
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
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        //when
        MatchPerksVO matchPerksVO =
                new MatchPerksVO(
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
                        , rrt
                );

        //then
        assertThat(matchPerksVO.getMatchId()).isEqualTo(matchId);
        assertThat(matchPerksVO.getPuuid()).isEqualTo(puuid);
        assertThat(matchPerksVO.getPrimaryStyle()).isEqualTo(primaryStyle);
        assertThat(matchPerksVO.getPrimaryPerk1()).isEqualTo(primaryPerk1);
        assertThat(matchPerksVO.getPrimaryPerk2()).isEqualTo(primaryPerk2);
        assertThat(matchPerksVO.getPrimaryPerk3()).isEqualTo(primaryPerk3);
        assertThat(matchPerksVO.getPrimaryPerk4()).isEqualTo(primaryPerk4);
        assertThat(matchPerksVO.getSubStyle()).isEqualTo(subStyle);
        assertThat(matchPerksVO.getSubPerk1()).isEqualTo(subPerk1);
        assertThat(matchPerksVO.getSubPerk2()).isEqualTo(subPerk2);
        assertThat(matchPerksVO.getStatPerkDefense()).isEqualTo(statPerkDefense);
        assertThat(matchPerksVO.getStatPerkFlex()).isEqualTo(statPerkFlex);
        assertThat(matchPerksVO.getStatPerkOffense()).isEqualTo(statPerkOffense);
        assertThat(matchPerksVO.getRrt()).isEqualTo(rrt);
    }

    @Test
    @DisplayName("Lombok Set Function")
    public void testLombokSetFunction() {
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
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        MatchPerksVO matchPerksVO =
                new MatchPerksVO(
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
                        , rrt
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
        Timestamp newRrt = new Timestamp(System.currentTimeMillis());

        matchPerksVO.setMatchId(newMatchId);
        matchPerksVO.setPuuid(newPuuid);
        matchPerksVO.setPrimaryStyle(newPrimaryStyle);
        matchPerksVO.setPrimaryPerk1(newPrimaryPerk1);
        matchPerksVO.setPrimaryPerk2(newPrimaryPerk2);
        matchPerksVO.setPrimaryPerk3(newPrimaryPerk3);
        matchPerksVO.setPrimaryPerk4(newPrimaryPerk4);
        matchPerksVO.setSubStyle(newSubStyle);
        matchPerksVO.setSubPerk1(newSubPerk1);
        matchPerksVO.setSubPerk2(newSubPerk2);
        matchPerksVO.setStatPerkDefense(newStatPerkDefense);
        matchPerksVO.setStatPerkFlex(newStatPerkFlex);
        matchPerksVO.setStatPerkOffense(newStatPerkOffense);
        matchPerksVO.setRrt(newRrt);

        //then
        assertThat(matchPerksVO.getMatchId()).isEqualTo(newMatchId);
        assertThat(matchPerksVO.getPuuid()).isEqualTo(newPuuid);
        assertThat(matchPerksVO.getPrimaryStyle()).isEqualTo(newPrimaryStyle);
        assertThat(matchPerksVO.getPrimaryPerk1()).isEqualTo(newPrimaryPerk1);
        assertThat(matchPerksVO.getPrimaryPerk2()).isEqualTo(newPrimaryPerk2);
        assertThat(matchPerksVO.getPrimaryPerk3()).isEqualTo(newPrimaryPerk3);
        assertThat(matchPerksVO.getPrimaryPerk4()).isEqualTo(newPrimaryPerk4);
        assertThat(matchPerksVO.getSubStyle()).isEqualTo(newSubStyle);
        assertThat(matchPerksVO.getSubPerk1()).isEqualTo(newSubPerk1);
        assertThat(matchPerksVO.getSubPerk2()).isEqualTo(newSubPerk2);
        assertThat(matchPerksVO.getStatPerkDefense()).isEqualTo(newStatPerkDefense);
        assertThat(matchPerksVO.getStatPerkFlex()).isEqualTo(newStatPerkFlex);
        assertThat(matchPerksVO.getStatPerkOffense()).isEqualTo(newStatPerkOffense);
        assertThat(matchPerksVO.getRrt()).isEqualTo(newRrt);
    }
}
