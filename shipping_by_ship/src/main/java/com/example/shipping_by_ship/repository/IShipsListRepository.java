package com.example.shipping_by_ship.repository;

import com.example.shipping_by_ship.model.ships.ShipsListFromShips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShipsListRepository extends JpaRepository<ShipsListFromShips, Long> {

    @Query(value = "select c from ShipsListFromShips c where c.isDeleted = false ")
    public List<ShipsListFromShips> findAllShips();

    @Query(value = "select c from ShipsListFromShips c where c.checkId = ?1 and c.isDeleted = false")
    ShipsListFromShips findByCheckId(String id);

    @Query(value = "select c from ShipsListFromShips c where c.orderCode = ?1")
    ShipsListFromShips findShips(String orderCode);
}
