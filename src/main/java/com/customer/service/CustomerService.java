package com.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Method to add a customer
    public Customer addCustomer(String id, String name, String city, List<String> subscribedServices) {
        // Initialize subscribedServices if it's null
        if (subscribedServices == null) {
            subscribedServices = new ArrayList<>();
        }

        Customer customer = new Customer(id, name, city, subscribedServices);
        return customerRepository.save(customer); // Save the customer to MongoDB
    }

    // Method to get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll(); // Retrieve all customers from MongoDB
    }

    // Method to get a customer by ID
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
