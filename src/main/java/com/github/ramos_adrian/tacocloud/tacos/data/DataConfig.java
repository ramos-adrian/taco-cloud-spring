package com.github.ramos_adrian.tacocloud.tacos.data;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.ramos_adrian.tacocloud.tacos.Ingredient;
import com.github.ramos_adrian.tacocloud.tacos.Ingredient.Type;

@Configuration
public class DataConfig {

    @Bean
    public ApplicationRunner dataLoader(IngredientRepository repo) {
        return args -> {
            repo.deleteAll(); // TODO: Quick hack to avoid tests from stepping on each other with constraint violations
            repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP, true));
            repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP, true));
            repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN, true));
            repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN, true));
            repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES, true));
            repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES, true));
            repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE, true));
            repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE, true));
            repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE, true));
            repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE, true));
        };
    }
}
