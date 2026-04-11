package com.lavindu_inventory.inventory_service.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lavindu_inventory.inventory_service.DTO.InventoryResponseDTO;
import com.lavindu_inventory.inventory_service.Entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    

    List<Inventory> findAllBySkuCodeIn(List<String> skuCode);

    
}
