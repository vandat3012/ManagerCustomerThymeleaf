package com.example.managercustomer.model.service;

import com.example.managercustomer.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static final Map<Integer,Customer> customers = new HashMap<>();
    static {
        customers.put(1,new Customer(1,"dat","dat@","HT"));
        customers.put(2,new Customer(2,"nhat","nhat@","QT"));
        customers.put(3,new Customer(3,"phap","phap@","QT"));
        customers.put(4,new Customer(4,"dung","dung@","DN"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public void update(Customer customer, int id) {
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
