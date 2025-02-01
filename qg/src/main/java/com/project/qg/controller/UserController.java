package com.project.qg.controller;


import com.project.qg.dto.OrderDTO;
import com.project.qg.entity.GroceryItem;
import com.project.qg.entity.Order;
import com.project.qg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/grocery")
    public List<GroceryItem> getAllAvailableGroceryItems() {
        return userService.getAllAvailableGroceryItems();
    }

    @PostMapping("/order")
    public Order placeOrder(@RequestBody OrderDTO orderDTO) {
        return userService.placeOrder(orderDTO);
    }
}