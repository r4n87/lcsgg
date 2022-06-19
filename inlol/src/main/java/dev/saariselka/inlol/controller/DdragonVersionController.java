package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.DdragonVersionEntity;
import dev.saariselka.inlol.service.DdragonVersionService;
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
@RequestMapping(path = "/ddragonversion")
public class DdragonVersionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DdragonVersionService ddragonVersionService;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<DdragonVersionEntity>> getAllVersions() {
        List<DdragonVersionEntity> ddragonVersionEntities = ddragonVersionService.findAll();
        return new ResponseEntity<List<DdragonVersionEntity>>(ddragonVersionEntities, HttpStatus.OK);
    }

    @GetMapping(value ="/{currentVersion}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String getCurrentDdragonVersion() {
        List<DdragonVersionEntity> ddragonVersionEntities = ddragonVersionService.getCurrentDdragonVersion();

        if(!ddragonVersionEntities.isEmpty()) {
            return ddragonVersionEntities.get(0).getVersion();
        } else {
            return null;
        }
    }
}
