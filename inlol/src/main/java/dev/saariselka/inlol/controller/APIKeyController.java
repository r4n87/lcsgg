package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.APIKeyEntity;
import dev.saariselka.inlol.service.APIKeyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/apikey")
public class APIKeyController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    APIKeyService APIKeyService;

    public String getAPIKeyByCategory(String category) {
        List<APIKeyEntity> apiKeys = APIKeyService.findByCategory(category);

        if(!apiKeys.isEmpty()) {
            return apiKeys.get(0).getApiKey();
        } else {
            return null;
        }
    }

}
