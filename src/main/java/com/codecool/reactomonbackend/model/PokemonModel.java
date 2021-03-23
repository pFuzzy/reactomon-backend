package com.codecool.reactomonbackend.model;

import lombok.Data;

import java.util.List;

@Data
public class PokemonModel {
    private String name;
    private int height;
    private int weight;
    private List<PokemonType> types;
    private Sprites sprites;
    private List<PokemonAbility> abilities;
}
