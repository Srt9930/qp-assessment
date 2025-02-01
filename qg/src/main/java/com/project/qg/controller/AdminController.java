package com.project.qg.controller;

import com.project.qg.dto.GroceryItemDTO;
import com.project.qg.entity.GroceryItem;
import com.project.qg.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/grocery")
    public GroceryItem addGroceryItem(@RequestBody GroceryItemDTO groceryItemDTO) {
        return adminService.addGroceryItem(groceryItemDTO);
    }

    @GetMapping("/grocery")
    public List<GroceryItem> getAllGroceryItems() {
        return adminService.getAllGroceryItems();
    }

    @DeleteMapping("/grocery/{id}")
    public String removeGroceryItem(@PathVariable Long id) {
        boolean isAvailable = adminService.removeGroceryItem(id);
        if (isAvailable){
            return "Grocery item has deleted successfully!";
        }
        return "No item was found to delete";
    }

    @PutMapping("/grocery/{id}")
    public GroceryItem updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItemDTO groceryItemDTO) {
        return adminService.updateGroceryItem(id, groceryItemDTO);
    }

    @PatchMapping("/grocery/{id}/inventory")
    public GroceryItem manageInventory(@PathVariable Long id, @RequestParam int inventory) {
        return adminService.manageInventory(id, inventory);
    }
}