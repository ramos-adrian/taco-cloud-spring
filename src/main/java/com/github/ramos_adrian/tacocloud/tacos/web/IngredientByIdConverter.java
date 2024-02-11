package com.github.ramos_adrian.tacocloud.tacos.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.github.ramos_adrian.tacocloud.tacos.Ingredient;
import com.github.ramos_adrian.tacocloud.tacos.data.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepository;

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;       
    }

    @Override
    @Nullable
    public Ingredient convert(String ingredientId) {
        return ingredientRepository.findById(ingredientId).orElse(null);
    }

}
