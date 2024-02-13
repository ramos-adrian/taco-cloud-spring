package com.github.ramos_adrian.tacocloud.tacos.data;

import org.springframework.data.repository.CrudRepository;

import com.github.ramos_adrian.tacocloud.tacos.Order;

import java.sql.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByDeliveryZip(String deliveryZip);

    List<Order> getByDeliveryZipAndCreatedAtBetween(String deliveryZip, Date startDate, Date endDate);

}
