package com.example.shipping_by_ship.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipResponeDTO implements Serializable {

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "weight")
    private Long weight;

    @JsonProperty(value = "status")
    private Long statusShip = 0L;

    public ShipResponeDTO(String code, String name, String type, Long weight, Long status) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.statusShip = 0L;
    }
}
