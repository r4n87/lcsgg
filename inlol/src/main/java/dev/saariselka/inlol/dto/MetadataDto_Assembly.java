package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.MatchMasterController;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MetadataDto_Assembly {
    @Autowired
    MatchMasterController matchMasterController;

    public MatchDto getMatchMaster_ByMatchId(String matchId) {
        List<MatchMasterEntity> masterList = matchMasterController.getMatchMaster_ByMatchId(matchId);

        MatchDto matchDto = new MatchDto();

        for(MatchMasterEntity masterEntity : masterList)
        {
            MetadataDto metadataDto = new MetadataDto(masterEntity.getMatchMasterId().getDataVersion(), masterEntity.getMatchMasterId().getMatchId());
            InfoDto infoDto = new InfoDto();
            TeamDto teamDto1 = new TeamDto();
            TeamDto teamDto2 = new TeamDto();
            List<TeamDto> teams = new ArrayList<>();

            infoDto.setGameCreation(masterEntity.getGameCreation());
            infoDto.setGameEndTimestamp(masterEntity.getGameEndTimeStamp());
            infoDto.setGameDuration(masterEntity.getGameDuration());
            infoDto.setGameId(masterEntity.getGameId());
            infoDto.setGameMode(masterEntity.getGameMode());
            infoDto.setGameName(masterEntity.getGameName());
            infoDto.setGameStartTimeStamp(masterEntity.getGameStartTimeStamp());
            infoDto.setGameType(masterEntity.getGameType());
            infoDto.setGameVersion(masterEntity.getGameVersion());
            infoDto.setMapId(masterEntity.getMapId());
            infoDto.setPlatformId(masterEntity.getPlatformId());
            infoDto.setQueueId(masterEntity.getQueueId());

            teamDto1.setTeamId(masterEntity.getTeamId1());
            teamDto2.setTeamId(masterEntity.getTeamId2());

            teams.add(teamDto1);
            teams.add(teamDto2);
            infoDto.setTeams(teams);
            infoDto.setTournamentCode(masterEntity.getTournamentCode());

            matchDto.setMetadata(metadataDto);
            matchDto.setInfo(infoDto);
        }

        return matchDto;
    }

    public MatchDto getMatchMaster_ByMatchMasterId(String matchId, String dataVersion) {
        List<MatchMasterEntity> masterList = matchMasterController.getMatchMaster_ByDataVersionAndMatchId(dataVersion, matchId);

        MatchDto matchDto = new MatchDto();

        for(MatchMasterEntity masterEntity : masterList)
        {
            MetadataDto metadataDto = new MetadataDto(masterEntity.getMatchMasterId().getDataVersion(), masterEntity.getMatchMasterId().getMatchId());
            InfoDto infoDto = new InfoDto();
            TeamDto teamDto1 = new TeamDto();
            TeamDto teamDto2 = new TeamDto();
            List<TeamDto> teams = new ArrayList<>();

            infoDto.setGameCreation(masterEntity.getGameCreation());
            infoDto.setGameEndTimestamp(masterEntity.getGameEndTimeStamp());
            infoDto.setGameDuration(masterEntity.getGameDuration());
            infoDto.setGameId(masterEntity.getGameId());
            infoDto.setGameMode(masterEntity.getGameMode());
            infoDto.setGameName(masterEntity.getGameName());
            infoDto.setGameStartTimeStamp(masterEntity.getGameStartTimeStamp());
            infoDto.setGameType(masterEntity.getGameType());
            infoDto.setGameVersion(masterEntity.getGameVersion());
            infoDto.setMapId(masterEntity.getMapId());
            infoDto.setPlatformId(masterEntity.getPlatformId());
            infoDto.setQueueId(masterEntity.getQueueId());

            teamDto1.setTeamId(masterEntity.getTeamId1());
            teamDto2.setTeamId(masterEntity.getTeamId2());

            teams.add(teamDto1);
            teams.add(teamDto2);
            infoDto.setTeams(teams);
            infoDto.setTournamentCode(masterEntity.getTournamentCode());

            matchDto.setMetadata(metadataDto);
            matchDto.setInfo(infoDto);
        }

        return matchDto;
    }
}
