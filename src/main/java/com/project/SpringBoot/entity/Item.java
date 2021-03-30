package com.project.SpringBoot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Item")
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long itemId;

    @Column(name = "item_name")
    String itemName;

    @Column(name = "item_quantity")
    Integer itemQuantity;

    @Column(name = "item_price")
    Double itemPrice;

    @Transient
    Double totalAmount;

    public Item(Long itemId, String itemName, Integer itemQuantity, Double itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    public Item(String itemName, Integer itemQuantity, Double itemPrice) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }
}
