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
@RequestMapping(path = "/test")
public class APIController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    APIService apiService;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<APIEntity>> getAllapis() {
        List<APIEntity> api = apiService.findAll();
        return new ResponseEntity<List<APIEntity>>(api, HttpStatus.OK);
    }

    @GetMapping(value ="/{id}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<APIEntity>  getAPI(@PathVariable("id") Long id) {
        Optional<APIEntity> api = apiService.findById(id);

        if(api.isPresent()) {
            return new ResponseEntity<APIEntity>(api.get(), HttpStatus.OK);
        } else {
            return null;
        }
    }

}
