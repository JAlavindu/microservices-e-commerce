package com.lavindu_order.order_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lavindu_order.order_service.dto.InventoryResponseDTO;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryClient{
    
    @GetMapping("/inventory")
    List<InventoryResponseDTO> isInStock(@RequestParam List<String> skuCode);
}