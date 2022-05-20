package dev.saariselka.inlol;

import dev.saariselka.inlol.controller.*;
import dev.saariselka.inlol.dto.*;
import dev.saariselka.inlol.entity.*;
import dev.saariselka.inlol.util.JsonParserForLOL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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

    private API api;
    private String apiKey;

    public Facade_Get()
    {
        api = new API();
    }

    public HashMap<String, Object> getMatchInfo(ArrayList<String> matchList, int i) {

        apiKey = apiKeyController.getAPIKey_ByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri;
            uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("MATCH","GET_MATCH_BY_MATCHID")
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

    public ArrayList<MatchDto> getMatchInfoFromDB(String puuid) {
        ArrayList<MatchDto> matchDtos = new ArrayList<>();

        MetadataDto_Assembly metadataDto_assembly = new MetadataDto_Assembly();
        InfoDto_Assembly infoDto_assembly = new InfoDto_Assembly();
        BanDto_Assembly banDto_assembly = new BanDto_Assembly();
        ObjectivesDto_Assembly objectivesDto_assembly = new ObjectivesDto_Assembly();
        TeamDto_Assembly teamDto_assembly = new TeamDto_Assembly();
        MatchDto_Assembly matchDto_assembly = new MatchDto_Assembly();
        ParticipantDto_Assembly participantDto_assembly = new ParticipantDto_Assembly();

        List<MatchParticipantEntity> matchList = matchParticipantController.getMatchParticipantList_ByPuuid(puuid);

        if(0 == matchList.size()) return null;

        String matchId;
        String dataVersion;

        for(MatchParticipantEntity match : matchList) {
            MatchMasterEntity matchMasterEntity = matchMasterController.getMatchMaster_ByMatchId(match.getMatchParticipantId().getMatchId()).get(0);
            matchId = matchMasterEntity.getMatchMasterId().getMatchId();
            dataVersion = matchMasterEntity.getMatchMasterId().getDataVersion();

            MatchDto matchInfo = new MatchDto();
            MetadataDto metadataDto = new MetadataDto();
            InfoDto infoDto = new InfoDto();

            //2. Team 정보 생성
            List<TeamEntity> teamEntityList = teamController.getTeams_ByMatchId(matchId);
            List<TeamDto> teamDtoList = new ArrayList<>();

            for(TeamEntity teamEntity : teamEntityList) {
                List<MatchBanEntity> matchBanEntityList = matchBanController.getBans_ByMatchBanIdAndTeamId(matchId, teamEntity.getTeamId().getTeamId());

                MatchObjectivesEntity matchObjectivesEntity = matchObjectivesController
                        .getMatchObjectives_ByMatchIdAndTeamId(matchId, teamEntity.getTeamId().getTeamId())
                        .get(0);

                teamDtoList.add(teamDto_assembly.getTeamDto_byEntityAndDto(teamEntity
                                                                          ,banDto_assembly.getBanList_byEntity(matchBanEntityList)
                                                                          ,objectivesDto_assembly.getObjectivesDto_byEntity(matchObjectivesEntity)));
            }

            //5. Match Participants 정보 생성
            List<MatchParticipantEntity> participantsList = matchParticipantController.getMatchParticipantList_ByDataVersionAndMatchId(dataVersion, matchId);
            List<ParticipantDto> blueParticipantDtoList = new ArrayList<>();
            List<ParticipantDto> redParticipantDtoList = new ArrayList<>();
            ParticipantDto summonerInfo = new ParticipantDto();

            for(MatchParticipantEntity participantEntity : participantsList) {

                if(puuid.equals(participantEntity.getMatchParticipantId().getPuuid())) {
                    summonerInfo = participantDto_assembly.getParticipantDto_byEntity(participantEntity);
                }

                ParticipantDto participantDto = participantDto_assembly.getParticipantDto_byEntity(participantEntity);

                if("100".equals(participantDto.getTeamId())) {
                    blueParticipantDtoList.add(participantDto);
                } else if("200".equals(participantDto.getTeamId())) {
                    redParticipantDtoList.add(participantDto);
                }
            }

            sortParticipationDtoList(blueParticipantDtoList, redParticipantDtoList);

            summonerInfo.setChampionNameKR(JsonParserForLOL.getKRChampionNameByENGChampionName(summonerInfo.getChampionNameENG()));

            metadataDto = metadataDto_assembly.getMetadataDto_byEntity(matchMasterEntity,participantsList);
            infoDto = infoDto_assembly.getInfoDto_byEntityAndDto(matchMasterEntity,teamDtoList,blueParticipantDtoList,redParticipantDtoList,summonerInfo);

            matchInfo = matchDto_assembly.getMatchDto_byDto(metadataDto,infoDto);

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
        apiKey = apiKeyController.getAPIKey_ByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();
        ArrayList<String> matchList = new ArrayList<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("MATCH", "GET_MATCHES_BY_PUUID")
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
        List<MatchParticipantEntity> list = matchParticipantController.getMatchParticipantList_ByPuuid(puuid);
        HashSet<String> matchList = new HashSet<>();

        for(MatchParticipantEntity entity : list) {
            matchList.add(entity.getMatchParticipantId().getMatchId());
        }

        return matchList;
    }


    public HashMap<String, Object> getSummonerInfo(String name) {

        apiKey = apiKeyController.getAPIKey_ByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("SUMMONER","GET_PUUID_BY_NAME")
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
        SummonerDto summonerDto = new SummonerDto();
        SummonerDto_Assembly summonerDto_assembly = new SummonerDto_Assembly();

        String puuid = summonerController.getSummoner_Puuid_ByName(name);

        if(null == puuid) return null;

        SummonerEntity summoner = summonerController.getSummoner(puuid).get(0);

        summonerDto = summonerDto_assembly.getSummonerDto_byEntity(summoner);

        return summonerDto;
    }

    public HashMap<String, Object> getLeagueInfo(String encryptedSummonerId) {
        apiKey = apiKeyController.getAPIKey_ByCategory("Product");

        HashMap<String, Object> result = new HashMap<>();

        try {
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiController.getAPIURL_ByCategoryAndOperation("LEAGUE","GET_LEAGUE_BY_ENCRYPTEDID")
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

        List<LeagueEntryEntity> leagueEntryEntityList = leagueEntryController.getLeagueEntries_BySummonerId(summonerId);

        LeagueEntryDto_Assembly leagueEntryDto_assembly = new LeagueEntryDto_Assembly();

        for(LeagueEntryEntity leagueEntryEntity : leagueEntryEntityList) {
            result.add(leagueEntryDto_assembly.getLeagueEntryDto_byEntity(leagueEntryEntity));
        }

        return result;
    }

}
