package dev.saariselka.lcsgg.service;

import dev.saariselka.lcsgg.entity.APIEntity;
import dev.saariselka.lcsgg.repository.APIRepository;
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

    public List<APIEntity> findByCategoryAndOperation(String category,String operation) {
        List<APIEntity> api = apiRepository.findByCategoryAndOperation(category,operation);
        return api;
    }

}
