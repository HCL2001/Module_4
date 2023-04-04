package com.example.shipping_by_ship.controller;

import com.example.shipping_by_ship.mapper.ResponseMapper;
import com.example.shipping_by_ship.model.dto.OrderCustomerDTO;
import com.example.shipping_by_ship.model.dto.OrderDetailsConfirmedToShipsDTO;
import com.example.shipping_by_ship.service.IOrderCustomerService;
import com.example.shipping_by_ship.service.IOrderDetailService;
import com.example.shipping_by_ship.service.thirdService.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api")
public class RestController {

    @Autowired
    private OrderRequest orderRequest;

    @Autowired
    private ResponseMapper responseMapper;

    @Autowired
    private IOrderDetailService iOrderDetailService;

    @Autowired
    private IOrderCustomerService iOrderCustomerService;



    @PostMapping(value = "/order_contact")
    public ResponseEntity<?> orderContact(@RequestBody OrderCustomerDTO orderCustomerDTO){
        if (orderRequest.checkAvail(orderCustomerDTO) == null) {
            return new ResponseEntity<>("Khong co tau", HttpStatus.NO_CONTENT);
        }
        orderRequest.demooo(orderCustomerDTO);
        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);
    }

//    @PostMapping(value = "/order_contact_full")
//    public ResponseEntity<?> orderContactFull(@RequestBody OrderDetailsConfirmedToShipsDTO orderDetailsConfirmedToShipsDTO){
//        iOrderDetailService.save(responseMapper.confirmedToShips(orderDetailsConfirmedToShipsDTO));
//        System.out.println(orderRequest.orderResponeDTO(orderDetailsConfirmedToShipsDTO));
//        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);
//    }

//    @PostMapping(value = "/final_order")
//    public ResponseEntity<?> final_order(@RequestBody String orderCode){
////        orderRequest.sendFinalOrder(orderCode);
//        return new ResponseEntity<>("Done", HttpStatus.OK);
//    }

}
