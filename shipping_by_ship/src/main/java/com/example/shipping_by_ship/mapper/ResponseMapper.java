package com.example.shipping_by_ship.mapper;

import com.example.shipping_by_ship.model.dto.*;
import com.example.shipping_by_ship.model.orders.Order;
import com.example.shipping_by_ship.model.orders.OrderCustomer;
import com.example.shipping_by_ship.model.orders.OrderDetailConfirmedToShips;
import com.example.shipping_by_ship.model.orders.OrderResponse;
import com.example.shipping_by_ship.model.ships.Ship;
import com.example.shipping_by_ship.model.ships.ShipsListFromShips;
import com.example.shipping_by_ship.service.impl.OrderResponeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class ResponseMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OrderResponeService orderResponeService;

    public  ShipResponeDTO responeDTO(Ship ship){
        return mapper.map(ship, ShipResponeDTO.class);
    }

    public List<ShipResponeDTO> shipResponeDTOList(List<Ship> ships){
        return mapper.map(ships, new TypeToken<List<ShipResponeDTO>>() {}.getType());
    }

    public OrderResponeDTO orderResponeDTO(Ship ship){
        return mapper.map(ship, OrderResponeDTO.class);
    }

    public List<OrderResponeDTO> orderResponeDTOList(List<Order> orders){
//        List<OrderResponeDTO> mapperOrderResponseDTOlist = new ArrayList<>();
//        orders.stream().map(order -> mapperOrderResponseDTOlist);
//        return mapperOrderResponseDTOlist;
        return mapper.map(orders, new TypeToken<List<OrderResponeDTO>>() {}.getType());
    }

    public ShipsListFormShipsDTO shipsListFormShipsDTO(ShipsListFromShips ships){
        return mapper.map(ships, ShipsListFormShipsDTO.class);
    }

    public List<ShipsListFormShipsDTO> shipsDTOS(List<ShipsListFromShips> ships){
        return mapper.map(ships, new TypeToken<List<ShipsListFormShipsDTO>>() {}.getType());
    }

    public OrderDetailConfirmedToShips confirmedToShips(OrderDetailsConfirmedToShipsDTO toShipsDTO){

        return mapper.map(toShipsDTO, OrderDetailConfirmedToShips.class);
    }

    public OrderCustomer orderCustomer(OrderCustomerDTO orderCustomerDTO){
        return mapper.map(orderCustomerDTO, OrderCustomer.class);
    }

    public OrderResponse orderResponse(OrderResponeDTO orderResponeDTO){
        return mapper.map(orderResponeDTO, OrderResponse.class);
    }



}
