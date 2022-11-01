package dev.saariselka.lcsgg.controller;

import dev.saariselka.lcsgg.service.DdragonVersionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DdragonVersionController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DdragonVersionService ddragonVersionService;

    public String getDdragonVersionByCurrent(String current) {
        if(ddragonVersionService.findByCurrent(current).isPresent()) {
            return ddragonVersionService.findByCurrent(current).get().getVersion();
        }

        return "";
    }
}
