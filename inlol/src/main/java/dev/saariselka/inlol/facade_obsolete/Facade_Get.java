package dev.saariselka.inlol.facade_obsolete;

import dev.saariselka.inlol.controller.*;
import dev.saariselka.inlol.dto.*;
import dev.saariselka.inlol.entity.*;
import dev.saariselka.inlol.utils.API;
import dev.saariselka.inlol.utils.JsonParserForLOL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.*;

@Service
public class Facade_Get {

    @Autowired
    APIController apiController;
    @Autowired
    APIKeyController apiKeyController;
    @Autowired
    SummonerController summonerController;
    @Autowired
    MatchMasterController matchMasterController;
    @Autowired
    TeamController teamController;
    @Autowired
    MatchParticipantController matchParticipantController;
    @Autowired
    MatchBanController matchBanController;
    @Autowired
    MatchObjectivesController matchObjectivesController;
    @Autowired
    LeagueEntryController leagueEntryController;
    @Autowired
    LeagueMiniSeriesController leagueMiniSeriesController;
    @Autowired
    MatchPerksController matchPerksController;
    @Autowired
    SummonerPerkController summonerPerkController;

    private final API api;
    private String apiKey;

    public Facade_Get()
    {
        api = new API();
    }

    public HashMap<String, Object> getMatchInfo(ArrayList<String> matchList, int i) {

        apiKey = apiKeyController.getAPIKeyByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri;
            uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIUrlByCategoryAndOperation("MATCH","GET_MATCH_BY_MATCHID")
                    + matchList.get(i)
                    + "?"
                    + "api_key=" + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, HashMap.class);


        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("error~");
            System.out.println(e);

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion~");
            System.out.println(e);
        }
        return result;
    }

    public ArrayList<MatchDto> getMatchInfoFromDB(String puuid) throws IOException {
        ArrayList<MatchDto> matchDtos = new ArrayList<>();

        List<MatchParticipantEntity> matchList = matchParticipantController.getMatchParticipantListByPuuid(puuid);

        if(0 == matchList.size()) return null;

        String matchId;
        String dataVersion;

        for(MatchParticipantEntity match : matchList) {
            MatchMasterEntity matchMasterEntity = matchMasterController.getMatchMasterByMatchId(match.getMatchParticipantId().getMatchId()).get(0);
            matchId = matchMasterEntity.getMatchMasterId().getMatchId();
            dataVersion = matchMasterEntity.getMatchMasterId().getDataVersion();

            //2. Team 정보 생성
            List<TeamEntity> teamEntityList = teamController.getTeams_ByMatchId(matchId);
            List<TeamDto> teamDtoList = new ArrayList<>();

            for(TeamEntity teamEntity : teamEntityList) {
                List<MatchBanEntity> matchBanEntityList = matchBanController.getBansByMatchBanIdAndTeamId(matchId, teamEntity.getTeamId().getTeamId());

                MatchObjectivesEntity matchObjectivesEntity = matchObjectivesController
                        .getMatchObjectives_ByMatchIdAndTeamId(matchId, teamEntity.getTeamId().getTeamId())
                        .get(0);

                List<BanDto> banDtoList = new ArrayList<>();

                for(MatchBanEntity matchBanEntity : matchBanEntityList) {
                    BanDto banDto = new BanDto(matchBanEntity);
                    banDtoList.add(banDto);
                }

                ObjectivesDto objectivesDto = new ObjectivesDto(matchObjectivesEntity);

                TeamDto teamDto = new TeamDto(teamEntity,banDtoList,objectivesDto);
                teamDtoList.add(teamDto);
            }

            //5. Match Participants 정보 생성
            List<MatchParticipantEntity> participantsList = matchParticipantController.getMatchParticipantListByDataVersionAndMatchId(dataVersion, matchId);
            List<ParticipantDto> blueParticipantDtoList = new ArrayList<>();
            List<ParticipantDto> redParticipantDtoList = new ArrayList<>();
            ParticipantDto summonerInfo = new ParticipantDto();

            for(MatchParticipantEntity participantEntity : participantsList) {
                List<MatchPerksEntity> perksList = matchPerksController.getMatchPerksListByMatchIdAndPuuid(matchId, participantEntity.getMatchParticipantId().getPuuid());
                MatchPerksEntity perksEntity = (0 == perksList.size())
                                                ? new MatchPerksEntity() : perksList.get(0);
                String primaryIconPath = summonerPerkController.getSummonerPerkByPerkId(perksEntity.getPrimaryPerk1()).get(0).getIcon();
                String subIconPath = summonerPerkController.getSummonerPerkByPerkId(perksEntity.getSubStyle()).get(0).getIcon();
                PerksDto perksDto = new PerksDto(perksEntity, primaryIconPath, subIconPath);
                ParticipantDto participantDto = new ParticipantDto(participantEntity, perksDto, matchMasterEntity.getGameDuration());

                if(puuid.equals(participantEntity.getMatchParticipantId().getPuuid())) {
                    summonerInfo = participantDto;
                    summonerInfo.setChampionNameKR(JsonParserForLOL.getKRChampionNameByENGChampionName(summonerInfo.getChampionNameENG()));
                }

                if("100".equals(participantDto.getTeamId())) {
                    blueParticipantDtoList.add(participantDto);
                } else if("200".equals(participantDto.getTeamId())) {
                    redParticipantDtoList.add(participantDto);
                }
            }

            sortParticipationDtoList(blueParticipantDtoList, redParticipantDtoList);

            MetadataDto metadataDto = new MetadataDto(matchMasterEntity,participantsList);
            InfoDto infoDto = new InfoDto(matchMasterEntity,teamDtoList,summonerInfo);

            MatchDto matchInfo = new MatchDto(metadataDto,infoDto);

            matchDtos.add(matchInfo);
        }

        return matchDtos;
    }

    private void sortParticipationDtoList(List<ParticipantDto> blueParticipantDtoList, List<ParticipantDto> redParticipantDtoList) {
        blueParticipantDtoList.sort((o1, o2) -> {
            int score1 = getScore(o1);
            int score2 = getScore(o2);

            return score2 - score1;
        });

        redParticipantDtoList.sort((o1, o2) -> {
            int score1 = getScore(o1);
            int score2 = getScore(o2);

            return score2 - score1;
        });
    }

    private int getScore(ParticipantDto participant) {
        int score = 0;

        switch(participant.getTeamPosition()) {
            case "TOP" : score = 5; break;
            case "JUNGLE" : score = 4; break;
            case "MIDDLE" : score = 3; break;
            case "BOTTOM" : score = 2; break;
            case "UTILITY" : score = 1; break;
        }
        return score;
    }

    public ArrayList<String> getMatchList(String name, long startTime) {
        apiKey = apiKeyController.getAPIKeyByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();
        ArrayList<String> matchList = new ArrayList<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIUrlByCategoryAndOperation("MATCH", "GET_MATCHES_BY_PUUID")
                    + summonerController.getSummoner_Puuid_ByName(name)
                    + "/ids?startTime=" + startTime + "&count=20&api_key="
                    + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, List.class);

            // parsing
            matchList = (ArrayList) result.get("body");
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body", e.getStatusText());
            System.out.println("get match list error");
            System.out.println(e);

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body", "get match list exception");
            System.out.println(e);
        }
        return matchList;
    }

    public HashSet<String> getMatchListFromDB(String puuid) {
        List<MatchParticipantEntity> list = matchParticipantController.getMatchParticipantListByPuuid(puuid);
        HashSet<String> matchList = new HashSet<>();

        for(MatchParticipantEntity entity : list) {
            matchList.add(entity.getMatchParticipantId().getMatchId());
        }

        return matchList;
    }


    public HashMap<String, Object> getSummonerInfo(String name) {

        apiKey = apiKeyController.getAPIKeyByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIUrlByCategoryAndOperation("SUMMONER","GET_PUUID_BY_NAME")
                    + name
                    + "?"+"api_key="
                    + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, Map.class);


        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("summoner info get error");
            System.out.println(e);

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "summoner info get exception");
            System.out.println(e);
        }
        return result;
    }

    public SummonerDto getSummonerInfoFromDB(String name) {
        String puuid = summonerController.getSummoner_Puuid_ByName(name);

        if(null == puuid) return null;

        SummonerEntity summonerEntity = summonerController.getSummoner(puuid).get(0);
        SummonerDto summonerDto = new SummonerDto(summonerEntity);

        return summonerDto;
    }

    public HashMap<String, Object> getLeagueInfo(String encryptedSummonerId) {
        apiKey = apiKeyController.getAPIKeyByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIUrlByCategoryAndOperation("LEAGUE","GET_LEAGUE_BY_ENCRYPTEDID")
                    + encryptedSummonerId
                    + "?"+"api_key="
                    + apiKey).build();

            // API 호출
            result = api.executeAPI(uri, Set.class);

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body", e.getStatusText());
            System.out.println("league info get error");
            System.out.println(e);

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body", "league info get exception");
            System.out.println(e);
        }
        return result;
    }

    public ArrayList<LeagueEntryDto> getLeagueInfoFromDB(String summonerId) {
        ArrayList<LeagueEntryDto> result = new ArrayList<>();

        List<LeagueEntryEntity> leagueEntryEntityList = leagueEntryController.getLeagueEntriesBySummonerId(summonerId);

        for(LeagueEntryEntity leagueEntryEntity : leagueEntryEntityList) {

            LeagueMiniSeriesEntity leagueMiniSeriesEntity = leagueMiniSeriesController.getLeagueMiniSeriesEntries_ByLeagueMiniSeriesId(summonerId,leagueEntryEntity.getLeagueEntryId().getQueueType());
            LeagueMiniSeriesDto leagueMiniSeriesDto = new LeagueMiniSeriesDto();

            if(leagueMiniSeriesEntity != null)
            {
                leagueMiniSeriesDto = new LeagueMiniSeriesDto(leagueMiniSeriesEntity);
            }

            LeagueEntryDto leagueEntryDto = new LeagueEntryDto(leagueEntryEntity, leagueMiniSeriesDto);
            result.add(leagueEntryDto);
        }

        return result;
    }

}
