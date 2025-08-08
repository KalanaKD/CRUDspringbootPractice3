package com.kd.inventory.service;

import com.kd.inventory.dto.InventoryDTO;
import com.kd.inventory.model.Inventory;
import com.kd.inventory.repo.InventoryRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<InventoryDTO> getAllInventories(){
        List<Inventory> inventoryList = inventoryRepo.findAll();
        return modelMapper.map(inventoryList, new TypeToken<List<InventoryDTO>>(){}.getType());
    }
    public InventoryDTO getInventoryById(int id){
        Inventory inventory = inventoryRepo.getItemById(id);
        return modelMapper.map(inventory, InventoryDTO.class);
    }
    public InventoryDTO saveInventory(InventoryDTO newInventory){
        inventoryRepo.save(modelMapper.map(newInventory, Inventory.class));
        return newInventory;
    }
    public InventoryDTO updateInventory(InventoryDTO newInventory){
        inventoryRepo.save(modelMapper.map(newInventory, Inventory.class));
        return newInventory;
    }
    public String deleteInventoryById(int id){
        inventoryRepo.deleteById(id);
        return "Inventory deleted";
    }

}
