package com.lavindu_inventory.inventory_service.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lavindu_inventory.inventory_service.DTO.InventoryResponseDTO;
import com.lavindu_inventory.inventory_service.mapper.InventoryMapper;
import com.lavindu_inventory.inventory_service.repo.InventoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponseDTO> isInStock(List<String> skuCode) {
        return inventoryRepository.findAllBySkuCodeIn(skuCode).stream()
                .map(InventoryMapper::mapToInventoryResponse) // Now this works!
                .toList();
    }
    
}
