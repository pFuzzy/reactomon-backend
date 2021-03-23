package com.codecool.reactomonbackend.service;

import com.codecool.reactomonbackend.entity.Pokemon;
import com.codecool.reactomonbackend.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiDataConverter {
    public Pokemon createEntityFromApiData(int pokemonId) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String baseUrl = "https://pokeapi.co/api/v2/pokemon/";

            PokemonModel pokemonModel = restTemplate.getForObject(baseUrl + pokemonId, PokemonModel.class);

            String pokemonName = pokemonModel.getName();
            int pokemonHeight = pokemonModel.getHeight();
            int pokemonWeight = pokemonModel.getWeight();
            Sprites sprites = pokemonModel.getSprites();
            List<PokemonAbility> abilities = pokemonModel.getAbilities();
            List<PokemonType> types = pokemonModel.getTypes();

            Pokemon newPokemonEntity = Pokemon.builder()
                    .name(pokemonName)
                    .height(pokemonHeight)
                    .weight(pokemonWeight)
                    .sprite(sprites.getBack_default())
                    .sprite(sprites.getFront_default())
                    .build();
            List<String> abilityNames = new ArrayList<>();
            for (PokemonAbility pokemonAbility : abilities) {
                abilityNames.add(pokemonAbility.getAbility().getName());
            }
            newPokemonEntity.setAbilities(abilityNames);
            List<String> pokemonTypeNames = new ArrayList<>();
            for (PokemonType type : types) {
                pokemonTypeNames.add(type.getType().getName());
            }
            newPokemonEntity.setTypes(pokemonTypeNames);
            return newPokemonEntity;
        }
        catch(Exception e){
            throw new Exception("Something is fucked up fam");
        }
    }
}
