package com.customer.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// The Lombok @Data annotation automatically generates getters, setters, and other utility methods.
@Document(collection = "Customer")
public class Customer {

    @Id
    private String id;
    private String name;
    private String city;
    private List<String> subscribedServices = new ArrayList<>(); // Initialize as an empty ArrayList by default

    // Constructor with parameters
    public Customer(String id, String name, String city, List<String> subscribedServices) {
        this.id = id;
        this.name = name;
        this.city = city;
        if (subscribedServices != null) {
            this.subscribedServices = subscribedServices;
        } else {
            this.subscribedServices = new ArrayList<>(); // Ensure it's initialized as an empty list
        }
    }

    // No-arg constructor (required by MongoDB)
    public Customer() {
        this.subscribedServices = new ArrayList<>(); // Initialize to empty list by default
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getSubscribedServices() {
        return subscribedServices;
    }

    public void setSubscribedServices(List<String> subscribedServices) {
        this.subscribedServices = subscribedServices;
    }
}
