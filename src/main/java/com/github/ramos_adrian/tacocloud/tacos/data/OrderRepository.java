package com.github.ramos_adrian.tacocloud.tacos.data;
import org.springframework.data.repository.CrudRepository;

import com.github.ramos_adrian.tacocloud.tacos.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}

