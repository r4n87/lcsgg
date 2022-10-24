package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.entity.APIEntity;
import dev.saariselka.lcsgg.service.APIService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class APIController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    APIService apiService;

    public String getAPIUrlByCategoryAndOperation(String category, String operation) {
        List<APIEntity> apis = apiService.findByCategoryAndOperation(category,operation);

        if(!apis.isEmpty()) {
            return apis.get(0).getUrl();
        } else {
            return null;
        }
    }
}
