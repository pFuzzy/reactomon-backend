package com.codecool.reactomonbackend.repository;

import com.codecool.reactomonbackend.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
