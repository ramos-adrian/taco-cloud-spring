package com.github.ramos_adrian.tacocloud.tacos.data;

import org.springframework.data.repository.CrudRepository;

import com.github.ramos_adrian.tacocloud.tacos.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
