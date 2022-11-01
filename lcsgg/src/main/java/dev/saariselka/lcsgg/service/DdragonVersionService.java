package dev.saariselka.lcsgg.service;

import dev.saariselka.lcsgg.entity.DdragonVersion;
import dev.saariselka.lcsgg.repository.DdragonVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DdragonVersionService {
    @Autowired
    DdragonVersionRepository ddragonVersionRepository;

    public Optional<DdragonVersion> findByCurrent(String current) {
        return ddragonVersionRepository.findDdragonVersionByCurrent(current);
    }
}
