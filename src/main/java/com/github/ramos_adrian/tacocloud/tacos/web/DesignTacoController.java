package com.github.ramos_adrian.tacocloud.tacos.web;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.ramos_adrian.tacocloud.tacos.Ingredient;
import com.github.ramos_adrian.tacocloud.tacos.Order;
import com.github.ramos_adrian.tacocloud.tacos.Taco;
import com.github.ramos_adrian.tacocloud.tacos.Ingredient.Type;
import com.github.ramos_adrian.tacocloud.tacos.data.IngredientRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void createIngredientLists(final Model model) {
        List<Ingredient> ingredients = StreamSupport.stream(ingredientRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        for (Type type : Ingredient.Type.values()) {
            model.addAttribute(
                    type.toString().toLowerCase(),
                    ingredients
                            .stream()
                            .filter(ingredient -> ingredient.getType().equals(type))
                            .collect(Collectors.toList()));
        }
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute Order order) {

        if (errors.hasErrors()) {
            return "design";
        }

        order.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }

}
