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

    @Test
    @DisplayName("Convert SummonerPerk Dto List To SummonerPerk VO List")
    public void toSummonerPerkVOList() {
        //given
        List<SummonerPerkDto> summonerPerkDtoList = new ArrayList<>();
        SummonerPerkDto summonerPerkDto =
                new SummonerPerkDto(
                        12345
                        , "nameEng"
                        , "한글이름"
                        , "iconpath"
                        , "description"
                );
        summonerPerkDtoList.add(summonerPerkDto);

        //when
        List<SummonerPerkVO> summonerPerkVOList = dtoMapper.toSummonerPerkVOList(summonerPerkDtoList);

        //then
        assertThat(summonerPerkVOList.get(0).getPerkId()).isEqualTo(summonerPerkDto.getPerkId());
        assertThat(summonerPerkVOList.get(0).getNameEng()).isEqualTo(summonerPerkDto.getNameEng());
        assertThat(summonerPerkVOList.get(0).getNameKor()).isEqualTo(summonerPerkDto.getNameKor());
        assertThat(summonerPerkVOList.get(0).getIcon()).isEqualTo(summonerPerkDto.getIcon());
        assertThat(summonerPerkVOList.get(0).getDescription()).isEqualTo(summonerPerkDto.getDescription());
    }

    @Test
    @DisplayName("Convert SummonerPerk VO List To SummonerPerk Dto List")
    public void toSummonerPerkDtoList() {
        //given
        List<SummonerPerkVO> summonerPerkVOList = new ArrayList<>();
        SummonerPerkVO summonerPerkVO =
                new SummonerPerkVO(
                        12345
                        , "nameEng"
                        , "한글이름"
                        , "iconpath"
                        , "description"
                );
        summonerPerkVOList.add(summonerPerkVO);

        //when
        List<SummonerPerkDto> summonerPerkDtoList = dtoMapper.toSummonerPerkDtoList(summonerPerkVOList);

        //then
        assertThat(summonerPerkDtoList.get(0).getPerkId()).isEqualTo(summonerPerkVO.getPerkId());
        assertThat(summonerPerkDtoList.get(0).getNameEng()).isEqualTo(summonerPerkVO.getNameEng());
        assertThat(summonerPerkDtoList.get(0).getNameKor()).isEqualTo(summonerPerkVO.getNameKor());
        assertThat(summonerPerkDtoList.get(0).getIcon()).isEqualTo(summonerPerkVO.getIcon());
        assertThat(summonerPerkDtoList.get(0).getDescription()).isEqualTo(summonerPerkVO.getDescription());
    }

    @Test
    @DisplayName("Convert MatchPerks VO List To MatchPerks Dto List")
    public void toMatchPerksDtoList() {
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

        List<MatchPerksVO> matchPerksVOList = new ArrayList<>();
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
        matchPerksVOList.add(matchPerksVO);

        //when
        List<MatchPerksDto> matchPerksDtoList = dtoMapper.toMatchPerksDtoList(matchPerksVOList);

        //then
        assertThat(matchPerksDtoList.get(0).getMatchId()).isEqualTo(matchPerksVO.getMatchId());
        assertThat(matchPerksDtoList.get(0).getPuuid()).isEqualTo(matchPerksVO.getPuuid());
        assertThat(matchPerksDtoList.get(0).getPrimaryStyle()).isEqualTo(matchPerksVO.getPrimaryStyle());
        assertThat(matchPerksDtoList.get(0).getPrimaryPerk1()).isEqualTo(matchPerksVO.getPrimaryPerk1());
        assertThat(matchPerksDtoList.get(0).getPrimaryPerk2()).isEqualTo(matchPerksVO.getPrimaryPerk2());
        assertThat(matchPerksDtoList.get(0).getPrimaryPerk3()).isEqualTo(matchPerksVO.getPrimaryPerk3());
        assertThat(matchPerksDtoList.get(0).getPrimaryPerk4()).isEqualTo(matchPerksVO.getPrimaryPerk4());
        assertThat(matchPerksDtoList.get(0).getSubStyle()).isEqualTo(matchPerksVO.getSubStyle());
        assertThat(matchPerksDtoList.get(0).getSubPerk1()).isEqualTo(matchPerksVO.getSubPerk1());
        assertThat(matchPerksDtoList.get(0).getSubPerk2()).isEqualTo(matchPerksVO.getSubPerk2());
        assertThat(matchPerksDtoList.get(0).getStatPerkDefense()).isEqualTo(matchPerksVO.getStatPerkDefense());
        assertThat(matchPerksDtoList.get(0).getStatPerkFlex()).isEqualTo(matchPerksVO.getStatPerkFlex());
        assertThat(matchPerksDtoList.get(0).getStatPerkOffense()).isEqualTo(matchPerksVO.getStatPerkOffense());
    }

    @Test
    @DisplayName("Convert MatchMaster VO List To MatchMaster Dto List")
    public void toMatchMasterDtoList() {
        //given
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
        String queueType = "일반";
        int teamId1 = 100;
        int teamId2 = 200;
        String tournamentCode = null;

        MatchMasterVO matchMasterVO = new MatchMasterVO(dataVersion,matchId,gameCreation,gameDuration,gameEndTimeStamp,gameId,gameMode,gameName,
                gameStartTimeStamp,gameType,gameVersion,mapId,platformId,queueId,queueType,teamId1,teamId2,tournamentCode);

        List<MatchMasterVO> matchMasterVOList = new ArrayList<>();

        matchMasterVOList.add(matchMasterVO);

        //when
        MatchMasterDto matchMasterDto = dtoMapper.toMatchMasterDtoList(matchMasterVOList).get(0);

        //then
        assertThat(matchMasterDto.getMatchId()).isEqualTo(matchId);
        assertThat(matchMasterDto.getDataVersion()).isEqualTo(dataVersion);
    }
}
