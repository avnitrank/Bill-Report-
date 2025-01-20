package com.example.Bill_Generation.Repository;

import com.example.Bill_Generation.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
