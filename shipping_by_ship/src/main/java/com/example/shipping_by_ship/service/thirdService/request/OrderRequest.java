package com.example.shipping_by_ship.service.thirdService.request;

import com.example.shipping_by_ship.mapper.RequestMapper;
import com.example.shipping_by_ship.mapper.ResponseMapper;
import com.example.shipping_by_ship.model.MessageAndOrderCode;
import com.example.shipping_by_ship.model.dto.OrderCustomerDTO;
import com.example.shipping_by_ship.model.dto.OrderResponeDTO;
import com.example.shipping_by_ship.model.dto.ShipResponeDTO;
import com.example.shipping_by_ship.model.ships.Ship;
import com.example.shipping_by_ship.model.ships.ShipsListFromShips;
import com.example.shipping_by_ship.service.IOrderCustomerService;
import com.example.shipping_by_ship.service.IOrderResponseService;
import com.example.shipping_by_ship.service.IShipListService;
import com.example.shipping_by_ship.service.IShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderRequest {

    @Autowired
    private IShipService iShipService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IShipListService iShipListService;

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private ResponseMapper responseMapper;

    @Autowired
    private IOrderResponseService iOrderResponseService;
    @Autowired
    private IOrderCustomerService iOrderCustomerService;

    public void demooo(OrderCustomerDTO orderCustomerDTO) {
//        RequestEntity<?> request = RequestEntity.post("http://192.168.4.107:8080/api/ships-list-from-ships")
//                .accept(MediaType.APPLICATION_JSON)
//                .header("url", "192.168.4.89")
//                .header("secret_key", "longHoang0911")
//                .header("signature", "long")
//                .body(requestMapper.shipsListFormShipsDTO(ships(orderCustomerDTO)));
        requestMapper.shipsListFormShipsDTO(ships(orderCustomerDTO));
        iOrderCustomerService.save(responseMapper.orderCustomer(orderCustomerDTO));
        ShipsListFromShips ships = iShipListService.findByCode(orderCustomerDTO.getOrderCode());
        Ship ship;
        for (String s : ships.getShipsList()
        ) {
            ship = iShipService.findByCode(s);
            ship.setStatusShip(1L);
            iShipService.save(ship);
        }
//        ResponseEntity<?> response = restTemplate.exchange(request, String.class);
//        System.out.println(response);
    }

    public List<ShipResponeDTO> checkAvail(OrderCustomerDTO orderCustomerDTO) {
        List<ShipResponeDTO> temp = new ArrayList<>();
        //New
        Long tempWeight = orderCustomerDTO.getWeight();
//
        for (ShipResponeDTO s : requestMapper.shipResponeDTOList(iShipService.findAllByStatus(0L))
        ) {
            if (s.getWeight() >= tempWeight) {
                temp.add(s);
                tempWeight -= s.getWeight();
                //New
                break;
                //
            } else if (s.getWeight() <= orderCustomerDTO.getWeight()) {
                temp.add(s);
                tempWeight -= s.getWeight();
            }
            //
        }
        if (tempWeight > 0){
            return null;
        }
        return temp;
    }

    public ShipsListFromShips ships(OrderCustomerDTO orderCustomerDTO) {
        ShipsListFromShips ships = new ShipsListFromShips();
        List<String> temp = new ArrayList<>();
        for (ShipResponeDTO code : checkAvail(orderCustomerDTO)
        ) {
            temp.add(code.getCode());
        }
        ships.setShipsList(temp);
        ships.setCheckId("Long");
        ships.setDate(new Date().toString());
        ships.setOrderCode(orderCustomerDTO.getOrderCode());
        iShipListService.save(ships);
        return ships;
    }

//    public OrderResponeDTO orderResponeDTO(OrderDetailsConfirmedToShipsDTO orderDetailsConfirmedToShipsDTO) {
//        OrderResponeDTO orderResponeDTO = new OrderResponeDTO();
//        orderResponeDTO.setOrderCode(orderDetailsConfirmedToShipsDTO.getOrderCode());
//        orderResponeDTO.setWeight(orderDetailsConfirmedToShipsDTO.getWeight());
//        orderResponeDTO.setShipsCode(orderResponeDTO.getShipsCode());
//        orderResponeDTO.setDestination(orderDetailsConfirmedToShipsDTO.getDestination());
//        orderResponeDTO.setDepartureLocation(orderResponeDTO.getDepartureLocation());
//        iOrderResponseService.save(responseMapper.orderResponse(orderResponeDTO));
//        return orderResponeDTO;
//    }

//    public void sendFinalOrder(String orderCode) {
//        RequestEntity<?> request = RequestEntity.post("http://192.168.4.107:8080/api/order-received-from-ships")
//                .accept(MediaType.APPLICATION_JSON)
//                .body(requestMapper.orderResponeDTO(iOrderResponseService.findByOrderCode(orderCode)));
//        ResponseEntity<?> response = restTemplate.exchange(request, String.class);
//        System.out.println(response);
//    }

    public void sendAPI(OrderResponeDTO orderResponeDTO) {
        RequestEntity<?> request = RequestEntity.post("http://192.168.4.107:8080/api/receive-full-order-from-ships")
                .accept(MediaType.APPLICATION_JSON)
                .body(orderResponeDTO);
        ResponseEntity<?> response = restTemplate.exchange(request, String.class);
        System.out.println(response.getBody());
    }

    public void sendAPIMessage(MessageAndOrderCode done) {
        RequestEntity<?> request = RequestEntity.post("http://192.168.4.107:8080/api/receive-signal")
                .accept(MediaType.APPLICATION_JSON)
                .body(done);
        ResponseEntity<?> response = restTemplate.exchange(request, String.class);
        System.out.println(response);
    }
}
