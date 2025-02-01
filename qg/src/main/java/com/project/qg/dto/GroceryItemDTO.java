package com.project.qg.dto;

import lombok.Data;

@Data
public class GroceryItemDTO {
    private String name;
    private double price;
    private int inventory;
}