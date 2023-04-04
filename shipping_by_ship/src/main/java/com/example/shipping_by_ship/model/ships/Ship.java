package com.example.shipping_by_ship.model.ships;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ships")
@Getter
@Setter
@NoArgsConstructor
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private Long statusShip = 0L;
    @Column(name = "weight")
    private Long weight;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    public Ship(Long id, String code, String name, String type, Long status, Long weight, boolean isDeleted) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.statusShip = 0L;
        this.weight = weight;
        this.isDeleted = isDeleted;
    }

    public Ship(String code, String name, String type, Long status, Long weight, boolean isDeleted) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.statusShip = 0L;
        this.weight = weight;
        this.isDeleted = isDeleted;
    }
}
