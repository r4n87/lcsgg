package dev.saariselka.inlol.facade;

import dev.saariselka.inlol.controller.*;
import dev.saariselka.inlol.dto.SummonerDto;
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

        List<SummonerSpellEntity> summonerSpellEntities = new ArrayList<>();

        SummonerSpellEntity summonerSpellEntity = new SummonerSpellEntity(name, description, spellKey, image);

        summonerSpellEntities.add(summonerSpellEntity);

        // when
        dbFacade.setSummonerSpell(summonerSpellEntities);

        // then
        SummonerSpellEntity summonerSpellEntitySaved = summonerSpellController.getSummonerSpellByKey(spellKey).get(0);

        assertThat(spellKey).isEqualTo(summonerSpellEntitySaved.getSpellKey());
        assertThat(summonerSpellEntitySaved.getSpellKey()).isNotNull();
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
        List<ChampionEntity> entities = new ArrayList<>();
        ChampionEntity entity1 = new ChampionEntity(999, "champion1", "챔피언1", "Test1.png");
        ChampionEntity entity2 = new ChampionEntity(998, "champion2", "챔피언2", "Test2.png");
        entities.add(entity1);
        entities.add(entity2);

        // when
        dbFacade.setChampions(entities);
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
        LeagueEntryEntity find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId").get(0);

        // then
        assertThat(find.getLeagueEntryId().getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(find.getLeagueEntryId().getQueueType()).isEqualTo("RANKED_SOLO_5x5");
        assertThat(find.getLeagueId()).isEqualTo("TestLeagueId");
        assertThat(find.getSummonerName()).isEqualTo("TestUser");
        assertThat(find.getTier()).isEqualTo("TestTier");
        assertThat(find.getRanks()).isEqualTo("II");
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
        LeagueEntryEntity find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId").get(0);

        // then
        assertThat(find.getLeagueEntryId().getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(find.getLeagueEntryId().getQueueType()).isEqualTo("RANKED_FLEX_SR");
        assertThat(find.getLeagueId()).isEqualTo("TestLeagueId");
        assertThat(find.getSummonerName()).isEqualTo("TestUser");
        assertThat(find.getTier()).isEqualTo("TestTier");
        assertThat(find.getRanks()).isEqualTo("II");
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
        List<LeagueEntryEntity> find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId");

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
        LeagueEntryEntity find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId").get(0);
        LeagueMiniSeriesEntity miniFind = leagueMiniSeriesController.getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId("TestSummonerId", "RANKED_SOLO_5x5");

        // then
        assertThat(find.getLeagueEntryId().getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(find.getLeagueEntryId().getQueueType()).isEqualTo("RANKED_SOLO_5x5");
        assertThat(find.getLeagueId()).isEqualTo("TestLeagueId");
        assertThat(find.getSummonerName()).isEqualTo("TestUser");
        assertThat(find.getTier()).isEqualTo("TestTier");
        assertThat(find.getRanks()).isEqualTo("I");
        assertThat(find.getLeaguePoints()).isEqualTo(100);
        assertThat(find.getWins()).isEqualTo(2);
        assertThat(find.getLosses()).isEqualTo(1);
        assertThat(find.isHotStreak()).isTrue();
        assertThat(find.isVeteran()).isFalse();
        assertThat(find.isFreshBlood()).isTrue();
        assertThat(find.isInactive()).isFalse();
        assertThat(miniFind.getLeagueMiniSeriesId().getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(miniFind.getLeagueMiniSeriesId().getQueueType()).isEqualTo("RANKED_SOLO_5x5");
        assertThat(miniFind.getWins()).isEqualTo(2);
        assertThat(miniFind.getLosses()).isEqualTo(1);
        assertThat(miniFind.getTarget()).isEqualTo(3);
        assertThat(miniFind.getProgress()).isEqualTo("ABCDE");
    }

    @Test
    @DisplayName("Save LeagueInfo When 5x5 Rank & MiniSeries")
    void setLeagueInfoWhen55RankAndMiniSeries() {
        // given
        HashSet<Object> leagueInfos = createSummonerInfoWithMiniSeries("RANKED_FLEX_SR");

        // when
        dbFacade.setLeagueInfo(leagueInfos);
        LeagueEntryEntity find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId").get(0);
        LeagueMiniSeriesEntity miniFind = leagueMiniSeriesController.getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId("TestSummonerId", "RANKED_FLEX_SR");

        // then
        assertThat(find.getLeagueEntryId().getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(find.getLeagueEntryId().getQueueType()).isEqualTo("RANKED_FLEX_SR");
        assertThat(find.getLeagueId()).isEqualTo("TestLeagueId");
        assertThat(find.getSummonerName()).isEqualTo("TestUser");
        assertThat(find.getTier()).isEqualTo("TestTier");
        assertThat(find.getRanks()).isEqualTo("I");
        assertThat(find.getLeaguePoints()).isEqualTo(100);
        assertThat(find.getWins()).isEqualTo(2);
        assertThat(find.getLosses()).isEqualTo(1);
        assertThat(find.isHotStreak()).isTrue();
        assertThat(find.isVeteran()).isFalse();
        assertThat(find.isFreshBlood()).isTrue();
        assertThat(find.isInactive()).isFalse();
        assertThat(miniFind.getLeagueMiniSeriesId().getSummonerId()).isEqualTo("TestSummonerId");
        assertThat(miniFind.getLeagueMiniSeriesId().getQueueType()).isEqualTo("RANKED_FLEX_SR");
        assertThat(miniFind.getWins()).isEqualTo(2);
        assertThat(miniFind.getLosses()).isEqualTo(1);
        assertThat(miniFind.getTarget()).isEqualTo(3);
        assertThat(miniFind.getProgress()).isEqualTo("ABCDE");
    }

    @Test
    @DisplayName("Save LeagueInfo When ETC Rank & MiniSeries")
    void setLeagueInfoWhenETCRankAndMiniSeries() {
        // given
        HashSet<Object> leagueInfos = createSummonerInfoWhenNoMiniSeries("TestType");


        // when
        dbFacade.setLeagueInfo(leagueInfos);
        List<LeagueEntryEntity> find = leagueEntryController.getLeagueEntriesBySummonerId("TestSummonerId");
        LeagueMiniSeriesEntity miniFind = leagueMiniSeriesController.getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId("TestSummonerId", "TestType");

        // then
        assertThat(find.isEmpty()).isTrue();
        assertThat(miniFind).isNull();
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

        SummonerPerkEntity summonerPerkEntity = new SummonerPerkEntity(perkId,nameEng,nameKor,icon,description);
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
}
