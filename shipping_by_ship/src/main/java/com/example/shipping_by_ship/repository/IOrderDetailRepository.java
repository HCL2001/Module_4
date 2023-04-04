package com.example.shipping_by_ship.repository;

import com.example.shipping_by_ship.model.orders.OrderDetailConfirmedToShips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetailConfirmedToShips, Long> {

    @Query(value = "select c from OrderDetailConfirmedToShips c where c.isDeleted = false")
    public List<OrderDetailConfirmedToShips> findAll();

    @Query(value = "select c from OrderDetailConfirmedToShips c where c.isDeleted = false and c.orderCode = ?1")
    public OrderDetailConfirmedToShips findByCode(String code);

}
