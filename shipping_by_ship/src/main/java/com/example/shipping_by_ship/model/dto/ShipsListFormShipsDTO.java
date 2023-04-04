package com.example.shipping_by_ship.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Generated
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipsListFormShipsDTO implements Serializable {

    @Column(name = "check_id")
    private String checkId;

    @Column(name = "ships_list")
    @ElementCollection
    private List<String> shipsList;

    private String orderCode;

    private String date;

}
