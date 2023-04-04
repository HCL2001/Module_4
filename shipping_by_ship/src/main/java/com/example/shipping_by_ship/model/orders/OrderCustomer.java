package com.example.shipping_by_ship.model.orders;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
@Generated
public class OrderCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderCode;

    private Long weight;

    private String departureLocation;

    private String destination;

    private boolean status = false;

    private boolean isDeleted;

    public OrderCustomer(String orderCode, Long weight) {
        this.orderCode = orderCode;
        this.weight = weight;
    }

}
