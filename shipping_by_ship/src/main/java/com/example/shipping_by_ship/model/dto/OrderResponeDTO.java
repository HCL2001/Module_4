package com.example.shipping_by_ship.model.dto;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

import java.util.List;

@Setter
@Getter
@Generated
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponeDTO {


    private String orderCode;


    private long weight;

    @ElementCollection
    @Column(name = "ship_code")
    private List<String> shipsCode;

    private String departureLocation;

    private String destination;

    private String departureDate;

    private String arrivalDate;

    private boolean isConfirming = false;

    private boolean isDelivering = false;

    public boolean isConfirming() {
        return isConfirming;
    }

    public void setConfirming(boolean confirming) {
        isConfirming = confirming;
    }

    public boolean isDelivering() {
        return isDelivering;
    }

    public void setDelivering(boolean delivering) {
        isDelivering = delivering;
    }


}
