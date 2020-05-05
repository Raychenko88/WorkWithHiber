package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer closed;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "creation_time")
    private Long creationTime;

    public Cart(Integer closed, Integer userId, Long creationTime) {
        this.closed = closed;
        this.userId = userId;
        this.creationTime = creationTime;
    }
}
