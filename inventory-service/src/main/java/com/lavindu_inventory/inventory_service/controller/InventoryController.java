package com.lavindu_inventory.inventory_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lavindu_inventory.inventory_service.DTO.InventoryResponseDTO;
import com.lavindu_inventory.inventory_service.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping()
    public ResponseEntity<List<InventoryResponseDTO>> isInstock(@RequestParam List<String> skuCode) {
        return new ResponseEntity<>(inventoryService.isInStock(skuCode), HttpStatus.OK);
    }
}
