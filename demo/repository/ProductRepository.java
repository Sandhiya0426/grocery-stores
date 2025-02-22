package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query to find products by price using @Query annotation
    @Query("SELECT p FROM Product p WHERE p.price = :price")
    List<Product> findByPrice(double price);
}
