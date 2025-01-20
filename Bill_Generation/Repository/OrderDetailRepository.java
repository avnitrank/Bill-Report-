package com.example.Bill_Generation.Repository;

import com.example.Bill_Generation.Model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
