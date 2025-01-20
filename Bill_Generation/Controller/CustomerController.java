package com.example.Bill_Generation.Controller;

import com.example.Bill_Generation.Dto.CustomerCreateRequestDto;
import com.example.Bill_Generation.Model.Customer;
import com.example.Bill_Generation.Model.ResponseDTO;
import com.example.Bill_Generation.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCustomer")
    public ResponseEntity<String> saveProduct(@RequestBody List<CustomerCreateRequestDto> customers){
         customerService.saveProduct(customers);
         return ResponseEntity.ok("customer saved successfully");
    }
}
