package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.APIEntity;
import dev.saariselka.inlol.entity.DdragonVersionEntity;
import dev.saariselka.inlol.repository.DdragonVersionRepository;
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

    public List<DdragonVersionEntity> findAll() {
        List<DdragonVersionEntity> ddragonVersionEntities = new ArrayList<>();
        ddragonVersionRepository.findAll().forEach(e -> ddragonVersionEntities.add(e));

        return ddragonVersionEntities;
    }

    public Optional<DdragonVersionEntity> findById(Long id) {
        Optional<DdragonVersionEntity> ddragonVersionEntity = ddragonVersionRepository.findById(id);
        return ddragonVersionEntity;
    }

    public List<DdragonVersionEntity> findByCurrent(String current) {
        List<DdragonVersionEntity> ddragonVersionEntities = ddragonVersionRepository.findByCurrent(current);
        return ddragonVersionEntities;
    }

    public List<DdragonVersionEntity> getCurrentDdragonVersion() {
        List<DdragonVersionEntity> ddragonVersionEntities = ddragonVersionRepository.getCurrentDdragonVersion();
        return ddragonVersionEntities;
    }
}
