package com.example.Bill_Generation.Repository;

import com.example.Bill_Generation.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
