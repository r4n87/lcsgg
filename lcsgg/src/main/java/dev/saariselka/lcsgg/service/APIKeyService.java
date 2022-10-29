package dev.saariselka.lcsgg.service;

import dev.saariselka.lcsgg.entity.APIKeyEntity;
import dev.saariselka.lcsgg.repository.APIKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class APIKeyService {

    @Autowired
    private final APIKeyRepository APIKeyRepository;

    public List<APIKeyEntity> findAll() {
        return new ArrayList<>(APIKeyRepository.findAll());
    }

    public Optional<APIKeyEntity> findById(Long id) {
        return APIKeyRepository.findById(id);
    }

    public List<APIKeyEntity> findByCategory(String category) {
        return APIKeyRepository.findByCategory(category);
    }

}
