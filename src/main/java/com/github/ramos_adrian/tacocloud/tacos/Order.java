package com.github.ramos_adrian.tacocloud.tacos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Order {
    
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private final List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }


}
