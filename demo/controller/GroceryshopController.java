package com.example.demo.controller;

import com.example.demo.model.Groceryshop;
import com.example.demo.model.Customer;
import com.example.demo.model.ShoppingCart;
import com.example.demo.model.Product;
import com.example.demo.service.GroceryshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grocery-shops")
public class GroceryshopController {

    private final GroceryshopService groceryshopService;

    @Autowired
    public GroceryshopController(GroceryshopService groceryshopService) {
        this.groceryshopService = groceryshopService;
    }

    @GetMapping("/getAll")
    public List<Groceryshop> getAllGroceryshops() {
        return groceryshopService.getAllGroceryshops();
    }

    @GetMapping("/{id}")
    public Optional<Groceryshop> getGroceryshopById(@PathVariable Long id) {
        return groceryshopService.getGroceryshopById(id);
    }

    @PostMapping("/add")
    public void addGroceryshop(@RequestBody Groceryshop groceryshop) {
        groceryshopService.saveGroceryshop(groceryshop);
    }

    @PutMapping("/{id}")
    public void updateGroceryshop(@PathVariable Long id, @RequestBody Groceryshop groceryshop) {
        if (groceryshop.getId() == null || !groceryshop.getId().equals(id)) {
            throw new IllegalArgumentException("ID in path and ID in body do not match");
        }
        groceryshopService.saveGroceryshop(groceryshop);
    }

    @DeleteMapping("/{id}")
    public void deleteGroceryshopById(@PathVariable Long id) {
        groceryshopService.deleteGroceryshopById(id);
    }

    @GetMapping("/api/children/sortBy/{field}")
    public ResponseEntity<?> getchild(@PathVariable String field) {
        try {
            // Implement your logic here to get children sorted by the specified field
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/children/{offset}/{pagesize}")
    public ResponseEntity<?> gettchild(@PathVariable int offset, @PathVariable int pagesize) {
        try {
            // Implement your logic here to get children with pagination
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<?> getttchild(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field) {
        try {
            // Implement your logic here to get children with pagination and sorting
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
