package com.codecool.reactomonbackend;

import com.codecool.reactomonbackend.service.ApiConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ReactomonBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactomonBackendApplication.class, args);
    }

    @Autowired
    private ApiConverter apiConverter;

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            System.out.println(apiConverter.createEntityFromApiData(1));
        };}
}
