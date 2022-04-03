package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.APIKeyEntity;
import dev.saariselka.inlol.repository.APIKeyRepository;
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
        List<APIKeyEntity> keys = new ArrayList<>();
        APIKeyRepository.findAll().forEach(e -> keys.add(e));

        return keys;
    }

    public Optional<APIKeyEntity> findById(Long id) {
        Optional<APIKeyEntity> key = APIKeyRepository.findById(id);
        return key;
    }

    public List<APIKeyEntity> findByCategory(String category) {
        List<APIKeyEntity> key = APIKeyRepository.findByCategory(category);
        return key;
    }

}
