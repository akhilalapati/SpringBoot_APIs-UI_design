package com.example.mapperDemo;

import org.jetbrains.annotations.NotNull;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    CustomerDTO customerTOCustomerDTO(Customer customer);

    List<Customer> customerDTOsTOCustomers(List<CustomerDTO> customerDTOList);

    List<CustomerDTO> customersToCustomerDTOs(List<Customer> customerList);


}
