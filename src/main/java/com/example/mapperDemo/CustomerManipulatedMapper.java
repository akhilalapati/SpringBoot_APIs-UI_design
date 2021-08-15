package com.example.mapperDemo;

import org.jetbrains.annotations.NotNull;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerManipulatedMapper {

    CustomerDTO manipulatedcustomerTOCustomerDTO(Customer customer);

    Customer manipulatedCustomerDTOToCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> manipulatedcustomersTOCustomerDTO(List<Customer> customers);
}


