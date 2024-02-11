package com.github.ramos_adrian.tacocloud.tacos;

import java.util.List;

import lombok.Data;

@Data
public class Taco {

    private String name;
    private List<Ingredient> ingredients;

}
