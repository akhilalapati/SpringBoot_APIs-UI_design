package com.example.mapperDemo;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/home")
    public String homePage(){
        return "Welcome to Customers";
    }

    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer customer){
        System.out.println("adding customer\n" + customer);
        customerService.addCustomer(customer);
    }

    @GetMapping("/Manualcustomers")
    public List<CustomerDTO> getCustomers() {
        Random random = new Random();
        int randomInt = random.nextInt(10);
        if(randomInt%2 == 0) {
            List<CustomerDTO> list = new ArrayList<>();
            list.add(new CustomerDTO(1L, "cust1", "cust1@gmail.com"));
            list.add(new CustomerDTO(2L, "cust2", "cust2@gmail.com"));
            list.add(new CustomerDTO(3L, "cust3", "cust3@gmail.com"));
            return list;
        }
        else{
           return Arrays.asList(new CustomerDTO(1L, "cust1Else", "cust1Else@gmail.com"), //cust1Else-cust1Else
                                new CustomerDTO(2L, "cust2Else", "cust2Else@gmail.com"),
                                new CustomerDTO(3L, "cust3Else", "cust3Else@gmail.com"));
        }

    }

    @GetMapping("/DBcustomers")
    public List<Customer> getDBCustomers() {
        return customerService.getDBCustomers();
    }

    @GetMapping("/Mapper/customer/{id}")
    public CustomerDTO getMapperCustomer(@PathVariable Long id){
        return customerService.getMapperCustomer(id);
    }

    @GetMapping("/Mapper/customers")
    public List<CustomerDTO> getAllMapperCustomers() {
        System.out.println("Mapper Customers");
        return customerService.getAllMapperCustomers();
    }

    @GetMapping("/Mapper/ManipulatedMapper/customer/{id}")
    public CustomerDTO getManipulatedMapper(@PathVariable Long id) {
        return customerService.getManipulatedMapper(id);
    }
}
