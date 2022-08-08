package dev.saariselka.inlol.vo;

import dev.saariselka.inlol.dto.SummonerSpellDto;
import dev.saariselka.inlol.entity.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Test
    @DisplayName("Convert QueueTypeEntityList To QueueTypeVOList")
    public void toQueueTypeVOList() {
        // given
        List<QueueTypeEntity> entityList = new ArrayList<>();
        QueueTypeEntity entity = new QueueTypeEntity(999, "TestMap", "TestDes");
        entityList.add(entity);

        // when
        List<QueueTypeVO> voList = voMapper.toQueueTypeVOList(entityList);

        // then
        assertThat(voList.get(0).getQueueId()).isEqualTo(999);
        assertThat(voList.get(0).getMap()).isEqualTo("TestMap");
        assertThat(voList.get(0).getDescription()).isEqualTo("TestDes");
    }

    @Test
    @DisplayName("Convert ChampionEntityList To ChampionVOList")
    public void toChampionEntityList() {
        // given
        List<ChampionVO> voList = new ArrayList<>();
        ChampionVO vo = new ChampionVO(999, "Test", "테스트", "/testimage.png");
        voList.add(vo);

        // when
        List<ChampionEntity> entityList = voMapper.toChampionEntityList(voList);

        // then
        assertThat(entityList.get(0).getId()).isEqualTo(999);
        assertThat(entityList.get(0).getNameEng()).isEqualTo("Test");
        assertThat(entityList.get(0).getNameKo()).isEqualTo("테스트");
        assertThat(entityList.get(0).getImagePath()).isEqualTo("/testimage.png");

    }

    @Test
    @DisplayName("Convert DdrgonVersionEntityList To DdragonVersionVOList")
    public void toDdragonVersionVOList() {
        //given
        List<DdragonVersionEntity> ddragonVersionEntityList = new ArrayList<>();
        DdragonVersionEntity ddragonVersionEntity = new DdragonVersionEntity(12345L, "12345", "Y");
        ddragonVersionEntityList.add(ddragonVersionEntity);

        //when
        List<DdragonVersionVO> ddragonVersionVOList = voMapper.toDdragonVersionVOList(ddragonVersionEntityList);

        //then
        assertThat(ddragonVersionVOList.get(0).getId()).isEqualTo(ddragonVersionEntity.getId());
        assertThat(ddragonVersionVOList.get(0).getVersion()).isEqualTo(ddragonVersionEntity.getVersion());
        assertThat(ddragonVersionVOList.get(0).getCurrent()).isEqualTo(ddragonVersionEntity.getCurrent());
    }

    @Test
    @DisplayName("Convert DdrgonVersionEntity To DdragonVersionVO")
    public void toDdragonVersionVO() {
        //given
        Optional<DdragonVersionEntity> ddragonVersionEntity = Optional.of(new DdragonVersionEntity(12345L, "12345", "Y"));

        //when
        Optional<DdragonVersionVO> ddragonVersionVO = voMapper.toDdragonVersionVO(ddragonVersionEntity);

        //then
        assertThat(ddragonVersionVO.get().getId()).isEqualTo(ddragonVersionEntity.get().getId());
        assertThat(ddragonVersionVO.get().getVersion()).isEqualTo(ddragonVersionEntity.get().getVersion());
        assertThat(ddragonVersionVO.get().getCurrent()).isEqualTo(ddragonVersionEntity.get().getCurrent());
    }
}
