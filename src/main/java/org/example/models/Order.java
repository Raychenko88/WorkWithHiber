package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "cart_id")
    private Integer cartId;
    private Integer amount;

    public Order(int itemId, int cartId, Integer amount) {
        this.itemId = itemId;
        this.cartId = cartId;
        this.amount = amount;
    }
}
