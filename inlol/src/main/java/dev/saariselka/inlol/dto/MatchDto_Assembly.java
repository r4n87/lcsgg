package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.controller.MatchMasterController;
import dev.saariselka.inlol.entity.MatchMasterEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class MatchDto_Assembly {
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

            //시간 차이 계산
            String gameDuration = String.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())))
                    + "분 "
                    + String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) - (ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) * 60))
                    + "초";

            String gameAgoTime = null;

            if (ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.now()) >= 24)
            {
                gameAgoTime = String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                        + "일 전";
            }
            else
            {
                gameAgoTime = String.valueOf(ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                        + "시간 전";
            }

            infoDto.setGameCreation(masterEntity.getGameCreation());
            infoDto.setGameEndTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId()));
            infoDto.setGameDuration(gameDuration);
            infoDto.setGameId(masterEntity.getGameId());
            infoDto.setGameMode(masterEntity.getGameMode());
            infoDto.setGameName(masterEntity.getGameName());
            infoDto.setGameStartTimeStamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()),TimeZone.getDefault().toZoneId()));
            infoDto.setGameType(masterEntity.getGameType());
            infoDto.setGameVersion(masterEntity.getGameVersion());
            infoDto.setMapId(String.valueOf(masterEntity.getMapId()));
            infoDto.setPlatformId(masterEntity.getPlatformId());
            infoDto.setQueueId(String.valueOf(masterEntity.getQueueId()));
            infoDto.setGameAgoTime(gameAgoTime);

            teamDto1.setTeamId(String.valueOf(masterEntity.getTeamId1()));
            teamDto2.setTeamId(String.valueOf(masterEntity.getTeamId2()));

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

            //시간 차이 계산
            String gameDuration = String.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())))
                    + "분 "
                    + String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) - (ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) * 60))
                    + "초";

            String gameAgoTime = null;

            if (ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.now()) >= 24)
            {
                gameAgoTime = String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                        + "일 전";
            }
            else
            {
                gameAgoTime = String.valueOf(ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                        + "시간 전";
            }

            infoDto.setGameCreation(masterEntity.getGameCreation());
            infoDto.setGameEndTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId()));
            infoDto.setGameDuration(gameDuration);
            infoDto.setGameId(masterEntity.getGameId());
            infoDto.setGameMode(masterEntity.getGameMode());
            infoDto.setGameName(masterEntity.getGameName());
            infoDto.setGameStartTimeStamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(masterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()));
            infoDto.setGameType(masterEntity.getGameType());
            infoDto.setGameVersion(masterEntity.getGameVersion());
            infoDto.setMapId(String.valueOf(masterEntity.getMapId()));
            infoDto.setPlatformId(masterEntity.getPlatformId());
            infoDto.setQueueId(String.valueOf(masterEntity.getQueueId()));
            infoDto.setGameAgoTime(gameAgoTime);

            teamDto1.setTeamId(String.valueOf(masterEntity.getTeamId1()));
            teamDto2.setTeamId(String.valueOf(masterEntity.getTeamId2()));

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
