package dev.saariselka.inlol.facade;

import dev.saariselka.inlol.controller.*;
import dev.saariselka.inlol.dto.*;
import dev.saariselka.inlol.entity.*;
import dev.saariselka.inlol.repository.DdragonVersionRepository;
import dev.saariselka.inlol.service.MatchParticipantService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@SpringBootTest
@Transactional
public class DBFacadeTest {

    @Autowired
    DBFacade dbFacade;
    @Autowired
    SummonerSpellController summonerSpellController;
    @Autowired
    SummonerController summonerController;
    @Autowired
    ChampionController championController;
    @Autowired
    LeagueEntryController leagueEntryController;
    @Autowired
    LeagueMiniSeriesController leagueMiniSeriesController;
    @Autowired
    MatchParticipantService matchParticipantService;
    @Autowired
    DdragonVersionRepository ddragonVersionRepository;
    @Autowired
    SummonerPerkController summonerPerkController;


    @Test
    @DisplayName("Find SummonerDto By SummonerName When SummonerName is Null")
    public void getSummonerDtoBySummonerNameWhenSummonerNameIsNull() {
        //given
        String name = null;

        //when
        SummonerDto summonerDto = dbFacade.getSummonerDtoBySummonerName(name);

        //then
        assertThat(summonerDto).isNull();
    }

    @Test
    @DisplayName("Find SummonerDto By SummonerName When SummonerName is Not Null")
    public void getSummonerDtoBySummonerNameWhenSummonerNameIsNotNull() {
        //given
        String name = "Petaluma";

        //when
        SummonerDto summonerDto = dbFacade.getSummonerDtoBySummonerName(name);

        //then
        assertThat(summonerDto).isNotNull();
    }

    @Test
    @DisplayName("Find SummonerDto By SummonerName When Invalid SummonerName")
    public void getSummonerDtoBySummonerNameWhenInvalidSummonerName() {
        //given
        String name = "A";

        //when
        SummonerDto summonerDto = dbFacade.getSummonerDtoBySummonerName(name);

        //then
        assertThat(summonerDto).isNull();
    }

    @Test
    @DisplayName("Find Summoner Puuid By SummonerName When SummonerName Is Null")
    public void getSummonerPuuidBySummonerNameWhenSummonerNameIsNull() {

        //given
        String name = null;

        //when
        String puuid = dbFacade.getSummonerPuuidBySummonerName(name);

        //then
        assertThat(puuid).isNull();
    }

    @Test
    @DisplayName("Find Summoner Puuid By SummonerName When SummonerName Is Not Null")
    public void getSummonerPuuidBySummonerNameWhenSummonerNameIsNotNull() {

        //given
        String name = "Petaluma";

        //when
        String puuid = dbFacade.getSummonerPuuidBySummonerName(name);

        //then
        assertThat(puuid).isNotNull();
    }

    @Test
    @DisplayName("Find Summoner Puuid By SummonerName When SummonerName Is Not Null")
    public void getSummonerPuuidBySummonerNameWhenInvalidSummonerName() {

        //given
        String name = "A";

        //when
        String puuid = dbFacade.getSummonerPuuidBySummonerName(name);

        //then
        assertThat(puuid).isNull();
    }

    @Test
    @DisplayName("Save SummonerSpell")
    public void setSummonerSpell()
    {
        // given
        String name = "testSummonerSpellName";
        String description = "testSummonerSpellDesc";
        int spellKey = 0;
        String image = "testSummonerSpellImage";

        List<SummonerSpellDto> summonerSpellDtoList = new ArrayList<>();

        SummonerSpellDto summonerSpellDto = new SummonerSpellDto(name, description, spellKey, image);

        summonerSpellDtoList.add(summonerSpellDto);

        // when
        dbFacade.setSummonerSpell(summonerSpellDtoList);

        // then
        SummonerSpellDto summonerSpellDtoSaved = summonerSpellController.getSummonerSpellByKey(spellKey).get(0);

        assertThat(spellKey).isEqualTo(summonerSpellDtoSaved.getSpellKey());
        assertThat(summonerSpellDtoSaved.getSpellKey()).isNotNull();
    }

    @Test
    @DisplayName("Find SummonerSpellImage By SummonerSpellKey")
    public void getSummonerSpellByKey()
    {
        //given
        String summonerSpellNameBarrier = "방어막";
        String summonerSpellNameBooster = "점멸";
        String summonerSpellDescBarrier = "2초 동안 방어막으로 감싸 피해를 115~455(챔피언 레벨에 따라 변동)만큼 흡수합니다.";
        String summonerSpellDescBooster = "챔피언에 걸린 모든 이동 불가와 (제압 및 공중으로 띄우는 효과 제외) 소환사 주문에 의한 해로운 효과를 제거하고 새로 적용되는 이동 불가 효과들의 지속시간을 3초간 65% 감소시킵니다.";
        int summonerSpellKeyBarrier = 21;
        int summonerSpellKeyBooster = 1;
        String summonerSpellImageBarrier = "SummonerBarrier.png";
        String summonerSpellImageBooster = "SummonerBoost.png";

        summonerSpellController.insertSummonerSpell(summonerSpellNameBarrier, summonerSpellDescBarrier, summonerSpellKeyBarrier, summonerSpellImageBarrier);
        summonerSpellController.insertSummonerSpell(summonerSpellNameBooster, summonerSpellDescBooster, summonerSpellKeyBooster, summonerSpellImageBooster);

        //when
        String summonerSpellImageBarrierFind = dbFacade.getSummonerSpellImageByKey(summonerSpellKeyBarrier);
        String summonerSpellImageBoosterFind = dbFacade.getSummonerSpellImageByKey(summonerSpellKeyBooster);

        //then
        assertThat(summonerSpellImageBarrierFind).isEqualTo("SummonerBarrier.png");
        assertThat(summonerSpellImageBoosterFind).isEqualTo("SummonerBoost.png");
    }

    @Test
    @DisplayName("Save Champions")
    public void setChampions() {
        // given
        List<ChampionDto> dtoList = new ArrayList<>();
        ChampionDto dto1 = new ChampionDto(999, "champion1", "챔피언1", "Test1.png");
        ChampionDto dto2 = new ChampionDto(998, "champion2", "챔피언2", "Test2.png");
        dtoList.add(dto1);
        dtoList.add(dto2);

        // when
        dbFacade.setChampions(dtoList);
        String findKo1 = championController.getNameKoByNameEng("champion1");
        String findImg1 = championController.getImagePathByNameEng("champion1");
        String findKo2 = championController.getNameKoByNameEng("champion2");
        String findImg2 = championController.getImagePathByNameEng("champion2");

        // then
        assertThat(findKo1).isEqualTo("챔피언1");
        assertThat(findImg1).isEqualTo("Test1.png");
        assertThat(findKo2).isEqualTo("챔피언2");
        assertThat(findImg2).isEqualTo("Test2.png");
    }

    @Test
    @DisplayName("Save SummonerInfo")
    public void setSummonerInfo() {
        // given
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("id", "TestId");
        map.put("accountId", "TestAccountId");
        map.put("puuid", "TestPuuid");
        map.put("name", "TestUser");
        map.put("profileIconId", "9999");
        map.put("revisionDate", "888888888");
        map.put("summonerLevel", "999");

        // when
        dbFacade.setSummonerInfo(map);
        SummonerEntity entity = summonerController.getSummoner("TestPuuid").get(0);

        // then
        assertThat(entity.getId()).isEqualTo("TestId");
        assertThat(entity.getAccountid()).isEqualTo("TestAccountId");
        assertThat(entity.getPuuid()).isEqualTo("TestPuuid");
        assertThat(entity.getName()).isEqualTo("TestUser");
        assertThat(entity.getProfileiconid()).isEqualTo(9999);
        assertThat(entity.getRevisiondate()).isEqualTo(888888888L);
        assertThat(entity.getSummonerlevel()).isEqualTo(999L);
    }

    @Test
    @DisplayName("Save LeagueInfo When Solo Rank & No MiniSeries")
    void setLeagueInfoWhenSoloRankAndNoMiniSeries() {
        // given
        HashSet<Object> leagueInfos = createSummonerInfoWhenNoMiniSeries("RANKED_SOLO_5x5");

        // when
        dbFacade.setLeagueInfo(leagueInfos);
        LeagueEntryDto find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId").get(0);

        // then
        assertThat(find.getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(find.getQueueType()).isEqualTo("RANKED_SOLO_5x5");
        assertThat(find.getLeagueId()).isEqualTo("TestLeagueId");
        assertThat(find.getSummonerName()).isEqualTo("TestUser");
        assertThat(find.getTier()).isEqualTo("TestTier");
        assertThat(find.getRank()).isEqualTo("II");
        assertThat(find.getLeaguePoints()).isEqualTo(99);
        assertThat(find.getWins()).isEqualTo(0);
        assertThat(find.getLosses()).isEqualTo(0);
        assertThat(find.isHotStreak()).isTrue();
        assertThat(find.isVeteran()).isFalse();
        assertThat(find.isFreshBlood()).isTrue();
        assertThat(find.isInactive()).isFalse();
    }

    @Test
    @DisplayName("Save LeagueInfo When 5x5 Rank & No MiniSeries")
    void setLeagueInfoWhen55RankAndNoMiniSeries() {
        // given
        HashSet<Object> leagueInfos = createSummonerInfoWhenNoMiniSeries("RANKED_FLEX_SR");

        // when
        dbFacade.setLeagueInfo(leagueInfos);
        LeagueEntryDto find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId").get(0);

        // then
        assertThat(find.getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(find.getQueueType()).isEqualTo("RANKED_FLEX_SR");
        assertThat(find.getLeagueId()).isEqualTo("TestLeagueId");
        assertThat(find.getSummonerName()).isEqualTo("TestUser");
        assertThat(find.getTier()).isEqualTo("TestTier");
        assertThat(find.getRank()).isEqualTo("II");
        assertThat(find.getLeaguePoints()).isEqualTo(99);
        assertThat(find.getWins()).isEqualTo(0);
        assertThat(find.getLosses()).isEqualTo(0);
        assertThat(find.isHotStreak()).isTrue();
        assertThat(find.isVeteran()).isFalse();
        assertThat(find.isFreshBlood()).isTrue();
        assertThat(find.isInactive()).isFalse();
    }

    @Test
    @DisplayName("Save LeagueInfo When ETC Rank & No MiniSeries")
    void setLeagueInfoWhenETCRankAndNoMiniSeries() {
        // given
        HashSet<Object> leagueInfos = createSummonerInfoWhenNoMiniSeries("TestType");


        // when
        dbFacade.setLeagueInfo(leagueInfos);
        List<LeagueEntryDto> find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId");

        // then
        assertThat(find.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Save LeagueInfo When Solo Rank & MiniSeries")
    void setLeagueInfoWhenSoloRankAndMiniSeries() {
        // given
        HashSet<Object> leagueInfos = createSummonerInfoWithMiniSeries("RANKED_SOLO_5x5");

        // when
        dbFacade.setLeagueInfo(leagueInfos);
        LeagueEntryDto find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId").get(0);
        LeagueMiniSeriesDto miniFind = leagueMiniSeriesController.getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId("TestSummonerId", "RANKED_SOLO_5x5");

        // then
        assertThat(find.getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(find.getQueueType()).isEqualTo("RANKED_SOLO_5x5");
        assertThat(find.getLeagueId()).isEqualTo("TestLeagueId");
        assertThat(find.getSummonerName()).isEqualTo("TestUser");
        assertThat(find.getTier()).isEqualTo("TestTier");
        assertThat(find.getRank()).isEqualTo("I");
        assertThat(find.getLeaguePoints()).isEqualTo(100);
        assertThat(find.getWins()).isEqualTo(2);
        assertThat(find.getLosses()).isEqualTo(1);
        assertThat(find.isHotStreak()).isTrue();
        assertThat(find.isVeteran()).isFalse();
        assertThat(find.isFreshBlood()).isTrue();
        assertThat(find.isInactive()).isFalse();
        assertThat(miniFind.getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(miniFind.getQueueType()).isEqualTo("RANKED_SOLO_5x5");
        assertThat(miniFind.getWins()).isEqualTo(2);
        assertThat(miniFind.getLosses()).isEqualTo(1);
        assertThat(miniFind.getTarget()).isEqualTo(3);
        assertThat(String.valueOf(miniFind.getProgress())).isEqualTo("ABCDE");
    }

    @Test
    @DisplayName("Save LeagueInfo When 5x5 Rank & MiniSeries")
    void setLeagueInfoWhen55RankAndMiniSeries() {
        // given
        HashSet<Object> leagueInfos = createSummonerInfoWithMiniSeries("RANKED_FLEX_SR");

        // when
        dbFacade.setLeagueInfo(leagueInfos);
        LeagueEntryDto find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId").get(0);
        LeagueMiniSeriesDto miniFind = leagueMiniSeriesController.getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId("TestSummonerId", "RANKED_FLEX_SR");

        // then
        assertThat(find.getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(find.getQueueType()).isEqualTo("RANKED_FLEX_SR");
        assertThat(find.getLeagueId()).isEqualTo("TestLeagueId");
        assertThat(find.getSummonerName()).isEqualTo("TestUser");
        assertThat(find.getTier()).isEqualTo("TestTier");
        assertThat(find.getRank()).isEqualTo("I");
        assertThat(find.getLeaguePoints()).isEqualTo(100);
        assertThat(find.getWins()).isEqualTo(2);
        assertThat(find.getLosses()).isEqualTo(1);
        assertThat(find.isHotStreak()).isTrue();
        assertThat(find.isVeteran()).isFalse();
        assertThat(find.isFreshBlood()).isTrue();
        assertThat(find.isInactive()).isFalse();
        assertThat(miniFind.getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(miniFind.getQueueType()).isEqualTo("RANKED_FLEX_SR");
        assertThat(miniFind.getWins()).isEqualTo(2);
        assertThat(miniFind.getLosses()).isEqualTo(1);
        assertThat(miniFind.getTarget()).isEqualTo(3);
        assertThat(String.valueOf(miniFind.getProgress())).isEqualTo("ABCDE");
    }

    @Test
    @DisplayName("Save LeagueInfo When ETC Rank & MiniSeries")
    void setLeagueInfoWhenETCRankAndMiniSeries() {
        // given
        HashSet<Object> leagueInfos = createSummonerInfoWhenNoMiniSeries("TestType");


        // when
        dbFacade.setLeagueInfo(leagueInfos);
        List<LeagueEntryDto> find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId");
        LeagueMiniSeriesDto miniFind = leagueMiniSeriesController.getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId("TestSummonerId", "TestType");

        // then
        assertThat(find.isEmpty()).isTrue();
        assertThat(miniFind.getSummonerId()).isNull();
    }

    @Test
    @DisplayName("Get MatchIdList By Summoner Puuid")
    void getMatchIdListBySummonerPuuid() {
        //given
        String puuid1 = "AAAAA";
        String puuid2 = "BBBBB";
        String dataVersion1 = "dv1";
        String dataVersion2 = "dv2";
        String dataVersion3 = "dv3";
        String matchId1 = "matchId1";
        String matchId2 = "matchId2";
        String matchId3 = "matchId3";
        int participantId1 = 1;
        int participantId2 = 2;
        int participantId3 = 3;

        matchParticipantService.insert(puuid1
                , dataVersion1
                , matchId1
                , 0, 0, 0, 0, 0, 0, "", "", ""
                , 0, 0,0, 0, 0, 0, 0,0, 0
                , 0, true, true, true, true, true, true
                , 0, 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                , 0, 0, 0, "", 0, 0, 0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0, 0
                , participantId1
                , 0, 0, 0, 0, 0, 0
                , "", "", "", 0, 0, 0, 0, 0, 0, ""
                , 0, "", "", 0, "", true, 0, "", 0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                , true, null);
        matchParticipantService.insert(puuid2
                , dataVersion2
                , matchId2
                , 0, 0, 0, 0, 0, 0, "", "", ""
                , 0, 0,0, 0, 0, 0, 0,0, 0
                , 0, true, true, true, true, true, true
                , 0, 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                , 0, 0, 0, "", 0, 0, 0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0, 0
                , participantId2
                , 0, 0, 0, 0, 0, 0
                , "", "", "", 0, 0, 0, 0, 0, 0, ""
                , 0, "", "", 0, "", true, 0, "", 0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                , true, null);
        matchParticipantService.insert(puuid1
                , dataVersion3
                , matchId3
                , 0, 0, 0, 0, 0, 0, "", "", ""
                , 0, 0,0, 0, 0, 0, 0,0, 0
                , 0, true, true, true, true, true, true
                , 0, 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                , 0, 0, 0, "", 0, 0, 0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0, 0
                , participantId3
                , 0, 0, 0, 0, 0, 0
                , "", "", "", 0, 0, 0, 0, 0, 0, ""
                , 0, "", "", 0, "", true, 0, "", 0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                , true, null);

        //when
        HashSet<String> matchIds = dbFacade.getMatchIdListBySummonerPuuid(puuid1);

        //then
        assertThat(matchIds.size()).isEqualTo(2);
        for (String matchId : matchIds) {
            assertThat(matchId).isNotEqualTo(matchId2);
        }
    }

    private HashSet<Object> createSummonerInfoWithMiniSeries(String queueType) {
        HashSet<Object> leagueInfos = new HashSet<>();
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        leagueInfos.add(data);
        data.put("summonerId", "TestSummonerId");
        data.put("queueType", queueType);
        data.put("leagueId", "TestLeagueId");
        data.put("summonerName", "TestUser");
        data.put("tier", "TestTier");
        data.put("rank", "I");
        data.put("leaguePoints", "100");
        data.put("wins", "2");
        data.put("losses", "1");
        data.put("hotStreak", "true");
        data.put("veteran", "false");
        data.put("freshBlood", "true");
        data.put("inactive", "false");

        LinkedHashMap<String, Object> miniSeriesData = new LinkedHashMap<>();
        data.put("miniSeries", miniSeriesData);
        miniSeriesData.put("losses", "1");
        miniSeriesData.put("target", "3");
        miniSeriesData.put("wins", "2");
        miniSeriesData.put("progress", "ABCDE");

        return leagueInfos;
    }

    private HashSet<Object> createSummonerInfoWhenNoMiniSeries(String queueType) {
        HashSet<Object> leagueInfos = new HashSet<>();
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        leagueInfos.add(data);
        data.put("summonerId", "TestSummonerId");
        data.put("queueType", queueType);
        data.put("leagueId", "TestLeagueId");
        data.put("summonerName", "TestUser");
        data.put("tier", "TestTier");
        data.put("rank", "II");
        data.put("leaguePoints", "99");
        data.put("wins", "0");
        data.put("losses", "0");
        data.put("hotStreak", "true");
        data.put("veteran", "false");
        data.put("freshBlood", "true");
        data.put("inactive", "false");

        return leagueInfos;
    }

    @Test
    @DisplayName("Get SummonerDto By SummonerPuuid")
    void getSummonerDtoBySummonerPuuid() {
        // given
        String id = "TestId";
        String accountId = "TestAccountId";
        String puuid = "TestPuuid";
        String name = "TestUser";
        int profileIconId = 9999;
        long revisionDate = 888888888L;
        long summonerLevel = 999L;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        // when
        summonerController.insertSummoner(accountId, profileIconId, revisionDate, name, id, summonerLevel, puuid, rrt);
        SummonerDto testDto = dbFacade.getSummonerDtoBySummonerPuuid(puuid);

        // then
        assertThat(testDto.getId()).isEqualTo("TestId");
        assertThat(testDto.getAccountId()).isEqualTo("TestAccountId");
        assertThat(testDto.getPuuid()).isEqualTo("TestPuuid");
        assertThat(testDto.getName()).isEqualTo("TestUser");
        assertThat(testDto.getProfileIconId()).isEqualTo("9999");
        assertThat(testDto.getRevisionDate()).isEqualTo("888888888");
        assertThat(testDto.getSummonerLevel()).isEqualTo("999");
    }

    @Test
    @DisplayName("Get LeagueEntryDtoList By SummonerId When No MiniSeries")
    void getLeagueEntryDtoListBySummonerIdWhenNoMiniSeries() {
        // given
        // 자유랭크 추가
        String summonerId = "TestSummonerId";
        String queueType = "RANKED_FLEX_SR";
        String leagueId = "TestLeagueId";
        String summonerName = "TestUser";
        String tier = "TestTier";
        String rank = "II";
        int leaguePoints = 99;
        int wins = 2;
        int losses = 1;
        boolean hotStreak = true;
        boolean veteran = false;
        boolean freshBlood = true;
        boolean inactive = false;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());
        String progress = "ABCDE";
        int target = 3;

        leagueEntryController.insertLeagueEntryInfo(summonerId, queueType, leagueId, summonerName, tier, rank,
                leaguePoints, wins, losses, hotStreak, veteran, freshBlood, inactive, rrt);

        leagueMiniSeriesController.insertLeagueMiniSeriesInfo(summonerId, queueType, losses, progress, target, wins, rrt);

        // 솔로랭크 추가
        String soloQueueType = "RANKED_SOLO_5x5";
        String soloLeagueId = "TestSoloLeagueId";
        String soloTier = "TestSoloTier";
        String soloRank = "III";
        int soloLeaguePoints = 100;
        int soloWins = 1;
        int soloLosses = 2;
        boolean soloHotStreak = false;
        boolean soloVeteran = true;
        boolean soloFreshBlood = false;
        boolean soloInactive = true;
        String soloProgress = "QWERT";

        leagueEntryController.insertLeagueEntryInfo(summonerId, soloQueueType, soloLeagueId, summonerName, soloTier, soloRank,
                soloLeaguePoints, soloWins, soloLosses, soloHotStreak, soloVeteran, soloFreshBlood, soloInactive, rrt);

        leagueMiniSeriesController.insertLeagueMiniSeriesInfo(summonerId, soloQueueType, soloLosses, soloProgress, target, soloWins, rrt);


        // when
        List<LeagueEntryDto> test = dbFacade.getLeagueEntryDtoListBySummonerId(summonerId);

        // then
        for(LeagueEntryDto dto : test) {
            if(dto.getMiniSeries() == null)
                fail("MiniSeries 에러 발생");

            if(dto.getQueueType().equals("RANKED_FLEX_SR"))
            {
                assertThat(dto.getSummonerId()).isEqualTo(summonerId);
                assertThat(dto.getQueueType()).isEqualTo(queueType);
                assertThat(dto.getLeagueId()).isEqualTo(leagueId);
                assertThat(dto.getSummonerName()).isEqualTo(summonerName);
                assertThat(dto.getTier()).isEqualTo(tier);
                assertThat(dto.getRank()).isEqualTo(rank);
                assertThat(dto.getLeaguePoints()).isEqualTo(leaguePoints);
                assertThat(dto.getWins()).isEqualTo(wins);
                assertThat(dto.getLosses()).isEqualTo(losses);
                assertThat(dto.isHotStreak()).isTrue();
                assertThat(dto.isVeteran()).isFalse();
                assertThat(dto.isFreshBlood()).isTrue();
                assertThat(dto.isInactive()).isFalse();
                assertThat(dto.getMiniSeries().getSummonerId()).isEqualTo(summonerId);
                assertThat(dto.getMiniSeries().getQueueType()).isEqualTo(queueType);
                assertThat(dto.getMiniSeries().getTarget()).isEqualTo(target);
                assertThat(String.valueOf(dto.getMiniSeries().getProgress())).isEqualTo(progress);
                assertThat(dto.getMiniSeries().getWins()).isEqualTo(wins);
                assertThat(dto.getMiniSeries().getLosses()).isEqualTo(losses);
            }
            else if(dto.getQueueType().equals("RANKED_SOLO_5x5"))
            {
                assertThat(dto.getSummonerId()).isEqualTo(summonerId);
                assertThat(dto.getQueueType()).isEqualTo(soloQueueType);
                assertThat(dto.getLeagueId()).isEqualTo(soloLeagueId);
                assertThat(dto.getSummonerName()).isEqualTo(summonerName);
                assertThat(dto.getTier()).isEqualTo(soloTier);
                assertThat(dto.getRank()).isEqualTo(soloRank);
                assertThat(dto.getLeaguePoints()).isEqualTo(soloLeaguePoints);
                assertThat(dto.getWins()).isEqualTo(soloWins);
                assertThat(dto.getLosses()).isEqualTo(soloLosses);
                assertThat(dto.isHotStreak()).isFalse();
                assertThat(dto.isVeteran()).isTrue();
                assertThat(dto.isFreshBlood()).isFalse();
                assertThat(dto.isInactive()).isTrue();
                assertThat(dto.getMiniSeries().getSummonerId()).isEqualTo(summonerId);
                assertThat(dto.getMiniSeries().getQueueType()).isEqualTo(soloQueueType);
                assertThat(dto.getMiniSeries().getTarget()).isEqualTo(target);
                assertThat(String.valueOf(dto.getMiniSeries().getProgress())).isEqualTo(soloProgress);
                assertThat(dto.getMiniSeries().getWins()).isEqualTo(soloWins);
                assertThat(dto.getMiniSeries().getLosses()).isEqualTo(soloLosses);
            }
            else {
                fail("허용되지 않은 queueType 발생");
            }
        }
    }

    @Test
    @DisplayName("Get LeagueEntryDtoList By SummonerId When Yes MiniSeries")
    void getLeagueEntryDtoListBySummonerIdWhenYesMiniSeries() {
        // given
        // 자유랭크 추가
        String summonerId = "TestSummonerId";
        String queueType = "RANKED_FLEX_SR";
        String leagueId = "TestLeagueId";
        String summonerName = "TestUser";
        String tier = "TestTier";
        String rank = "II";
        int leaguePoints = 100;
        int win = 0;
        int losses = 0;
        boolean hotStreak = true;
        boolean veteran = false;
        boolean freshBlood = true;
        boolean inactive = false;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        leagueEntryController.insertLeagueEntryInfo(summonerId, queueType, leagueId, summonerName, tier, rank,
                leaguePoints, win, losses, hotStreak, veteran, freshBlood, inactive, rrt);

        // 솔로랭크 추가
        String soloQueueType = "RANKED_SOLO_5x5";
        String soloLeagueId = "TestSoloLeagueId";
        String soloTier = "TestSoloTier";
        String soloRank = "III";
        int soloLeaguePoints = 90;
        win = 0;
        losses = 0;
        boolean soloHotStreak = false;
        boolean soloVeteran = true;
        boolean soloFreshBlood = false;
        boolean soloInactive = true;

        leagueEntryController.insertLeagueEntryInfo(summonerId, soloQueueType, soloLeagueId, summonerName, soloTier, soloRank,
                soloLeaguePoints, win, losses, soloHotStreak, soloVeteran, soloFreshBlood, soloInactive, rrt);

        // when
        List<LeagueEntryDto> test = dbFacade.getLeagueEntryDtoListBySummonerId(summonerId);

        // then
        for(LeagueEntryDto dto : test) {
            if(dto.getQueueType().equals("RANKED_FLEX_SR"))
            {
                assertThat(dto.getSummonerId()).isEqualTo(summonerId);
                assertThat(dto.getQueueType()).isEqualTo(queueType);
                assertThat(dto.getLeagueId()).isEqualTo(leagueId);
                assertThat(dto.getSummonerName()).isEqualTo(summonerName);
                assertThat(dto.getTier()).isEqualTo(tier);
                assertThat(dto.getRank()).isEqualTo(rank);
                assertThat(dto.getLeaguePoints()).isEqualTo(leaguePoints);
                assertThat(dto.getWins()).isEqualTo(win);
                assertThat(dto.getLosses()).isEqualTo(losses);
                assertThat(dto.isHotStreak()).isTrue();
                assertThat(dto.isVeteran()).isFalse();
                assertThat(dto.isFreshBlood()).isTrue();
                assertThat(dto.isInactive()).isFalse();
            }
            else if(dto.getQueueType().equals("RANKED_SOLO_5x5"))
            {
                assertThat(dto.getSummonerId()).isEqualTo(summonerId);
                assertThat(dto.getQueueType()).isEqualTo(soloQueueType);
                assertThat(dto.getLeagueId()).isEqualTo(soloLeagueId);
                assertThat(dto.getSummonerName()).isEqualTo(summonerName);
                assertThat(dto.getTier()).isEqualTo(soloTier);
                assertThat(dto.getRank()).isEqualTo(soloRank);
                assertThat(dto.getLeaguePoints()).isEqualTo(soloLeaguePoints);
                assertThat(dto.getWins()).isEqualTo(win);
                assertThat(dto.getLosses()).isEqualTo(losses);
                assertThat(dto.isHotStreak()).isFalse();
                assertThat(dto.isVeteran()).isTrue();
                assertThat(dto.isFreshBlood()).isFalse();
                assertThat(dto.isInactive()).isTrue();
            }
            else {
                fail("허용되지 않은 queueType 발생");
            }
        }
    }
    
    @Test
    @DisplayName("Find Current DdragonVersion")
    public void getCurrentDdragonVersion() {
        //given
        DdragonVersionEntity currentDdragonVersionEntity = ddragonVersionRepository.findByCurrent("Y").get(0);
        currentDdragonVersionEntity.setCurrent("N");
        ddragonVersionRepository.save(currentDdragonVersionEntity);

        String testVersion = "TestVersion";
        String testCurrent = "Y";

        ddragonVersionRepository.save(new DdragonVersionEntity(testVersion, testCurrent));

        //when
        String currentDdrgonVersion = dbFacade.getCurrentDdragonVersion();

        //then
        assertThat(currentDdrgonVersion).isEqualTo(testVersion);
    }

    @Test
    @DisplayName("Save Summoner Perk At DB")
    public void setSummonerPerk() {
        //given
        int perkId = 0;
        String nameEng = "TestPerk";
        String nameKor = "테스트데이터";
        String icon = "TestIcon";
        String description = "TestPerk";

        SummonerPerkEntity summonerPerkEntity = new SummonerPerkEntity(perkId, nameEng, nameKor, icon, description);
        List<SummonerPerkEntity> summonerPerkEntities = new ArrayList<>();
        summonerPerkEntities.add(summonerPerkEntity);

        //when
        dbFacade.setSummonerPerk(summonerPerkEntities);

        //then
        SummonerPerkEntity testPerkEntity = summonerPerkController.getSummonerPerkByPerkId(0).get(0);
        assertThat(perkId).isEqualTo(testPerkEntity.getPerkId());
        assertThat(nameEng).isEqualTo(testPerkEntity.getNameEng());
        assertThat(nameKor).isEqualTo(testPerkEntity.getNameKor());
        assertThat(icon).isEqualTo(testPerkEntity.getIcon());
        assertThat(description).isEqualTo(testPerkEntity.getDescription());
    }

    @Test
    @DisplayName("Get Last Refresh Time By Summoner Name")
    public void getLastRefreshTimeBySummonerName() {
        //given
        String puuid = "ABCDE";
        String accountId = "FGHIJ";
        String id = "KLMNO";
        String name = "PQRST";
        int profileIconId = 5678;
        long revisionDate = 123456L;
        long summonerLevel = 125L;
        Timestamp rrt = new Timestamp(System.currentTimeMillis());

        summonerController.insertSummoner(accountId
                                        , profileIconId
                                        , revisionDate
                                        , name
                                        , id
                                        , summonerLevel
                                        , puuid
                                        , rrt);

        //when
        long lastRefreshTime = dbFacade.getLastRefreshTimeBySummonerName(puuid);

        //then
        assertThat(lastRefreshTime).isEqualTo(rrt.toInstant().getEpochSecond());
    }
}
