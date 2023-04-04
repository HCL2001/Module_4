package com.example.shipping_by_ship.mapper;

import com.example.shipping_by_ship.model.dto.*;
import com.example.shipping_by_ship.model.orders.OrderCustomer;
import com.example.shipping_by_ship.model.orders.OrderDetailConfirmedToShips;
import com.example.shipping_by_ship.model.orders.OrderResponse;
import com.example.shipping_by_ship.model.ships.Ship;
import com.example.shipping_by_ship.model.ships.ShipsListFromShips;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestMapper {

    @Autowired
    private ModelMapper mapper;

    public Ship dtoToEntity(ShipResponeDTO shipResponeDTO){
        return mapper.map(shipResponeDTO, Ship.class);
    }

    public ShipsListFormShipsDTO shipsListFormShipsDTO(ShipsListFromShips ships){
        return mapper.map(ships, ShipsListFormShipsDTO.class);
    }

    public List<OrderResponeDTO> orderResponeDTOS(List<OrderResponse> orderResponses){
        return mapper.map(orderResponses, new TypeToken<List<OrderResponeDTO>>() {} .getType());
    }

    public OrderResponeDTO orderResponeDTO(OrderResponse orderResponse){
        return mapper.map(orderResponse, OrderResponeDTO.class);
    }

    public List<OrderCustomerDTO> orderCustomers(List<OrderCustomer> orderCustomers){
        return mapper.map(orderCustomers, new TypeToken<List<OrderCustomerDTO>>() {} .getType());
    }

    public OrderDetailsConfirmedToShipsDTO orderDetailsConfirmedToShipsDTO(OrderDetailConfirmedToShips orderDetailConfirmedToShips){
        return mapper.map(orderDetailConfirmedToShips, OrderDetailsConfirmedToShipsDTO.class);
    }

    public List<ShipResponeDTO> shipResponeDTOList(List<Ship> ships){
        return mapper.map(ships, new TypeToken<List<ShipResponeDTO>>() {}.getType());
    }

    public OrderCustomerDTO orderCustomerDTO(OrderCustomer orderCustomer){
        return mapper.map(orderCustomer, OrderCustomerDTO.class);
    }

    public OrderResponse orderResponse(OrderResponeDTO orderResponeDTO){
        return mapper.map(orderResponeDTO, OrderResponse.class);
    }
}
