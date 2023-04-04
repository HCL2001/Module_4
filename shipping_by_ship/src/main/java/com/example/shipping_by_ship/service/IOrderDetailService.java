package com.example.shipping_by_ship.service;

import com.example.shipping_by_ship.model.orders.OrderDetailConfirmedToShips;

import java.util.List;

public interface IOrderDetailService {
    void save(OrderDetailConfirmedToShips orderDetailConfirmedToShips);

    List<OrderDetailConfirmedToShips> orderDetailConfirmedToShips();

    OrderDetailConfirmedToShips confirmedToShipsByCode(String code);
}
