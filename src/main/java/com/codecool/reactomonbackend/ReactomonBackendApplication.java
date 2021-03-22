package com.codecool.reactomonbackend;

import com.codecool.reactomonbackend.service.ApiDataConverter;
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
    private ApiDataConverter apiDataConverter;

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            System.out.println(apiDataConverter.createEntityFromApiData(1));
        };}
}
