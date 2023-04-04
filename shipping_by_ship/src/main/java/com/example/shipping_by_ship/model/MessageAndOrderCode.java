package com.example.shipping_by_ship.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@Generated
@AllArgsConstructor
public class MessageAndOrderCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;

    private String orderCode;

    public MessageAndOrderCode(Message message, String orderCode) {
        this.message = message;
        this.orderCode = orderCode;
    }
}
