package dev.saariselka.inlol.vo;

import dev.saariselka.inlol.dto.SummonerSpellDto;
import dev.saariselka.inlol.entity.MatchBanEntity;
import dev.saariselka.inlol.entity.MatchBanId;
import dev.saariselka.inlol.entity.SummonerSpellEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VOMapperTest {

    @Autowired
    VOMapper voMapper;

    @Test
    @DisplayName("Convert SummonerSpellVOList To SummonerSpellEntityList")
    public void toSummonerSpellEntityList() {

        //given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";
        SummonerSpellVO summonerSpellVO = new SummonerSpellVO(name,description,spellKey,image);
        List<SummonerSpellVO> summonerSpellVOList = new ArrayList<>();
        summonerSpellVOList.add(summonerSpellVO);

        //when
        List<SummonerSpellEntity> summonerSpellEntities = new ArrayList<>();
        summonerSpellEntities = voMapper.toSummonerSpellEntityList(summonerSpellVOList);

        //then
        assertThat(summonerSpellEntities.get(0).getName()).isEqualTo(name);
        assertThat(summonerSpellEntities.get(0).getDescription()).isEqualTo(description);
        assertThat(summonerSpellEntities.get(0).getSpellKey()).isEqualTo(spellKey);
        assertThat(summonerSpellEntities.get(0).getImage()).isEqualTo(image);
    }

    @Test
    @DisplayName("Convert SummonerSpellEntityList To SummonerSpellVOList")
    public void toSummonerSpellVOList() {

        //given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";
        SummonerSpellEntity summonerSpellEntity = new SummonerSpellEntity(name,description,spellKey,image);
        List<SummonerSpellEntity> summonerSpellEntityList = new ArrayList<>();
        summonerSpellEntityList.add(summonerSpellEntity);

        //when
        List<SummonerSpellVO> summonerSpellVOList = new ArrayList<>();
        summonerSpellVOList = voMapper.toSummonerSpellVOList(summonerSpellEntityList);

        //then
        assertThat(summonerSpellVOList.get(0).getName()).isEqualTo(name);
        assertThat(summonerSpellVOList.get(0).getDescription()).isEqualTo(description);
        assertThat(summonerSpellVOList.get(0).getSpellKey()).isEqualTo(spellKey);
        assertThat(summonerSpellVOList.get(0).getImage()).isEqualTo(image);
    }

    @Test
    @DisplayName("Convert MatchBanVOList To MatchBanEntityList")
    public void toMatchBanEntityList() {

        //given
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;
        MatchBanVO matchBanVO = new MatchBanVO(matchId,pickTurn,teamId,championId);
        List<MatchBanVO> matchBanVOList = new ArrayList<>();
        matchBanVOList.add(matchBanVO);

        //when
        List<MatchBanEntity> matchBanEntityList = new ArrayList<>();
        matchBanEntityList = voMapper.toMatchBanEntityList(matchBanVOList);

        //then
        assertThat(matchBanEntityList.get(0).getMatchBanId().getMatchId()).isEqualTo(matchId);
        assertThat(matchBanEntityList.get(0).getMatchBanId().getPickTurn()).isEqualTo(pickTurn);
        assertThat(matchBanEntityList.get(0).getMatchBanId().getTeamId()).isEqualTo(teamId);
        assertThat(matchBanEntityList.get(0).getChampionId()).isEqualTo(championId);
    }

    @Test
    @DisplayName("Convert MatchBanEntityList To MatchBanVOList")
    public void toMatchBanVOList() {

        //given
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        MatchBanEntity matchBanEntity = new MatchBanEntity(new MatchBanId(matchId,pickTurn,teamId),championId,rrt);
        List<MatchBanEntity> matchBanEntityList = new ArrayList<>();
        matchBanEntityList.add(matchBanEntity);

        //when
        List<MatchBanVO> matchBanVOList = new ArrayList<>();
        matchBanVOList = voMapper.toMatchBanVOList(matchBanEntityList);

        //then
        assertThat(matchBanVOList.get(0).getMatchId()).isEqualTo(matchId);
        assertThat(matchBanVOList.get(0).getPickTurn()).isEqualTo(pickTurn);
        assertThat(matchBanVOList.get(0).getTeamId()).isEqualTo(teamId);
        assertThat(matchBanVOList.get(0).getChampionId()).isEqualTo(championId);
    }
}
