package com.kd.inventory.controller;


import com.kd.inventory.dto.InventoryDTO;
import com.kd.inventory.model.Inventory;
import com.kd.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/getinventories")
    public List<InventoryDTO> getInventories(){
        return inventoryService.getAllInventories();
    }

    @GetMapping("/getinventory/{id}")
    public InventoryDTO getInventoryById(@PathVariable int id){
        return inventoryService.getInventoryById(id);
    }

    @PostMapping("/addinventory")
    public InventoryDTO addInv(@RequestBody InventoryDTO newInventory){
        return inventoryService.saveInventory(newInventory);
    }

    @PutMapping("/updateinventory")
    public InventoryDTO updateInv(@RequestBody InventoryDTO newInventory){
        return inventoryService.updateInventory(newInventory);
    }

    @DeleteMapping("/deleteinventory/{id}")
    public String deleteInv(@PathVariable int id ){
        return inventoryService.deleteInventoryById(id);
    }
}
