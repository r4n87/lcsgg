package dev.saariselka.inlol;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class InlolApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(InlolApplication.class, args);

    }

}
