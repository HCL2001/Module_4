package com.example.shipping_by_ship.model.ships;


import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shipslistformships")
@Setter
@Getter
@Generated
@NoArgsConstructor
public class ShipsListFromShips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_id")
    private String checkId;

    @Column(name = "ships_list")
    @ElementCollection
    private List<String> shipsList;

    private String orderCode;

    private String date;

    private boolean isDeleted;

    public ShipsListFromShips(Long id, String checkId, List<String> shipsList, String date) {
        this.id = id;
        this.checkId = checkId;
        this.shipsList = shipsList;
        this.date = date;
    }

}
