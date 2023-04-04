package com.example.shipping_by_ship.repository;

import com.example.shipping_by_ship.model.orders.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderResponeRepository extends JpaRepository<OrderResponse, Long> {

    @Query(value = "select c from OrderResponse c where c.isDeleted = false")
     List<OrderResponse> findAllResponse();

    @Query
     OrderResponse findByOrderCode(String orderCode);
}
