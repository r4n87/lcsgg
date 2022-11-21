package dev.saariselka.lcsgg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LcsggApplication {

    public static void main(String[] args) {
        SpringApplication.run(LcsggApplication.class, args);

    }

}
