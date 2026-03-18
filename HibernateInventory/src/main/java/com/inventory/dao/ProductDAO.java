package com.inventory.dao;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import com.inventory.entity.Product;

@Repository
@Transactional
public class ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // CREATE
    public void saveProduct(Product product) {
        entityManager.persist(product);
        System.out.println("Product saved: " + product.getName());
    }

    // READ
    public Product getProduct(int id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            System.out.println("Found: " + product.getName() + " | Price: " + product.getPrice());
        } else {
            System.out.println("Product not found!");
        }
        return product;
    }

    // UPDATE
    public void updateProduct(int id, double price, int quantity) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            product.setPrice(price);
            product.setQuantity(quantity);
            entityManager.merge(product);
            System.out.println("Product updated: " + product.getName());
        }
    }

    // DELETE
    public void deleteProduct(int id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
            System.out.println("Product deleted: " + product.getName());
        }
    }
}