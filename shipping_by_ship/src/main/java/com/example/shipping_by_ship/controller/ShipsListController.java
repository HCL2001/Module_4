package com.example.shipping_by_ship.controller;

import com.example.shipping_by_ship.service.impl.ShipListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/shipslist")
public class ShipsListController {

    @Autowired
    private ShipListService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showShipsList(){
        ModelAndView modelAndView = new ModelAndView("/shipslist");
        modelAndView.addObject("shipslist", service.findAllShips());
        return modelAndView;
    }

}
