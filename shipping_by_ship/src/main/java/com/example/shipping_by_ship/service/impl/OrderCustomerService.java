package com.example.shipping_by_ship.service.impl;

import com.example.shipping_by_ship.model.orders.OrderCustomer;
import com.example.shipping_by_ship.repository.IOrderCustomerRepository;
import com.example.shipping_by_ship.service.IOrderCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCustomerService implements IOrderCustomerService {

    @Autowired
    private IOrderCustomerRepository iOrderCustomerRepository;

    @Override
    public void save(OrderCustomer orderCustomer){
        iOrderCustomerRepository.save(orderCustomer);
    }


    @Override
    public List<OrderCustomer> findAll(){
        return iOrderCustomerRepository.findAll();
    }

    @Override
    public OrderCustomer findByCode(String orderCode){
        return iOrderCustomerRepository.findByOrderCode(orderCode);
    }

}
