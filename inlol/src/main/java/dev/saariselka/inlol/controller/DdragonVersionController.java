package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.dto.DdragonVersionDto;
import dev.saariselka.inlol.dto.DtoMapper;
import dev.saariselka.inlol.entity.DdragonVersionEntity;
import dev.saariselka.inlol.service.DdragonVersionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    DtoMapper dtoMapper;

    public String getCurrentDdragonVersion() {
        List<DdragonVersionDto> ddragonVersionDtoList = dtoMapper.toDdragonVersionDtoList(ddragonVersionService.getCurrentDdragonVersion());

        if(!ddragonVersionDtoList.isEmpty()) {
            return ddragonVersionDtoList.get(0).getVersion();
        } else {
            return null;
        }
    }
}
