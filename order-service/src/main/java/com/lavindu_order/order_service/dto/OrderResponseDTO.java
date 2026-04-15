package com.lavindu_order.order_service.dto;

import java.util.List;

import com.lavindu_order.order_service.entity.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {
    private Long id;
    
    private String orderNumber;

    private List<OrderLineItems> orderLineItemsList;

}
