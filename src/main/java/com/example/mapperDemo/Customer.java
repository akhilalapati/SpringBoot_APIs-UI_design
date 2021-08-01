package com.example.mapperDemo;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;

    private String customerEmail;

    private String phoneNumber;

    private String whatsAppNumber;

    private String city;

    private LocalDate dob;

    public Customer(String customerName, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public Customer(){}

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customer_id) {
        this.customerId = customer_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customer_name) {
        this.customerName = customer_name;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customer_email) {
        this.customerEmail = customer_email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWhatsAppNumber() {
        return whatsAppNumber;
    }

    public void setWhatsAppNumber(String whatsAppNumber) {
        this.whatsAppNumber = whatsAppNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDob(LocalDate dob){
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customerId +
                ", customer_name='" + customerName + '\'' +
                ", customer_email='" + customerEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", whatsAppNumber='" + whatsAppNumber + '\'' +
                ", city='" + city + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
