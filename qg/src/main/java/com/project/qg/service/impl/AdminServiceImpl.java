package com.project.qg.service.impl;

import com.project.qg.dto.GroceryItemDTO;
import com.project.qg.entity.GroceryItem;
import com.project.qg.repository.GroceryItemRepository;
import com.project.qg.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Override
    public GroceryItem addGroceryItem(GroceryItemDTO groceryItemDTO) {
        GroceryItem groceryItem = new GroceryItem();
        groceryItem.setName(groceryItemDTO.getName());
        groceryItem.setPrice(groceryItemDTO.getPrice());
        groceryItem.setInventory(groceryItemDTO.getInventory());
        return groceryItemRepository.save(groceryItem);
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public boolean removeGroceryItem(Long id) {
        if (!ObjectUtils.isEmpty(groceryItemRepository.findById(id))){
            groceryItemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public GroceryItem updateGroceryItem(Long id, GroceryItemDTO groceryItemDTO) {
        GroceryItem groceryItem = groceryItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        groceryItem.setName(groceryItemDTO.getName());
        groceryItem.setPrice(groceryItemDTO.getPrice());
        groceryItem.setInventory(groceryItemDTO.getInventory());
        return groceryItemRepository.save(groceryItem);
    }

    @Override
    public GroceryItem manageInventory(Long id, int inventory) {
        GroceryItem groceryItem = groceryItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        groceryItem.setInventory(inventory);
        return groceryItemRepository.save(groceryItem);
    }
}