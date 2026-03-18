package com.inventory;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;

@SpringBootApplication
@ComponentScan(basePackages = "com.inventory")
@EntityScan(basePackages = "com.inventory.entity")
public class HibernateInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateInventoryApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ProductDAO dao) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            System.out.println("\n========== INVENTORY MANAGEMENT ==========\n");

            while (running) {
                System.out.println("1. Create Product");
                System.out.println("2. Read Product");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        // CREATE
                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        Product product = new Product(name, description, price, quantity);
                        dao.saveProduct(product);
                        break;

                    case 2:
                        // READ
                        System.out.print("Enter product ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        dao.getProduct(id);
                        break;

                    case 3:
                        // UPDATE
                        System.out.print("Enter product ID: ");
                        int updateId = scanner.nextInt();
                        System.out.print("Enter new price: ");
                        double newPrice = scanner.nextDouble();
                        System.out.print("Enter new quantity: ");
                        int newQuantity = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        dao.updateProduct(updateId, newPrice, newQuantity);
                        break;

                    case 4:
                        // DELETE
                        System.out.print("Enter product ID: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        dao.deleteProduct(deleteId);
                        break;

                    case 5:
                        // EXIT
                        running = false;
                        System.out.println("Exiting... Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.\n");
                }
            }

            scanner.close();
        };
    }
}