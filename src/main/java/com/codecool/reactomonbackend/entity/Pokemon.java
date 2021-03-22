package com.codecool.reactomonbackend.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Pokemon {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ElementCollection
    private List<String> types;

    @ElementCollection
    private List<String> sprites;

    @ElementCollection
    private List<String> abilities;

    private int height;

    private int width;
}
