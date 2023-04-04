package com.example.shipping_by_ship.model.orders;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Generated
@NoArgsConstructor
@Entity
@Table
@Setter
@Getter
public class OrderDetailConfirmedToShips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderCode;


    private long weight;

    @ElementCollection
    private List<String> shipsCode;


    private String departureLocation;


    private String destination;

    private boolean status = false;

    private boolean isDeleted;

    public OrderDetailConfirmedToShips(String orderCode, String receiverName, String senderName, long weight, List<String> shipsCode, String departureLocation, String destination) {
        this.orderCode = orderCode;
        this.weight = weight;
        this.shipsCode = shipsCode;
        this.departureLocation = departureLocation;
        this.destination = destination;
    }
}
