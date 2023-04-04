package com.example.shipping_by_ship.controller;

import com.example.shipping_by_ship.mapper.RequestMapper;
import com.example.shipping_by_ship.model.dto.ShipResponeDTO;
import com.example.shipping_by_ship.repository.IShipRepository;
import com.example.shipping_by_ship.service.IShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class ShipController {

    @Autowired
    private IShipService iShipService;

    @Autowired
    private RequestMapper requestMapper;
    @Autowired
    private IShipRepository iShipRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showMain() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("listShip", iShipService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/new_ship", method = RequestMethod.GET)
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("ship", new ShipResponeDTO());
        return modelAndView;
    }

    @RequestMapping(value = "/new_ship", method = RequestMethod.POST)
    public ModelAndView addShip(@ModelAttribute("ship") ShipResponeDTO shipResponeDTO) {
        ModelAndView modelAndView = new ModelAndView("/create");
        iShipService.save(requestMapper.dtoToEntity(shipResponeDTO));
        modelAndView.addObject("ship", new ShipResponeDTO());
        modelAndView.addObject("message", "OK");
        return modelAndView;
    }

    @RequestMapping(value = "/ship/{code}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("code") String code) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("ship", iShipService.findByCode(code));
        return modelAndView;
    }

    @RequestMapping(value = "/ship", method = RequestMethod.POST)
    public ModelAndView updateShip(@ModelAttribute ShipResponeDTO shipResponeDTO){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("ship", iShipRepository.findByCode(shipResponeDTO.getCode()));
        modelAndView.addObject("message", "OK");
        return modelAndView;
    }

    @RequestMapping(value = "/ship_out/{code}", method = RequestMethod.GET)
    public ModelAndView showDeleteForm(@PathVariable("code") String code){
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("ship", iShipService.findByCode(code));
        return modelAndView;
    }

    @RequestMapping(value = "/ship_out", method = RequestMethod.POST)
    public ModelAndView deleteShip(@ModelAttribute ShipResponeDTO shipResponeDTO){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin");
        iShipService.removeByCode(shipResponeDTO.getCode());
        return modelAndView;
    }
}
