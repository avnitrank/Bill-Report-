package com.example.Bill_Generation.Service;

import com.example.Bill_Generation.Dto.CustomerCreateRequestDto;
import com.example.Bill_Generation.Model.Customer;
import com.example.Bill_Generation.Model.ResponseDTO;
import com.example.Bill_Generation.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void saveProduct(List<CustomerCreateRequestDto> customers) {
        List<Customer> customerDetailsList = new ArrayList<>();
        for(CustomerCreateRequestDto customer : customers){
            Customer customerDetails = new Customer();
            customerDetails.setName(customer.getName());
            customerDetails.setEmail(customer.getEmail());
            customerDetails.setMobileNumber(customer.getMobileNumber());
            customerDetailsList.add(customerDetails);
        }
         customerRepository.saveAll(customerDetailsList);
    }


}
