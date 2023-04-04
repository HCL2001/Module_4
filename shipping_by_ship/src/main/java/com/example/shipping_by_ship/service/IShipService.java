package com.example.shipping_by_ship.service;


import com.example.shipping_by_ship.model.ships.Ship;
import com.example.shipping_by_ship.model.dto.ShipResponeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IShipService {

    void save(Ship ship);

    List<ShipResponeDTO> findAll();

    Ship findByCode(String code);

    void delete(Ship ship);

    @Transactional
    void removeByCode(String code);

    List<Ship> findAllByStatus(Long status);

    List<Ship> findAllShip();
}
