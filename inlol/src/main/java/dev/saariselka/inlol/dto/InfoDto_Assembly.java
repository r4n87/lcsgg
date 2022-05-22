package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.MatchMasterEntity;
import dev.saariselka.inlol.util.JsonParserForLOL;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TimeZone;

public class InfoDto_Assembly {

    public InfoDto getInfoDto_byEntityAndDto(MatchMasterEntity matchMasterEntity,
                                             List<TeamDto> teamDtoList, List<ParticipantDto> blueParticipantDtoList, List<ParticipantDto> redParticipantDtoList,
                                             ParticipantDto summonerInfo) {
        InfoDto infoDto = new InfoDto();

        //시간 차이 계산
        String gameDuration = String.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())))
                + "분 "
                + String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) - (ChronoUnit.MINUTES.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId())) * 60))
                + "초";

        String gameAgoTime = null;

        if (ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()), TimeZone.getDefault().toZoneId()), LocalDateTime.now()) >= 24)
        {
            gameAgoTime = String.valueOf(ChronoUnit.DAYS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "일 전";
        }
        else
        {
            gameAgoTime = String.valueOf(ChronoUnit.HOURS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()), LocalDateTime.now()))
                    + "시간 전";
        }

        //1. Match Master 정보 생성

        infoDto.setGameCreation(matchMasterEntity.getGameCreation());
        infoDto.setGameDuration(gameDuration);
        infoDto.setGameEndTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameEndTimeStamp()),TimeZone.getDefault().toZoneId()));
        infoDto.setGameId(matchMasterEntity.getGameId());
        //infoDto.setGameMode(masterEntity.getGameMode());
        infoDto.setGameMode(JsonParserForLOL.getKRGameModeByQueueId(matchMasterEntity.getQueueId()));
        infoDto.setGameName(matchMasterEntity.getGameName());
        infoDto.setGameStartTimeStamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(matchMasterEntity.getGameStartTimeStamp()),TimeZone.getDefault().toZoneId()));
        infoDto.setGameType(matchMasterEntity.getGameType());
        infoDto.setGameVersion(matchMasterEntity.getGameVersion());
        infoDto.setMapId(String.valueOf(matchMasterEntity.getMapId()));
        infoDto.setPlatformId(matchMasterEntity.getPlatformId());
        infoDto.setQueueId(String.valueOf(matchMasterEntity.getQueueId()));
        infoDto.setTournamentCode(matchMasterEntity.getTournamentCode());
        infoDto.setGameAgoTime(gameAgoTime);
        infoDto.setTeams(teamDtoList);
        infoDto.setBlueParticipants(blueParticipantDtoList);
        infoDto.setRedParticipants(redParticipantDtoList);
        infoDto.setSummoner(summonerInfo);

        return infoDto;
    }
}
