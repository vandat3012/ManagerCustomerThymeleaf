package com.example.managercustomer.model.service;

import com.example.managercustomer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save (Customer customer);
    void update (Customer customer,int id);
    void remove (int id);

}
