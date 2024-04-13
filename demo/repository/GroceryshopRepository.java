package com.example.demo.repository;

import com.example.demo.model.Groceryshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryshopRepository extends JpaRepository<Groceryshop, Long> {

    // Add custom query methods if needed
}
