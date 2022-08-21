package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.MatchParticipantId;
import dev.saariselka.inlol.repository.MatchParticipantRepository;
import dev.saariselka.inlol.vo.MatchParticipantVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchParticipantService {

    @Autowired
    private final MatchParticipantRepository matchParticipantRepository;
    @Autowired
    private VOMapper voMapper;

    public List<MatchParticipantVO> findById(MatchParticipantId matchParticipantId) {
        return voMapper.toMatchParticipantVOList(
                matchParticipantRepository.findByMatchParticipantId(matchParticipantId));
    }

    public List<MatchParticipantVO> findByDataVersionAndMatchId(String dataVersion, String matchId) {
        return voMapper.toMatchParticipantVOList(
                matchParticipantRepository.findByMatchParticipantId_DataVersionAndMatchParticipantId_MatchId(dataVersion, matchId));
    }

    public List<MatchParticipantVO> findByPuuid(String puuid) {
        return voMapper.toMatchParticipantVOList(
                matchParticipantRepository.findByMatchParticipantId_PuuidOrderByMatchParticipantId_MatchIdDesc(puuid));
    }

    public void insert(MatchParticipantVO matchParticipantVO) {
        matchParticipantRepository.save(voMapper.toMatchParticipantEntity(matchParticipantVO));

    }
}
