package com.example.shipping_by_ship.service.impl;


import com.example.shipping_by_ship.mapper.ResponseMapper;
import com.example.shipping_by_ship.model.dto.ShipsListFormShipsDTO;
import com.example.shipping_by_ship.model.ships.ShipsListFromShips;
import com.example.shipping_by_ship.repository.IShipRepository;
import com.example.shipping_by_ship.repository.IShipsListRepository;
import com.example.shipping_by_ship.service.IShipListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipListService implements IShipListService {

    @Autowired
    private IShipsListRepository iShipsListRepository;

    @Autowired
    private ResponseMapper responseMapper;
    @Autowired
    private IShipRepository iShipRepository;

    @Override
    public void save(ShipsListFromShips ships){
        iShipsListRepository.save(ships);
    }

    @Override
    public List<ShipsListFormShipsDTO> findAllShips(){
        return responseMapper.shipsDTOS(iShipsListRepository.findAllShips());
    }

    @Override
    public ShipsListFromShips findByCheckId(String id){
        return iShipsListRepository.findByCheckId(id);
    }

    @Override
    public ShipsListFromShips findById(Long id){
        if (iShipsListRepository.findById(id).isPresent())
            return iShipsListRepository.findById(id).get();
        return null;
    }

    @Override
    public ShipsListFromShips findByCode(String orderCode){
        return iShipsListRepository.findShips(orderCode);
    }
}
