package com.lavindu_inventory.inventory_service.mapper;

import com.lavindu_inventory.inventory_service.DTO.InventoryResponseDTO;
import com.lavindu_inventory.inventory_service.Entity.Inventory;

public class InventoryMapper {
    
    public static InventoryResponseDTO mapToInventoryResponse(Inventory inventory) {
        return InventoryResponseDTO.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() != null && inventory.getQuantity() > 0)
                .build();
    }
}
