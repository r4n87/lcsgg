package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.APIEntity;
import dev.saariselka.inlol.repository.APIRepository;
import dev.saariselka.inlol.service.APIService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class APIController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    APIService apiService;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<APIEntity>> getAllapis() {
        List<APIEntity> api = apiService.findAll();
        return new ResponseEntity<List<APIEntity>>(api, HttpStatus.OK);
    }

    @GetMapping(value ="/{category,operation}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public String getAPIURL_ByCategoryAndOperation(@PathVariable("category") String category,@PathVariable("operation") String operation) {
        List<APIEntity> apis = apiService.findByCategoryAndOperation(category,operation);

        if(!apis.isEmpty()) {
            return apis.get(0).getUrl();
        } else {
            return null;
        }
    }
}
