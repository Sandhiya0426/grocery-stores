package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom query to find a customer by their name
    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    Customer findByName(String name);
}
