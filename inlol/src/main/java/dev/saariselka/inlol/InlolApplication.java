package dev.saariselka.inlol;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.saariselka.inlol.controller.SummonerController;
import dev.saariselka.inlol.entity.SummonerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;

@SpringBootApplication
public class InlolApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(InlolApplication.class, args);
    }

}
