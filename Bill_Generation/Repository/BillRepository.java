package com.example.Bill_Generation.Repository;

import com.example.Bill_Generation.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
