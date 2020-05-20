package com.zoe.frea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FreaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreaApplication.class, args);
    }

}
