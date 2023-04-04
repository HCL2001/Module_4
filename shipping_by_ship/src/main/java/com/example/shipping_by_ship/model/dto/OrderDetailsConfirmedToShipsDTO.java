package com.example.shipping_by_ship.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetailsConfirmedToShipsDTO implements Serializable {

    private String orderCode;

    private long weight;

    @ElementCollection
    private List<String> shipsCode;


    private String departureLocation;


    private String destination;

    public OrderDetailsConfirmedToShipsDTO(String orderCode, String receiverName, String senderName, long weight, List<String> shipsCode, String departureLocation, String destination) {
        this.orderCode = orderCode;
        this.weight = weight;
        this.shipsCode = shipsCode;
        this.departureLocation = departureLocation;
        this.destination = destination;
    }
}
