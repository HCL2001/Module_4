package com.example.shipping_by_ship.service;

import com.example.shipping_by_ship.model.orders.OrderCustomer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderCustomerService {
    void save(OrderCustomer orderCustomer);

    List<OrderCustomer> findAll();


    OrderCustomer findByCode(String orderCode);
}
