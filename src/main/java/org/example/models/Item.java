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
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;
    private String code;
    private Integer price;
    private Integer availability;

    public Item(String name, String code, Integer price, Integer availability) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.availability = availability;
    }
}
