package com.example.shipping_by_ship.model.orders;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Generated
public class Order {

    private Long id;

    private String orderCode;

    private String receiverName;

    private String senderName;

    private long weight;

    private List<String> shipsCode;

    private String departureLocation;

    private String destination;

    private String departureDate;

    private String arrivalDate;

    private boolean isDeleted;

    public Order(Long id, String orderCode, String receiverName, String senderName, long weight, List<String> shipsCode, String departureLocation, String destination, String departureDate, String arrivalDate, boolean isDeleted) {
        this.id = id;
        this.orderCode = orderCode;
        this.receiverName = receiverName;
        this.senderName = senderName;
        this.weight = weight;
        this.shipsCode = shipsCode;
        this.departureLocation = departureLocation;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.isDeleted = isDeleted;
    }

    public Order(String orderCode, String receiverName, String senderName, long weight, List<String> shipsCode, String departureLocation, String destination, String departureDate, String arrivalDate, boolean isDeleted) {
        this.orderCode = orderCode;
        this.receiverName = receiverName;
        this.senderName = senderName;
        this.weight = weight;
        this.shipsCode = shipsCode;
        this.departureLocation = departureLocation;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.isDeleted = isDeleted;
    }

    public Order(String orderCode, String receiverName, String senderName, long weight, List<String> shipsCode, String departureLocation, String destination, String departureDate, String arrivalDate) {
        this.orderCode = orderCode;
        this.receiverName = receiverName;
        this.senderName = senderName;
        this.weight = weight;
        this.shipsCode = shipsCode;
        this.departureLocation = departureLocation;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }
}
