package com.kd.inventory.repo;

import com.kd.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

    @Query(value="SELECT * FROM inventory WHERE id=?1" , nativeQuery = true)
    Inventory getItemById(int id);
}
