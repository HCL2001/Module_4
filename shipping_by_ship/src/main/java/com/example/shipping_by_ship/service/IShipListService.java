package com.example.shipping_by_ship.service;

import com.example.shipping_by_ship.model.dto.ShipsListFormShipsDTO;
import com.example.shipping_by_ship.model.ships.ShipsListFromShips;

import java.util.List;

public interface IShipListService {
    void save(ShipsListFromShips ships);

    List<ShipsListFormShipsDTO> findAllShips();

    ShipsListFromShips findByCheckId(String id);

    ShipsListFromShips findById(Long id);

    ShipsListFromShips findByCode(String orderCode);
}
