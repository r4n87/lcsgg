package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.APIKeyEntity;
import dev.saariselka.inlol.service.APIKeyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<APIKeyEntity>> getAllkeys() {
        List<APIKeyEntity> key = APIKeyService.findAll();
        return new ResponseEntity<List<APIKeyEntity>>(key, HttpStatus.OK);
    }

    @GetMapping(value ="/{category}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public String getAPIKey_ByCategory(@PathVariable("category") String category) {
        List<APIKeyEntity> keys = APIKeyService.findByCategory(category);

        if(!keys.isEmpty()) {
            return keys.get(0).getKey();
        } else {
            return null;
        }
    }

}
