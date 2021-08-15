package com.example.mapperDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRespository customerRespository;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerManipulatedMapper customerManipulatedMapper;

    Random random = new Random();
    int bound10Int = random.nextInt(10);

    private boolean manipulatedMapper = (bound10Int%2 == 0);

    public void addCustomer(Customer customer) {
        customerRespository.save(customer);
    }

    public List<Customer> getDBCustomers() {
        return customerRespository.findAll();
    }

    public CustomerDTO getMapperCustomer(Long id) {
        Customer customer = customerRespository.findById(id).orElse(new Customer("addCustomerName", "addCustomerEmail")); //Customer customer = customerRespository.getById(id); //using getById , can use findById but giving an error
        if (!manipulatedMapper) {
            return customerMapper.customerTOCustomerDTO(customer);
        }
        return customerManipulatedMapper.manipulatedcustomerTOCustomerDTO(customer);
    }

    public List<CustomerDTO> getAllMapperCustomers() {
        List<Customer> customers = customerRespository.findAll();
        if (!manipulatedMapper) {
            return customerMapper.customersToCustomerDTOs(customers);
        }
        return customerManipulatedMapper.manipulatedcustomersTOCustomerDTO(customers);
    }

    public CustomerDTO getManipulatedMapper(Long id) {
        Customer customer = customerRespository.findById(id).orElse(new Customer("addName", "addEmail"));
        if (false) {
            return customerMapper.customerTOCustomerDTO(customer);
        }
        return customerManipulatedMapper.manipulatedcustomerTOCustomerDTO(customer);
    }
}
