package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.entity.LeagueEntryEntity;

public class LeagueEntryDto_Assembly {

    public LeagueEntryDto getLeagueEntryDtoByEntity(LeagueEntryEntity leagueEntryEntity) {
        LeagueEntryDto leagueEntryDto = new LeagueEntryDto();

        leagueEntryDto.setLeagueId(leagueEntryEntity.getLeagueId());
        leagueEntryDto.setSummonerId(leagueEntryEntity.getLeagueEntryId().getSummonerId());
        leagueEntryDto.setSummonerName(leagueEntryEntity.getSummonerName());
        leagueEntryDto.setQueueType(leagueEntryEntity.getLeagueEntryId().getQueueType());
        leagueEntryDto.setTier(leagueEntryEntity.getTier());
        leagueEntryDto.setRank(leagueEntryEntity.getRanks());
        leagueEntryDto.setLeaguePoints(leagueEntryEntity.getLeaguePoints());
        leagueEntryDto.setWins(leagueEntryEntity.getWins());
        leagueEntryDto.setLosses(leagueEntryEntity.getLosses());
        leagueEntryDto.setHotStreak(leagueEntryEntity.isHotStreak());
        leagueEntryDto.setVeteran(leagueEntryEntity.isVeteran());
        leagueEntryDto.setFreshBlood(leagueEntryEntity.isFreshBlood());
        leagueEntryDto.setInactive(leagueEntryEntity.isInactive());

        return leagueEntryDto;
    }
}
