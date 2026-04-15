package com.lavindu_order.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lavindu_order.order_service.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {
}