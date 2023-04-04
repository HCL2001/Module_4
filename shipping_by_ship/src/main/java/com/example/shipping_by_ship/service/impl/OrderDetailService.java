package com.example.shipping_by_ship.service.impl;

import com.example.shipping_by_ship.model.orders.OrderDetailConfirmedToShips;
import com.example.shipping_by_ship.repository.IOrderDetailRepository;
import com.example.shipping_by_ship.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;

    @Override
    public void save(OrderDetailConfirmedToShips orderDetailConfirmedToShips){
        iOrderDetailRepository.save(orderDetailConfirmedToShips);
    }

    @Override
    public List<OrderDetailConfirmedToShips> orderDetailConfirmedToShips(){
        return iOrderDetailRepository.findAll();
    }

    @Override
    public OrderDetailConfirmedToShips confirmedToShipsByCode(String code){
        return iOrderDetailRepository.findByCode(code);
    }

}
