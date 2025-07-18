package com.example.demo.myfirstapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;

    @BeforeEach
    void setup(){
        product = new Product(100L, "blo", 2500);
    }

    @Test
    void getId() {
        assertEquals(100L, product.getId());
    }

    @Test
    void getName() {
        assertEquals("blo", product.getName());
    }

    @Test
    void getPrice() {
        assertEquals(2500, product.getPrice());
    }

    @Test
    void setId() {
        product.setId(101L);
        assertEquals(101L, product.getId());
    }

    @Test
    void setName() {
        product.setName("barkada room");
        assertEquals("barkada room", product.getName());
    }

    @Test
    void setPrice() {
        product.setPrice(600);
        assertEquals(600, product.getPrice());
    }

    @Test
    void testToString() {
        Product product1 = new Product(003L, "hotdog", 12);
        assertEquals("Product{id=3, name='hotdog', price=12.0}", product1.toString());
    }

    @Test
    void testEquals() {
        assertTrue(product.equals(product));
    }

    @Test
    void testHashCode() {
        Product product2 = new Product(100L, "blo", 2500);
                assertEquals(product2.hashCode(), product.hashCode());
    }
}