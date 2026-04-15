package com.lavindu_order.order_service.mapper;

import com.lavindu_order.order_service.dto.OrderResponseDTO;
import com.lavindu_order.order_service.entity.Order;

public class OrderMapper {

    public Order toEntity(OrderResponseDTO dto){
        Order order = new Order();
        order.setId(dto.getId());
        order.setOrderNumber(dto.getOrderNumber());
        order.setOrderLineItemsList(dto.getOrderLineItemsList());
        return order;
    }

    public OrderResponseDTO toResponseDto(Order order){
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setOrderNumber(order.getOrderNumber());
        dto.setOrderLineItemsList(order.getOrderLineItemsList());
        return dto;
    }
    
}
