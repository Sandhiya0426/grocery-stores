package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Groceryshop;
import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCart;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.GroceryshopRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryshopService {

    private final CustomerRepository customerRepository;
    private final GroceryshopRepository groceryshopRepository;
    private final ProductRepository productRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public GroceryshopService(CustomerRepository customerRepository, GroceryshopRepository groceryshopRepository,
                              ProductRepository productRepository, ShoppingCartRepository shoppingCartRepository) {
        this.customerRepository = customerRepository;
        this.groceryshopRepository = groceryshopRepository;
        this.productRepository = productRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    // Customer operations
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    // Groceryshop operations
    public List<Groceryshop> getAllGroceryshops() {
        return groceryshopRepository.findAll();
    }

    public Optional<Groceryshop> getGroceryshopById(Long id) {
        return groceryshopRepository.findById(id);
    }

    public void saveGroceryshop(Groceryshop groceryshop) {
        groceryshopRepository.save(groceryshop);
    }

    public void deleteGroceryshopById(Long id) {
        groceryshopRepository.deleteById(id);
    }

    // Product operations
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    // ShoppingCart operations
    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    public Optional<ShoppingCart> getShoppingCartById(Long id) {
        return shoppingCartRepository.findById(id);
    }

    public void saveShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    public void deleteShoppingCartById(Long id) {
        shoppingCartRepository.deleteById(id);
    }
    public List<Groceryshop> getAllGroceryshopsSortedByField(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return groceryshopRepository.findAll(sort);
    }

    public List<Groceryshop> getGroceryshopsPage(int offset, int pageSize) {
        PageRequest page = PageRequest.of(offset, pageSize);
        return groceryshopRepository.findAll(page).getContent();
    }

    public List<Groceryshop> getGroceryshopsPageSortedByField(int offset, int pageSize, String field) {
        return groceryshopRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC, field))).getContent();
    }

}
