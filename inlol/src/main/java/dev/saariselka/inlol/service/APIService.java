package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.APIEntity;
import dev.saariselka.inlol.repository.APIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class APIService {

    @Autowired
    private final APIRepository apiRepository;

    public List<APIEntity> findAll() {
        List<APIEntity> apis = new ArrayList<>();
        apiRepository.findAll().forEach(e -> apis.add(e));

        return apis;
    }

    public Optional<APIEntity> findById(Long id) {
        Optional<APIEntity> api = apiRepository.findById(id);
        return api;
    }

}
