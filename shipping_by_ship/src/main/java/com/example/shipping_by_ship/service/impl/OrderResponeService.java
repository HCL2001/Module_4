package com.example.shipping_by_ship.service.impl;

import com.example.shipping_by_ship.model.orders.OrderResponse;
import com.example.shipping_by_ship.repository.IOrderResponeRepository;
import com.example.shipping_by_ship.service.IOrderResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderResponeService implements IOrderResponseService {

    @Autowired
    private IOrderResponeRepository iOrderResponeRepository;

    @Override
    public void save(OrderResponse orderResponse){
        iOrderResponeRepository.save(orderResponse);
    }

    @Override
    public List<OrderResponse> findAll(){
        return iOrderResponeRepository.findAllResponse();
    }

    @Override
    public OrderResponse findByOrderCode(String orderCode){
        return iOrderResponeRepository.findByOrderCode(orderCode);
    }
}
