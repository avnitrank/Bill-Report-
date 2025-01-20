package com.example.Bill_Generation.Repository;

import com.example.Bill_Generation.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
