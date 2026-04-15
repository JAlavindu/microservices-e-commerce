package com.lavindu_order.order_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lavindu_order.order_service.dto.InventoryResponseDTO;
import com.lavindu_order.order_service.dto.OrderRequestDTO;
import com.lavindu_order.order_service.dto.OrderResponseDTO;
import com.lavindu_order.order_service.entity.Order;
import com.lavindu_order.order_service.feign.InventoryClient;
import com.lavindu_order.order_service.mapper.OrderMapper;
import com.lavindu_order.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO){
        orderRequestDTO.setOrderNumber(UUID.randomUUID().toString());

        OrderMapper orderMapper = new OrderMapper();
        Order order = new Order();
        order.setOrderNumber(orderRequestDTO.getOrderNumber());
        order.setOrderLineItemsList(orderRequestDTO.getOrderLineItemsList());

        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(orderLineItems -> orderLineItems.getSkuCode())
                .toList();
        
        List<InventoryResponseDTO> inventoryResponse = inventoryClient.isInStock(skuCodes);
        boolean allProductsInStock = inventoryResponse.stream()
                .allMatch(InventoryResponseDTO::isInStock);

        if (allProductsInStock && !skuCodes.isEmpty()) {
            Order savedOrder = orderRepository.save(order);
            
            // 6. Map back to Response DTO
            return orderMapper.toResponseDto(savedOrder);
        } else {
            throw new IllegalArgumentException("One or more products are not in stock, please try again later.");
        }
    }
}
