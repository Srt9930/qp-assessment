package com.project.qg.service;

import com.project.qg.dto.OrderDTO;
import com.project.qg.entity.GroceryItem;
import com.project.qg.entity.Order;

import java.util.List;

public interface UserService {
    List<GroceryItem> getAllAvailableGroceryItems();
    Order placeOrder(OrderDTO orderDTO);
}