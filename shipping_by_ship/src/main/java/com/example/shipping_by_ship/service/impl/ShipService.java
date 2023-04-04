package com.example.shipping_by_ship.service.impl;

import com.example.shipping_by_ship.mapper.RequestMapper;
import com.example.shipping_by_ship.mapper.ResponseMapper;
import com.example.shipping_by_ship.model.ships.Ship;
import com.example.shipping_by_ship.model.dto.ShipResponeDTO;
import com.example.shipping_by_ship.repository.IShipRepository;
import com.example.shipping_by_ship.service.IShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShipService implements IShipService {

    @Autowired
    private IShipRepository iShipRepository;

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private ResponseMapper responseMapper;

    @Override
    public void save(Ship ship){
        iShipRepository.save(ship);
    }

    @Override
    public List<ShipResponeDTO> findAll(){
      return responseMapper.shipResponeDTOList(iShipRepository.findAllShip());
    }

    @Override
    public Ship findByCode(String code){
        return iShipRepository.findByCode(code);
    }

    @Override
    public void delete(Ship ship){
        iShipRepository.delete(ship);
    }

    @Transactional
    public void removeById(Long id){
        if (iShipRepository.findById(id).isPresent()){
            Ship ship = iShipRepository.findById(id).get();
            ship.setDeleted(true);
            iShipRepository.save(ship);
        }
        System.out.println("Khong co id nay");
    }

    @Override
    @Transactional
    public void removeByCode(String code){
        Ship ship = iShipRepository.findByCode(code);
        ship.setDeleted(true);
        iShipRepository.save(ship);
    }

    @Override
    public List<Ship> findAllByStatus(Long status){
        return iShipRepository.findAllByStatusShip(status);
    }

    @Override
    public List<Ship> findAllShip(){
        return iShipRepository.findAll();
    }
}
