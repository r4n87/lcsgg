package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.Summoner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/summoner")
public class SearchController {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @GetMapping("/summoner-info")
    public ModelAndView searchSummoner(
            @RequestParam("name") String name
    ) {
        logger.info("search Summoner");
        ModelAndView modelAndView = new ModelAndView();
        Summoner summoner = new Summoner(name);

        modelAndView.addObject("summoner", summoner);
        modelAndView.setViewName("summoner-thyme");

        return modelAndView;
    }
}
