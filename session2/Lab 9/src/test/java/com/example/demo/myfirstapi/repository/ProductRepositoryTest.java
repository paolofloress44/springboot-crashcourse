package com.example.demo.myfirstapi.repository;

import com.example.demo.myfirstapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;
class ProductRepositoryTest {
    public List<Product> products = Collections.synchronizedList(new ArrayList<>());
    public AtomicLong nextId = new AtomicLong(1);
    ProductRepository productRepository;

    @BeforeEach
    void setup(){
        productRepository = new ProductRepository();
        products.add(new Product(nextId.getAndIncrement(), "Laptop", 1200.00));
        products.add(new Product(nextId.getAndIncrement(), "Mouse", 25.50));
        products.add(new Product(nextId.getAndIncrement(), "Keyboard", 75.00));
    }

    @Test
    void findAll() {
        assertEquals(productRepository.findAll(), products);
    }

    @Test
    void findById() {
        assertEquals(products.getFirst().hashCode(), productRepository.findById(1L).hashCode());
    }

    @Test
    void save() {
        Product product = new Product("Headphone", 5.00);
        productRepository.save(product);
        assertEquals(product.hashCode(),productRepository.findById(4L).hashCode());
    }
}