package com.example.shipping_by_ship.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@Generated
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    private String message;

    private String date;

    public Message(String message, String date) {
        this.message = message;
        this.date = date;
    }
}
