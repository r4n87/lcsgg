package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.controller.DtoMapper;
import dev.saariselka.inlol.dto.*;
import dev.saariselka.inlol.entity.LeagueMiniSeriesEntity;
import dev.saariselka.inlol.entity.LeagueMiniSeriesId;
import dev.saariselka.inlol.vo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.array;

@SpringBootTest
public class DtoMapperTest {

    @Autowired
    DtoMapper dtoMapper;

    @Test
    @DisplayName("Convert SummonerSpellDtoList To SummonerSpellVOList")
    public void toSummonerSpellVOList() {

        //given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";
        SummonerSpellDto summonerSpellDto = new SummonerSpellDto(name,description,spellKey,image);
        List<SummonerSpellDto> summonerSpellDtoList = new ArrayList<>();
        summonerSpellDtoList.add(summonerSpellDto);

        //when
        List<SummonerSpellVO> summonerSpellVOList = new ArrayList<>();
        summonerSpellVOList = dtoMapper.toSummonerSpellVOList(summonerSpellDtoList);

        //then
        assertThat(summonerSpellVOList.get(0).getName()).isEqualTo(name);
        assertThat(summonerSpellVOList.get(0).getDescription()).isEqualTo(description);
        assertThat(summonerSpellVOList.get(0).getSpellKey()).isEqualTo(spellKey);
        assertThat(summonerSpellVOList.get(0).getImage()).isEqualTo(image);
    }

    @Test
    @DisplayName("Convert SummonerSpellVOList To SummonerSpellDtoList")
    public void toSummonerSpellDtoList() {

        //given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";
        SummonerSpellVO summonerSpellVO = new SummonerSpellVO(name,description,spellKey,image);
        List<SummonerSpellVO> summonerSpellVOList = new ArrayList<>();
        summonerSpellVOList.add(summonerSpellVO);

        //when
        List<SummonerSpellDto> summonerSpellDtoList = new ArrayList<>();
        summonerSpellDtoList = dtoMapper.toSummonerSpellDtoList(summonerSpellVOList);

        //then
        assertThat(summonerSpellDtoList.get(0).getName()).isEqualTo(name);
        assertThat(summonerSpellDtoList.get(0).getDescription()).isEqualTo(description);
        assertThat(summonerSpellDtoList.get(0).getSpellKey()).isEqualTo(spellKey);
        assertThat(summonerSpellDtoList.get(0).getImage()).isEqualTo(image);
    }


    @Test
    @DisplayName("Convert MatchBanDtoList To MatchBanVOList")
    public void toMatchBanVOList() {

        //given
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;
        MatchBanDto matchBanDto = new MatchBanDto(matchId,pickTurn,teamId,championId);
        List<MatchBanDto> matchBanDtoList = new ArrayList<>();
        matchBanDtoList.add(matchBanDto);

        //when
        List<MatchBanVO> matchBanVOList = new ArrayList<>();
        matchBanVOList = dtoMapper.toMatchBanVOList(matchBanDtoList);

        //then
        assertThat(matchBanVOList.get(0).getMatchId()).isEqualTo(matchId);
        assertThat(matchBanVOList.get(0).getPickTurn()).isEqualTo(pickTurn);
        assertThat(matchBanVOList.get(0).getTeamId()).isEqualTo(teamId);
        assertThat(matchBanVOList.get(0).getChampionId()).isEqualTo(championId);
    }

    @Test
    @DisplayName("Convert MatchBanVOList To MatchBanDtoList")
    public void toMatchBanDtoList() {
        //given
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;
        MatchBanVO matchBanVO = new MatchBanVO(matchId,pickTurn,teamId,championId);
        List<MatchBanVO> matchBanVOList = new ArrayList<>();
        matchBanVOList.add(matchBanVO);

        //when
        List<MatchBanDto> matchBanDtoList = new ArrayList<>();
        matchBanDtoList = dtoMapper.toMatchBanDtoList(matchBanVOList);

        //then
        assertThat(matchBanDtoList.get(0).getMatchId()).isEqualTo(matchId);
        assertThat(matchBanDtoList.get(0).getPickTurn()).isEqualTo(pickTurn);
        assertThat(matchBanDtoList.get(0).getTeamId()).isEqualTo(teamId);
        assertThat(matchBanDtoList.get(0).getChampionId()).isEqualTo(championId);
    }

    @Test
    @DisplayName("Convert ChampionDtoList To ChampionVOList")
    public void toChampionVOList() {
        // given
        List<ChampionDto> dtoList = new ArrayList<>();
        ChampionDto dto = new ChampionDto(999, "Test", "테스트", "/testimage.png");
        dtoList.add(dto);

        // when
        List<ChampionVO> voList = dtoMapper.toChampionVOList(dtoList);

        // then
        assertThat(voList.get(0).getId()).isEqualTo(999);
        assertThat(voList.get(0).getNameEng()).isEqualTo("Test");
        assertThat(voList.get(0).getNameKo()).isEqualTo("테스트");
        assertThat(voList.get(0).getImagePath()).isEqualTo("/testimage.png");
    }

    @Test
    @DisplayName("Convert DdragonVersionVOList To DdragonVersionDtoList")
    public void toDdragonVersionDtoList() {
        //given
        List<DdragonVersionVO> ddragonVersionVOList = new ArrayList<>();
        DdragonVersionVO ddragonVersionVO = new DdragonVersionVO(12345L, "33333", "Y");
        ddragonVersionVOList.add(ddragonVersionVO);

        //when
        List<DdragonVersionDto> ddragonVersionDtoList = dtoMapper.toDdragonVersionDtoList(ddragonVersionVOList);

        //then
        assertThat(ddragonVersionDtoList.get(0).getId()).isEqualTo(ddragonVersionVO.getId());
        assertThat(ddragonVersionDtoList.get(0).getVersion()).isEqualTo(ddragonVersionVO.getVersion());
        assertThat(ddragonVersionDtoList.get(0).getCurrent()).isEqualTo(ddragonVersionVO.getCurrent());
    }

    @Test
    @DisplayName("Convert LeagueMiniseriesVO To LeagueMiniseriesDto")
    public void toLeagueMiniseriesDto(){
        // given
        String summonerId = "testSummonerId";
        String queueType = "RANKED_SOLO_5x5";
        int target = 3;
        int wins = 2;
        int losses = 1;
        String progress = "Test";
        LeagueMiniSeriesVO leagueMiniSeriesVO = new LeagueMiniSeriesVO(summonerId,queueType,losses,progress,target,wins);

        //when
        LeagueMiniSeriesDto leagueMiniSeriesDto = dtoMapper.toLeagueMiniseriesDto(leagueMiniSeriesVO);

        //then
        assertThat(leagueMiniSeriesDto.getSummonerId()).isEqualTo(summonerId);
        assertThat(leagueMiniSeriesDto.getQueueType()).isEqualTo(queueType);
        assertThat(leagueMiniSeriesDto.getTarget()).isEqualTo(target);
        assertThat(leagueMiniSeriesDto.getWins()).isEqualTo(wins);
        assertThat(leagueMiniSeriesDto.getLosses()).isEqualTo(losses);
        assertThat(String.valueOf(leagueMiniSeriesDto.getProgress())).isEqualTo(progress);
    }

    @Test
    @DisplayName("Convert LeagueEntryVO To LeagueEntryDto")
    public void toLeagueEntryDtoList(){
        // given
        String summonerId = "testSummonerId";
        String queueType = "RANKED_SOLO_5x5";
        String leagueId = "05fb99f4-e149-3133-a78e-821597582f9d";
        String summonerName = "Hide on bush";
        String tier = "CHALLENGER";
        String ranks = "I";
        int leaguePoints = 1008;
        int wins = 358;
        int losses = 309;
        boolean hotStreak = false;
        boolean veteran = true;
        boolean freshBlood = false;
        boolean inactive = false;
        LeagueEntryVO leagueEntryVO = new LeagueEntryVO(summonerId,queueType,leagueId,summonerName,tier,ranks,leaguePoints,wins,losses,hotStreak,veteran,freshBlood,inactive);
        List<LeagueEntryVO> leagueEntryVOList = new ArrayList<>();
        leagueEntryVOList.add(leagueEntryVO);

        //when
        LeagueEntryDto leagueEntryDto = dtoMapper.toLeagueEntryDtoList(leagueEntryVOList).get(0);

        //then
        assertThat(leagueEntryDto.getSummonerId()).isEqualTo(summonerId);
        assertThat(leagueEntryDto.getQueueType()).isEqualTo(queueType);
    }
}