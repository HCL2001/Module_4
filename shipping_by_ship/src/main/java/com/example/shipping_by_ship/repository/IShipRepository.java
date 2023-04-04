package com.example.shipping_by_ship.repository;

import com.example.shipping_by_ship.model.ships.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShipRepository extends JpaRepository<Ship, Long> {

    @Query
    public Ship findByCode(String  code);

    @Query(value = "select c from Ship c where c.isDeleted = false ")
    public List<Ship> findAllShip();

    List<Ship> findAllByStatusShip(Long status);
}
