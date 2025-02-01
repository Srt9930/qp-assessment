package com.project.qg.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private int inventory;
}