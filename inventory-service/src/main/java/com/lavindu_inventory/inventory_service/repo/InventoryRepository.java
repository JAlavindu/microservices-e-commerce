package com.lavindu_inventory.inventory_service.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lavindu_inventory.inventory_service.Entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findBySkuCode(String skuCode);

    List<Inventory> findAllBySkuCodeIn(List<String> skuCode);
    
}
