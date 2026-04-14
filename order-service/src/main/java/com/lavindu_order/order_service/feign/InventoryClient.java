package com.lavindu_order.order_service.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "inventory-service")
public interface InventoryClient{
    
    @Getmapping("/inventory")
    List<InventoryResponseDTO> isInStock(@RequestParam List<String> skuCode);
}