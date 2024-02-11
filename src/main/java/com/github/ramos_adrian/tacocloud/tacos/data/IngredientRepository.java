package com.github.ramos_adrian.tacocloud.tacos.data;

import java.util.Optional;

import com.github.ramos_adrian.tacocloud.tacos.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
    
}
