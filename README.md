Here's the README rewritten in different words:

Inventory Management System with Hibernate
A Spring Boot-based application that handles product inventory operations using Hibernate ORM backed by an H2 in-memory database.
📋 What It Does

Add Products – Register new items into the inventory
View Products – Look up item details using their ID
Modify Products – Update pricing and stock levels
Remove Products – Delete items from the system
H2 Console – Inspect the database through a browser interface
Interactive Menu – Navigate features via a command-line prompt

🛠️ Tech Stack

Java 21 – Core language
Spring Boot 3.5.11 – Application framework
Hibernate 6.6.42 – Object-relational mapping
H2 Database – Lightweight in-memory database
Maven – Dependency and build management
JPA – Java Persistence API

📦 Folder Layout
HibernateInventory/
├── src/
│   ├── main/
│   │   ├── java/com/inventory/
│   │   │   ├── HibernateInventoryApplication.java  (Application entry point)
│   │   │   ├── dao/
│   │   │   │   └── ProductDAO.java                 (Data access logic)
│   │   │   └── entity/
│   │   │       └── Product.java                    (Data model)
│   │   └── resources/
│   │       └── application.properties              (App configuration)
│   └── test/
│       └── java/com/inventory/HibernateInventory/
│           └── HibernateInventoryApplicationTests.java
├── pom.xml                                        (Maven config)
└── README.md                                      (Documentation)
🚀 Setup & Installation
Requirements

Java 21 (JDK)
Maven 3.6 or above

Steps

Go to the project folder:

bashcd HibernateInventory

Build the project:

bashmvn clean install
Launch the App
bashmvn spring-boot:run
```

Once started, you'll see:
```
========== INVENTORY MANAGEMENT ==========
1. Create Product
2. Read Product
3. Update Product
4. Delete Product
5. Exit
Enter your choice:
```

## 📝 Sample Interactions

### Adding a Product
```
Enter your choice: 1
Enter product name: Keyboard
Enter description: Mechanical Keyboard
Enter price: 5000
Enter quantity: 20
→ Product saved: Keyboard
```

### Fetching a Product
```
Enter your choice: 2
Enter product ID: 1
→ Found: Keyboard
```

### Editing a Product
```
Enter your choice: 3
Enter product ID: 1
Enter new price: 4500
Enter new quantity: 15
→ Product updated: Keyboard
```

### Removing a Product
```
Enter your choice: 4
Enter product ID: 1
→ Product deleted: Keyboard
```

## 🗄️ Database Setup

Configured in `application.properties`:
- **Type**: H2 (In-memory)
- **URL**: `jdbc:h2:mem:inventory_db`
- **Username**: `sa`
- **Password**: `password`
- **DDL Mode**: `update` (tables are auto-created on startup)

### Accessing the Web Console

While the app is running, visit:
```
http://localhost:8080/h2-console
Credentials:

JDBC URL: jdbc:h2:mem:inventory_db
User: sa
Password: password

To view all records:
sqlSELECT * FROM products;
🧪 Running Tests
bashmvn test
📄 Data Model
Product Fields
FieldTypeDescriptionidIntegerAuto-generated primary keynameStringName of the productdescriptionStringBrief product descriptionpriceDoubleListed pricequantityIntegerUnits available in stock
Sample Record
json{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 75000,
  "quantity": 10
}
```

## 🔍 Operation Details

### Add
Creates a new inventory entry with an auto-assigned ID.

### View
Looks up and displays a product by its ID, or shows a "not found" message.

### Edit
Updates the price and stock count for a given product ID.

### Remove
Permanently deletes the product associated with the provided ID.

## 📊 Sample Console Output
```
Started HibernateInventoryApplication in 2.061 seconds
Product saved: Laptop
Product saved: Mouse
Found: Laptop
Product updated: Laptop
Product deleted: Mouse
BUILD SUCCESS
🐛 Common Issues
"Access denied for user 'root'"
This app runs on H2, not MySQL — no external database configuration is needed.
"Unable to locate persister"
Make sure the @EntityScan annotation points to the correct package.
Build fails
Try running mvn clean install to do a fresh build.
📝 Things to Keep in Mind

H2 is an in-memory database — all data is wiped when the application stops
To retain data across sessions, migrate to MySQL or PostgreSQL
Tables are created automatically when the app starts up
