package com.example.shipping_by_ship.controller;

import com.example.shipping_by_ship.mapper.RequestMapper;
import com.example.shipping_by_ship.model.Message;
import com.example.shipping_by_ship.model.MessageAndOrderCode;
import com.example.shipping_by_ship.model.dto.OrderResponeDTO;
import com.example.shipping_by_ship.model.orders.OrderCustomer;
import com.example.shipping_by_ship.model.orders.OrderResponse;
import com.example.shipping_by_ship.model.ships.Ship;
import com.example.shipping_by_ship.model.ships.ShipsListFromShips;
import com.example.shipping_by_ship.service.*;
import com.example.shipping_by_ship.service.thirdService.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private IOrderCustomerService customerService;

    @Autowired
    private IOrderResponseService orderResponeService;

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private IOrderDetailService orderDetailService;

    @Autowired
    private OrderRequest orderRequest;

    @Autowired
    private IShipListService service;

    @Autowired
    private IShipService shipService;


    @RequestMapping(value = "/orderCustomer", method = RequestMethod.GET)
    public ModelAndView showOrderCustomer() {
        ModelAndView modelAndView = new ModelAndView("/orderCustomer");
        modelAndView.addObject("list", requestMapper.orderCustomers(customerService.findAll()));
        return modelAndView;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showOrderPage() {
        return new ModelAndView("/order");
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public ModelAndView showDetailOrder(@PathVariable("code") String code) {
        ModelAndView modelAndView = new ModelAndView("/orderDetail");
        modelAndView.addObject("order", requestMapper.orderDetailsConfirmedToShipsDTO(orderDetailService.confirmedToShipsByCode(code)));
        return modelAndView;
    }

    @RequestMapping(value = "/confirm/{code}", method = RequestMethod.GET)
    public ModelAndView showConfirmPage(@PathVariable("code") String code) {
        ModelAndView modelAndView = new ModelAndView("/confirmPage");
        OrderResponeDTO orderResponeDTO = new OrderResponeDTO();
        orderResponeDTO.setShipsCode(service.findByCode(code).getShipsList());
        orderResponeDTO.setOrderCode(code);
        orderResponeDTO.setWeight(requestMapper.orderCustomerDTO(customerService.findByCode(code)).getWeight());
        orderResponeDTO.setDepartureLocation(requestMapper.orderCustomerDTO(customerService.findByCode(code)).getDepartureLocation());
        orderResponeDTO.setDestination(requestMapper.orderCustomerDTO(customerService.findByCode(code)).getDestination());
        orderResponeService.save(requestMapper.orderResponse(orderResponeDTO));
        modelAndView.addObject("order", orderResponeDTO);
        return modelAndView;
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public ModelAndView confirming(@ModelAttribute OrderResponeDTO orderResponeDTO) {
        ModelAndView modelAndView = new ModelAndView("redirect:");
        OrderResponse orderResponse = orderResponeService.findByOrderCode(orderResponeDTO.getOrderCode());
        orderResponse.setDepartureDate(orderResponeDTO.getDepartureDate());
        orderResponse.setArrivalDate(orderResponeDTO.getArrivalDate());
        orderResponse.setConfirming(true);
        OrderCustomer orderCustomer = customerService.findByCode(orderResponse.getOrderCode());
        orderCustomer.setStatus(true);
        customerService.save(orderCustomer);
        orderResponeService.save(orderResponeService.findByOrderCode(orderResponeDTO.getOrderCode()));
        orderRequest.sendAPI(requestMapper.orderResponeDTO(orderResponse));
        return modelAndView;
    }

    @RequestMapping(value = "/confirmed", method = RequestMethod.GET)
    public ModelAndView hasConfirmed() {
        ModelAndView modelAndView = new ModelAndView("/orderConfirmed");
        modelAndView.addObject("orderConfirmedList", requestMapper.orderResponeDTOS(orderResponeService.findAll()));
        return modelAndView;
    }

    @RequestMapping(value = "/ship_come/{code}", method = RequestMethod.GET)
    public ModelAndView showConfirmShipComePage(@PathVariable("code") String code){
        ModelAndView modelAndView = new ModelAndView("/ship_come");
        modelAndView.addObject("ship_come", orderResponeService.findByOrderCode(code));
        return modelAndView;
    }

    @RequestMapping(value = "/ship_come",method = RequestMethod.POST)
    public ModelAndView confirmShipCome(@ModelAttribute OrderResponeDTO orderResponeDTO){
        OrderResponse orderResponse = orderResponeService.findByOrderCode(orderResponeDTO.getOrderCode());
        orderResponse.setDelivering(true);
        ShipsListFromShips ships = service.findByCode(orderResponse.getOrderCode());
        List<String> shipList =  ships.getShipsList();
        for (String s:
             shipList) {
            Ship ship = shipService.findByCode(s);
            ship.setStatusShip(0L);
            shipService.save(ship);
        }
        orderResponeService.save(orderResponse);
        orderRequest.sendAPIMessage(new MessageAndOrderCode(new Message("DONE", new Date().toString()), orderResponeDTO.getOrderCode()));
        return new ModelAndView("redirect:");
    }
}
