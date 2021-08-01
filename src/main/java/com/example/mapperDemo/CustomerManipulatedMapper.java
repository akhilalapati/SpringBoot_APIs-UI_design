package com.example.mapperDemo;

import org.jetbrains.annotations.NotNull;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerManipulatedMapper {

    @Mapping(target = "nameExtarctEmail", expression = "java(customer.getCustomerEmail().split(\"@\")[0])")
    @Mapping(target = "age", expression = "java(calculateAge(customer.getDob()))")
    CustomerDTO manipulatedcustomerTOCustomerDTO(Customer customer);

    @InheritInverseConfiguration
    Customer manipulatedCustomerDTOToCustomer(CustomerDTO customerDTO);

   /* default String manipulateCustomerEmail(String email) {
        if (email != null && email.contains("@")) {
            return email.split("@")[0];
        }
        return email;
    }*/

    default int calculateAge(LocalDate dob) {
        return (LocalDate.now().getYear() - dob.getYear());
    }

    List<CustomerDTO> manipulatedcustomersTOCustomerDTO(List<Customer> customers);
}


