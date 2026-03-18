package com.inventory.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;

@SpringBootApplication
@ComponentScan(basePackages = "com.inventory")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner run(ProductDAO dao) {
        return args -> {

            // CREATE
            Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 10);
            Product p2 = new Product("Mouse", "Wireless Mouse", 1200, 50);
            dao.saveProduct(p1);
            dao.saveProduct(p2);

            // READ
            dao.getProduct(1);

            // UPDATE
            dao.updateProduct(1, 72000, 8);

            // DELETE
            dao.deleteProduct(2);
        };
    }
}