package com.project.qg.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private List<OrderItemDTO> items;

    @Data
    public static class OrderItemDTO {
        private Long itemId;
        private int quantity;
    }
}