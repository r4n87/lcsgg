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

    @Test
    @DisplayName("Convert MatchObjectives VO To MatchObjectives Dto")
    public void toMatchObjectivesDto() {
        // given
        MatchObjectiveVO baron = new MatchObjectiveVO(true, 1);
        MatchObjectiveVO champion = new MatchObjectiveVO(false, 2);
        MatchObjectiveVO dragon = new MatchObjectiveVO(true, 3);
        MatchObjectiveVO inhibitor = new MatchObjectiveVO(false, 4);
        MatchObjectiveVO riftHeraId = new MatchObjectiveVO(true, 5);
        MatchObjectiveVO tower = new MatchObjectiveVO(false, 6);
        MatchObjectivesVO matchObjectivesVO = new MatchObjectivesVO(baron, champion, dragon, inhibitor,
                riftHeraId, tower);

        // when
        MatchObjectivesDto matchObjectivesDto = dtoMapper.toMatchObjectivesDto(matchObjectivesVO);

        // then
        assertThat(matchObjectivesDto.getBaron().isFirst()).isEqualTo(baron.isFirst());
        assertThat(matchObjectivesDto.getBaron().getKills()).isEqualTo(baron.getKills());
        assertThat(matchObjectivesDto.getChampion().isFirst()).isEqualTo(champion.isFirst());
        assertThat(matchObjectivesDto.getChampion().getKills()).isEqualTo(champion.getKills());
        assertThat(matchObjectivesDto.getDragon().isFirst()).isEqualTo(dragon.isFirst());
        assertThat(matchObjectivesDto.getDragon().getKills()).isEqualTo(dragon.getKills());
        assertThat(matchObjectivesDto.getInhibitor().isFirst()).isEqualTo(inhibitor.isFirst());
        assertThat(matchObjectivesDto.getInhibitor().getKills()).isEqualTo(inhibitor.getKills());
        assertThat(matchObjectivesDto.getRiftHeraId().isFirst()).isEqualTo(riftHeraId.isFirst());
        assertThat(matchObjectivesDto.getRiftHeraId().getKills()).isEqualTo(riftHeraId.getKills());
        assertThat(matchObjectivesDto.getTower().isFirst()).isEqualTo(tower.isFirst());
        assertThat(matchObjectivesDto.getTower().getKills()).isEqualTo(tower.getKills());
    }

    @Test
    @DisplayName("Convert MatchObjectives VO List To MatchObjectives Dto List")
    public void toMatchObjectivesDtoList() {
        // given
        MatchObjectiveVO baron = new MatchObjectiveVO(true, 1);
        MatchObjectiveVO champion = new MatchObjectiveVO(false, 2);
        MatchObjectiveVO dragon = new MatchObjectiveVO(true, 3);
        MatchObjectiveVO inhibitor = new MatchObjectiveVO(false, 4);
        MatchObjectiveVO riftHeraId = new MatchObjectiveVO(true, 5);
        MatchObjectiveVO tower = new MatchObjectiveVO(false, 6);
        MatchObjectivesVO matchObjectivesVO = new MatchObjectivesVO(baron, champion, dragon, inhibitor,
                riftHeraId, tower);
        List<MatchObjectivesVO> matchObjectivesVOList = new ArrayList<>();
        matchObjectivesVOList.add(matchObjectivesVO);

        // when
        MatchObjectivesDto matchObjectivesDto = dtoMapper.toMatchObjectivesDtoList(matchObjectivesVOList).get(0);

        // then
        assertThat(matchObjectivesDto.getBaron().isFirst()).isEqualTo(baron.isFirst());
        assertThat(matchObjectivesDto.getBaron().getKills()).isEqualTo(baron.getKills());
        assertThat(matchObjectivesDto.getChampion().isFirst()).isEqualTo(champion.isFirst());
        assertThat(matchObjectivesDto.getChampion().getKills()).isEqualTo(champion.getKills());
        assertThat(matchObjectivesDto.getDragon().isFirst()).isEqualTo(dragon.isFirst());
        assertThat(matchObjectivesDto.getDragon().getKills()).isEqualTo(dragon.getKills());
        assertThat(matchObjectivesDto.getInhibitor().isFirst()).isEqualTo(inhibitor.isFirst());
        assertThat(matchObjectivesDto.getInhibitor().getKills()).isEqualTo(inhibitor.getKills());
        assertThat(matchObjectivesDto.getRiftHeraId().isFirst()).isEqualTo(riftHeraId.isFirst());
        assertThat(matchObjectivesDto.getRiftHeraId().getKills()).isEqualTo(riftHeraId.getKills());
        assertThat(matchObjectivesDto.getTower().isFirst()).isEqualTo(tower.isFirst());
        assertThat(matchObjectivesDto.getTower().getKills()).isEqualTo(tower.getKills());
    }

    @Test
    @DisplayName("Convert MatchTeam VO List To MatchTeam Dto List")
    public void toMatchTeamDtoList() {
        // given
        List<MatchTeamVO> matchTeamVOList = new ArrayList<>();

        // 1) MatchBanVO List
        String matchId = "KR_5804413147";
        int pickTurn = 1;
        int teamId = 100;
        int championId = 99;
        MatchBanVO matchBanVO = new MatchBanVO(matchId,pickTurn,teamId,championId);
        List<MatchBanVO> matchBanVOList = new ArrayList<>();
        matchBanVOList.add(matchBanVO);

        // 2) MatchObjectivesVO
        MatchObjectiveVO baron = new MatchObjectiveVO(true, 1);
        MatchObjectiveVO champion = new MatchObjectiveVO(false, 2);
        MatchObjectiveVO dragon = new MatchObjectiveVO(true, 3);
        MatchObjectiveVO inhibitor = new MatchObjectiveVO(false, 4);
        MatchObjectiveVO riftHeraId = new MatchObjectiveVO(true, 5);
        MatchObjectiveVO tower = new MatchObjectiveVO(false, 6);
        MatchObjectivesVO matchObjectivesVO = new MatchObjectivesVO(baron, champion, dragon, inhibitor,
                riftHeraId, tower);

        String win = "true";
        int teamKills = 99;

        // 3) MatchParticipantVO List
        // TODO
        MatchParticipantVO matchParticipantVO = createMatchParticipantVO();
        List<MatchParticipantVO> matchParticipantVOList = new ArrayList<>();
        matchParticipantVOList.add(matchParticipantVO);

        MatchTeamVO matchTeamVO = new MatchTeamVO(matchBanVOList, matchObjectivesVO, String.valueOf(teamId), win, teamKills, matchParticipantVOList);
        matchTeamVOList.add(matchTeamVO);

        // when
        MatchTeamDto matchTeamDto = dtoMapper.toMatchTeamDtoList(matchTeamVOList).get(0);

        // then
        assertThat(matchTeamDto.getBans().get(0).getMatchId()).isEqualTo(matchId);
        assertThat(matchTeamDto.getBans().get(0).getPickTurn()).isEqualTo(pickTurn);
        assertThat(matchTeamDto.getBans().get(0).getTeamId()).isEqualTo(teamId);
        assertThat(matchTeamDto.getBans().get(0).getChampionId()).isEqualTo(championId);
        assertThat(matchTeamDto.getObjectives().getBaron().isFirst()).isEqualTo(baron.isFirst());
        assertThat(matchTeamDto.getObjectives().getBaron().getKills()).isEqualTo(baron.getKills());
        assertThat(matchTeamDto.getObjectives().getChampion().isFirst()).isEqualTo(champion.isFirst());
        assertThat(matchTeamDto.getObjectives().getChampion().getKills()).isEqualTo(champion.getKills());
        assertThat(matchTeamDto.getObjectives().getDragon().isFirst()).isEqualTo(dragon.isFirst());
        assertThat(matchTeamDto.getObjectives().getDragon().getKills()).isEqualTo(dragon.getKills());
        assertThat(matchTeamDto.getObjectives().getInhibitor().isFirst()).isEqualTo(inhibitor.isFirst());
        assertThat(matchTeamDto.getObjectives().getInhibitor().getKills()).isEqualTo(inhibitor.getKills());
        assertThat(matchTeamDto.getObjectives().getRiftHeraId().isFirst()).isEqualTo(riftHeraId.isFirst());
        assertThat(matchTeamDto.getObjectives().getRiftHeraId().getKills()).isEqualTo(riftHeraId.getKills());
        assertThat(matchTeamDto.getObjectives().getTower().isFirst()).isEqualTo(tower.isFirst());
        assertThat(matchTeamDto.getObjectives().getTower().getKills()).isEqualTo(tower.getKills());
        assertThat(matchTeamDto.getTeamId()).isEqualTo(String.valueOf(teamId));
        assertThat(matchTeamDto.getWin()).isEqualTo(win);
        assertThat(matchTeamDto.getTeamKills()).isEqualTo(teamKills);

        assertThat(matchTeamDto.getParticipants().get(0).getPuuid()).isEqualTo(matchParticipantVO.getPuuid());
        assertThat(matchTeamDto.getParticipants().get(0).getDataVersion()).isEqualTo(matchParticipantVO.getDataVersion());
        assertThat(matchTeamDto.getParticipants().get(0).getMatchId()).isEqualTo(matchParticipantVO.getMatchId());
        assertThat(matchTeamDto.getParticipants().get(0).getParticipantId()).isEqualTo(
                String.valueOf(matchParticipantVO.getParticipantId()));
        assertThat(matchTeamDto.getParticipants().get(0).getAssists()).isEqualTo(
                String.valueOf(matchParticipantVO.getAssists()));
        assertThat(matchTeamDto.getParticipants().get(0).getBaronKills()).isEqualTo(
                String.valueOf(matchParticipantVO.getBaronKills()));
        assertThat(matchTeamDto.getParticipants().get(0).getBountyLevel()).isEqualTo(
                String.valueOf(matchParticipantVO.getBountyLevel()));
        assertThat(matchTeamDto.getParticipants().get(0).getChampExperience()).isEqualTo(
                String.valueOf(matchParticipantVO.getChampExperience()));
        assertThat(matchTeamDto.getParticipants().get(0).getChampLevel()).isEqualTo(
                String.valueOf(matchParticipantVO.getChampLevel()));
        assertThat(matchTeamDto.getParticipants().get(0).getChampionId()).isEqualTo(
                String.valueOf(matchParticipantVO.getChampionId()));
        assertThat(matchTeamDto.getParticipants().get(0).getChampionName()).isEqualTo(
                String.valueOf(matchParticipantVO.getChampionName()));
        assertThat(matchTeamDto.getParticipants().get(0).getChampionNameKR()).isEqualTo(
                String.valueOf(matchParticipantVO.getChampionNameKR()));
        assertThat(matchTeamDto.getParticipants().get(0).getChampionImg()).isEqualTo(
                String.valueOf(matchParticipantVO.getChampionImg()));
        assertThat(matchTeamDto.getParticipants().get(0).getChampionTransform()).isEqualTo(
                String.valueOf(matchParticipantVO.getChampionTransform()));
        assertThat(matchTeamDto.getParticipants().get(0).getConsumablesPurchased()).isEqualTo(
                String.valueOf(matchParticipantVO.getConsumablesPurchased()));
        assertThat(matchTeamDto.getParticipants().get(0).getDamageDealtToBuildings()).isEqualTo(
                String.valueOf(matchParticipantVO.getDamageDealtToBuildings()));
        assertThat(matchTeamDto.getParticipants().get(0).getDamageDealtToObjectives()).isEqualTo(
                String.valueOf(matchParticipantVO.getDamageDealtToObjectives()));
        assertThat(matchTeamDto.getParticipants().get(0).getDamageSelfMitigated()).isEqualTo(
                String.valueOf(matchParticipantVO.getDamageSelfMitigated()));
        assertThat(matchTeamDto.getParticipants().get(0).getDeaths()).isEqualTo(
                String.valueOf(matchParticipantVO.getDeaths()));
        assertThat(matchTeamDto.getParticipants().get(0).getDetectorWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantVO.getDetectorWardsPlaced()));
        assertThat(matchTeamDto.getParticipants().get(0).getDoubleKills()).isEqualTo(
                String.valueOf(matchParticipantVO.getDoubleKills()));
        assertThat(matchTeamDto.getParticipants().get(0).getDragonKills()).isEqualTo(
                String.valueOf(matchParticipantVO.getDragonKills()));
        assertThat(matchTeamDto.getParticipants().get(0).getFirstBloodAssist()).isEqualTo(
                String.valueOf(matchParticipantVO.isFirstBloodAssist()));
        assertThat(matchTeamDto.getParticipants().get(0).getFirstBloodKill()).isEqualTo(
                String.valueOf(matchParticipantVO.isFirstBloodKill()));
        assertThat(matchTeamDto.getParticipants().get(0).getFirstTowerAssist()).isEqualTo(
                String.valueOf(matchParticipantVO.isFirstTowerAssist()));
        assertThat(matchTeamDto.getParticipants().get(0).getFirstTowerKill()).isEqualTo(
                String.valueOf(matchParticipantVO.isFirstTowerKill()));
        assertThat(matchTeamDto.getParticipants().get(0).getGameEndedInEarlySurrender()).isEqualTo(
                String.valueOf(matchParticipantVO.isGameEndedInEarlySurrender()));
        assertThat(matchTeamDto.getParticipants().get(0).getGameEndedInSurrender()).isEqualTo(
                String.valueOf(matchParticipantVO.isGameEndedInSurrender()));
        assertThat(matchTeamDto.getParticipants().get(0).getGoldEarned()).isEqualTo(
                String.valueOf(matchParticipantVO.getGoldEarned()));
        assertThat(matchTeamDto.getParticipants().get(0).getGoldSpent()).isEqualTo(
                String.valueOf(matchParticipantVO.getGoldSpent()));
        assertThat(matchTeamDto.getParticipants().get(0).getIndividualPosition()).isEqualTo(
                matchParticipantVO.getIndividualPosition());
        assertThat(matchTeamDto.getParticipants().get(0).getInhibitorKills()).isEqualTo(
                String.valueOf(matchParticipantVO.getInhibitorKills()));
        assertThat(matchTeamDto.getParticipants().get(0).getInhibitorTakedowns()).isEqualTo(
                String.valueOf(matchParticipantVO.getInhibitorTakedowns()));
        assertThat(matchTeamDto.getParticipants().get(0).getInhibitorsLost()).isEqualTo(
                String.valueOf(matchParticipantVO.getInhibitorsLost()));
        assertThat(matchTeamDto.getParticipants().get(0).getItem0()).isEqualTo(
                String.valueOf(matchParticipantVO.getItem0()));
        assertThat(matchTeamDto.getParticipants().get(0).getItem1()).isEqualTo(
                String.valueOf(matchParticipantVO.getItem1()));
        assertThat(matchTeamDto.getParticipants().get(0).getItem2()).isEqualTo(
                String.valueOf(matchParticipantVO.getItem2()));
        assertThat(matchTeamDto.getParticipants().get(0).getItem3()).isEqualTo(
                String.valueOf(matchParticipantVO.getItem3()));
        assertThat(matchTeamDto.getParticipants().get(0).getItem4()).isEqualTo(
                String.valueOf(matchParticipantVO.getItem4()));
        assertThat(matchTeamDto.getParticipants().get(0).getItem5()).isEqualTo(
                String.valueOf(matchParticipantVO.getItem5()));
        assertThat(matchTeamDto.getParticipants().get(0).getItem6()).isEqualTo(
                String.valueOf(matchParticipantVO.getItem6()));
        assertThat(matchTeamDto.getParticipants().get(0).getItemsPurchased()).isEqualTo(
                String.valueOf(matchParticipantVO.getItemsPurchased()));
        assertThat(matchTeamDto.getParticipants().get(0).getKillingSprees()).isEqualTo(
                String.valueOf(matchParticipantVO.getKillingSprees()));
        assertThat(matchTeamDto.getParticipants().get(0).getKills()).isEqualTo(
                String.valueOf(matchParticipantVO.getKills()));
        assertThat(matchTeamDto.getParticipants().get(0).getLane()).isEqualTo(
                matchParticipantVO.getLane());
        assertThat(matchTeamDto.getParticipants().get(0).getLargestCriticalStrike()).isEqualTo(
                String.valueOf(matchParticipantVO.getLargestCriticalStrike()));
        assertThat(matchTeamDto.getParticipants().get(0).getLargestKillingSpree()).isEqualTo(
                String.valueOf(matchParticipantVO.getLargestKillingSpree()));
        assertThat(matchTeamDto.getParticipants().get(0).getLongestTimeSpentLiving()).isEqualTo(
                String.valueOf(matchParticipantVO.getLongestTimeSpentLiving()));
        assertThat(matchTeamDto.getParticipants().get(0).getMagicDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantVO.getMagicDamageDealt()));
        assertThat(matchTeamDto.getParticipants().get(0).getMagicDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantVO.getMagicDamageDealtToChampions()));
        assertThat(matchTeamDto.getParticipants().get(0).getMagicDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantVO.getMagicDamageTaken()));
        assertThat(matchTeamDto.getParticipants().get(0).getNeutralMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantVO.getNeutralMinionsKilled()));
        assertThat(matchTeamDto.getParticipants().get(0).getNexusKills()).isEqualTo(
                String.valueOf(matchParticipantVO.getNexusKills()));
        assertThat(matchTeamDto.getParticipants().get(0).getNexusLost()).isEqualTo(
                String.valueOf(matchParticipantVO.getNexusLost()));
        assertThat(matchTeamDto.getParticipants().get(0).getNexusTakedowns()).isEqualTo(
                String.valueOf(matchParticipantVO.getNexusTakedowns()));
        assertThat(matchTeamDto.getParticipants().get(0).getObjectivesStolen()).isEqualTo(
                String.valueOf(matchParticipantVO.getObjectivesStolen()));
        assertThat(matchTeamDto.getParticipants().get(0).getObjectivesStolenAssists()).isEqualTo(
                String.valueOf(matchParticipantVO.getObjectivesStolenAssists()));
        assertThat(matchTeamDto.getParticipants().get(0).getPentaKills()).isEqualTo(
                String.valueOf(matchParticipantVO.getPentaKills()));
        assertThat(matchTeamDto.getParticipants().get(0).getPhysicalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantVO.getPhysicalDamageDealt()));
        assertThat(matchTeamDto.getParticipants().get(0).getPhysicalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantVO.getPhysicalDamageDealtToChampions()));
        assertThat(matchTeamDto.getParticipants().get(0).getPhysicalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantVO.getPhysicalDamageTaken()));
        assertThat(matchTeamDto.getParticipants().get(0).getProfileIcon()).isEqualTo(
                String.valueOf(matchParticipantVO.getProfileIcon()));
        assertThat(matchTeamDto.getParticipants().get(0).getQuadraKills()).isEqualTo(
                String.valueOf(matchParticipantVO.getQuadraKills()));
        assertThat(matchTeamDto.getParticipants().get(0).getRiotIdName()).isEqualTo(
                matchParticipantVO.getRiotIdName());
        assertThat(matchTeamDto.getParticipants().get(0).getRiotIdTagline()).isEqualTo(
                matchParticipantVO.getRiotIdTagline());
        assertThat(matchTeamDto.getParticipants().get(0).getRole()).isEqualTo(
                matchParticipantVO.getRole());
        assertThat(matchTeamDto.getParticipants().get(0).getSightWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantVO.getSightWardsBoughtInGame()));
        assertThat(matchTeamDto.getParticipants().get(0).getSpell1Casts()).isEqualTo(
                String.valueOf(matchParticipantVO.getSpell1Casts()));
        assertThat(matchTeamDto.getParticipants().get(0).getSpell2Casts()).isEqualTo(
                String.valueOf(matchParticipantVO.getSpell2Casts()));
        assertThat(matchTeamDto.getParticipants().get(0).getSpell3Casts()).isEqualTo(
                String.valueOf(matchParticipantVO.getSpell3Casts()));
        assertThat(matchTeamDto.getParticipants().get(0).getSpell4Casts()).isEqualTo(
                String.valueOf(matchParticipantVO.getSpell4Casts()));
        assertThat(matchTeamDto.getParticipants().get(0).getSummoner1Casts()).isEqualTo(
                String.valueOf(matchParticipantVO.getSummoner1Casts()));
        assertThat(matchTeamDto.getParticipants().get(0).getSummoner1Id()).isEqualTo(
                String.valueOf(matchParticipantVO.getSummoner1Id()));
        assertThat(matchTeamDto.getParticipants().get(0).getSummoner2Casts()).isEqualTo(
                String.valueOf(matchParticipantVO.getSummoner2Casts()));
        assertThat(matchTeamDto.getParticipants().get(0).getSummoner2Id()).isEqualTo(
                String.valueOf(matchParticipantVO.getSummoner2Id()));
        assertThat(matchTeamDto.getParticipants().get(0).getSummonerId()).isEqualTo(
                matchParticipantVO.getSummonerId());
        assertThat(matchTeamDto.getParticipants().get(0).getSummonerLevel()).isEqualTo(
                String.valueOf(matchParticipantVO.getSummonerLevel()));
        assertThat(matchTeamDto.getParticipants().get(0).getSummonerName()).isEqualTo(
                matchParticipantVO.getPuuid().equals("BOT")
                        ? "(봇)" : matchParticipantVO.getSummonerName());
        assertThat(matchTeamDto.getParticipants().get(0).getTeamEarlySurrendered()).isEqualTo(
                String.valueOf(matchParticipantVO.isTeamEarlySurrendered()));
        assertThat(matchTeamDto.getParticipants().get(0).getTeamId()).isEqualTo(
                String.valueOf(matchParticipantVO.getTeamId()));
        assertThat(matchTeamDto.getParticipants().get(0).getTeamPosition()).isEqualTo(
                matchParticipantVO.getTeamPosition());
        assertThat(matchTeamDto.getParticipants().get(0).getTimeCCingOthers()).isEqualTo(
                String.valueOf(matchParticipantVO.getTimeCCingOthers()));
        assertThat(matchTeamDto.getParticipants().get(0).getTimePlayed()).isEqualTo(
                String.valueOf(matchParticipantVO.getTimePlayed()));
        assertThat(matchTeamDto.getParticipants().get(0).getTotalDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantVO.getTotalDamageDealt()));
        assertThat(matchTeamDto.getParticipants().get(0).getTotalDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantVO.getTotalDamageDealtToChampions()));
        assertThat(matchTeamDto.getParticipants().get(0).getTotalDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantVO.getTotalDamageTaken()));
        assertThat(matchTeamDto.getParticipants().get(0).getTotalHeal()).isEqualTo(
                String.valueOf(matchParticipantVO.getTotalHeal()));
        assertThat(matchTeamDto.getParticipants().get(0).getTotalHealsOnTeammates()).isEqualTo(
                String.valueOf(matchParticipantVO.getTotalHealsOnTeammates()));
        assertThat(matchTeamDto.getParticipants().get(0).getTotalMinionsKilled()).isEqualTo(
                String.valueOf(matchParticipantVO.getTotalMinionsKilled()));
        assertThat(matchTeamDto.getParticipants().get(0).getTotalTimeCCDealt()).isEqualTo(
                String.valueOf(matchParticipantVO.getTotalTimeCCDealt()));
        assertThat(matchTeamDto.getParticipants().get(0).getTotalTimeSpentDead()).isEqualTo(
                String.valueOf(matchParticipantVO.getTotalTimeSpentDead()));
        assertThat(matchTeamDto.getParticipants().get(0).getTotalUnitsHealed()).isEqualTo(
                String.valueOf(matchParticipantVO.getTotalUnitsHealed()));
        assertThat(matchTeamDto.getParticipants().get(0).getTripleKills()).isEqualTo(
                String.valueOf(matchParticipantVO.getTripleKills()));
        assertThat(matchTeamDto.getParticipants().get(0).getTrueDamageDealt()).isEqualTo(
                String.valueOf(matchParticipantVO.getTrueDamageDealt()));
        assertThat(matchTeamDto.getParticipants().get(0).getTrueDamageDealtToChampions()).isEqualTo(
                String.valueOf(matchParticipantVO.getTrueDamageDealtToChampions()));
        assertThat(matchTeamDto.getParticipants().get(0).getTrueDamageTaken()).isEqualTo(
                String.valueOf(matchParticipantVO.getTrueDamageTaken()));
        assertThat(matchTeamDto.getParticipants().get(0).getTurretKills()).isEqualTo(
                String.valueOf(matchParticipantVO.getTurretKills()));
        assertThat(matchTeamDto.getParticipants().get(0).getTurretTakedowns()).isEqualTo(
                String.valueOf(matchParticipantVO.getTurretTakedowns()));
        assertThat(matchTeamDto.getParticipants().get(0).getTurretsLost()).isEqualTo(
                String.valueOf(matchParticipantVO.getTurretsLost()));
        assertThat(matchTeamDto.getParticipants().get(0).getUnrealKills()).isEqualTo(
                String.valueOf(matchParticipantVO.getUnrealKills()));
        assertThat(matchTeamDto.getParticipants().get(0).getVisionScore()).isEqualTo(
                String.valueOf(matchParticipantVO.getVisionScore()));
        assertThat(matchTeamDto.getParticipants().get(0).getVisionWardsBoughtInGame()).isEqualTo(
                String.valueOf(matchParticipantVO.getVisionWardsBoughtInGame()));
        assertThat(matchTeamDto.getParticipants().get(0).getWardsKilled()).isEqualTo(
                String.valueOf(matchParticipantVO.getWardsKilled()));
        assertThat(matchTeamDto.getParticipants().get(0).getWardsPlaced()).isEqualTo(
                String.valueOf(matchParticipantVO.getWardsPlaced()));
        assertThat(matchTeamDto.getParticipants().get(0).getWin()).isEqualTo(
                String.valueOf(matchParticipantVO.isWin()));
        assertThat(matchTeamDto.getParticipants().get(0).getRrt()).isEqualTo(
                matchParticipantVO.getRrt());
        // TODO
//        assertThat(matchParticipantDto.getMultiKills()).isEqualTo(
//                matchParticipantVO.getMultiKills());
//        assertThat(matchParticipantDto.getKda()).isEqualTo(
//                matchParticipantVO.getKda());
//        assertThat(matchParticipantDto.getMinionsKilledPerMin()).isEqualTo(
//                matchParticipantVO.getMinionsKilledPerMin());
    }

    @Test
    @DisplayName("Convert Summoner VO List To Summoner Dto List")
    public void toSummonerDtoList() {
        // given
        List<SummonerVO> summonerVOList = new ArrayList<>();
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        SummonerVO summonerVO = new SummonerVO("yNr_v4gSrhBU8EhJ5edZpXGRjG_892njE-EGMaRLdSXyMY2RJHGDMoFsbv4eD--2aQvdruC0YqNY4g",
                "dAU3oF9-T5Rok7LzAwqhHDDTGiNNuvakeANcZcDWexPy",
                "qdDRYfl_uN6Pt7V-9kSwLGoc-jNfw0hjQj0n7XT1yVrLiA",
                "Hide on bush",
                "6",
                "1655406735000",
                "576",
                "0분 전",
                rrt.toInstant().getEpochSecond());
        summonerVOList.add(summonerVO);

        // when
        SummonerDto summonerDto = dtoMapper.toSummonerDtoList(summonerVOList).get(0);

        // then
        assertThat(summonerDto.getPuuid()).isEqualTo(summonerVO.getPuuid());
        assertThat(summonerDto.getAccountId()).isEqualTo(summonerVO.getAccountId());
        assertThat(summonerDto.getId()).isEqualTo(summonerVO.getId());
        assertThat(summonerDto.getName()).isEqualTo(summonerVO.getName());
        assertThat(summonerDto.getProfileIconId()).isEqualTo(summonerVO.getProfileIconId());
        assertThat(summonerDto.getRevisionDate()).isEqualTo(summonerVO.getRevisionDate());
        assertThat(summonerDto.getSummonerLevel()).isEqualTo(summonerVO.getSummonerLevel());
        assertThat(summonerDto.getLastRefreshTimeForUI()).isEqualTo(summonerVO.getLastRefreshTimeForUI());
        assertThat(summonerDto.getLastRefreshTimeForAPI()).isEqualTo(summonerVO.getLastRefreshTimeForAPI());
    }

    private MatchParticipantVO createMatchParticipantVO()
    {
        String puuid = "A1B2C3D4";
        String dataVersion = "2";
        String matchId = "AAAAAA";
        int participantId = 5;

        int assists = 6;
        int baronKills = 3;
        int bountyLevel = 6;
        int champExperience = 6;
        int champLevel = 10;
        int championId = 32;
        String championName = "Ezreal";
        String championNameKR = "이즈리얼";
        String championImg = "Ezreal.png";
        int championTransform = 0;
        int consumablesPurchased = 0;
        int damageDealtToBuildings = 562;
        int damageDealtToObjectives = 652;
        int damageDealtToTurrets = 424;
        int damageSelfMitigated = 456;
        int deaths = 3;
        int detectorWardsPlaced = 10;
        int doubleKills = 3;
        int dragonKills = 2;
        boolean firstBloodAssist = false;
        boolean firstBloodKill = true;
        boolean firstTowerAssist = false;
        boolean firstTowerKill = true;
        boolean gameEndedInEarlySurrender = false;
        boolean gameEndedInSurrender = true;
        int goldEarned = 5240;
        int goldSpent = 4270;
        String individualPosition = "BOTTOM";
        int inhibitorKills = 3;
        int inhibitorTakedowns = 6;
        int inhibitorsLost = 2;
        int item0 = 1;
        int item1 = 2;
        int item2 = 3;
        int item3 = 4;
        int item4 = 5;
        int item5 = 6;
        int item6 = 7;
        int itemsPurchased = 50;
        int killingSprees = 60;
        int kills = 7;
        String lane = "BOTTOM";
        int largestCriticalStrike = 5;
        int largestKillingSpree = 6;
        int largestMultiKill = 7;
        int longestTimeSpentLiving = 8;
        int magicDamageDealt = 9200;
        int magicDamageDealtToChampions = 6300;
        int magicDamageTaken = 5200;
        int neutralMinionsKilled = 52;
        int nexusKills = 3;
        int nexusTakedowns = 5;
        int nexusLost = 3;
        int objectivesStolen = 2;
        int objectivesStolenAssists = 1;
        int pentaKills = 1;
        int physicalDamageDealt = 12691;
        int physicalDamageDealtToChampions = 11591;
        int physicalDamageTaken = 6000;
        int profileIcon = 32;
        int quadraKills = 1;
        String riotIdName = "HIROO";
        String riotIdTagline = "HIROO321";
        String role = "HIHI";
        int sightWardsBoughtInGame = 5;
        int spell1Casts = 1;
        int spell2Casts = 2;
        int spell3Casts = 3;
        int spell4Casts = 4;
        int summoner1Casts = 5;
        String summoner1Id = "6";
        int summoner2Casts = 7;
        String summoner2Id = "8";
        String summonerId = "HelloSummoner";
        int summonerLevel = 10;
        String summonerName = "EZREALISGOD";
        boolean teamEarlySurrendered = false;
        int teamId = 100;
        String teamPosition = "RED";
        int timeCCingOthers = 5;
        int timePlayed = 10;
        int totalDamageDealt = 6000;
        int totalDamageDealtToChampions = 7000;
        int totalDamageShieldedOnTeammates = 8000;
        int totalDamageTaken = 9000;
        int totalHeal = 500;
        int totalHealsOnTeammates = 600;
        int totalMinionsKilled = 230;
        int totalTimeCCDealt = 100;
        int totalTimeSpentDead = 500;
        int totalUnitsHealed = 600;
        int tripleKills = 0;
        int trueDamageDealt = 18000;
        int trueDamageDealtToChampions = 17000;
        int trueDamageTaken = 16000;
        int turretKills = 3;
        int turretTakedowns = 60;
        int turretsLost = 2;
        int unrealKills = 1234;
        int visionScore = 10;
        int visionWardsBoughtInGame = 15;
        int wardsKilled = 6;
        int wardsPlaced = 1;
        boolean win = true;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        MatchParticipantVO matchParticipantVO = new MatchParticipantVO(
                puuid,
                dataVersion,
                matchId,
                participantId,
                assists,
                baronKills,
                bountyLevel,
                champExperience,
                champLevel,
                championId,
                championName,
                championNameKR,
                championImg,
                championTransform,
                consumablesPurchased,
                damageDealtToBuildings,
                damageDealtToObjectives,
                damageDealtToTurrets,
                damageSelfMitigated,
                deaths,
                detectorWardsPlaced,
                doubleKills,
                dragonKills,
                firstBloodAssist,
                firstBloodKill,
                firstTowerAssist,
                firstTowerKill,
                gameEndedInEarlySurrender,
                gameEndedInSurrender,
                goldEarned,
                goldSpent,
                individualPosition,
                inhibitorKills,
                inhibitorTakedowns,
                inhibitorsLost,
                item0,
                item1,
                item2,
                item3,
                item4,
                item5,
                item6,
                itemsPurchased,
                killingSprees,
                kills,
                lane,
                largestCriticalStrike,
                largestKillingSpree,
                largestMultiKill,
                longestTimeSpentLiving,
                magicDamageDealt,
                magicDamageDealtToChampions,
                magicDamageTaken,
                neutralMinionsKilled,
                nexusKills,
                nexusTakedowns,
                nexusLost,
                objectivesStolen,
                objectivesStolenAssists,
                pentaKills,
                physicalDamageDealt,
                physicalDamageDealtToChampions,
                physicalDamageTaken,
                profileIcon,
                quadraKills,
                riotIdName,
                riotIdTagline,
                role,
                sightWardsBoughtInGame,
                spell1Casts,
                spell2Casts,
                spell3Casts,
                spell4Casts,
                summoner1Casts,
                summoner1Id,
                summoner2Casts,
                summoner2Id,
                summonerId,
                summonerLevel,
                summonerName,
                teamEarlySurrendered,
                teamId,
                teamPosition,
                timeCCingOthers,
                timePlayed,
                totalDamageDealt,
                totalDamageDealtToChampions,
                totalDamageShieldedOnTeammates,
                totalDamageTaken,
                totalHeal,
                totalHealsOnTeammates,
                totalMinionsKilled,
                totalTimeCCDealt,
                totalTimeSpentDead,
                totalUnitsHealed,
                tripleKills,
                trueDamageDealt,
                trueDamageDealtToChampions,
                trueDamageTaken,
                turretKills,
                turretTakedowns,
                turretsLost,
                unrealKills,
                visionScore,
                visionWardsBoughtInGame,
                wardsKilled,
                wardsPlaced,
                win,
                rrt
        );

        return matchParticipantVO;

    }
}
