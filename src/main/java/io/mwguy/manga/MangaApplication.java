package io.mwguy.manga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MangaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangaApplication.class, args);
    }
}
