package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.APIEntity;
import dev.saariselka.inlol.entity.DdragonVersionEntity;
import dev.saariselka.inlol.repository.DdragonVersionRepository;
import dev.saariselka.inlol.vo.DdragonVersionVO;
import dev.saariselka.inlol.vo.VOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DdragonVersionService {

    @Autowired
    private final DdragonVersionRepository ddragonVersionRepository;
    @Autowired
    private VOMapper voMapper;

    public List<DdragonVersionVO> findAll() {
        return voMapper.toDdragonVersionVOList(ddragonVersionRepository.findAll());
    }

    public Optional<DdragonVersionVO> findById(Long id) {
        return voMapper.toDdragonVersionVO(ddragonVersionRepository.findById(id));
    }

    public List<DdragonVersionVO> findByCurrent(String current) {
        return voMapper.toDdragonVersionVOList(ddragonVersionRepository.findByCurrent(current));
    }

    public List<DdragonVersionVO> getCurrentDdragonVersion() {
        return voMapper.toDdragonVersionVOList(ddragonVersionRepository.getCurrentDdragonVersion());
    }
}
