package com.example.shipping_by_ship.model.orders;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Generated
@Setter
@Getter
public class OrderResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderCode;


    private long weight;

    private boolean isDeleted;

    @ElementCollection
    @Column(name = "ship_code")
    private List<String> shipsCode;

    private String departureLocation;

    private String destination;

    private String departureDate;

    private String arrivalDate;

    private boolean isConfirming = false;

    private boolean isDelivering = false;

    public OrderResponse(String orderCode, String receiverName, String senderName, long weight, List<String> shipsCode, String departureLocation, String destination, String departureDate, String arrivalDate) {
        this.orderCode = orderCode;
        this.weight = weight;
        this.shipsCode = shipsCode;
        this.departureLocation = departureLocation;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }
}
