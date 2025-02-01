package com.project.qg.service.impl;

import com.project.qg.dto.OrderDTO;
import com.project.qg.entity.GroceryItem;
import com.project.qg.entity.Order;
import com.project.qg.entity.OrderItem;
import com.project.qg.repository.GroceryItemRepository;
import com.project.qg.repository.OrderItemRepository;
import com.project.qg.repository.OrderRepository;
import com.project.qg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<GroceryItem> getAllAvailableGroceryItems() {
        return groceryItemRepository.findAll().stream()
                .filter(item -> item.getInventory() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public Order placeOrder(OrderDTO orderDTO) {
        Order order = new Order();
        orderRepository.save(order);

        for (OrderDTO.OrderItemDTO itemDTO : orderDTO.getItems()) {
            GroceryItem groceryItem = groceryItemRepository.findById(itemDTO.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            if (groceryItem.getInventory() < itemDTO.getQuantity()) {
                throw new RuntimeException("Insufficient inventory for item: " + groceryItem.getName());
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setGroceryItem(groceryItem);
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);

            groceryItem.setInventory(groceryItem.getInventory() - itemDTO.getQuantity());
            groceryItemRepository.save(groceryItem);
        }

        return order;
    }
}