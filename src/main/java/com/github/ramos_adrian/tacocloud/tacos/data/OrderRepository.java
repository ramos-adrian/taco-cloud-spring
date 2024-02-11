package com.github.ramos_adrian.tacocloud.tacos.data;
import com.github.ramos_adrian.tacocloud.tacos.Order;

public interface OrderRepository {
    
    Order save(Order order);

}

