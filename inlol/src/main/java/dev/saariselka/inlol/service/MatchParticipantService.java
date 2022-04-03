package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchParticipantEntity;
import dev.saariselka.inlol.entity.MatchParticipantId;
import dev.saariselka.inlol.repository.MatchParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchParticipantService {

    @Autowired
    private final MatchParticipantRepository matchParticipantRepository;

    public Optional<MatchParticipantEntity> findById(MatchParticipantId matchParticipantId) {
        Optional<MatchParticipantEntity> matchParticipant = matchParticipantRepository.findById(matchParticipantId);
        return matchParticipant;
    }

    public List<MatchParticipantEntity> findAllById(MatchParticipantId matchParticipantId) {
        List<MatchParticipantEntity> matchParticipantList = matchParticipantRepository.findAllByMatchParticipantId(matchParticipantId);
        return matchParticipantList;
    }

}
