package com.project.qg.service;

import com.project.qg.dto.GroceryItemDTO;
import com.project.qg.entity.GroceryItem;

import java.util.List;

public interface AdminService {
    GroceryItem addGroceryItem(GroceryItemDTO groceryItemDTO);
    List<GroceryItem> getAllGroceryItems();
    boolean removeGroceryItem(Long id);
    GroceryItem updateGroceryItem(Long id, GroceryItemDTO groceryItemDTO);
    GroceryItem manageInventory(Long id, int inventory);
}