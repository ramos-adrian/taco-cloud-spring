package com.github.ramos_adrian.tacocloud.tacos;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Table
@AllArgsConstructor
public class Ingredient implements Persistable<String> {

    @Id
    private String id;

    private String name;
    private Type type;

    private boolean isNew = true;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }

}
