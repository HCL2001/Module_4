package com.example.shipping_by_ship.repository;

import com.example.shipping_by_ship.model.orders.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderCustomerRepository extends JpaRepository<OrderCustomer, Long> {

    @Query(value = "select c from OrderCustomer c where c.isDeleted = false")
    List<OrderCustomer> findAll();

    @Query
    OrderCustomer findByOrderCode(String orderCode);

}
