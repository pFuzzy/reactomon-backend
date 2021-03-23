package com.codecool.reactomonbackend;

import com.codecool.reactomonbackend.model.PokemonCount;
import com.codecool.reactomonbackend.repository.PokemonRepository;
import com.codecool.reactomonbackend.service.ApiDataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ReactomonBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactomonBackendApplication.class, args);
    }

    @Autowired
    private ApiDataConverter apiDataConverter;

    @Autowired
    private PokemonRepository pokemonRepository;


    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            /*RestTemplate restTemplate = new RestTemplate();
            int numberOfPokemons = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/", PokemonCount.class).getCount();
            for(int i = 1; i <= numberOfPokemons; i++){
                try{
                    pokemonRepository.save(apiDataConverter.createEntityFromApiData(i));
                }catch(Exception e){
                    continue;
                }
            }*/
        };}
}
