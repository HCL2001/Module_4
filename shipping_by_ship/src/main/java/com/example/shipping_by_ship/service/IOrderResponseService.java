package com.example.shipping_by_ship.service;

import com.example.shipping_by_ship.model.orders.OrderResponse;

import java.util.List;

public interface IOrderResponseService {
    void save(OrderResponse orderResponse);

    List<OrderResponse> findAll();

    OrderResponse findByOrderCode(String orderCode);
}
