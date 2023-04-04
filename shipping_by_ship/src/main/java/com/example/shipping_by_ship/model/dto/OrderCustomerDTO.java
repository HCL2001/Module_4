package com.example.shipping_by_ship.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
@Generated
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCustomerDTO implements Serializable {


    private String orderCode;

    private Long weight;

    private String departureLocation;

    private String destination;

    private boolean status = false;

    public OrderCustomerDTO(String orderCode, Long weight) {
        this.orderCode = orderCode;
        this.weight = weight;
    }
}
