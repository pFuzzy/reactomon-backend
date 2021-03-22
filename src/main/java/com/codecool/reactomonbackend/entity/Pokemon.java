package com.codecool.reactomonbackend.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ElementCollection
    @Singular
    private List<String> types;

    @ElementCollection
    @Singular
    private List<String> sprites;

    @ElementCollection
    @Singular
    private List<String> abilities;

    private int height;

    private int weight;
}
