package com.project.qg.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "grocery_item_id")
    private GroceryItem groceryItem;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}