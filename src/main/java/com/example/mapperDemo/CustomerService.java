package com.example.mapperDemo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    void addCustomer(Customer customer);

    List<Customer> getDBCustomers();

    CustomerDTO getMapperCustomer(Long id);

    List<CustomerDTO> getAllMapperCustomers();

    CustomerDTO getManipulatedMapper(Long id);
}
